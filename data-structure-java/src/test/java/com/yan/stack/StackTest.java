package com.yan.stack;

import com.yan.stack.array.ArrayStack;
import com.yan.stack.linked.LinkedListStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/18 0018 13:04
 */
@RunWith(JUnit4.class)
public class StackTest {
    private Stack<Integer> arrayStack;
    private Stack<Integer> linkedListStack;

    @Before
    public void before() {
        arrayStack = new ArrayStack<>();
        linkedListStack = new LinkedListStack<>();
    }

    /**
     * 测试效率
     */
    @Test
    public void test() {
        int count = 10000000;
        push_pop_by_count(arrayStack, count);
        push_pop_by_count(linkedListStack, count);
    }

    private void push_pop_by_count(Stack<Integer> stack, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            stack.push(i);
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        long end = System.currentTimeMillis();
        System.out.println(stack.getClass().getSimpleName() + "耗时:" + ((end - start) / 1000.0));
    }

    @After
    public void after() {

    }
}