#include <iostream>
#include "Point.hpp"
using namespace std;


int main()  {
    // Point()
    cout << "Point()" << endl;
    Point P1;
    cout << "X: " << P1.getX() << ",Y : " << P1.getY() << endl;
    // Point(int nx, int ny)
    cout << "Point(int nx, int ny)" << endl;
    Point P2(50,100);
    cout << "X: " << P2.getX() << ",Y : " << P2.getY() << endl;
    // getX()
    cout << "getX()" << endl;
    cout << "P1.getX() : " << P1.getX() << "P2.getX() : " << P2.getX() << endl;
    // getY()
    cout << "getY()" << endl;
    cout << "P1.getY() : " << P1.getY() << "P2.getY() : " << P2.getY() << endl;
    // getDistance()
    cout << "getDistance()" << endl;
    cout << "Jarak P1 dan P2 : " << P1.getDistance(P2) << endl;
    // setX() dan setY()
    cout << "setX() dan setY()" << endl;
    P1.setX(100);
    P1.setY(150);
    cout << "X: " << P1.getX() << ",Y : " << P1.getY() << endl;
    // operator+(const Point& P)
    cout << "operator+(const Point& P)" << endl;
    P1+P2;
    cout << "X: " << P1.getX() << ",Y : " << P1.getY() << endl;
    // operator-(const Point& P)
    cout << "operator-(const Point& P)" << endl;
    P1-P2;
    cout << "X: " << P1.getX() << ",Y : " << P1.getY() << endl;
    // operator++()
    cout << "operator++()" << endl;
    P1.operator++();
    cout << "X: " << P1.getX() << ",Y : " << P1.getY() << endl;
    // operator--()
    cout << "operator--()" << endl;
    P1.operator--();
    cout << "X: " << P1.getX() << ",Y : " << P1.getY() << endl;
    // operator*(int k)
    cout << "operator*(int k)" << endl;
    P1 * 5;
    cout << "X: " << P1.getX() << ",Y : " << P1.getY() << endl;
    // operator=(const Point& P) dan operator==(const Point& P)
    cout << "operator=(const Point& P) dan operator==(const Point& P)" << endl;
    P1=P2;
    if (P1==P2) cout << "True" << endl; 
    else cout << "False" << endl;
}