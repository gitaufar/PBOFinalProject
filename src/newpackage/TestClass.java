/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author ammar
 */
public class TestClass {
    //this untuk mengakses akses di class tsb, super akses variable parent class
    public static void main(String[] args) {
        
        /*interface
        dinamic binding
        abstract class
        */
        Orang joko;
        Orang budi;
        
        joko = new pegawai("joko",5.0,20);
        budi = new manager("budi",15,29,"hacker");
        
        joko.printDetail();
        joko.bayarPajak();
        joko.printDetail();
        
        budi.printDetail();
        budi.bayarPajak();
        budi.printDetail();
        
    }
}

//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//
//class Node {
//    // Isi Disini
//    Node next;
//    String item;
//    public Node(String item){
//     this.item = item;   
//    }
//}
//
//Node head;
//Node tail;
//int n;
//
//
//class LinkedList {
//
//    public boolean isEmpty() {
//        // Isi Disini
//        return head == null;
//    }
//
//    public void addFirst(Node input) {
//        // Isi Disini
//        if(head == null){
//        head = input;
//        tail = input;
//        } else {
//            input.next = head;
//            head = input;
//        }
//    }
//
//    public void addLast(Node input) {
//        // Isi Disini
//    }
//
//    public void addAfter(String key, Node input) {
//        // Isi Disini
//    }
//
//    public void addBefore(String key, Node input) {
//        // Isi Disini
//    }
//
//    public void cetak() {
//        // Isi Disini
//    }
//}

//public class Solution {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        scanner.nextLine();
//
//        LinkedList list = new LinkedList();
//
//        for (int i = 0; i < N; i++) {
//            String operation = scanner.nextLine();
//            String[] parts = operation.split(" ");
//            String command = parts[0];
//
//            Node newNode = new Node(parts[1]);
//
//            switch (command) {
//                case "awal":
//                    addFirst(newNode);
//                    break;
//                case "akhir":
//                    // Isi Disini
//                    break;
//                case "sebelum":
//                    // Isi Disini
//                    break;
//                case "setelah":
//                    // Isi Disini
//                    break;
//            }
//        }
//        scanner.close();
//    }
//}

//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//
//class Node {
//    // Isi Disini
//    Node next;
//    String item;
//    public Node(String item){
//     this.item = item;   
//    }
//}
//
//
//class LinkedList {
//    
//    Node head;
//    Node tail;
//    int n;
//
//    public boolean isEmpty() {
//        // Isi Disini
//        return head == null;
//    }
//
//    public void addFirst(Node input) {
//        // Isi Disini
//        if(head == null){
//        head = input;
//        tail = input;
//        } else {
//            input.next = head;
//            head = input;
//        }
//        n++;
//    }
//
//    public void addLast(Node input) {
//        // Isi Disini
//        if(tail == null){
//            tail = input;
//            head = input;
//        } else {
//            tail.next = input;
//            tail = input;
//        }
//        n++;
//    }
//
//    public void addAfter(String key, Node input) {
//        // Isi Disini
//        Node temp = head;
//        for(int i = 0; i < n; i++){
//            if(temp.item.equalsIgnoreCase(key)){
//                input.next = temp.next;
//                temp.next = input;
//                break;
//            }
//            temp = temp.next;
//        }
//        n++;
//    }
//
//    public void addBefore(String key, Node input) {
//        // Isi Disini
//        Node temp = head;
//        for(int i = 0; i < n; i++){
//            if(temp.next.item.equalsIgnoreCase(key)){
//                input.next = temp;
//                break;
//            }
//            temp = temp.next;
//        }
//    }
//
//    public void cetak() {
//        // Isi Disini
//        Node temp = head;
//        while(temp != null){
//        System.out.print(temp.item + " -> ");
//            temp = temp.next;
//        }
//        System.out.println("null");
//    }
//}
//
//public class Solution {
//    
//    
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        scanner.nextLine();
//
//        LinkedList list = new LinkedList();
//
//        for (int i = 0; i < N; i++) {
//            String operation = scanner.nextLine();
//            String[] parts = operation.split(" ");
//            String command = parts[0];
//
//            Node newNode = new Node(parts[1]);
//
//
//            switch (command) {
//                case "awal":
//                    list.addFirst(newNode);
//                    break;
//                case "akhir":
//                    list.addLast(newNode);
//                    break;
//                case "sebelum":
//                    // Isi Disini
//                    list.addBefore(parts[1],new Node(parts[2]));
//                    break;
//                case "setelah":
//                    // Isi Disini
//                    list.addAfter(parts[1],new Node(parts[2]));
//                    break;
//            }
//                list.cetak();
//        }
//        scanner.close();
//    }
//}
