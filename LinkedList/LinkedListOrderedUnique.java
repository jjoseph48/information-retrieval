/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.ListIterator;

/**
 *
 * @author Gallery
 */
public class LinkedListOrderedUnique<E> extends LinkedListOrdered<E> {

    @Override
    public boolean addSort(E e) {
        ListIterator<E> iterator = this.listIterator();
        
        if(this.get(e)== null){
            while (iterator.hasNext()) {
            E item = iterator.next();
            if (((Comparable) item).compareTo(e) > 0) {
                iterator.previous();
                iterator.add(e);
                return true;
            }
        }
        iterator.add(e);
        }
        
        return true;
    }

    @Override
    public E get(E e) {
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {
            E temp = iterator.next();
            if (((Comparable) temp).compareTo(e) == 0) {
                return temp;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String temp = "";
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {
            temp = temp + iterator.next() + " ";
        }
        return temp;
    }
}
