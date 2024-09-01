package thing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import point.Point;

class ThingTest {
  
  @Test
  void testConstructorWithNoParameter() {
    Thing t1 = new Thing();
    Thing t2 = new Thing();
    assertTrue(t1.id != t2.id);
    assertTrue(t1.pos.equals(t2.pos));
    assertTrue(t1.id + 1 == t2.id);
  }
  
  @Test
  void testGetPoint() {
    Point p1 = new Point(3,4);
    Thing t1 = new Thing(p1);
    assertTrue(t1.getPoint().equals(p1));
  }

  @Test
  void testGetId() {
    Point p1 = new Point(3,4);
    Thing t1 = new Thing(p1);
    assertTrue(t1.getId() % 1 == 0);
  }
  
  @Test
  void testSetPoint() {
    Point p1 = new Point(3,4);
    Point p2 = new Point(2,4);
    Thing t1 = new Thing(p1);
    t1.setPoint(p2);
    assertFalse(t1.getPoint().equals(p1));
    assertTrue(t1.getPoint().equals(p2));
  }
  
  @Test
  void testGetBatas() {
    Point p1 = new Point(3,4);
    Thing t1 = new Thing(p1);
    Point maxTester = new Point(500,500);
    assertTrue(t1.getMax().equals(maxTester));
  }
  
  @Test
  void testSetMaxPoint() {
    Point p1 = new Point(3,4);
    Thing t1 = new Thing(p1);
    Point maxTester = new Point(23,23);
    t1.setMax(maxTester);
    assertTrue(t1.getMax().equals(maxTester));
  }
  

}
