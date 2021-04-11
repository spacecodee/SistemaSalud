package Controlador;

import Modelo.Cita.M_Citas;
import Modelo.Doctor.M_DoctorCombo;
import Modelo.Usuario.M_UsuarioCombo;
import SQL.Cita.SentenciasCita;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import rojeru_san.rsdate.RSDateChooser;

public class CtrlCitas {

    DefaultTableModel modelo;
    DefaultComboBoxModel modeloCombo;
    M_UsuarioCombo mUsuCom = new M_UsuarioCombo();
    M_DoctorCombo mDocCom = new M_DoctorCombo();
    M_Citas mCit = new M_Citas();
    SentenciasCita sqlCi = new SentenciasCita();
    Date date = null;
    java.sql.Date sqlFecha = null;
    long d = 0;
    String x, y, g = null, k = null;
    Vector vec1 = new Vector();
    Vector vec2 = new Vector();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yy-MM-dd");

    public void datosUsuario(JComboBox cbx) {
        modeloCombo = new DefaultComboBoxModel(sqlCi.mostrarUsuarioCombo());
        cbx.setModel(modeloCombo);
        mUsuCom = (M_UsuarioCombo) cbx.getSelectedItem();
    }

    public void datosDoctor(JComboBox cbx) {
        modeloCombo = new DefaultComboBoxModel(sqlCi.mostrarDoctorCombo());
        cbx.setModel(modeloCombo);
        mDocCom = (M_DoctorCombo) cbx.getSelectedItem();
    }

    public void mostrarCita(JTable tbl) {
        modelo = sqlCi.mostrarCita();
        tbl.setModel(modelo);
        ocultarFila(tbl);
    }

    public void buscarCita(JTable tbl, JTextField txtCodigo) {

        if (txtCodigo.getText().trim().isEmpty()) {
            mostrarCita(tbl);
        } else {
            modelo = sqlCi.buscarCita(txtCodigo.getText());
            tbl.setModel(modelo);
            ocultarFila(tbl);
        }
    }

    public void registrarCita(JComboBox cbxUsu, JComboBox cbxDoc, JLabel lblID, JTextField txtCod, RSDateChooser rsDt) {
        mUsuCom = (M_UsuarioCombo) cbxUsu.getSelectedItem();
        mDocCom = (M_DoctorCombo) cbxDoc.getSelectedItem();

        mCit.setIdUsu(mUsuCom.getIdUsuario());
        mCit.setIdDoc(mDocCom.getidDoctor());
        mCit.setCodigo(txtCod.getText());
        date = rsDt.getDatoFecha();
        d = date.getTime();
        sqlFecha = new java.sql.Date(d);
        mCit.setFecha(sqlFecha.toString());

        if (cbxUsu.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona el usuario");
        } else if (cbxDoc.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona el doctor");
        } else {
            if (sqlCi.agregarCita(mCit)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiarCajas(cbxUsu, cbxDoc, lblID, txtCod, rsDt);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiarCajas(cbxUsu, cbxDoc, lblID, txtCod, rsDt);
            }
        }

    }

    public void actualizarCita(JComboBox cbxUsu, JComboBox cbxDoc, JLabel lblID, JTextField txtCod, RSDateChooser rsDt) {
        mUsuCom = (M_UsuarioCombo) cbxUsu.getSelectedItem();
        mDocCom = (M_DoctorCombo) cbxDoc.getSelectedItem();

        mCit.setId(Integer.parseInt(lblID.getText()));
        mCit.setIdUsu(mUsuCom.getIdUsuario());
        mCit.setIdDoc(mDocCom.getidDoctor());
        mCit.setCodigo(txtCod.getText());
        date = rsDt.getDatoFecha();
        d = date.getTime();
        sqlFecha = new java.sql.Date(d);
        mCit.setFecha(sqlFecha.toString());

        if (cbxUsu.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona el usuario");
        } else if (cbxDoc.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona el doctor");
        } else if (txtCod.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellena el código");
        } else {
            if (sqlCi.actualizarCita(mCit)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                limpiarCajas(cbxUsu, cbxDoc, lblID, txtCod, rsDt);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
                limpiarCajas(cbxUsu, cbxDoc, lblID, txtCod, rsDt);
            }
        }

    }

    public void eliminarCita(JLabel lblID, JTable tbl) {

        int input = JOptionPane.showConfirmDialog(null,
                "¿Estas seguro que quieres eliminar al usuario", "Eliminar Usuario",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (input == 0) {
            if (!lblID.getText().trim().isEmpty()) {
                sqlCi.eliminarCita(Integer.parseInt(lblID.getText()));
                mostrarCita(tbl);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione lo que desea eliminar");
            }
        }

    }

    public void pasarCita(JTable tbl, JComboBox cbxUsua, JComboBox cbxDoc, JLabel lblID, JTextField Codigo,
            RSDateChooser dt) {

        try {
            int fila = tbl.getSelectedRow();

            lblID.setText(tbl.getValueAt(fila, 0).toString());

            // Usuario
            x = tbl.getValueAt(tbl.getSelectedRow(), 1).toString();

            for (int i = 0; i < cbxUsua.getItemCount(); i++) {
                vec1.add(cbxUsua.getItemAt(i));
            }
            for (int i = 0; i < cbxUsua.getItemCount(); i++) {
                g = vec1.get(i).toString();
                if (x.equalsIgnoreCase(g)) {
                    cbxUsua.setSelectedIndex(i);
                }
            }
            //

            // Doctor
            y = tbl.getValueAt(tbl.getSelectedRow(), 2).toString();
            for (int j = 0; j < cbxDoc.getItemCount(); j++) {
                vec2.add(cbxDoc.getItemAt(j));
            }
            for (int j = 0; j < cbxDoc.getItemCount(); j++) {
                k = vec2.get(j).toString();
                if (y.equalsIgnoreCase(k)) {
                    cbxDoc.setSelectedIndex(j);
                }
            }
            //

            Codigo.setText(tbl.getValueAt(fila, 3).toString());
            date = formatoFecha.parse(tbl.getValueAt(fila, 4).toString());
            dt.setDatoFecha(date);
        } catch (ParseException ex) {
            Logger.getLogger(CtrlCitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limpiarCajas(JComboBox cbxUsu, JComboBox cbxDoc, JLabel lblID, JTextField txtCodigo, RSDateChooser dt) {
        cbxUsu.setSelectedIndex(0);
        cbxDoc.setSelectedIndex(0);
        lblID.setText(null);
        txtCodigo.setText(null);
        dt.setDatoFecha(new Date());
    }

    private void ocultarFila(JTable tbl) {
        tbl.getColumnModel().getColumn(0).setMaxWidth(0);
        tbl.getColumnModel().getColumn(0).setMinWidth(0);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

}
