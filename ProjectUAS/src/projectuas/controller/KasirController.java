/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas.controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import projectuas.model.*;
import javax.swing.table.*;

import sun.util.logging.PlatformLogger;

/**
 *
 * @author ZEIDAR
 */
public class KasirController  {

    public Kasir[] dataKasir = new Kasir[100];
    Koneksi koneksi= new Koneksi();
    static private int index = 0;
    
    public void setIndex(int index){
        this.index=index;
    }
    
    public int getIndex() {
        return index;
    }

     public void insert(String username, String password, String noTelp, String alamat) {
        Kasir ksr=new Kasir();
        ksr.Kasir(username, password, noTelp, alamat);
        String i="INSERT INTO KASIR_07030 VALUES ('"+username+"','"+password+"','"+alamat+"','"+noTelp+"')";
        System.out.println(i);
       this.koneksi.ManipulasiData(i);
       dataKasir[index]=ksr;
        index++;

    }

    /**
     *
     * @return
     * @throws SQLException
     */
   
   
    public Kasir cariObjek(String username) {
        Kasir temp = null;
        for (int i = 0; i < index; i++) {
            if (username.equals(dataKasir[i].getUsername())) {
                temp = dataKasir[i];
            }
        }
        return temp;
    }
    public void delete(String username){
        Kasir temp=null;
        boolean ketemu=false;
        for(int i=0; i<index; i++){
            ketemu=true;
        }
        if(ketemu==true){
            String i="DELETE FROM KASIR_07030 WHERE USERNAME ="+username;
            koneksi.ManipulasiData(i);
            index--;
           
            try{
                getDataKasir();
            } catch (SQLException ex){
                Logger.getLogger(KasirController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void update(String username, String password, String noTelp, String alamat ){
        boolean ketemu=false;
        for(int i=0; i<index; i++){
            if(dataKasir[i].getUsername()==username){
                dataKasir[i].setUsername(username);
                dataKasir[i].setPassword(password);
                dataKasir[i].setNoTelp(noTelp);
                dataKasir[i].setAlamat(alamat);
            }
        }
        if(ketemu==true){
            koneksi.ManipulasiData("UPDATE KASIR_07030 set USERNAME= '"+username+"', Password = '"+password+"', No_telp = '"+noTelp+"', Alamat ='"+alamat+" WHERE USERNAME ="+username);
        }
    }
    
    
 public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel modelKasir = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int a, int b) {
                return false;
            }

        };
        modelKasir.addColumn("Username ");
        modelKasir.addColumn("Password ");
        modelKasir.addColumn("No Telp ");
        modelKasir.addColumn("Alamat ");
        
        ResultSet rs= koneksi.GetData("SELECT * from Kasir_07030");
        while (rs.next()){
            Object data[] = new Object[5];
            data[0] = rs.getString("USERNAME");
            data[1]= rs.getString("PASSWORD");
            data[2]= rs.getString("NO_TELP");
            data[3]= rs.getString("ALAMAT");
            modelKasir.addRow(data);
        }
      /*  for (int i = 0; i < index; i++) {
            Object[] temp = new Object[4];
            temp[0] = dataKasir[i].getUsername();
            temp[1] = dataKasir[i].getPassword();
            temp[2] = dataKasir[i].getNoTelp();
            temp[3] = dataKasir[i].getAlamat();
            modelKasir.addRow(temp);
        }*/
        return modelKasir;
    }
 public void getDataKasir() throws SQLException{
        index=0;
        ResultSet rs=koneksi.GetData("SELECT * FROM KASIR_07030");
        while (rs.next()){
            Kasir k=new Kasir();
            k.setUsername(rs.getString("USERNAME"));
            k.setPassword(rs.getString("PASSWORD"));
            k.setNoTelp(rs.getString("NO_TELP"));
            k.setAlamat(rs.getString("ALAMAT"));
            
        }
    }

}
