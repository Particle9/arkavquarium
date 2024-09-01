#ifndef _PIRANHA_
#define _PIRANHA_

#include "Ikan.hpp"
#include "Guppy.hpp"
#include "Point.hpp"
#include "oop.hpp"

class Piranha : public Ikan{
    protected:
        static List<Piranha> listLivingPiranha;
        static const std::string imageR,imageL;
        static const double speed;
        int dirDeg;
    public:
        Piranha(){
        }
        Piranha(Point npos, int nLevel =1, char c = 'R', int fooe =0) : Ikan(nLevel,npos,c,fooe){
            listLivingPiranha.add(*this);
        }
        void removeFromList(){
            listLivingPiranha.remove(*this);
        }
        //Prekondisi Tersedia Makanan di Aquarium
        Guppy searchMakanan(){
            List<Guppy> listMakanan;
            listMakanan.clone(Guppy::getGuppyList());
            Guppy minFood = listMakanan.get(1);
            int minDis = pos.getDistance(minFood.getPoint());
            if (listMakanan.isOneElmt()) return minFood;
            int nsize = listMakanan.size();
            for(int i  = 2; i < nsize; i++){
                Guppy tempFood = listMakanan.get(i);
                if(minDis > pos.getDistance(tempFood.getPoint())){
                    minDis = pos.getDistance(tempFood.getPoint());
                    minFood = tempFood;
                }
            }
            return minFood;
        }
        void normalMove(int dirDeg = 0){
            int x = pos.getX();
            if (health % 300 == 0) {
                dirDegree = float((rand()%360));
                cout << dirDegree << endl;
                dirDegree = dirDegree*3.14159265/180;
            }
            if (pos.getX() < 40 || pos.getX() > (SCREEN_WIDTH - 40) || pos.getY() < 40 || pos.getY() > (SCREEN_HEIGHT-40)) {
                dirDegree = float((rand()%360));
                cout << dirDegree << endl;
                dirDegree = dirDegree*3.14159265/180;   
            }
            pos.setX(pos.getX() - speed*cos(dirDegree));
            pos.setY(pos.getY() - speed*sin(dirDegree));
            if(pos.getX() > max.getX()){
                stateDirH = 'L';  
            } 
            if(pos.getX() < 0 ){
                stateDirH = 'R';
            }
            arah = x < pos.getX();
        }
        void move(int dirDeg = 0){
            if(!hungerStat) normalMove();
            else{
                int x = pos.getX();
                Guppy FF;
                if (!Guppy::getGuppyList().isEmpty()){
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
            decreaseHealth();
        }
        void makan(Guppy food){
            int foodprice = food.getPrice();
            int foodlevel = food.getLevel();
            food.removeFromList();
            health = getMaxHealth();
            foodEaten ++;
            hungerStat = false;
            produceCoin(price[level]*10/5);
        }

        int getMaxHealth(){
            return(Ikan::getMaxHealth()*3);
        }

        void decreaseHealth(){
            if (health < 1){
                listLivingPiranha.remove(*this);
                delete[] this;
            }
            else if(health < hungerPercent*getMaxHealth()){
                health -= 2;
                hungerStat = true;
            }
            else{
                health -= 2;
                hungerStat = false;
            }
        }

        int getPrice(){
            return(Ikan::getPrice() *10);
        }
        void produceCoin(int price){
            Coin C(price,pos,4);
        }
        static List<Piranha> getListPiranha(){
            return listLivingPiranha;
        }
        void draw(){

            if (arah) draw_image("fish/piranha_128_r.png", pos.getX(), pos.getY());
            else draw_image("fish/piranha_128_l.png",pos.getX(),pos.getY());
        }
        static int getDefaultPrice(){
            return(Ikan::getDefaultPrice() * 10);
        }
};

const double Piranha::speed = 1;
const std::string Piranha::imageR = "PiranhaR.png";
const std::string Piranha::imageL = "PiranhaL.png";
List<Piranha> Piranha::listLivingPiranha = List<Piranha>();

#endif
