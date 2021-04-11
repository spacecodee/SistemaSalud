package Vista.Cita;

import Controlador.CtrlCitas;
import Controlador.ctrlUsuario;
import java.util.Date;
import javax.swing.JOptionPane;

public class jdCitaCRUD extends javax.swing.JDialog {

    ctrlUsuario ctrlUsu = new ctrlUsuario();
    CtrlCitas ctrlCi = new CtrlCitas();
    String verificar = "Agregar";

    public jdCitaCRUD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        ctrlCi.datosUsuario(cbxUsuario);
        ctrlCi.datosDoctor(cbxDoctor);
        ctrlCi.mostrarCita(tblUsuarios);
        dtDia.setDatoFecha(new Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new rojerusan.RSTableMetro();
        txtCodigo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxUsuario = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxDoctor = new javax.swing.JComboBox<>();
        dtDia = new rojeru_san.rsdate.RSDateChooser();
        lblID = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1240, 758));
        setMinimumSize(new java.awt.Dimension(1240, 758));
        setPreferredSize(new java.awt.Dimension(1240, 758));
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane1.setBorder(null);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USUARIO", "DOCTOR", "CODIGO", "DÍA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tblUsuarios.setFuenteFilas(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tblUsuarios.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tblUsuarios.setFuenteHead(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tblUsuarios.setGrosorBordeFilas(0);
        tblUsuarios.setGrosorBordeHead(0);
        tblUsuarios.setRowHeight(35);
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(38, 126, 717, 405);

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(940, 300, 268, 46);

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(810, 450, 396, 60);

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(810, 540, 396, 60);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CÓDIGO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(780, 300, 143, 46);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DÍA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(780, 370, 143, 46);

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(38, 52, 717, 46);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("USUARIO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(773, 106, 143, 46);

        cbxUsuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        getContentPane().add(cbxUsuario);
        cbxUsuario.setBounds(934, 104, 268, 46);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DOCTOR");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(780, 240, 143, 46);

        cbxDoctor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        getContentPane().add(cbxDoctor);
        cbxDoctor.setBounds(940, 240, 268, 46);

        dtDia.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        dtDia.setFuente(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        getContentPane().add(dtDia);
        dtDia.setBounds(940, 370, 268, 46);
        getContentPane().add(lblID);
        lblID.setBounds(680, 550, 74, 23);

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(810, 630, 396, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (evt.getSource() == btnAgregar) {

            if (verificar.equals("Actualizar")) {
                ctrlCi.actualizarCita(cbxUsuario, cbxDoctor, lblID, txtCodigo, dtDia);
                ctrlCi.mostrarCita(tblUsuarios);
                verificar = "Actualizar";
            } else if (verificar.equals("Agregar")) {
                ctrlCi.registrarCita(cbxUsuario, cbxDoctor, lblID, txtCodigo, dtDia);
                ctrlCi.mostrarCita(tblUsuarios);
                verificar = "Agregar";
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (evt.getSource() == txtBuscar) {
            ctrlCi.buscarCita(tblUsuarios, txtBuscar);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        if (evt.getSource() == tblUsuarios) {
            ctrlCi.pasarCita(tblUsuarios, cbxUsuario, cbxDoctor, lblID, txtCodigo, dtDia);
            verificar = "Actualizar";
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        if (evt.getSource() == btnLimpiar) {
            ctrlCi.limpiarCajas(cbxUsuario, cbxDoctor, lblID, txtCodigo, dtDia);
            verificar = "Agregar";
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (evt.getSource() == btnEliminar) {
            int fila = tblUsuarios.getSelectedRow();
            if (fila > 0) {
                ctrlCi.eliminarCita(lblID, tblUsuarios);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione lo que desea eliminar");
            }
            verificar = "Agregar";
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdCitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdCitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdCitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdCitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdCitaCRUD dialog = new jdCitaCRUD(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbxDoctor;
    private javax.swing.JComboBox<String> cbxUsuario;
    private rojeru_san.rsdate.RSDateChooser dtDia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private rojerusan.RSTableMetro tblUsuarios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
