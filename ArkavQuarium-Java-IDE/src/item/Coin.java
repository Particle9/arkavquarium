package item;

import linkList.LinkList;
import point.Point;

public class Coin extends Item {
  protected static LinkList<Coin> listCoin = new LinkList<Coin>();
  protected static int CollectedCoin = 100000;
  protected int value;
  protected int cointype;

  /**
   * Default Constructor.
   */
  public Coin() {
    super(new Point(0, 0));
    value = 100;
    cointype = 1;
  }

  /**
   * User Defined Constructor.
   * @param val Value of the Coin
   * @param t Coin type
   */
  public Coin(int val, int t) {
    super(new Point(0, 0));
    value = val;
    cointype = t;
    listCoin.add(this);
  }

  /**
   * User Defined Constructor with Point.
   * @param val Value of the Coin
   * @param p position of the Coin as Point
   * @param t Coin Type
   */
  public Coin(int val, Point p, int t) {
    super(p);
    value = val;
    cointype = t;
    listCoin.add(this);
  }

  /**
   * Remove Coin from listCoin.
   */
  public void removeFromList() {
    listCoin.remove(this);
  }

  public static LinkList<Coin> getActiveCoins() {
    return (listCoin);
  }

  public int getValue() {
    return (value);
  }

  public void setValue(int v) {
    value = v;
  }

  @Override
  public void drown() {
    if (pos.getY() < max.getY()) {
      super.drown();
    }
  }

  public static int getCollectedCoins() {
    return (CollectedCoin);
  }

  public void addCollectedCoins() {
    CollectedCoin += value;
  }

  public static void decCollectedCoin(int val) {
    CollectedCoin -= val;
  }

  /**
   * Drown all Coin(s) in listCoin.
   */
  public static void drownAll() {
    int siz = listCoin.size();
    for (int i = 0; i < siz; i++) {
      listCoin.get(i).drown();
    }
  }

  public int getCoinType() {
    return cointype;
  }
}