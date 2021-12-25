import student.TestCase;

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
 * This class tests the fly node class
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 10.11.2021
 */
public class FlyNodeTest extends TestCase {
    
    /**
     * A field that holds the flyNode
     */
    private FlyNode flyNode;
    
    /**
     * setup for the testing class
     */
    public void setUp() {
        flyNode = new FlyNode();
    }
    
    /**
     * A method to test Dump
     */
    public void testDump() {
        flyNode.dump(0, 0, 1024, 1);
        
        assertEquals("  Node at 0, 0, 1024: Empty\n", systemOut().getHistory());
    }
    
    /**
     * A method to test Remove
     */
    public void testRemove() {
        assertEquals(flyNode, flyNode.remove(null, 0, 0, 0));
    }
    
    /**
     * A method that test insert
     */
    public void testInsert() {
        Point point = new Point("test", 0, 0);
        
        flyNode.insert(point, 0, 0, 1024).dump(0, 0, 1024, 1);
        assertEquals("  Node at 0, 0, 1024:\n  "
            + "(test, 0, 0)\n", systemOut().getHistory());
        flyNode.duplicates();
    }
}
