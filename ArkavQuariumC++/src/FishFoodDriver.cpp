#include <iostream>
#include "List.hpp"
#include "FishFood.hpp"
using namespace std;


int main()  {
    cout << "FishFood()" << endl;
    FishFood F1;
    cout << "Foodlvl:" << F1.getFoodLvl() << ", pos:" << F1.getPoint().getX() << " " << F1.getPoint().getY() << endl;
    cout << "FishFood(Point p) : ObjekMati(p)" << endl;
    Point P(10,20);
    FishFood F2(P);
    FishFood F3(Point(50,75));
    cout << "Foodlvl:" << F2.getFoodLvl() << ", pos:" << F2.getPoint().getX() << " " << F2.getPoint().getY() << endl;
    cout << "static void setFoodLvl(int m) dan getFoodLvl()" << endl;
    F2.setFoodLvl(5);
    cout << "Foodlvl:" << F2.getFoodLvl() << endl;
    cout << "static void incFoodLvl()" << endl;
    F2.incFoodLvl();
    cout << "Foodlvl:" << F2.getFoodLvl() << endl;
    cout << "getFoodList() dan void removeFromList()" << endl;
    cout << "Sebelum Dihapus :";
    FishFood::getFoodList().printAll();
    F2.removeFromList();
    cout << "Sesudah Dihapus :";
    FishFood::getFoodList().printAll();
    // void draw()
    // void drown()
}