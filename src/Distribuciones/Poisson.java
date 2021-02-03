package Distribuciones;

public class Poisson implements Distribucion {
    private double lambda;
    private double a;
    public Poisson(double lambda){
        this.lambda=lambda;
        this.a=Math.exp((double)-lambda);
    }
    public double valor() {
        double rnd=Math.random();
        double media=lambda;

        double p=1;
        double x=-1;

//        do {
//            double rnd=Math.random();
//            p=p*rnd;
//            x+=x;
//        } while (p>=a);
//        return x;
        while (p>=a) {
            p = p*Math.random();
            x = x+1;
        }
        return x;

    }


}
