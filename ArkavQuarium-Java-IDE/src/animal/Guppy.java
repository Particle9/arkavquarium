package animal;

import item.Coin;
import item.Food;
import java.lang.Math;
import java.util.Random;
import linkList.LinkList;
import point.Point;
import thing.Thing;

public class Guppy extends Fish {
  protected static LinkList<Guppy> listLivingGuppy = new LinkList<Guppy>();
  protected static double speed = 0.5;
  protected int goldTimer;
  public static LinkList<Guppy> removeCandidate = new LinkList<Guppy>();

  /**
   * Default Guppy Constructor.
   */
  public Guppy() {
    super();
    listLivingGuppy.add(this);
    level = 1;
    goldTimer = 0;
  }

  /**
   * Constructor Guppy.
   * 
   * @param npos
   *          position
   */
  public Guppy(Point npos) {
    super(npos);
    listLivingGuppy.add(this);
    level = 1;
    goldTimer = 0;
  }

  /**
   * goldTimer getter.
   * 
   * @return goldTimer
   */
  public int getGoldTimer() {
    return goldTimer;
  }

  /**
   * goldTimer setter.
   * 
   * @param g
   *          goldTimer
   */
  public void setGoldTimer(int g) {
    goldTimer = g;
  }

  /**
   * listLivingGuppy getter.
   * 
   * @return listLivingGuppy
   */
  public static LinkList<Guppy> getListGuppy() {
    return listLivingGuppy;
  }

  /**
   * defaultPrice getter.
   * 
   * @return defaultPrice
   */
  public static int getDefaultPrice() {
    return (Fish.getDefaultPrice() * 10);
  }

  /**
   * Remove Guppy from listLivingGuppy.
   */
  public void removeFromList() {
    listLivingGuppy.remove(this);
  }

  /**
   * Find the closest food from Guppy.
   * 
   * @return Closest food
   */
  public Food searchFood() {
    LinkList<Food> listFood;
    listFood = Food.getFoodList();
    Food minFood = listFood.get(0);
    double minDistance = pos.getDistance(minFood.getPoint());
    if (listFood.isOneElmt()) {
      return minFood;
    }
    int nsize = listFood.size();
    for (int i = 1; i < nsize; i++) {
      Food tempFood = listFood.get(i);
      if (minDistance > pos.getDistance(tempFood.getPoint())) {
        minDistance = pos.getDistance(tempFood.getPoint());
        minFood = tempFood;
      }
    }
    return minFood;
  }

  /**
   * Move Guppy normally.
   */
  public void normalMove() {
    Random rand = new Random();
    double x;
    x = pos.getX();
    if (health % 75 == 0) {
      dirDegree = rand.nextInt(360);
      dirDegree = dirDegree * 3.14159265 / 180;
    }
    boolean xoutRange = (pos.getX() < 40 || pos.getX() > (Thing.getMax().getX()));
    boolean youtRange = (pos.getY() < 40 || pos.getY() > (Thing.getMax().getY()));
    if (xoutRange || youtRange) {
      dirDegree = rand.nextInt(360);
      dirDegree = dirDegree * 3.14159265 / 180;
    }
    pos.setX(pos.getX() - speed * Math.cos(dirDegree));
    pos.setY(pos.getY() - speed * Math.sin(dirDegree));
    direction = x < pos.getX();
  }

  @Override
  public void move() {
    if (!hungerStat) {
      normalMove();
    } else {
      double x = pos.getX();
      Food targetFood;
      if (!Food.getFoodList().isEmpty()) {
        targetFood = searchFood();
        if (pos.getDistance(targetFood.getPoint()) < 20) {
          eat(targetFood);
        } else {
          Point p1 = pos;
          Point p2 = targetFood.getPoint();
          double angle = Math.atan2(p1.getY() - p2.getY(), p1.getX() - p2.getX());
          pos.setX(pos.getX() - speed * Math.cos(angle));
          pos.setY(pos.getY() - speed * Math.sin(angle));
          direction = x < pos.getX();
        }
      } else {
        normalMove();
      }
    }
    goldTimer = (goldTimer + 1) % 500;
    decreaseHealth();
    if (goldTimer == 0) {
      produceCoin(getPrice() / 5);
    }
  }

  /**
   * Move all Guppy in listLivingGuppy.
   */
  public static void moveAll() {
    int listSize = listLivingGuppy.size();
    for (int i = 0; i < listSize; i++) {
      listLivingGuppy.get(i).move();
    }
    for (int i = 0; i < removeCandidate.size(); i++) {
      listLivingGuppy.remove(removeCandidate.get(i));
    }
    removeCandidate.removeAll();
  }

  /**
   * eat food.
   * 
   * @param food
   *          = food
   */
  public void eat(Food food) {
    food.removeFromList();
    health = getMaxHealth();
    ++foodEaten;
    if (foodEaten > foodRequired[level]) {
      foodEaten = 0;
      if (level < 3) {
        ++level;
      }
    }
    hungerStat = false;
  }

  /**
   * decrease Health.
   */
  public void decreaseHealth() {
    if (health < 1) {
      removeCandidate.add(this);
    } else if (health < hungerPercent * getMaxHealth()) {
      health -= 1;
      hungerStat = true;
    } else {
      health -= 1;
      hungerStat = false;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see animal.Fish#produceCoin(int)
   */
  public void produceCoin(int price) {
    new Coin(price, pos, level);
  }

}