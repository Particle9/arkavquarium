package thing;

import point.Point;

public class Thing {
  protected static Point max;
  protected static int idList;
  protected int id;
  protected Point pos;

  static {
    idList = 0;
    max = new Point(500,500);
  }

  /** default constructor of class thing
   * return a thing with position (0,0) and unique ID.
   */
  public Thing() {
    pos = new Point();
    id = idList;
    ++idList;
  }

  /** constructor of class thing with parameter point p return a thing
   * with position p and a unique ID.
   * @param p location of the constructed object.
   */
  public Thing(Point p) {
    pos = p.clone();
    id = idList;
    ++idList;
  }

  /**
   * pos getter.
   * @return position of the Thing as Point
   */
  public Point getPoint() {
    return pos;
  }
  
  /**
   * idList getter.
   * @return idList
   */
  public static int getIdList() {
    return idList;
  }

  /**
   * id getter.
   * @return id
   */
  public int getId() {
    return id;
  }

  /**
   * pos setter.
   * @param p position of the Thing as Point
   */
  public void setPoint(Point p) {
    pos = p;
  }

  /**
   * max getter.
   * @return max as Point
   */
  public static Point getMax() {
    return max;
  }

  /**
   * max setter.
   * @param p max as Point
   */
  public static void setMax(Point p) {
    max = p;
  }

  /**
   * Compare two Things
   * @param t Thing that needs to be compared
   * @return true if id == t.id
   */
  public boolean equals(Thing t) {
    return (id == t.id);
  }
}