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
 * This class tests the behavior of the internal node class
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 10.11.2021
 */
public class InternalNodeTest extends TestCase {
    /**
     * A field that holds the flyNode
     */
    private InternalNode internalNode;
    
    /**
     * setup for the testing class
     */
    public void setUp() {
        internalNode = new InternalNode();
    }
    
    /**
     * test the dump method
     */
    public void testDump() {
        internalNode.dump(0, 0, 512, 0);
        assertEquals("Node at 0, 0, 512: Internal\n"
            + "  Node at 0, 0, 256: Empty\n"
            + "  Node at 256, 0, 256: Empty\n"
            + "  Node at 0, 256, 256: Empty\n"
            + "  Node at 256, 256, 256: Empty\n", systemOut().getHistory());
    }
    
    /**
     * tests the insert Method
     */
    public void testInsert() {
        internalNode.insert(new Point("A", 0, 0), 0, 0, 512);
        internalNode.dump(0, 0, 512, 0);
        assertEquals("Node at 0, 0, 512: Internal\n"
            + "  Node at 0, 0, 256:\n"
            + "  (A, 0, 0)\n"
            + "  Node at 256, 0, 256: Empty\n"
            + "  Node at 0, 256, 256: Empty\n"
            + "  Node at 256, 256, 256: Empty\n", systemOut().getHistory());
    }
    
    /**
     * tests the insert Method
     */
    public void testInsert1() {
        internalNode.insert(new Point("A", 0, 0), 0, 0, 512);
        internalNode.insert(new Point("B", 900, 1), 0, 0, 1024);
        internalNode.insert(new Point("C", 1, 900), 0, 0, 1024);
        internalNode.insert(new Point("D", 700, 700), 0, 0, 1024);
        internalNode.insert(new Point("E", 512, 512), 0, 0, 1024);
        internalNode.insert(new Point("F", 512, 5), 0, 0, 1024);
        internalNode.insert(new Point("G", 5, 512), 0, 0, 1024);
        internalNode.insert(new Point("H", 1024, 1024), 0, 0, 1024);
        internalNode.dump(0, 0, 1024, 0);
        assertEquals("Node at 0, 0, 1024: Internal\n"
            + "  Node at 0, 0, 512:\n"
            + "  (A, 0, 0)\n"
            + "  (F, 512, 5)\n"
            + "  Node at 512, 0, 512:\n"
            + "  (B, 900, 1)\n"
            + "  (E, 512, 512)\n"
            + "  Node at 0, 512, 512:\n"
            + "  (C, 1, 900)\n"
            + "  (G, 5, 512)\n"
            + "  Node at 512, 512, 512:\n"
            + "  (D, 700, 700)\n"
            + "  (H, 1024, 1024)\n", systemOut().getHistory());
    }
    
    /**
     * tests the remove Method
     */
    public void testRemove() {
        internalNode.insert(new Point("A", 0, 0), 0, 0, 1024);
        Point pointA = new Point("A", 0, 0);
        internalNode.remove(pointA, 0, 0, 1024);
        
        Point pointB = new Point("B", 700, 5);
        Point pointC = new Point("C", 5, 700);
        Point pointD = new Point("D", 700, 700);
        
        internalNode.insert(new Point("A", 0, 0), 0, 0, 1024);
        internalNode.insert(new Point("B", 700, 5), 0, 0, 1024);
        internalNode.insert(new Point("C", 5, 700), 0, 0, 1024);
        internalNode.insert(new Point("D", 700, 700), 0, 0, 1024);
        
        internalNode.remove(pointA, 0, 0, 1024);
        internalNode.remove(pointB, 0, 0, 1024);
        internalNode.remove(pointC, 0, 0, 1024);
        QuadNode qN = internalNode.remove(pointD, 0, 0, 1024);
        
        //System.out.println("-------");
        qN.dump(0, 0, 1024, 0);
        assertEquals("Node at 0, 0, 1024: Empty\n", systemOut().getHistory());

        internalNode.dump(0, 0, 1024, 0);
        assertEquals("Node at 0, 0, 1024: Empty\n"
            + "Node at 0, 0, 1024: Internal\n"
            + "  Node at 0, 0, 512: Empty\n"
            + "  Node at 512, 0, 512: Empty\n"
            + "  Node at 0, 512, 512: Empty\n"
            + "  Node at 512, 512, 512: Empty\n", systemOut().getHistory());
    }
    
    /**
     * tests the remove Method
     */
    public void testRemove1() {
        internalNode.insert(new Point("A", 0, 0), 0, 0, 1024);
        internalNode.insert(new Point("B", 5, 5), 0, 0, 1024);
        internalNode.insert(new Point("C", 10, 10), 0, 0, 1024);
        internalNode.insert(new Point("D", 15, 15), 0, 0, 1024);
        internalNode.insert(new Point("E", 20, 400), 0, 0, 1024);
        
        QuadNode qN = internalNode.remove(new Point("A", 0, 0), 0, 0, 1024);
        qN.dump(0, 0, 1024, 0);
        assertEquals("Node at 0, 0, 1024: Internal\n"
            + "  Node at 0, 0, 512: Internal\n"
            + "    Node at 0, 0, 256:\n"
            + "    (B, 5, 5)\n"
            + "    (C, 10, 10)\n"
            + "    (D, 15, 15)\n"
            + "    Node at 256, 0, 256: Empty\n"
            + "    Node at 0, 256, 256:\n"
            + "    (E, 20, 400)\n"
            + "    Node at 256, 256, 256: Empty\n"
            + "  Node at 512, 0, 512: Empty\n"
            + "  Node at 0, 512, 512: Empty\n"
            + "  Node at 512, 512, 512: Empty\n", systemOut().getHistory());
        
    }
    
    /**
     * tests the remove Method
     */
    public void testRemove2() {
        internalNode.insert(new Point("A", 0, 0), 0, 0, 1024);
        internalNode.insert(new Point("B", 5, 5), 0, 0, 1024);
        internalNode.insert(new Point("C", 10, 10), 0, 0, 1024);
        internalNode.insert(new Point("D", 15, 15), 0, 0, 1024);
        internalNode.insert(new Point("E", 20, 400), 0, 0, 1024);
        
        QuadNode qN = internalNode.remove(new Point("A", 0, 0), 0, 0, 1024);
        qN.remove(new Point("B", 5, 5), 0, 0, 1024);
        qN.remove(new Point("C", 10, 10), 0, 0, 1024);
        qN.remove(new Point("D", 15, 15), 0, 0, 1024);
        qN = qN.remove(new Point("E", 20, 400), 0, 0, 1024);
        qN.dump(0, 0, 1024, 0);
        assertEquals("Node at 0, 0, 1024: Empty\n", systemOut().getHistory());
        
    }
    
    /**
     * tests the remove Method
     */
    public void testRemove3() {
        internalNode.insert(new Point("A", 0, 0), 0, 0, 1024);
        internalNode.insert(new Point("B", 0, 0), 0, 0, 1024);
        internalNode.insert(new Point("C", 0, 0), 0, 0, 1024);
        internalNode.insert(new Point("D", 0, 0), 0, 0, 1024);
        internalNode.insert(new Point("E", 0, 0), 0, 0, 1024);
        
        QuadNode qN = internalNode.remove(new Point("A", 0, 0), 0, 0, 1024);
        qN.remove(new Point("B", 0, 0), 0, 0, 1024);
        qN.remove(new Point("C", 0, 0), 0, 0, 1024);
        //qN.remove(new Point("D", 0, 0), 0, 0, 1024);
        qN = qN.remove(new Point("E", 0, 0), 0, 0, 1024);
        qN.dump(0, 0, 1024, 0);
        assertEquals("Node at 0, 0, 1024:\n"
            + "(D, 0, 0)\n", systemOut().getHistory());
        
    }
}
