package com.gbudkov.trainee;

import java.util.Comparator;

public interface MySimpleArrayList<E> extends Iterable<E> {
    boolean add(E e);

    void delete(int index);

    E get(int index);

    int size();

    void update(int index, E e);

    void sort(int from, int to);

    void sort(int from, int to, Comparator<? super E> c);

}

