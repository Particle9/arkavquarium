import java.util.Collections;


public class Siput extends Objek implements Hewan{
    protected boolean arah;
    protected static String imageL = "siput/snail_100_l.png";
    protected static String imageR = "siput/snail_100_r.png";
    protected int speed;
    public Siput(){}
    public Siput(char dir, int nx){
        super(Point(nx,max.getY()-100));
        arah = dir == 'R';
        speed = 2;
    }
    public boolean getArah(){
        return(arah);
    }
    public int getSpeed(){
        return(speed);
    }
    public void setArah(bool b){
        arah = b;
    }
    public void setSpeed(int s)    {
        speed = s;
    }
    public void turn(char c){
        arah = c == 'R';
    }
    public void move(int p){
        move();
    }
    public void move(){
        int x = pos.getX();
        if (!Coin.getActiveCoins().isEmpty()){
            Coin CC = searchMakanan();
            if(pos.getDistance(CC.getPoint()) < 60){
                 makan(CC);
            } 
            if (pos.getX() > CC.getPoint().getX()){
                pos.setX(pos.getX() - speed);
            }
            else{
                pos.setX(pos.getX() + speed);
            }
            arah = x < pos.getX();
        }
    }
    Coin searchMakanan(){
        List<Coin> listMakanan;
        listMakanan = Coin.getActiveCoins();
        Coin minFood = listMakanan.get(1);
        int minDis;
        minDis = pos.getDistance(minFood.getPoint());
        if (listMakanan.isOneElmt()) return minFood;
        int nsize = listMakanan.size();
        for(int i  = 2; i < nsize; i++){
            Coin tempFood = listMakanan.get(i);
            if(minDis > pos.getDistance(tempFood.getPoint())){
                minDis = pos.getDistance(tempFood.getPoint());
                minFood = tempFood;
            }
        }
        return minFood;
    }
    public void makan(Coin foo){
        foo.addCollectedCoins();
        foo.removeFromList();
    }
    public void draw(){
        if (arah) draw_image(imageR, pos.getX(), pos.getY());
        else draw_image(imageL, pos.getX(), pos.getY());
    }
}