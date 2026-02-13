package util;

import Modelo.Financiamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class FiletoMemoryComparator {
    String line;
    boolean finType;
    public void DataComparator(ArrayList<Financiamento> fin_list, String filename){
        try(FileReader fw = new FileReader(filename);
            BufferedReader bw = new BufferedReader(fw);){
            for(Financiamento fin : fin_list){
                while (!Objects.equals(line = bw.readLine(), "")) {
                    if(fin.dataFinder(line)){
                        System.out.println("linha validada, com valor " + line);
                    }
                    else{
                        System.out.println("O valor " + line + "não deveria estar ai!");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}