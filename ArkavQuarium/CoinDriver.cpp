#include "Coin.hpp"
#include "ObjekMati.hpp"
#include "Objek.hpp"
#include <iostream>
using namespace std;

int main() {
    Coin coin(500, Point(10,15), 1);

    // Pengujian method drown()
    coin.drown();
    cout << "Pos : (" << coin.getPoint().getX() << "," << coin.getPoint().getY() << ")" << endl;
}