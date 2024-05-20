/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pbo;

/**
 *
 * @author ammar
 */
public interface AksiPokemon {
    public void basicAttack(Pokemon musuh);
    public void spesialAttack(Pokemon musuh);
    public void elementalAttack(Pokemon musuh) throws InterruptedException;
}
