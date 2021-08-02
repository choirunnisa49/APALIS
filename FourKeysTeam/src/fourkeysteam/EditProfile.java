/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourkeysteam;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class EditProfile {
    private String name;
    private String email;
    private String password;
    private Date ultah;
    private String alamat;

    public Date getUltah() {
        return ultah;
    }

    public void setUltah(Date ultah) {
        this.ultah = ultah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
