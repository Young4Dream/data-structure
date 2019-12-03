package com.yan.tree;

import com.yan.util.FileOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/27 13:40
 */
public class RBTreeTest extends RBTree<String, Integer> {
    private com.yan.tree.teacher.RBTree<String, Integer> t;

    @Before
    public void setUp() throws Exception {
        List<String> words = FileOperation.readFile("pride-and-prejudice.txt");
        t = new com.yan.tree.teacher.RBTree<>();
//        PrintStream stdPrintStream = System.out;
//        String inputStream = Objects.requireNonNull(RBTree.class.getClassLoader().getResource("err.log")).getPath();
//        System.setOut(new PrintStream(new File(inputStream)));
        for (String word : words) {
//            System.out.append(word).append("\n");
            Assert.assertEquals(t.contains(word), containsKey(word));
            if (t.contains(word)) {
                t.set(word, t.get(word) + 1);
                set(word, get(word) + 1);
                continue;
            }
            t.add(word, 1);
            add(word, 1);
        }
//        System.setOut(stdPrintStream);
//        System.out.println("add end!");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSize() {
        Assert.assertEquals(size(), t.getSize());
        Assert.assertEquals(get("is"), t.get("is"));
    }

    @Test
    public void test_node_set() {
        ArrayList<com.yan.tree.teacher.RBTree<String, Integer>.Node> nodeList = new ArrayList<>(t.nodeSet());
        ArrayList<Node<String, Integer>> nodeList1 = new ArrayList<>(nodeSet());
        int size = nodeList.size();
        Assert.assertEquals(size, nodeList1.size());
        for (int i = 0; i < nodeList.size(); i++) {
            com.yan.tree.teacher.RBTree<String, Integer>.Node node1 = nodeList.get(i);
            Node<String, Integer> stringIntegerNode1 = nodeList1.get(i);
            Assert.assertEquals(node1.key, stringIntegerNode1.key);
            Assert.assertEquals(node1.value, stringIntegerNode1.value);
            Assert.assertEquals("node1.key:" + node1.key, node1.color, stringIntegerNode1.color);
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test_left_rotate() throws NoSuchFieldException, IllegalAccessException {
        RBTree<Integer, String> integerIntegerRBTree = new RBTree<>();
        integerIntegerRBTree.add(3, "rightSubTree");
        integerIntegerRBTree.add(2, "parent");
        integerIntegerRBTree.add(1, "leftSubTree");
        Field rootField = integerIntegerRBTree.getClass().getDeclaredField("root");
        rootField.setAccessible(true);
        Node<Integer, String> root = (Node<Integer, String>) rootField.get(integerIntegerRBTree);
        Assert.assertFalse(root.color);
        Assert.assertFalse(root.left.color);
        Assert.assertFalse(root.right.color);
        Assert.assertEquals("parent", root.value);
        Assert.assertEquals("leftSubTree", root.left.value);
        Assert.assertEquals("rightSubTree", root.right.value);
    }
}