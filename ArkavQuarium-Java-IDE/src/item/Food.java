package item;

import linkList.LinkList;
import point.Point;

/**
 * FishFood.
 */
public class Food extends Item {
  protected static LinkList<Food> listFood = new LinkList<Food>();
  protected static LinkList<Food> removeCandidate = new LinkList<Food>();
  protected static int foodPrice = 10;
  
  public Food() {
    super(new Point());
    listFood.add(this);
  }
  
  public Food(Point p) {
    super(p);
    listFood.add(this);
  }

  public void removeFromList() {
    listFood.remove(this);
  }

  public static LinkList<Food> getFoodList() {
    return (listFood);
  }
  
  public static void setFoodList(LinkList<Food> listFood) {
    Food.listFood = listFood;
  }

  /** 
   * Override item.Item.drown().
   */
  public void drown() {
    if (pos.getY() < max.getY()) {
      super.drown();
    } else {
      removeCandidate.add(this);
    }
  }
  
  /**
 * Call Item.drown() for each Food in listFood
 */
  public static void drownAll() {
    int siz = listFood.size();
    for (int i = 0; i < siz; i++) {
      listFood.get(i).drown();
    }
    for (int i = 0; i < removeCandidate.size(); i++) {
      listFood.remove(removeCandidate.get(i));
    }
    removeCandidate.removeAll();
  }
  
  public static int getFoodPrice()  {
    return foodPrice;
  }
}