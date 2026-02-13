package Modelo;


public class Apartamento extends Financiamento{
    protected double garageSlots;
    protected double apartmentFloor;
    protected double finMonths = (double) fin_years * 12;
    public Apartamento(double base_value, int fin_years, double interest_rate, int garageSlots, int apartmentFloor) {
        super(base_value, fin_years, interest_rate);
        this.apartmentFloor = apartmentFloor;
        this.garageSlots = garageSlots;
    }

    @Override
    public double total_Fee() {
        return (base_value * (Math.pow(1+interest_rate/12, finMonths)))/(Math.pow(1+interest_rate/12,finMonths)-1);
    }

    @Override
    public void Print() {
        System.out.println(
                "Apartamento de valor " + this.base_value + ", por " + this.fin_years + " anos, com juros de " + this.interest_rate + "% ao ano, totalizando " + this.total_Fee() + " reais.");
    }
    @Override
    public void writeData(String fileName){
        super.writeData(fileName, this.dataOrganizer());

    }
    @Override
    public String dataOrganizer(){
        return super.dataOrganizer() + String.valueOf(garageSlots) + "\n" + String.valueOf(apartmentFloor) + "\n";

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
        return base_value == Double.parseDouble(data) || fin_years == Double.parseDouble(data) || interest_rate == Double.parseDouble(data) || garageSlots == Double.parseDouble(data) || apartmentFloor == Double.parseDouble(data);
    }
}
