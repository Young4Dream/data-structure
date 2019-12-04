package com.yan.tree;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/23 0023 14:29
 */
@RunWith(JUnit4.class)
public class BSTTest {
    @Before
    public void before() {

    }

    @Test
    public void test() {
        BST<Integer> integerBST = new BST<>();
        integerBST.add(8);
        integerBST.add(6);
        integerBST.add(11);
        integerBST.add(3);
        integerBST.add(7);
        integerBST.add(9);
        integerBST.add(12);
        ///////////////////
        //       8       //
        //     /   \     //
        //   6      11   //
        //  / \    /  \  //
        //3    7  9    12//
        ///////////////////
        integerBST.contains(9);
        //8,6,3,7,11,9,12
        integerBST.preOrderNR();
        //3,6,7,8,9,11,12
        integerBST.midOrder();
        //3,7,6,9,12,11,8
        integerBST.postOrder();
        System.out.println(integerBST.removeMin());
        System.out.println(integerBST.contains(3));
        System.out.println(integerBST.contains(12));
        System.out.println(integerBST.removeMin());
        integerBST.remove(8);
        integerBST.remove(11);
        Assert.assertFalse(integerBST.contains(11));
    }

    @After
    public void after() {

    }
}