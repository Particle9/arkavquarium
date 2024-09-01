package animal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import item.Coin;
import item.Food;
import point.Point;

class GuppyTest {

  @Test
  void testConstructorWithNoParameter() {
    Guppy g = new Guppy();
    assertTrue(g.getId() % 1 == 0);
    assertTrue(g.getPoint().equals(new Point(0,0)));
    assertTrue(g.getHealth() == Guppy.maxHealth[1]);
    assertTrue(g.getLevel() == 1);
    assertTrue(g.getFoodEaten() == 0);
    assertTrue(g.getHungerStat() == false);
    assertTrue(g.getDirection() == true);
    assertTrue(g.getDirDegree() == 0);
    assertTrue(g.getGoldTimer() == 0);
  }
  
  @Test
  void testConstructorWithPointParameter() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    assertTrue(g.getId() % 1 == 0);
    assertTrue(g.getPoint().equals(new Point(3.5,5)));
    assertTrue(g.getHealth() == Guppy.maxHealth[1]);
    assertTrue(g.getLevel() == 1);
    assertTrue(g.getFoodEaten() == 0);
    assertTrue(g.getHungerStat() == false);
    assertTrue(g.getDirection() == true);
    assertTrue(g.getDirDegree() == 0);
    assertTrue(g.getGoldTimer() == 0);
  }

  @Test
  void testGetHealth() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    assertTrue(g.getHealth() == Guppy.maxHealth[1]);
  }
  
  @Test
  void testSetHealth() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    g.setHealth(Guppy.maxHealth[2]);
    assertTrue(g.getHealth() == Guppy.maxHealth[2]);
  }
  
  @Test
  void testGetLevel() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    assertTrue(g.getLevel() == 1);
  }

  @Test
  void testGetFoodEaten() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    assertTrue(g.getFoodEaten() == 0);
  }

  @Test
  void testGetHungerStat() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    assertTrue(g.getHungerStat() == false);
  }

  @Test
  void testGetDirection() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    assertTrue(g.getDirection() == true);
  }

  @Test
  void testGetDirDegree() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    assertTrue(g.getDirDegree() == 0);
  }

  @Test
  void testGetGoldTimer() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    assertTrue(g.getGoldTimer() == 0);
  }
  
  @Test
  void testSetLevel() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    g.setLevel(2);
    assertTrue(g.getLevel() == 2);
  }

  @Test
  void testSetFoodEaten() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    g.setFoodEaten(1);
    assertTrue(g.getFoodEaten() == 1);
  }

  @Test
  void testSetHungerStat() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    g.setHungerStat(true);
    assertTrue(g.getHungerStat() == true);
  }

  @Test
  void testSetDirection() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    g.setDirection();
    assertTrue(g.getDirection() == false);
  }

  @Test
  void testSetDirDegree() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    g.setDirDegree(34);
    assertTrue(g.getDirDegree() == 34);
  }

  @Test
  void testSetGoldTimer() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    assertTrue(g.getGoldTimer() == 0);
  }
  
  @Test
  void testGetListGuppy() {
    Point p = new Point(3.5, 5);
    new Guppy(p);
    int firstListGuppySize = Guppy.getListGuppy().size();
    new Guppy(p);
    int secondListGuppySize = Guppy.getListGuppy().size();
    assertTrue(secondListGuppySize == firstListGuppySize + 1);
  }

  @Test
  void testGetDefaultPrice() {
    assertTrue(Guppy.getDefaultPrice() == 1000);
  }
  
  @Test
  void testRemoveFromList() {
    Point p = new Point(3.5, 5);
    Guppy g = new Guppy(p);
    int firstListGuppySize = Guppy.getListGuppy().size();
    g.removeFromList();
    int secondListGuppySize = Guppy.getListGuppy().size();
    assertTrue(secondListGuppySize == firstListGuppySize - 1);
  }
  
  @Test
  void testSearchFood() {
    Point p1 = new Point(3.5, 5);
    Point p2 = new Point(200, 200);
    Point p3 = new Point(3, 4);
    Food f1 = new Food(p1);
    Food f2 = new Food(p2);
    Guppy g = new Guppy(p3);
    assertTrue(g.searchFood() == f1);
  }
  
  @Test
  void testNormalMove() {
    Point p1 = new Point(3.5, 5);
    Guppy g = new Guppy(p1);
    g.normalMove();
    assertFalse(g.getPoint().equals(p1));
  }
  
  @Test
  void testMove() {
    Point p1 = new Point(3.5, 5);
    Guppy g = new Guppy(p1);
    g.move();
    assertFalse(g.getPoint().equals(p1));
  }

  @Test
  void testMoveAll() {
    Point p1 = new Point(3.5, 5);
    Guppy g = new Guppy(p1);
    Guppy.moveAll();
    assertFalse(g.getPoint().equals(p1));
  }
  
  @Test
  void testEat() {
    Point p1 = new Point(3.5, 5);
    Guppy g = new Guppy(p1);
    Food f = new Food(p1);
    int firstFoodListSize = Food.getFoodList().size();
    g.eat(f);
    int secondFoodListSize = Food.getFoodList().size();
    assertTrue(secondFoodListSize < firstFoodListSize);
  }
  
  @Test
  void testDecreaseHealth() {
    Point p1 = new Point(3.5, 5);
    Guppy g = new Guppy(p1);
    int firstHealth = g.getHealth();
    g.decreaseHealth();
    int secondHealth = g.getHealth();
    assertTrue(secondHealth < firstHealth);
  }
  
  @Test
  void testProduceCoin() {
    Point p1 = new Point(3.5, 5);
    Guppy g = new Guppy(p1);
    int firstCoinSize = Coin.getActiveCoins().size();
    g.produceCoin(100);
    int secondCoinSize = Coin.getActiveCoins().size();
    assertTrue(secondCoinSize > firstCoinSize);
  }

}
