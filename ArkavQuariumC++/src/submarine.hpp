#include "Objek.hpp"
#include "oop.hpp"
#include "Coin.hpp"
#include "Point.hpp"
#include "List.hpp"
#include <stdlib.h>
#include <math.h>

#ifndef __SUBMARINE__
#define __SUBMARINE__

class Submarine : public Objek{
    protected :
        static const int speed = 5;
        std::string image;
        bool arah;
    public :
        Submarine(){}
        Submarine(int x,int y) : Objek(Point(x,y)){
        }

        void move(int x, int y){
            pos.setX(pos.getX() + x*speed);
            pos.setY(pos.getY() + y*speed);
            if(x != 0) arah = x >0;
            if(Coin::getActiveCoins().isEmpty()) return;
            Coin CC = searchMakanan();
            if(pos.getDistance(CC.getPoint()) < 50){
                 makan(CC);
            }
        }

        Coin searchMakanan(){
            List<Coin> listMakanan;
            listMakanan = Coin::getActiveCoins();
            Coin minFood = listMakanan.get(1);
            int minDis;
            minDis = pos.getDistance(minFood.getPoint());
            if (listMakanan.isOneElmt()) return minFood;
            int nsize = listMakanan.size();
            for(int i  = 2; i < nsize; i++){
                Coin tempFood = listMakanan.get(i);
                if(minDis > pos.getDistance(tempFood.getPoint())){
                    minDis = pos.getDistance(tempFood.getPoint());
                    minFood = tempFood;
                }
            }
            return minFood;
        }

        
        void draw(){
            if (arah) draw_image("submarine.png", pos.getX(), pos.getY());
            else draw_image("submarineL.png", pos.getX(), pos.getY());
        }

        void makan(Coin foo){
            foo.addCollectedCoins();
            foo.removeFromList();
        }

        void setPosition(int x, int y){
            pos = Point(x,y);
        }

};

#endif