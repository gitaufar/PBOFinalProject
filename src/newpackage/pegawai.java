/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author ammar
 */
public class pegawai extends Orang {
    
    public pegawai(String nama,double gaji,int umur){
        super(nama,gaji,umur);
    }
    @Override
    public double cekPajak(){
        return gaji * 0.1;
    }
    
    @Override
    public void bayarPajak(){
        gaji -= cekPajak();
    }
    
    @Override
    public void printDetail(){
        System.out.println("nama: " + nama + "\ngaji = "+ gaji + "\numur: " + umur + "\npajak: " + cekPajak());
    }
    }
