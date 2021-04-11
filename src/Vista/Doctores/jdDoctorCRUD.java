package Vista.Doctores;

import Controlador.ctrlDoctor;
import javax.swing.JOptionPane;

public class jdDoctorCRUD extends javax.swing.JDialog {

    ctrlDoctor ctrlDoc = new ctrlDoctor();
    String verificar = "Agregar";

    public jdDoctorCRUD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        ctrlDoc.mostrarEscuela(tblUsuarios);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new rojerusan.RSTableMetro();
        txtDNI = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1240, 664));
        setMinimumSize(new java.awt.Dimension(1240, 664));
        setPreferredSize(new java.awt.Dimension(1240, 664));
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane1.setBorder(null);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "NOMBRES", "TELEFONO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane1.setBounds(40, 110, 717, 402);

        txtDNI.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtDNI);
        txtDNI.setBounds(940, 120, 260, 46);

        txtNombres.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNombres);
        txtNombres.setBounds(940, 190, 260, 46);

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtTelefono);
        txtTelefono.setBounds(940, 250, 260, 46);

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(810, 360, 396, 60);

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(810, 450, 396, 60);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DNI");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(780, 120, 143, 46);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOMBRES");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(780, 190, 143, 46);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TELÉFONO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(780, 250, 143, 46);

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
        txtBuscar.setBounds(40, 30, 717, 46);
        getContentPane().add(lblID);
        lblID.setBounds(660, 530, 100, 30);

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(810, 530, 400, 60);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (evt.getSource() == btnAgregar) {
            //int fila = tblUsuarios.getSelectedRow();
            if (verificar.equals("Actualizar")) {
                ctrlDoc.actualizarDoctor(lblID, txtDNI, txtNombres, txtTelefono);
                ctrlDoc.mostrarEscuela(tblUsuarios);
                verificar = "Actualizar";
            } else if (verificar.equals("Agregar")) {
                ctrlDoc.agregarDoctor(lblID, txtDNI, txtNombres, txtTelefono);
                ctrlDoc.mostrarEscuela(tblUsuarios);
                verificar = "Agregar";
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (evt.getSource() == txtBuscar) {
            ctrlDoc.buscarDoctor(txtBuscar, tblUsuarios);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        if (evt.getSource() == tblUsuarios) {
            ctrlDoc.pasarDoctor(tblUsuarios, lblID, txtDNI, txtNombres, txtTelefono);
            verificar = "Actualizar";
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        if (evt.getSource() == btnLimpiar) {
            ctrlDoc.limpiarCajas(lblID, txtDNI, txtNombres, txtTelefono);
            verificar = "Agregar";
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (evt.getSource() == btnEliminar) {
            int fila = tblUsuarios.getSelectedRow();
            if (fila > 0) {
                ctrlDoc.eliminarUsuario(lblID, tblUsuarios);
                ctrlDoc.limpiarCajas(lblID, txtDNI, txtNombres, txtTelefono);
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
            java.util.logging.Logger.getLogger(jdDoctorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdDoctorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdDoctorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdDoctorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdDoctorCRUD dialog = new jdDoctorCRUD(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private rojerusan.RSTableMetro tblUsuarios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
