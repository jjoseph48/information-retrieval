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
public class Dokumen implements Comparable{
    String namaDok;

    public Dokumen(String namaDok) {
        this.namaDok = namaDok;
    }

    public String getNamaDok() {
        return namaDok;
    }

    @Override
    public int compareTo(Object o) {
        return namaDok.compareTo(((Dokumen)o).getNamaDok());
    }

    @Override
    public String toString() {
        return "Dokumen{" + "namaDok=" + namaDok + '}';
    }
  
}
