package animal;

import item.Coin;
import linkList.LinkList;
import point.Point;
import thing.Thing;

public class Snail extends Thing implements Animal {
  protected boolean direction;
  protected int speed;

  public Snail() {
  }

  /**
   * User Defined Constructor.
   * 
   * @param dir
   *          Direction
   * @param posx
   *          Initial absis
   */
  public Snail(char dir, int posx) {
    super(new Point(posx, Thing.max.getY() - 100));
    direction = dir == 'R';
    speed = 2;
  }

  public boolean getDirection() {
    return (direction);
  }

  public int getSpeed() {
    return (speed);
  }

  public void setDirection(boolean b) {
    direction = b;
  }

  public void setSpeed(int s) {
    speed = s;
  }

  public void turn(char c) {
    direction = c == 'R';
  }

  public void move(int p) {
    move();
  }

  @Override
  public void move() {
    double x = pos.getX();
    if (!Coin.getActiveCoins().isEmpty()) {
      Coin targetCoin = searchFood();
      if (pos.getDistance(targetCoin.getPoint()) < 60) {
        eat(targetCoin);
      }
      if (pos.getX() > targetCoin.getPoint().getX()) {
        pos.setX(pos.getX() - speed);
      } else {
        pos.setX(pos.getX() + speed);
      }
      direction = x < pos.getX();
    }
  }

  Coin searchFood() {
    LinkList<Coin> listCoin;
    listCoin = Coin.getActiveCoins();
    Coin minFood = listCoin.get(0);
    double minDis;
    minDis = pos.getDistance(minFood.getPoint());
    if (listCoin.isOneElmt()) {
      return minFood;
    }
    int nsize = listCoin.size();
    for (int i = 1; i < nsize; i++) {
      Coin tempFood = listCoin.get(i);
      if (minDis > pos.getDistance(tempFood.getPoint())) {
        minDis = pos.getDistance(tempFood.getPoint());
        minFood = tempFood;
      }
    }
    return minFood;
  }

  public void eat(Coin foo) {
    foo.addCollectedCoins();
    foo.removeFromList();
  }
}