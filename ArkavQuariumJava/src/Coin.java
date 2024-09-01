import java.util.Collections;

public class Coin extends ObjekMati{
    protected static LinkList<Coin> listCoin = new LinkList<Coin>();
    protected static int CollectedCoin = 0;
    protected int value;
    protected int cointype;

    public Coin(){
        super(new Point(0,0));
        value = 100;
        cointype = 1;
    }
    public Coin(int val, int t){
        super(new Point(0,0));
        value = val;
        cointype = t;
        listCoin.add(this);
    }
    public Coin(int val, Point P, int t){
        super(P);
        value = val;
        cointype = t;
        listCoin.add(this);
    }
    public void removeFromList(){
        listCoin.remove(this);
    }
    public static LinkList<Coin> getActiveCoins(){
        return(listCoin);
    }
    public int getValue(){
        return(value);
    }
    public void setValue(int v){
        value = v;
    }
    public void drown(){
        if (pos.getY() < max.getY() -100){
            super.drown();
        }
    }
    public static int getCollectedCoins(){
        return(CollectedCoin);
    }
    public void addCollectedCoins(){
        CollectedCoin += value;
    }
    public void draw(){
        if (cointype == 1) draw_image("coin/bronzecoin_32.png", pos.getX(), pos.getY());
        else if (cointype == 2) draw_image("coin/silvercoin_32.png", pos.getX(), pos.getY());
        else if (cointype == 3) draw_image("coin/goldcoin_32.png", pos.getX(), pos.getY());
        else if (cointype == 4) draw_image("coin/diamond_32.png", pos.getX(), pos.getY());
    }
    public static void decCollectedCoin(int val){
        CollectedCoin -= val;
    }
    public static void drawAll(){
        int siz = listCoin.size() + 1;
        for (int i = 0; i < siz; i++){
            listCoin.get(i).draw();
        }
    }
    public static void drownAll(){
        int siz = listCoin.size() + 1;
        for (int i = 0; i < siz; i++){
            listCoin.get(i).drown();
        }
    }
}