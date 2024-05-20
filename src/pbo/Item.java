/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo;

/**
 *
 * @author ammar
 */
public class Item {

    public String nama;

    public Item(String nama) {
        this.nama = nama;
    }

    public void use(Pokemon pokemon) {
        if (pokemon.getHp() >= pokemon.getMaxHp()) {
            System.out.println("Hp pokemon masih penuh, item tidak terpakai tapi kehilangan 1 turn..");
            return;
        }

        int heal;

        if (nama.equalsIgnoreCase("High")) {
            heal = (int) Math.ceil((pokemon.getMaxHp() * 0.5));
        } else if (nama.equalsIgnoreCase("Medium")) {
            heal = (int) Math.ceil((pokemon.getMaxHp() * 0.3));
        } else {
            heal = (int) Math.ceil((pokemon.getMaxHp() * 0.2));
        }
        
        if(pokemon.getHp() + heal > pokemon.getMaxHp()){
            heal = pokemon.getMaxHp() - pokemon.getHp();
        }
        System.out.println("Menggunakan " + nama + " potion, memulihkan " + heal + " Hp");
        pokemon.setHp(pokemon.getHp() + heal);
    }
}
