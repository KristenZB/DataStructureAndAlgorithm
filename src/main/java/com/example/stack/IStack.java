package com.example.stack;

public interface IStack<E> {

    /**
     * 往栈中添加新元素
     * @param element 待添加元素
     */
    void push(E element);

    /**
     * 出栈并获取出栈元素
     * @return 出栈元素
     */
    E pop();

    /**
     * 获取栈的长度
     * @return 栈的长度
     */
    int size();

    /**
     * 获取栈顶元素
     * @return 栈顶元素
     */
    E peek();

    /**
     * 判断栈是否为空
     *
     * @return 判断结果
     */
    boolean isEmpty();
}