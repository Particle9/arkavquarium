#include <iostream>
#include "Point.hpp"
using namespace std;

#ifndef _OBJEK_
#define _OBJEK_

class Objek{
    protected:
        static Point max;
        static int idList;
        int id;
        Point pos;
    public:
        static void initializeMaxPoint(Point P){
            max = P;
        }
        Objek(){
            id = idList;
            idList++;
        }
        Objek(Point P){
            pos = P;
            id = idList;
            idList++;
        }
        Point getPoint(){
            return pos;
        }
        int getId() {
            return id;
        }
        void setPoint(Point P){
            pos = P;
        }
        Point getBatas(){
            return(max);
        }
        static void setMaxPoint(Point P){
            max = P;
        }
        bool operator==(Objek O){
            return(id == O.id);
        }
};
int Objek::idList = 0;
Point Objek::max = Point(500,500);

#endif