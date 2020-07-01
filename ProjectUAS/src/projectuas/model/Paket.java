/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas.model;

/**
 *
 * @author ZEIDAR
 */
public class Paket {
    int idPaket,jamPaket;
    String namaPaket;
    
    public Paket(int idPaket, String namaPaket, int jamPaket){
        this.idPaket=idPaket;
        this.namaPaket=namaPaket;
        this.jamPaket=jamPaket;
    }
    
    public Paket(int idPaket){
        this.idPaket=idPaket;
    }
    
    public int getidPaket(){
        return idPaket;
    }
    public String getnamaPaket(){
        return namaPaket;
    }
    public int getjamPaket(){
        return jamPaket;
    }
}
