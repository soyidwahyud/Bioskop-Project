/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioskopproject;
import backEnd.*;
import java.sql.*;
/**
 *
 * @author Rifaul06
 */
public class BioskopProject {
    public static void main(String[] args) {
        /*
        Film f1 = new Film("A Star is Born");
        Film f2 = new Film("Bohemian Rhapsody");
        
        f1.save();
        f2.save();
        */
        for (Film film1 : new Film().getAll()) {
            System.out.println("judul "+film1.getJudul());
        }
        
        Pembelian newValue = new Pembelian();
        newValue.setIdPembelian(0);
        
        newValue.getKursi().setKode("B5");
        newValue.getKursi().setStatus("book");
        
        for (Pembelian p : new Pembelian().getAll()) {
            if (p.getStudio().getStudio().equals("Reguler")) {
                if (p.getStudio().getFilm().getJudul().equals("Bumblebee")) {
                    int idFilm = p.getStudio().getFilm().getIdFilm();
                    int idStudio = p.getStudio().getIdStudio();
                    newValue.getStudio().setIdStudio(idStudio);
                    newValue.getStudio().getFilm().setIdFilm(idFilm);
                }
            }
        }
        
        newValue.save();
        for (Pembelian beli : new Pembelian().getAll()) {
            System.out.println(beli.getIdPembelian()+" "+beli.getKursi().getKode()+" "+beli.getStudio().getStudio()+" "+beli.getStudio().getFilm().getJudul()+" "+beli.getKursi().getStatus());
        }
        
    }
    /*
    public static boolean isBooking(String kode, String judul){
    boolean ans = false;
    for (Pembelian beli : new Pembelian().getAll()) {
        if (beli.getKursi().getKode().equals(kode) && beli.getStudio().getFilm().getJudul().equals(judul)) {
            if (beli.getKursi().getStatus().equals("book")) {
                ans = true;                    
            }
        }
    }
    return ans;
    } */  
    
}
