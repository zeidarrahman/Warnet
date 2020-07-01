/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import projectuas.model.*;
import projectuas.controller.*;
/**
 *
 * @author ZEIDAR
 */
public class LogActivityFrame {
    Voucher voc1;
    Komputer kmp2;
    public LogActivityFrame(){
        
        JFrame frameLog=new JFrame();
        frameLog.getContentPane().setBackground(Color.black);
        frameLog.setSize(800,800);
        frameLog.setLocationRelativeTo(null);
        frameLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLog.setLayout(null);
        
        
        JLabel labelLog=new JLabel("Log Activity");
        labelLog.setBackground(Color.black);
        labelLog.setForeground(Color.white);
        labelLog.setFont(new Font("Consolas",Font.BOLD,24));
        labelLog.setBounds(380, 0, 200, 100);
        frameLog.add(labelLog);
        
        
        JLabel labelKode=new JLabel("Voucher");
        labelKode.setBackground(Color.black);
        labelKode.setForeground(Color.white);
        labelKode.setBounds(25, 100, 100, 30);
        labelKode.setFont(new Font("Consolas",Font.PLAIN,14));
        frameLog.add(labelKode);
        
        JTextField textKode=new JTextField();
        textKode.setBackground(Color.black);
        textKode.setForeground(Color.white);
        textKode.setFont(new Font("Consolas",Font.PLAIN,14));
        textKode.setBounds(25, 130, 100, 30);
        frameLog.add(textKode);
        
        
        JLabel labelKomp=new JLabel("Id Komputer");
        labelKomp.setBackground(Color.black);
        labelKomp.setForeground(Color.white);
        labelKomp.setFont(new Font("Consolas",Font.PLAIN,14));
        labelKomp.setBounds(25, 160, 100, 30);
        frameLog.add(labelKomp);
        
        
        JTextField textKomp=new JTextField();
        textKomp.setBackground(Color.black);
        textKomp.setForeground(Color.white);
        textKomp.setFont(new Font("Consolas",Font.PLAIN,14));
        textKomp.setBounds(25, 190, 100, 30);
        frameLog.add(textKomp);
        
        
        JLabel tglLabel=new JLabel("Tanggal Log");
        tglLabel.setBackground(Color.black);
        tglLabel.setForeground(Color.white);
        tglLabel.setFont(new Font("Consolas",Font.PLAIN,14));
        tglLabel.setBounds(25, 220, 100, 30);
        frameLog.add(tglLabel);
        
        
        JTextField textTgl=new JTextField();
        textTgl.setBackground(Color.black);
        textTgl.setForeground(Color.white);
        textTgl.setFont(new Font("Consolas",Font.PLAIN,14));
        textTgl.setBounds(25, 250, 100, 30);
        frameLog.add(textTgl);
        
        
        JLabel loginLabel=new JLabel("Jam Login");
        loginLabel.setBackground(Color.black);
        loginLabel.setForeground(Color.white);
        loginLabel.setFont(new Font("Consolas",Font.PLAIN,14));
        loginLabel.setBounds(25, 280, 100, 30);
        frameLog.add(loginLabel);
        
        
        JTextField textLogin=new JTextField();
        textLogin.setBackground(Color.black);
        textLogin.setForeground(Color.white);
        textLogin.setFont(new Font("Consolas",Font.PLAIN,14));
        textLogin.setBounds(25, 310, 100, 30);
        frameLog.add(textLogin);
        
        
        JLabel logoutLabel=new JLabel("Jam Logout");
        logoutLabel.setBackground(Color.black);
        logoutLabel.setForeground(Color.white);
        logoutLabel.setFont(new Font("Consolas",Font.PLAIN,14));
        logoutLabel.setBounds(25, 340, 100, 30);
        frameLog.add(logoutLabel);
        
        
        JTextField textLogout=new JTextField();
        textLogout.setBackground(Color.black);
        textLogout.setForeground(Color.white);
        textLogout.setFont(new Font("Consolas",Font.PLAIN,14));
        textLogout.setBounds(25, 370, 100, 30);
        frameLog.add(textLogout);
        
        
        String[] fieldData={"Kode Voucher","Id Komputer","Tanggal Log","Jam Login","Jam Logout"};
        DefaultTableModel tabelDataLog=new DefaultTableModel(fieldData,0);
        JTable tabelLogAc=new JTable(tabelDataLog);
        TableColumn tc1=new TableColumn(),tc2=new TableColumn(),tc3=new TableColumn(),tc4=new TableColumn(),tc5=new TableColumn();
        JScrollPane scrollPaneLog=new JScrollPane(tabelLogAc);
        scrollPaneLog.setBounds(200, 130, 500, 500);
        tc1=tabelLogAc.getColumnModel().getColumn(0);
        tc2=tabelLogAc.getColumnModel().getColumn(1);
        tc3=tabelLogAc.getColumnModel().getColumn(2);
        tc4=tabelLogAc.getColumnModel().getColumn(3);
        tc5=tabelLogAc.getColumnModel().getColumn(4);
        
        tc1.setPreferredWidth(100);
        tc2.setPreferredWidth(100);
        tc3.setPreferredWidth(100);
        tc4.setPreferredWidth(100);
        tc5.setPreferredWidth(100);
        frameLog.add(scrollPaneLog);
        
        JButton buttonIN=new JButton("Insert");
        buttonIN.setBackground(Color.black);
        buttonIN.setForeground(Color.white);
        buttonIN.setFont(new Font("Consolas",Font.PLAIN,14));
        buttonIN.setBounds(25, 410, 100, 30);
        buttonIN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                       
               if(textTgl.getText().isEmpty()||textLogin.getText().isEmpty()||textLogout.getText().isEmpty()){
                   JOptionPane.showMessageDialog(null, "Data Kosong");
               }
               else{
                   String voucher1=textKode.getText();
                   int idKomp2=Integer.parseInt(textKomp.getText());
                   int getTglLog=Integer.parseInt(textTgl.getText());
               int getJamLogin=Integer.parseInt(textLogin.getText());
               int getJamLogout=Integer.parseInt(textLogout.getText());
               AllObject.log1.insert(voucher1,idKomp2,getTglLog, getJamLogin, getJamLogout);
               JOptionPane.showMessageDialog(null, "Data berhasil di Insert");
                   try {
                       tabelLogAc.setModel(AllObject.log1.viewTable4());
                   } catch (SQLException ex) {
                       Logger.getLogger(LogActivityFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }
        });
        frameLog.add(buttonIN);
        try {
            tabelLogAc.setModel(AllObject.log1.viewTable4());
        } catch (SQLException ex) {
            Logger.getLogger(LogActivityFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JButton buttonUp=new JButton("Update");
        buttonUp.setBackground(Color.black);
        buttonUp.setForeground(Color.white);
        buttonUp.setBounds(25, 445, 100, 30);
        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        frameLog.add(buttonUp);
        
        
        JButton buttonDel=new JButton("Delete");
        buttonDel.setBackground(Color.black);
        buttonDel.setForeground(Color.white);
        buttonDel.setBounds(25, 480, 100, 30);
        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        
        frameLog.add(buttonDel);
        
        JButton backButton=new JButton("<=");
        backButton.setBackground(Color.red);
        backButton.setForeground(Color.white);
        backButton.setBounds(700, 700, 50, 50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             MainFrame main1=new MainFrame();
             frameLog.dispose();
            }
        });
        frameLog.add(backButton);
        frameLog.setVisible(true);
    }
}
