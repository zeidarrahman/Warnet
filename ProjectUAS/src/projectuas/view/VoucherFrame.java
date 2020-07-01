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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import projectuas.controller.KasirController;
import projectuas.controller.VoucherController;
import projectuas.model.AllObject;


/**
 *
 * @author ZEIDAR
 */
public class VoucherFrame extends JFrame{
    VoucherController vController;
    KasirController kasir3;       
    AllObject object;
    public VoucherFrame(){
        JFrame  bayarFrame=new JFrame("Voucher");
        bayarFrame.setSize(1000, 800);
        bayarFrame.getContentPane().setBackground(Color.black);
        bayarFrame.setLocationRelativeTo(null);
        bayarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //bayarFrame.setTitle("PEMBAYARAN");
        bayarFrame.setLayout(null);
        
        
        JLabel labelBayar=new JLabel("Voucher");
        labelBayar.setFont(new Font("Consolas",Font.BOLD,24));
        labelBayar.setBackground(Color.black);
        labelBayar.setForeground(Color.white);
        labelBayar.setBounds(230, 40, 150, 30);
        bayarFrame.add(labelBayar);
        
        
        JLabel labelVoucher=new JLabel("Voucher");
        labelVoucher.setFont(new Font("Consolas",Font.PLAIN,14));
        labelVoucher.setBackground(Color.black);
        labelVoucher.setForeground(Color.white);
        labelVoucher.setBounds(25, 100, 100, 30);
        bayarFrame.add(labelVoucher);
        
        
        JTextField textVoucher=new JTextField();
        textVoucher.setFont(new Font("Consolas",Font.PLAIN,14));
        textVoucher.setBackground(Color.black);
        textVoucher.setForeground(Color.white);
        textVoucher.setBounds(25, 130, 120, 30);
        bayarFrame.add(textVoucher);
        
        
        JLabel labeltgl=new JLabel("Tanggal");
        labeltgl.setFont(new Font("Consolas",Font.PLAIN,14));
        labeltgl.setBackground(Color.black);
        labeltgl.setForeground(Color.white);
        labeltgl.setBounds(25, 170, 120, 30);
        bayarFrame.add(labeltgl);
        
        
        JTextField textTgl=new JTextField();
        textTgl.setFont(new Font("Consolas",Font.PLAIN,14));
        textTgl.setBackground(Color.black);
        textTgl.setForeground(Color.white);
        textTgl.setBounds(25, 200, 120, 30);
        textTgl.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if(Character.isAlphabetic(ke.getKeyChar())){
                    ke.consume();
                    JOptionPane.showMessageDialog(null,"Inputan hanya menerima angka");
                }
            }
        });
        bayarFrame.add(textTgl);
        
        
        JLabel labelJam=new JLabel("Total Jam");
        labelJam.setFont(new Font("Consolas",Font.PLAIN,14));
        labelJam.setBackground(Color.black);
        labelJam.setForeground(Color.white);
        labelJam.setBounds(25, 260, 120, 30);
        bayarFrame.add(labelJam);
        
        
        
        JTextField textJam=new JTextField();
        textJam.setFont(new Font("Consolas",Font.PLAIN,14));
        textJam.setBackground(Color.black);
        textJam.setForeground(Color.white);
        textJam.setBounds(25, 300, 120, 30);
        textJam.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if(Character.isAlphabetic(ke.getKeyChar())){
                    ke.consume();
                    JOptionPane.showMessageDialog(null, "Inputan Hanya menerima angka");
                }
            }
        
        });
        bayarFrame.add(textJam);
        
        
        JLabel labelGuest=new JLabel("Nama Guest");
        labelGuest.setFont(new Font("Consolas",Font.PLAIN,14));
        labelGuest.setBackground(Color.black);
        labelGuest.setForeground(Color.white);
        labelGuest.setBounds(25, 340, 120, 30);
        bayarFrame.add(labelGuest);
        
        
        
        JTextField textGuest=new JTextField();
        textGuest.setFont(new Font("Consolas",Font.PLAIN,14));
        textGuest.setBackground(Color.black);
        textGuest.setForeground(Color.white);
        textGuest.setBounds(25, 380, 120, 30);
        textGuest.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
               if(Character.isDigit(ke.getKeyChar())){
                   ke.consume();
                   JOptionPane.showMessageDialog(null,"Inputan hanya menerima huruf");
               }
            }
        });
        bayarFrame.add(textGuest);
        
        
        
        JLabel labelAdm=new JLabel("Username Kasir");
        labelAdm.setFont(new Font("Consolas",Font.PLAIN,14));
        labelAdm.setBackground(Color.black);
        labelAdm.setForeground(Color.white);
        labelAdm.setBounds(25, 410, 120, 30);
        bayarFrame.add(labelAdm);
        
        
        
        JTextField textKasir=new JTextField();
        textKasir.setFont(new Font("Consolas",Font.PLAIN,14));
        textKasir.setBackground(Color.black);
        textKasir.setForeground(Color.white);
        textKasir.setBounds(25, 440, 120, 30);
        textKasir.setEditable(false);
        
        bayarFrame.add(textKasir);
        textKasir.setText(AllObject.nama);
        
        
        JLabel labelHarga=new JLabel("Harga");
        labelHarga.setFont(new Font("Consolas",Font.PLAIN,14));
        labelHarga.setBackground(Color.BLACK);
        labelHarga.setForeground(Color.WHITE);
        labelHarga.setBounds(25, 470, 120, 30);
        bayarFrame.add(labelHarga);
        
        JTextField textHarga=new JTextField();
        textHarga.setFont(new Font("Consolas",Font.PLAIN,14));
        textHarga.setBackground(Color.BLACK);
        textHarga.setForeground(Color.WHITE);
        textHarga.setBounds(25,500,120,30);
        bayarFrame.add(textHarga);
        
        
        
        
        
        String[] fieldData={"Voucher","Tanggal","Total Jam","Nama Guest","Username Kasir","Harga"};
        DefaultTableModel TabelDataVoucher=new DefaultTableModel(fieldData,0);
        JTable tabelVoucher=new JTable(TabelDataVoucher);
        TableColumn tc1=new TableColumn(),tc2=new TableColumn(),tc3=new TableColumn(),tc4=new TableColumn(),tc5=new TableColumn(),tc6=new TableColumn();
        JScrollPane scrollPaneVoucher=new JScrollPane(tabelVoucher);
        scrollPaneVoucher.setBounds(200, 100, 600, 500);
        tc1=tabelVoucher.getColumnModel().getColumn(0);
        tc2=tabelVoucher.getColumnModel().getColumn(1);
        tc3=tabelVoucher.getColumnModel().getColumn(2);
        tc4=tabelVoucher.getColumnModel().getColumn(3);
        tc5=tabelVoucher.getColumnModel().getColumn(4);
        tc6=tabelVoucher.getColumnModel().getColumn(5);
        tc1.setPreferredWidth(100);
        tc2.setPreferredWidth(100);
        tc3.setPreferredWidth(100);
        tc4.setPreferredWidth(100);
        tc5.setPreferredWidth(100);
        tc6.setPreferredWidth(100);
        bayarFrame.add(scrollPaneVoucher);
        
        
        
        
        
        JButton printButton=new JButton("Print");
        printButton.setFont(new Font("Consolas",Font.PLAIN,14));
        printButton.setBackground(Color.black);
        printButton.setForeground(Color.white);
        printButton.setBounds(25, 550, 120, 30);
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 String getVoucher=textVoucher.getText();
                 String getTgl=textTgl.getText();
                 int getJam=Integer.parseInt(textJam.getText());
                 String getGuest=textGuest.getText();
                 String getKasir=textKasir.getText();
                 int getHarga=Integer.parseInt(textHarga.getText());
                 
                 
                 if(textVoucher.getText().equals("")||textTgl.getText().equals("")||textJam.getText().equals("")|| textGuest.getText().equals("") || textKasir.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Data salah");
                }
                else{
                  AllObject.voucher.insert(getVoucher, getTgl, getJam, getGuest,getHarga);
                     
                    JOptionPane.showMessageDialog(null, "Voucher "+getVoucher+"\nTanggal "+getTgl+"\nTotal Jam "+getJam+
                            "\nNama Guest "+getGuest+"\nNama Kasir "+getKasir+"\nHarga "+getHarga);
                     try {
                         tabelVoucher.setModel(AllObject.voucher.viewTable1());
                     } catch (SQLException ex) {
                         Logger.getLogger(VoucherFrame.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
                
            }
        });
        bayarFrame.add(printButton);
        try {
            tabelVoucher.setModel(AllObject.voucher.viewTable1());
        } catch (SQLException ex) {
            Logger.getLogger(VoucherFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JButton buttonUp=new JButton("Update");
        buttonUp.setBackground(Color.black);
        buttonUp.setForeground(Color.white);
        buttonUp.setBounds(25,580 , 100, 30);
        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
       bayarFrame.add(buttonUp);
       
       
       JButton buttonDel=new JButton("Delete");
       buttonDel.setBackground(Color.black);
       buttonDel.setForeground(Color.white);
       buttonDel.setBounds(25, 610, 100, 30);
       buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
       bayarFrame.add(buttonDel);
       
       
        JButton backButton=new JButton("<=");
        backButton.setBackground(Color.red);
        backButton.setForeground(Color.white);
        backButton.setBounds(450,700 , 50, 50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LoginFrame kasir=new LoginFrame();
                bayarFrame.dispose();
            }
        });
        bayarFrame.add(backButton);
        
        
        bayarFrame.setVisible(true);
        
        
       
    }
}
