package Modelo;


import java.io.*;
import java.util.ArrayList;

public abstract class Financiamento implements Serializable{
    protected double base_value;
    protected double fin_years;
    protected double interest_rate;

    public Financiamento(double base_value, int fin_years, double interest_rate) {
        setBase_value(base_value);
        setFin_years(fin_years);
        setInterest_rate(interest_rate);
    }
    public BufferedWriter out;
    public double getBase_value(){
        return this.base_value;
    }
    public double getInterest_rate(){
        return this.interest_rate;
    }
    public double getFin_years(){
        return this.fin_years;
    }
    public void setBase_value(double base_value) {
        if(base_value > 0) {
            this.base_value = base_value;
        }
        else{
            throw new IllegalArgumentException("Valor base deve ser superior a 0, foi inserido "+ base_value);
        }
    }

    public void setFin_years(int fin_years) {
        if (fin_years < 50 && fin_years > 0){
            this.fin_years = fin_years;
        }
        else {
            throw new IllegalArgumentException("O prazo do financiamento deve ser um valor positivo menor que 50, foi inserido " + base_value);
        }
    }

    public void setInterest_rate(double interest_rate) {
        if (interest_rate > 0 && interest_rate < 24){
            this.interest_rate = interest_rate;
        }
        else{
            throw new IllegalArgumentException("Taxa de juros deve ser superior a 0 e menor que 24, foi inserido"+ interest_rate);
        }
    }

    public double mensal_Fee() {
        return (this.base_value / (this.fin_years * 12)) * (1 + (this.interest_rate/12));
    }

    public double total_Fee() {
        return mensal_Fee() * fin_years * 12;
    }

    public abstract void Print();

    public void writeData(String fileName, String wroteData) {
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(wroteData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void checkData(ArrayList<Financiamento> fin_list){
        String line;
        boolean finType;
        try(FileReader fw = new FileReader("fin.txt");
            BufferedReader bw = new BufferedReader(fw);){
            for(Financiamento fin : fin_list){
                while ((line = bw.readLine()) != null) {
                    if(line.equals(String.valueOf(fin.getBase_value()))){
                        System.out.println("O valor base do Financiamento está correto!");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void writeData(String fileName);

    public String dataOrganizer(){
        return String.valueOf(base_value) + "\n" + String.valueOf(fin_years) + "\n" + String.valueOf(String.valueOf(interest_rate)) + "\n";

    }
    public boolean dataFinder(String data){
        if (data == null) return false;
        data = data.trim();
        try{
            Double.parseDouble(data);
        }catch (NumberFormatException e){
            return false;
        }
        return base_value == Double.parseDouble(data) || fin_years == Double.parseDouble(data) || interest_rate == Double.parseDouble(data);
    }
}

