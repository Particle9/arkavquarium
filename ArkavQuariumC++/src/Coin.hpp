#include <iostream>
#include "ObjekMati.hpp"
#include "List.hpp"
#include "Point.hpp"
#include "oop.hpp"

#ifndef _COIN_
#define _COIN_

class Coin : public ObjekMati{
    protected:
        static List<Coin> listCoin;
        static int CollectedCoin; //Uang yang dikumpulkan Pemain
        int value;
        // int groundTimer;
        int cointype;
    public :
        Coin() : ObjekMati(Point(0,0)){
            value = 100;
            cointype = 1;
            // groundTimer = 0;
        }
        Coin(int val, int t) : ObjekMati(Point(0,0)){
            value = val;
            cointype = t;
            listCoin.add(*this);
            // groundTimer = 0;
        }
        Coin(int val, Point P, int t) : ObjekMati(P){
            value = val;
            cointype = t;
            listCoin.add(*this);
            // groundTimer = 0;
        }
        // ~Coin(){
        //    listCoin.remove(*this);
        // }
        void removeFromList(){
            listCoin.remove(*this);
        }
        static List<Coin> getActiveCoins(){
            return(listCoin);
        }
        int getValue(){
            return(value);
        }
        void setValue(int v){
            value = v;
        }
        void drown(){
            if (pos.getY() < max.getY() -100){
                ObjekMati::drown();
            }
            // else if(groundTimer >= 50){
            //     listCoin.remove(*this);
            //     delete [] this;
            // }
            // else{
            //     groundTimer++;
            // }
        }
        static int getCollectedCoins(){
            return(CollectedCoin);
        }
        void addCollectedCoins(){
            CollectedCoin += value;
        }
        void draw(){
            if (cointype == 1) draw_image("coin/bronzecoin_32.png", pos.getX(), pos.getY());
            else if (cointype == 2) draw_image("coin/silvercoin_32.png", pos.getX(), pos.getY());
            else if (cointype == 3) draw_image("coin/goldcoin_32.png", pos.getX(), pos.getY());
            else if (cointype == 4) draw_image("coin/diamond_32.png", pos.getX(), pos.getY());
        }
        static void decCollectedCoin(int val){
            CollectedCoin -= val;
        }
};

List<Coin> Coin::listCoin = List<Coin>();
int Coin::CollectedCoin = 0;
#endif