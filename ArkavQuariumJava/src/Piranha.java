public class Piranha extends Ikan{
    protected static LinkList<Piranha> listLivingPiranha = new LinkList<Piranha>();
    protected static double speed = 1;
    protected static String imageL = "fish/piranha_128_l.png";
    protected static String imageR = "fish/piranha_128_r.png";
    protected int dirDeg;
    public Piranha(){}
    public Piranha(Point npos){
        super(npos);
    }
    public void removeFromList(){
        listLivingPiranha.remove(this);
    }
    public Guppy searchMakanan(){
        LinkList<Guppy> listMakanan;
        listMakanan.clone(Guppy.getGuppyList());
        Guppy minFood = listMakanan.get(1);
        int minDis = pos.getDistance(minFood.getPoint());
        if (listMakanan.isOneElmt()) return minFood;
        int nsize = listMakanan.size();
        for(int i  = 2; i < nsize; i++){
            Guppy tempFood = listMakanan.get(i);
            if(minDis > pos.getDistance(tempFood.getPoint())){
                minDis = pos.getDistance(tempFood.getPoint());
                minFood = tempFood;
            }
        }
        return minFood;
    }
    public void normalMove(){
        normalMove(0);
    }
    public void normalMove(int dirDeg){
        int x = pos.getX();
        if (health % 300 == 0) {
            dirDegree = (rand()%360);
            dirDegree = dirDegree*3.14159265/180;
        }
        if (pos.getX() < 40 || pos.getX() > (SCREEN_WIDTH - 40) || pos.getY() < 40 || pos.getY() > (SCREEN_HEIGHT-40)) {
            dirDegree = (rand()%360);
            dirDegree = dirDegree*3.14159265/180;   
        }
        pos.setX(pos.getX() - speed*cos(dirDegree));
        pos.setY(pos.getY() - speed*sin(dirDegree));
        if(pos.getX() > max.getX()){
            stateDirH = 'L';  
        } 
        if(pos.getX() < 0 ){
            stateDirH = 'R';
        }
        arah = x < pos.getX();
    }
    public void move(){
        move(0);
    }
    public void move(int dirDeg){
        if(!hungerStat) normalMove();
        else{
            int x = pos.getX();
            Guppy FF;
            if (!Guppy.getGuppyList().isEmpty()){
                FF = searchMakanan();
                if((pos.getDistance(FF.getPoint())) < 20) makan(FF);
                else{
                    if(pos.getX() > FF.getPoint().getX()) stateDirH = 'L';
                    else stateDirH = 'R';
                    Point p1 = pos;
                    Point p2 = FF.getPoint();
                    float angle = atan2(p1.getY() - p2.getY(), p1.getX() - p2.getX());
                    pos.setX(pos.getX() - speed*cos(angle));
                    pos.setY(pos.getY() - speed*sin(angle));
                    arah = x <pos.getX();
                } 
            }
            else normalMove();
        }
        decreaseHealth();
    }
    public void makan(Guppy food){
        int foodprice = food.getPrice();
        int foodlevel = food.getLevel();
        food.removeFromList();
        health = getMaxHealth();
        foodEaten ++;
        hungerStat = false;
        produceCoin(price[level]*10/5);
    }

    public int getMaxHealth(){
        return(super.getMaxHealth()*3);
    }

    public void decreaseHealth(){
        if (health < 1){
            listLivingPiranha.remove(this);
        }
        else if(health < hungerPercent*getMaxHealth()){
            health -= 2;
            hungerStat = true;
        }
        else{
            health -= 2;
            hungerStat = false;
        }
    }

    public int getPrice(){
        return(super.getPrice() *10);
    }
    public void produceCoin(int price){
        Coin C = new Coin(price,pos,4);
    }
    public static LinkList<Piranha> getListPiranha(){
        return listLivingPiranha;
    }
    public void draw(){
        if (arah) draw_image(imageR, pos.getX(), pos.getY());
        else draw_image(imageL,pos.getX(),pos.getY());
    }
    public static int getDefaultPrice(){
        return(Ikan.getDefaultPrice() * 10);
    }
    public static void drawAll(){
        int siz = listLivingPiranha.size() + 1;
        for (int i = 0; i < siz; i++){
            listLivingPiranha.get(i).draw();
        }
    }
    public static void moveAll(){
        int siz = listLivingPiranha.size() + 1;
        for (int i = 0; i < siz; i++){
            listLivingPiranha.get(i).move();
        }
    }
}   