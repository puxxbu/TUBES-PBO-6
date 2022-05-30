/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Transaksi {
    private int id;
    private String tanggal_transaksi;
    private String total_harga;
    private String bonus;
    private Computer computer;
    private Pembeli pembeli;

    public Transaksi(int id, String tanggal_transaksi, String total_harga, String bonus, Computer computer, Pembeli pembeli) {
        this.id = id;
        this.tanggal_transaksi = tanggal_transaksi;
        this.total_harga = total_harga;
        this.bonus = bonus;
        this.computer = computer;
        this.pembeli = pembeli;
    }

    public Transaksi(String tanggal_transaksi, String total_harga, String bonus, Computer computer, Pembeli pembeli) {
        this.tanggal_transaksi = tanggal_transaksi;
        this.total_harga = total_harga;
        this.bonus = bonus;
        this.computer = computer;
        this.pembeli = pembeli;
    }
    
    

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(String total_harga) {
        this.total_harga = total_harga;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }
    
    public String getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setTanggal_transaksi(String tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    
    
    
    
    
}
