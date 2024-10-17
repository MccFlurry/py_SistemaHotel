package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.*;

public class clsEmpleado {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    // Method to list all employees
    public ResultSet listarEmpleados() throws Exception {
        strSQL = "SELECT * FROM empleado";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar empleados: " + e.getMessage());
        }
    }

    // Method to obtain the full name of the employee by their DNI
    public String obtenerNombreEmpleado(String dniEmpleado) throws Exception {
        String strSQL = "SELECT nombres, ape_paterno, ape_materno FROM empleado WHERE dni_empleado = '" + dniEmpleado + "'";
        try {
            ResultSet rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                // Combine names and surnames to return the full name
                return rs.getString("nombres") + " " + rs.getString("ape_paterno") + " " + rs.getString("ape_materno");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener nombre del empleado: " + e.getMessage());
        }
        return null;  // Return null if no employee is found
    }

    // Other methods (register, delete, modify employees, etc.)
    public void registrarEmpleado(String dni, String apePaterno, String apeMaterno, String nombres, String sexo, String movil, java.util.Date fAlta, java.util.Date fBaja) throws Exception {
        java.sql.Date sqlFAlta = new java.sql.Date(fAlta.getTime());
        java.sql.Date sqlFBaja = (fBaja != null) ? new java.sql.Date(fBaja.getTime()) : null;

        String strSQL = "INSERT INTO empleado (dni_empleado, ape_paterno, ape_materno, nombres, sexo, movil, f_alta, f_baja) "
                + "VALUES ('" + dni + "', '" + apePaterno + "', '" + apeMaterno + "', '" + nombres + "', '" + sexo + "', '" + movil + "', '" + sqlFAlta + "', "
                + (sqlFBaja != null ? "'" + sqlFBaja + "'" : "NULL") + ")";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar empleado --> " + e.getMessage());
        }
    }

    // Method to search for an employee by DNI
    public ResultSet buscarEmpleado(String dni) throws Exception {
        strSQL = "SELECT * FROM empleado WHERE dni_empleado = '" + dni + "'";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar empleado --> " + e.getMessage());
        }
    }

    // Method to delete an employee
    public void eliminarEmpleado(String dni) throws Exception {
        strSQL = "DELETE FROM empleado WHERE dni_empleado = '" + dni + "'";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar empleado --> " + e.getMessage());
        }
    }

    // Method to modify an employee
    public void modificarEmpleado(String dni, String apePaterno, String apeMaterno, String nombres, String sexo, String movil, java.util.Date fAlta, java.util.Date fBaja) throws Exception {
        java.sql.Date sqlFAlta = new java.sql.Date(fAlta.getTime());
        java.sql.Date sqlFBaja = (fBaja != null) ? new java.sql.Date(fBaja.getTime()) : null;
        strSQL = "UPDATE empleado SET ape_paterno = '" + apePaterno + "', ape_materno = '" + apeMaterno + "', nombres = '" + nombres + "', "
                + "sexo = '" + sexo + "', movil = '" + movil + "', f_alta = '" + sqlFAlta + "', f_baja = " + (sqlFBaja != null ? "'" + sqlFBaja + "'" : "NULL")
                + " WHERE dni_empleado = '" + dni + "'";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar empleado --> " + e.getMessage());
        }
    }

}
