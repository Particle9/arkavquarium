package item;

import static org.junit.jupiter.api.Assertions.*;

import linkList.LinkList;
import org.junit.jupiter.api.Test;

import point.Point;

class FoodTest {

  @Test
  void testDrown() {
    LinkList<Food> listFood = Food.getFoodList();
    Food food1 = new Food(new Point(50, 40));
    food1.drown();
    assertEquals(40.1, food1.getPoint().getY());
    Food food2 = new Food(new Point(60, 500));
    assertEquals(2, listFood.size());
    food2.drown();
    assertEquals(1, listFood.size());
    
  }

  @Test
  void testFood() {
    Food food = new Food(new Point());
    assertEquals(0, food.getPoint().getX());
    assertEquals(0, food.getPoint().getY());
  }
  
  @Test
  void testFoodPoint() {
    Food food = new Food(new Point(4, 6));
    assertEquals(4, food.getPoint().getX());
    assertEquals(6, food.getPoint().getY());
  }

  @Test
  void testRemoveFromList() {
    Food.setFoodList(new LinkList<Food>());
    LinkList<Food> listFood = Food.getFoodList();
    
    Food food = new Food(new Point());
    
    assertEquals(1, listFood.size());
    food.removeFromList();
    assertEquals(0, listFood.size());
  }

  @Test
  void testGetFoodList() {
    Food.setFoodList(new LinkList<Food>());
    LinkList<Food> listFood = Food.getFoodList();
    assertEquals(0, listFood.size());
    new Food();
    new Food();
    assertEquals(2, listFood.size());
  }

  @Test
  void testDrownAll() {
    Food.setFoodList(new LinkList<Food>());
    LinkList<Food> listFood = Food.getFoodList();
    new Food();
    new Food(new Point(500, 500));
    assertEquals(2, listFood.size());
    Food.drownAll();
    assertEquals(0.1, listFood.get(0).getPoint().getY());
    assertEquals(1, listFood.size());
  }

}
