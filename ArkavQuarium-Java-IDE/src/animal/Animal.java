package animal;

interface Animal {
  /**
   * Move towards a certain direction.
   */
  void move();
  
  /**
   * Switch direction.
   * @param c Direction
   */
  void turn(char c);
}