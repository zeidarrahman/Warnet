/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas.controller;

import javax.swing.table.DefaultTableModel;
import projectuas.model.*;
import Database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ZEIDAR
 */
public class KomputerController {
    public Komputer[] dataKomputer=new Komputer[100];
    Koneksi koneksi=new Koneksi();
    public int index=0;
    
    public void insert(int idKomp){
        Komputer kmp=new Komputer();
        kmp.Komputer(idKomp);
        String i="INSERT INTO KOMPUTER_07030 VALUES("+idKomp+")";
        System.out.println(i);
        this.koneksi.ManipulasiData(i);
        dataKomputer[index]=kmp;
        index++;
    }
    
    public Komputer search(int cari){
        Komputer temp=null;
        for(int i=0; i<index; i++){
            if(dataKomputer[i].getIdKomp()==cari){
                temp=dataKomputer[i];
            }
        }
       return temp; 
    }
    
    public void delete(int cari){
        Komputer temp=null;
        boolean ketemu=false;
        for(int i=0; i<index; i++){
            ketemu=true;
        }
        if(ketemu==true){
            String i="DELETE FROM KOMPUTER_07030 WHERE ID_KOMP ="+cari;
            koneksi.ManipulasiData(i);
            index--;
            ketemu=false;
            try{
                getDataKomputer();
            }catch (SQLException ex){
                Logger.getLogger(KomputerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void update(int cari){
        boolean ketemu=false;
        for(int i=0; i<index; i++){
            if(dataKomputer[i].getIdKomp()==cari){
                dataKomputer[i].setIdKomp(i);
            }
        }
    }
    
    public DefaultTableModel viewTable2() throws SQLException{
        DefaultTableModel tabelKomputer=new DefaultTableModel();
        
        tabelKomputer.addColumn("Id Komputer");
        
        ResultSet rs=koneksi.GetData("SELECT * FROM KOMPUTER_07030");
        while(rs.next()){
            Object data[]=new Object[1];
            data[0]=rs.getInt("ID_KOMP");
            tabelKomputer.addRow(data);
        }
        
        /*for(int i=0; i<index; i++){
            Object[] temp2=new Object[1];
            temp2[0]=dataKomputer[i].getIdKomp();
            tabelKomputer.addRow(temp2);
         }*/
        return tabelKomputer;
    }
    public void getDataKomputer() throws SQLException{
        index=0;
        ResultSet rs=koneksi.GetData("SELECT * FROM KOMPUTER_07030");
        while (rs.next()){
            Komputer ko=new Komputer();
            ko.setIdKomp(rs.getInt("ID_KOMP"));
        }
}
}