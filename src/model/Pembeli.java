/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Pembeli {
    private int id;
    private String nama;
    private String alamat;
    private String no_telepon;

    public Pembeli(int id, String nama, String alamat, String no_telepon) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
    }
    
    public Pembeli( String nama, String alamat, String no_telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }
    

    
    
    @Override 
    public String toString(){
        return nama;
        
    }
    
}
