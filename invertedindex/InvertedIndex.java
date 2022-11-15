/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import LinkedList.LinkedListOrderedUnique;

/**
 *
 * @author Gallery
 */
public class InvertedIndex {
    LinkedListOrderedUnique<Term> dict = new LinkedListOrderedUnique<Term>();

    public InvertedIndex() {
        
    }
    
    public boolean add (String term, String namaDok) {
        Term a = new Term (term);
        Dokumen dok = new Dokumen(namaDok);
        
        if(dict.isEmpty()){
            dict.addSort(a);
            a.addDoc(dok);
            System.out.println("Berhasil");
            return true;
        }
        else{
            for (int i = 0; i < dict.size(); i++) {
                if(dict.get(i).getNamaTerm() == term){
                    dict.get(i).addDoc(dok);
                    System.out.println("Masukkan ke yang sama");
                    return true;
                }
            }
            dict.addSort(a);
            a.addDoc(dok);
        }
        return true;
    }
}
