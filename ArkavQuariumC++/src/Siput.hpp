#ifndef SIPUT_H
#define SIPUT_H

#include <stdlib.h>
#include "Hewan.hpp"
#include "Coin.hpp"
#include "Point.hpp"
#include "oop.hpp"

class Siput : public Objek, public Hewan{
    protected:
        bool arah;
        int speed;
    public:
        Siput(){
        }
        Siput(char dir, int nx) : Objek(Point(nx,max.getY() -100)){
            arah = dir == 'R';
            speed = 2;
        }
        bool getArah()  {
            return arah;
        }
        int getSpeed()  {
            return speed;
        }
        void setArah(bool b)    {
            arah = b;
        }
        void setSpeed(int s)    {
            speed = s;
        }
        void turn(char c){
            arah = c == 'R';
        }
        void move(int p = 0){
            int x = pos.getX();
            if (!Coin::getActiveCoins().isEmpty()){
                Coin CC = searchMakanan();
                if(pos.getDistance(CC.getPoint()) < 60){
                     makan(CC);
                } 
                if (pos.getX() > CC.getPoint().getX()){
                    pos.setX(pos.getX() - speed);
                }
                else{
                    pos.setX(pos.getX() + speed);
                }
                arah = x < pos.getX();
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
        void makan(Coin foo){
            foo.addCollectedCoins();
            foo.removeFromList();
        }
        // void turn(char c){
        //     arah = c == 'R';
        // }
        void draw(){
            if (arah) draw_image("siput/snail_100_r.png", pos.getX(), pos.getY());
            else draw_image("siput/snail_100_l.png", pos.getX(), pos.getY());
        }
};

#endif
