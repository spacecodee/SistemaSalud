package Controlador;

import Modelo.Usuario.M_Usuario;
import SQL.Usuarios.SentenciasUsuario;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ctrlUsuario {

    SentenciasUsuario sqlUsu = new SentenciasUsuario();
    M_Usuario mUsu = new M_Usuario();

    DefaultTableModel modelo;
    DefaultComboBoxModel modeloCombo;

    public void mostrarEscuela(JTable tbl) {
        modelo = sqlUsu.mostrarUsuarios();
        tbl.setModel(modelo);
        ocultarFila(tbl);
    }

    public void agregUsuario(JLabel lblID, JTextField txtDNI, JTextField txtNom, JTextField txtTelefono) {
        if (!txtDNI.getText().trim().isEmpty() || !txtNom.getText().trim().isEmpty() || !txtTelefono.getText().trim().isEmpty()) {
            if (txtDNI.getText().trim().length() > 8) {
                JOptionPane.showMessageDialog(null, "El DNI solo tiene 8 digitos");
            } else {
                mUsu.setDni(txtDNI.getText());
                mUsu.setNombre(txtNom.getText());
                mUsu.setTelefono(txtTelefono.getText());

                if (sqlUsu.agregarUsuario(mUsu)) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    limpiarCajas(lblID, txtDNI, txtNom, txtTelefono);
                } else {
                    JOptionPane.showMessageDialog(null, "Al parecer ocurrio un error al agregar el usuario");
                    limpiarCajas(lblID, txtDNI, txtNom, txtTelefono);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }
    }

    public void actualizarUsuario(JLabel lblID, JTextField txtDNI, JTextField txtNom, JTextField txtTelefono) {
        if (!txtDNI.getText().trim().isEmpty() || !txtNom.getText().trim().isEmpty() || !txtTelefono.getText().trim().isEmpty()) {
            if (txtDNI.getText().trim().length() > 8) {
                JOptionPane.showMessageDialog(null, "El DNI solo tiene 8 digitos");
            } else {
                mUsu.setId(Integer.parseInt(lblID.getText()));
                mUsu.setDni(txtDNI.getText());
                mUsu.setNombre(txtNom.getText());
                mUsu.setTelefono(txtTelefono.getText());

                if (sqlUsu.actualizarUsuario(mUsu)) {
                    JOptionPane.showMessageDialog(null, "Registro Actualizado");
                    txtDNI.setEnabled(true);
                    limpiarCajas(lblID, txtDNI, txtNom, txtTelefono);
                } else {
                    JOptionPane.showMessageDialog(null, "Al parecer ocurrio un error al actualizar el usuario");
                    txtDNI.setEnabled(true);
                    limpiarCajas(lblID, txtDNI, txtNom, txtTelefono);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }
    }

    public void eliminarUsuario(JLabel lblID, JTable tbl) {

        int input = JOptionPane.showConfirmDialog(null,
                "¿Estas seguro que quieres eliminar al usuario", "Eliminar Usuario",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (input == 0) {
            if (!lblID.getText().trim().isEmpty()) {
                sqlUsu.eliminarUsuario(Integer.parseInt(lblID.getText()));
                mostrarEscuela(tbl);
            }
        }

    }

    public void buscarUsuario(JTextField txtBuscar, JTable tbl) {
        if (txtBuscar.getText().trim().isEmpty()) {
            mostrarEscuela(tbl);
        } else {
            modelo = sqlUsu.buscarUsuario(txtBuscar.getText());
            tbl.setModel(modelo);
            ocultarFila(tbl);
        }
    }

    public void pasarUsuario(JTable tbl, JLabel lblID, JTextField txtDNI, JTextField txtNom, JTextField txtTelefono) {
        int fila = tbl.getSelectedRow();

        lblID.setText(tbl.getValueAt(fila, 0).toString());
        lblID.setVisible(false);
        txtDNI.setText(tbl.getValueAt(fila, 1).toString());
        //txtDNI.setEnabled(false);
        txtNom.setText(tbl.getValueAt(fila, 2).toString());
        txtTelefono.setText(tbl.getValueAt(fila, 3).toString());
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
