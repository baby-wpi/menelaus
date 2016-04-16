package menelaus.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by frankegan on 4/15/16.
 */
public class KabaSujiJPanel extends JPanel {
    /**
     * Define the start point for all panels that extend our class
     */
    public static final int START_X = 100;
    /**
     * Define the start point for all panels that extend our class
     */
    public static final int START_Y = 100;
    /**
     * Define the width for all panels that extend our class
     */
    public static final int WIDTH = 1000;
    /**
     * Define the height for all panels that extend our class
     */
    public static final int HEIGHT = 750;

    /**
     * Define a base class for all our panels to extend. Includes constants for defining panel sizes,
     * and methods for dragging views. Will be used for handling all mous events inside of panel and delegating them to
     * their respective controllers.
     */
    public KabaSujiJPanel() {
        setBounds(START_X, START_Y, WIDTH, HEIGHT);
        setBorder(new EmptyBorder(5, 5, 5, 5));
    }
}
