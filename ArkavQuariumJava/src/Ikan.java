public abstract class Ikan extends Objek implements Hewan  {
    protected static final int price[] = {0, 100, 200, 300};
    protected static final int maxHealth[] = {0, 3000, 3500, 4500};
    protected static final int foodRequired[] = {0, 5, 10, 10000};
    protected static final double hungerPercent = 0.4;
    protected int health;
    protected int level;
    protected int foodEaten;
    protected boolean hungerStat;
    protected boolean arah;
    protected char stateDirH;
    protected char stateDirV;
    protected double dirDegree;

    /**
     * Default Ctor
     */
    public Ikan() {
        stateDirH = 'R';
        stateDirV = 'T';
        level = 0;
        health = maxHealth[1];
        arah = true;
        hungerStat = false;
        dirDegree = 0;
    }

    /**
     * User Defined Ctor
     */
    public Ikan(int nlevel, Point npos, char c, int fooe) {
        super(npos);
        level = nlevel;
        arah = c == 'R';
        health = maxHealth[level];
        foodEaten = fooe;
        stateDirH = c;
        hungerStat = false;
        dirDegree = 0;
    }

    //Method menghadap
    public void turn(char dir){
        if (dir == 'R') {
            arah = true;
        } else {
            arah = false;
        } 
    }
    //Method Gerak dengan parameter arah
    
    public  int getPrice(){
        return(price[level]);
    }
    //getter Level
    public int getLevel(){
        return(level);
    }
    //getter Health
    public int getHealth(){
        return(health);
    }
    //getter Status
    public boolean getArah(){
        return(arah);
    }
    //setter koin
    public int getFoodRequired(){
        return(foodRequired[level]);
    }
    public int getFoodEaten(){
        return(foodEaten);
    }
    public int getHungerHealth(){
        return((int) hungerPercent * maxHealth[level]);
    }
    public int getMaxHealth(){
        return(maxHealth[level]);
    }
    //setter level
    public void setLevel(int l){
        level = l;

    }
    public static int getDefaultPrice(){
        return(price[1]);
    }
    //setter HP
    public void setHealth(int h){
        health = h;
    }
    //setter Status
    public void setArah(){
        arah = !arah;
    }
    public void setFoodEaten(int s ){
        foodEaten = s;
    }
    //setter Makanan
    public void levelUp(){
        level++;
    }
    public abstract void produceCoin(int price);
}