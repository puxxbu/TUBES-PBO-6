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
public class PembeliDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertPembeli(Pembeli p){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO computer_pembeli(id,nama, alamat, no_telepon) "
                    + "VALUES ('" + p.getId() + "','" + p.getNama()+ "','" + p.getAlamat()+ "','"
                    + p.getNo_telepon()+"')";
        
        System.out.println("Adding Pembeli...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " Pembeli");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Adding Pembeli...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void updatePembeli(Pembeli p) {
        con = dbCon.makeConnection();
        
        
        String sql = "UPDATE computer_pembeli SET id =" + p.getId() +","
                    + "nama = '" +p.getNama()+ "', "
                    + "alamat = '" +p.getAlamat()+ "', "
                    + "no_telepon = '" +p.getNo_telepon() +"' "
                    + "WHERE id = '" +p.getId()+"'";
        
        System.out.println("Editing Pembeli...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " +result+ " Pembeli" +p.getId());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Pembeli...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
     public void deletePembeli(int id) {
         con = dbCon.makeConnection();
         
         String sql = "DELETE FROM computer_pembeli WHERE id = "+ id +"";
         System.out.println("Deleting Pembeli...");
         
         try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " +result+ " Pembeli " +id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Pembeli...");
            System.out.println(e);
        }
        dbCon.closeConnection();
     }
     
     public List<Pembeli> showPembeliBySearch(String query) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT  p.* FROM computer_pembeli as p "
                + " WHERE "
                + "(p.id LIKE"
                + "'%" +query+ "%'"
                + "OR p.nama LIKE '%" +query+ "%'"
                + "OR p.alamat LIKE '%" +query+ "%'"
                + "OR p.no_telepon LIKE '%" +query+ "%')";
        
        System.out.println("Mengambil data Pembeli...");
       
        List<Pembeli> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null) {
                while(rs.next()) {

                    Pembeli p = new Pembeli(
                            Integer.parseInt(rs.getString("p.id")), 
                            rs.getString("p.nama"),
                            rs.getString("p.alamat"),
                            rs.getString("p.no_telepon"));
          
                    list.add(p);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading Pembeli...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
      
    }
    
    public List<Pembeli> showListPembeli() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM computer_pembeli";
        System.out.println("Mengambil data Pembeli...");
        
        List<Pembeli> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null) {
                while(rs.next()) {
                    Pembeli p = new Pembeli(
                            Integer.parseInt(rs.getString("id")), 
                            rs.getString("nama"),
                            rs.getString("alamat"),
                            rs.getString("no_telepon"));
                    
                    list.add(p);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading Pembeli...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
      
    }
    
}
