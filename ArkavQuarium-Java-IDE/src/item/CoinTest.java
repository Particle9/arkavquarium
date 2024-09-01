package item;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import item.Coin;
import linkList.*;
import point.*;

public class CoinTest {
	@Test
	void testCoinCtor() {
		Coin c = new Coin();
		assertTrue(c.getPoint().equals(new Point(0,0)));
		assertTrue(c.value == 100);
		assertTrue(c.cointype == 1);
		int firstSize = Coin.getActiveCoins().size();
		c = new Coin(150,new Point(100,500),2);
		assertTrue(c.getPoint().equals(new Point(100,500)));
		assertTrue(c.value == 150);
		assertTrue(c.cointype == 2);
		assertTrue(Coin.getActiveCoins().size() > firstSize);
	}
	@Test
	void testRemoveFromList() {
		Coin c = new Coin(100,new Point(0,0),2);
		int len1 = Coin.getActiveCoins().size();
		c.removeFromList();
		assertTrue(Coin.getActiveCoins().size() < len1);
	}
	@Test
	void testDrown() {
		Coin c = new Coin(100,new Point(0,0),2);
		Point pp = new Point(c.getPoint().getX(), c.getPoint().getY());
		c.drown();
		assertTrue(c.getPoint().getY() > pp.getY());
		assertTrue(c.getPoint().getX() == pp.getX());
	}
	@Test
	void testAddCollectedCoin() {
		Coin c = new Coin(100, new Point(0,0),1);
		int firstCollCoin = Coin.CollectedCoin;
		c.addCollectedCoins();
		assertTrue(Coin.CollectedCoin > firstCollCoin);
	}
	@Test
	void testDecCollectedCoin() {
		int firstCollCoin = Coin.CollectedCoin;
		Coin.decCollectedCoin(100);
		assertTrue(Coin.CollectedCoin < firstCollCoin);
	}
	
	@Test
	void testDrownAll() {
		Coin c1 = new Coin(100, new Point(1,1),1);
		Coin c2 = new Coin(100, new Point(2,2),1);
		Coin c3 = new Coin(100, new Point(3,3),1);
		Point pp1 = new Point(c1.getPoint().getX(), c1.getPoint().getY());
		Point pp2 = new Point(c2.getPoint().getX(), c2.getPoint().getY());
		Point pp3 = new Point(c3.getPoint().getX(), c3.getPoint().getY());
		Coin.drownAll();
		assertTrue(c1.getPoint().getY() > pp1.getY());
		assertTrue(c1.getPoint().getX() == pp1.getX());
		assertTrue(c2.getPoint().getY() > pp2.getY());
		assertTrue(c2.getPoint().getX() == pp2.getX());
		assertTrue(c3.getPoint().getY() > pp3.getY());
		assertTrue(c3.getPoint().getX() == pp3.getX());
	}
}
