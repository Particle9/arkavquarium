#include <iostream>
#include "Objek.hpp"
using namespace std;

int main()  {
    // Objek(), Point getPoint(), getID()
    cout << "Objek()" << endl;
    Objek O1;
    cout << "id : " << O1.getId() << ", pos : " << O1.getPoint().getX() << " " << O1.getPoint().getY() <<endl;
    // Objek(Point P)
    cout << "Objek(Point P)" << endl;
    Point P1(10,20);
    Objek O2(P1);
    cout << "id : " << O2.getId() << ", pos : " << O2.getPoint().getX() << " " << O2.getPoint().getY() <<endl;
    // void setPoint(Point P)
    cout << "void setPoint(Point P)" << endl;
    O1.setPoint(P1);
    cout << "id : " << O1.getId() << ", pos : " << O1.getPoint().getX() << " " << O1.getPoint().getY() <<endl;
    // Point getBatas()
    cout << "Point getBatas()" << endl;
    cout << O1.getBatas().getX() << " " << O1.getBatas().getY() << endl;
    // bool operator==(Objek O)
    cout << "bool operator==(Objek O)" << endl;
    if (O1==O2) cout << "TRUE" << endl;
    else cout << "FALSE" << endl;
}