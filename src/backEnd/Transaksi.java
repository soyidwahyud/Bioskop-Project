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
public class Transaksi 
{
    private int idTransaksi;
    private String judul, Studio, kodekursi, nama_makanan,nama_minuman;
    private int total;
    
    public Transaksi()
    {
        
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public String getNama_minuman() {
        return nama_minuman;
    }

    public void setNama_minuman(String nama_minuman) {
        this.nama_minuman = nama_minuman;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String Studio) {
        this.Studio = Studio;
    }

    public String getKodekursi() {
        return kodekursi;
    }

    public void setKodekursi(String kodekursi) {
        this.kodekursi = kodekursi;
    }
    

    public Transaksi getByIdTransaksi(int id)
    {
    	Transaksi t = new Transaksi(); 
    	ResultSet res = DBHelper.SelectQuery("SELECT " 
    		+ "kodetransaksi, "
    		+ "judul, "
    		+ "Studio, "
    		+ "kodekursi, "
                + "nama_makanan, "
                + "nama_minuman, "
                + "totalharga "
    		+ "FROM transaksi "
    		+ "WHERE kodetransaksi = '" + id +"'");

    	try
    	{
    		while(res.next())
    		{
                    t = new Transaksi();
                    t.setIdTransaksi(res.getInt("kodetransaksi"));
                    t.setJudul(res.getString("judul"));
                    t.setStudio(res.getString("Studio"));
                    t.setKodekursi(res.getString("kodekursi"));
                    t.setNama_makanan(res.getString("nama_makanan"));
                    t.setNama_minuman(res.getString("nama_minuman"));
                    t.setTotal(res.getInt("totalharga"));
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return t;
    }
    public ArrayList<Transaksi> getAll(){
        Transaksi t = new Transaksi();
        ArrayList<Transaksi> listTransaksi = new ArrayList();
        ResultSet res = DBHelper.SelectQuery("SELECT "
                + "t.kodetransaksi, "
    		+ "t.judul, "
    		+ "t.Studio, "
    		+ "t.kodekursi, "
                + "t.nama_makanan, "
                + "t.nama_minuman, "
                + "t.totalharga "
    		+ "FROM transaksi t"
                + "  ");
        try {
            while (res.next()) {              
                t = new Transaksi();
                t.setIdTransaksi(res.getInt("kodetransaksi"));
                t.setJudul(res.getString("judul"));
                t.setStudio(res.getString("Studio"));
                t.setKodekursi(res.getString("kodekursi"));
                t.setNama_makanan(res.getString("nama_makanan"));
                t.setNama_minuman(res.getString("nama_minuman"));
                t.setTotal(res.getInt("totalharga"));
                listTransaksi.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }
    
    public void save(){
        if (getByIdTransaksi(idTransaksi).getIdTransaksi() == 0) {
            String query = "INSERT INTO transaksi(judul,Studio,kodekursi,nama_makanan, nama_minuman,totalharga)"
                    + "VALUES("
                    + " '"+this.judul+"', "
                    + " '"+this.Studio+"', "
                    + " '"+this.kodekursi+"', "
                    + " '"+this.nama_makanan+"', "
                    + " '"+this.nama_minuman+"', "
                    + " '"+this.total+"')";
            DBHelper.executeQuery(query);
        } 
        else 
        {
            String query = "UPDATE transaksi SET"
                    + " judul= '"+this.judul+"', "
                    + " Studio= '"+this.Studio+"',"
                    + " status= '"+this.kodekursi+"', "
                    + " nama_makanan= '"+this.nama_makanan+"', "
                    + " nama_minuman= '"+this.nama_minuman+"', "
                    + " totalharga= '" +this.total+"' "
                    + " WHERE idtransaksi = '"+this.idTransaksi+"'";
            DBHelper.executeQuery(query);
        }
    }
    
    public ArrayList<Transaksi> search(String cari){
        ArrayList<Transaksi> listTransaksi = new ArrayList();
        ResultSet res = DBHelper.SelectQuery("SELECT "
                + "t.judul AS Judul, "
                + "t.Studio AS Studio, "
                + "t.kodekursi AS Kursi, "
                + "t.nama_makanan AS Makan, "
                + "t.nama_minuman AS Minuman, "
                + "FROM transaksi t "
                + "WHERE t.judul LIKE '%"+cari+"%' OR "
                        + "t.studio LIKE '%"+cari+"%' OR"
                                + " t.kodekursi LIKE '%"+cari+"%' OR"
                                    + " t.nama_makanan LIKE '%"+cari+"%' OR"
                                            + " t.nama_minuman LIKE '%"+cari+"%' OR"
                                                + " t.totalharga LIKE '%"+cari+"%'");
        try {
            while (res.next()) {                
                Transaksi t = new Transaksi();
                t.setJudul(res.getString("judul"));
                t.setStudio(res.getString("Studio"));
                t.setKodekursi(res.getString("kursi"));
                t.setNama_makanan(res.getString("nama_makanan"));
                t.setNama_minuman(res.getString("nama_minuman"));
                t.setTotal(res.getInt("totalharga"));
           
                listTransaksi.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }
    public void delete(){
        String sql = "DELETE FROM transaksi WHERE kodetransaksi = '"+this.idTransaksi+"' ";
        DBHelper.executeQuery(sql);
    }
}
