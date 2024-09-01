package aquarium;

import animal.Fish;
import animal.Guppy;
import animal.Piranha;
import animal.Snail;
import cursor.Cursor;
import item.Coin;
import item.Food;
import java.awt.event.KeyEvent;
import java.util.Random;
import point.Point;
import screen.Screen;
import thing.Thing;

/*
 * @author alghifari
 *
 */
public class Aquarium {
  private int eggState;
  public static final int[] eggPrice = { 0, 2000, 3000, 4000, 0 };
  public Snail snail;
  public Cursor cursor;

  /**
   * Default Costructor.
   */
  public Aquarium() {
    snail = new Snail('R', 250);
    cursor = new Cursor(250, 250);
    Thing.setMax(new Point(Screen.SCREEN_WIDTH - 40, Screen.SCREEN_HEIGHT - 100));
    Random rand = new Random();
    int gx = rand.nextInt((int) Thing.getMax().getX()) + 40;
    int gy = rand.nextInt((int) Thing.getMax().getY()) + 40;
    int px = rand.nextInt((int) Thing.getMax().getX()) + 40;
    int py = rand.nextInt((int) Thing.getMax().getY()) + 40;
    new Guppy(new Point(gx, gy));
    new Piranha(new Point(px, py));
    eggState = 0;
  }

  /**
   * Snail getter.
   * 
   * @return snail.
   */
  public Snail getSnail() {
    return snail;
  }

  /**
   * Snail setter.
   * 
   * @param snail Snail
   */
  public void setSnail(Snail snail) {
    this.snail = snail;
  }

  /**
   * Cursor getter.
   * 
   * @return cursor
   */
  public Cursor getCursor() {
    return cursor;
  }

  /**
   * Cursor setter.
   * 
   * @param cursor cursor
   */
  public void setCursor(Cursor cursor) {
    this.cursor = cursor;
  }

  /**
   * eggPrice getter.
   * 
   * @return eggPrice.
   */
  public static int[] getEggprice() {
    return eggPrice;
  }

  /**
   * eggState setter.
   * 
   * @param eggState eggState
   */
  public void setEggState(int eggState) {
    this.eggState = eggState;
  }

  /**
   * eggState getter.
   * 
   * @return eggstate
   */
  public int getEggState() {
    return (eggState);
  }

  /**
   * Current Egg Price getter.
   * 
   * @return curreggprice.
   */
  public int getCurrEggPrice() {
    return (eggPrice[eggState + 1]);
  }

  /**
   * increaseeggstate.
   */
  public void increaseEggState() {
    eggState += 1;
  }

  /**
   * Keyboard input.
   * 
   * @param e
   *          Key type that is pressed
   */
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (Screen.state == 1) {
      if (key == KeyEvent.VK_UP) { // keyboard atas
        Screen.menu = 2;
      }
      if (key == KeyEvent.VK_DOWN) { // keyboard bawah
        Screen.menu = 3;
      }
      if (key == KeyEvent.VK_ENTER) { // enter
        if (Screen.menu == 2) {
          Screen.state = 2;
        } else if (Screen.menu == 3) {
          Screen.state = 3;
          Screen.win = false;
        }
      }
    }
    if (Screen.state == 2) {
      if (key == KeyEvent.VK_G) {
        if (Coin.getCollectedCoins() > Fish.getDefaultPrice()) {
          Random rand = new Random();
          int gx = rand.nextInt((int) Thing.getMax().getX()) + 40;
          int gy = rand.nextInt((int) Thing.getMax().getY()) + 40;
          new Guppy(new Point(gx, gy));
          Coin.decCollectedCoin(Fish.getDefaultPrice());
        }
      }
      if (key == KeyEvent.VK_P) {
        if (Coin.getCollectedCoins() > Piranha.getDefaultPrice()) {
          Random rand = new Random();
          int px = rand.nextInt((int) Thing.getMax().getX()) + 40;
          int py = rand.nextInt((int) Thing.getMax().getY()) + 40;
          new Piranha(new Point(px, py));
          Coin.decCollectedCoin(Piranha.getDefaultPrice());
        }
      }
      if (key == KeyEvent.VK_M) {
        if (Coin.getCollectedCoins() > Food.getFoodPrice()) {
          new Food(new Point(cursor.getPoint().getX(), cursor.getPoint().getY()));
          Coin.decCollectedCoin(Food.getFoodPrice());
        }
      }
      if (key == KeyEvent.VK_E) {
        if (Coin.getCollectedCoins() > this.getCurrEggPrice()) {
          this.increaseEggState();
          Coin.decCollectedCoin(this.getCurrEggPrice());
        }
      }
      if (key == KeyEvent.VK_X) {
        Screen.state = 3;
        Screen.win = false;
      }
      if (key == KeyEvent.VK_OPEN_BRACKET) {
        Guppy.getListGuppy().removeAll();
      }
      if (key == KeyEvent.VK_CLOSE_BRACKET) {
        Piranha.getListPiranha().removeAll();
      }
      if (key == KeyEvent.VK_LEFT) {
        cursor.setDx(-1);
      }
      if (key == KeyEvent.VK_RIGHT) {
        cursor.setDx(1);
      }
      if (key == KeyEvent.VK_UP) {
        cursor.setDy(-1);
      }
      if (key == KeyEvent.VK_DOWN) {
        cursor.setDy(1);
      }
    }
  }

  /**
   * when keyboard released.
   * 
   * @param e Key type released
   */
  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_LEFT) {
      cursor.setDx(0);
    }
    if (key == KeyEvent.VK_RIGHT) {
      cursor.setDx(0);
    }
    if (key == KeyEvent.VK_UP) {
      cursor.setDy(0);
    }
    if (key == KeyEvent.VK_DOWN) {
      cursor.setDy(0);
    }
  }

}