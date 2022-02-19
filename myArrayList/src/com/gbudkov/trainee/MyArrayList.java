package com.gbudkov.trainee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<E> implements MySimpleArrayList<E> {
    private E[] val;


    public MyArrayList() {
        val = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = val;
            val = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, val, 0, temp.length);
            val[val.length - 1] = e;
            return true;
        } catch (ClassCastException exp) {
            exp.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = val;
            val = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, val, 0, index);
            int elementsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, val, index, elementsAfterIndex);
        } catch (ClassCastException exp) {
            exp.printStackTrace();
        }

    }

    @Override
    public E get(int index) {
        return val[index];
    }

    @Override
    public int size() {
        return val.length;
    }

    @Override
    public void update(int index, E e) {
        val[index] = e;
    }

    public void sort(int from, int to) {

        if (from < to) {

            int divideIndex = partition(from, to);

            sort(from, divideIndex - 1);

            sort(divideIndex, to);
        }

    }

    private int partition(int from, int to) {
        E pivot = val[val.length / 2];
        int leftIndex = from;
        int rightIndex = to;

        while (leftIndex <= rightIndex) {

            while (((Comparable) val[leftIndex]).compareTo(pivot) < 0) {
                leftIndex++;
            }

            while (((Comparable) val[rightIndex]).compareTo(pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(val, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public void sort(int from, int to, Comparator<? super E> c) {


        if (from < to) {

            int divideIndex = partitionComparator(from, to, c);

            sort(from, divideIndex - 1, c);

            sort(divideIndex, to, c);
        }

    }

    private int partitionComparator(int from, int to, Comparator<? super E> c) {
        int leftIndex = from;
        int rightIndex = to;

        E pivot = val[leftIndex + (rightIndex - leftIndex) / 2];
        while (leftIndex <= rightIndex) {

            while (c.compare(val[leftIndex], pivot) < 0) {
                leftIndex++;
            }

            while (c.compare(val[rightIndex], pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(val, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private void swap(E[] array, int index1, int index2) {
        E tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }


    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator<>(val);
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "val=" + Arrays.toString(val) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return Arrays.equals(val, that.val);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(val);
    }
}
