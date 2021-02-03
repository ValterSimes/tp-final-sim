package Distribuciones;

public class Normal implements Distribucion {
    private double media;
    private double desvStandar;
    public Normal(){
        this.media=0;
        this.desvStandar=1;
    }
    public Normal(double media, double desvStandar){
        this.media=media;
        this.desvStandar=desvStandar;               
    }
    public double valor() {
        double acumulador=0;
        for (int i = 1; i <=12 ; i++) {
            acumulador+=Math.random();
        }
        double x=(acumulador-6)*desvStandar+media;
        return x;
    }

}
