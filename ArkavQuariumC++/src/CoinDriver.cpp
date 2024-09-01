#include "Coin.hpp"
#include <iostream>
using namespace std;

int main() {
    cout << "ctor Coin with parameter (100, 1)" << endl;
    Coin coin(100, 1);
    cout << "pos : " << "(" << coin.getPoint().getX() << "," << coin.getPoint().getY() << ")" << endl;
    cout << "id : " << coin.getId() << endl;
    cout << "drown speed : " << coin.getDrownSpeed() << endl;
    cout << "value : " << coin.getValue() << endl;
    cout << "Set Value to 15" << endl;
    coin.setValue(15);
    cout << "value : " << coin.getValue() << endl;
    cout << "Collected Coin : " << Coin::getCollectedCoins() << endl;
    cout << "Add collected coin with value " << coin.getValue() << endl;
    coin.addCollectedCoins();
    cout << "Collected Coin : " << Coin::getCollectedCoins() << endl;
    cout << "Dec collected coin by 4 " << endl;
    coin.decCollectedCoin(4);
    cout << "Collected Coin : " << Coin::getCollectedCoins() << endl;
    
}