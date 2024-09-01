#include "Ikan.hpp"
#include "List.hpp"
#include "Point.hpp"
#include "ObjekMati.hpp"
#include "FishFood.hpp"
#include "Coin.hpp"
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include "oop.hpp"

#ifndef _GUPPY_
#define _GUPPY_

class Guppy : public Ikan{
    protected:
        static List<Guppy> listLivingGuppy;
        static const double speed;
        int goldTimer;
    public:
        Guppy(){
            level = 1;
        }
        Guppy(Point npos, int nLevel =1, char c = 'R', int fooe =0) : Ikan(nLevel,npos,c,fooe){
            listLivingGuppy.add(*this);
            goldTimer = 0;
            // srand(time(NULL));
            // if (c == 'R') dirDeg = rand() %45;
            // else dirDeg = rand() % (45) +270;
        }

        void decreaseHealth(){
            if (health < 1){
                listLivingGuppy.remove(*this);
                delete [] this;
            }
            else if(health < hungerPercent*getMaxHealth()){
                health -= 1;
                hungerStat = true;
            }
            else{
                health -= 1;
                hungerStat = false;
            }
        }

        void removeFromList(){
            listLivingGuppy.remove(*this);
        }
        //Prekondisi Tersedia Makanan di Aquarium
        FishFood searchMakanan(){
            List<FishFood> listMakanan;
            listMakanan.clone(FishFood::getFoodList());
            FishFood minFood = listMakanan.get(1);
            int minDis = pos.getDistance(minFood.getPoint());
            if (listMakanan.isOneElmt()) return minFood;
            int nsize = listMakanan.size();
            for(int i  = 2; i < nsize; i++){
                FishFood tempFood = listMakanan.get(i);
                if(minDis > pos.getDistance(tempFood.getPoint())){
                    minDis = pos.getDistance(tempFood.getPoint());
                    minFood = tempFood;
                }
            }
            return minFood;
        }
        void normalMove(int dirDeg = 0){
            if (health % 75 == 0) {
                dirDegree = float((rand()%360));
                cout << dirDegree << endl;
                dirDegree = dirDegree*3.14159265/180;
                
            }
            int x = pos.getX();
            // if (pos.getY() > max.getY() - 40 ) yy = -1;
            // else if (pos.getY() < 40) yy = 1;
            // if (stateDirH == 'R') xx = 1;
            // else xx = -1;
            // pos.setX(pos.getX() + xx*abs(speed*cos((dirDeg)*3.14159265/180)));
            // pos.setY(pos.getY() + yy*abs(speed*sin((dirDeg)*3.14159265/180)));
            // float angle = atan2(pos.getY() - yy, pos.getX() - xx);
            if (pos.getX() < 40 || pos.getX() > (SCREEN_WIDTH - 40) || pos.getY() < 40 || pos.getY() > (SCREEN_HEIGHT-40)) {
                dirDegree = float((rand()%360));
                cout << dirDegree << endl;
                dirDegree = dirDegree*3.14159265/180;

            }

            pos.setX(pos.getX() - speed*cos(dirDegree));
            pos.setY(pos.getY() - speed*sin(dirDegree));
            if(pos.getX() > max.getX() - 40){
                stateDirH = 'L';  
            } 
            if(pos.getX() < 40 ){
                stateDirH = 'R';
            }
            if(pos.getY() > max.getY() - 40){
                stateDirV = 'T';
            }
            if(pos.getY() < 40 ){
                stateDirV = 'B';
            }
            arah = x < pos.getX();
        }
        void move(int dirDeg = 0){
            if(!hungerStat) normalMove();
            else{
                int x = pos.getX();
                FishFood FF;
                if (!FishFood::getFoodList().isEmpty()){
                    FF = searchMakanan();
                    if((pos.getDistance(FF.getPoint())) < 20) makan(FF);
                    else{
                        if(pos.getX() > FF.getPoint().getX()) stateDirH = 'L';
                        else stateDirH = 'R';
                        Point p1 = pos;
                        Point p2 = FF.getPoint();
                        float angle = atan2(p1.getY() - p2.getY(), p1.getX() - p2.getX());
                        pos.setX(pos.getX() - speed*cos(angle));
                        pos.setY(pos.getY() - speed*sin(angle));
                        arah = x <pos.getX();
                    } 
                }
                else normalMove();
            }
            goldTimer = (goldTimer + 1) % 500;
            decreaseHealth();
            if(goldTimer == 0) produceCoin(getPrice()/5);
        }
        void makan(FishFood food){
            food.removeFromList();
            health = getMaxHealth();
            if(food.getFoodLvl() == 1){
                foodEaten++;
            }
            else if (food.getFoodLvl() == 2){
                foodEaten+= 3;
            }
            else{
                foodEaten += 6;
            }
            if (foodEaten > foodRequired[level]) {
                foodEaten = 0;
                if (level < 3) {
                    ++ level;
                }
            }
            hungerStat = false;
        }
        void produceCoin(int price){
            Coin C(price,pos,level);
        }

        static List<Guppy> getGuppyList(){
            return(listLivingGuppy);
        }
        void draw(){
            if (level == 1) {
                if (arah) draw_image("fish/guppy_64_r.png", pos.getX(), pos.getY());
                else draw_image("fish/guppy_64_l.png",pos.getX(),pos.getY());    
            } else if (level == 2) {
                if (arah) draw_image("fish/guppy_82_r.png", pos.getX(), pos.getY());
                else draw_image("fish/guppy_82_l.png",pos.getX(),pos.getY());
            } else {
                if (arah) draw_image("fish/guppy_100_r.png", pos.getX(), pos.getY());
                else draw_image("fish/guppy_100_l.png",pos.getX(),pos.getY());
            }
            
        }
        static void drawAll(){
            listLivingGuppy.drawAll();
        }
};

List<Guppy> Guppy::listLivingGuppy = List<Guppy>();
const double Guppy::speed = 0.5;
#endif

