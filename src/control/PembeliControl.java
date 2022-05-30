/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;


import java.util.List;
import model.Pembeli;
import dao.PembeliDAO;
import table.TablePembeli;



/**
 *
 * @author LENOVO
 */
public class PembeliControl {
    private PembeliDAO pDAO = new PembeliDAO();
    
    public List<Pembeli> showPembeli(){
        List<Pembeli> dataPembeli = pDAO.showListPembeli();
        return dataPembeli;
        
    }
     public void insertPembeli(Pembeli p){
        pDAO.insertPembeli(p);
    }
    
    public TablePembeli showDataPembeli(String query) {
        List<Pembeli> dataPembeli = pDAO.showPembeliBySearch(query);
        TablePembeli tablePembeli = new TablePembeli(dataPembeli);
        
        return tablePembeli;
    }
    
    public void updatePembeli(Pembeli p){
        pDAO.updatePembeli(p);
    }
    public void deletePembeli(int id){
        pDAO.deletePembeli(id);
    }
}
