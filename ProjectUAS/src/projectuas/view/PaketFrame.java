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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import projectuas.model.AllObject;

/**
 *
 * @author ZEIDAR
 */
public class PaketFrame {
    
    
    public PaketFrame(){
        
        JFrame framePaket=new JFrame("Regis Paket");
        framePaket.setSize(800,800);
        framePaket.getContentPane().setBackground(Color.black);
        framePaket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePaket.setLocationRelativeTo(null);
        framePaket.setLayout(null);
        
        
        JLabel labelPaket=new JLabel("Paket");
        labelPaket.setFont(new Font("Consolas",Font.BOLD,24));
        labelPaket.setBackground(Color.black);
        labelPaket.setForeground(Color.white);
        labelPaket.setBounds(380, 0,200, 100);
        framePaket.add(labelPaket);
        
        
        JLabel labelIdPaket=new JLabel("Id Paket");
        labelIdPaket.setFont(new Font("Consolas",Font.PLAIN,14));
        labelIdPaket.setBounds(25, 130, 100, 30);
        labelIdPaket.setBackground(Color.black);
        labelIdPaket.setForeground(Color.white);
        framePaket.add(labelIdPaket);
        
        JTextField textIdPaket=new JTextField();
        textIdPaket.setFont(new Font("Consolas",Font.PLAIN,14));
        textIdPaket.setBounds(25, 160, 100, 30);
        textIdPaket.setBackground(Color.black);
        textIdPaket.setForeground(Color.white);
        framePaket.add(textIdPaket);
        
        
        JLabel labelNamaPaket=new JLabel("Nama Paket");
        labelNamaPaket.setBounds(25,200, 100, 30);
        labelNamaPaket.setFont(new Font("Consolas",Font.PLAIN,14));
        labelNamaPaket.setBackground(Color.black);
        labelNamaPaket.setForeground(Color.white);
        framePaket.add(labelNamaPaket);
        
        JTextField textNamaPaket=new JTextField();
        textNamaPaket.setFont(new Font("Consolas",Font.PLAIN,14));
        textNamaPaket.setBounds(25, 230, 100, 30);
        textNamaPaket.setBackground(Color.black);
        textNamaPaket.setForeground(Color.white);
        framePaket.add(textNamaPaket);
        
        JLabel labelJamPaket=new JLabel("Jam Paket");
        labelJamPaket.setFont(new Font("Consolas",Font.PLAIN,14));
        labelJamPaket.setBounds(25, 255, 100, 30);
        labelJamPaket.setBackground(Color.black);
        labelJamPaket.setForeground(Color.white);
        framePaket.add(labelJamPaket);
        
        JTextField textJamPaket=new JTextField();
        textJamPaket.setFont(new Font("Consolas",Font.PLAIN,14));
        textJamPaket.setBounds(25, 280, 100, 30);
        textJamPaket.setBackground(Color.black);
        textJamPaket.setForeground(Color.white);
        framePaket.add(textJamPaket);
        
        
        String[] fieldData={"Id Paket","Nama Paket","Jam Paket"};
        DefaultTableModel tabelDataPaket=new DefaultTableModel(fieldData,0);
        JTable tabelPaket=new JTable(tabelDataPaket);
        TableColumn tc1=new TableColumn(),tc2=new TableColumn(),tc3=new TableColumn();
        JScrollPane scrollPanePaket=new JScrollPane(tabelPaket);
        scrollPanePaket.setBounds(200,130, 300, 300);
        tc1=tabelPaket.getColumnModel().getColumn(0);
        tc2=tabelPaket.getColumnModel().getColumn(1);
        tc3=tabelPaket.getColumnModel().getColumn(2);
        framePaket.add(scrollPanePaket);
        
        JButton buttonInsert=new JButton("Insert");
        buttonInsert.setBackground(Color.black);
        buttonInsert.setForeground(Color.white);
        buttonInsert.setFont(new Font("Consolas",Font.PLAIN,14));
        buttonInsert.setBounds(25, 400, 100, 30);
        buttonInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            int getIdPaket=Integer.parseInt(textIdPaket.getText());
            String getNamaPaket=textNamaPaket.getText();
            int getJamPaket=Integer.parseInt(textJamPaket.getText());
            
            if(textIdPaket.getText().equals(0)||textNamaPaket.getText().equals("")||textJamPaket.getText().equals(0)){
                JOptionPane.showMessageDialog(null,"Data Salah");
            }
            else{
                AllObject.paket1.insert(getIdPaket, getNamaPaket, getJamPaket);
                JOptionPane.showMessageDialog(null," Data Berhasil di Input");
                tabelPaket.setModel(AllObject.paket1.viewTable3());
            }
        }
        });
        framePaket.add(buttonInsert);
        tabelPaket.setModel(AllObject.paket1.viewTable3());
        
        JButton buttonUp=new JButton("Update");
        buttonUp.setBackground(Color.black);
        buttonUp.setForeground(Color.white);
        buttonUp.setBounds(25, 435, 100, 30);
        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        framePaket.add(buttonUp);
        
        
        JButton buttonDel=new JButton("Delete");
        buttonDel.setBackground(Color.black);
        buttonDel.setForeground(Color.white);
        buttonDel.setBounds(25, 470, 100, 30);
        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        framePaket.add(buttonDel);
        
        
        JButton backButton=new JButton("<=");
        backButton.setBounds(550, 400, 50, 50);
        backButton.setBackground(Color.red);
        backButton.setForeground(Color.white);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            MenuAdminFrame menuAd=new MenuAdminFrame();
            framePaket.dispose();
            }
        });
        framePaket.add(backButton);
        
        framePaket.setVisible(true);
    }
}
