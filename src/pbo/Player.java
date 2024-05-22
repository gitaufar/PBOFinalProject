/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo;

import GUI.Gui;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 *
 * @author ammar
 */
public class Player {

    private int pokemonHidup;

    public int getPokemonHidup() {
        return pokemonHidup;
    }

    public void setPokemonHidup(int pokemonHidup) {
        this.pokemonHidup = pokemonHidup;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    private Map map;
    public LinkedList<Pokemon> ownedPokemon = new LinkedList<>();
    public Pokemon[] battlePokemon = new Pokemon[3];
    public int bPokemonIndex = 0;
    public ArrayList<Item> listItem = new ArrayList<>();

    public void addItem(Item item) {
        listItem.add(item);
    }

    public void useItem(Item item, Pokemon pokemon) {
        item.use(pokemon);
    }

    public void printItem() {
        int count = 1;
        for (Item i : listItem) {
            System.out.println(count + ". " + i.nama + " Potion");
            count++;
        }
    }

    public void bAdd(int index) {
        if (bPokemonIndex == 3) {
            bPokemonIndex = 0;
        }
        battlePokemon[bPokemonIndex++] = ownedPokemon.get(index);
        System.out.println("Pokemon berhasil di masukkan");
        ownedPokemon.get(index).setStatus(true);
        pokemonHidup++;
    }

    public void printOwned() {
        int count = 1;
        for (Pokemon p : battlePokemon) {
            if (p == null) {
                return;
            }
            if (p.isAlive()) {
                System.out.println(count + ". " + p.getNama());
            }
            count++;
        }
    }

    public boolean pokemonEmpty() {
        for (Pokemon p : ownedPokemon) {
            if (p.isAlive() && !p.isStatus()) {
                return false;
            }
        }
        return true;
    }

    public void add(Pokemon pokemon) {
        Pokemon monster;
        if (pokemon instanceof PokemonApi) {
            monster = new PokemonApi(pokemon.getNama(), pokemon.getLevel());
        } else if (pokemon instanceof PokemonAir) {
            monster = new PokemonAir(pokemon.getNama(), pokemon.getLevel());
        } else if (pokemon instanceof PokemonEs) {
            monster = new PokemonEs(pokemon.getNama(), pokemon.getLevel());
        } else if (pokemon instanceof PokemonAngin) {
            monster = new PokemonAngin(pokemon.getNama(), pokemon.getLevel());
        } else {
            monster = new PokemonTanah(pokemon.getNama(), pokemon.getLevel());
        }

        monster.setEvolusi(monster.getLevel());
        ownedPokemon.add(monster);
    }

    public void add(String nama,String tipe,int level,int evolusi,int hp,int ep) {
        Pokemon monster;
        if (tipe.equalsIgnoreCase("Api")) {
            monster = new PokemonApi(nama, level);
        } else if (tipe.equalsIgnoreCase("Air")) {
            monster = new PokemonAir(nama, level);
        } else if (tipe.equalsIgnoreCase("Es")) {
            monster = new PokemonEs(nama, level);
        } else if (tipe.equalsIgnoreCase("Angin")) {
            monster = new PokemonAngin(nama, level);
        } else {
            monster = new PokemonTanah(nama, level);
        }

        monster.setEvolusi(evolusi);
        monster.setHp(hp);
        monster.setTipe(tipe);
        if(monster.getHp() < 0){
            monster.setAlive(false);
        }
        monster.setEp(ep);
        ownedPokemon.add(monster);
    }
    
    public void addItem(String nama){
        listItem.add(new Item(nama));
    }
    
    public void clear(){
        for(int i = 0;i < battlePokemon.length; i++){
            battlePokemon[i] = null;
        }
        bPokemonIndex = 0;
    }

    public void tangkap(Pokemon musuh) {
        Pokemon pokemon;
        if (musuh instanceof PokemonApi) {
            pokemon = new PokemonApi(musuh.getNama(), musuh.getLevel());
        } else if (musuh instanceof PokemonAir) {
            pokemon = new PokemonAir(musuh.getNama(), musuh.getLevel());
        } else if (musuh instanceof PokemonEs) {
            pokemon = new PokemonEs(musuh.getNama(), musuh.getLevel());
        } else if (musuh instanceof PokemonAngin) {
            pokemon = new PokemonAngin(musuh.getNama(), musuh.getLevel());
        } else {
            pokemon = new PokemonTanah(musuh.getNama(), musuh.getLevel());
        }
        pokemon.setEvolusi(pokemon.getLevel());
        int probability = (int) (Math.random() * 99);
        if (probability > 49) {
            System.out.println(musuh.getNama() + " berhasil ditangkap :D");
            ownedPokemon.add(pokemon);
        } else {
            System.out.println(musuh.getNama() + "tidak berhasil ditangkap :(");
        }
    }

    public boolean contains(String nama) {
        for (Pokemon p : ownedPokemon) {
            if (p.getNama().equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

}
