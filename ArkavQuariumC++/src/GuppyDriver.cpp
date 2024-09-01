#include <iostream>
#include "Guppy.hpp"
using namespace std;

int main()  {
    cout << "Guppy()" << endl;
    Guppy G1;
    cout << "pos:" << G1.getPoint().getX() << " " << G1.getPoint().getY() << ", level:" << G1.getLevel() << ", arah:" << G1.getArah() << ", FoodEaten:" << G1.getFoodEaten() << ", health:" << G1.getHealth() << endl;
    cout << "Guppy(Point npos, int nLevel =1, char c = 'R', int fooe =0) : Ikan(nLevel,npos,c,fooe)" << endl;
    Point P(100,150);
    Guppy G2(P);
    cout << "pos:" << G2.getPoint().getX() << " " << G2.getPoint().getY() << ", level:" << G1.getLevel() << ", arah:" << G1.getArah() << ", FoodEaten:" << G1.getFoodEaten() << ", health:" << G2.getHealth() << endl;
    cout << "void decreaseHealth()" << endl;
    G2.decreaseHealth();
    cout << "pos:" << G2.getPoint().getX() << " " << G2.getPoint().getY() << ", level:" << G1.getLevel() << ", arah:" << G1.getArah() << ", FoodEaten:" << G1.getFoodEaten() << ", health:" << G2.getHealth() << endl;
    // void removeFromList()
    // //Prekondisi Tersedia Makanan di Aquarium
    cout << "FishFood searchMakanan()" << endl;
    FishFood F1;
    FishFood F2 = G2.searchMakanan();
    cout << "Foodlvl:" << F2.getFoodLvl() << ", pos:" << F2.getPoint().getX() << " " << F2.getPoint().getY() << endl;
    cout << "void normalMove(int dirDeg = 0)" << endl;
    G2.normalMove();
    cout << "pos:" << G2.getPoint().getX() << " " << G2.getPoint().getY() << ", level:" << G1.getLevel() << ", arah:" << G1.getArah() << ", FoodEaten:" << G1.getFoodEaten() << ", health:" << G2.getHealth() << endl;
    cout << "void move(int dirDeg = 0)" << endl;
    G2.move();
    cout << "pos:" << G2.getPoint().getX() << " " << G2.getPoint().getY() << ", level:" << G1.getLevel() << ", arah:" << G1.getArah() << ", FoodEaten:" << G1.getFoodEaten() << ", health:" << G2.getHealth() << endl;
    // void makan(FishFood food)
    // void produceCoin(int price)
    // static List<Guppy> getGuppyList()
    // void draw()
    // static void drawAll()
}