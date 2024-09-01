#include <iostream>
#include "Point.hpp"
#include "List.hpp"
#include "Hewan.hpp"
using namespace std;

#ifndef _IKAN_
#define _IKAN_
class Ikan : public Hewan, public Objek{
    protected:
        static int const price[]; 
        static int const maxHealth[];
        static int const foodRequired[];
        static float const hungerPercent;
        int health, level;
        bool hungerStat;
        bool arah; //TRUE berarti menghadap ke kanan, False Berarti menghadap ke Kiri
        int foodEaten;
        char stateDirH, stateDirV;
        float dirDegree;
    public:
        //Constructor Default Ikan
        Ikan(){
            stateDirH = 'R';
            stateDirV = 'T';
            level = 0;
            health = maxHealth[1];
            arah = true;
            hungerStat = false;
            dirDegree = 0;
        }
        //User Defined Constructor Ikan
        Ikan(int nlevel, Point npos, char c, int fooe) : Objek(npos){
            level = nlevel;
            arah = c == 'R';
            health = maxHealth[level];
            foodEaten = fooe;
            stateDirH = arah;
            hungerStat = false;
            dirDegree = 0;
        }

        //Method menghadap
        void turn(char dir){
            if (dir == 'R') arah = true;
            else arah = false;
        }
        //Method Gerak dengan parameter arah
        
        virtual int getPrice(){
            return(price[level]);
        }
        //getter Level
        int getLevel(){
            return(level);
        }
        //getter Health
        int getHealth(){
            return(health);
        }
        //getter Status
        bool getArah(){
            return(arah);
        }
        //setter koin
        int getFoodRequired(){
            return(foodRequired[level]);
        }
        int getFoodEaten(){
            return(foodEaten);
        }
        int getHungerHealth(){
            return(hungerPercent*maxHealth[level]);
        }
        virtual int getMaxHealth(){
            return(maxHealth[level]);
        }
        //setter level
        void setLevel(int l){
            level = l;

        }
        static int getDefaultPrice(){
            return(price[1]);
        }
        //setter HP
        void setHealth(int h){
            health = h;
        }
        //setter Status
        void setArah(){
            arah = !arah;
        }
        void setFoodEaten(int s ){
            foodEaten = s;
        }
        //setter Makanan
        void levelUp(){
            level++;
        }
        virtual void produceCoin(int price) = 0;

};

const float Ikan::hungerPercent = 0.4;
const int Ikan::price[] = {0,100,200,300};
const int Ikan::maxHealth[] = {0,3000,3500,4500};
const int Ikan::foodRequired[] = {0,5,10,10000};

#endif
