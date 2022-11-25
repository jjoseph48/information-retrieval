/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import LinkedList.LinkedListOrderedUnique;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Gallery
 */
public class InvertedIndex {
    LinkedListOrderedUnique<Term> dict;
    String path = "D:\\TUGAS VEROL\\Materi Kuliah Smstr 5\\Pemerolehan Informasi\\Tugas\\Koleksi";
    Scanner input;
    String sentence = "";

    public InvertedIndex() {
        dict = new LinkedListOrderedUnique<Term>();
    }
    
    public void bacaFile(){
        File name = new File(path);

        if (name.exists()) {
            if (name.isDirectory()) {
                String directory[] = name.list();
                System.out.println("n\nDirectort contents:\n");

                for (String directoryName : directory) {
                    System.out.printf("%s\n", directoryName);

                    try {
                        input = new Scanner(new File(name.getAbsolutePath() + "\\" + directoryName));

                        try {
                            while (input.hasNext()) {
                                sentence = input.nextLine();
                                String[] tokens = sentence.split(" ");
                                for (String token : tokens) {
                                    add(token, directoryName);
                                    System.out.println(directoryName + " " + token);
                                }
                            }

                        } catch (NoSuchElementException elementException) {
                            System.err.println("File improperly formed");
                            input.close();
                            System.exit(1);
                        } catch (IllegalStateException stateException) {
                            System.err.println("Error reading from file");
                            System.exit(1);
                        }
                    } catch (FileNotFoundException fileNotFoundException) {
                        System.err.println("Error opening file");
                        System.exit(1);
                    }
                    System.out.println("");

                }
            } else {
                System.out.printf("%s %s", path, "does not exist");
            }
        }
    }
    
    public boolean add (String term, String namaDok) {
        Term inputTerm = dict.get(new Term(term));
        
        if(inputTerm == null){
            Term newTerm = new Term(term);
            newTerm.listing = new LinkedListOrderedUnique<>();
            newTerm.getListing().addSort(new Dokumen(namaDok));
            dict.addSort(newTerm);
            return true;
        }
        else{
            inputTerm.getListing().addSort(new Dokumen(namaDok));
        }
        return true;
    }
    
    public void search(String term){
        Term searchTerm = dict.get(new Term(term));
        
        if(searchTerm == null){
            System.out.println("Dokumen tidak ditemukan");
        }else{
	    System.out.println("Kata " + searchTerm + " =>");
            ListIterator<Dokumen> iterator = searchTerm.getListing().listIterator();
            while(iterator.hasNext()){
            	System.out.print(iterator.next() + " ");
            }
	    System.out.println(" ");
        }
    }
}
