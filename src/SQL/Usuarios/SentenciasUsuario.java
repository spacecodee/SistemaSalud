package SQL.Usuarios;

import Modelo.Usuario.M_Usuario;
import Modelo.Usuario.M_UsuarioCombo;
import SQL.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class SentenciasUsuario extends Conexion {

    private Connection Con = null;
    private CallableStatement callSt = null;
    private ResultSet Res = null;
    M_UsuarioCombo mUsuCom = new M_UsuarioCombo();
    String SQL;

    //Crud
    public DefaultTableModel mostrarUsuarios() {

        Con = getConexion();
        callSt = null;
        Res = null;

        String[] nombresColumnas = {
            "ID", "DNI", "Nombre", "Teléfono"
        };
        String[] registros = new String[4];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        //
        try {

            SQL = "CALL spMostrarUsuario()";
            callSt = Con.prepareCall(SQL);
            Res = callSt.executeQuery();

            while (Res.next()) {
                registros[0] = Res.getString(1);
                registros[1] = Res.getString(2);
                registros[2] = Res.getString(3);
                registros[3] = Res.getString(4);
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

    public boolean agregarUsuario(M_Usuario mUsu) {
        Con = getConexion();
        callSt = null;
        Res = null;

        try {
            SQL = "CALL spAgregarUsuario(?, ?, ?)";
            callSt = Con.prepareCall(SQL);
            callSt.setString(1, mUsu.getDni());
            callSt.setString(2, mUsu.getNombre());
            callSt.setString(3, mUsu.getTelefono());
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

    public DefaultTableModel buscarUsuario(String dni) {
        Con = getConexion();
        callSt = null;
        Res = null;

        String[] nombresColumnas = {
            "ID", "DNI", "Nombre", "Teléfono"
        };
        String[] registros = new String[4];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        //
        try {

            SQL = "CALL spBuscarUsuario(?)";
            callSt = Con.prepareCall(SQL);
            callSt.setString(1, dni);
            Res = callSt.executeQuery();

            while (Res.next()) {
                registros[0] = Res.getString(1);
                registros[1] = Res.getString(2);
                registros[2] = Res.getString(3);
                registros[3] = Res.getString(4);
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

    public boolean actualizarUsuario(M_Usuario mUsu) {
        Con = getConexion();
        callSt = null;
        Res = null;

        try {
            SQL = "CALL spActualizarUsuario(?, ?, ?, ?)";
            callSt = Con.prepareCall(SQL);

            callSt.setString(1, mUsu.getDni());
            callSt.setString(2, mUsu.getNombre());
            callSt.setString(3, mUsu.getTelefono());
            callSt.setInt(4, mUsu.getId());
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

    public boolean eliminarUsuario(int id) {
        Con = getConexion();
        callSt = null;
        Res = null;

        try {
            SQL = "CALL spEliminarUsuario(?)";
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
