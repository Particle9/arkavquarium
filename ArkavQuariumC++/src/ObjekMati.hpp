#include <iostream>
#include "Point.hpp"
#include "Objek.hpp"
using namespace std;

#ifndef _OBJEKMATI_
#define _OBJEKMATI_

class ObjekMati : public Objek{
    protected:
        static const double speedDrown;
    public:
        ObjekMati(){
        }
        ObjekMati(Point P):Objek(P){}
        static const double getDrownSpeed(){
            return(speedDrown);
        }
        virtual void drown(){
            pos.setY(pos.getY() + speedDrown);
        }
};

const double ObjekMati::speedDrown = 0.1;

#endif