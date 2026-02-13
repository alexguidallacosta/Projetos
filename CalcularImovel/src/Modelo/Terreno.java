package Modelo;

import java.io.*;
import java.util.Objects;

public class Terreno extends Financiamento{
    String slotType;
    public Terreno(double base_value, int fin_years, double interest_rate, String slotType) {
        super(base_value, fin_years, interest_rate);
        this.slotType = slotType;
    }

    @Override
    public double mensal_Fee() {
        return super.mensal_Fee()*1.02;
    }

    @Override
    public void Print() {
        System.out.println("Terreno de valor " + this.base_value + ", por " + this.fin_years + " anos, com juros de " + this.interest_rate + "% ao ano, totalizando " + this.total_Fee() + " reais.");
    }
    @Override
    public void writeData(String fileName){
        super.writeData(fileName, this.dataOrganizer());

    }

    @Override
    public String dataOrganizer() {
        return super.dataOrganizer() + String.valueOf(slotType) + "\n";
    }
    @Override
    public boolean dataFinder(String data){
        if (data == null) return false;
        data = data.trim();
        try{
            Double.parseDouble(data);
        }catch (NumberFormatException e){
            return Objects.equals(slotType, data);
        }
        return base_value == Double.parseDouble(data) || fin_years == Double.parseDouble(data) || interest_rate == Double.parseDouble(data);
    }
}
