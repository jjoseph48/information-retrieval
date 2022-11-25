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
        InvertedIndex coba1 = new InvertedIndex();
        coba1.bacaFile();
        
        coba1.search("kawasan");
        coba1.search("-");
        coba1.search("rumah");
    }
}
