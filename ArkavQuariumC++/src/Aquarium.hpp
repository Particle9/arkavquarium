
#include "Objek.hpp"
#include "Coin.hpp"
#include "Guppy.hpp"
#include "Piranha.hpp"
#include "Siput.hpp"
#include "FishFood.hpp"
#include "submarine.hpp"
#include <iostream>

#ifndef _AQUARIUM_
#define _AQUARIUM_

class Aquarium{
    protected:
        // int coinScore;
        int eggState;
        // static const int foodUpPrice[];
        static const int eggPrice[];
        static const int foodPrice[];
    public:
        Siput Snaily;
        Submarine Sb;
        Aquarium(){
            Objek::setMaxPoint(Point(500,500));
            Guppy G(Point(250,250));
            Snaily = Siput('R',250);
            Sb = Submarine(250,250);
            //FishFood::setFoodLvl(1);
            eggState = 0;
        }
        Aquarium(int a , int b){
            Objek::setMaxPoint(Point(a,b));
            Guppy G(Point(a/2,b/2));
            Snaily = Siput('R',a/2);
            Sb = Submarine(a/2,b/2);
            //FishFood::setFoodLvl(1);
            eggState = 0;
        }
        // int getScore(){
        //     return(coinScore);
        // }
        // void setScore(int val){
        //     coinScore = val;
        // }
        // void increaseScore(int val){
        //     coinScore += val;
        // }
        int getEggState(){
            return(eggState);
        }
        void increaseEggState(){
            eggState += 1;
        }
        int getCurrEggPrice(){
            return(eggPrice[eggState + 1]);
        }
        int getCurrFoodPrice(){
            return(foodPrice[FishFood::getFoodLvl()]);
        }
        // int getFoodUpPrice(){
        //     return(foodUpPrice[FishFood::getFoodLvl() + 1]);
        // }
        // void upgradeFood(){
        //     FishFood::incFoodLvl();
        // }
        // void printAquarium();
        // friend ostream& operator<<(ostream&, Aquarium&);
};


const int Aquarium::eggPrice[] = {0,2000,3000,4000};
// const int Aquarium::foodUpPrice[] = {0,300,400,500};
const int Aquarium::foodPrice[] = {0,15,10,5};

#endif