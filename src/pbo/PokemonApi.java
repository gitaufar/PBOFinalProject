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
public class PokemonApi extends Pokemon{

    public PokemonApi(String nama, int damage, int hp) {
        super(nama, damage, hp);
        super.setTipe("Api");
    }
    
    public PokemonApi(String nama,int level){
        super(nama,level);
        super.setTipe("Api");
    }

    @Override
    public void elementalAttack(Pokemon musuh) throws InterruptedException {
        System.out.print("Mengeluarkan Api");
        for(int i = 0;i < 3; i++){
            System.out.print(".");
            Thread.sleep(750);
        }
        if(musuh instanceof PokemonEs){
            System.out.println("Serangan efektif!!!, memberikan damage " + getDamage() * 2);
            musuh.setHp(musuh.getHp() - getDamage() * 2);
        } else {
            System.out.println("memberikan damage " + getDamage());
            musuh.setHp(musuh.getHp() - getDamage());
        }
    }

    @Override
    public void printDetail() {
        System.out.printf("Nama: %s\t| Elemen: Api\nLevel: %d\t| Ep: %d/%d\nHp: %d\n",getNama(),getLevel(),getEp(),getEpMax(),getHp());
    }
    
    @Override
    public String evolve() {
        System.out.println("Ingin berubah ke element apa");
        Scanner input = new Scanner(System.in);
        System.out.println("1.Angin");
        System.out.println("2.Tanah");
        String hasil = "";
        int choice = 0;
        while (choice != 1 && choice != 2) {
            choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    hasil = "angin";
                }
                case 2 -> {
                    hasil = "tanah";
                }
                default -> {
                    System.out.println("tidak ada opsi yang dipilih, pilih ulang");
                }
            }
        }
        return hasil;
    }
}
