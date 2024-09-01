package animal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import item.Coin;
import linkList.*;
import point.*;

public class SnailTest {
	@Test
	void testSnailCtor() {
		Snail s = new Snail('R',10);
		assertTrue(s.direction);
		assertTrue(s.speed == 2);
	}
	
	@Test
	void testTurn() {
		Snail s = new Snail('R',10);
		assertTrue(s.direction);
		s.turn('L');
		assertFalse(s.direction);
	}
	
	@Test
	void testMove() {
		Snail s = new Snail('R',0);
		Point pp = new Point(s.getPoint().getX(),s.getPoint().getY());
		new Coin(100,new Point(300,100),1);
		s.move();
		assertFalse(s.getPoint().equals(pp));
	}
	
	@Test
	void testSearchFood() {
		Coin c1 = new Coin(100,new Point(0,1),1);
		Coin c2 = new Coin(100,new Point(9,9),1);
		Snail s = new Snail('R',6);
		assertTrue(s.searchFood() == c2);
	}
	
	@Test
	void testEat() {
		Coin c1 = new Coin(100,new Point(0,1),1);
		Coin c2 = new Coin(100,new Point(0,6),1);
		int firstCollectedCoin = Coin.getCollectedCoins();
		int firstSize = Coin.getActiveCoins().size();
		Snail s = new Snail('R',0);
		s.eat(c1);
		assertTrue(firstCollectedCoin < Coin.getCollectedCoins());
		assertTrue(firstSize > Coin.getActiveCoins().size());
	}
}
