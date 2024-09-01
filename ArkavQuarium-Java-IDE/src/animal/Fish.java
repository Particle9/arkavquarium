package animal;

import point.Point;
import thing.Thing;

public abstract class Fish extends Thing implements Animal {
  protected static final int[] price = { 0, 100, 200, 300, 1000 };
  protected static final int[] maxHealth = { 0, 3000, 3500, 4500, 5000 };
  protected static final int[] foodRequired = { 0, 5, 10, 10000 };
  protected static final double hungerPercent = 0.4;
  protected int health;
  protected int level;
  protected int foodEaten;
  protected boolean hungerStat;
  protected boolean direction;
  protected double dirDegree;

  /**
   * Default Constructor.
   */
  public Fish() {
    super();
    health = maxHealth[1];
    level = 0;
    foodEaten = 0;
    hungerStat = false;
    direction = true;
    dirDegree = 0;
  }

  /**
   * Default constructor.
   * @param npos Initial position
   */
  public Fish(Point npos) {
    super(npos);
    health = maxHealth[1];
    level = 0;
    foodEaten = 0;
    hungerStat = false;
    direction = true;
    dirDegree = 0;
  }

  /**
   * User defined constructor.
   * @param nlevel Initial level
   * @param npos Initial position
   * @param c Initial direction
   * @param fooe Initial Food eaten
   */
  public Fish(int nlevel, Point npos, char c, int fooe) {
    super(npos);
    level = nlevel;
    direction = c == 'R';
    health = maxHealth[level];
    foodEaten = fooe;
    hungerStat = false;
    dirDegree = 0;
  }

  public int getPrice() {
    return (price[level]);
  }

  public int getMaxHealth() {
    return (maxHealth[level]);
  }

  public int getFoodRequired() {
    return (foodRequired[level]);
  }

  public int getHealth() {
    return (health);
  }

  public void setHealth(int h) {
    health = h;
  }

  public int getLevel() {
    return (level);
  }

  public void setLevel(int l) {
    level = l;
  }

  public int getFoodEaten() {
    return (foodEaten);
  }

  public void setFoodEaten(int s) {
    foodEaten = s;
  }

  public boolean getHungerStat() {
    return (hungerStat);
  }

  public void setHungerStat(boolean hs) {
    hungerStat = hs;
  }

  public boolean getDirection() {
    return (direction);
  }

  public void setDirection() {
    direction = !direction;
  }
  
  public double getDirDegree() {
    return dirDegree;
  }
  
  public void setDirDegree(double dirDeg) {
    dirDegree = dirDeg;
  }

  @Override
  public void turn(char dir) {
    if (dir == 'R') {
      direction = true;
    } else {
      direction = false;
    }
  }
  
  public boolean isHungry() {
    return (hungerStat);
  }

  public int getHungerHealth() {
    return ((int) hungerPercent * maxHealth[level]);
  }

  public static int getDefaultPrice() {
    return (price[1]);
  }

  public void levelUp() {
    level++;
  }

  public abstract void produceCoin(int price);
}