/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * Benidiktus Valerino Gozen - 200710606
 */
public class Computer {
    private String id,nama,processor,jenis;
    private int kapasitasRAM,dayaListrik,kapasitasBaterai;

    public Computer(String id, String nama, String processor, String jenis, int kapasitasRAM, int dayaListrik, int kapasitasBaterai) {
        this.id = id;
        this.nama = nama;
        this.processor = processor;
        this.jenis = jenis;
        this.kapasitasRAM = kapasitasRAM;
        this.dayaListrik = dayaListrik;
        this.kapasitasBaterai = kapasitasBaterai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getKapasitasRAM() {
        return kapasitasRAM;
    }

    public void setKapasitasRAM(int kapasitasRAM) {
        this.kapasitasRAM = kapasitasRAM;
    }

    public int getDayaListrik() {
        return dayaListrik;
    }

    public void setDayaListrik(int dayaListrik) {
        this.dayaListrik = dayaListrik;
    }

    public int getKapasitasBaterai() {
        return kapasitasBaterai;
    }

    public void setKapasitasBaterai(int kapasitasBaterai) {
        this.kapasitasBaterai = kapasitasBaterai;
    }
    
    @Override
    public String toString(){
        return nama;
        
    }
    
    
    
    public String showData(){
        
        return this.id + " | " + this.nama + " | " + this.processor
                + " | " + this.kapasitasRAM + " | " ;
    }
    
    
    
}
