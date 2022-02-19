package com.gbudkov.trainee;

import java.util.Iterator;

public class MyArrayListIterator<E> implements Iterator {
    private int index = 0;
    private E[] val;

    public MyArrayListIterator(E[] val) {
        this.val = val;
    }


    @Override
    public boolean hasNext() {
        return index < val.length;
    }

    @Override
    public E next() {
        return val[index++];
    }
}
