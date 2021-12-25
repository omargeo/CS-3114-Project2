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
 * This class controls the behavior of QuadTree
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version  2021.09.20
 */
public class QuadTree {
    
    /**
     * a fly Node field
     */
    public static final FlyNode FLY = new FlyNode();
    
    /**
     * A variable that holds the head
     */
    private QuadNode root;
    
    
    /**
     * constructor of the class
     */
    public QuadTree() {
        root = FLY;
    }
    
    /**
     * Insert method to insert a point
     * @param point to be removed
     * @param x coordinate
     * @param y coordinate
     * @param size of the width
     */
    public void insert(Point point, int x, int y, int size) {
        root = root.insert(point, 0, 0, 1024);
    }
    
    /**
     * A method that reports all the duplicate points
     */
    public void duplicates() {
        root.duplicates();
    }
    
    /**
     * Prints every point that is part of the database
     */
    public void dump() {
        System.out.println("QuadTree dump:");
        root.dump(0, 0, 1024, 0);
        System.out.println("" + getSize() + " quadtree nodes printed");
    }
    
    /**
     * gets the node size 
     * @return the number of nodes
     */
    public int getSize() {
        int size = 0;
        size += root.getSize();
        return size;
    }
    
    /**
     * Remove method to remove a point
     * @param point to be removed
     * @param x coordinate
     * @param y coordinate
     * @param size of the width
     */
    public void remove(Point point, int x, int y, int size) {
        root = root.remove(point, 0, 0, 1024);
    }

    /**
     * A getter method for the root
     * @return the root
     */
    public QuadNode getRoot() {
        return root;
    }
    
    /**
     * A method that checks for rectangles within a specific region
     * @param x coordinate
     * @param y coordinate
     * @param w coordinate
     * @param h coordinate
     * @return the point that fall under the region
     */
    public int regionsearch(int x, int y, int w, int h) {
        int size = 0;
        size += root.regionsearch(0, 0, x, y, w, h, 1024);
        return size;
    }
    
    /**
     * search method based on coordinates
     * @param x coordinate
     * @param y coordinate
     * @return the found point
     */
    public Point search(int x, int y) {
        return root.search(x, y, 0, 0, 1024);
    }
}
