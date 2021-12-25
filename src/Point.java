/** 
 On my honor:

 - I have not used source code obtained from another student,
 or any other unauthorized source, either modified or
 unmodified.

 - All source code and documentation used in my program is
 either my original work, or was derived by me from the
 source code published in the textbook for this course.

 - I have not discussed coding details about this project with
 anyone other than the instructor, ACM/UPE tutors, programming 
 partner (if allowed in this class), or the TAs assigned to 
 this course. I understand that I may discuss the concepts
 of this program with other students, and that another student
 may help me debug my program so long as neither of us writes
 anything during the discussion or modifies any computer file
 during the discussion. I have violated neither the spirit nor
 letter of this restriction.
*/

/**
 * This class handles the behaviour of points
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 10.11.2021
 */
public class Point {
    /**
     * A variable that holds the name of the rectangle
     */
    private String name;
    
    /**
     * A variable that holds the x coordinate of the rectangle
     */
    private int x;
    
    /**
     * A variable that holds the y coordinate of the rectangle
     */
    private int y;
    
    /**
     * Class Constructor 
     * @param name the rectangle name
     * @param x coordinate
     * @param y coordinate
     */
    public Point(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    /**
     * A getter method for the name
     * @return the name of the rectangle
     */
    public String getName() {
        return name;
    }
    
    /**
     * A getter method for the x coordinate 
     * @return the x coordinate of the rectangle
     */
    public int getX() {
        return x;
    }
    
    /**
     * A getter method for the y coordinate 
     * @return the y coordinate of the rectangle
     */
    public int getY() {
        return y;
    }
    
    /**
     * A toString method for the rectangle
     * @return a String of the Rectangle
     */
    public String toString() {
        String string = String.format("(%s, %d, %d)", 
            getName(), getX(), getY());
        //String string = String.format("%d %d", getX(), getY());
        return string;
    }
}
