/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas.controller;
import projectuas.controller.*;
import Database.Koneksi;
import java.sql.*;
import java.text.*;
/**
 *
 * @author ZEIDAR
 */
public class getData {
    Koneksi koneksi;
    SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
    Date tgl;
    public getData() throws SQLException{
        koneksi= new Koneksi();
        getDataKasir();
    }
}
