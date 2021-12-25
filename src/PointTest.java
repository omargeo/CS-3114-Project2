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
 * This class test the Point class
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 10.11.2021
 */
public class PointTest extends TestCase {
    /**
     * A field that holds the point
     */
    private Point point;
    
    /**
     * setup for the testing class
     */
    public void setUp() {
        point = new Point("AA", 1, 2);
    }
    
    /**
     * A method that tests the getName
     */
    public void testGetName() {
        assertEquals("AA", point.getName());
    }
    
    /**
     * A method that tests the getX
     */
    public void testGetX() {
        assertEquals(1, point.getX());
    }
    
    /**
     * A method that tests the getY
     */
    public void testGetY() {
        assertEquals(2, point.getY());
    }
    
    /**
     * A method that tests the getY
     */
    public void testToString() {
        assertEquals("(AA, 1, 2)", point.toString());
    }
}
