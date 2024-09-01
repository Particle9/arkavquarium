package point;



public class Point {
  protected double x;
  protected double y;

  public Point() {
    x = 0;
    y = 0;
  }

  public Point(double _x, double _y) {
    x = _x;
    y = _y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(double _x) {
    x = _x;
  }

  public void setY(double _y) {
    y = _y;
  }

  public double getDistance(Point P) {
    double _x = x - P.x;
    double _y = y - P.y;
    return (Math.sqrt(_x*_x + _y*_y));
  }

  public Point add(final Point P) {
    Point result = new Point(x,y);
    result.x += P.x;
    result.y += P.y;
    return result;
  }

  public Point substract(final Point P) {
    Point result = new Point(x,y);
    result.x -= P.x;
    result.y -= P.y;
    return result;	
  }

  public Point increment() {
    Point result = new Point(this.x+1, this.y+1);
    return result;
  }

  public Point decrement() {
    Point result = new Point(this.x-1, this.y-1);
    return result;
  }

  public Point multiply(double constant) {
    Point result = new Point(this.x*constant, this.y*constant);
    return result;
  }

  public boolean equals(Point P) {
    if ((x == P.x) && (y == P.y)) {
      return true;
    }
    return false;
  }
  
  public Point clone() {
    Point result = new Point(x,y);
    return result;
  }

}