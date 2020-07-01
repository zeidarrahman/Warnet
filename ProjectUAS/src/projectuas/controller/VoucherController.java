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
import javax.swing.table.DefaultTableModel;
import projectuas.model.*;

/**
 *
 * @author ZEIDAR
 */
public class VoucherController {
    public Voucher[] dataVoucher = new Voucher[100];
    Koneksi koneksi=new Koneksi();
    public Kasir kasir;
    public int index = 0;
    
    public void setIndex(int index){
        this.index=index;
    }
    
    public int getIndex(){
        return index;
    }
    
    public void insert(String voucher, String tgl, int jam, String namaGuest,int harga) {
        Voucher vcr=new Voucher();
        vcr.Voucher(voucher, tgl, jam, namaGuest, harga);
        String i="INSERT INTO VOUCHER_07030 VALUES ('"+voucher+"',sysdate,"+jam+",'"+namaGuest+"',"+harga+")";
        this.koneksi.ManipulasiData(i);
        dataVoucher[index]= vcr;
        index++;
    }
    
    public Voucher search(String voucher){
        Voucher temp=null;
        for(int i=0; i<index; i++){
            if(voucher.equals(dataVoucher[i].getVoucher())){
                temp=dataVoucher[i];
            }
        }
        return temp;
    }
    
    public void delete(String voucher){
        Voucher temp=null;
        boolean ketemu=false;
        for(int i=0; i<index; i++){
            ketemu=true;
        }
        if(ketemu==true){
            String i="DELETE FROM VOUCHER_07030 WHERE USERNAME ="+voucher;
            koneksi.ManipulasiData(i);
            index--;
            ketemu=false;
            try {
                getDataVoucher();
            } catch (SQLException ex) {
                Logger.getLogger(VoucherController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void update(String voucher,String tgl,int jam, String namaGuest, int harga){
        boolean ketemu=false;
        for(int i=0; i<index; i++){
            if(dataVoucher[i].getVoucher()==voucher){
                dataVoucher[i].setVoucher(voucher);
                dataVoucher[i].setTgl(tgl);
                dataVoucher[i].setJam(jam);
                dataVoucher[i].setNamaGuest(namaGuest);
                dataVoucher[i].setHarga(harga);
                ketemu=true;
            }
        }
        if(ketemu==true){
            koneksi.ManipulasiData("Update VOUCHER_07030 set KODE_VOUCHER = '"+voucher+"', Tanggal = '"+tgl+"', Jam = "+jam+",Nama Guest = '"+namaGuest+", Harga ="+harga+" where KODE_VOUCHER ="+voucher);
            ketemu=false;
    }
    }
    
    public DefaultTableModel viewTable1() throws SQLException{
        DefaultTableModel tabelvoucher=new DefaultTableModel();
        tabelvoucher.addColumn("Voucher");
        tabelvoucher.addColumn("Tanggal");
        tabelvoucher.addColumn("Total Jam");
        tabelvoucher.addColumn("Nama Guest");
        tabelvoucher.addColumn("Username Kasir");
        tabelvoucher.addColumn("Harga total");
        
        
        /*for(int i=0; i<index; i++){
            Object[] temp1=new Object[6];
            temp1[0]=dataVoucher[i].getVoucher();
            temp1[1]=dataVoucher[i].getTgl();
            temp1[2]=dataVoucher[i].getJam();
            temp1[3]=dataVoucher[i].getNamaGuest();
            temp1[4]=dataVoucher[i].getNamaKasir();
            temp1[5]=dataVoucher[i].getHarga();
            tabelvoucher.addRow(temp1);
        }*/
        return tabelvoucher;
    }
    public void getDataVoucher() throws SQLException{
ResultSet rs=koneksi.GetData("SELECT * FROM VOUCHER_07030");
        while (rs.next()){
            Voucher vcr=new Voucher();
            vcr.setVoucher(rs.getString("KODE_VOUCHER"));
            vcr.setTgl(rs.getString("TANGGAL"));
            vcr.setJam(rs.getInt("TOTAL_JAM"));
            vcr.setNamaGuest(rs.getString("NAMA_GUEST_07030"));
            vcr.setHarga(rs.getInt("HARGA"));
        }

    
    }
    
}
