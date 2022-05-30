/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ComputerDAO;
import java.util.List;
import model.Computer;


/**
 *
 * Benidiktus Valerino Gozen - 200710606
 */
public class ComputerControl {
    private ComputerDAO cDao = new ComputerDAO();
    
    public void insertDataComputer(Computer c){
        cDao.insert(c);
    }
    
    public String showDataComputer(){
        List<Computer> dataDesktop = cDao.showComputer();
        
        String computerString = "";
        
        for (int i = 0; i < dataDesktop.size(); i++) {
            if (dataDesktop.get(i).getJenis().contains("Desktop")) {
                computerString  = computerString  + dataDesktop.get(i).showData()
                         + dataDesktop.get(i).getDayaListrik() + "\n";
            }
            
        }
       
        return computerString;
        
    }
    
    public int countDataComputer(){
        List<Computer> dataDesktop = cDao.showComputer();
        
        int count =1;
        
        for (int i = 0; i < dataDesktop.size(); i++) {
            if (dataDesktop.get(i).getJenis().contains("Desktop")) {
                count++;
            }
            
        }
        
        return count;
        
    }
    
    public String showDataLaptop(){
        List<Computer> dataLaptop = cDao.showComputer();
        
        String laptopString = "";
        
        for (int i = 0; i < dataLaptop.size(); i++) {
            
            if (dataLaptop.get(i).getJenis().contains("Laptop")) {
                
                laptopString  = laptopString  + dataLaptop.get(i).showData()
                         + dataLaptop.get(i).getKapasitasBaterai()+ " \n" ;
            }
            
        }
        return laptopString;
        
    }
    
    public List<Computer> showListAllComputer(){
         List<Computer> dataComputer = cDao.showComputer();
        return dataComputer;
    }
    
    public int countDataLaptop(){
        List<Computer> dataLaptop = cDao.showComputer();
        
        int count =1;
        
        for (int i = 0; i < dataLaptop.size(); i++) {
            if (dataLaptop.get(i).getJenis().contains("Laptop")) {
                count++;
            }
            
        }
        
        return count;
        
    }
    
    public Computer searchComputer(String id){
        Computer c = null;
        c = cDao.searchComputer(id);
        
        return c;
        
    }
    
    public void updateDataComputer(Computer c, String id){
        cDao.updateFilm(c, id);
    }
    
    public void deleteDataComputer(String id){
        cDao.deleteComputer(id);
    }
}
