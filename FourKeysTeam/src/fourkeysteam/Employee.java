/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourkeysteam;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Nisa
 */
public class Employee {    
    private  final SimpleStringProperty Nama;
    private  final SimpleStringProperty Alamat;
    private  final SimpleStringProperty Pesanan;
    private  final SimpleIntegerProperty Jumlah;
    private  final SimpleStringProperty Pembayaran;
    
    Employee(String Nama, String Alamat, String Pesanan, Integer Jumlah, String Pembayaran)
    {      
       this.Nama = new SimpleStringProperty(Nama);
       this.Alamat = new SimpleStringProperty(Alamat);
       this.Pesanan =  new SimpleStringProperty(Pesanan);
       this.Jumlah =  new SimpleIntegerProperty(Jumlah);
       this.Pembayaran =  new SimpleStringProperty(Pembayaran);
    }
    
     
    public String getNama() {
        return Nama.get();
    }

    public void setNama(String Nama) {
        this.Nama.set(Nama);
    }
    
   
  
    public String getAlamat() {
        return Alamat.get();
    }

    public void setAlamat(String Alamat) {
        this.Alamat.set(Alamat);
    }

    
    public String getPesanan() {
        return Pesanan.get();
    }

    public void setPesanan(String Pesanan) {
        this.Pesanan.set(Pesanan);
    }
    
    
    public int getJumlah() {
        return Jumlah.get();
    }

    public void setJumlah(int Jumlah) {
        this.Jumlah.set(Jumlah);
    }
    
   

    public String getPembayaran() {
        return Pembayaran.get();
    }

    public void setPembayaran(String Pembayaran) {
        this.Pembayaran.set(Pembayaran);
    }
    
    
}
    
