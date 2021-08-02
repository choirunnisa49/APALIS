/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourkeysteam;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ASUS
 */
public class Order1 {
    private SimpleStringProperty nama,alamat,pesanan,jumlah,pembayaran,nomor,sayur,harga;

    public Order1 (String nama,String alamat,String pesanan,String jumlah,String pembayaran) {
        this.nama = new SimpleStringProperty(nama);
        this.alamat =new SimpleStringProperty(alamat);
        this.pesanan =new SimpleStringProperty(pesanan);
        this.pembayaran =new SimpleStringProperty(pembayaran);
        this.jumlah =new SimpleStringProperty (jumlah);
    }

    public Order1(String sayur,String jumlah,String harga) {
        this.jumlah = new SimpleStringProperty(jumlah);
        this.sayur = new SimpleStringProperty(sayur);
        this.harga = new SimpleStringProperty(harga);
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
        this.alamat =new SimpleStringProperty(alamat);
    }

    public String getPesanan() {
        return pesanan.get();
    }

    public void setPesanan(String pesanan) {
        this.pesanan = new SimpleStringProperty(pesanan);
    }

    public String getPembayaran() {
        return pembayaran.get();
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = new SimpleStringProperty(pembayaran);
    }

    public String getJumlah() {
        return jumlah.get();
    }

    public void setJumlah(String jumlah) {
        this.jumlah =new SimpleStringProperty(jumlah);
    }

    public String getSayur() {
        return sayur.get();
    }

    public void setSayur(String sayur) {
        this.sayur =new SimpleStringProperty(sayur);
    }
    
    public String getHarga() {
        return harga.get();
    }

    public void setHarga(String harga) {
        this.harga =new SimpleStringProperty(harga);
    }
    
}
