#include <iostream>
#include "Siput.hpp"
#include "Coin.hpp"
using namespace std;

int main()  {
    cout << "Siput()" << endl;
    Siput S1;
    cout << "arah:" << S1.getArah() << ", speed:" << S1.getSpeed() << endl;
    cout << "Siput(char dir, int nx) : Objek(Point(nx,max.getY() -100))" << endl;
    Siput S2('R', 100);
    cout << "arah:" << S2.getArah() << ", pos:" << S2.getPoint().getX() << " " << S2.getPoint().getY() << endl;    
    cout << "void move()" << endl;
    Coin C1(100, 1);
    S2.move();
    cout << "arah:" << S2.getArah() << ", pos:" << S2.getPoint().getX() << " " << S2.getPoint().getY() << endl;
    cout << "Coin searchMakanan()" << endl;
    Coin coin = S2.searchMakanan();
    cout << "pos : " << "(" << coin.getPoint().getX() << "," << coin.getPoint().getY() << ")" << endl;
    cout << "id : " << coin.getId() << endl;
    cout << "drown speed : " << coin.getDrownSpeed() << endl;
    cout << "value : " << coin.getValue() << endl;
    cout << "Set Value to 15" << endl;
    cout <<  "void makan(Coin foo)" << endl;
    cout << "Collected Coin : " << Coin::getCollectedCoins() << endl;
    cout << "Add collected coin with value " << coin.getValue() << endl;
    coin.addCollectedCoins();
    cout << "Collected Coin : " << Coin::getCollectedCoins() << endl;
}