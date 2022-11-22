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
public class Term implements Comparable{
    String namaTerm;
    LinkedListOrderedUnique<Dokumen> listing;
    
    public Term(String namaTerm){
        this.namaTerm = namaTerm;
    }

    public String getNamaTerm() {
        return namaTerm;
    }
    
    public LinkedListOrderedUnique<Dokumen> getListing(){
        return listing;
    }
    
    @Override
    public int compareTo(Object t) {
        return namaTerm.compareTo(((Term) t).getNamaTerm());
    }

}
