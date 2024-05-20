/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo;

/**
 *
 * @author ammar
 */
public class HomeBase extends Map{
    
    public void healPokemon(Pokemon pokemon){
        if(pokemon.getHp() == pokemon.getMaxHp()){
            System.out.println("Hp pokemon anda masih penuh");
            return;
        }
        
        pokemon.setHp(pokemon.getMaxHp());
        System.out.println("Pokemon berhasil dipulihkan");
        pokemon.setAlive(true);
    }
    
    public void levelUp(Pokemon pokemon){
       pokemon.naikLevel(); 
    }
    
    public Pokemon evolusi(Pokemon pokemon) {
    if (pokemon.getEvolusi() >= pokemon.getLevel() || pokemon.getLevel() <= 1) {
        System.out.println("Tidak ada kesempatan evolusi, naik level untuk dapat kesempatan");
        return pokemon;
    }
    String tipe = pokemon.evolve();
    Pokemon evolusiPokemon;
    if (tipe.equalsIgnoreCase("angin")) {
        evolusiPokemon = new PokemonAngin(pokemon.getNama(), pokemon.getLevel());
        System.out.println("Pokemon berevolusi ke elemen Angin");
    } else if (tipe.equalsIgnoreCase("api")) {
        evolusiPokemon = new PokemonApi(pokemon.getNama(), pokemon.getLevel());
        System.out.println("Pokemon berevolusi ke elemen Api");
    } else if (tipe.equalsIgnoreCase("es")) {
        evolusiPokemon = new PokemonEs(pokemon.getNama(), pokemon.getLevel());
        System.out.println("Pokemon berevolusi ke elemen Es");
    } else if (tipe.equalsIgnoreCase("tanah")) {
        evolusiPokemon = new PokemonTanah(pokemon.getNama(), pokemon.getLevel());
        System.out.println("Pokemon berevolusi ke elemen Tanah");
    } else {
        evolusiPokemon = new PokemonAir(pokemon.getNama(), pokemon.getLevel());
        System.out.println("Pokemon berevolusi ke elemen Air");
    }

    // Salin atribut penting ke objek baru
    evolusiPokemon.setEvolusi(pokemon.getEvolusi() + 1);
    evolusiPokemon.setDamage(pokemon.getDamage());
    evolusiPokemon.setHp(pokemon.getHp());
    evolusiPokemon.setMaxHp(pokemon.getMaxHp());
    evolusiPokemon.setEp(pokemon.getEp());
    evolusiPokemon.setEpMax(pokemon.getEpMax());
    evolusiPokemon.setStatus(pokemon.isStatus());
    evolusiPokemon.setAlive(pokemon.isAlive());
    evolusiPokemon.setStun(pokemon.isStun());

    return evolusiPokemon;
}

    
}
