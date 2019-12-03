package com.yan.tree;

import com.yan.util.FileOperation;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/20 12:12
 */
public class AVLTreeTest extends AVLTree<String, Integer> {
    private com.yan.tree.teacher.AVLTree<String, Integer> map = new com.yan.tree.teacher.AVLTree<>();

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
    public void test_remove() {
        Set<String> strings = keySet();
        int size = strings.size();
        int skip = (int) (Math.random() * size);
        int limit = (int) (Math.random() * (size - skip));
//        skip = 3278;
//        limit = 1;
        assertEquals(map.get("is"), get("is"));
        strings.stream().skip(skip).limit(limit).forEach(k -> {
//            System.out.println("key:" + k);
            map.remove(k);
            remove(k);
            assertNull(get(k));
        });
        assertEquals(map.getSize(), size());
        assertEquals(key_set_to_string(map.keySet()), key_set_to_string(keySet()));
    }

    private String key_set_to_string(Set<String> keySet) {
        return keySet.stream().sorted().collect(Collectors.joining());
    }

}