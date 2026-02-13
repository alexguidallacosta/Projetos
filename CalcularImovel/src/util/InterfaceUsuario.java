package util;

import Modelo.Financiamento;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario{
    public void Interface(Financiamento fin1) {
        Scanner scanner = new Scanner(System.in);
        double base_value = 0;
        int fin_years = 0;
        double interest_rate = 0;
        boolean validated = false;
        System.out.println("Insira o valor base: ");
            try{
                base_value = scanner.nextDouble();
             }
            catch (InputMismatchException e){
                System.out.println("Insira um valor numérico.");
                Interface(fin1);
            }
            if (base_value < 0){
                throw new IllegalArgumentException("Valor base deve ser superior a 0, foi inserido "+ base_value);
            }
        System.out.println("Insira o tempo de financiamento: ");
        try{
            fin_years = scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Insira um valor numérico.");
        }

            if (fin_years > 50 || fin_years < 0){
                throw new IllegalArgumentException("O prazo do financiamento deve ser um valor positivo menor que 50, foi inserido "+ fin_years);
            }
            System.out.println("Insira a taxa de juros: ");
        try{
            interest_rate = scanner.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("Insira um valor numérico.");
        }
            if (interest_rate < 0 || interest_rate > 24)    {
                throw new IllegalArgumentException("Taxa de juros deve ser superior a 0 e menor que 24, foi inserido "+ interest_rate);
            }
        fin1.setFin_years(fin_years);
        fin1.setBase_value(base_value);
        fin1.setInterest_rate(interest_rate);
    }
}
