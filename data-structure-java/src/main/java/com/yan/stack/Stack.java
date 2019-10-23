package com.yan.stack;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/8 0008 10:33
 */
public interface Stack<E> {
    /**
     * 压入栈
     *
     * @param e 压入栈的元素
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return 返回栈顶元素，如果没有返回NULL
     */
    E pop() throws UnsupportedOperationException;

    /**
     * 查看栈顶元素
     *
     * @return 返回栈顶元素，如果没有返回NULL
     */
    E peek();

    /**
     * 栈的元素数量
     *
     * @return 栈的元素数量
     */
    int getSize();

    /**
     * 是否为空栈
     *
     * @return 为空返回True
     */
    default boolean isEmpty() {
        return getSize() == 0;
    }
}
