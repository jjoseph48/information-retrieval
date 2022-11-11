/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.lang.Comparable;

/**
 *
 * @author Gallery
 */
public class LinkedListOrdered<E> extends LinkedList<E>{
    
    public boolean addSort(E e){
        ListIterator<E> iterator = this.listIterator();
        while(iterator.hasNext()){
            E item = iterator.next();
            if(((Comparable) item).compareTo(e) > 0){
                iterator.previous();
                iterator.add(e);
               return true;
            }
        }
        iterator.add(e);
        return true;
    }
    
    public E get(E e){
        ListIterator<E> iterator = this.listIterator();
        while(iterator.hasNext()){
            E temp = iterator.next();
            if(((Comparable) temp).compareTo(e) == 0){
                return temp;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String temp = "";
        ListIterator<E> iterator = this.listIterator();
        while(iterator.hasNext()){
            temp = temp + iterator.next() + " ";
        }
        return temp;
    }
    
    
}
