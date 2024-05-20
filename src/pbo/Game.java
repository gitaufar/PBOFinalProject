/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo;

/**
 *
 * @author ammar
 */
import java.io.*;
import java.util.*;


public class Game {

    public static void newGame(Player player) {
        Scanner input = new Scanner(System.in);
        int count = 1;
        int pilihan;
        System.out.println("Pilih pokemon awalan anda:");
        for (Pokemon pokemon : ListPokemon.list) {
            System.out.println(count + ". " + pokemon.getNama());
            count++;
        }
        System.out.print("Masukkan pilihan(dalam angka): ");
        pilihan = input.nextInt();
        player.add(ListPokemon.list.get(pilihan - 1));
    }

    public static void loadFile(Player player) throws InterruptedException {
        try {
            File pokemon = new File("Pokemon.txt");
            File item = new File("itemSave.txt");
            Scanner scan = new Scanner(pokemon);
            System.out.println("Berhasil load game...");
            Thread.sleep(1000);
            try {
                Scanner scan2 = new Scanner(item);
                while (scan2.hasNext()) {
                    player.addItem(scan2.nextLine());
                }
            } catch (FileNotFoundException e) {

            }

            while (scan.hasNext()) {
                String[] filePokemon = scan.nextLine().split(" ");
                player.add(filePokemon[0], filePokemon[1], Integer.parseInt(filePokemon[2]), Integer.parseInt(filePokemon[3]), Integer.parseInt(filePokemon[4]),Integer.parseInt(filePokemon[5]));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Belom ada file progress, otomatis memulai game dari awal");
            newGame(player);
        }
    }

    public static void saveFile(Player player) throws IOException {
        FileWriter itemSave;
        try (FileWriter pokemonSave = new FileWriter("Pokemon.txt")) {
            itemSave = new FileWriter("itemSave.txt");
            for (Pokemon p : player.ownedPokemon) {

                pokemonSave.write(p.getNama() + " " + p.getTipe() + " " + Integer.toString(p.getLevel()) + " " + Integer.toString(p.getEvolusi()) + " " + Integer.toString(p.getHp()) + " " + Integer.toString(p.getEp()));
                pokemonSave.write("\n");

            }
        }

        if (!player.listItem.isEmpty()) {
            for (Item i : player.listItem) {

                itemSave.write(i.nama);
                itemSave.write("\n");

            }

        }
        itemSave.close();

    }

    public static Pokemon selectPokemon(Player user) throws CustomException {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Pilih Pokemon untuk bertarung:");
            user.printOwned();
            int choice = input.nextInt();
            if (choice > 0 && choice <= user.ownedPokemon.size()) {
                Pokemon selectedPokemon = user.battlePokemon[choice - 1];
                if (selectedPokemon.isAlive()) {
                    return selectedPokemon;
                } else {
                    System.out.println("Pokemon sudah mati,tidak bisa dipilih.");
                }
            } else {
                throw new CustomException("Pilihan tidak valid.");
            }
        }
    }

    public static void enterBattleArena(Player user) throws InterruptedException, CustomException {
        Scanner input = new Scanner(System.in);
        Pokemon player = selectPokemon(user);
        Pokemon musuh = Dungeon.generateEnemy(player);

        if (player == null) {
            System.out.println("Tidak ada Pokemon yang tersedia untuk bertarung.");
            return;
        }

        System.out.println("Battle start....");
        System.out.println("type any key to ready...");
        String x = input.nextLine();
        boolean playerTurn = true, gameStart = true;

        while (gameStart) {

            if (playerTurn) {
                if (player.isStun()) {
                    System.out.println("Kamu terkena stun...");
                    playerTurn = false;
                    player.setStun(false);
                    continue;
                }
                Thread.sleep(650);
                System.out.println("Giliran kamu...");
                player.printDetail();
                System.out.println("1.Basic Attack\t\t3.Elemenetal Attack");
                System.out.println("2.Spesial Attack\t\t4.Runaway");
                System.out.println("5.Use item");

                int action = input.nextInt();
                switch (action) {
                    case 1 ->
                        player.basicAttack(musuh);
                    case 2 ->
                        player.spesialAttack(musuh);
                    case 3 ->
                        player.elementalAttack(musuh);
                    case 4 -> {
                        int success = (int) (Math.random() * 100);
                        if (success > 80) {
                            System.out.println("berhasil kabur..");
                            gameStart = false;
                        } else {
                            System.out.println("kabur gagal!!!");
                        }
                    }

                    case 5 -> {
                        if (user.listItem.isEmpty()) {
                            System.out.println("Tidak ada item yang bisa dipakai");
                            continue;
                        }
                        user.printItem();
                        System.out.print("Pilih item yang ingin digunakkan(nomor): ");
                        int choose = input.nextInt();
                        user.useItem(user.listItem.get(choose - 1), player);
                        user.listItem.remove(user.listItem.get(choose - 1));
                    }

                    default ->
                        System.out.println("opsi yang kamu pilih tidak ada kamu kehilangan 1 turn");
                }

                if (musuh.getHp() <= 0) {
                    System.out.println("Musuh telah dikalahkan!");
                    int drop = (int) (Math.random() * 100);
                    if (drop < 10) {
                        Item dropItem;
                        System.out.println("Musuh drop sebuah item...");
                        int change = (int) (Math.random() * 100);
                        if (change > 80) {
                            System.out.println("Mendapatkan high potion");
                            dropItem = new Item("High");
                        } else if (change > 50) {
                            System.out.println("Mendapatkan medium potion");
                            dropItem = new Item("Medium");
                        } else {
                            System.out.println("Mendapatkan regular potion");
                            dropItem = new Item("Reguler");
                        }
                        user.addItem(dropItem);
                    }
                    player.dapetEp(musuh);
                    if (!user.contains(musuh.getNama())) {
                        System.out.println("ingin mencoba menangkap musuh?");
                        System.out.println("1.iya\t2.tidak");
                        int choice = input.nextInt();
                        switch (choice) {
                            case 1 ->
                                user.tangkap(musuh);
                            default ->
                                System.out.println("baiklah...");
                        }
                    }
                    gameStart = false;
                }

                playerTurn = false;
            } else {
                if (musuh.isStun()) {
                    System.out.println("Musuh terkena stun...");
                    musuh.setStun(false);
                    playerTurn = true;
                    continue;
                }
                Thread.sleep(650);
                System.out.println("\nGiliran musuh...");
                musuh.printDetail();
                int success = (int) (Math.random() * 100);
                int action = (int) (Math.random() * 100);
                if (action == 50) {
                    System.out.println("Musuh mencoba kabur");
                    Thread.sleep(1000);
                    if (success > 80) {
                        System.out.println("musuh berhasil kabur..");
                        gameStart = false;
                    } else {
                        System.out.println("musuh gagal kabur!!!");
                    }
                } else {
                    musuh.randomAction(player);
                    System.out.println("");
                    if (player.getHp() <= 0) {
                        player.setAlive(false);
                        System.out.println(player.getNama() + " telah dikalahkan!");
                        user.setPokemonHidup(user.getPokemonHidup() - 1);
                        if (user.getPokemonHidup() > 0) {
                            System.out.println("Masih ada Pokemon yang hidup. Apakah Anda ingin melanjutkan pertarungan?");
                            System.out.println("1. Ganti Pokemon dan lanjutkan");
                            System.out.println("2. Akhiri pertarungan");
                            int choice = input.nextInt();
                            if (choice == 1) {
                                player = selectPokemon(user);
                                if (player == null) {
                                    System.out.println("Tidak ada Pokemon yang tersedia untuk bertarung.");
                                    gameStart = false;
                                }
                            } else {
                                gameStart = false;
                            }
                        } else {
                            System.out.println("Semua Pokemon telah dikalahkan. Pertarungan berakhir.");
                            gameStart = false;
                        }
                    }
                }

                playerTurn = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, CustomException, IOException {
        int pilihan;
        boolean gamePlaying = true;
        Dungeon d = new Dungeon();
        HomeBase hb = new HomeBase();
        int count = 1;

        Player a = new Player();
        a.setMap(hb);
        Scanner input = new Scanner(System.in);
        System.out.print("Selamat bermain");
        Thread.sleep(700);
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            Thread.sleep(700);
        }

        System.out.println("\n1.New Game");
        System.out.println("2.Load Game");

        pilihan = input.nextInt();
        switch (pilihan) {
            case 1 -> {
                newGame(a);
            }
            case 2 -> {
                loadFile(a);
            }
            default -> {
                System.out.println("Otomatis new game karena opsi yang dipilih tidak ada");
                newGame(a);
            }
        }

        while (gamePlaying) {

            int choose;

            while (a.getMap() instanceof HomeBase homebase) {
                System.out.println("1.LevelUp Pokemon");
                System.out.println("2.Heal Pokemon");
                System.out.println("3.Evolusi Pokemon");
                System.out.println("4.Menuju Dungeon");
                System.out.println("5.Exit game");

                int fungsi = input.nextInt();
                switch (fungsi) {
                    case 1 -> {
                        for (Pokemon p : a.ownedPokemon) {
                            System.out.println(count + ". " + p.getNama());
                            count++;
                        }
                        count = 1;
                        choose = input.nextInt();
                        homebase.levelUp(a.ownedPokemon.get(choose - 1));
                    }
                    case 2 -> {
                        for (Pokemon p : a.ownedPokemon) {
                            System.out.println(count + ". " + p.getNama());
                            count++;
                        }
                        count = 1;
                        choose = input.nextInt();
                        homebase.healPokemon(a.ownedPokemon.get(choose - 1));
                    }
                    case 3 -> {
                        for (Pokemon p : a.ownedPokemon) {
                            System.out.println(count + ". " + p.getNama());
                            count++;
                        }
                        count = 1;
                        choose = input.nextInt();
                        a.ownedPokemon.set(choose - 1, homebase.evolusi(a.ownedPokemon.get(choose - 1)));
                    }
                    case 4 -> {
                        if (a.pokemonEmpty()) {
                            System.out.println("Tidak ada pokemon yang bisa dibawa heal pokemon anda terlebih dahulu");
                            continue;
                        }
                        for (Pokemon p : a.ownedPokemon) {
                            System.out.println(count + ". " + p.getNama());
                            count++;
                        }
                        count = 1;
                        System.out.print("Mau bawa berapa pokemon ke dungeon (max 3): ");
                        choose = input.nextInt();
                        while(choose > 3 || choose < 1){
                            System.out.println("tidak boleh membawa pokemon lebih dari 3 atau kurang dari 1");
                            choose = input.nextInt();
                        }
                        
                        for (int i = 0; i < choose; i++) {
                            if (a.pokemonEmpty()) {
                                System.out.println("Tidak ada pokemon yang bisa anda bawa lagi");
                                break;
                            }
                            System.out.print("Pokemon(input angka): ");
                            int index = input.nextInt();
                            while (!a.ownedPokemon.get(index - 1).isAlive() || a.ownedPokemon.get(index - 1).isStatus()) {
                                System.out.println("Pokemon yang anda pilih mati/sudah ada di battle pokemon anda, pilih ulang");
                                index = input.nextInt();
                            }
                            a.bAdd(index - 1);
                        }
                        System.out.println("Menuju dungeon...");
                        Thread.sleep(1000);
                        a.setMap(d);
                    }

                    case 5 -> {
                        gamePlaying = false;
                        a.setMap(null);
                    }

                    default -> {
                        System.out.println("Opsi tidak tersedia, pilih ulang\n");
                    }
                }
            }

            while (a.getMap() instanceof Dungeon dungeon) {
                enterBattleArena(a);
                if (a.getPokemonHidup() > 0) {
                    System.out.println("1.Kembali ke homebase");
                    System.out.println("2.Lanjut bertarung");
                    int fungsi = input.nextInt();
                    switch (fungsi) {
                        case 1 -> {
                            a.setMap(hb);
                            for (int i = 0; i < a.bPokemonIndex; i++) {
                                a.battlePokemon[i].setStatus(false);
                            }
                            a.clear();
                        }

                    }
                } else {
                    System.out.println("Karena semua pokemon telah dikalahkan otomatis menuju homebase");
                    a.setMap(hb);
                    System.out.println("Menuju home base...");
                    for (int i = 0; i < a.bPokemonIndex; i++) {
                        a.battlePokemon[i].setStatus(false);
                    }
                    a.clear();
                    Thread.sleep(700);
                }

            }

            //save
            saveFile(a);
        }
    }
}
