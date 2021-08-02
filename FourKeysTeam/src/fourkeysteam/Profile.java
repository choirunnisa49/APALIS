/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourkeysteam;

import java.util.Date;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ASUS
 */
public class Profile {
    //private String nama;
    //private String alamat;
    //private String email;
    private Date ultah;
    //private String password;
    private String gender;

    private SimpleStringProperty nama,alamat,email,password;

    public Profile() {
    }

    public Profile(String nama, String alamat, String email, String password) {
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
    }
    
       public Profile(String nama, String alamat) {
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
       
    
    }
    
    
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama =new SimpleStringProperty(nama);
    }
    
    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String alamat) {
        this.alamat = new SimpleStringProperty( alamat);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public Date getUltah() {
        return ultah;
    }

    public void setUltah(Date ultah) {
        this.ultah = ultah;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }
    
}
