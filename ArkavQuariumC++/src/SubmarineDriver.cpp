#include <iostream>
#include "submarine.hpp"
using namespace std;

int main()  {
    cout << "Submarine()" << endl;
    Submarine S1;
    cout << "pos:" << S1.getPoint().getX() << " " << S1.getPoint().getY() << endl;
    cout << "Submarine(int x,int y) : Objek(Point(x,y))" << endl;
    Submarine S2(10,20);
    cout << "void move(int x, int y)" << endl;
    cout << "pos:" << S2.getPoint().getX() << " " << S2.getPoint().getY() << endl;
    cout << "Coin searchMakanan()" << endl;        
    cout << "void draw()" << endl;
    cout << "void makan(Coin foo)" << endl;
    cout << "void setPosition(int x, int y)" << endl;
}