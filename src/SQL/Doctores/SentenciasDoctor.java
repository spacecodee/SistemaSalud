package SQL.Doctores;

import Modelo.Doctor.M_Doctor;
import SQL.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class SentenciasDoctor extends Conexion {

    private Connection Con = null;
    private CallableStatement callSt = null;
    private ResultSet Res = null;
    String SQL;

    public DefaultTableModel mostrarDoctores() {

        Con = getConexion();
        callSt = null;
        Res = null;

        String[] nombresColumnas = {
            "ID", "Código", "Nombre", "Teléfono"
        };
        String[] registros = new String[4];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        //
        try {

            SQL = "CALL spMostrarDoctor()";
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

    public boolean agregarDoctor(M_Doctor mDoc) {
        Con = getConexion();
        callSt = null;
        Res = null;

        try {
            SQL = "CALL spGuardarDoctor(?, ?, ?)";
            callSt = Con.prepareCall(SQL);
            callSt.setString(1, mDoc.getCodigo());
            callSt.setString(2, mDoc.getNombre());
            callSt.setString(3, mDoc.getTelefono());
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

    public DefaultTableModel buscarDoctor(String dni) {
        Con = getConexion();
        callSt = null;
        Res = null;

        String[] nombresColumnas = {
            "ID", "Código", "Nombre", "Teléfono"
        };
        String[] registros = new String[4];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        //
        try {

            SQL = "CALL spBuscarDoctor(?)";
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

    public boolean actualizarDoctor(M_Doctor mDoc) {
        Con = getConexion();
        callSt = null;
        Res = null;

        try {
            SQL = "CALL spActualizarDoctor(?, ?, ?, ?)";
            callSt = Con.prepareCall(SQL);
            callSt.setString(1, mDoc.getCodigo());
            callSt.setString(2, mDoc.getNombre());
            callSt.setString(3, mDoc.getTelefono());
            callSt.setInt(4, mDoc.getId());
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
    
    public boolean eliminarDoctor(int id) {
        Con = getConexion();
        callSt = null;
        Res = null;

        try {
            SQL = "CALL spEliminarDoctor(?)";
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
