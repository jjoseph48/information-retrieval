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
    LinkedListOrderedUnique listing;
    
    public Term(String namaTerm){
        this.namaTerm = namaTerm;
        listing = new LinkedListOrderedUnique();
    }

    public String getNamaTerm() {
        return namaTerm;
    }

    public void setNamaTerm(String namaTerm) {
        this.namaTerm = namaTerm;
    }
    
    public void addDoc(Dokumen namaDoc){
        this.listing.addSort(namaDoc);
    }
    
    @Override
    public int compareTo(Object t) {
        Term other = (Term)t;
        
        if(this.namaTerm.compareTo(other.getNamaTerm())< 0){
            return -1;
        }else{
            return 1;
        }
    }

}
