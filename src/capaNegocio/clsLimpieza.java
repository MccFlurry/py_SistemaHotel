package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.*;

public class clsLimpieza {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    public ResultSet listarLimpiezas() throws Exception {
        strSQL = "SELECT * FROM limpieza";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar limpiezas: " + e.getMessage());
        }
    }

    public void registrarLimpieza(int habitacionId, String dniEmpleado, java.sql.Date fechaLimpieza, Time horaLimpieza, String observacion) throws Exception {
        strSQL = "INSERT INTO limpieza (habitacion_id, dni_empleado, fecha_limpieza, hora_limpieza, observacion) "
                + "VALUES (" + habitacionId + ", '" + dniEmpleado + "', '" + fechaLimpieza + "', '" + horaLimpieza + "', '" + observacion + "')";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar limpieza --> " + e.getMessage());
        }
    }

    public Integer generarCodigoLimpieza() throws Exception {
        String strSQL = "SELECT COALESCE(MAX(limpieza_id), 0) + 1 AS nuevo_codigo FROM limpieza";
        ResultSet rs = null;
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("nuevo_codigo");
            } else {
                return 1;  // Si no hay registros, empezar con el ID 1
            }
        } catch (Exception e) {
            throw new Exception("Error al generar el código de limpieza: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }

    public ResultSet buscarLimpieza(int limpiezaId) throws Exception {
        strSQL = "SELECT * FROM limpieza WHERE limpieza_id = " + limpiezaId;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar limpieza --> " + e.getMessage());
        }
    }

    public void eliminarLimpieza(int limpiezaId) throws Exception {
        strSQL = "DELETE FROM limpieza WHERE limpieza_id = " + limpiezaId;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar limpieza --> " + e.getMessage());
        }
    }

    public void modificarLimpieza(int limpiezaId, int habitacionId, String dniEmpleado, java.sql.Date fechaLimpieza, Time horaLimpieza, String observacion) throws Exception {
        strSQL = "UPDATE limpieza SET habitacion_id = " + habitacionId + ", dni_empleado = '" + dniEmpleado + "', "
                + "fecha_limpieza = '" + fechaLimpieza + "', hora_limpieza = '" + horaLimpieza + "', observacion = '" + observacion + "' "
                + "WHERE limpieza_id = " + limpiezaId;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar limpieza --> " + e.getMessage());
        }
    }

}
