/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Computer;
import model.Pembeli;
import model.Transaksi;



/**
 *
 * @author LENOVO
 */
public class TransaksiDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertTransaksi(Transaksi tr){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO computer_transaksi(id_computer,id_pembeli, tanggal_transaksi, total_harga, bonus) "
                    + "VALUES ('" + tr.getComputer().getId() + "','" + tr.getPembeli().getId() + "','" + tr.getTanggal_transaksi()+ "','"
                    + tr.getTotal_harga() + "','" + tr.getBonus()+"')";
        
        System.out.println("Adding Transaksi...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " Transaksi");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Adding Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Transaksi> showTransaksi(String query) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT tr.*, c.*, p.* FROM computer_transaksi as tr JOIN computer as c ON tr.id_computer = c.id"
                + " JOIN computer_pembeli as p ON tr.id_pembeli = p.id WHERE "
                + "(c.nama LIKE"
                + "'%" +query+ "%'"
                + "OR c.jenis LIKE '%" +query+ "%'"
                + "OR p.nama LIKE '%" +query+ "%'"
                + "OR tr.tanggal_transaksi LIKE '%" +query+ "%'"
                + "OR tr.total_harga LIKE '%" +query+ "%'"
                + "OR tr.bonus LIKE '%" +query+ "%'"
                + "OR c.dayaListrik LIKE '%" +query+ "%'"
                + "OR p.alamat LIKE '%" +query+ "%'"
                + "OR p.no_telepon LIKE '%" +query+ "%'"
                + "OR c.kapasitasBaterai LIKE '%" +query+ "%')";
        
        System.out.println("Mengambil data Transaksi...");
       
        List<Transaksi> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null) {
                while(rs.next()) {
                    
                    
                    Computer c = new Computer(
                            rs.getString("c.id"),
                            rs.getString("nama"),
                            rs.getString("processor"),
                            rs.getString("jenis"),
                            rs.getInt("kapasitasRAM"),
                            rs.getInt("dayaListrik"),
                            rs.getInt("kapasitasBaterai"));
                    
                    
                    Pembeli p = new Pembeli(
                            Integer.parseInt(rs.getString("p.id")), 
                            rs.getString("p.nama"),
                            rs.getString("p.alamat"),
                            rs.getString("p.no_telepon"));
                    
                    Transaksi tr = new Transaksi(Integer.parseInt(
                            rs.getString("tr.id")), 
                            rs.getString("tr.tanggal_transaksi"), 
                            rs.getString("tr.total_harga"), 
                            rs.getString("tr.bonus"), 
                            c, 
                            p);
                            
                            
                    list.add(tr);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
      
    }
    
     public void updateTransaksi(Transaksi tr) {
        con = dbCon.makeConnection();
        
         System.out.println(tr.getComputer().getId());
        
        String sql = "UPDATE computer_transaksi SET id =" + tr.getId() +","
                    + "id_computer = '" +tr.getComputer().getId()+ "', "
                    + "id_pembeli = " +tr.getPembeli().getId()+ ", "
                    + "tanggal_transaksi = '"+tr.getTanggal_transaksi()+ "', "
                    + "total_harga = '" +tr.getTotal_harga()+ "', "
                    + "bonus = '" +tr.getBonus() +"' "
                    + "WHERE id = '" +tr.getId()+"'";
        
        System.out.println("Editing Transaksi...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " +result+ " Transaksi" +tr.getId());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
     public void deleteTransaksi(int id) {
         con = dbCon.makeConnection();
         
         String sql = "DELETE FROM computer_transaksi WHERE id = "+ id +"";
         System.out.println("Deleting Transaksi...");
         
         try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " +result+ " Transaksi " +id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
     }
}
