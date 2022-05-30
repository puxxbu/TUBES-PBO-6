/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * Benidiktus Valerino Gozen - 200710606
 */
public class InputIDException extends Exception{
    public String message(){
        return "Panjang ID harus 5-8 digit";
    }
}

