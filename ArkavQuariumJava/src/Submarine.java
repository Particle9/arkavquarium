import java.util.Collections;

public class Submarine extends Objek{
    protected static int speed = 5;
    protected String imageR = "submarine.png";
    protected String imageL = "submarineL.png";
    protected boolean arah;
    public Submarine(){}
    public Submarine(int x, int y){
        super(Point(x,y));
    }

    public void move(int x, int y){
        pos.setX(pos.getX() + x*speed);
        pos.setY(pos.getY() + y*speed);
        if(x != 0) arah = x >0;
        if(Coin.getActiveCoins().isEmpty()) return;
        Coin CC = searchMakanan();
        if(pos.getDistance(CC.getPoint()) < 50){
            makan(CC);
        }
    }
    public Coin searchMakanan(){
        LinkedList<Coin> listMakanan;
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
    public void draw(){
        if (arah) draw_image(imageR, pos.getX(), pos.getY());
        else draw_image(imageL, pos.getX(), pos.getY());
    }
    public void makan(Coin foo){
        foo.addCollectedCoins();
        foo.removeFromList();
    }

    public void setPosition(int x,int y){
        pos = Point(x,y);
    }
}