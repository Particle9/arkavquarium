#include <iostream>
#include "Point.hpp"
#include "Objek.hpp"
using namespace std;

#ifndef _HEWAN_
#define _HEWAN_

//INTERFACE
class Hewan{
    public:
        //Method Makan (Pure Virtual) sesuai dengan jenis ikannya
        virtual void move(int ) = 0;
        virtual void turn(char) = 0;
};

#endif