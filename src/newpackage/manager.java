/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author ammar
 */
public class manager extends pegawai{
    public String departemen;
    public manager(String nama,double gaji,int umur,String dep){
        super(nama,gaji,umur);
        this.departemen = dep;
    }
    @Override
    public double cekPajak(){
        return gaji * 0.2;
    }
    
    @Override
    public void printDetail(){
        super.printDetail();
        System.out.println("departemen: " + departemen);
    }
    
}
