#include "ObjekMati.hpp"
#include <iostream>
using namespace std;

int main() {
    cout << "ctor ObjekMati with parameter Point(14,32)" << endl;
    ObjekMati objekMati(Point(14,32));
    cout << "pos : " << "(" << objekMati.getPoint().getX() << "," << objekMati.getPoint().getY() << ")" << endl;
    cout << "id : " << objekMati.getId() << endl;
    cout << "drown speed : " << objekMati.getDrownSpeed() << endl;
    cout << "run method drown() twice" << endl;
    objekMati.drown();
    objekMati.drown();
    cout << "pos : " << "(" << objekMati.getPoint().getX() << "," << objekMati.getPoint().getY() << ")" << endl;
}