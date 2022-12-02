/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;


/**
 *
 * @author Gallery
 */
public class InvertedIndexMain {
    public static void main(String[] args) {
        InvertedIndex invindex = new InvertedIndex();
        invindex.bacaFile();
        
        // Pencarian satu keyword
        System.out.println("Pencarian satu keyword");
        invindex.cari("semarang");
        invindex.cari("rabu,");
        invindex.cari("jalan");
        invindex.cari("kawasan");
        System.out.println("");
        
        // Pencarian empat keyword
        System.out.println("Pencarian empat keyword");
        invindex.cari("semarang rabu, jalan kawasan");
        
    }
}
