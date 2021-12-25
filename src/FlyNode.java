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
 * Empty class that is Flyweight to avoid null pointer exceptions
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 10.11.2021
 */
public class FlyNode extends QuadNode {

    /**
     * Insert method to insert a point
     * @param point to be removed
     * @param x coordinate
     * @param y coordinate
     * @param size of the width
     * @return QuadNode
     */
    @Override
    public QuadNode insert(Point point, int x, int y, int size) {
        LeafNode leafNode = new LeafNode();
        leafNode.insert(point, x, y, size);
        return leafNode;
    }

    /**
     * Remove method to remove a point
     * @param point to be removed
     * @param x coordinate
     * @param y coordinate
     * @param size of the width
     * @return QuadNode
     */
    @Override
    public QuadNode remove(Point point, int x, int y, int size) {
        return this;
    }

    /**
     * Prints every point that is part of the database
     * @param x coordinate
     * @param y coordinate
     * @param size of the width
     * @param level is the level of the node
     */
    @Override
    public void dump(int x, int y, int size, int level) {
        int i = 0;
        String space = "";
        while (i < level) {
            space += "  ";
            i++;
        }
//        String spacessss = space + 
//            "Node at " + x + ", " + y + ", " + size + ": Empty";
        System.out.println(space + 
            "Node at " + x + ", " + y + ", " + size + ": Empty");
    }

    /**
     * Prints every duplicate point
     */
    @Override
    public void duplicates() { 
        //Needs to be empty because flynode is an abstract class
    }

    /**
     * A method that checks for rectangles within a specific region
     * @param x coordinate
     * @param y coordinate
     * @param w coordinate
     * @param h coordinate
     * @param size coordinate
     */
    @Override
    public int regionsearch(int xP, int yP, 
        int x, int y, int w, int h, int size) {
        return 0;
    }

    /**
     * gets the node size 
     * @return the number of nodes
     */
    @Override
    public int getSize() {
        return 1;
    }

    /**
     * search method based on coordinates
     * @param xP point x coordinate
     * @param yP point y coordinate
     * @param x coordinate
     * @param y coordinate
     * @param size
     * @return the found Point
     */
    @Override
    public Point search(int xP, int yP, int x, int y, int size) {
        return null;
    }
}
