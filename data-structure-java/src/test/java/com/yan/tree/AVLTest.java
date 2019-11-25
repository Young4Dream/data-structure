package com.yan.tree;

import com.yan.tree.teacher.AVLTree;
import com.yan.util.FileOperation;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/20 12:12
 */
public class AVLTest extends AVL<String, Integer> {
    private AVLTree<String, Integer> map = new AVLTree<>();

    @Before
    public void setUp() {
        List<String> words = FileOperation.readFile("pride-and-prejudice.txt");
        for (String word : words) {
            if (map.contains(word))
                map.set(word, map.get(word) + 1);
            else
                map.add(word, 1);
        }
        for (String word : words) {
            if (containsKey(word))
                set(word, get(word) + 1);
            else
                add(word, 1);
        }
    }

    @Test
    public void test_is_balanced() {
        assertEquals(isBalanced(), map.isBalanced());
    }

    @Test
    public void test_size() {
        assertEquals(size(), map.getSize());
    }

    @Test
    public void test_key_set() {
        assertEquals(keySet().size(), map.keySet().size());
    }

    @Test
    public void test_random_key_value() {
        Set<String> strings = keySet();
        int size = strings.size();
        int skip = (int) (Math.random() * size);
        String random_key = strings.stream().skip(skip).findAny().orElseThrow(RuntimeException::new);
//        System.out.println("random_key:" + random_key);
        assertEquals(get(random_key), map.get(random_key));
    }

    @Test
    public void test_remove(){
        map.remove("are");
        map.remove("often");
        remove("are");
        remove("often");

        assertEquals(map.getSize(), size());
        assertNull(get("are"));
        test_random_key_value();
    }

}