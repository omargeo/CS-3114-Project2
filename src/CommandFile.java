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
 * The projectRunner class of this project
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 10.08.2021
 */
public class CommandFile {
    
    /**
     * A variable that holds the point
     */
    private Point2 point2 = new Point2();
    
    /**
     * the method that runs the project
     * @param args is the file 
     */
    public void run(String args) {
        String com = args;
        com = com.trim();
        String[] list = com.split("\\s+");
        if (list[0].equals("dump")) {
            point2.getSkipList().dump();
            point2.getQuadTree().dump();
        }
        else if (list[0].equals("insert")) {
            String name = list[1];
            int x = Integer.parseInt(list[2]);
            int y = Integer.parseInt(list[3]);
            if ((x >= 0 && x <= 1024) && (y >= 0 && y <= 1024)) {
                Point point = new Point(name, x, y);
                point2.getQuadTree().insert(point, x, y, 0);
                point2.getSkipList().insert(name, point);
                System.out.format("Point inserted: "
                    + "(%s, %d, %d)\n", name, x, y);
            }
            else {
                System.out.format("Point rejected: "
                    + "(%s, %d, %d)\n", name, x, y);
            }
        }
        else if (list[0].equals("remove")) {
            if (isNumeric(list[1])) {
                int x = Integer.parseInt(list[1]);
                int y = Integer.parseInt(list[2]);
                if (!((x >= 0 && x <= 1024) && (y >= 0 && y <= 1024))) {
                    System.out.format("Point not rejected: "
                        + "(%d, %d)\n", x, y);
                    return;
                }
 //               SkipNode<String, Point> sk = remove(x, y, w, h);
                
                Point point = point2.getQuadTree().search(x, y);
                if (point == null) {
                    System.out.format("Point not found: "
                        + "(%d, %d)\n", x, y); 
                }
                else {
                    point2.getQuadTree().remove(point, x, y, 1024);
                    point2.getSkipList().remove(point.getName());
                    System.out.format("Point removed: %s\n", 
                        point.toString());
                }
            }
            else {
                String name = list[1];
                SkipNode<String, Point> sk = 
                    point2.getSkipList().remove(name);
                if (sk == null) {
                    System.out.format("Point not removed: (%s)\n"
                        , name); 
                }
                else {
                    point2.getQuadTree().remove(sk.getValue(), 
                        sk.getValue().getX(), sk.getValue().getY(), 1024);
                    System.out.format("Point removed: %s\n", 
                        sk.toString());
                }
            }
        }
        else if (list[0].equals("search")) {
            String name = list[1];
            ArrayList<SkipNode<String, Point>> array = 
                point2.getSkipList().search(name);
            if (array != null) {
//                for (int i = 0; i < )
                for (int i = 0; i < array.size(); i++) {
                    System.out.println("Found (" + array.get(i).getKey() + ", "
                        + array.get(i).getValue().getX() + 
                        ", " + array.get(i).getValue().getY() + ")");
                }
            }
            else {
                System.out.println("Point not found: " + list[1]);
            }
        }
        else if (list[0].equals("regionsearch")) {
            int x = Integer.parseInt(list[1]);
            int y = Integer.parseInt(list[2]);
            int w = Integer.parseInt(list[3]);
            int h = Integer.parseInt(list[4]);
            if (!((w > 0) && (h > 0) && 
                (x + w > 0 && x < 1024) && 
                (y + h > 0 && y < 1024))) {
                System.out.print(String.format(
                    "Rectangle rejected: (%d, %d, %d, %d):\n", x, y, w, h));
                return;
            }
            System.out.print(String.format(
                "Points intersecting region (%d, %d, %d, %d):\n", x, y, w, h));
            int size = point2.getQuadTree().regionsearch(x, y, w, h);
            System.out.print(String.format(
                "%d quadtree nodes visited\n", size));
        }
        else if (list[0].equals("duplicates")) {
            System.out.println("Duplicate points:");
            point2.getQuadTree().duplicates();
        }
    }
    
    
//    /**
//     * Getter method for rectangle1
//     * @return rectangle1
//     */
//    public point2 getpoint2() {
//        return point2;
//    }
    
    /**
     * a private method that checks if the string is a number or not
     * @param str the String to be checked
     * @return a boolean true if its a string false otherwise
     */
    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;  
        }
    }
}
