package main;

import Modelo.*;
import util.FiletoMemoryComparator;
import util.InterfaceUsuario;

import javax.print.attribute.standard.PrinterState;
import javax.print.attribute.standard.PrinterStateReason;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, AumentoMaiorDoQueJurosException {
        Scanner scanner = new Scanner(System.in);
        double total_value = 0;
        Random random = new Random();
        ArrayList<Financiamento> fin_list = new ArrayList<>();
        fin_list.add(new Casa(1,1,1,1, 1 ));
        InterfaceUsuario user = new InterfaceUsuario();
        user.Interface(fin_list.get(0));
        try {
            fin_list.add(new Casa(100000,10,0.1, 10000, 10000));
        } catch (AumentoMaiorDoQueJurosException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            fin_list.add(new Casa(300000,20,0.08, 10000, 10000));
        } catch (AumentoMaiorDoQueJurosException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try{
            fin_list.add(new Apartamento(800000,10,1, 10, 5));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try{
            fin_list.add(new Apartamento(500000,30,1, 10, 5));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


        for (Financiamento single_fin : fin_list) {
            single_fin.Print();
            total_value = total_value + single_fin.total_Fee();
        }
        System.out.println("O total desses financiamentos é " + total_value + " reais.");

        for (Financiamento financiamento : fin_list) {
            financiamento.writeData("fin.txt");
        }
        FiletoMemoryComparator comp = new FiletoMemoryComparator();
        comp.DataComparator(fin_list,"fin.txt");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("finobjects.txt"))) {
            oos.writeObject(fin_list);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        } try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("finobjects.txt"))) {
            ArrayList<Financiamento> fileFinList = (ArrayList<Financiamento>) ois.readObject();
            for (int i = 0; i < fin_list.size(); i++) {
                if (fileFinList.get(i) instanceof Financiamento) {
                    System.out.println("O objeto está correto!");
                } else {
                    System.out.println("O objeto está incorreto!");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
