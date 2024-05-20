/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo;

import java.util.Scanner;

/**
 *
 * @author ammar
 */
public class PokemonAngin extends Pokemon{
    
    public PokemonAngin(String nama,int damage,int hp){
        super(nama,damage,hp);
        super.setTipe("angin");
    }
    
    public PokemonAngin(String nama,int level){
        super(nama,level);
        super.setTipe("angin");
    }
    
    @Override
    public void spesialAttack(Pokemon musuh){
        int sacrifice = (int)(Math.ceil(getHp() * 0.1)),damage = getDamage() * 2;
        setHp(getHp() - sacrifice);
        System.out.println("Mengorbankan " + sacrifice + " hp untuk memberikan " + damage + " damage");
        musuh.setHp(musuh.getHp() - damage);
    }
    
    @Override
    public void elementalAttack(Pokemon musuh) throws InterruptedException{
        System.out.print("Mengeluarkan tornado");
        for(int i = 0;i < 3; i++){
            System.out.print(".");
            Thread.sleep(750);
        }
        if(musuh instanceof PokemonTanah){
            System.out.println("Serangan efektif!!!, memberikan damage " + getDamage() * 2);
            musuh.setHp(musuh.getHp() - getDamage() * 2);
        } else {
            System.out.println("memberikan damage " + getDamage());
            musuh.setHp(musuh.getHp() - getDamage());
        }
    }
    
    @Override 
    public void printDetail(){
        System.out.printf("Nama: %s\t| Elemen: Angin\nLevel: %d\t| Ep: %d/%d\nHp: %d\n",getNama(),getLevel(),getEp(),getEpMax(),getHp());
    }
    
    @Override
    public String evolve() {
        System.out.println("Ingin berubah ke element apa");
        Scanner input = new Scanner(System.in);
        System.out.println("1.Air");
        System.out.println("2.Api");
        String hasil = "";
        int choice = 0;
        while (choice != 1 && choice != 2) {
            choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    hasil = "air";
                }
                case 2 -> {
                    hasil = "api";
                }
                default -> {
                    System.out.println("tidak ada opsi yang dipilih, pilih ulang");
                }
            }
        }
        return hasil;
    }

}
