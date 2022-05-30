/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Transaksi;

/**
 *
 * @author LENOVO
 */
public class TableTransaksi extends AbstractTableModel{
    private List<Transaksi> list;
    
    

    public TableTransaksi(List<Transaksi> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getComputer().getNama();
            case 1:
                return list.get(rowIndex).getComputer().getJenis();
            case 2:
                return list.get(rowIndex).getPembeli().getNama();
            case 3:
                return list.get(rowIndex).getTanggal_transaksi();
            case 4:
                return list.get(rowIndex).getTotal_harga();
            case 5:
                return list.get(rowIndex).getBonus();
            case 6:
                return list.get(rowIndex).getComputer().getDayaListrik();
            case 7:
                return list.get(rowIndex).getComputer().getKapasitasBaterai();
            //ujicoba
            case 8:
                return list.get(rowIndex).getId();
            case 9:
                return list.get(rowIndex).getPembeli().getId();
            case 10:
                return list.get(rowIndex).getComputer().getId();
                
                
                 
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama Computer";
            case 1:
                return "Jenis Computer";
            case 2:
                return "Nama Pembeli";
            case 3:
                return "Tanggal Transaksi";
            case 4:
                return "Total Harga";
            case 5:
                return "Bonus";
            case 6:
                return "Daya Listrik";
            case 7:
                return "Kapasitas Baterai";
            
                
            default:
                return null;
        }
        
    }

    
    
    
    
}
