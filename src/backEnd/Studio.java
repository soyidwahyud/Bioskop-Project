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
public class Studio {
    private int idStudio;
    private String Studio;
    private Film film = new Film();
    
    public Studio() {
    }

    public Studio(String Studio) {
        this.idStudio = idStudio;
        this.Studio = Studio;
    }

    public int getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(int idStudio) {
        this.idStudio = idStudio;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String Studio) {
        this.Studio = Studio;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    
    public Studio getByidStudio(int id){
        Studio studio = new Studio();
        ResultSet res = DBHelper.SelectQuery("SELECT "
                + " s.id_studio AS ID_Studio,"
                + " s.Studio AS Studio,"
                + " f.idfilm AS idFilm,"
                + " f.judul AS Judul"
                + " FROM studio s LEFT JOIN film f"
                + " ON s.idfilm = f.idfilm"
                + " WHERE s.id_studio = '"+id+"'");
        try {
            while (res.next()) {                
                studio = new Studio();
                studio.setIdStudio(res.getInt("id_studio"));
                studio.setStudio(res.getString("Studio"));
                studio.getFilm().setIdFilm(res.getInt("idfilm"));
                studio.getFilm().setJudul(res.getString("judul"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studio;
    }
    
    public ArrayList<Studio> getAll(){
        ArrayList<Studio> listStudio = new ArrayList();
        ResultSet res = DBHelper.SelectQuery("SELECT "
                + " s.id_studio AS ID_Studio,"
                + " s.Studio AS Studio,"
                + " f.idfilm As idFilm, "
                + " f.judul AS Judul"
                + " FROM studio s LEFT JOIN film f"
                + " ON s.idfilm = f.idfilm ");
        try {
            while (res.next()) {                
                Studio s = new Studio();
                s.setIdStudio(res.getInt("id_studio"));
                s.setStudio(res.getString("Studio"));
                s.getFilm().setIdFilm(res.getInt("idfilm"));
                s.getFilm().setJudul(res.getString("judul"));
                
                listStudio.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudio;
    }
    
    public void save(){
        if (getByidStudio(idStudio).getIdStudio() == 0) {
            String sql = "INSERT INTO studio(Studio, idfilm)"
                    + " VALUES("
                    + " '"+this.Studio+"',"
                    + " '"+this.getFilm().getIdFilm()+"' "
                    + " )";
            this.idStudio = DBHelper.insertQueryGetId(sql);
        } else {
            String sql = "UPDATE studio SET"
                    + " Studio='"+this.Studio+"',"
                    + " idfilm='"+this.getFilm().getIdFilm()+"' "
                    + " WHERE id_studio ='"+this.idStudio+"'";
            DBHelper.executeQuery(sql);
        }       
    }
    
    public void delete(){
        String sql = "DELETE FROM studio WHERE id_studio = '"+this.idStudio+"'";
        DBHelper.executeQuery(sql);
    }
    
    public ArrayList<Studio> Search(String cari){
        ArrayList<Studio> listStudio = new ArrayList();
        ResultSet res = DBHelper.SelectQuery("SELECT "
                + " s.id_studio AS ID_Studio,"
                + " s.Studio AS Studio,"
                + " f.judul AS 'Judul Film'"
                + " FROM studio s LEFT JOIN film f"
                + " ON s.idfilm = f.idfilm"
                + " WHERE s.id_studio LIKE '%"+cari+"%'");
        try {
            while (res.next()) {
                Studio studio = new Studio();
                studio = new Studio();
                studio.setIdStudio(res.getInt("id_studio"));
                studio.setStudio(res.getString("Studio"));
                studio.getFilm().setIdFilm(res.getInt("idfilm"));
                studio.getFilm().setJudul(res.getString("judul"));
                
                listStudio.add(studio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudio;
    }
}
