package main;

import animal.Fish;
import animal.Guppy;
import animal.Piranha;
import aquarium.Aquarium;
import item.Coin;
import item.Food;
import java.awt.Toolkit;
import screen.DisplayScreen;
import screen.Screen;

public class Main {

  /**
   * Main program.
   * 
   * @param args
   *          .
   */
  public static void main(String[] args) {
    Aquarium aqua = new Aquarium();
    Screen screen = new Screen(aqua);
    Screen.state = 1;
    Screen.menu = 1;
    DisplayScreen ex = new DisplayScreen(screen);
    ex.setVisible(true);
    while (Screen.state != 4) {
      if (Screen.state == 2) {
        Food.drownAll();
        Guppy.moveAll();
        Piranha.moveAll();
        Coin.drownAll();
        aqua.snail.move();
        aqua.cursor.moveT();
        if (aqua.getEggState() == 3) {
          Screen.state = 3;
          Screen.win = true;
        }
        if (Guppy.getListGuppy().size() == 0 && Coin.getCollectedCoins() < Fish.getDefaultPrice()) {
          Screen.state = 3;
          Screen.win = false;
        }
      }
      screen.repaint();
      if (System.getProperty("os.name").equals("Linux")) {
        Toolkit.getDefaultToolkit().sync();
      }
      try {
        Thread.sleep(10);
      } catch (InterruptedException exc) {
        // TODO Auto-generated catch block
        exc.printStackTrace();
      }
    }
  }
}
