package desire.morse;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 *
 */

/**Test Student for MorseCodeTree Class
 * @author desire Mpondo
 *
 */
public class MorseCodeTreeTest {

    static MorseCodeTree<String> tree = new MorseCodeTree<>();//Use the same tree for all the test
    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link MorseCodeTree#addNode(TreeNode, java.lang.Object, java.lang.Object)}.
     */
    @Test
    public void testAddNode() {
        //Creating morse code for digits
        String code1 = ".----";
        String code3 = "...--";
        String code4 = "....-";
        String code5 = ".....";
        String code6 = "-....";
        String code7 = "--...";

        //adding new node to the tree
        tree.addNode(tree.getRoot(), code1, "1");//adds 1 as Rnode of j
        tree.addNode(tree.getRoot(), code3, "3");//adds 3 as Rnode of v
        tree.addNode(tree.getRoot(), code4, "4");//adds 4 as Rnode of h
        tree.addNode(tree.getRoot(), code5, "5");
        tree.addNode(tree.getRoot(), code6, "6");
        tree.addNode(tree.getRoot(), code7, "7");
        //new tree inorder content is [5, h, 4, s, v, 3, i, f, u, e, l, r, a, p, w, j, 1, , 6, b, d, x, n, c, k, y, t, 7, z, g, q, m, o]
        String expected = "[5, h, 4, s, v, 3, i, f, u, e, l, r, a, p, w, j, 1, , 6, b, d, x, n, c, k, y, t, 7, z, g, q, m, o]";

        assertEquals(expected, tree.toArrayList().toString());
    }

    /**
     * Test method for {@link MorseCodeTree#fetch(java.lang.String)}.
     */
    @Test
    public void testFetch() {
        String v = "...-";
        String q = "--.-";
        String w =".--";
        String seven = "--...";
        assertEquals("v", tree.fetch(v));
        assertEquals("q", tree.fetch(q));
        assertEquals("w", tree.fetch(w));
        assertEquals("7", tree.fetch(seven));

    }


    /**
     * Test method for {@link MorseCodeTree#toArrayList()}.
     */
    @Test
    public void testToArrayList() {

        ArrayList<String> list = tree.toArrayList();
        //after adding new nodes 3,4,5,6,7
        String correctResult = "5, h, 4, s, v, 3, i, f, u, e, l, r, a, p, w, j, 1, , 6, b, d, x, n, c, k, y, t, 7, z, g, q, m, o";
        String listString = list.toString();
        listString = listString.replace('[', ' ');
        listString = listString.replace(']', ' ');
        listString = listString.trim();
        //System.out.println(list);
        assertEquals(correctResult, listString);
    }

    /**
     * Test method for {@link MorseCodeTree#LNRoutputTraversal(TreeNode, java.util.ArrayList)}.
     */
    @Test
    public void testLNRoutputTraversal() {
        //displays the list inorder traversal
        ArrayList<String> list = new ArrayList<>();
        tree.LNRoutputTraversal(tree.getRoot(), list);
        //System.out.println(list);
    }

}
