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
public class Pembelian {
    private int idPembelian;
    private Kursi kursi = new Kursi();
    private Studio studio = new Studio();
    

    public Pembelian() {
    }

    public int getIdPembelian() {
        return idPembelian;
    }

    public void setIdPembelian(int idPembelian) {
        this.idPembelian = idPembelian;
    }

    public Kursi getKursi() {
        return kursi;
    }

    public void setKursi(Kursi kursi) {
        this.kursi = kursi;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
    
    public Pembelian getByIdPembelian(int id)
    {
        Pembelian p = new Pembelian();
        ResultSet res = DBHelper.SelectQuery("SELECT "
                + "b.idpembelian, "
                + "f.idfilm, "
                + "f.judul, "
                + "b.id_studio, "
                + "s.Studio, "
                + "b.kodekursi, "
                + "b.status "
                + "FROM beli b "
                + "LEFT JOIN studio s ON b.id_studio = s.id_studio "
                + "LEFT JOIN film f ON s.idfilm = f.idfilm "
                + "WHERE idpembelian = '"+id+"'");
        try 
        {
            while (res.next()) 
            {                
                p = new Pembelian();
                p.setIdPembelian(res.getInt("idpembelian"));
                p.getStudio().setIdStudio(res.getInt("id_studio"));
                p.getStudio().setStudio(res.getString("Studio"));
                p.getStudio().getFilm().setIdFilm(res.getInt("idfilm"));
                p.getStudio().getFilm().setJudul(res.getString("judul"));
                p.getKursi().setKode(res.getString("kodekursi"));
                p.getKursi().setStatus(res.getString("status"));          
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return p;
    }
    
    public ArrayList<Pembelian> getAll(){
        ArrayList<Pembelian> listBeli = new ArrayList();
        ResultSet res = DBHelper.SelectQuery("SELECT"
                + " b.idpembelian AS idpembelian, "
                + " f.idfilm AS idfilm, "
                + " f.judul AS judul,"
                + " b.id_studio AS id_studio, "
                + " s.Studio AS Studio, "
                + " b.kodekursi AS kodekursi, "
                + " b.status As status"
                + " FROM beli b LEFT JOIN studio s ON b.id_studio = s.id_studio"
                + " LEFT JOIN film f ON s.idfilm = f.idfilm "
                + "  ");
        try {
            while (res.next()) {              
                Pembelian p = new Pembelian();
                p.setIdPembelian(res.getInt("idpembelian"));
                p.getStudio().getFilm().setIdFilm(res.getInt("idfilm"));
                p.getStudio().getFilm().setJudul(res.getString("judul"));
                p.getStudio().setIdStudio(res.getInt("id_studio"));
                p.getStudio().setStudio(res.getString("Studio"));
                p.getKursi().setKode(res.getString("kodekursi"));
                p.getKursi().setStatus(res.getString("status"));
                
                listBeli.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBeli;
    }
    
    public void save(){
        if (getByIdPembelian(idPembelian).getIdPembelian() == 0) {
            String query = "INSERT INTO beli(id_studio,kodekursi,status) "
                    + " VALUES("
                    + " '"+this.getStudio().getIdStudio()+"', "
                    + " '"+this.getKursi().getKode()+"', "
                    + " '"+this.getKursi().getStatus()+"' )";
            this.idPembelian = DBHelper.insertQueryGetId(query);
        } else {
            String query = "UPDATE beli SET"
                    + " id_studio= '"+this.getStudio().getIdStudio()+"', "
                    + " kodekursi= '"+this.getKursi().getKode()+"',"
                    + " status= '"+this.getKursi().getStatus()+"' "
                    + " WHERE idpembelian = '"+this.idPembelian+"'";
            DBHelper.executeQuery(query);
        }
    }
    
    public ArrayList<Pembelian> search(String cari){
        ArrayList<Pembelian> listBeli = new ArrayList();
        ResultSet res = DBHelper.SelectQuery("SELECT "
                + "b.idpembelian AS idPembelian, "
                + "f.idfilm AS idFilm"
                + "f.judul AS Judul, "
                + "s.id_studio AS IdStudio, "
                + "s.Studio AS Studio, "
                + "b.kodekursi AS Kursi, "
                + "b.status AS Status"
                + "FROM beli b "
                + "LEFT JOIN studio s ON b.id_studio = s.id_studio "
                + "LEFT JOIN film f ON s.idfilm = f.idfilm "
                + "WHERE f.judul LIKE '%"+cari+"%' OR "
                        + "s.studio LIKE '%"+cari+"%' OR"
                                + " b.status LIKE '%"+cari+"%'");
        try {
            while (res.next()) {                
                Pembelian p = new Pembelian();
                p.setIdPembelian(res.getInt("idpembelian"));
                p.getStudio().setIdStudio(res.getInt("id_studio"));
                p.getStudio().setStudio(res.getString("Studio"));
                p.getStudio().getFilm().setIdFilm(res.getInt("idfilm"));
                p.getStudio().getFilm().setJudul(res.getString("judul"));
                p.getKursi().setKode(res.getString("kodekursi"));
                p.getKursi().setStatus(res.getString("status"));
                
                listBeli.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBeli;
    }
    public void delete(){
        String sql = "DELETE FROM beli WHERE idpembelian = '"+this.idPembelian+"' ";
        DBHelper.executeQuery(sql);
    }
}
