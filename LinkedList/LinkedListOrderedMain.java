/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Gallery
 */
public class LinkedListOrderedMain {
    public static void main(String[] args) {
        LinkedListOrderedUnique<String> linkedListSort = new LinkedListOrderedUnique();
        
        linkedListSort.addSort("lumpia");
        linkedListSort.addSort("semarang");
        linkedListSort.addSort("solo");
        linkedListSort.addSort("rabu");
        linkedListSort.addSort("sekolah");
        linkedListSort.addSort("lampu");
        linkedListSort.addSort("solo");
        
        System.out.println(linkedListSort.toString());
        
    }
}
