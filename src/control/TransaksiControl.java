/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import dao.TransaksiDAO;
import java.util.List;
import model.Transaksi;
import table.TableTransaksi;

/**
 *
 * @author LENOVO
 */
public class TransaksiControl {
    private TransaksiDAO trDAO = new TransaksiDAO();
    
    public void insertTransaksi(Transaksi tr){
        trDAO.insertTransaksi(tr);
    }
    
    public TableTransaksi showTransaksi(String query) {
        List<Transaksi> dataTransaksi = trDAO.showTransaksi(query);
        TableTransaksi tableTransaksi = new TableTransaksi(dataTransaksi);
        
        return tableTransaksi;
    }
    
    public void updateTransaksi(Transaksi tr){
        trDAO.updateTransaksi(tr);
    }
    public void deleteTransaksi(int id){
        trDAO.deleteTransaksi(id);
    }
    
}
