#include <iostream>
#include "Aquarium.hpp"

using namespace std;

int main()  {
    cout << "Aquarium()" << endl;
    Aquarium A1;
    cout << "Aquarium(int a , int b)" << endl;
    Aquarium A2(30,50);
    cout << "int getScore()" << endl;
    cout << "score :" << A1.getScore() << endl;
    cout << "void setScore(int val) *100" << endl;
    A1.setScore(100);
    cout << "score :" << A1.getScore() << endl;
    cout << "void increaseScore(int val) *50" << endl;
    A1.increaseScore(50);
    cout << "score :" << A1.getScore() << endl;
    cout << "int getEggState()" << endl;
    cout << "egg state:" << A1.getEggState() << endl;
    cout << "void increaseEggState()" << endl;
    A1.increaseEggState();
    cout << "egg state:" << A1.getEggState() << endl;
    cout << "int getCurrEggPrice()" << endl;
    cout << "cur egg price:" << A1.getCurrEggPrice() << endl;
    cout << "int getCurrFoodPrice()" << endl;
    cout << "cur food price:" << A1.getCurrFoodPrice() << endl;
    cout << "int getFoodUpPrice()" << endl;
    cout << "food up price:" << A1.getFoodUpPrice() << endl;
    cout << "void upgradeFood()" << endl;
    A1.upgradeFood();
    cout << "cur food price:" << A1.getCurrFoodPrice() << endl;
}