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
    LinkedListOrderedUnique<Term> dict;

    public InvertedIndex() {
        dict = new LinkedListOrderedUnique<Term>();
    }
    
    public boolean add (String term, String namaDok) {
        Term inputTerm = dict.get(new Term(term));
        
        if(inputTerm == null){
            Term newTerm = new Term(term);
            newTerm.listing = new LinkedListOrderedUnique<>();
            newTerm.getListing().addSort(new Dokumen(namaDok));
            dict.addSort(newTerm);
            System.out.println("Berhasil");
            return true;
        }
        else{
            inputTerm.getListing().addSort(new Dokumen(namaDok));
        }
        return true;
    }
}
