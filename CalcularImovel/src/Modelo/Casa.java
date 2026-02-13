package Modelo;

import java.io.*;
import java.util.Objects;

public class Casa extends Financiamento {
    protected double buildArea;
    protected double lotSize;

    public Casa(double base_value, int fin_years, double interest_rate, double buildArea, double lotSize) throws AumentoMaiorDoQueJurosException {
        super(base_value, fin_years, interest_rate);
        validateHouse();
        this.lotSize = lotSize;
        this.buildArea = buildArea;
    }

    @Override
    public double mensal_Fee() {
        return super.mensal_Fee() + 80;
    }

    @Override
    public void Print() {
        System.out.println("Casa de valor " + this.base_value + ", por " + this.fin_years + " anos, com juros de " + this.interest_rate + "% ao ano, totalizando " + this.total_Fee() + " reais.");
    }

    public void validateHouse() throws AumentoMaiorDoQueJurosException {
        double fees = this.base_value / (this.fin_years * 12) * (this.interest_rate / 12);
        if (fees >= 40) {
            throw new AumentoMaiorDoQueJurosException("Financiamento de valor " + base_value + " reais é barato demais para uma casa, pois o juros mensal é de " + fees + " por mês, sendo menos da metade do valor do seguro.");
        }
    }

    @Override
    public void writeData(String fileName){
        super.writeData(fileName, this.dataOrganizer());

    }

    @Override
    public String dataOrganizer() {
        return super.dataOrganizer() + String.valueOf(lotSize) + "\n" + String.valueOf(buildArea) + "\n";
    }
    @Override
    public boolean dataFinder(String data){
        if (data == null) return false;
        data = data.trim();
        try{
            Double.parseDouble(data);
        }catch (NumberFormatException e){
            return false;
        }
        return base_value == Double.parseDouble(data) || fin_years == Double.parseDouble(data) || interest_rate == Double.parseDouble(data) || buildArea == Double.parseDouble(data) || lotSize == Double.parseDouble(data);
    }
}