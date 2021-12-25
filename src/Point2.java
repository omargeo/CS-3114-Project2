import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
 * This class is associated with parsing
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version  2021.09.20
 */
public class Point2 {
    /**
     * A variable that holds the file
     */
    private static Scanner file;
    
    /**
     * A variable that holds the skipList
     */
    private QuadTree quadTree = new QuadTree();
    
    /**
     * A variable that holds the skipNode
     */
    private SkipList<String, Point> skipList = 
        new SkipList<String, Point>();

    /**
     * Constructor of the class
     */
    public Point2() {
//        quadTree = new QuadTree(); 
//        skipList = new SkipList<String, Point>();
    }
    
    /**
     * The main method of the project
     * @param args the input file 
     */
    public static void main(String[] args) {
        CommandFile projectRunner = new CommandFile();
        try {
            file = new Scanner(new File(args[0]));
            while (file.hasNextLine()) {
                String com = file.nextLine();
                projectRunner.run(com);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * A getter method for the quadTree
     * @return the internalNode
     */
    public QuadTree getQuadTree() {
        return quadTree;
    }

    /**
     * A getter method for the SkipList
     * @return the skipList
     */
    public SkipList<String, Point> getSkipList() {
        return skipList;
    }
}
