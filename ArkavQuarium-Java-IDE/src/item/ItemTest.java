package item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import point.Point;
import thing.Thing;

class ItemTest {

  @Test
  void testItem() {
    Item item = new Item();
    assertEquals(item.getPoint().getX(), 0);
    assertEquals(item.getPoint().getY(), 0);
    assertEquals(item.getId(), Thing.getIdList() - 1);
  }

  @Test
  void testItemPoint() {
    Item item = new Item(new Point(5, 10));
    assertEquals(item.getPoint().getX(), 5);
    assertEquals(item.getPoint().getY(), 10);
    assertEquals(item.getId(), Thing.getIdList() - 1);
  }

  @Test
  void testGetDrownSpeed() {
    assertEquals(Item.getDrownSpeed(), 1);
  }

  @Test
  void testDrown() {
    Item item = new Item(new Point(10, 20));
    item.drown();
    assertEquals(item.getPoint().getY(), 21);
  }

}
