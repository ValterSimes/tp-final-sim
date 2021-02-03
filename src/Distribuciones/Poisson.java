package Distribuciones;

public class Poisson implements Distribucion {
    private double lambda;
    private double a;
    public Poisson(double lambda){
        this.lambda=lambda;
        this.a=Math.exp((double)-lambda);
    }
    public double valor() {
        double p=1;
        double x=-1;

        while (p>=a) {
            p = p*Math.random();
            x = x+1;
        }
        return x;
    }

}
