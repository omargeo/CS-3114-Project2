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

import student.TestCase;

/**
 * This class tests the behavior of projectRunner class
 * @author Omar Elgeoushy (omarelgeoushy)
 * @version  2021.09.20
 */
public class CommandFileTest extends TestCase {

    /**
     * A variable that holds the rectangle
     */
    private CommandFile projectRunner;
    
    /**
     * setUp method for the class
     */
    public void setUp() {
        projectRunner = new CommandFile();
    }
    
    /**
     * tests isNumeric
     */
    public void testIsNumeric() {
        assertFalse(projectRunner.isNumeric("a"));
        assertTrue(projectRunner.isNumeric("1"));
    }
    
    /**
     * tests the remove method
     */
    public void testRemove() {
        projectRunner.run("insert p1 -1 -20");
        projectRunner.run("insert p2 7 -8");
        projectRunner.run("dump");
        projectRunner.run("search p1");
        projectRunner.run("remove p1");
        assertEquals("Point rejected: (p1, -1, -20)\n"
            + "Point rejected: (p2, 7, -8)\n"
            + "SkipList dump:\n"
            + "Node has depth 1, Value (null)\n"
            + "SkipList size is: 0\n"
            + "QuadTree dump:\n"
            + "Node at 0, 0, 1024: Empty\n"
            + "1 quadtree nodes printed\n"
            + "Point not found: p1\n"
            + "Point not removed: (p1)\n", systemOut().getHistory());
    }
    
    /**
     * A method that tests regionsearch
     */
    public void testRegionSearch() {
        projectRunner.run("regionsearch -10 1 2 3");
        projectRunner.run("regionsearch 0 -1 2 3");
        projectRunner.run("regionsearch 0 1 -2 3");
        projectRunner.run("regionsearch 0 1 2 -3");
        
        projectRunner.run("insert p1 0 10");
        projectRunner.run("insert p2 5 9");
        projectRunner.run("regionsearch 0 0 11 10");
        
        assertEquals("Rectangle rejected: (-10, 1, 2, 3):\n"
            + "Points intersecting region (0, -1, 2, 3):\n"
            + "0 quadtree nodes visited\n"
            + "Rectangle rejected: (0, 1, -2, 3):\n"
            + "Rectangle rejected: (0, 1, 2, -3):\n"
            + "Point inserted: (p1, 0, 10)\n"
            + "Point inserted: (p2, 5, 9)\n"
            + "Points intersecting region (0, 0, 11, 10):\n"
            + "Point found: (p1, 0, 10)\n"
            + "Point found: (p2, 5, 9)\n"
            + "1 quadtree nodes visited\n", systemOut().getHistory());
    }
    
//    /**
//     * tests the remove method
//     */
//    public void testRemove1() {
//        projectRunner.run("insert A 0 0");
//        projectRunner.run("insert B 5 5");
//        projectRunner.run("insert C 10 10");
//        projectRunner.run("insert D 15 15");
//        projectRunner.run("insert E 20 400");
////        System.out.println("----------");
////        projectRunner.run("dump");
////        System.out.println("----------");
//        projectRunner.run("remove 0 0");
//        projectRunner.run("remove 5 5");
//        projectRunner.run("remove 10 10");
//        projectRunner.run("remove 20 400");
//        projectRunner.run("remove 2 2");
//        projectRunner.run("remove 15 15");
//        
////        System.out.println("----------");
//        projectRunner.run("dump");
////        System.out.println("----------");
//        assertEquals("Point inserted: (A, 0, 0)\n"
//            + "Point inserted: (B, 5, 5)\n"
//            + "Point inserted: (C, 10, 10)\n"
//            + "Point inserted: (D, 15, 15)\n"
//            + "Point inserted: (E, 20, 400)\n"
//            + "Point removed: (A, 0, 0)\n"
//            + "SkipList dump:\n"
//            + "Node has depth 1, Value (null)\n"
//            + "Node has depth 0, Value (B, 5, 5)\n"
//            + "Node has depth 0, Value (C, 10, 10)\n"
//            + "Node has depth 1, Value (D, 15, 15)\n"
//            + "Node has depth 0, Value (E, 20, 400)\n"
//            + "SkipList size is: 4\n"
//            + "QuadTree dump:\n"
//            + "Node at 0, 0, 1024: Internal\n"
//            + "  Node at 0, 0, 512: Internal\n"
//            + "    Node at 0, 0, 256: Internal\n"
//            + "    (B, 5, 5)\n"
//            + "    (C, 10, 10)\n"
//            + "    (D, 15, 15)\n"
//            + "    Node at 256, 0, 256: Empty\n"
//            + "    Node at 0, 256, 256:\n"
//            + "    (E, 20, 400)\n"
//            + "    Node at 256, 256, 256: Empty\n"
//            + "  Node at 512, 0, 512: Empty\n"
//            + "  Node at 0, 512, 512: Empty\n"
//            + "  Node at 512, 512, 512: Empty\n"
//            + "9 quadtree nodes printed", systemOut().getHistory());
//    }
//    
//    /**
//     * tests the remove method
//     */
//    public void testRemove2() {
//        projectRunner.run("insert A 0 0");
//        projectRunner.run("insert B 5 5");
//        projectRunner.run("insert C 10 10");
//        projectRunner.run("insert D 15 15");
//        projectRunner.run("insert E 20 400");
////        System.out.println("----------");
////        projectRunner.run("dump");
////        System.out.println("----------");
//        projectRunner.run("remove A");
//        projectRunner.run("remove B");
//        projectRunner.run("remove C");
//        projectRunner.run("remove D");
//        projectRunner.run("remove E");
////        System.out.println("----------");
//        projectRunner.run("dump");
////        System.out.println("----------");
//        
//        assertEquals("Point inserted: (A, 0, 0)\n"
//            + "Point inserted: (B, 5, 5)\n"
//            + "Point inserted: (C, 10, 10)\n"
//            + "Point inserted: (D, 15, 15)\n"
//            + "Point inserted: (E, 20, 400)\n"
//            + "Point removed: (A, 0, 0)\n"
//            + "Point removed: (B, 5, 5)\n"
//            + "Point removed: (C, 10, 10)\n"
//            + "Point removed: (D, 15, 15)\n"
//            + "Point removed: (E, 20, 400)\n"
//            + "SkipList dump:\n"
//            + "Node has depth 2, Value (null)\n"
//            + "SkipList size is: 0\n"
//            + "QuadTree dump:\n"
//            + "Node at 0, 0, 1024: Empty\n"
//            + "1 quadtree nodes printed\n", systemOut().getHistory());
//    }
    
    /**
     * tests the search method
     */
    public void testSearch() {
        projectRunner.run("insert p1 10 10");
        projectRunner.run("insert p1 20 30");
        projectRunner.run("search p1");
        assertEquals("Point inserted: (p1, 10, 10)\n"
            + "Point inserted: (p1, 20, 30)\n"
            + "Found (p1, 20, 30)\n"
            + "Found (p1, 10, 10)\n", systemOut().getHistory());
    }
    
//    /**
//     * tests RegionSearch
//     */
//    public void testRegionSearch1() {
//        projectRunner.run("insert A 0 0");
//        projectRunner.run("insert B 700 700");
//        projectRunner.run("insert C 700 700");
//        projectRunner.run("insert D 750 750");
//        projectRunner.run("insert E 751 751");
//        projectRunner.run("insert F 752 753");
//        projectRunner.run("insert G 760 770");
//        projectRunner.run("insert X 1024 1024");
//        projectRunner.run("dump");
//        projectRunner.run("regionsearch 500 500 524 524");
//        assertEquals("QuadTree dump:\n"
//            + "Node at 0, 0, 1024: Internal\n"
//            + "  Node at 0, 0, 512:\n"
//            + "  (A, 0, 0)\n"
//            + "  Node at 512, 0, 512: Empty\n"
//            + "  Node at 0, 512, 512: Empty\n"
//            + "  Node at 512, 512, 512: Internal\n"
//            + "    Node at 512, 512, 256: Internal\n"
//            + "      Node at 512, 512, 128: Empty\n"
//            + "      Node at 640, 512, 128: Empty\n"
//            + "      Node at 512, 640, 128: Empty\n"
//            + "      Node at 640, 640, 128: Internal\n"
//            + "        Node at 640, 640, 64:\n"
//            + "        (B, 700, 700)\n"
//            + "        (C, 700, 700)\n"
//            + "        Node at 704, 640, 64: Empty\n"
//            + "        Node at 640, 704, 64: Empty\n"
//            + "        Node at 704, 704, 64:\n"
//            + "        (D, 750, 750)\n"
//            + "        (E, 751, 751)\n"
//            + "        (F, 752, 753)\n"
//            + "    Node at 768, 512, 256: Empty\n"
//            + "    Node at 512, 768, 256:\n"
//            + "    (G, 760, 770)\n"
//            + "    Node at 768, 768, 256:\n"
//            + "    (X, 1024, 1024)\n"
//            + "17 quadtree nodes printed\n"
//            + "Point found: (B, 700, 700)\n"
//            + "Point found: (C, 700, 700)\n"
//            + "Point found: (D, 750, 750)\n"
//            + "Point found: (E, 751, 751)\n"
//            + "Point found: (F, 752, 753)\n"
//            + "Point found: (G, 760, 770)\n"
//            + "Point found: (X, 1024, 1024)\n", systemOut().getHistory());
//    }
    
//    /** 
//     * tests the regionSearch
//     */
//    public void testRegionSearch() {
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("insert rec1 12 18 5 5");
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("regionsearch 10 10 10 10");
//        assertEquals("Rectangles intersecting region "
//            + "(10, 10, 10, 10):\n(rec1, 12, 18, 5, 5)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("insert rec2 18 18 5 5");
//        projectRunner.run("regionsearch 10 10 10 10");
//        assertEquals("Rectangle inserted: (rec2, 18, 18, 5, 5)\n"
//            + "Rectangles intersecting region (10, 10, 10, 10):"
//            + "\n(rec1, 12, 18, 5, 5)\n"
//            + "(rec2, 18, 18, 5, 5)\n", outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("insert rec3 5 5 10 10");
//        projectRunner.run("regionsearch 10 10 10 10");
//        assertEquals("Rectangle inserted: (rec3, 5, 5, 10, 10)\n"
//            + "Rectangles intersecting region (10, 10, 10, 10):\n"
//            + "(rec1, 12, 18, 5, 5)\n"
//            + "(rec2, 18, 18, 5, 5)\n(rec3, 5, 5, 10, 10)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("insert rec4 18 5 10 10");
//        projectRunner.run("regionsearch 10 10 10 10");
//        assertEquals("Rectangle inserted: (rec4, 18, 5, 10, 10)\n"
//            + "Rectangles intersecting region (10, 10, 10, 10):\n"
//            + "(rec1, 12, 18, 5, 5)\n"
//            + "(rec2, 18, 18, 5, 5)\n(rec3, 5, 5, 10, 10)"
//            + "\n(rec4, 18, 5, 10, 10)\n", outContent.toString());
//    }
//   
//    /**
//     * tests the regionSearch
//     */
//    public void testRegionSearch1() {
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.regionsearch(-10, 10, 10, 10);
//        assertEquals("Rectangle rejected: (-10, 10, 10, 10)\n",
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.regionsearch(10, -10, 10, 10);
//        assertEquals("Rectangle rejected: (10, -10, 10, 10)\n",
//            outContent.toString());
//    
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.regionsearch(10, 10, -10, 10);
//        assertEquals("Rectangle rejected: (10, 10, -10, 10)\n",
//            outContent.toString());
//    
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.regionsearch(10, 10, 10, -10);
//        assertEquals("Rectangle rejected: (10, 10, 10, -10)\n",
//            outContent.toString());
//    }
//    
//    /**
//     * test method for search
//     */
//    public void testSearch() {
//        
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.search("rec");
//        assertEquals("Rectangle not found: rec\n", outContent.toString());
//        
//        projectRunner.run("insert rec1 18 18 5 5");
//        
//        projectRunner.run("insert rec2 18 18 5 5");
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        //projectRunner.search("rec2");
//        projectRunner.run("search rec2");
//        assertEquals("Rectangles found:\n(rec2, 18, 18, 5, 5)\n", 
//            outContent.toString());
//        
//        projectRunner.run("insert rec2 10 7 3 4");
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("search rec2");
//        assertEquals("Rectangles found:\n(rec2, 10, 7, 3, 4)"
//            + "\n(rec2, 18, 18, 5, 5)\n", 
//            outContent.toString());
//    }
//   
//    /**
//     * test method for remove
//     */
//    public void testRemove() {
//        projectRunner.run("insert rec1 12 18 5 4");
//        projectRunner.run("insert rec2 12 18 4 5");
//        projectRunner.run("insert rec3 12 17 5 5");
//        projectRunner.run("insert rec4 11 18 5 5");
//        projectRunner.run("insert rec5 12 18 5 5");
//        
//        
//        projectRunner.run("dump");
//        
//        
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("remove 12 18 5 5");
//        assertEquals("Rectangle removed: (rec5, 12, 18, 5, 5)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("remove 11 18 5 5");
//        assertEquals("Rectangle removed: (rec4, 11, 18, 5, 5)\n",
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("remove 12 17 5 5");
//        assertEquals("Rectangle removed: (rec3, 12, 17, 5, 5)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("remove 12 18 4 5");
//        assertEquals("Rectangle removed: (rec2, 12, 18, 4, 5)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("remove 12 18 5 4");
//        assertEquals("Rectangle removed: (rec1, 12, 18, 5, 4)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("remove 12 18 5 4");
//        assertEquals("Rectangle not found: (12, 18, 5, 4)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("dump");
//        assertEquals(String.format("SkipList dump:"
//            + "\nNode has depth %d, Value (null)\n"
//            + "SkipList size is: 0\n", projectRunner.getRectangle1().
//            getSkipList().getLevel()), 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        assertNull(projectRunner.remove(-1, 0, 1, 1));
//    }
//    
//    /**
//     * tests insert method
//     */
//    public void testInsert() {
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("dump");
//        assertEquals("SkipList dump:\nNode has depth 1, "
//            + "Value (null)\nSkipList size is: 0\n", outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run(" \n insert rec1  0  0  5  5");
//        assertEquals("Rectangle inserted: (rec1, 0, 0, 5, 5)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run(" \n insert rec1  -1  0  5  5");
//        assertEquals("Rectangle rejected: (rec1, -1, 0, 5, 5)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run(" \n insert rec1  0  -1  5  5");
//        assertEquals("Rectangle rejected: (rec1, 0, -1, 5, 5)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run(" \n insert rec1  0  0  0  5");
//        assertEquals("Rectangle rejected: (rec1, 0, 0, 0, 5)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run(" \n insert rec1  0  0  5  0");
//        assertEquals("Rectangle rejected: (rec1, 0, 0, 5, 0)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("remove rec1");
//        assertEquals("Rectangle removed: (rec1, 0, 0, 5, 5)\n", 
//            outContent.toString());
//    }
//    
//    /**
//     * tests remove method
//     */
//    public void testRemove1() {
//        projectRunner.run("insert rec1 1 0 2 4");
//        projectRunner.run("insert rec2 1 0 2 4");
//        projectRunner.run("insert rec3 2 5 123 6");
//        
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("remove rec3");
//        assertEquals("Rectangle removed: (rec3, 2, 5, 123, 6)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("remove rec1");
//        assertEquals("Rectangle removed: (rec1, 1, 0, 2, 4)\n", 
//            outContent.toString());
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("dump");
//    }
//    
//    /**
//     * Tests the intersection method
//     */
//    public void testIntersection() {
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        
//        projectRunner.run("insert rec1 0 0 5 4");
//        projectRunner.run("insert rec2 2 3 6 3");
//        projectRunner.run("insert rec3 8 3 5 2");
//        projectRunner.run("insert rec4 10 4 5 2");
//        
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        projectRunner.run("intersections");
//        assertEquals("Intersection pairs:\n"
//            + "(rec1, 0, 0, 5, 4) | (rec2, 2, 3, 6, 3)\n"
//            + "(rec2, 2, 3, 6, 3) | (rec1, 0, 0, 5, 4)\n"
//            + "(rec3, 8, 3, 5, 2) | (rec4, 10, 4, 5, 2)\n"
//            + "(rec4, 10, 4, 5, 2) | (rec3, 8, 3, 5, 2)\n", 
//            outContent.toString());
//    }
}
