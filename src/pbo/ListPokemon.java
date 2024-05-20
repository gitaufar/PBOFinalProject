/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo;

import java.util.*;

/**
 *
 * @author ammar
 */
public class ListPokemon {
    
    public static PokemonApi charmander = new PokemonApi("Charmander",10,100);
//    public static PokemonApi charizard = new PokemonApi("Charizard",10,100);
    public static PokemonAir squirtel = new PokemonAir("Squirtle",10,100);
//    public static PokemonAir vaporeon = new PokemonAir("Vaporeon",10,100);
//    public static PokemonAngin pigeot = new PokemonAngin("Pigeot",10,100);
    public static PokemonAngin parrot = new PokemonAngin("Parrot",10,100);
    public static PokemonEs blaster = new PokemonEs("Blaster",10,100);
//    public static PokemonEs drion = new PokemonEs("Dryon",10,100);
    public static PokemonTanah bulbasaur = new PokemonTanah("Bulbasaur",10,100);
//    public static PokemonTanah diglet = new PokemonTanah("diglet",10,100);
    public static ArrayList<Pokemon> list = new ArrayList(Arrays.asList(charmander,squirtel,parrot,blaster,bulbasaur));
    
    public static Pokemon get(int index){
        return list.get(index);
    }
    
}
