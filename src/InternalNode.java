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
 * This class manages the behavior of the internal Node
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 10.11.2021
 */
public class InternalNode extends QuadNode {
    
    /**
     * A field that holds the north west node
     */
    private QuadNode nw;
    
    /**
     * A field that holds the north east node
     */
    private QuadNode ne;
    
    /**
     * A field that holds the south west node
     */
    private QuadNode sw;
    
    /**
     * A field that holds the south east node
     */
    private QuadNode se;
    
    /**
     * Constructor of the class
     */
    public InternalNode() {
        nw = QuadTree.FLY;
        ne = QuadTree.FLY;
        sw = QuadTree.FLY;
        se = QuadTree.FLY;
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
        if (point.getX() <= x + (size / 2) && 
            point.getY() < y + (size / 2)) {
            //nw
            nw = nw.insert(point, x, y, size / 2);
        }
        else if ((point.getX() > x + (size / 2) && 
            point.getY() <= y + (size / 2)) || 
            (point.getX() == x + (size / 2) && 
            point.getY() == y + (size / 2))) {
            //ne;
            ne = ne.insert(point, x + (size / 2), y, size / 2);
        }
        else if (point.getX() < x + (size / 2) && 
            point.getY() >= y + (size / 2)) {
            //sw;
            sw = sw.insert(point, x, (y + size / 2), size / 2);
        }
        else if (point.getX() >= x + (size / 2) && 
            point.getY() > y + (size / 2)) {
            //se;
            se = se.insert(point, x + (size / 2), y + (size / 2), size / 2);
        }
        return this;
    }
    
    /**
     * gets the node size 
     * @return the number of nodes
     */
    public int getSize() {
        int size = 1;
        size += nw.getSize();
        size += ne.getSize();
        size += sw.getSize();
        size += se.getSize();
        return size;
    }
    
    /**
     * A helper method that returns the total number of points
     * and the nodes size
     * @param internalNode to be checked
     * @return the total number of points and the nodes size
     */
    private ArrayList<Integer> numPoints(InternalNode internalNode) {
        ArrayList<Integer> listInt = new ArrayList<Integer>(2);
        int pointSize = 0; //# of points
        int flag = 1; //1 if all the same 0 if not
        ArrayList<Point> list = new ArrayList<Point>();
        if (internalNode.nw instanceof LeafNode) {
            for (int i = 0; i < ((LeafNode)internalNode.nw).
                getList().size(); i++) {
                for (int j = 0; j < ((LeafNode)internalNode.nw).
                    getList().get(i).size(); j++) {
                    if (!list.contains(((LeafNode)internalNode.nw).
                        getList().get(i).get(j))) {
                        list.add(((LeafNode)internalNode.nw).
                            getList().get(i).get(j));
                        pointSize++; 
                        //((LeafNode)internalNode.nw).getList().size();
                    }
                }
            }
        }
        if (internalNode.ne instanceof LeafNode) {
            for (int i = 0; i < ((LeafNode)internalNode.ne).
                getList().size(); i++) {
                for (int j = 0; j < ((LeafNode)internalNode.ne).
                    getList().get(i).size(); j++) {
                    if (!list.contains(((LeafNode)internalNode.ne).
                        getList().get(i).get(j))) {
                        list.add(((LeafNode)internalNode.ne).
                            getList().get(i).get(j));
                        pointSize++; 
                         //((LeafNode)internalNode.ne).getList().size();
                    }
                }
            }
        }
        if (internalNode.sw instanceof LeafNode) {
            for (int i = 0; i < ((LeafNode)internalNode.sw).
                getList().size(); i++) {
                for (int j = 0; j < ((LeafNode)internalNode.sw).
                    getList().get(i).size(); j++) {
                    if (!list.contains(((LeafNode)internalNode.sw).
                        getList().get(i).get(j))) {
                        list.add(((LeafNode)internalNode.sw).
                            getList().get(i).get(j));
                        pointSize++; 
                        //= ((LeafNode)internalNode.sw).getList().size();
                    }
                }
            }
        }
        if (internalNode.se instanceof LeafNode) {
            for (int i = 0; i < ((LeafNode)internalNode.se).
                getList().size(); i++) {
                for (int j = 0; j < ((LeafNode)internalNode.se).
                    getList().get(i).size(); j++) {
                    if (!list.contains(((LeafNode)internalNode.se).
                        getList().get(i).get(j))) {
                        list.add(((LeafNode)internalNode.se).
                            getList().get(i).get(j));
                        pointSize++; 
                        //= ((LeafNode)internalNode.se).getList().size();
                    }
                }
            }
        }
        if (list.size() > 0) {
            Point p1 = list.get(0);
            for (int i = 0; i < list.size(); i++) {
                if (!(p1.equals(list.get(i)))) {
                    flag = 0;
                }
            }
        }
        
        listInt.add(0, pointSize);
        listInt.add(1, flag);
        return listInt;
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
        QuadNode quadNode = null;
        //Removing process
        if (point.getX() <= x + (size / 2) && 
            point.getY() < y + (size / 2)) {
            //nw = nw.remove(point, x, y, size / 2);
            nw = nw.remove(point, x, y, size / 2);
            quadNode = this;
        }
        if ((point.getX() >= x + (size / 2) && 
            point.getY() <= y + (size / 2)) || 
            (point.getX() == x + (size / 2) && 
            point.getY() == y + (size / 2))) {
                //ne = ne.remove(point, x + (size / 2), y, size / 2);
            ne = ne.remove(point, x + size / 2, y, size / 2);
            //quadNode = ne;
            quadNode = this;
        }
        if (point.getX() <= x + (size / 2) && 
            point.getY() > y + (size / 2)) {
            //sw = sw.remove(point, x, y + (size / 2), size / 2);
            sw = sw.remove(point, x, y + size / 2, size / 2);
            quadNode = sw;
            quadNode = this;
        }
        if (point.getX() > x + (size / 2) && 
            point.getY() > y + (size / 2)) {
            //se = se.remove(point, x + (size / 2), y + (size / 2), size / 2);
            se = se.remove(point, x + size / 2, y + size / 2, size / 2);
            //quadNode = se;
            quadNode = this;
        }
//        if (quadNode instanceof FlyNode) {
//            return quadNode;
//        }
        
        if (quadNode instanceof InternalNode) {
            int countFly = 0;
            if (((InternalNode)quadNode).nw instanceof FlyNode) {
                countFly++;
            }
            if (((InternalNode)quadNode).ne instanceof FlyNode) {
                countFly++;
            }
            if (((InternalNode)quadNode).sw instanceof FlyNode) {
                countFly++;
            }
            if (((InternalNode)quadNode).se instanceof FlyNode) {
                countFly++;
            }
            if (countFly == 4) {
                return new FlyNode();
            }
            if (countFly == 3) {
                if (((InternalNode)quadNode).nw instanceof LeafNode) {
                    quadNode = ((InternalNode)quadNode).nw;
                }
                else if (((InternalNode)quadNode).ne instanceof LeafNode) {
                    quadNode = ((InternalNode)quadNode).ne;
                }
                else if (((InternalNode)quadNode).sw instanceof LeafNode) {
                    quadNode = ((InternalNode)quadNode).sw;
                }
                else if (((InternalNode)quadNode).se instanceof LeafNode) {
                    quadNode = ((InternalNode)quadNode).se;
                }
                return quadNode;
            }
            ArrayList<Integer> pointsList = numPoints((InternalNode)quadNode);
            int numberPoints = pointsList.get(0);
            int flag = pointsList.get(1);
            if (numberPoints <= 3 || (numberPoints > 3 && flag == 1)) {
                LeafNode leafNode = new LeafNode();
                if (((InternalNode)quadNode).nw instanceof LeafNode) {
                    LeafNode nwO = (LeafNode)((InternalNode)
                        quadNode).nw;
                    ArrayList<ArrayList<Point>> listP = nwO.getList();
                    for (int i = 0; i < listP.size(); i++) {
                        for (int j = 0; j < listP.get(i).size(); j++) {
                            Point tempPoint = 
                                new Point(listP.get(i).get(j).getName(), 
                                listP.get(i).get(j).getX(), 
                                listP.get(i).get(j).getY());
                            leafNode.insert(tempPoint, 
                                tempPoint.getX(), tempPoint.getY(), size);
                        }
                    }
                }
                if (((InternalNode)quadNode).ne instanceof LeafNode) {
                    LeafNode neO = (LeafNode)((InternalNode)
                        quadNode).ne;
                    ArrayList<ArrayList<Point>> listP = neO.getList();
                    for (int i = 0; i < listP.size(); i++) {
                        for (int j = 0; j < listP.get(i).size(); j++) {
                            Point tempPoint = 
                                new Point(listP.get(i).get(j).getName(), 
                                listP.get(i).get(j).getX(), 
                                listP.get(i).get(j).getY());
                            leafNode.insert(tempPoint, 
                                tempPoint.getX(), tempPoint.getY(), size);
                        }
                    }
                }
                if (((InternalNode)quadNode).sw instanceof LeafNode) {
                    LeafNode swO = (LeafNode)((InternalNode)
                        quadNode).sw;
                    ArrayList<ArrayList<Point>> listP = swO.getList();
                    for (int i = 0; i < listP.size(); i++) {
                        for (int j = 0; j < listP.get(i).size(); j++) {
                            Point tempPoint = 
                                new Point(listP.get(i).get(j).getName(), 
                                listP.get(i).get(j).getX(), 
                                listP.get(i).get(j).getY());
                            leafNode.insert(tempPoint, 
                                tempPoint.getX(), tempPoint.getY(), size);
                        }
                    }
                }
                if (((InternalNode)quadNode).se instanceof LeafNode) {
                    LeafNode seO = (LeafNode)((InternalNode)
                        quadNode).se;
                    ArrayList<ArrayList<Point>> listP = seO.getList();
                    for (int i = 0; i < listP.size(); i++) {
                        for (int j = 0; j < listP.get(i).size(); j++) {
                            Point tempPoint = 
                                new Point(listP.get(i).get(j).getName(), 
                                listP.get(i).get(j).getX(), 
                                listP.get(i).get(j).getY());
                            leafNode.insert(tempPoint, 
                                tempPoint.getX(), tempPoint.getY(), size);
                        }
                    }
                }
                quadNode = leafNode;
                return quadNode;
            }
        }
        return this;
    }

    /**
     * A method that checks for rectangles within a specific region
     * @param xP coordinate of the subtree
     * @param yP coordinate of the subtree
     * @param x coordinate of the rectangle
     * @param y coordinate of the rectangle
     * @param w coordinate of the rectangle
     * @param h coordinate of the rectangle
     * @return s how many nodes we visited
     */
    @Override
    public int regionsearch(int xP, int yP, 
        int x, int y, int w, int h, int size) {
        int s = 0;
        if (intersect(xP, yP, x, y, w, h, size)) {
            //nw
            s += nw.regionsearch(xP, yP, x, y, w, h, size);
            s++;
        }
        if (intersect(xP + size / 2, yP + size / 2, 
            x, y, w, h, size / 2)) {
            //ne
            s += ne.regionsearch(xP + size / 2, yP + size / 2, 
                x, y, w, h, size / 2);
            s++;
        }
        if (intersect(xP, yP + size / 2, 
            x, y, w, h, size / 2)) {
            //sw
            s += sw.regionsearch(xP, yP + size / 2, 
                x, y, w, h, size / 2);
            s++;
        }
        if (intersect(xP + size / 2, yP + size / 2,
            x, y, w, h, size / 2)) {
            //se
            s += se.regionsearch(xP + size / 2, yP + size / 2, 
                x, y, w, h, size / 2);
            s++;
        }
        return s;
    }
    
    /**
     * Checks if the rectangle intersect with the subtree
     * @param xP coordinate of the subtree
     * @param yP coordinate of the subtree
     * @param x coordinate of the rectangle
     * @param y coordinate of the rectangle
     * @param w coordinate of the rectangle
     * @param h coordinate of the rectangle
     * @param size of the tree
     * @return boolean true if it intersects false otherwise
     */
    private boolean intersect(int xP, int yP,
        int x, int y, int w, int h, int size) {
        int wP = size;
        int hP = size;
        return (x < xP + wP && y < yP + hP 
            && x + w > xP && y + h > yP) || (xP == x && yP == y);
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
        System.out.println(space + "Node at " + x + 
            ", " + y + ", " + size + ": " + "Internal");
        nw.dump(x, y, size / 2, level + 1);
        ne.dump(x + (size / 2), y, size / 2, level + 1);
        sw.dump(x, y + (size / 2), size / 2, level + 1);
        se.dump(x + (size / 2), y + (size / 2), size / 2, level + 1);
    }
    
    /**
     * Prints every duplicate point
     */
    @Override
    public void duplicates() {
        nw.duplicates();
        ne.duplicates();
        sw.duplicates();
        se.duplicates();
    }

    /**
     * A getter method for the nw
     * @return the nw
     */
    public QuadNode getNw() {
        return nw;
    }

    /**
     * A getter method for the ne
     * @return the ne
     */
    public QuadNode getNe() {
        return ne;
    }

    /**
     * A getter method for the sw
     * @return the sw
     */
    public QuadNode getSw() {
        return sw;
    }

    /**
     * A getter method for the se
     * @return the se
     */
    public QuadNode getSe() {
        return se;
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
        Point p1 = null;
        if (x <= xP + (size / 2) && 
            y < yP + (size / 2)) {
            //nw
            p1 = nw.search(x, y, xP, yP, size / 2);
        }
        if ((x > xP + (size / 2) && 
            y <= yP + (size / 2)) || 
            (x == xP + (size / 2) && 
                y == yP + (size / 2))) {
            //ne;
            p1 = ne.search(x, y, xP + (size / 2), yP, size / 2);
        }
        if (x < xP + (size / 2) && 
            y >= yP + (size / 2)) {
            //sw;
            p1 = sw.search(x, y, xP, (yP + size / 2), size / 2);
        }
        if (x >= xP + (size / 2) && 
            y > yP + (size / 2)) {
            //se;
            p1 = se.search(x, y, 
                xP + (size / 2), yP + (size / 2), size / 2);
        }
        return p1;
    }
}
