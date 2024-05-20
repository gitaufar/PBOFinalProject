/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author ammar
 */
public abstract class Orang {
    public String nama;
    public double gaji;
    public int umur;
    
    public Orang(String nama,double gaji,int umur){
        this.nama = nama;
        this.gaji = gaji;
        this.umur = umur;
    }
    
    public abstract double cekPajak();
    public abstract void bayarPajak();
    public abstract void printDetail();
    
}
