/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas.controller;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import projectuas.model.Admin;

/**
 *
 * @author ZEIDAR
 */
public class AdminController {
    
    private Admin[] dataAdmin =new Admin[100];
    private int index=0;
    
    public void insert(String username, String password, String alamat, String noTelp){
        dataAdmin[index]=new Admin(username,password,alamat,noTelp);
        index++;
    }
    
    public static String[] nama = new String[10];
    public static String[] pass = new String[10];
    public static int index1 = 0;

    public void addKasir(JTextField nama, JPasswordField password) {
        String getNama = nama.getText();
        String getPass = password.getText();
        this.nama[index] = getNama;
        this.pass[index] = getPass;
        index++;
    }
    public int getIndex(){
        return index;
    }
}
