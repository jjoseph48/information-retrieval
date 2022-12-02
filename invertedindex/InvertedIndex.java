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

    public void bacaFile() {
        File name = new File(path);

        if (name.exists()) {
            if (name.isDirectory()) {
                String directory[] = name.list();
//                System.out.println("n\nDirectort contents:\n");

                for (String directoryName : directory) {
//                    System.out.printf("%s\n", directoryName);

                    try {
                        input = new Scanner(new File(name.getAbsolutePath() + "\\" + directoryName));

                        try {
                            while (input.hasNext()) {
                                sentence = input.nextLine();
                                String[] tokens = sentence.split(" ");
                                for (String token : tokens) {
                                    add(token, directoryName);
//                                    System.out.println(directoryName + " " + token);
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
//                    System.out.println("");

                }
            } else {
                System.out.printf("%s %s", path, "does not exist");
            }
        }
    }

    public boolean add(String term, String namaDok) {
        Term inputTerm = dict.get(new Term(term));

        if (inputTerm == null) {
            Term newTerm = new Term(term);
            newTerm.listing = new LinkedListOrderedUnique<>();
            newTerm.getListing().addSort(new Dokumen(namaDok));
            dict.addSort(newTerm);
            return true;
        } else {
            inputTerm.getListing().addSort(new Dokumen(namaDok));
        }
        return true;
    }

    public void cari(String term) {
        String[] tokens = term.split(" ");

        if (tokens.length > 1) {
            LinkedListOrderedUnique<Dokumen> ans = getPost(tokens[0]);
            for (int i = 1; i < tokens.length; i++) {
                ans = intersect(ans,getPost(tokens[i]));
            }
            
            if (ans == null) {
                System.out.println("Dokumen tidak ditemukan");
            } else {
                System.out.print("Kata " + term + " =>");
                ListIterator<Dokumen> iterator = ans.listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next() + " ");
                }
                System.out.println(" ");
            }
            
        } else {
            LinkedListOrderedUnique<Dokumen> index = getPost(term);

            if (index == null) {
                System.out.println("Dokumen tidak ditemukan");
            } else {
                System.out.print("Kata " + term + " =>");
                ListIterator<Dokumen> iterator = index.listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next() + " ");
                }
                System.out.println(" ");
            }
        }

    }

    public LinkedListOrderedUnique<Dokumen> getPost(String term) {
        LinkedListOrderedUnique<Dokumen> index = new LinkedListOrderedUnique<>();
        Term t = dict.get(new Term(term));

        if (t == null) {
            return null;
        } else {
            index = t.getListing();
        }
        return index;
    }

    public LinkedListOrderedUnique<Dokumen> intersect(LinkedListOrderedUnique<Dokumen> p1,
            LinkedListOrderedUnique<Dokumen> p2) {
        LinkedListOrderedUnique<Dokumen> hasil = new LinkedListOrderedUnique<>();

        if(p1 != null && p2 != null) {
            ListIterator<Dokumen> it1 = p1.listIterator();
            ListIterator<Dokumen> it2 = p2.listIterator();
            
            while (it1.hasNext() && it2.hasNext()) {
                if (p1.get(it1.nextIndex()).compareTo(p2.get(it2.nextIndex()))== 0) {
                    hasil.addSort(p1.get(it1.nextIndex()));
                    it1.next();
                    it2.next();
                } else if (p1.get(it1.nextIndex()).compareTo(p2.get(it2.nextIndex())) < 1) {
                    it1.next();
                } else {
                    it2.next();
                }
            }
        }
        return hasil;
    }
}
