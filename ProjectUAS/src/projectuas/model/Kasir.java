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
public class Kasir extends Manusia {
    
    private String username,password;
    public void Kasir(String username, String password,String noTelp ,String alamat ) {
        this.username = username;
        this.password = password;
        super.alamat = alamat;
        super.noTelp = noTelp;
    }
    public Kasir(){
        this.username=" ";
        this.password=" ";
        super.alamat=" ";
        super.noTelp=" ";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
  public void setAlamat(String alamat){
      this.alamat=alamat;
  }
    @Override
  public void setNoTelp(String noTelp){
      this.noTelp=noTelp;
  }
    
    
    
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
