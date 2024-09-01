#include <iostream>
#include "ObjekMati.hpp"
#include "List.hpp"
#include "oop.hpp"

#ifndef _FISHFOOD_
#define _FISHFOOD_


class FishFood : public ObjekMati{
    protected:
        static List<FishFood> listFood;
        static int foodlvl;
    public :
        FishFood(){
        }
        FishFood(Point p) : ObjekMati(p){
            listFood.add(*this);
        }
        static void setFoodLvl(int m){
            FishFood::foodlvl = m;
        }
        static int getFoodLvl(){
            return (FishFood::foodlvl);
        }
        static void incFoodLvl(){
            FishFood::foodlvl++;
        }
        void removeFromList(){
            listFood.remove(*this);
        }
        static List<FishFood> getFoodList(){
            return(listFood);
        }
        void draw(){
            draw_image("food/food_20.png", pos.getX(), pos.getY());
        }
        void drown(){
            if (pos.getY() < max.getY() -100){
                ObjekMati::drown();
            }
            else{
                listFood.remove(*this);
                delete [] this;
            }
        }
};

List<FishFood> FishFood::listFood = List<FishFood>();
int FishFood::foodlvl = 1;
#endif
