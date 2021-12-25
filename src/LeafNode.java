import java.util.ArrayList;

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
 * This class controls the behavior of the LeafNode
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 10.11.2021
 */
public class LeafNode extends QuadNode {

    /**
     * A field that holds the size
     */
    private int sizeN;
    
    /**
     * A field that holds the Points
     */
    private ArrayList<ArrayList<Point>> list;
//    /**
//     * a field that holds the coordinates
//     */
//    private Point point;
    
    /**
     * Constructor of the class
     * @param point is the point that will used
     */
    public LeafNode(Point point) {
        this();
        list.get(0).add(point);
    }
    
    /**
     * Constructor of the class
     */
    public LeafNode() {
        list = new ArrayList<ArrayList<Point>>(3);
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<Point>());
        }
    }
    
    /**
     * Getter method for the value
     * @return is the value of the node
     */
    public ArrayList<ArrayList<Point>> getList() {
        return list;
    }
    
    /**
     * A method that checks for rectangles within a specific region
     * @param x coordinate
     * @param y coordinate
     * @param w coordinate
     * @param h coordinate
     */
    @Override
    public int regionsearch(int xP, int yP, 
        int x, int y, int w, int h, int size) {
        for (int i = 0; i < getList().size(); i++) {
            for (int j = 0; j < getList().get(i).size(); j++) {
                if (recInt(getList().get(i).get(j), x, y, w, h)) {
                    System.out.println("Point found: ("
                        + getList().get(i).get(j).getName() + ", "
                        + getList().get(i).get(j).getX() + ", "
                        + getList().get(i).get(j).getY() + ")");
                }
            }
        }
        return 1;
    }
    
    /**
     * Checks if the rectangles intersect
     * @param rec rectangle
     * @param x coordinate
     * @param y coordinate
     * @return SkipNode
     */
    private boolean 
        recInt(Point point, int x, int y, int w, int h) {
        int xVar = point.getX();
        int yVar = point.getY();
        
//        return xP >= x && xP <= x &&
//            yP >= y && yP <= y;
            
        return x <= xVar && y <= yVar
            && x + w >= xVar && y + h >= yVar;
//        return x < xP && y < yP 
//            && x + w > xP && y + h > yP;
    }
    
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
        if (!split()) { //sizeN < 3
            for (int i = 0; i < getList().size(); i++) {
                ArrayList<Point> subList = getList().get(i);
                if (subList.size() != 0 && 
                    (subList.get(0).getX() == point.getX() && 
                        subList.get(0).getY() == point.getY())) {
                    subList.add(point);
                    return this;
                }
            }
            getList().get(sizeN).add(point);
            sizeN++;
            return this;
        }
        else {
            InternalNode internalNode = new InternalNode();
            //internalNode.insert(point, x, y, size);
            for (int i = 0; i < getList().size(); i++) {
                for (int j = 0; j < getList().get(i).size(); j++) {
                    Point p = getList().get(i).get(j);
                    internalNode.insert(p, x, y, size);
                }
            }
            internalNode.insert(point, x, y, size);
            return internalNode;
        }
    }
    
    /**
     * Decides if we split or not
     * @return boolean of true if we split false otherwise
     */
    private boolean split() {
        int totalNum = 0;
        for (int i = 0; i < getList().size(); i++) {
            for (int j = 0; j < getList().get(i).size(); j++) {
                totalNum++;
            }
        }
        return sizeN > 1 && totalNum >= 3;
//            return true;
//        }
//        return false;
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
        for (int i = 0; i < getList().size(); i++) {
            for (int j = 0; j < getList().get(i).size(); j++) {
                if ((getList().get(i).get(j).getX() == point.getX() && 
                    getList().get(i).get(j).getY() == point.getY()) &&
                    getList().get(i).get(j).getName().equals(point.getName())) {
                    getList().get(i).remove(j);
                    if (getList().get(i).size() == 0) {
                        sizeN--;
                    }
//                    return this;
                }
            }
        }
        if (sizeN == 0) {
            return new FlyNode();
        }
        return this;
    }
    
    /**
     * gets the node size 
     * @return the number of nodes
     */
    public int getSize() {
        return 1;
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
        int c = 0;
        String space = "";
        while (c < level) {
            space += "  ";
            c++;
        }
        System.out.println(space + "Node at "
            + x + ", " + y + ", " + size + ":");
        for (int i = 0; i < getList().size(); i++) {
            for (int j = 0; j < getList().get(i).size(); j++) {
                System.out.println(space + "("
                    + getList().get(i).get(j).getName() 
                    + ", " + getList().get(i).get(j).getX() 
                    + ", " + getList().get(i).get(j).getY() + ")");
            }
        }
    }
    
    /**
     * Prints every duplicate point
     */
    @Override
    public void duplicates() {
        String string = "";
        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).size() > 1) {
                System.out.println("(" + getList().get(i).get(0).getX() + 
                    ", " + getList().get(i).get(0).getY() + ")");
            }
        }
    }

    /**
     * search method based on coordinates
     * @param xP point x coordinate
     * @param yP point y coordinate
     * @param x coordinate
     * @param y coordinate
     * @param size
     * @return the found point
     */
    @Override
    public Point search(int x, int y, int xP, int yP, int size) {
        for (int i = 0; i < getList().size(); i++) {
            for (int j = 0; j < getList().get(i).size(); j++) {
                Point point = getList().get(i).get(j);
                if (point.getX() == x && point.getY() == y) {
                    return point;
                }
            }
        }
        return null;
    }

}
