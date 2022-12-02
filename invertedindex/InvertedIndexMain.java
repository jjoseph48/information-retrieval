/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import java.util.Scanner;

/**
 *
 * @author Gallery
 */
public class InvertedIndexMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InvertedIndex invindex = new InvertedIndex();
        invindex.bacaFile();
        
        invindex.cari("mulai");
        invindex.cari("hari");
        invindex.cari("jalan");
        invindex.cari("mulai hari jalan");
        
//        boolean lanjut = true;
//        int input;
//        String kata;
//        
//        while(lanjut){
//            System.out.println("Pilihan :");
//            System.out.println("1. Inputkan 1 untuk melanjutkan pencarian");
//            System.out.println("1. Inputkan 2 untuk menutup aplikasi");
//            
//            System.out.print("Masukkan inputan :");
//            input = sc.nextInt();
//            
//            switch (input){
//                case 1:
//                    System.out.print("Masukkan kata yang ingin dicari :");
//                    kata = sc.next();
//                    invindex.cari(kata);
//                    break;
//                case 2:
//                    System.out.println("Program selesai");
//                    lanjut = false;
//                    break;
//            }       
//        }
    }
}
