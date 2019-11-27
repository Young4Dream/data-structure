package com.yan.tree;

import com.yan.util.FileOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/27 13:40
 */
public class RBTreeTest extends RBTree<String, Integer> {
    private List<String> words;
    private com.yan.tree.teacher.RBTree<String, Integer> t;

    @Before
    public void setUp() throws Exception {
        words = FileOperation.readFile("pride-and-prejudice.txt");
        t = new com.yan.tree.teacher.RBTree<>();
//        String inputStream = Objects.requireNonNull(RBTree.class.getClassLoader().getResource("err.log")).getPath();
//        System.setOut(new PrintStream(new File(inputStream)));
//        System.out.println();
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
        Set<com.yan.tree.teacher.RBTree<String, Integer>.Node> nodes = t.nodeSet();
        Set<Node<String, Integer>> nodes1 = nodeSet();
        int size = nodes.size();
        Assert.assertEquals(size, nodes1.size());
        Boolean[] booleans = nodes.stream().map(n -> t.isRed(n)).collect(Collectors.toList()).toArray(new Boolean[size]);
        Boolean[] booleans1 = nodes1.stream().map(RBTreeTest::isRed).collect(Collectors.toList()).toArray(new Boolean[size]);
        Assert.assertArrayEquals(booleans, booleans1);
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