package animal;

import item.Coin;
import java.util.Random;
import linkList.LinkList;
import point.Point;
import thing.Thing;

public class Piranha extends Fish {
  protected static LinkList<Piranha> listLivingPiranha = new LinkList<Piranha>();
  protected static double speed = 1;
  public static LinkList<Piranha> removeCandidate = new LinkList<Piranha>();

  public Piranha() {
    super();
    level = 4;
  }

  public Piranha(Point npos) {
    super(4, npos, 'R', 0);
    listLivingPiranha.add(this);
  }

  public void removeFromList() {
    listLivingPiranha.remove(this);
  }

  /**
   * search nearest food.
   * 
   * @return nearest guppy
   */
  public Guppy searchFood() {
    LinkList<Guppy> listGuppy;
    listGuppy = Guppy.getListGuppy();
    Guppy minFood = listGuppy.get(0);
    double minDis = pos.getDistance(minFood.getPoint());
    if (listGuppy.isOneElmt()) {
      return minFood;
    }
    int nsize = listGuppy.size();
    for (int i = 1; i < nsize; i++) {
      Guppy tempFood = listGuppy.get(i);
      if (minDis > pos.getDistance(tempFood.getPoint())) {
        minDis = pos.getDistance(tempFood.getPoint());
        minFood = tempFood;
      }
    }
    return minFood;
  }

  public void normalMove() {
    normalMove(0);
  }

  /**
   * Move when piranha is not hungry.
   * 
   * @param dirDeg
   *          direction Degree
   */
  public void normalMove(int dirDeg) {
    if (health % 300 == 0) {
      dirDegree = (((new Random()).nextInt() % 360));
      dirDegree = dirDegree * 3.14159265 / 180;
    }
    if (pos.getX() < 40 || pos.getX() > (Thing.getMax().getX()) 
        || pos.getY() < 40
        || pos.getY() > (Thing.getMax().getY())) {
      dirDegree = (((new Random()).nextInt() % 360));
      dirDegree = dirDegree * 3.14159265 / 180;
    }
    pos.setX(pos.getX() - speed * Math.cos(dirDegree));
    pos.setY(pos.getY() - speed * Math.sin(dirDegree));
    double x = pos.getX();
    direction = x < pos.getX();
  }

  @Override
  public void move() {
    if (!hungerStat) {
      normalMove();
    } else {
      double x = pos.getX();
      Guppy targetGuppy;
      if (!Guppy.getListGuppy().isEmpty()) {
        targetGuppy = searchFood();
        if ((pos.getDistance(targetGuppy.getPoint())) < 20) {
          eat(targetGuppy);
        } else {
          Point p1 = pos;
          Point p2 = targetGuppy.getPoint();
          double angle = Math.atan2(p1.getY() - p2.getY(), p1.getX() - p2.getX());
          pos.setX(pos.getX() - speed * Math.cos(angle));
          pos.setY(pos.getY() - speed * Math.sin(angle));
          direction = x < pos.getX();
        }
      } else {
        normalMove();
      }
    }
    decreaseHealth();
  }
  
  /**
   * Eats Guppy.
   * @param food food as Guppy
   */
  public void eat(Guppy food) {
    health = getMaxHealth();
    foodEaten++;
    hungerStat = false;
    produceCoin(price[food.level] * 10 / 5);
    Guppy.listLivingGuppy.remove(food);
  }

  /**
   * Decrease health by 2.
   */
  public void decreaseHealth() {
    if (health < 1) {
      removeCandidate.add(this);
    } else if (health < hungerPercent * getMaxHealth()) {
      health -= 2;
      hungerStat = true;
    } else {
      health -= 2;
      hungerStat = false;
    }
  }

  public int getPrice() {
    return (super.getPrice() * 10);
  }

  public void produceCoin(int price) {
    new Coin(price, pos, 4);
  }

  public static LinkList<Piranha> getListPiranha() {
    return listLivingPiranha;
  }

  public static int getDefaultPrice() {
    return (Fish.getDefaultPrice() * 10);
  }

  /**
   * Move all piranha inside listLivingPiranha.
   */
  public static void moveAll() {
    int siz = listLivingPiranha.size();
    for (int i = 0; i < siz; i++) {
      listLivingPiranha.get(i).move();
    }
    for (int i = 0; i < removeCandidate.size(); i++) {
      listLivingPiranha.remove(removeCandidate.get(i));
    }
    removeCandidate.removeAll();
  }
}