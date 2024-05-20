/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Quiz;

/**
 *
 * @author ammar
 */
public abstract class Film {
    protected String judul,genre,synopsis,kategoriUmur;
    protected int tahun;
    
    public Film(String judul,String genre,String kategoriUmur,int tahun){
        this.judul = judul;
        this.genre = genre;
        this.kategoriUmur = kategoriUmur;
        this.tahun = tahun;
    }
    
}
