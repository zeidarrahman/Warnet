/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas.controller;
import javax.swing.table.DefaultTableModel;
import projectuas.model.*;
/**
 *
 * @author ZEIDAR
 */
public class PaketController {
    public Paket[] dataPaket=new Paket[100];
    public int index=0;
    
    public void insert(int idPaket, String namaPaket, int jamPaket ){
        dataPaket[index]=new Paket(idPaket, namaPaket, jamPaket);
        index++;
    }
    
//    public void insert1(int idPaket){
//        dataPaket[index]=new Paket(idPaket);
//        index++;
//    }
//    
    public DefaultTableModel viewTable3(){
        DefaultTableModel tabelPaket=new DefaultTableModel();
        tabelPaket.addColumn("Id Paket");
        tabelPaket.addColumn("Nama Paket");
        tabelPaket.addColumn("Jam Paket");
        
        for(int i=0; i<index; i++){
            Object[] temp3=new Object[3];
            temp3[0]=dataPaket[i].getidPaket();
            temp3[1]=dataPaket[i].getnamaPaket();
            temp3[2]=dataPaket[i].getjamPaket();
            tabelPaket.addRow(temp3);
        }
        return tabelPaket;
    }
}
