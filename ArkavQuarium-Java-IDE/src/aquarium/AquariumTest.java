package aquarium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import animal.Guppy;
import animal.Piranha;
import thing.Thing;

class AquariumTest {

  @Test
  void testAquariumCons() {
    Aquarium a = new Aquarium();
    assertTrue(a.snail.getPoint().getX() == 250);
    assertTrue(a.snail.getDirection() == true);
    assertTrue(a.cursor.getPoint().getX() == 250);
    assertTrue(a.cursor.getPoint().getY() == 250);
    assertTrue(Thing.getMax().getX() == 500);
    assertTrue(Thing.getMax().getY() == 500);
    assertTrue(Guppy.getListGuppy().size() == 1);
    assertTrue(Piranha.getListPiranha().size() == 1);
    assertTrue(a.getEggState() == 0);
  }
   
   @Test
   void testIncreaseEgg() {
     Aquarium a = new Aquarium();
     a.increaseEggState();
     assertTrue(a.getEggState() == 1);
   }
}
