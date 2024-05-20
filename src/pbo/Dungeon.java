/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo;

/**
 *
 * @author ammar
 */
public class Dungeon extends Map{
    
    static public Pokemon generateEnemy(Pokemon player){
        int index = (int)((Math.random() * 10) % 10);
        Pokemon list = ListPokemon.list.get(index);
        int level = ((int)(Math.random() * 10) % 3);
        level -= 1;
        if(level <= 0){
           level = 1;
        } 
        Pokemon pokemon;
        if(list instanceof PokemonApi){
            pokemon = new PokemonApi(list.getNama(),level);
        } else if(list instanceof PokemonAir){
            pokemon = new PokemonAir(list.getNama(),level);
        } else if(list instanceof PokemonTanah){
            pokemon = new PokemonTanah(list.getNama(),level);
        } else if(list instanceof PokemonAngin){
            pokemon = new PokemonAngin(list.getNama(),level);
        } else {
            pokemon = new PokemonEs(list.getNama(),level);
        }
        return pokemon;
    }
}
