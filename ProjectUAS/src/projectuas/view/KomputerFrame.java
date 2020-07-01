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
import projectuas.model.*;
import projectuas.controller.*;

/**
 *
 * @author ZEIDAR
 */
public class KomputerFrame {
    KomputerController kController;
    
    public KomputerFrame(){
        JFrame frameKomputer=new JFrame("Komputer");
        frameKomputer.getContentPane().setBackground(Color.black);
        frameKomputer.setSize(800, 800);
        frameKomputer.setLocationRelativeTo(null);
        frameKomputer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameKomputer.setLayout(null);
        
        JLabel labelKomp=new JLabel("Komputer");
        labelKomp.setBounds(380, 0, 200, 100);
        labelKomp.setFont(new Font("Consolas", Font.BOLD, 24));
        labelKomp.setBackground(Color.black);
        labelKomp.setForeground(Color.white);
        frameKomputer.add(labelKomp);
        
        JLabel labelId=new JLabel("Id Komputer");
        labelId.setBounds(25, 100, 100, 30);
        labelId.setFont(new Font("Consolas",Font.PLAIN,14));
        labelId.setBackground(Color.black);
        labelId.setForeground(Color.white);
        frameKomputer.add(labelId);
        
        JTextField textIdkomp=new JTextField();
        textIdkomp.setBounds(25, 130, 100, 30);
        textIdkomp.setFont(new Font("Consolas",Font.PLAIN,14));
        textIdkomp.setBackground(Color.black);
        textIdkomp.setForeground(Color.white);
        frameKomputer.add(textIdkomp);
        
        String[] fieldData={"Id Komputer"};
        DefaultTableModel tabelDataKomp=new DefaultTableModel(fieldData,0);
        JTable tabelKomp=new JTable(tabelDataKomp);
        TableColumn tc1=new TableColumn();
        JScrollPane scrollPaneKomp=new JScrollPane(tabelKomp);
        scrollPaneKomp.setBounds(200, 130, 200, 300);
        tc1=tabelKomp.getColumnModel().getColumn(0);
        tc1.setPreferredWidth(200);
        frameKomputer.add(scrollPaneKomp);
        
        JButton buttonInsert=new JButton("Insert");
        buttonInsert.setBackground(Color.black);
        buttonInsert.setForeground(Color.white);
        buttonInsert.setFont(new Font("Consolas",Font.PLAIN,14));
        buttonInsert.setBounds(25, 430, 100, 30);
        buttonInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
                if(textIdkomp.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Data salah");
                }
                else{
                    int getIdKomp=Integer.parseInt(textIdkomp.getText());
                    AllObject.komp1.insert(getIdKomp);
                    JOptionPane.showMessageDialog(null, "Id Komputer "+getIdKomp);
                    tabelKomp.setModel(AllObject.komp1.viewTable2());
                    
                }
            }
        });
        frameKomputer.add(buttonInsert);
        tabelKomp.setModel(AllObject.komp1.viewTable2());
        
        JButton buttonUp=new JButton("Update");
        buttonUp.setBounds(25, 465, 100, 30);
        buttonUp.setBackground(Color.black);
        buttonUp.setForeground(Color.white);
        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        frameKomputer.add(buttonUp);
        
        JButton buttonDel=new JButton("Delete");
        buttonDel.setBackground(Color.black);
        buttonDel.setForeground(Color.white);
        buttonDel.setBounds(25, 500, 100, 30);
        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        frameKomputer.add(buttonDel);
        
        
        
        JButton bButton=new JButton("<=");
        bButton.setBackground(Color.red);
        bButton.setForeground(Color.white);
        bButton.setBounds(450, 430, 50, 50);
        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuAdminFrame menuad=new MenuAdminFrame();
                frameKomputer.dispose();
            }
        });
        frameKomputer.add(bButton);
        
        frameKomputer.setVisible(true);
        
    }
}
