
import Distribuciones.Distribucion;
import Distribuciones.Exponencial;
import Distribuciones.Normal;
import Distribuciones.Poisson;

import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class Principal extends javax.swing.JFrame {

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    //Componentes Swing
    private javax.swing.JLabel jLabelDisLlegada;
    private javax.swing.JLabel jLabelDisAtencion;
    private javax.swing.JLabel jLabelLambdaAtencion;
    private javax.swing.JLabel jLabelMediaAtencion;
    private javax.swing.JLabel jLabelDesvAtencion;
    private javax.swing.JLabel jLabelLambdaLlegada;
    private javax.swing.JLabel jLabelMediaLlegada;
    private javax.swing.JLabel jLabelDesvLlegada;
    private javax.swing.JLabel jLabelDuracion;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JPanel jPanelLlegAten;
    private javax.swing.JPanel jPanelLlegada;
    private javax.swing.JPanel jPanelAtencion;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JPanel jPanelRes;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jlDurSim;
    private javax.swing.JLabel jlDurSim1;
    private javax.swing.JLabel jlDurSim2;
    private javax.swing.JLabel jlDurSim3;
    private javax.swing.JLabel jlDurSim4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSimulacion;
    private javax.swing.JButton jbInforme;
    private javax.swing.JButton jbSimular;
    private javax.swing.JComboBox jcbAtencionDistribucion;
    private javax.swing.JComboBox jcbLlegadaDistribucion;
    private javax.swing.JTextField jtfAtencionDesviacion;
    private javax.swing.JTextField jtfAtencionLambda;
    private javax.swing.JTextField jtfAtencionMedia;
    private javax.swing.JTextField jtfLlegadaDesviacion;
    private javax.swing.JTextField jtfLlegadaLambda;
    private javax.swing.JTextField jtfLlegadaMedia;
    private javax.swing.JTextField jtfTiempoSim;

    double duracionSim;
    double lambdaL, mediaL, desvL; //distribucion llegada
    double lambdaA, mediaA, desvA; //distribucion atencion
    int disLlegada;
    int disAtencion;
    Modelo tabla;
    public McDonalds automac;
    Object fila[];
    int men;
    String val;


    public Principal() {
        cargar();
        iniciar();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    private void cargar() {

        jbSimular = new javax.swing.JButton();
        jPanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSimulacion = new javax.swing.JTable();
        jPanelLlegAten = new javax.swing.JPanel();
        jPanelLlegada = new javax.swing.JPanel();
        jPanelResultados = new javax.swing.JPanel();
        jPanelRes = new javax.swing.JPanel();
        jLabelLambdaAtencion = new javax.swing.JLabel();
        jtfLlegadaLambda = new javax.swing.JTextField();
        jLabelMediaAtencion = new javax.swing.JLabel();
        jtfLlegadaMedia = new javax.swing.JTextField();
        jLabelDesvAtencion = new javax.swing.JLabel();
        jtfLlegadaDesviacion = new javax.swing.JTextField();
        jcbLlegadaDistribucion = new javax.swing.JComboBox();
        jLabelDisLlegada = new javax.swing.JLabel();
        jPanelAtencion = new javax.swing.JPanel();
        jLabelLambdaLlegada = new javax.swing.JLabel();
        jtfAtencionLambda = new javax.swing.JTextField();
        jLabelMediaLlegada = new javax.swing.JLabel();
        jtfAtencionMedia = new javax.swing.JTextField();
        jLabelDesvLlegada = new javax.swing.JLabel();
        jtfAtencionDesviacion = new javax.swing.JTextField();
        jcbAtencionDistribucion = new javax.swing.JComboBox();
        jLabelDisAtencion = new javax.swing.JLabel();
        jbInforme = new javax.swing.JButton();
        jtfTiempoSim = new javax.swing.JTextField();
        jLabelDuracion = new javax.swing.JLabel();
        jlDurSim = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jlDurSim1 = new javax.swing.JLabel();
        jlDurSim2 = new javax.swing.JLabel();
        jlDurSim3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlDurSim4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulación");
        setExtendedState(4);
        setMinimumSize(new java.awt.Dimension(1300, 900));
        getContentPane().setLayout(null);

        jbSimular.setFont(new java.awt.Font("Arial", 1, 12));
        jbSimular.setForeground(new java.awt.Color(0, 50, 100));
        jbSimular.setText("Simular");
        jbSimular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSimularMouseClicked(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbSimularMousePressed(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jbSimularMouseReleased(evt);
            }
        });
        jbSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickSimular(evt);
            }
        });
        getContentPane().add(jbSimular);
        jbSimular.setBounds(820, 120, 100, 30);

        jPanelTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder(1, new java.awt.Color(0, 50, 100), new java.awt.Color(0, 150, 100)));

        jTableSimulacion.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
                },
                new String[]{
                        "Reloj", "Evento", "T. hasta prox llegada", "Prox. llegada", "T. atencion", "Fin atencion", "Estado caja", "Cola", "Sum. Rechazados", "Sum. Atendidos", "Espera Max", "Sum. T. Espera", "HL1", "HL2", "HL3"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, true, true, true, true, true, true, true, true, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableSimulacion);

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
                jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelTablaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanelTablaLayout.setVerticalGroup(
                jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelTablaLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                                .addContainerGap())
        );

        getContentPane().add(jPanelTabla);
        jPanelTabla.setBounds(40, 180, 1240, 500);


        jPanelLlegada.setBorder(javax.swing.BorderFactory.createEtchedBorder(1, new java.awt.Color(0, 50, 100), new java.awt.Color(0, 150, 100)));
        jPanelLlegada.setLayout(null);

        jLabelDisAtencion.setText("Distribucion:");
        jPanelAtencion.add(jLabelDisAtencion);
        jLabelDisAtencion.setBounds(20, 20, 75, 20);

        jLabelLambdaAtencion.setText("Lambda (λ):");
        jPanelLlegada.add(jLabelLambdaAtencion);
        jLabelLambdaAtencion.setBounds(20, 50, 75, 20);

        jtfLlegadaLambda.setText("0.66666");
        jtfLlegadaLambda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLlegadaLambdaActionPerformed(evt);
            }
        });
        jPanelLlegada.add(jtfLlegadaLambda);
        jtfLlegadaLambda.setBounds(140, 50, 130, 20);

        jLabelMediaAtencion.setText("Media (μ) (seg):");
        jPanelLlegada.add(jLabelMediaAtencion);
        jLabelMediaAtencion.setBounds(20, 80, 110, 20);

        jtfLlegadaMedia.setText("30");
        jPanelLlegada.add(jtfLlegadaMedia);
        jtfLlegadaMedia.setBounds(140, 80, 130, 20);

        jLabelDesvAtencion.setText("Desviacion (σ) (seg):");
        jPanelLlegada.add(jLabelDesvAtencion);
        jLabelDesvAtencion.setBounds(20, 110, 120, 20);

        jtfLlegadaDesviacion.setText("5");
        jPanelLlegada.add(jtfLlegadaDesviacion);
        jtfLlegadaDesviacion.setBounds(140, 110, 130, 20);

        jcbLlegadaDistribucion.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Normal", "Poisson", "Exponencial"}));
        jcbLlegadaDistribucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioDistribucionLlegada(evt);
            }
        });
        jPanelLlegada.add(jcbLlegadaDistribucion);
        jcbLlegadaDistribucion.setBounds(140, 20, 130, 20);

        jLabelDisLlegada.setText("Distribucion:");
        jPanelLlegada.add(jLabelDisLlegada);
        jLabelDisLlegada.setBounds(20, 20, 75, 20);

        jPanelAtencion.setBorder(javax.swing.BorderFactory.createEtchedBorder(1, new java.awt.Color(0, 50, 100), new java.awt.Color(0, 150, 100)));
        jPanelAtencion.setLayout(null);
        jLabelLambdaLlegada.setText("Lambda (λ):");
        jPanelAtencion.add(jLabelLambdaLlegada);
        jLabelLambdaLlegada.setBounds(20, 50, 75, 20);

        jtfAtencionLambda.setText("0.25");
        jtfAtencionLambda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAtencionLambdaActionPerformed(evt);
            }
        });
        jPanelAtencion.add(jtfAtencionLambda);
        jtfAtencionLambda.setBounds(140, 50, 130, 20);
        jLabelMediaLlegada.setText("Media (μ) (seg):");
        jPanelAtencion.add(jLabelMediaLlegada);
        jLabelMediaLlegada.setBounds(20, 80, 110, 20);

        jtfAtencionMedia.setText("45");
        jPanelAtencion.add(jtfAtencionMedia);
        jtfAtencionMedia.setBounds(140, 80, 130, 20);

        jLabelDesvLlegada.setText("Desviacion (σ) (seg):");
        jPanelAtencion.add(jLabelDesvLlegada);
        jLabelDesvLlegada.setBounds(20, 110, 120, 20);

        jtfAtencionDesviacion.setText("5");
        jPanelAtencion.add(jtfAtencionDesviacion);
        jtfAtencionDesviacion.setBounds(140, 110, 130, 20);

        jcbAtencionDistribucion.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Normal", "Poisson", "Exponencial"}));
        jcbAtencionDistribucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioDistribucionAtencion(evt);
            }
        });
        jPanelAtencion.add(jcbAtencionDistribucion);
        jcbAtencionDistribucion.setBounds(140, 20, 130, 20);

        javax.swing.GroupLayout jPanelLlegAtenLayout = new javax.swing.GroupLayout(jPanelLlegAten);
        jPanelLlegAten.setLayout(jPanelLlegAtenLayout);
        jPanelLlegAtenLayout.setHorizontalGroup(
                jPanelLlegAtenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLlegAtenLayout.createSequentialGroup()
                                .addComponent(jPanelLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(jPanelAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanelLlegAtenLayout.setVerticalGroup(
                jPanelLlegAtenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLlegAtenLayout.createSequentialGroup()
                                .addGroup(jPanelLlegAtenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanelLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanelAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(138, 138, 138))
        );

        getContentPane().add(jPanelLlegAten);
        jPanelLlegAten.setBounds(60, 17, 650, 175);

        jLabelDuracion.setFont(new java.awt.Font("Arial", 1, 12));
        jLabelDuracion.setText("Duración (min): ");
        getContentPane().add(jLabelDuracion);
        jLabelDuracion.setBounds(710, 60, 100, 20);

        jtfTiempoSim.setText("60");
        jtfTiempoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTiempoSimActionPerformed(evt);
            }
        });
        getContentPane().add(jtfTiempoSim);
        jtfTiempoSim.setBounds(810, 60, 110, 20);

        jbInforme.setFont(new java.awt.Font("Arial", 1, 12));
        jbInforme.setForeground(new java.awt.Color(0, 50, 100));
        jbInforme.setText("Resultados");
        jbInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInformeActionPerformed(evt);
            }
        });
        getContentPane().add(jbInforme);
        jbInforme.setBounds(710, 120, 100, 30);


        pack();
    }

    private void iniciar() {
        habilitarLlegada(jcbLlegadaDistribucion.getSelectedIndex());
        habilitarAtencion(jcbAtencionDistribucion.getSelectedIndex());
        fila = new Object[15];
    }

    //Habilitar variables de acuerdo a la distribucion de llegada
    private void habilitarLlegada(int op) {
        switch (op) {
            case 0:
                jtfLlegadaLambda.setEnabled(false);
                jtfLlegadaMedia.setEnabled(true);
                jtfLlegadaDesviacion.setEnabled(true);
                break;
            case 1:
            case 2:
                jtfLlegadaLambda.setEnabled(true);
                jtfLlegadaMedia.setEnabled(false);
                jtfLlegadaDesviacion.setEnabled(false);
                break;
        }
    }

    //Habilitar variables de acuerdo a la distribucion de atencion
    private void habilitarAtencion(int op) {
        switch (op) {
            case 0:
                jtfAtencionLambda.setEnabled(false);
                jtfAtencionMedia.setEnabled(true);
                jtfAtencionDesviacion.setEnabled(true);
                break;
            case 1:
            case 2:
                jtfAtencionLambda.setEnabled(true);
                jtfAtencionMedia.setEnabled(false);
                jtfAtencionDesviacion.setEnabled(false);
                break;
        }
    }

    private void clickSimular(java.awt.event.ActionEvent evt) {

        disLlegada = jcbLlegadaDistribucion.getSelectedIndex();
        disAtencion = jcbAtencionDistribucion.getSelectedIndex();
        Distribucion llegada = new Normal();
        Distribucion atencion = new Normal();
        try {

            duracionSim = Double.parseDouble(jtfTiempoSim.getText().trim());

            switch (disLlegada) {
                case 0:
                    mediaL = Double.parseDouble(jtfLlegadaMedia.getText().trim());
                    desvL = Double.parseDouble(jtfLlegadaDesviacion.getText().trim());
                    llegada = new Normal(mediaL, desvL);
                    break;
                case 1:
                    lambdaL = Double.parseDouble(jtfLlegadaLambda.getText().trim());
                    llegada = new Poisson(lambdaL);
                    break;
                case 2:
                    lambdaL = Double.parseDouble(jtfLlegadaLambda.getText().trim());
                    llegada = new Exponencial(lambdaL);
                    break;
            }

            switch (disAtencion) {
                case 0:
                    mediaA = Double.parseDouble(jtfAtencionMedia.getText().trim());
                    desvA = Double.parseDouble(jtfAtencionDesviacion.getText().trim());
                    atencion = new Normal(mediaA, desvA);
                    break;
                case 1:
                    lambdaA = Double.parseDouble(jtfAtencionLambda.getText().trim());
                    atencion = new Poisson(lambdaA);
                    break;
                case 2:
                    lambdaA = Double.parseDouble(jtfAtencionLambda.getText().trim());
                    atencion = new Exponencial(lambdaA);
                    break;
            }

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Ingrese parámeros válidos", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        automac = new McDonalds(duracionSim, llegada, atencion);

        cargarTabla();
        ;

    }

    private void cargarTabla() {
        try {
            tabla = new Modelo();
            jTableSimulacion.setModel(tabla);
            Render miRender = new Render();
            jTableSimulacion.setDefaultRenderer(String.class, miRender);
            tabla.addColumn("Reloj");
            tabla.addColumn("Evento");
            tabla.addColumn("T. hasta prox llegada");
            tabla.addColumn("Prox llegada");
            tabla.addColumn("T. atencion");
            tabla.addColumn("Fin Atencion");
            tabla.addColumn("Estado caja");
            tabla.addColumn("Cola");
            tabla.addColumn("Sum. Rechazados");
            tabla.addColumn("Sum. Atendidos");
            tabla.addColumn("Espera Max");
            tabla.addColumn("Sum t. Espera");
            tabla.addColumn("HL1");
            tabla.addColumn("HL2");
            tabla.addColumn("HL3");
            primeraFila();
            tabla.addRow(fila);

            while (!automac.terminar()) {
                tabla.addRow(automac.siguienteEvento());
                men = automac.getMen();
                val = automac.getEtiqueta();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void primeraFila() {
        fila[0] = automac.getReloj();
        fila[1] = "Inicialización";
        float prox = (float) automac.proximaLlegada();
        String a = "" + prox;
        a = a.substring(0, 6);
        fila[2] = a;
        fila[3] = a;
        fila[4] = "-";
        fila[5] = "-";
        fila[6] = automac.getEstadoCaja();
        fila[7] = "-";
        fila[8] = 0;
        fila[9] = automac.getContadorPersonasRechazadas();
        ;
        fila[10] = "-";
        fila[11] = "-";
        fila[12] = "-";
        fila[13] = "-";
        fila[14] = "-";

    }

    private void jbSimularMouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void jbSimularMousePressed(java.awt.event.MouseEvent evt) {
        jbSimular.setForeground(new java.awt.Color(0, 50, 100));
    }

    private void jbSimularMouseReleased(java.awt.event.MouseEvent evt) {
        jbSimular.setForeground(new java.awt.Color(0, 50, 100));
    }

    //accion ante cambio de distribucion en el combo
    private void cambioDistribucionLlegada(java.awt.event.ActionEvent evt) {
        habilitarLlegada(jcbLlegadaDistribucion.getSelectedIndex());
    }

    //accion ante cambio de distribucion en el combo
    private void cambioDistribucionAtencion(java.awt.event.ActionEvent evt) {
        habilitarAtencion(jcbAtencionDistribucion.getSelectedIndex());
    }

    private void jbInformeActionPerformed(java.awt.event.ActionEvent evt) {
        try {
        cargarResultados(jtfTiempoSim.getText(), automac.getMaximaPermanencia(), automac.getAcumuladoPermanencia(), automac.getContadorPersonasAtendidas(), automac.getContadorPersonasRechazadas());
            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, "Primero debe simular");
           }
    }

    private void jtfTiempoSimActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jtfLlegadaLambdaActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jtfAtencionLambdaActionPerformed(java.awt.event.ActionEvent evt) {
    }

    //RESULTADOS

    @SuppressWarnings("unchecked")
    private void cargarResultados(String tiempo, double maximaEspera, double acumuladorEspera, int contadorPersonasAtendidas, int contadorPersonasRechazadas) {
        double tiempoSim = Integer.parseInt(tiempo);
        float max = (float) maximaEspera / 60;
        float acum = (float) acumuladorEspera / 60;
        float promedioAtendidas = (float) (contadorPersonasAtendidas) / (float) (tiempoSim / 60);
        int contRechazadas = contadorPersonasRechazadas;
        float promedioEspera = (float) (acum / contadorPersonasAtendidas);

        javax.swing.GroupLayout jPanelResultadosLayout = new javax.swing.GroupLayout(jPanelRes);
        jPanelResultados.setBorder(javax.swing.BorderFactory.createEtchedBorder(1, new java.awt.Color(0, 50, 100), new java.awt.Color(0, 150, 100)));
        jPanelRes.setLayout(jPanelResultadosLayout);

        jPanelResultadosLayout.setHorizontalGroup(
                jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelResultadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanelResultadosLayout.setVerticalGroup(
                jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelResultadosLayout.createSequentialGroup()
                                .addComponent(jPanelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanelRes.setBounds(930, 20, 310, 150);

        jlDurSim1.setFont(new java.awt.Font("Arial", 1, 11));
        jlDurSim1.setText("Duración de la simulación:");
        jPanelResultados.add(jlDurSim1);

        jLabel.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel.setForeground(new java.awt.Color(0, 50, 100));
        jLabel.setText(tiempoSim + " min");
        jPanelResultados.add(jLabel);

        jlDurSim.setFont(new java.awt.Font("Arial", 1, 11));
        jlDurSim.setText("Clientes atendidos prom. hora:");
        jPanelResultados.add(jlDurSim);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel3.setForeground(new java.awt.Color(0, 50, 100));
        jLabel3.setText(promedioAtendidas + " clientes");
        jPanelResultados.add(jLabel3);

        jlDurSim2.setFont(new java.awt.Font("Arial", 1, 11));
        jlDurSim2.setText("Espera Maxima de un cliente:");
        jPanelResultados.add(jlDurSim2);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel4.setForeground(new java.awt.Color(0, 50, 100));
        jLabel4.setText(max + " min");
        jPanelResultados.add(jLabel4);

        jlDurSim3.setFont(new java.awt.Font("Arial", 1, 11));
        jlDurSim3.setText("Tiempo de espera prom. clientes:");
        jPanelResultados.add(jlDurSim3);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel5.setForeground(new java.awt.Color(0, 50, 100));
        jLabel5.setText(promedioEspera + "min");
        jPanelResultados.add(jLabel5);

        jlDurSim4.setFont(new java.awt.Font("Arial", 1, 11));
        jlDurSim4.setText("Cant. de clientes no atendidos");
        jPanelResultados.add(jlDurSim4);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel2.setForeground(new java.awt.Color(0, 50, 100));
        jLabel2.setText("" + contRechazadas);
        jPanelResultados.add(jLabel2);

        getContentPane().add(jPanelRes);
        pack();
    }
}

