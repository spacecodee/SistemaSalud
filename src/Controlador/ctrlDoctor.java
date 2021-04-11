package Controlador;

import Modelo.Doctor.M_Doctor;
import SQL.Doctores.SentenciasDoctor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ctrlDoctor {

    SentenciasDoctor sqlDoc = new SentenciasDoctor();
    M_Doctor mDoc = new M_Doctor();

    DefaultTableModel modelo;
    DefaultComboBoxModel modeloCombo;

    public void mostrarEscuela(JTable tbl) {
        modelo = sqlDoc.mostrarDoctores();
        tbl.setModel(modelo);
        ocultarFila(tbl);
    }

    public void agregarDoctor(JLabel lblID, JTextField txtCod, JTextField txtNom, JTextField txtTelefono) {
        if (!txtCod.getText().trim().isEmpty() || !txtNom.getText().trim().isEmpty() || !txtTelefono.getText().trim().isEmpty()) {
            if (txtCod.getText().trim().length() > 4) {
                JOptionPane.showMessageDialog(null, "El código solo tiene 4 digitos");
            } else {
                mDoc.setCodigo(txtCod.getText());
                mDoc.setNombre(txtNom.getText());
                mDoc.setTelefono(txtTelefono.getText());

                if (sqlDoc.agregarDoctor(mDoc)) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    txtCod.setEnabled(true);
                    limpiarCajas(lblID, txtCod, txtNom, txtTelefono);
                } else {
                    JOptionPane.showMessageDialog(null, "Al parecer ocurrio un error al agregar el usuario");
                    txtCod.setEnabled(true);
                    limpiarCajas(lblID, txtCod, txtNom, txtTelefono);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }
    }

    public void actualizarDoctor(JLabel lblID, JTextField txtCod, JTextField txtNom, JTextField txtTelefono) {
        if (!txtCod.getText().trim().isEmpty() || !txtNom.getText().trim().isEmpty() || !txtTelefono.getText().trim().isEmpty()) {
            if (txtCod.getText().trim().length() > 4) {
                JOptionPane.showMessageDialog(null, "El DNI solo tiene 4 digitos");
            } else {
                mDoc.setId(Integer.parseInt(lblID.getText()));
                mDoc.setCodigo(txtCod.getText());
                mDoc.setNombre(txtNom.getText());
                mDoc.setTelefono(txtTelefono.getText());

                if (sqlDoc.actualizarDoctor(mDoc)) {
                    JOptionPane.showMessageDialog(null, "Registro Actualizado");
                    txtCod.setEnabled(true);
                    limpiarCajas(lblID, txtCod, txtNom, txtTelefono);
                } else {
                    JOptionPane.showMessageDialog(null, "Al parecer ocurrio un error al actualizar el usuario");
                    txtCod.setEnabled(true);
                    limpiarCajas(lblID, txtCod, txtNom, txtTelefono);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }
    }

    public void buscarDoctor(JTextField txtBuscar, JTable tbl) {
        if (txtBuscar.getText().trim().isEmpty()) {
            mostrarEscuela(tbl);
        } else {
            modelo = sqlDoc.buscarDoctor(txtBuscar.getText());
            tbl.setModel(modelo);
            ocultarFila(tbl);
        }
    }

    public void pasarDoctor(JTable tbl, JLabel lblID, JTextField txtDNI, JTextField txtNom, JTextField txtTelefono) {
        int fila = tbl.getSelectedRow();

        lblID.setText(tbl.getValueAt(fila, 0).toString());
        lblID.setEnabled(false);
        txtDNI.setText(tbl.getValueAt(fila, 1).toString());
        txtNom.setText(tbl.getValueAt(fila, 2).toString());
        txtTelefono.setText(tbl.getValueAt(fila, 3).toString());
    }

    public void eliminarUsuario(JLabel lblID, JTable tbl) {

        int input = JOptionPane.showConfirmDialog(null,
                "¿Estas seguro que quieres eliminar al Doctor", "Eliminar Doctor",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (input == 0) {
            if (!lblID.getText().trim().isEmpty()) {
                sqlDoc.eliminarDoctor(Integer.parseInt(lblID.getText()));
                mostrarEscuela(tbl);
            }
        }

    }

    public void limpiarCajas(JLabel lblID, JTextField txtDNI, JTextField txtNom, JTextField txtTelefono) {
        lblID.setText(null);
        txtDNI.setText(null);
        txtNom.setText(null);
        txtTelefono.setText(null);
    }

    private void ocultarFila(JTable tbl) {
        tbl.getColumnModel().getColumn(0).setMaxWidth(0);
        tbl.getColumnModel().getColumn(0).setMinWidth(0);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

}
