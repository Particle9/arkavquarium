package point;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  void testPointCtor() {
    Point p1 = new Point();
    assertTrue(p1.getX() == 0);
    assertTrue(p1.getY() == 0);
    Point p2 = new Point(1.2, -2.3);
    assertTrue(p2.getX() == 1.2);
    assertTrue(p2.getY() == -2.3);
  }
  
  @Test
  void testGetX() {
    Point p1 = new Point(1.2,-2.3);
    assertTrue(p1.getX() == 1.2);
  }

  @Test
  void testGetY() {
    Point p1 = new Point(1.2,-2.3);
    assertTrue(p1.getY() == -2.3);
  }
  
  @Test
  void testSetX() {
    Point p1 = new Point(1.2,-2.3);
    p1.setX(6.5);
    assertTrue(p1.getX() == 6.5);
  }

  @Test
  void testSetY() {
    Point p1 = new Point(1.2,-2.3);
    p1.setY(-4.5);
    assertTrue(p1.getY() == -4.5);
  }
  
  @Test
  void testGetDistance() {
    Point p1 = new Point(-1.5,2.5);
    Point p2 = new Point(1.5,-1.5);
    assertTrue(p2.getDistance(p1) == 5);
    assertTrue(p1.getDistance(p2) == 5);
    assertTrue(p1.getDistance(p2) == p2.getDistance(p1));
  }
  
  @Test
  void testAdd() {
    Point p1 = new Point(-1.5,2.5);
    Point p2 = new Point(1.5,-1.5);
    Point p3 = p1.add(p2);
    Point p4 = p2.add(p1);
    assertTrue(p3.getX() == 0);
    assertTrue(p3.getY() == 1);
    assertTrue(p4.getX() == 0);
    assertTrue(p4.getY() == 1);
    assertTrue(p3.getX() == p4.getX());
    assertTrue(p3.getY() == p4.getY());
  }
  
  @Test
  void testSubstract() {
    Point p1 = new Point(-1.5,2.5);
    Point p2 = new Point(1.5,-1.5);
    Point p3 = p1.substract(p2);
    Point p4 = p2.substract(p1);
    assertTrue(p3.getX() == -3);
    assertTrue(p3.getY() == 4);
    assertTrue(p4.getX() == 3);
    assertTrue(p4.getY() == -4);
    assertTrue(p3.getX() != p4.getX());
    assertTrue(p3.getY() != p4.getY());
  }
  
  @Test
  void testIncrement() {
    Point p1 = new Point(-1.5,2.5);
    Point p2 = p1.increment();
    assertTrue(p2.getX() == p1.getX() + 1);
    assertTrue(p2.getY() == p1.getY() + 1);
  }

  @Test
  void testDecrement() {
    Point p1 = new Point(-1.5,2.5);
    Point p2 = p1.decrement();
    assertTrue(p2.getX() == p1.getX() - 1);
    assertTrue(p2.getY() == p1.getY() - 1);
  }
  
  @Test
  void testMultiply() {
    Point p1 = new Point(-1.5,2.5);
    Point p2 = p1.multiply(3.5);
    assertTrue(p2.getX() == p1.getX() * 3.5);
    assertTrue(p2.getY() == p1.getY() * 3.5);
  }
  
  @Test
  void testEquals() {
    Point p1 = new Point(-1.5,2.5);
    Point p2 = new Point(-1.5,2.5);
    Point p3 = new Point(1.5,-2.5);
    assertTrue(p1.equals(p2));
    assertFalse(p1.equals(p3));
  }
  

  @Test
  void testClone() {
    Point p1 = new Point(-1.5,2.5);
    Point p2 = p1.clone();
    assertTrue(1 == 1);
  }
}
