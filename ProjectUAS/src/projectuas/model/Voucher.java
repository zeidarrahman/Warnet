/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author ZEIDAR
 */
public class Voucher {
   public Kasir ksr;
   public Paket pkt;
    public String voucher;
    public String tgl;
    public int jam;
    DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
    Date date=new Date();
   // public String namaKasir;
    public String namaGuest;
    public int harga;
    public int index = 0;
    public Voucher[] Modelvoucher = new Voucher[100];
    


    

    public void Voucher(String voucher,Kasir ksr,Paket pkt, String tgl, int jam, String namaGuest, int harga) {
        this.ksr=ksr;
        this.pkt=pkt;
        this.voucher = voucher;
        this.tgl = df.format(date);
        this.jam = jam;
        this.namaGuest = namaGuest;
        this.harga=harga*jam;
    }

    public Kasir getKsr() {
        return ksr;
    }

    public void setKsr(Kasir ksr) {
        this.ksr = ksr;
    }

    public Paket getPkt() {
        return pkt;
    }

    public void setPkt(Paket pkt) {
        this.pkt = pkt;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }
    
    public void setNamaGuest(String namaGuest) {
        this.namaGuest = namaGuest;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
     
    public void setIndex(int index) {
        this.index = index;
    }

   
   
    public String getVoucher() {
        return voucher;
    }

    public String getTgl() {
        return tgl;
    }

    public int getJam() {
        return jam;
    }

    

    public String getNamaGuest() {
        return namaGuest;
    }
    public int getHarga(){
        return harga;
    }

}
