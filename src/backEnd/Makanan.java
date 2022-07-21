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
public class Makanan {
    private int idmakanan;
    private int harga = 0;
    private String nama_makanan;
    
    public Makanan(){};

    public int getIdmakanan() {
        return idmakanan;
    }

    public void setIdmakanan(int idmakanan) {
        this.idmakanan = idmakanan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }
    
    public Makanan getById(int id)
    {
        Makanan m = new Makanan();
        ResultSet rs = DBHelper.SelectQuery("SELECT * FROM makanan " 
                + " WHERE idmakanan ='" + id +"'");
        try{
            while(rs.next()){
                m = new Makanan();
                m.setIdmakanan(rs.getInt("idmakanan"));
                m.setNama_makanan(rs.getString("nama_makanan"));
                m.setHarga(rs.getInt("harga"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return m;
    }
    public ArrayList<Makanan>getAll()
    {
        ArrayList<Makanan> ListMakanan = new ArrayList();
        ResultSet rs = DBHelper.SelectQuery("SELECT * FROM makanan");
        try
        {
            while(rs.next())
            {
                Makanan m = new Makanan();
                m.setIdmakanan(rs.getInt("idmakanan"));
                m.setNama_makanan(rs.getString("nama_makanan"));
                m.setHarga(rs.getInt("harga"));
                ListMakanan.add(m);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ListMakanan;
    }   
    public void save()
    {
        if(getById(idmakanan).getIdmakanan()==0)
        {
            String SQL = "INSERT INTO makanan(nama_makanan,harga)Values("
                    +" '"+this.nama_makanan+"',"
                    +" '"+this.harga+"')";
            this.idmakanan=DBHelper.insertQueryGetId(SQL);
        }
        else
        {
            String SQL = "UPDATE makanan SET "
                    +" nama_makanan = '"+this.nama_makanan+"',"
                    +" harga = '"+this.harga+"'"
                    +" WHERE idmakanan = '"+this.idmakanan+"'";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete()
    {
        String SQL = "DELETE FROM makanan WHERE idmakanan='"+this.idmakanan+"'";
        DBHelper.executeQuery(SQL);
    }
    public ArrayList<Makanan> search(String keyword)
    {
        ArrayList<Makanan> ListMakanan = new ArrayList();
        String SQL = "SELECT * FROM makanan WHERE "
                +" nama_makanan LIKE '%"+keyword+"%'";
        ResultSet rs = DBHelper.SelectQuery(SQL);
        try
        {
            while(rs.next())
            {
                Makanan m = new Makanan();
                m.setIdmakanan(rs.getInt("idmakanan"));
                m.setNama_makanan(rs.getString("nama_makanan"));
                m.setHarga(rs.getInt("harga"));
                ListMakanan.add(m);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ListMakanan;
    }
    @Override
    public String toString(){
        return nama_makanan;
    }
}
