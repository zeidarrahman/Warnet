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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import projectuas.model.AllObject;
/**
 *
 * @author ZEIDAR
 */
public class KasirFrame {
       
        
        
    public KasirFrame() {
        
        JFrame frameAdmin = new JFrame();
        frameAdmin.setSize(700, 800);
        frameAdmin.getContentPane().setBackground(Color.black);
        frameAdmin.setLocationRelativeTo(null);
        frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdmin.setTitle("ADMIN");
        frameAdmin.setLayout(null);
        
        
        JLabel labelAdmin = new JLabel("Kasir");
        labelAdmin.setFont(new Font("Consolas", Font.BOLD, 24));
        labelAdmin.setBackground(Color.black);
        labelAdmin.setForeground(Color.white);
        labelAdmin.setBounds(310, 0, 100, 100);
        frameAdmin.add(labelAdmin);
        
        
        JLabel labelUser = new JLabel("Username");
        labelUser.setFont(new Font("Consolas", Font.PLAIN, 14));
        labelUser.setBackground(Color.black);
        labelUser.setForeground(Color.white);
        labelUser.setBounds(25, 100, 100, 30);
        frameAdmin.add(labelUser);
        
        
        JTextField textUser = new JTextField();
        textUser.setBackground(Color.black);
        textUser.setFont(new Font("Consolas", Font.PLAIN, 14));
        textUser.setForeground(Color.white);
        textUser.setBounds(25, 140, 120, 30);
        frameAdmin.add(textUser);
        
        
        JLabel labelPass = new JLabel("Password");
         labelPass.setBackground(Color.black);
        labelPass.setFont(new Font("Consolas", Font.PLAIN, 14));
        labelPass.setForeground(Color.white);
        labelPass.setBounds(25, 180, 100, 30);
        frameAdmin.add(labelPass);
        
        
        JPasswordField textPass = new JPasswordField();
        textPass.setBackground(Color.black);
        textPass.setFont(new Font("Consolas", Font.PLAIN, 14));
        textPass.setForeground(Color.white);
        textPass.setBounds(25, 210, 120, 30);
        frameAdmin.add(textPass);
        
        
        JLabel labelNoTelp=new JLabel("No Telp");
        labelNoTelp.setFont(new Font("Consolas",Font.PLAIN,14));
        labelNoTelp.setBackground(Color.black);
        labelNoTelp.setForeground(Color.white);
        labelNoTelp.setBounds(25, 240, 120, 30);
        frameAdmin.add(labelNoTelp);
        
        
        JTextField textNoTelp=new JTextField();
        textNoTelp.setFont(new Font("Consolas",Font.PLAIN,14));
        textNoTelp.setBackground(Color.black);
        textNoTelp.setForeground(Color.white);
        textNoTelp.setBounds(25,270,120, 30);
        textNoTelp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if(Character.isAlphabetic(ke.getKeyChar())){
                    ke.consume();
                    JOptionPane.showMessageDialog(null, "Inputan hanya menerima Angka");
                }
            }
            
        
        
        });
        frameAdmin.add(textNoTelp);
        
        
        JLabel labelAl=new JLabel("Alamat");
        labelAl.setFont(new Font("Consolas",Font.PLAIN,14));
        labelAl.setBackground(Color.black);
        labelAl.setForeground(Color.white);
        labelAl.setBounds(25, 300, 120, 30);
        frameAdmin.add(labelAl);
        
        
        JTextField textAl=new JTextField();
        textAl.setFont(new Font("Consolas",Font.PLAIN,14));
        textAl.setBackground(Color.black);
        textAl.setForeground(Color.white);
        textAl.setBounds(25, 330, 120, 30);
        frameAdmin.add(textAl);
        
         String[] fieldData={"Username","Password","Alamat","No Telepon"};
        DefaultTableModel tabelDataAdmin=new DefaultTableModel(fieldData,0);
        JTable tabelAdmin=new JTable(tabelDataAdmin);
        TableColumn tc1=new TableColumn(),tc2=new TableColumn(),tc3=new TableColumn(),tc4=new TableColumn();
        JScrollPane scrollPaneAdmin=new JScrollPane(tabelAdmin);
        scrollPaneAdmin.setBounds(200, 100, 400, 300);
        tc1=tabelAdmin.getColumnModel().getColumn(0);
        tc2=tabelAdmin.getColumnModel().getColumn(1);
        tc3=tabelAdmin.getColumnModel().getColumn(2);
        tc4=tabelAdmin.getColumnModel().getColumn(3);
        tc1.setPreferredWidth(100);
        tc2.setPreferredWidth(100);
        tc3.setPreferredWidth(100);
        tc4.setPreferredWidth(100);
        frameAdmin.add(scrollPaneAdmin);

        
        JButton buttonIn = new JButton("Insert");
        buttonIn.setFont(new Font("Consolas", Font.PLAIN, 14));
        buttonIn.setBackground(Color.black);
        buttonIn.setForeground(Color.white);
        buttonIn.setBounds(25, 500, 180, 30);
        buttonIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String getUsername=textUser.getText();
                String getPassword=textPass.getText();
                String getNoTelp=textNoTelp.getText();
                String getAlamat=textAl.getText();
                if(textUser.getText().equals("")||textPass.getText().equals("")||textNoTelp.getText().equals("")||textAl.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Data salah");
                }
                else{
                    AllObject.kasir1.insert(getUsername, getPassword,getNoTelp ,getAlamat );
                    JOptionPane.showMessageDialog(null, "Data berhasil di insert");
                    try {
                        tabelAdmin.setModel(AllObject.kasir1.viewTabel());
                    } catch (SQLException ex) {
                        Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        });
        frameAdmin.add(buttonIn);
        try {
            tabelAdmin.setModel(AllObject.kasir1.viewTabel());
        } catch (SQLException ex) {
            Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JButton buttonUp=new JButton("Update");
        buttonUp.setBounds(25, 550, 180, 30);
        buttonUp.setBackground(Color.black);
        buttonUp.setForeground(Color.white);
        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String getUsername=textUser.getText();
                String getPassword=textPass.getText();
                String getNoTelp=textNoTelp.getText();
                String getAlamat=textAl.getText();
                AllObject.kasir1.update(getUsername, getPassword, getAlamat, getNoTelp);
                JOptionPane.showMessageDialog(null, "Data berhasil di Update ");
                try {
                    tabelAdmin.setModel(AllObject.kasir1.viewTabel());
                } catch (SQLException ex) {
                    Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        frameAdmin.add(buttonUp);
        
        JButton buttonDel=new JButton("Delete");
        buttonDel.setBounds(25, 600, 180, 30);
        buttonDel.setBackground(Color.black);
        buttonDel.setForeground(Color.white);
        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String getUsername=textUser.getText();
                AllObject.kasir1.delete(getUsername);
                JOptionPane.showMessageDialog(null, "Data berhasil di Hapus");
                try {
                    tabelAdmin.setModel(AllObject.kasir1.viewTabel());
                } catch (SQLException ex) {
                    Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        frameAdmin.add(buttonDel);
        
        JButton backButton=new JButton("<=");
        backButton.setBackground(Color.red);
        backButton.setForeground(Color.white);
        backButton.setBounds(550,500,50,50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                MenuAdminFrame menuAd=new MenuAdminFrame();
                frameAdmin.dispose();
            }
        });
        frameAdmin.add(backButton);
        
       

        frameAdmin.setVisible(true);

    }
}
