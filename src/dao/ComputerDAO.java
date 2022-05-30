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


/**
 *
 * Benidiktus Valerino Gozen - 200710606
 */
public class ComputerDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insert(Computer c){
        con = dbCon.makeConnection();
        
        String sql = " INSERT INTO computer(id,nama,processor,kapasitasRAM,jenis,dayaListrik,kapasitasBaterai)"
                + "VALUES ('" + c.getId()+"', '"+ c.getNama()+"', '"+
                c.getProcessor()+"', '"+ c.getKapasitasRAM() +"', '"+
                c.getJenis() +"', '"+ c.getDayaListrik() +"', '"+
                c.getKapasitasBaterai() + "')";
        
        System.out.println("Adding Computer...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result );
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding ...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Computer> showComputer(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM computer";
        System.out.println("Mengambil data ...");
        
        List<Computer> list = new ArrayList<>();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {                    
                    Computer c = new Computer(
                            rs.getString("id"),
                            rs.getString("nama"),
                            rs.getString("processor"),
                            rs.getString("jenis"),
                            rs.getInt("kapasitasRAM"),
                            rs.getInt("dayaListrik"),
                            rs.getInt("kapasitasBaterai"));
                    
                    list.add(c);
                    
                    
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding ...");
            System.out.println(e);
        }
        return list;
    }
    
    public Computer searchComputer (String id){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM computer WHERE id = '"
                + id + "'";
        System.out.println("Searching ...");
        Computer c = null;
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {                    
                    c = new Computer(rs.getString("id"),
                            rs.getString("nama"),
                            rs.getString("processor"),
                            rs.getString("jenis"),
                            rs.getInt("kapasitasRAM"),
                            rs.getInt("dayaListrik"),
                            rs.getInt("kapasitasBaterai"));
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return c;
        
    }
    
    public void updateFilm (Computer c, String id){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE computer SET id = '" +c.getId() +"',"
                + "nama = '" + c.getNama() + "',"
                + "processor = '" + c.getProcessor() + "',"
                + "kapasitasRAM = '" + c.getKapasitasRAM()+ "',"
                + "jenis = '" + c.getJenis()+ "',"
                + "dayaListrik = '" + c.getDayaListrik()+ "',"
                + "kapasitasBaterai = '" + c.getKapasitasBaterai()+ "' "
                + "WHERE id = '" + id + "'";
        System.out.println("Editing ...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Computer " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
public void deleteComputer(String id){
    con = dbCon.makeConnection();
    
    String sql = "DELETE FROM computer WHERE id = '"
            + id + "'";
    System.out.println("Deleting Computer...");
    
    try {
        Statement statement = con.createStatement();
        int result = statement.executeUpdate(sql);
        System.out.println("Delete " + result + " Computer " + id);
        statement.close();
    } catch (Exception e) {
        System.out.println("Error reading database...");
        System.out.println(e);
    }
    dbCon.closeConnection();
}    
    
}
