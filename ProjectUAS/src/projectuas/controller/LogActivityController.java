/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas.controller;
import Database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import projectuas.model.*;
/**
 *
 * @author ZEIDAR
 */
public class LogActivityController {
    
    
    public LogActivity[] dataLog=new LogActivity[100];
    public int index=0;
    Koneksi koneksi=new Koneksi();
    
    
    public DefaultTableModel viewTable4() throws SQLException{
        DefaultTableModel tabelLog=new DefaultTableModel();
        tabelLog.addColumn("Kode Voucher");
        tabelLog.addColumn("Id Komp");
        tabelLog.addColumn("Tanggal Log");
        tabelLog.addColumn("Jam Login");
        tabelLog.addColumn("Jam Logout");
        
        ResultSet rs=koneksi.GetData("SELECT * FROM LOGACTIVITY_07030");
        while (rs.next()){
            Object data[]= new Object[5];
            data[0]=rs.getString("USERNAME");
            data[1]=rs.getInt("ID_KOMP");
            data[2]=rs.getString("TANGGAL_LOG");
            data[3]=rs.getInt("JAM_LOGIN");
            data[4]=rs.getInt("JAM_LOGOUT");
            tabelLog.addRow(data);
        }
      /*  for(int i=0; i<index; i++){
            Object[] temp4=new Object[5];
            temp4[0]=dataLog[i].getVoucher1();
            temp4[1]=dataLog[i].getIdKomp2();
            temp4[2]=dataLog[i].getTanggalLog();
            temp4[3]=dataLog[i].getJamLogin();
            temp4[4]=dataLog[i].getJamLogout();
        }*/
        return tabelLog;
    }
    
    public void getDataLog() throws SQLException{
       index=0;
       ResultSet rs=koneksi.GetData("SELECT * FROM LOGACTIVITY_07030");
       while (rs.next()){
           
       }
    }
    
}

