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
 * Abstract class to control how the nodes behave in this project
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 10.11.2021
 */
public abstract class QuadNode {
    
    /**
     * Insert method to insert a point
     * @param point to be removed
     * @param x coordinate
     * @param y coordinate
     * @param size of the width
     * @return QuadNode
     */
    public abstract QuadNode insert(Point point, int x, int y, int size);
    
    /**
     * Remove method to remove a point
     * @param point to be removed
     * @param x coordinate
     * @param y coordinate
     * @param size of the width
     * @return QuadNode
     */
    public abstract QuadNode remove(Point point, int x, int y, int size);
    
    /**
     * Prints every point that is part of the database
     * @param x coordinate
     * @param y coordinate
     * @param size of the width
     * @param level is the level of the node
     */
    public abstract void dump(int x, int y, int size, int level);
    
    /**
     * Prints every duplicate point
     */
    public abstract void duplicates();
    
    /**
     * A method that checks for rectangles within a specific region
     * @param xP coordinate
     * @param yP coordinate
     * @param x coordinate
     * @param y coordinate
     * @param w coordinate
     * @param h coordinate
     * @param size coordinate
     * @return int which is a number of nodes visited
     */
    public abstract int regionsearch(int xP, int yP, 
        int x, int y, int w, int h, int size);

    /**
     * gets the node size 
     * @return the number of nodes
     */
    public abstract int getSize();

    /**
     * search method based on coordinates
     * @param xP point x coordinate
     * @param yP point y coordinate
     * @param x coordinate
     * @param y coordinate
     * @param size to be used
     * @return the found quadnode
     */
    public abstract Point search(int x, int y, int xP, int yP, int size);
}
