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
 * @author soyidwahyud
 */
public class Minuman {
    private int idminuman, harga = 0;
    private String nama_minuman;
    
    public Minuman(){};

    public int getIdminuman() {
        return idminuman;
    }

    public void setIdminuman(int idminuman) {
        this.idminuman = idminuman;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama_minuman() {
        return nama_minuman;
    }

    public void setNama_minuman(String nama_minuman) {
        this.nama_minuman = nama_minuman;
    }
    
    public Minuman getById(int id)
    {
        Minuman m = new Minuman();
        ResultSet rs = DBHelper.SelectQuery("SELECT * FROM minuman " 
                + " WHERE idminuman ='" + id +"'");
        try{
            while(rs.next()){
                m = new Minuman();
                m.setIdminuman(rs.getInt("idminuman"));
                m.setNama_minuman(rs.getString("nama_minuman"));
                m.setHarga(rs.getInt("harga"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return m;
    }
    public ArrayList<Minuman>getAll()
    {
        ArrayList<Minuman> ListMinuman = new ArrayList();
        ResultSet rs = DBHelper.SelectQuery("SELECT * FROM minuman");
        try
        {
            while(rs.next())
            {
                Minuman m = new Minuman();
                m.setIdminuman(rs.getInt("idminuman"));
                m.setNama_minuman(rs.getString("nama_minuman"));
                m.setHarga(rs.getInt("harga"));
                ListMinuman.add(m);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ListMinuman;
    }   
    public void save()
    {
        if(getById(idminuman).getIdminuman()==0)
        {
            String SQL = "INSERT INTO minuman (nama_minuman, harga) Values("
                    +" '"+this.nama_minuman+"',"
                    +" '"+this.harga+"')";
            this.idminuman=DBHelper.insertQueryGetId(SQL);
        }
        else
        {
            String SQL = "UPDATE minuman SET "
                    +" nama_minuman = '"+this.nama_minuman+"',"
                    +" harga = '"+this.harga+"'"
                    +" WHERE idminuman = '"+this.idminuman+"'";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete()
    {
        String SQL = "DELETE FROM minuman WHERE idminuman='"+this.idminuman+"'";
        DBHelper.executeQuery(SQL);
    }
    public ArrayList<Minuman> search(String keyword)
    {
        ArrayList<Minuman> ListMinuman = new ArrayList();
        String SQL = "SELECT * FROM minuman WHERE "
                +" nama_minuman LIKE '%"+keyword+"%'";
        ResultSet rs = DBHelper.SelectQuery(SQL);
        try
        {
            while(rs.next())
            {
                Minuman m = new Minuman();
                m.setIdminuman(rs.getInt("idminuman"));
                m.setNama_minuman(rs.getString("nama_minuman"));
                m.setHarga(rs.getInt("harga"));
                ListMinuman.add(m);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ListMinuman;
    }
    @Override
    public String toString(){
        return nama_minuman;
    }
}
