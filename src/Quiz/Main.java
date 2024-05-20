/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ammar
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner scan = new Scanner(System.in);

        ArrayList<String> data = new ArrayList<>();
        FileWriter fw = new FileWriter("D:\\Aufar\\tugasPemdas\\test.txt");
        String[][] x = new String[2][3];
        for (String[] x1 : x) {
            for (int j = 0; j < x[0].length; j++) {
                x1[j] = scan.nextLine();
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                fw.write(x[i][j] + " ");
            }
            fw.write("\n");
        }
        fw.close();
        try {
            File myObj = new File("D:\\Aufar\\FilePBO\\apaAja.txt");
            Scanner input = new Scanner(myObj);
            while (input.hasNextLine()) {
                data.add(input.nextLine());
            }
            for (String i : data) {
                System.out.println(i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("belum ada progress gim otomatis menuju new game");
        }

    }
}
