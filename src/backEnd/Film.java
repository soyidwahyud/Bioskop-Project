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
public class Film {
    private int idFilm;
    private String judul;
    private String genre;
    
    public Film(){};

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public Film(String judul) {
        this.judul = judul;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public Film getById(int id){
        Film f = new Film();
        ResultSet rs = DBHelper.SelectQuery("SELECT * FROM film "
                + " WHERE idfilm = '"+id+"'");
        try {
            while (rs.next()) {
                f = new Film();
                f.setIdFilm(rs.getInt("idfilm"));
                f.setJudul(rs.getString("judul"));
                //f.setGenre(rs.getString("genre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    public ArrayList<Film> getAll(){
        ArrayList<Film> ListFilm = new ArrayList();
        ResultSet rs = DBHelper.SelectQuery("SELECT * FROM film");
        try {
            while (rs.next()) {                
                Film film = new Film();
                film.setIdFilm(rs.getInt("idfilm"));
                film.setJudul(rs.getString("judul"));
                //film.setGenre(rs.getString("genre"));
                ListFilm.add(film);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListFilm;
    }
    public void save(){
        if (getById(idFilm).getIdFilm() == 0) {
            String SQL = "INSERT INTO film (judul,genre) VALUES("
                    + " '"+this.judul+"')";
                    //+ " '"+this.genre+"')";
            this.idFilm = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE film SET "
                    + "judul = '"+this.judul+"' "
                    //+ "genre = '"+this.genre+"' "
                    + "WHERE idfilm ='"+this.idFilm+"'";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL = "DELETE FROM film WHERE idfilm = '"+this.idFilm+"'";
        DBHelper.executeQuery(SQL);
    }
    public ArrayList<Film> search(String keyword){
        ArrayList<Film> listFilm = new ArrayList();
        String sql = "SELECT * FROM film WHERE "
                + " judul LIKE '%"+keyword+"%';";
                //+ " genre LIKE '%"+keyword+"%';";
        ResultSet rs = DBHelper.SelectQuery(sql);
        try {
            while (rs.next()) {                
                Film film = new Film();
                film.setIdFilm(rs.getInt("idfilm"));
                film.setJudul(rs.getString("judul"));
                //film.setGenre(rs.getString("genre"));
                listFilm.add(film);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listFilm;
    }
    @Override
    public String toString(){
        return judul;
    }
}
