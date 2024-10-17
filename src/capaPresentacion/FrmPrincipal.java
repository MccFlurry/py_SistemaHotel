package capaPresentacion;

import capaNegocio.clsUsuario;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class FrmPrincipal extends javax.swing.JFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdd = new SimpleDateFormat("HH:mm:ss");
    private String tipoUsuario;

    clsUsuario objUsuario = new clsUsuario();

    public FrmPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        iniciarReloj();
    }

    private void configurarVistaSegunUsuario() {
        if (tipoUsuario.equalsIgnoreCase("cliente")) {
            // Ocultar botones y menús no permitidos para clientes
            btnVenta.setVisible(false);
            btnCliente.setVisible(false);

            // Ocultar menús no permitidos para clientes
            mnuMantenimiento.setVisible(false);
            mnuVentas.setVisible(false);
            mnuReportes.setVisible(false);
            mnuProcedimientos.setVisible(false);

            // Mostrar solo los botones permitidos para el cliente
            btnIniciar.setVisible(true);
            btnCambiar.setVisible(true);
            btnCerrar.setVisible(true);
            btnConsultar.setVisible(true);
            btnPagar.setVisible(true);

        } else if (tipoUsuario.equalsIgnoreCase("empleado")) {
            // Mostrar todo para el empleado
            btnVenta.setVisible(true);
            btnCliente.setVisible(true);

            // Mostrar todos los menús
            mnuMantenimiento.setVisible(true);
            mnuVentas.setVisible(true);
            mnuReportes.setVisible(true);
            mnuProcedimientos.setVisible(true);
        }
    }

    private void iniciarReloj() {
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            Date fechaHora1 = new Date();
            lblfecha.setText(sdf.format(fechaHora1));
            lblHora.setText(sdd.format(fechaHora1));
        });
        timer.start(); // Iniciar el Timer
    }

    @Override
    public final Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("recursos/icono.png"));
        return retValue;
    }

    public void setUsuarioLogueado(String nombreCompleto) {
        lbluser.setText(nombreCompleto);
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        configurarVistaSegunUsuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mnuMantUsuario = new javax.swing.JMenuItem();
        mnuMantClientes = new javax.swing.JMenuItem();
        mnuMantCategoria = new javax.swing.JMenuItem();
        mnuMantProducto = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnIniciar = new javax.swing.JButton();
        btnCambiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnConsultar = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        mnuLogin = new javax.swing.JMenu();
        mnuMantenimiento = new javax.swing.JMenu();
        mnuMantUsuario1 = new javax.swing.JMenuItem();
        mnuMantClientes1 = new javax.swing.JMenuItem();
        mnuMantEmpresa = new javax.swing.JMenuItem();
        mnuMantLimpieza = new javax.swing.JMenuItem();
        mnuMantEmpleado = new javax.swing.JMenuItem();
        mnuMantHab = new javax.swing.JMenuItem();
        mnuMantCatHab = new javax.swing.JMenuItem();
        mnuMantReclamo = new javax.swing.JMenuItem();
        mnuMantPersona = new javax.swing.JMenuItem();
        mnuMantServicio = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        mnuReportes = new javax.swing.JMenu();
        mnuProcedimientos = new javax.swing.JMenu();

        jMenu1.setText("Login");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Mantenimiento");

        mnuMantUsuario.setText("Usuario");
        jMenu2.add(mnuMantUsuario);

        mnuMantClientes.setText("Clientes");
        mnuMantClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantClientesActionPerformed(evt);
            }
        });
        jMenu2.add(mnuMantClientes);

        mnuMantCategoria.setText("Pais");
        mnuMantCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantCategoriaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuMantCategoria);

        mnuMantProducto.setText("Empresa");
        mnuMantProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantProductoActionPerformed(evt);
            }
        });
        jMenu2.add(mnuMantProducto);

        jMenuItem1.setText("Tipo Empresa");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Limpieza");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Empleado");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Comprobante");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Habitacion");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Cat. Hab");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Reclamo");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Persona");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Servicio");
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Transaccion");
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ventas");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reportes");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Procedimientos");
        jMenuBar1.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/user.png"))); // NOI18N
        jLabel2.setText("Usuario");

        lbluser.setBackground(new java.awt.Color(18, 30, 49));
        lbluser.setForeground(new java.awt.Color(255, 255, 255));
        lbluser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbluser.setOpaque(true);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha");

        lblfecha.setBackground(new java.awt.Color(18, 30, 49));
        lblfecha.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        lblfecha.setForeground(new java.awt.Color(255, 255, 255));
        lblfecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfecha.setOpaque(true);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hora");

        lblHora.setBackground(new java.awt.Color(18, 30, 49));
        lblHora.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jToolBar1.setBackground(new java.awt.Color(0, 51, 102));
        jToolBar1.setRollover(true);

        btnIniciar.setBackground(new java.awt.Color(204, 255, 255));
        btnIniciar.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/login-.png"))); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.setFocusable(false);
        btnIniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnIniciar);

        btnCambiar.setBackground(new java.awt.Color(204, 255, 255));
        btnCambiar.setForeground(new java.awt.Color(0, 0, 0));
        btnCambiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/changeuser.png"))); // NOI18N
        btnCambiar.setText("Cambiar");
        btnCambiar.setFocusable(false);
        btnCambiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCambiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCambiar);

        btnCerrar.setBackground(new java.awt.Color(204, 255, 255));
        btnCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salir.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setFocusable(false);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCerrar);
        jToolBar1.add(jSeparator1);

        btnConsultar.setBackground(new java.awt.Color(204, 255, 255));
        btnConsultar.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscar.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setFocusable(false);
        btnConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnConsultar);

        btnVenta.setBackground(new java.awt.Color(204, 255, 255));
        btnVenta.setForeground(new java.awt.Color(0, 0, 0));
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/borrar.png"))); // NOI18N
        btnVenta.setText("Venta");
        btnVenta.setFocusable(false);
        btnVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnVenta);

        btnCliente.setBackground(new java.awt.Color(204, 255, 255));
        btnCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/borrar.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.setFocusable(false);
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCliente);

        btnPagar.setBackground(new java.awt.Color(204, 255, 255));
        btnPagar.setForeground(new java.awt.Color(0, 0, 0));
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/pagar.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setFocusable(false);
        btnPagar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPagar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnPagar);

        mnuLogin.setText("Login");
        jMenuBar2.add(mnuLogin);

        mnuMantenimiento.setText("Mantenimiento");

        mnuMantUsuario1.setText("Usuario");
        mnuMantUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantUsuario1ActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantUsuario1);

        mnuMantClientes1.setText("Clientes");
        mnuMantClientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantClientes1ActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantClientes1);

        mnuMantEmpresa.setText("Empresa");
        mnuMantEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantEmpresaActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantEmpresa);

        mnuMantLimpieza.setText("Limpieza");
        mnuMantLimpieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantLimpiezaActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantLimpieza);

        mnuMantEmpleado.setText("Empleado");
        mnuMantEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantEmpleadoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantEmpleado);

        mnuMantHab.setText("Habitacion");
        mnuMantHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantHabActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantHab);

        mnuMantCatHab.setText("Cat. Hab");
        mnuMantCatHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantCatHabActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantCatHab);

        mnuMantReclamo.setText("Reclamo");
        mnuMantReclamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantReclamoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantReclamo);

        mnuMantPersona.setText("Persona");
        mnuMantPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantPersonaActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantPersona);

        mnuMantServicio.setText("Servicio");
        mnuMantServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantServicioActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantServicio);

        jMenuBar2.add(mnuMantenimiento);

        mnuVentas.setText("Ventas");
        jMenuBar2.add(mnuVentas);

        mnuReportes.setText("Reportes");
        jMenuBar2.add(mnuReportes);

        mnuProcedimientos.setText("Procedimientos");
        jMenuBar2.add(mnuProcedimientos);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuMantClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantClientesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_mnuMantClientesActionPerformed

    private void mnuMantCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantCategoriaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_mnuMantCategoriaActionPerformed

    private void mnuMantProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantProductoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_mnuMantProductoActionPerformed

    private void mnuMantEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantEmpresaActionPerformed
        // TODO add your handling code here:
        jdMantEmpresa objEmpresa = new jdMantEmpresa(this, true);
        objEmpresa.setLocationRelativeTo(this);
        objEmpresa.setVisible(true);
    }//GEN-LAST:event_mnuMantEmpresaActionPerformed

    private void mnuMantLimpiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantLimpiezaActionPerformed
        // TODO add your handling code here:
        jdMantLimpieza objLimpieza = new jdMantLimpieza(this, true);
        objLimpieza.setLocationRelativeTo(this);
        objLimpieza.setVisible(true);
    }//GEN-LAST:event_mnuMantLimpiezaActionPerformed

    private void mnuMantUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantUsuario1ActionPerformed
        // TODO add your handling code here:
        jdMantUsuario objUsuario = new jdMantUsuario(this, true);
        objUsuario.setLocationRelativeTo(this);
        objUsuario.setVisible(true);

    }//GEN-LAST:event_mnuMantUsuario1ActionPerformed

    private void mnuMantClientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantClientes1ActionPerformed
        // TODO add your handling code here:
        jdMantCliente objCliente = new jdMantCliente(this, true);
        objCliente.setLocationRelativeTo(this);
        objCliente.setVisible(true);
    }//GEN-LAST:event_mnuMantClientes1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        iniciarReloj();
        jdInicioSesion is = new jdInicioSesion(this, true);
        is.setLocationRelativeTo(this);
        is.setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void mnuMantEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantEmpleadoActionPerformed
        // TODO add your handling code here:
        jdMantEmpleado objEmpleado = new jdMantEmpleado(this, true);
        objEmpleado.setLocationRelativeTo(this);
        objEmpleado.setVisible(true);
    }//GEN-LAST:event_mnuMantEmpleadoActionPerformed

    private void mnuMantHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantHabActionPerformed
        // TODO add your handling code here:
        jdMantHabitacion objHabitacion = new jdMantHabitacion(this, true);
        objHabitacion.setLocationRelativeTo(this);
        objHabitacion.setVisible(true);
    }//GEN-LAST:event_mnuMantHabActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        // TODO add your handling code here:
        try {
            ResultSet rsCuentas = objUsuario.listarCuentasGuardadas();

            if (rsCuentas != null) {
                JComboBox<String> comboCuentas = new JComboBox<>();
                while (rsCuentas.next()) {
                    comboCuentas.addItem(rsCuentas.getString("correo"));
                }
                int result = JOptionPane.showConfirmDialog(this, comboCuentas, "Seleccionar cuenta", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    String selectedEmail = (String) comboCuentas.getSelectedItem();
                    String password = JOptionPane.showInputDialog(this, "Ingrese su contraseña:");
                    if (password != null) {
                        String resultado = objUsuario.login(selectedEmail, password);
                        if (!resultado.isEmpty()) {
                            String[] partes = resultado.split(":");
                            String TipoUser = partes[0];
                            String nombreCompleto = partes[2];

                            // Set the logged-in user label
                            lbluser.setText(nombreCompleto);

                            setTipoUsuario(TipoUser);

                        } else {
                            JOptionPane.showMessageDialog(this, "Error: Contraseña incorrecta.");
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cambiar de cuenta: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCambiarActionPerformed

    private void mnuMantServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantServicioActionPerformed
        jdMantServicio objF = new jdMantServicio(this, true);
        objF.setLocationRelativeTo(this);
        objF.setVisible(true);
    }//GEN-LAST:event_mnuMantServicioActionPerformed

    private void mnuMantCatHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantCatHabActionPerformed
        jdMantCateHabitacion objF = new jdMantCateHabitacion(this, true);
        objF.setLocationRelativeTo(this);
        objF.setVisible(true);
    }//GEN-LAST:event_mnuMantCatHabActionPerformed

    private void mnuMantReclamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantReclamoActionPerformed
        jdMantReclamo objF = new jdMantReclamo(this, true);
        objF.setLocationRelativeTo(this);
        objF.setVisible(true);
    }//GEN-LAST:event_mnuMantReclamoActionPerformed

    private void mnuMantPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantPersonaActionPerformed
        // TODO add your handling code here:
        jdMantPersona objPersona = new jdMantPersona(this, true);
        objPersona.setLocationRelativeTo(this);
        objPersona.setVisible(true);
    }//GEN-LAST:event_mnuMantPersonaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lbluser;
    private javax.swing.JMenu mnuLogin;
    private javax.swing.JMenuItem mnuMantCatHab;
    private javax.swing.JMenuItem mnuMantCategoria;
    private javax.swing.JMenuItem mnuMantClientes;
    private javax.swing.JMenuItem mnuMantClientes1;
    private javax.swing.JMenuItem mnuMantEmpleado;
    private javax.swing.JMenuItem mnuMantEmpresa;
    private javax.swing.JMenuItem mnuMantHab;
    private javax.swing.JMenuItem mnuMantLimpieza;
    private javax.swing.JMenuItem mnuMantPersona;
    private javax.swing.JMenuItem mnuMantProducto;
    private javax.swing.JMenuItem mnuMantReclamo;
    private javax.swing.JMenuItem mnuMantServicio;
    private javax.swing.JMenuItem mnuMantUsuario;
    private javax.swing.JMenuItem mnuMantUsuario1;
    private javax.swing.JMenu mnuMantenimiento;
    private javax.swing.JMenu mnuProcedimientos;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenu mnuVentas;
    // End of variables declaration//GEN-END:variables
}
