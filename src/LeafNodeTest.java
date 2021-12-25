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
 * This class test the leaf node class
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version 10.11.2021
 */
public class LeafNodeTest extends TestCase {
    /**
     * A field that holds the LeafNode
     */
    private LeafNode leafNode;
    
    /**
     * setup for the testing class
     */
    public void setUp() {
        leafNode = new LeafNode();
    }
    
    /**
     * A method that tests the getList method
     */
    public void testGetList() {
        assertEquals("[[], [], []]", leafNode.getList().toString());
        Point point = new Point("AAA", 0, 0);
        leafNode.insert(point, 0, 0, 1024);
        assertEquals("[[(AAA, 0, 0)], [], []]", leafNode.getList().toString());
    }
    
    /**
     * A method that tests the insert
     */
    public void testRemove0() {
        QuadNode quadNode = leafNode.insert(new Point("AAA", 0, 0), 0, 0, 1024);
        assertEquals("[[(AAA, 0, 0)], [], []]", 
            leafNode.getList().toString());
        
        quadNode.insert(new Point("AA", 0, 0), 0, 0, 1024);
        assertEquals("[[(AAA, 0, 0), (AA, 0, 0)], "
            + "[], []]", leafNode.getList().toString());
        
        quadNode.insert(new Point("BB", 1, 0), 0, 0, 1024);
        assertEquals("[[(AAA, 0, 0), (AA, 0, 0)], "
            + "[(BB, 1, 0)], []]", leafNode.getList().toString());
        
        quadNode = quadNode.insert(new Point("CC", 0, 1), 0, 0, 1024);
        Point p = new Point("DD", 1024, 1024);
        quadNode.insert(p, 0, 0, 1024);
        
        
        quadNode.remove(new Point("AA", 0, 0), 0, 0, 1024);
        quadNode.remove(new Point("AAA", 0, 0), 0, 0, 1024);
        quadNode.remove(new Point("BB", 1, 0), 0, 0, 1024);
        quadNode = quadNode.remove(new Point("CC", 0, 1), 0, 0, 1024);
        //Point p = new Point("DD", 1024, 1024);
        quadNode = quadNode.remove(p, 0, 0, 1024);
        quadNode.dump(0, 0, 1024, 0);
        assertEquals("Node at 0, 0, 1024: Empty\n", systemOut().getHistory());
    }    
    /**
     * A method that tests the insert
     */
    public void testInsert() {
        QuadNode quadNode = leafNode.insert(new Point("AAA", 0, 0), 0, 0, 1024);
        assertEquals("[[(AAA, 0, 0)], [], []]", 
            leafNode.getList().toString());
        
        quadNode = leafNode.insert(new Point("AA", 0, 0), 0, 0, 1024);
        assertEquals("[[(AAA, 0, 0), (AA, 0, 0)], "
            + "[], []]", leafNode.getList().toString());
        
        quadNode = leafNode.insert(new Point("BB", 1, 0), 0, 0, 1024);
        assertEquals("[[(AAA, 0, 0), (AA, 0, 0)], "
            + "[(BB, 1, 0)], []]", leafNode.getList().toString());
        
        quadNode = leafNode.insert(new Point("CC", 0, 1), 0, 0, 1024);
        
//        assertEquals("[[(AAA, 0, 0), (AA, 0, 0)], "
//            + "[(BB, 1, 0)], [(CC, 0, 1)]]", leafNode.getList().toString());
        
        //qn.dump(0, 0, 0, 0);
        
//        assertEquals("[[(AAA, 0, 0), (AA, 0, 0)], "
//            + "[(BB, 1, 0)], [(CC, 0, 1)]]", systemOut().getHistory());
        
        //quadNode = leafNode.insert(new Point("DD", 0, 1), 0, 0, 1024);
        quadNode.dump(0, 0, 1024, 0);
        assertEquals("Node at 0, 0, 1024: Internal\n"
            + "  Node at 0, 0, 512: Internal\n"
            + "    Node at 0, 0, 256: Internal\n"
            + "      Node at 0, 0, 128: Internal\n"
            + "        Node at 0, 0, 64: Internal\n"
            + "          Node at 0, 0, 32: Internal\n"
            + "            Node at 0, 0, 16: Internal\n"
            + "              Node at 0, 0, 8: Internal\n"
            + "                Node at 0, 0, 4: Internal\n"
            + "                  Node at 0, 0, 2: Internal\n"
            + "                    Node at 0, 0, 1:\n"
            + "                    (AAA, 0, 0)\n"
            + "                    (AA, 0, 0)\n"
            + "                    (BB, 1, 0)\n"
            + "                    Node at 1, 0, 1: Empty\n"
            + "                    Node at 0, 1, 1:\n"
            + "                    (CC, 0, 1)\n"
            + "                    Node at 1, 1, 1: Empty\n"
            + "                  Node at 2, 0, 2: Empty\n"
            + "                  Node at 0, 2, 2: Empty\n"
            + "                  Node at 2, 2, 2: Empty\n"
            + "                Node at 4, 0, 4: Empty\n"
            + "                Node at 0, 4, 4: Empty\n"
            + "                Node at 4, 4, 4: Empty\n"
            + "              Node at 8, 0, 8: Empty\n"
            + "              Node at 0, 8, 8: Empty\n"
            + "              Node at 8, 8, 8: Empty\n"
            + "            Node at 16, 0, 16: Empty\n"
            + "            Node at 0, 16, 16: Empty\n"
            + "            Node at 16, 16, 16: Empty\n"
            + "          Node at 32, 0, 32: Empty\n"
            + "          Node at 0, 32, 32: Empty\n"
            + "          Node at 32, 32, 32: Empty\n"
            + "        Node at 64, 0, 64: Empty\n"
            + "        Node at 0, 64, 64: Empty\n"
            + "        Node at 64, 64, 64: Empty\n"
            + "      Node at 128, 0, 128: Empty\n"
            + "      Node at 0, 128, 128: Empty\n"
            + "      Node at 128, 128, 128: Empty\n"
            + "    Node at 256, 0, 256: Empty\n"
            + "    Node at 0, 256, 256: Empty\n"
            + "    Node at 256, 256, 256: Empty\n"
            + "  Node at 512, 0, 512: Empty\n"
            + "  Node at 0, 512, 512: Empty\n"
            + "  Node at 512, 512, 512: Empty\n", systemOut().getHistory());
    }
    
    /**
     * A method that tests the remove
     */
    public void testRemove() {
        leafNode.insert(new Point("AAA", 0, 0), 0, 0, 1024);
        QuadNode quadNode = leafNode.remove(new Point("AAA", 0, 0), 0, 0, 1024);
        quadNode.dump(0, 0, 1024, 0);
        assertEquals("Node at 0, 0, 1024: Empty\n", systemOut().getHistory());
    }
    
    /**
     * A method that tests the Duplicates
     */
    public void testDuplicates() {
        leafNode.insert(new Point("AAA", 0, 0), 0, 0, 1024);
        leafNode.insert(new Point("AA", 0, 0), 0, 0, 1024);
        
        leafNode.insert(new Point("BBB", 4, 4), 0, 0, 1024);
        leafNode.insert(new Point("BB", 4, 4), 0, 0, 1024);
        
        QuadNode quadNode = leafNode.insert(new Point("BB", 4, 4), 0, 0, 1024);
        quadNode.dump(0, 0, 1024, 0);
        quadNode.duplicates();
        assertEquals("Node at 0, 0, 1024: Internal\n"
            + "  Node at 0, 0, 512: Internal\n"
            + "    Node at 0, 0, 256: Internal\n"
            + "      Node at 0, 0, 128: Internal\n"
            + "        Node at 0, 0, 64: Internal\n"
            + "          Node at 0, 0, 32: Internal\n"
            + "            Node at 0, 0, 16: Internal\n"
            + "              Node at 0, 0, 8: Internal\n"
            + "                Node at 0, 0, 4:\n"
            + "                (AAA, 0, 0)\n"
            + "                (AA, 0, 0)\n"
            + "                Node at 4, 0, 4:\n"
            + "                (BBB, 4, 4)\n"
            + "                (BB, 4, 4)\n"
            + "                Node at 0, 4, 4: Empty\n"
            + "                Node at 4, 4, 4: Empty\n"
            + "              Node at 8, 0, 8: Empty\n"
            + "              Node at 0, 8, 8: Empty\n"
            + "              Node at 8, 8, 8: Empty\n"
            + "            Node at 16, 0, 16: Empty\n"
            + "            Node at 0, 16, 16: Empty\n"
            + "            Node at 16, 16, 16: Empty\n"
            + "          Node at 32, 0, 32: Empty\n"
            + "          Node at 0, 32, 32: Empty\n"
            + "          Node at 32, 32, 32: Empty\n"
            + "        Node at 64, 0, 64: Empty\n"
            + "        Node at 0, 64, 64: Empty\n"
            + "        Node at 64, 64, 64: Empty\n"
            + "      Node at 128, 0, 128: Empty\n"
            + "      Node at 0, 128, 128: Empty\n"
            + "      Node at 128, 128, 128: Empty\n"
            + "    Node at 256, 0, 256: Empty\n"
            + "    Node at 0, 256, 256: Empty\n"
            + "    Node at 256, 256, 256: Empty\n"
            + "  Node at 512, 0, 512: Empty\n"
            + "  Node at 0, 512, 512: Empty\n"
            + "  Node at 512, 512, 512: Empty\n"
            + "(0, 0)\n"
            + "(4, 4)\n", systemOut().getHistory());
        
        
//        assertEquals("(0, 0)\n"
//            + "(4, 4)\n", systemOut().getHistory());
    }
}
