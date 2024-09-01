package animal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import item.Coin;
import linkList.*;
import point.*;

public class PiranhaTest {
	@Test
	void testPiranhaCtor() {
		Piranha p = new Piranha();
		assertTrue(p.getId() %1 == 0);
		Piranha p1 = new Piranha(new Point(0,0));
		assertTrue(p1.getId() == p.getId()+1);
		assertTrue(p1.getPoint().equals(new Point(0,0)));
		assertTrue(p1.getHealth() == Piranha.maxHealth[4]);
		assertTrue(p1.getLevel() == 4);
		assertTrue(p1.getFoodEaten() == 0);
		assertTrue(!p1.getHungerStat());
	}
	
	@Test
	void testRemoveFromList() {
		Piranha p = new Piranha(new Point(0,0));
		Piranha p1 = new Piranha(new Point(0,31));
		p = new Piranha(new Point(12,0));
		int len1 = Piranha.getListPiranha().size();
		p1.removeFromList();
		assertTrue(Piranha.getListPiranha().size() < len1);
	}
	
	@Test
	void testSearchFood() {
		Guppy g1 = new Guppy(new Point(0,1));
		Guppy g2 = new Guppy(new Point(9,9));
		Piranha p = new Piranha(new Point(0,0));
		assertTrue(p.searchFood() == g1);
	}
	
	@Test
	void testNormalMove() {
		Point p1 = new Point(3.5,5);
		Piranha p = new Piranha(p1);
		p.normalMove();
		assertFalse(p.getPoint().equals(p1));
	}
	
	@Test
	void testMove() {
		Point p1 = new Point(3.5,5);
		Piranha p = new Piranha(p1);
		p.move();
		assertFalse(p.getPoint().equals(p1));
	}
	
	@Test
	void testEat() {
		Guppy g1 = new Guppy(new Point(0,0));
		Guppy g2 = new Guppy(new Point(1,5));
		Piranha p = new Piranha(new Point(0,0));
		int size1 = Guppy.getListGuppy().size();
		p.eat(g1);
		assertTrue(Guppy.getListGuppy().size() == size1 - 1);
	}
	
	@Test
	void testDecreaseHealth() {
		Point p1 = new Point(9,4.5);
		Piranha p = new Piranha(p1);
		int health1 = p.getHealth();
		p.decreaseHealth();
		assertTrue(p.getHealth() < health1);
	}
	
	@Test
	void testProduceCoin() {
		Point p1 = new Point(3.5, 5);
	    Piranha p = new Piranha(p1);
	    int firstCoinSize = Coin.getActiveCoins().size();
	    p.produceCoin(100);
	    int secondCoinSize = Coin.getActiveCoins().size();
	    assertTrue(secondCoinSize > firstCoinSize);
	}
	
	@Test
	void testMoveAll() {
		Point p1 = new Point(3.5,5);
		Piranha p = new Piranha(p1);
		Piranha.moveAll();
		assertFalse(p.getPoint().equals(p1));
	}
}
