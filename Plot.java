/*
 * Class: CMSC203 
 * Instructor: Prof. Tarek
 * Description: This program is designed to manage properties for a management company. It includes classes to handle various entities like properties, plots, and the management company itself, with a graphical user interface (GUI) using JavaFX for input and output. Property class represents individual properties, storing information like property name, city, rent amount, owner, and plot dimensions.
 * Due: October 29, 2024
 * Platform/compiler: Eclipse
	 * I pledge that I have completed the programming assignment independently. 
	 * I have not copied the code from a student or any source. 
	 * I have not given my code to any student.
   Print your Name here: Ash Ibasan
*/

package afour;

public class Plot {
    private int x, y;
    private int width, depth;

        // default constructor
        public Plot() {
            this.x = 0;
            this.y = 0;
            this.width = 1;
            this.depth = 1;
        }

        // parameterized constructor
        public Plot(int x, int y, int width, int depth) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.depth = depth;
        }

        // copy constructor
        public Plot(Plot otherPlot) {
            this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
        }

        // getters and setters
        public int getX() { return x; }
        public void setX(int x) { this.x = x; }
        public int getY() { return y; }
        public void setY(int y) { this.y = y; }
        public int getWidth() { return width; }
        public void setWidth(int width) { this.width = width; }
        public int getDepth() { return depth; }
        public void setDepth(int depth) { this.depth = depth; }

        // checks if this plot overlaps with another plot
        public boolean overlaps(Plot plot) {
            return !(x + width <= plot.x || plot.x + plot.width <= x || y + depth <= plot.y || plot.y + plot.depth <= y);
        }

        // checks if this plot encompasses another plot
        public boolean encompasses(Plot plot) {
            return x <= plot.x && y <= plot.y &&
                   (x + width) >= (plot.x + plot.width) &&
                   (y + depth) >= (plot.y + plot.depth);
        }

        // toString method
        @Override
        public String toString() {
            return String.format("%d,%d,%d,%d", x, y, width, depth);
        }
    }