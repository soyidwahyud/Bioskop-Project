/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Rifaul06
 */
public class Kursi {
    private String kode;
    private String status;

    public Kursi() {
    }

    public Kursi(String kode, String status) {
        this.kode = kode;
        this.status = status;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
