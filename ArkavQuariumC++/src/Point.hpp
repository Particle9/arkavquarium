#include <math.h>

#ifndef POINT_H
#define POINT_H

class Point{
    protected:
        double x,y;
    public:
        Point(){
            x = 0;
            y = 0;
        }
        Point(double nx, double ny){
            x = nx;
            y = ny;
        }
        double getX(){
            return(x);
        }
        double getY(){
            return(y);
        }
        double getDistance(Point P){
            double a = x- P.x;
            double b = y- P.y;
            return sqrt(a*a + b*b);
        }
        void setX(double nx){
            x = nx;
        }
        void setY(double ny){
            y = ny;
        }
        Point operator+(const Point& P){
            Point Pp(x,y);
            Pp.x += P.x;
            Pp.y += P.y;
            return(Pp);
        }
        Point operator-(const Point& P){
            Point Pp(x,y);
            Pp.x -= P.x;
            Pp.y -= P.y;
            return(Pp);
        }
        Point operator++(){
            x++;
            y++;
        }
        Point operator--(){
            x--;
            y--;
        }
        Point operator*(double k){
            x *= k;
            y *= k;
        }
        Point& operator=(const Point& P){
            x = P.x;
            y = P.y;
        }
        bool operator==(const Point& P){
            if(x != P.x) return false;
            if(y != P.y) return false;
            return true;
        }
};

#endif