package SQL.Cita;

import Modelo.Cita.M_Citas;
import Modelo.Doctor.M_DoctorCombo;
import Modelo.Usuario.M_UsuarioCombo;
import SQL.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SentenciasCita extends Conexion {

    private Connection Con = null;
    private CallableStatement callSt = null;
    private ResultSet Res = null;
    M_UsuarioCombo mUsuCom = new M_UsuarioCombo();
    M_DoctorCombo mDocCom = new M_DoctorCombo();
    String SQL;

    public Vector<M_UsuarioCombo> mostrarUsuarioCombo() {
        Con = getConexion();
        callSt = null;
        Res = null;

        Vector<M_UsuarioCombo> mUsuarioC = new Vector<>();
        M_UsuarioCombo objFacu;

        try {
            String SQL = "CALL spMostrarComboUsuarios()";
            callSt = Con.prepareCall(SQL);
            Res = callSt.executeQuery();

            mUsuCom = new M_UsuarioCombo();
            mUsuCom.setIdUsuario(0);
            mUsuCom.setNombre("Selecciona");
            mUsuarioC.add(mUsuCom);

            while (Res.next()) {
                mUsuCom = new M_UsuarioCombo();
                mUsuCom.setIdUsuario(Res.getInt(1));
                mUsuCom.setNombre(Res.getString(2));
                mUsuarioC.add(mUsuCom);
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.toString());
        } finally {
            try {
                Con.close();
            } catch (SQLException e) {
                System.err.println("Error: " + e.toString());
            }
        }

        return mUsuarioC;
    }

    public Vector<M_DoctorCombo> mostrarDoctorCombo() {
        Con = getConexion();
        callSt = null;
        Res = null;

        Vector<M_DoctorCombo> mDocC = new Vector<>();
        M_DoctorCombo mDocCom;

        try {
            String SQL = "CALL spMostarComboDoctor()";
            callSt = Con.prepareCall(SQL);
            Res = callSt.executeQuery();

            mDocCom = new M_DoctorCombo();
            mDocCom.setidDoctor(0);
            mDocCom.setNombre("Selecciona");
            mDocC.add(mDocCom);

            while (Res.next()) {
                mDocCom = new M_DoctorCombo();
                mDocCom.setidDoctor(Res.getInt(1));
                mDocCom.setNombre(Res.getString(2));
                mDocC.add(mDocCom);
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.toString());
        } finally {
            try {
                Con.close();
            } catch (SQLException e) {
                System.err.println("Error: " + e.toString());
            }
        }

        return mDocC;
    }

    //Crud
    public DefaultTableModel mostrarCita() {

        Con = getConexion();
        callSt = null;
        Res = null;

        String[] nombresColumnas = {
            "ID", "USUARIO", "DOCTOR", "CÓDIGO", "DÍA"
        };
        String[] registros = new String[5];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        //
        try {

            SQL = "CALL spMostrarCita()";
            callSt = Con.prepareCall(SQL);
            Res = callSt.executeQuery();

            while (Res.next()) {
                registros[0] = Res.getString(1);
                registros[1] = Res.getString(2);
                registros[2] = Res.getString(3);
                registros[3] = Res.getString(4);
                registros[4] = Res.getString(5);
                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.toString());
        } finally {
            try {
                Con.close();
            } catch (SQLException e) {
                System.err.println("Error: " + e.toString());
            }
        }

        return modelo;
    }

    public DefaultTableModel buscarCita(String codigo) {

        Con = getConexion();
        callSt = null;
        Res = null;

        String[] nombresColumnas = {
            "ID", "USUARIO", "DOCTOR", "CÓDIGO", "DÍA"
        };
        String[] registros = new String[5];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        //
        try {

            SQL = "CALL spBuscarCita(?)";
            callSt = Con.prepareCall(SQL);
            callSt.setString(1, codigo);
            Res = callSt.executeQuery();

            while (Res.next()) {
                registros[0] = Res.getString(1);
                registros[1] = Res.getString(2);
                registros[2] = Res.getString(3);
                registros[3] = Res.getString(4);
                registros[4] = Res.getString(5);
                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.toString());
        } finally {
            try {
                Con.close();
            } catch (SQLException e) {
                System.err.println("Error: " + e.toString());
            }
        }

        return modelo;
    }

    public boolean agregarCita(M_Citas mCit) {
        Con = getConexion();
        callSt = null;
        Res = null;

        try {
            SQL = "CALL spAgregarCita(?, ?, ?, ?)";
            callSt = Con.prepareCall(SQL);
            callSt.setInt(1, mCit.getIdUsu());
            callSt.setInt(2, mCit.getIdDoc());
            callSt.setString(3, mCit.getCodigo());
            callSt.setString(4, mCit.getFecha());
            callSt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error bro :( " + e.toString());
            return false;
        } finally {
            try {
                Con.close();
            } catch (SQLException e) {
                System.err.println("Error bro :( " + e.toString());
            }
        }
    }

    public boolean actualizarCita(M_Citas mCit) {
        Con = getConexion();
        callSt = null;
        Res = null;

        try {
            SQL = "CALL spActualizarCita(?, ?, ?, ?, ?)";
            callSt = Con.prepareCall(SQL);

            callSt.setInt(1, mCit.getIdUsu());
            callSt.setInt(2, mCit.getIdDoc());
            callSt.setString(3, mCit.getCodigo());
            callSt.setString(4, mCit.getFecha());
            callSt.setInt(5, mCit.getId());
            callSt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error bro :( " + e.toString());
            return false;
        } finally {
            try {
                Con.close();
            } catch (SQLException e) {
                System.err.println("Error bro :( " + e.toString());
            }
        }
    }

    public boolean eliminarCita(int id) {
        Con = getConexion();
        callSt = null;
        Res = null;

        try {
            SQL = "CALL spELiminarCita(?)";
            callSt = Con.prepareCall(SQL);
            callSt.setInt(1, id);
            callSt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error bro :( " + e.toString());
            return false;
        } finally {
            try {
                Con.close();
            } catch (SQLException e) {
                System.err.println("Error bro :( " + e.toString());
            }
        }
    }
}
