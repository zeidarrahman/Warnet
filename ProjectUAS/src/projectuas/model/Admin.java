/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectuas.model;

/**
 *
 * @author ZEIDAR
 */
public class Admin extends Manusia {
   private  String username;
   private String password;
   
   
    public Admin(String username, String password,String noTelp,String alamat) {
        this.username = username;
        this.password = password;
        super.noTelp=noTelp;
        super.alamat=alamat;
    }

   
//       public Admin(){
//                this.username=" ";
//                this.password=" ";
//                super.noTelp=" ";
//                super.alamat=" ";
//   }


   
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getNoTelp(){
        return noTelp;
    }
    public String getAlamat(){
        return alamat;
    }
}
