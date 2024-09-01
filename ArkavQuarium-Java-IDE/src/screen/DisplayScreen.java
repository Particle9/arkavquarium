package screen;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class DisplayScreen extends JFrame {

  /**
   * Display Screen.
   * @param s Screen displayed
   */
  public DisplayScreen(Screen s) {

      initUI(s);
  }

  /**
   * Initializes UI
   * @param s Screen displayed
   */
  private void initUI(Screen s) {
      add(s);
      pack();
      
      setTitle("ArkavQuarium");
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}