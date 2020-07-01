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
import javax.swing.*;
import projectuas.controller.KasirController;
import projectuas.model.AllObject;
/**
 *
 * @author ZEIDAR
 */
public class LoginFrame extends JFrame {

    KasirController kasir =new KasirController();

    public LoginFrame() {

        JFrame kasirFrame = new JFrame();
        kasirFrame.setSize(400, 400);
        kasirFrame.getContentPane().setBackground(Color.black);
        kasirFrame.setLocationRelativeTo(null);
        kasirFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kasirFrame.setTitle("Login");
        kasirFrame.setLayout(null);

        JLabel labelKasir = new JLabel("Login");
        labelKasir.setFont(new Font("Consolas", Font.BOLD, 24));
        labelKasir.setBackground(Color.black);
        labelKasir.setForeground(Color.white);
        labelKasir.setBounds(160, 0, 100, 100);
        kasirFrame.add(labelKasir);

        JLabel labelUser = new JLabel("Username");
        labelUser.setFont(new Font("Consolas", Font.PLAIN, 14));
        labelUser.setBackground(Color.black);
        labelUser.setForeground(Color.white);
        labelUser.setBounds(25, 100, 100, 20);
        kasirFrame.add(labelUser);

        JTextField textUser = new JTextField();
        textUser.setFont(new Font("Consolas", Font.PLAIN, 14));
        textUser.setBackground(Color.black);
        textUser.setForeground(Color.white);
        textUser.setBounds(25, 130, 100, 30);
        kasirFrame.add(textUser);

        JLabel labelPass = new JLabel("Password");
        labelPass.setFont(new Font("Consolas", Font.PLAIN, 14));
        labelPass.setBackground(Color.black);
        labelPass.setForeground(Color.white);
        labelPass.setBounds(25, 180, 100, 20);
        kasirFrame.add(labelPass);

        JPasswordField passField = new JPasswordField();
        passField.setBackground(Color.black);
        passField.setForeground(Color.white);
        passField.setBounds(25, 210, 100, 30);
        kasirFrame.add(passField);

        JButton buttonLogin = new JButton("Login");
        buttonLogin.setFont(new Font("Consolas", Font.PLAIN, 14));
        buttonLogin.setBackground(Color.black);
        buttonLogin.setForeground(Color.white);
        buttonLogin.setBounds(25, 260, 100, 20);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = textUser.getText();
                String pass = passField.getText();
                boolean ketemu = false;
                for (int i = 0; i < kasir.getIndex(); i++) {
                    if (nama.equals(kasir.dataKasir[i].getUsername()) && pass.equals(kasir.dataKasir[i].getPassword())) {
                        ketemu = true;
                    }

                }
                if (ketemu == true) {
                    AllObject.nama=nama;
                    AllObject.password=pass;
                    VoucherFrame bayar = new VoucherFrame();
                    kasirFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Nama/Password salah");
                }
            }
        });
        kasirFrame.add(buttonLogin);

        JButton backButton = new JButton("<=");
        backButton.setBackground(Color.red);
        backButton.setForeground(Color.white);
        backButton.setBounds(300, 260, 50, 50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MainFrame main = new MainFrame();
                kasirFrame.dispose();
            }
        });
        kasirFrame.add(backButton);

        kasirFrame.setVisible(true);
    }

//    public void kasirLogin(String username,String password){
//        AdminController admin=new AdminController();
//        admin.getAdmin();
//        if(admin==null){
//            JOptionPane.showMessageDialog(null, "ID / Password Salah");
//        }
//        else{
//            VoucherFrame bayar=new VoucherFrame();
//            
//            
//            
//        }
//    }
}
