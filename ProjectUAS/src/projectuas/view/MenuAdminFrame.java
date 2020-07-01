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

/**
 *
 * @author ZEIDAR
 */
public class MenuAdminFrame {
    
    public MenuAdminFrame(){
    
        JFrame MenuAdmin=new JFrame("Menu Admin");
        MenuAdmin.setSize(600,650);
        MenuAdmin.getContentPane().setBackground(Color.BLACK);
        MenuAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuAdmin.setLocationRelativeTo(null);
        MenuAdmin.setLayout(null);
        
        JButton ButtonKasir=new JButton("Regis Kasir");
        ButtonKasir.setBounds(0, 0, 600,200);
        ButtonKasir.setFont(new Font("Consolas",Font.BOLD,24));
        ButtonKasir.setBackground(Color.black);
        ButtonKasir.setForeground(Color.white);
        ButtonKasir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                KasirFrame admin=new KasirFrame();
                MenuAdmin.dispose();
            }
        });
        
        MenuAdmin.add(ButtonKasir);
        
        JButton ButtonPaket=new JButton("Regis Paket");
        ButtonPaket.setBounds(0, 200, 600, 200);
        ButtonPaket.setFont(new Font("Consolas",Font.BOLD,24));
        ButtonPaket.setBackground(Color.BLACK);
        ButtonPaket.setForeground(Color.WHITE);
        ButtonPaket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              PaketFrame paket=new PaketFrame();
              MenuAdmin.dispose();
            }
        });
        MenuAdmin.add(ButtonPaket);
        
        
        JButton ButtonKomp=new JButton("Regis Komputer");
        ButtonKomp.setBounds(0, 400, 600, 200);
        ButtonKomp.setFont(new Font("Consolas",Font.BOLD , 24));
        ButtonKomp.setBackground(Color.black);
        ButtonKomp.setForeground(Color.white);
        ButtonKomp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                KomputerFrame komp=new KomputerFrame();
                MenuAdmin.dispose();
            }
        });
        
        MenuAdmin.add(ButtonKomp);
        
        JButton backButton=new JButton("<=");
        backButton.setBackground(Color.red);
        backButton.setForeground(Color.white);
        backButton.setBounds(0, 150, 50, 50);
        backButton.setFont(new Font("Consolas",Font.PLAIN,14));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MainFrame mainF=new MainFrame();
                MenuAdmin.dispose();
            }
        });
        ButtonKomp.add(backButton);
        MenuAdmin.setVisible(true);
    }
    
    
}
