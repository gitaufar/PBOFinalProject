/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo;

/**
 *
 * @author ammar
 */
public abstract class Pokemon implements AksiPokemon{

    private String nama;
    private int damage;
    private int hp;
    private int level = 1;
    private int ep = 0;
    private boolean status = false;
    private int maxHp;
    private boolean alive = true;
    private int evolusi = 0;
    private boolean stun = false;

    public Pokemon(String nama, int damage, int hp) {
        this.nama = nama;
        this.damage = damage;
        this.hp = hp;
        maxHp = hp;
    }

    public Pokemon(String nama, int level) {
        this.nama = nama;
        this.hp = 100;
        this.damage = 10;
        this.level = level;
        if (level > 1) {
            for (int i = 0; i < level; i++) {
                hp += Math.ceil(hp * 0.1);
                damage += Math.ceil(damage * 0.1);
                epMax += 10 * (level - 1);
            }
        }
        maxHp = this.hp;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getEvolusi() {
        return evolusi;
    }

    public void setEvolusi(int evolusi) {
        this.evolusi = evolusi;
    }

    public boolean isStun() {
        return stun;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        hp = hp + (int) (Math.ceil(((this.level - 1) * hp) * 0.1));
        damage = damage + (int) (Math.ceil(((this.level - 1) * damage) * 0.1));
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
    private String tipe;

    public int getEpMax() {
        return epMax;
    }

    public void setEpMax(int epMax) {
        this.epMax = epMax;
    }
    
    private int epMax = 100;

    public abstract void printDetail();

    public void dapetEp(Pokemon musuh) {
        if (musuh.getLevel() > getLevel()) {
            System.out.println("Berhasil mengalahkan " + musuh.getNama() + " dapat 40 ep");
            ep += 40;
            return;
        } else if (musuh.getLevel() < getLevel()) {
            System.out.println("Berhasil mengalahkan " + musuh.getNama() + " dapat 10 ep");
            ep += 10;
            return;
        }
        System.out.println("Berhasil mengalahkan " + musuh.getNama() + " dapat 20 ep");
        ep += 20;
    }

    public void naikLevel() {
        if (ep >= epMax) {
            setLevel(++level);
            ep %= epMax;
            epMax += 10;
            System.out.println("Selamat " + getNama() + " naik level menjadi level " + getLevel());
            maxHp += (int) Math.ceil(maxHp * 0.1);
            damage += (int) Math.ceil(damage * 0.1);
            hp = maxHp;
        } else {
            System.out.println("Ep tidak mencukupi untuk naik level masih kurang " + (epMax - ep) + "Ep");
        }
    }

    public boolean criticalHit() {
        int crit = (int) (Math.random() * 10);
        return crit == 3;
    }

    @Override
    public void basicAttack(Pokemon musuh) {
        if (criticalHit()) {

            int criticalDamage = getDamage() * 2;
            musuh.setHp(musuh.getHp() - criticalDamage);
            System.out.println("Critical hit basic attack!!, memberi damage " + criticalDamage);
            return;

        }
        musuh.setHp(musuh.getHp() - getDamage());
        System.out.println("memberi damage " + getDamage() + " dengan basic attack");
    }

    @Override
    public abstract void elementalAttack(Pokemon musuh) throws InterruptedException;

    @Override
    public void spesialAttack(Pokemon musuh) {
        int sacrifice = (int) (Math.ceil(getHp() * 10 / 100));
        setHp(getHp() - sacrifice);
        int miss = (int) (Math.random() * 1000);
        if (miss == 523) {
            System.out.println("Serangan miss hp tetap berkurang " + sacrifice);
            return;
        }
        int dmg = sacrifice * 2 + this.damage;
        System.out.println("Mengorbankan " + sacrifice + " Hp untuk memberi " + dmg + " damage");
        musuh.setHp(musuh.getHp() - dmg);
    }

    public void randomAction(Pokemon enemy) throws InterruptedException {
        int action = (int) (Math.random() * 100);
        if (action > 60) {
            basicAttack(enemy);
        } else if (action > 40) {
            spesialAttack(enemy);
        } else{
            elementalAttack(enemy);
        }
    }
    
    public abstract String evolve();

}
