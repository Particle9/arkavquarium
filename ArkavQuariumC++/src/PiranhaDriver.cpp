#include <iostream>
#include "Piranha.hpp"
using namespace std;

int main()  {
    cout << "Piranha()" << endl;
    Piranha P1;
    cout << "pos:" << P1.getPoint().getX() << " " << P1.getPoint().getY() << ", level:" << P1.getLevel() << ", arah:" << P1.getArah() << ", FoodEaten:" << P1.getFoodEaten() << ", health:" << P1.getHealth() << endl;
    cout << "Piranha(Point npos, int nLevel =1, char c = 'R', int fooe =0) : Ikan(nLevel,npos,c,fooe)" << endl;
    Piranha P2(Point(10,20));
    Piranha P3(Point(25,50));
    cout << "pos:" << P2.getPoint().getX() << " " << P2.getPoint().getY() << ", level:" << P2.getLevel() << ", arah:" << P2.getArah() << ", FoodEaten:" << P2.getFoodEaten() << ", health:" << P2.getHealth() << endl;    
    cout << "getListPiranha() dan void removeFromList()" << endl;
    cout << "Sebelum Dihapus :";
    Piranha::getListPiranha().printAll();
    P2.removeFromList();
    cout << "Sesudah Dihapus :";
    Piranha::getListPiranha().printAll();
    cout << "Guppy searchMakanan()" << endl;
    Guppy G1(Point(1,1));
    Guppy G2(Point(2,2));
    Guppy G3;
    G3 = P3.searchMakanan();
    cout << "guppy as makanan:" <<  "  pos:" << G3.getPoint().getX() << " " << G3.getPoint().getY() << ", level:" << G3.getLevel() << ", arah:" << G3.getArah() << ", FoodEaten:" << G3.getFoodEaten() << ", health:" << G3.getHealth() << endl;
    cout << "void normalMove(int dirDeg = 0)" << endl;
    P3.normalMove();
    cout << "pos:" << P3.getPoint().getX() << " " << P3.getPoint().getY() << ", level:" << P3.getLevel() << ", arah:" << P3.getArah() << ", FoodEaten:" << P3.getFoodEaten() << ", health:" << P3.getHealth() << endl;
    cout << "void move(int dirDeg = 0)" << endl;
    P3.move();
    cout << "pos:" << P3.getPoint().getX() << " " << P3.getPoint().getY() << ", level:" << P3.getLevel() << ", arah:" << P3.getArah() << ", FoodEaten:" << P3.getFoodEaten() << ", health:" << P3.getHealth() << endl;
    //cout << "void makan(Guppy food)" << endl;
    cout << "int getMaxHealth()" << endl;
    cout << "MaxHealth():" << P3.getMaxHealth() << endl;
    cout << "void decreaseHealth()" << endl;
    P3.decreaseHealth();
    cout << "health:" << P3.getHealth() << endl;
    cout << "int getPrice()" << endl;
    cout << "price:" << P3.getPrice() << endl;
    // cout << "void produceCoin(int price)" << endl;
    // cout << "void draw()" << endl;
    cout << "static int getDefaultPrice()" << endl;
    cout << "default prize" << P3.getDefaultPrice() << endl;
}