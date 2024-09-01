#include "Objek.hpp"
#include "Point.hpp"
#include <iostream>
using namespace std;

int main() {
    cout << "ctor Objek with parameter (35,45)" << endl;
    Objek objek(Point(35, 45));
    cout << "pos : " << "(" << objek.getPoint().getX() << "," << objek.getPoint().getY() << ")" << endl;
    cout << "id : " << objek.getId() << endl;
    cout << "set pos to (5,6)" << endl;
    objek.setPoint(Point(5,6));
    cout << "pos : " << "(" << objek.getPoint().getX() << "," << objek.getPoint().getY() << ")" << endl;
    cout << "batas : " << "(" << objek.getBatas().getX() << "," << objek.getBatas().getY() << ")" << endl;
    cout << "set batas to (99,99)" << endl;
    Objek::setMaxPoint(Point(99,99));
    cout << "batas : " << "(" << objek.getBatas().getX() << "," << objek.getBatas().getY() << ")" << endl;
}