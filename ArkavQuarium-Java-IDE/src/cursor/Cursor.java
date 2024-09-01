package cursor;

import linkList.*;

import java.awt.event.KeyEvent;

import item.*;
import point.*;
import thing.*;

public class Cursor extends Thing{
  protected static int speed = 5;
  protected boolean direction;
  private int dx;
  public int getDx() {
    return dx;
  }
  public void setDx(int dx) {
    this.dx = dx;
  }
  public int getDy() {
    return dy;
  }
  public void setDy(int dy) {
    this.dy = dy;
  }

  private int dy;
  public Cursor(){}
  public Cursor(int x, int y){
    super(new Point(x,y));
    direction = true;
  }

  public boolean getDirection() {
    return direction;
  }
  
  public void setDirection(boolean dir)  {
    direction = dir;
  }

  private static Point Point(int x, int y) {
    // TODO Auto-generated method stub
    return null;
  }
  public void move(int x, int y){
    pos.setX(pos.getX() + x*speed);
    pos.setY(pos.getY() + y*speed);
    if(x != 0) direction = x >0;
    if(Coin.getActiveCoins().isEmpty()) return;
    Coin CC = searchFood();
    if(pos.getDistance(CC.getPoint()) < 50){
      makan(CC);
    }
  }
  public void moveT() {
    if (pos.getX() + dx > 50 && pos.getX() + dx < 550 && pos.getY() + dy > 50 && pos.getY() + dy < 550) {
      pos.setX(pos.getX()+dx);
      pos.setY(pos.getY()+dy);
    }
    if(Coin.getActiveCoins().isEmpty()) return;
    Coin CC = searchFood();
    if(pos.getDistance(CC.getPoint()) < 50){
      makan(CC);
    }
  }
  public Coin searchFood(){
    LinkList<Coin> listMakanan;
    listMakanan = Coin.getActiveCoins();
    Coin minFood = listMakanan.get(0);
    double minDis;
    minDis = pos.getDistance(minFood.getPoint());
    if (listMakanan.isOneElmt()) return minFood;
    int nsize = listMakanan.size();
    for(int i  = 1; i < nsize; i++){
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

  public void setPosition(int x,int y){
    pos = Point(x,y);
  }

}