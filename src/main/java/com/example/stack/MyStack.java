package com.example.stack;

import java.util.EmptyStackException;

import com.example.list.IList;
import com.example.list.MyArrayList;

public class MyStack<E> implements IStack<E> {

    IList<E> list = new MyArrayList<>();

    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
    public E pop() {
        checkEmpty();
        return list.remove(size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E peek() {
        checkEmpty();
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    private void checkEmpty() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
    }
}