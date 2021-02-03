package Distribuciones;

public class Exponencial implements Distribucion {
    private double lambda;

    public Exponencial (double lambda){
        this.lambda=lambda;
    }
    public Exponencial(){
        lambda=1;
    }
    public double valor() {
        double rnd=Math.random();
        double media=1/lambda;
        double x=-media*Math.log(1-rnd);
        return x;
    }





}
