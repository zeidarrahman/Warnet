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
public class LogActivity {
    int tanggalLog,jamLogin,jamLogout;
    Voucher voc;
    Komputer kmp;
    
    public void LogActivity(String voucher1,int idKomp2, int tanggalLog, int jamLogin, int jamLogout ){
        this.tanggalLog=tanggalLog;
        this.jamLogin=jamLogin;
        this.jamLogout=jamLogout;
        this.voc.voucher=voucher1;
        this.kmp.idKomp=idKomp2;
                
    }
    public int getTanggalLog(){
        return tanggalLog;
    }
    public int getJamLogin(){
        return jamLogin;
    }
    public int getJamLogout(){
        return jamLogout;
    }
    
    public String getVoucher1(){
        return voc.getVoucher();
    }
    public int getIdKomp2(){
        return kmp.getIdKomp();
    }
}
