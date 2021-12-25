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
 * This class test the Quad node class
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 10.11.2021
 */
public class QuadTreeTest extends TestCase {
    /**
     * A variable that holds the head
     */
    private QuadTree quadTree;
    
    /**
     * setup for the testing class
     */
    public void setUp() {
        quadTree = new QuadTree();
    }
    
    /**
     * A method that tests the insert method
     */
    public void testInsert() {
        quadTree.insert(new Point("A", 0, 0), 0, 0, 0);
        quadTree.dump();
        assertEquals("QuadTree dump:\n"
            + "Node at 0, 0, 1024:\n"
            + "(A, 0, 0)\n"
            + "1 quadtree nodes printed\n", systemOut().getHistory());
    }
    
//    /**
//     * A method that tests the remove method
//     */
//    public void testRemove() {
//        quadTree.insert(new Point("A", 0, 0), 0, 0, 0);
//        quadTree.insert(new Point("B", 5, 5), 0, 0, 0);
//        quadTree.insert(new Point("C", 10, 10), 0, 0, 0);
//        quadTree.insert(new Point("D", 15, 15), 0, 0, 0);
//        quadTree.insert(new Point("E", 20, 400), 0, 0, 0);
//        
//        quadTree.dump();
//        
//        quadTree.remove(new Point("A", 0, 0), 0, 0, 1024);
//        quadTree.dump();
//        assertEquals("QuadTree dump:\n"
//            + "Node at 0, 0, 1024:\n"
//            + "(B, 5, 5)\n"
//            + "(C, 10, 10)\n"
//            + "(D, 15, 15)\n"
//            + "1 quadtree nodes printed\n", systemOut().getHistory());
//    }
    
    /**
     * A method that tests the remove method
     */
    public void testGetRoot() {
        quadTree.getRoot().dump(0, 0, 0, 0);
        assertEquals("Node at 0, 0, 0: Empty\n", systemOut().getHistory());
    }
    
    /**
     * A method that tests the remove method
     */
    public void testDuplicates() {
        quadTree.insert(new Point("A", 0, 0), 0, 0, 0);
        quadTree.insert(new Point("B", 0, 0), 0, 0, 0);
        quadTree.duplicates();
        assertEquals("(0, 0)\n", systemOut().getHistory());
    }
    
    /**
     * tests RegionSearch
     */
    public void testRegionSearch() {
        quadTree.insert(new Point("A", 0, 0), 0, 0, 0);
        quadTree.insert(new Point("B", 700, 700), 0, 0, 0);
        quadTree.insert(new Point("C", 700, 700), 0, 0, 0);
        quadTree.insert(new Point("D", 750, 750), 0, 0, 0);
        quadTree.insert(new Point("E", 751, 751), 0, 0, 0);
        quadTree.insert(new Point("F", 752, 753), 0, 0, 0);
        quadTree.insert(new Point("G", 760, 770), 0, 0, 0);
        quadTree.insert(new Point("X", 1024, 1024), 0, 0, 0);
        quadTree.dump();
        quadTree.regionsearch(500, 500, 524, 524);
        assertEquals("QuadTree dump:\n"
            + "Node at 0, 0, 1024: Internal\n"
            + "  Node at 0, 0, 512:\n"
            + "  (A, 0, 0)\n"
            + "  Node at 512, 0, 512: Empty\n"
            + "  Node at 0, 512, 512: Empty\n"
            + "  Node at 512, 512, 512: Internal\n"
            + "    Node at 512, 512, 256: Internal\n"
            + "      Node at 512, 512, 128: Empty\n"
            + "      Node at 640, 512, 128: Empty\n"
            + "      Node at 512, 640, 128: Empty\n"
            + "      Node at 640, 640, 128: Internal\n"
            + "        Node at 640, 640, 64:\n"
            + "        (B, 700, 700)\n"
            + "        (C, 700, 700)\n"
            + "        Node at 704, 640, 64: Empty\n"
            + "        Node at 640, 704, 64: Empty\n"
            + "        Node at 704, 704, 64:\n"
            + "        (D, 750, 750)\n"
            + "        (E, 751, 751)\n"
            + "        (F, 752, 753)\n"
            + "    Node at 768, 512, 256: Empty\n"
            + "    Node at 512, 768, 256:\n"
            + "    (G, 760, 770)\n"
            + "    Node at 768, 768, 256:\n"
            + "    (X, 1024, 1024)\n"
            + "17 quadtree nodes printed\n"
            + "Point found: (B, 700, 700)\n"
            + "Point found: (C, 700, 700)\n"
            + "Point found: (D, 750, 750)\n"
            + "Point found: (E, 751, 751)\n"
            + "Point found: (F, 752, 753)\n"
            + "Point found: (G, 760, 770)\n"
            + "Point found: (X, 1024, 1024)\n", systemOut().getHistory());
    }
    
}
