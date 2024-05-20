/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Quiz;

/**
 *
 * @author ammar
 */
import java.util.*;

public class Pelanggan implements Menonton{
    
    private String kode,nama,status_keanggotaan;
    private LinkedList<Film> history = new LinkedList<>();
    public Film[] listFilm;
    private int nomor_telepon;
    
    public Pelanggan(String nama,String kode,String status_keanggotaan,int nomor){
        this.nama = nama;
        this.kode = kode;
        this.status_keanggotaan = status_keanggotaan;
        nomor_telepon = nomor;
    }
    
    public void ubahStatus(String status){
        status_keanggotaan = status;
    }
    
    public String getKode(){
        return kode;
    }
    
    public String getStatus(){
        return status_keanggotaan;
    }
    
    public String getNama(){
        return nama;
    }
    
    public int getNomor(){
        return nomor_telepon;
    }
    
    public void cekHistory(){
        System.out.println("Daftar history:");
        for(int i = 0;i < history.size(); i++){
            System.out.println(i + "." + history.get(i).judul);
        }
    }
    
    public void detailPelanggan(){
        System.out.println("nama: " + nama);
        System.out.println("status: " + status_keanggotaan);
        System.out.println("nomor telepon: " + nomor_telepon);
    }
    
    @Override
    public void ambilListFilm(){
        System.out.println("Daftar Film");
        if(status_keanggotaan.equalsIgnoreCase("platinum")){
            for(int i = 0;i < listFilm.length; i++){
                if(listFilm[i] instanceof FilmNew){
                    System.out.println("-" + listFilm[i].judul);
            }
            }
        }
        for(int i = 0; i < listFilm.length; i++){
            if(listFilm[i] instanceof FilmReguler){
                System.out.println("-" + listFilm[i].judul);
            }
        }
    }
    
    @Override
    public void tontonFilm(Film film){
        history.add(film);
    }
    
}
