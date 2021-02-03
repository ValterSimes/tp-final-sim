import Distribuciones.Distribucion;

public class McDonalds {

    private int cantidadEnCola;
    private double h1;
    private double h2;
    private double h3;
    private double eventos[];
    private double maximaPermanencia;
    private double acumuladoPermanencia;
    private int contadorPersonasAtendidas;
    private int contadorPersonasRechazadas;
    private Distribucion llegada;
    private Distribucion atencion;
    private double duracionSim;
    private double reloj;
    private Object[] fila;
    private String nombreEvento;
    private int men;
    private int estadoCaja;
    private int colaMaxima;

    public McDonalds() {

    }

    public McDonalds(double duracionSim, Distribucion llegada, Distribucion atencion) {
        maximaPermanencia = 0;
        acumuladoPermanencia = contadorPersonasAtendidas = contadorPersonasRechazadas = 0;
        h1 = h2 = h3 = 0;
        reloj = 0;
        eventos = new double[2];

        for (int i = 0; i < eventos.length; i++) {
            eventos[i] = -1;
        }

        fila = new Object[15];
        estadoCaja = 0;
        this.duracionSim = duracionSim * 60;
        this.llegada = llegada;
        this.atencion = atencion;
        this.colaMaxima = 3;

    }

    public boolean terminar() {
        return (reloj > duracionSim);
    }

    public Object[] siguienteEvento() {
        if (reloj > duracionSim) {
            for (int i = 0; i < fila.length; i++) {
                fila[i] = "-";
            }
            return fila;
        }

        men = menor();
        reloj = eventos[men];
        switch (men) {
            case 0:
                nombreEvento = "Llegada";
                eventoLlegada();
                break;
            case 1:
                nombreEvento = "Fin Atención";
                eventoAtencion();
                break;
        }

        fila[1] = nombreEvento;
        String a = "" + reloj;
        a = a.substring(0, 6);
        fila[0] = a;
        if (!nombreEvento.equals("Llegada")) {
            fila[2] = "-";
        }
        a = "" + eventos[0];
        a = a.substring(0, 6);
        fila[3] = a;
        fila[6] = getEstadoCaja();
        if (cantidadEnCola == 0) {
            fila[7] = "" + 0;
        } else {
            fila[7] = "" + cantidadEnCola;
        }

        if (eventos[1] != -1) {
            a = "" + eventos[1];
            a = a.substring(0, 6);
            fila[5] = a;
        } else {
            fila[5] = "-";
        }

        if (contadorPersonasRechazadas == 0) {
            fila[8] = 0;
        } else {
            a = "" + contadorPersonasRechazadas;
            fila[8] = a;
        }

        if (contadorPersonasAtendidas == 0) {
            fila[9] = 0;
        } else {
            a = "" + contadorPersonasAtendidas;
            fila[9] = a;
        }
        if (maximaPermanencia == 0) {
            fila[10] = "-";
        } else {
            a = "" + maximaPermanencia;
            a = a.substring(0, 6);
            fila[10] = a;
        }

        if (acumuladoPermanencia == 0) {
            fila[11] = "-";
        } else {
            a = "" + acumuladoPermanencia;
            a = a.substring(0, 6);
            fila[11] = a;
        }

        if (h1 == 0) {
            fila[12] = "-";
        } else {
            a = "" + h1;
            a = a.substring(0, 6);
            fila[12] = a;
        }
        if (h2 == 0) {
            fila[13] = "-";
        } else {
            a = "" + h2;
            a = a.substring(0, 6);
            fila[13] = a;
        }
        if (h3 == 0) {
            fila[14] = "-";
        } else {
            a = "" + h3;
            a = a.substring(0, 6);
            fila[14] = a;
        }

        return fila;
    }

    public int menor() {
        int i;
        double menor = eventos[0];
        int pos = 0;
        for (i = 1; i < eventos.length; i++) {
            if (eventos[i] < menor && eventos[i] != -1) {
                menor = eventos[i];
                pos = i;
            }
        }
        return pos;
    }

    public double getReloj() {
        return reloj;
    }

    public double proximaLlegada() {
        double proxima = llegada.valor();
        eventos[0] = reloj + proxima;
        return proxima;
    }

    public double proximoFinAtencion() {
        double proxima = atencion.valor();
        eventos[1] = reloj + proxima;
        return proxima;
    }


    public String getEstadoCaja() {

        switch (estadoCaja) {
            case 0:
                return "Libre";
            case 1:
                return "Ocupado";
        }
        return "";
    }

    private void eventoLlegada() {
        String a = "" + proximaLlegada();
        a = a.substring(0, 6);
        fila[2] = a;
        if (estadoCaja == 0) {
            estadoCaja = 1;
            a = "" + proximoFinAtencion();
            a = a.substring(0, 6);
            fila[4] = a;

        } else if (estadoCaja != 0) {
            if (cantidadEnCola >= colaMaxima) {
                contadorPersonasRechazadas++;
            } else {
                cantidadEnCola++;
                fila[4] = "-";

                if (h1 == 0) {
                    h1 = reloj;
                } else if (h2 == 0) {
                    h2 = reloj;
                } else if (h3 == 0) {
                    h3 = reloj;
                }
            }
        }
    }

    private void eventoAtencion() {
        if (cantidadEnCola == 0) {
            estadoCaja = 0;
            eventos[1] = -1;
            fila[4] = "-";
            contadorPersonasAtendidas++;
        } else {
            String a, b, c;
            cantidadEnCola--;
            a = "" + proximoFinAtencion();
            a = a.substring(0, 6);
            fila[4] = a;
            horarioMenor();
            contadorPersonasAtendidas++;
        }
    }

    //que auto atender
    public void horarioMenor() {
        double diferencia;

        if (h1 != 0 && h2 == 0 && h3 == 0) {
            acumuladoPermanencia = acumuladoPermanencia + (reloj - h1);
            diferencia = (reloj - h1);
            if (diferencia > maximaPermanencia) {
                maximaPermanencia = diferencia;
            }
            h1 = 0;

        } else if (h2 != 0 && h1 == 0 && h3 == 0) {
            acumuladoPermanencia = acumuladoPermanencia + (reloj - h2);
            diferencia = (reloj - h2);
            if (diferencia > maximaPermanencia) {
                maximaPermanencia = diferencia;
            }
            h2 = 0;
        } else if (h3 != 0 && h1 == 0 && h2 == 0) {
            acumuladoPermanencia = acumuladoPermanencia + (reloj - h3);
            diferencia = (reloj - h3);
            if (diferencia > maximaPermanencia) {
                maximaPermanencia = diferencia;
            }
            h3 = 0;
        } else if (h1 != 0 && h2 != 0 && h3 == 0) {
            if (h1 < h2) {
                acumuladoPermanencia = acumuladoPermanencia + (reloj - h1);
                diferencia = (reloj - h1);
                if (diferencia > maximaPermanencia) {
                    maximaPermanencia = diferencia;
                }
                h1 = 0;

            } else {
                acumuladoPermanencia = acumuladoPermanencia + (reloj - h2);
                diferencia = (reloj - h2);
                if (diferencia > maximaPermanencia) {
                    maximaPermanencia = diferencia;
                }
                h2 = 0;
            }


        } else if (h1 != 0 && h3 != 0 && h2 == 0) {
            if (h1 < h3) {
                acumuladoPermanencia = acumuladoPermanencia + (reloj - h1);
                diferencia = (reloj - h1);
                if (diferencia > maximaPermanencia) {
                    maximaPermanencia = diferencia;
                }
                h1 = 0;
            } else {
                acumuladoPermanencia = acumuladoPermanencia + (reloj - h3);
                diferencia = (reloj - h3);
                if (diferencia > maximaPermanencia) {
                    maximaPermanencia = diferencia;
                }
                h3 = 0;
            }
        } else if (h2 != 0 && h3 != 0 && h1 == 0) {
            if (h2 < h3) {
                acumuladoPermanencia = acumuladoPermanencia + (reloj - h2);
                diferencia = (reloj - h2);
                if (diferencia > maximaPermanencia) {
                    maximaPermanencia = diferencia;
                }
                h2 = 0;

            } else {
                acumuladoPermanencia = acumuladoPermanencia + (reloj - h3);
                diferencia = (reloj - h3);
                if (diferencia > maximaPermanencia) {
                    maximaPermanencia = diferencia;
                }
                h3 = 0;
            }

        } else if (h1 < h2 && h1 < h3 && h2 != 0 && h3 != 0 && h1 != 0) {
            diferencia = (reloj - h1);
            if (diferencia > maximaPermanencia) {
                maximaPermanencia = diferencia;
            }
            acumuladoPermanencia = (reloj - h1) + acumuladoPermanencia;
            h1 = 0;

        } else if (h2 < h1 && h2 < h3 && h2 != 0 && h3 != 0 && h1 != 0) {

            acumuladoPermanencia = acumuladoPermanencia + (reloj - h2);
            diferencia = (reloj - h2);
            if (diferencia > maximaPermanencia) {
                maximaPermanencia = diferencia;
            }
            h2 = 0;
        } else if (h3 < h1 && h3 < h2 && h2 != 0 && h3 != 0 && h1 != 0) {
            acumuladoPermanencia = acumuladoPermanencia + (reloj - h3);
            diferencia = (reloj - h3);
            if (diferencia > maximaPermanencia) {
                maximaPermanencia = diferencia;
            }
            h3 = 0;

        }

    }

    public int getMen() {
        return men;
    }

    public String getEtiqueta() {
        return String.valueOf(eventos[men]);
    }

    public double getAcumuladoPermanencia() {
        return acumuladoPermanencia;
    }

    public double getMaximaPermanencia() {
        return maximaPermanencia;
    }


    public void setEstadoCaja(int estadoCaja) {
        this.estadoCaja = estadoCaja;
    }

    public double getHoraLLegada1() {
        return h1;
    }

    public void setHoraLLegada1(double h1) {
        this.h1 = h1;
    }

    public double getHoraLLegada2() {
        return h2;
    }

    public void setHoraLLegada2(double h2) {
        this.h2 = h2;
    }

    public double getHoraLLegada3() {
        return h3;
    }

    public void setHoraLLegada3(double h3) {
        this.h3 = h3;
    }

    public Distribucion getAtencion() {
        return atencion;
    }

    public void setAtencion(Distribucion atencion) {
        this.atencion = atencion;
    }

    public int getContadorPersonasAtendidas() {
        return contadorPersonasAtendidas;
    }

    public void setContadorPersonasAtendidas(int contadorPersonasAtendidas) {
        this.contadorPersonasAtendidas = contadorPersonasAtendidas;
    }

    public int getContadorPersonasRechazadas() {
        return contadorPersonasRechazadas;
    }

    public void setContadorPersonasRechazadas(int contadorPersonasRechazadas) {
        this.contadorPersonasRechazadas = contadorPersonasRechazadas;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public double getSimulacion() {
        return duracionSim;
    }

    public void setSimulacion(double simulacion) {
        this.duracionSim = duracionSim;
    }

}

