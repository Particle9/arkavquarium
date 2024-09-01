package screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import animal.Fish;
import animal.Guppy;
import animal.Piranha;
import aquarium.Aquarium;
import item.Coin;
import item.Food;
import linkList.LinkList;

public class Screen extends JPanel implements ActionListener {

  private static final long serialVersionUID = 1L;
  public static final int SCREEN_WIDTH = 500;
  public static final int SCREEN_HEIGHT = 500;
  private BufferedImage aquarium;
  private BufferedImage coinLvl1;
  private BufferedImage coinLvl2;
  private BufferedImage coinLvl3;
  private BufferedImage diamond;
  private BufferedImage endGameLose;
  private BufferedImage endGameWin;
  private BufferedImage guppyLvl1R;
  private BufferedImage guppyLvl1L;
  private BufferedImage guppyLvl2R;
  private BufferedImage guppyLvl2L;
  private BufferedImage guppyLvl3R;
  private BufferedImage guppyLvl3L;
  private BufferedImage piranhaR;
  private BufferedImage piranhaL;
  private BufferedImage guppyLvl1Rh;
  private BufferedImage guppyLvl1Lh;
  private BufferedImage guppyLvl2Rh;
  private BufferedImage guppyLvl2Lh;
  private BufferedImage guppyLvl3Rh;
  private BufferedImage guppyLvl3Lh;
  private BufferedImage piranhaRh;
  private BufferedImage piranhaLh;
  private BufferedImage food;
  private BufferedImage menuNormal;
  private BufferedImage menuPlay;
  private BufferedImage menuQuit;
  private BufferedImage snailR;
  private BufferedImage snailL;
  private BufferedImage cursor;
  private Aquarium aqua;
  public static int state;
  public static int menu;
  public static boolean win;

  /**
   * Constructor.
   */
  public Screen(Aquarium aqua) {

    addKeyListener(new TAdapter());
    setFocusable(true);
    setDoubleBuffered(true);
    this.aqua = aqua;
    loadImage();
    setSurfaceSize();
  }

  public Aquarium getAquarium() {
    return aqua;
  }

  /**
   * Aquarium setter.
   * 
   * @param aqua Aquarium
   */
  public void setAquarium(Aquarium aqua) {
    this.aqua = aqua;
  }

  /**
   * Load every image of every entity.
   */
  public void loadImage() {
    try {
      aquarium = ImageIO.read(getClass().getResourceAsStream("img/aquarium/aquarium.jpg"));
      coinLvl1 = ImageIO.read(getClass().getResourceAsStream("img/coin/bronzecoin_32.png"));
      coinLvl2 = ImageIO.read(getClass().getResourceAsStream("img/coin/silvercoin_32.png"));
      coinLvl3 = ImageIO.read(getClass().getResourceAsStream("img/coin/goldcoin_32.png"));
      diamond = ImageIO.read(getClass().getResourceAsStream("img/coin/diamond_32.png"));
      endGameLose = ImageIO.read(getClass().getResourceAsStream("img/end_game/lose.jpg"));
      endGameWin = ImageIO.read(getClass().getResourceAsStream("img/end_game/win.jpg"));
      guppyLvl1R = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_64_r.png"));
      guppyLvl1L = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_64_l.png"));
      guppyLvl2R = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_82_r.png"));
      guppyLvl2L = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_82_l.png"));
      guppyLvl3R = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_100_r.png"));
      guppyLvl3L = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_100_l.png"));
      piranhaR = ImageIO.read(getClass().getResourceAsStream("img/fish/piranha_128_r.png"));
      piranhaL = ImageIO.read(getClass().getResourceAsStream("img/fish/piranha_128_l.png"));
      guppyLvl1Rh = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_64_r_h.png"));
      guppyLvl1Lh = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_64_l_h.png"));
      guppyLvl2Rh = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_82_r_h.png"));
      guppyLvl2Lh = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_82_l_h.png"));
      guppyLvl3Rh = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_100_r_h.png"));
      guppyLvl3Lh = ImageIO.read(getClass().getResourceAsStream("img/fish/guppy_100_l_h.png"));
      piranhaRh = ImageIO.read(getClass().getResourceAsStream("img/fish/piranha_128_r_h.png"));
      piranhaLh = ImageIO.read(getClass().getResourceAsStream("img/fish/piranha_128_l_h.png"));
      food = ImageIO.read(getClass().getResourceAsStream("img/food/food_20.png"));
      menuNormal = ImageIO.read(getClass().getResourceAsStream("img/menu/menu_normal.jpg"));
      menuPlay = ImageIO.read(getClass().getResourceAsStream("img/menu/menu_play.jpg"));
      menuQuit = ImageIO.read(getClass().getResourceAsStream("img/menu/menu_quit.jpg"));
      snailR = ImageIO.read(getClass().getResourceAsStream("img/siput/snail_100_r.png"));
      snailL = ImageIO.read(getClass().getResourceAsStream("img/siput/snail_100_l.png"));
      cursor = ImageIO.read(getClass().getResourceAsStream("img/cursor/starfish_16.png"));
    } catch (IOException e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }

  private void setSurfaceSize() {
    Dimension d = new Dimension();
    d.width = aquarium.getWidth(null);
    d.height = aquarium.getHeight(null);
    setPreferredSize(d);
  }

  /**
   * Draw Graphics g.
   * @param g Graphics
   */
  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    switch (state) {
      case 1: {
        drawMenu(g2d, menu);
        break;
      }
      case 2: {
  
        drawAquarium(g2d);
        drawText(g2d);
        drawCoin(g2d);
        drawFood(g2d);
        drawGuppy(g2d);
        drawPiranha(g2d);
        drawSnail(g2d);
        drawCursor(g2d);
        break;
      }
      case 3: {
        drawEndGame(g2d, win);
        break;
      }
      default:
        break;
    }

  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }

  private void drawAquarium(Graphics2D g2d) {
    g2d.drawImage(aquarium, 0, 0, this.getWidth(), this.getHeight(), null);
  }

  private void drawText(Graphics2D g2d) {
    FontRenderContext frc = g2d.getFontRenderContext();
    Font helpF = new Font("Helvetica", Font.BOLD, 11);
    String helpS = new String(
        "Panah:bergerak | r:reset | x:keluar | e:beli telur "
        + "| g:beli guppy | p:beli piranha | m:beli makanan");
    String coinS = new String("Jumlah Koin : " + Coin.getCollectedCoins());
    TextLayout helpTl = new TextLayout(helpS, helpF, frc);
    TextLayout coinTl = new TextLayout(coinS, helpF, frc);

    g2d.setColor(Color.green);
    helpTl.draw(g2d, Screen.SCREEN_WIDTH / 30, 15);
    coinTl.draw(g2d, Screen.SCREEN_WIDTH / 30, 30);
    String eggS = new String("Level Telur : " + aqua.getEggState());
    TextLayout eggTl = new TextLayout(eggS, helpF, frc);
    eggTl.draw(g2d, Screen.SCREEN_WIDTH / 30, 45);
    String eggPriceS = new String("Harga Telur : " + aqua.getCurrEggPrice());
    TextLayout eggPriceTl = new TextLayout(eggPriceS, helpF, frc);
    eggPriceTl.draw(g2d, (Screen.SCREEN_WIDTH / 30) + 200, 30);
    String guppyPriceS = new String("Harga Guppy : " + Fish.getDefaultPrice());
    TextLayout guppyPriceTl = new TextLayout(guppyPriceS, helpF, frc);
    guppyPriceTl.draw(g2d, (Screen.SCREEN_WIDTH / 30) + 200, 45);
    String piranhaPriceS = new String("Harga Piranha : " + Piranha.getDefaultPrice());
    TextLayout piranhaPriceTl = new TextLayout(piranhaPriceS, helpF, frc);
    piranhaPriceTl.draw(g2d, (Screen.SCREEN_WIDTH / 30) + 350, 30);
    String foodPriceS = new String("Harga Makanan : " + Food.getFoodPrice());
    TextLayout foodPriceTl = new TextLayout(foodPriceS, helpF, frc);
    foodPriceTl.draw(g2d, (Screen.SCREEN_WIDTH / 30) + 350, 45);
  }

  private void drawGuppy(Graphics2D g2d) {
    LinkList<Guppy> listGuppy = Guppy.getListGuppy();
    BufferedImage guppyType = guppyLvl1R;
    for (int i = 0; i < listGuppy.size(); i++) {
      if (listGuppy.get(i).getLevel() == 1) {
        if (listGuppy.get(i).getDirection() == true) {
          if (listGuppy.get(i).getHungerStat() == false) {
            guppyType = guppyLvl1R;
          } else {
            guppyType = guppyLvl1Rh;
          }
        } else {
          if (listGuppy.get(i).getHungerStat() == false) {
            guppyType = guppyLvl1L;
          } else {
            guppyType = guppyLvl1Lh;
          }
        }
      } else if (listGuppy.get(i).getLevel() == 2) {
        if (listGuppy.get(i).getDirection() == true) {
          if (listGuppy.get(i).getHungerStat() == false) {
            guppyType = guppyLvl2R;
          } else {
            guppyType = guppyLvl2Rh;
          }
        } else {
          if (listGuppy.get(i).getHungerStat() == false) {
            guppyType = guppyLvl2L;
          } else {
            guppyType = guppyLvl2Lh;
          }
        }
      } else if (listGuppy.get(i).getLevel() == 3) {
        if (listGuppy.get(i).getDirection() == true) {
          if (listGuppy.get(i).getHungerStat() == false) {
            guppyType = guppyLvl3R;
          } else {
            guppyType = guppyLvl3Rh;
          }
        } else {
          if (listGuppy.get(i).getHungerStat() == false) {
            guppyType = guppyLvl3L;
          } else {
            guppyType = guppyLvl3Lh;
          }
        }
      }
      g2d.drawImage(guppyType, (int) (listGuppy.get(i).getPoint().getX()),
          (int) (listGuppy.get(i).getPoint().getY()),
          guppyType.getWidth(), guppyType.getHeight(), null);
    }
  }

  private void drawPiranha(Graphics2D g2d) {
    LinkList<Piranha> listPiranha = Piranha.getListPiranha();
    BufferedImage piranhaType = piranhaR;
    for (int i = 0; i < listPiranha.size(); i++) {
      if (listPiranha.get(i).getDirection() == true) {
        if (listPiranha.get(i).getHungerStat() == false) {
          piranhaType = piranhaR;
        } else {
          piranhaType = piranhaRh;
        }
      } else {
        if (listPiranha.get(i).getHungerStat() == false) {
          piranhaType = piranhaL;
        } else {
          piranhaType = piranhaLh;
        }
      }
      g2d.drawImage(piranhaType, (int) (listPiranha.get(i).getPoint().getX()),
          (int) (listPiranha.get(i).getPoint().getY()),
          piranhaType.getWidth(), piranhaType.getHeight(), null);
    }
  }

  private void drawSnail(Graphics2D g2d) {
    BufferedImage snailType = snailR;
    if (aqua.snail.getDirection() == true) {
      snailType = snailR;
    } else {
      snailType = snailL;
    }
    g2d.drawImage(snailType, (int) (aqua.snail.getPoint().getX()), (int) (aqua.snail.getPoint().getY()),
        snailType.getWidth(), snailType.getHeight(), null);
  }

  private void drawCoin(Graphics2D g2d) {
    LinkList<Coin> listCoin = Coin.getActiveCoins();
    BufferedImage coinType = coinLvl1;
    for (int i = 0; i < listCoin.size(); i++) {
      if (listCoin.get(i).getCoinType() == 1) {
        coinType = coinLvl1;
      } else if (listCoin.get(i).getCoinType() == 2) {
        coinType = coinLvl2;
      } else if (listCoin.get(i).getCoinType() == 3) {
        coinType = coinLvl3;
      } else if (listCoin.get(i).getCoinType() == 4) {
        coinType = diamond;
      }
      g2d.drawImage(coinType, (int) (listCoin.get(i).getPoint().getX()), (int) (listCoin.get(i).getPoint().getY()),
          coinType.getWidth(), coinType.getHeight(), null);
    }
  }

  private void drawEndGame(Graphics2D g2d, boolean win) {
    BufferedImage endGame = endGameWin;
    if (win == true) {
      endGame = endGameWin;
    } else {
      endGame = endGameLose;
    }
    g2d.drawImage(endGame, 0, 0, this.getWidth(), this.getHeight(), null);
  }

  private void drawFood(Graphics2D g2d) {
    LinkList<Food> listFood = Food.getFoodList();
    for (int i = 0; i < listFood.size(); i++) {
      g2d.drawImage(food, (int) (listFood.get(i).getPoint().getX()), (int) (listFood.get(i).getPoint().getY()),
          food.getWidth(), food.getHeight(), null);
    }
  }

  private void drawMenu(Graphics2D g2d, int menu) {
    BufferedImage menuType = menuNormal;
    if (menu == 1) {
      menuType = menuNormal;
    } else if (menu == 2) {
      menuType = menuPlay;
    } else if (menu == 3) {
      menuType = menuQuit;
    }
    g2d.drawImage(menuType, 0, 0, this.getWidth(), this.getHeight(), null);
  }

  private void drawCursor(Graphics2D g2d) {
    g2d.drawImage(cursor, (int) (aqua.cursor.getPoint().getX()), (int) (aqua.cursor.getPoint().getY()),
        cursor.getWidth(), cursor.getHeight(), null);
  }

  public void actionPerformed(ActionEvent e) {

  }

  private class TAdapter extends KeyAdapter {

    @Override
    public void keyReleased(KeyEvent e) {
      aqua.keyReleased(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
      aqua.keyPressed(e);
    }
  }

}
