
package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.*;


public class clsReclamo {
    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;
    
    public ResultSet listarReclamos() throws Exception {
        strSQL = "SELECT * FROM reclamo";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar reclamos: " + e.getMessage());
        }
    }
    
    public void registrarReclamo(int idReclamo, String motivo, String descripcion, int clienteId, String dniEmpleado) throws Exception {
        strSQL = "INSERT INTO reclamo (idreclamo, motivo, descripcion, cliente_id, dni_empleado, estado) " +
                 "VALUES (" + idReclamo + ", '" + motivo + "', '" + descripcion + "', " + clienteId + ", '" + dniEmpleado + "', 'En espera')";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar reclamo --> " + e.getMessage());
        }
    }
    
    public ResultSet buscarReclamo(int idReclamo) throws Exception {
        strSQL = "SELECT * FROM reclamo WHERE idreclamo = " + idReclamo;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar reclamo --> " + e.getMessage());
        }
    }
    
    public void eliminarReclamo(int idReclamo) throws Exception {
        strSQL = "DELETE FROM reclamo WHERE idreclamo = " + idReclamo;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar reclamo --> " + e.getMessage());
        }
    }
    
    public void modificarReclamo(int idReclamo, String motivo, String descripcion, int clienteId, String dniEmpleado, String estado) throws Exception {
        strSQL = "UPDATE reclamo SET motivo = '" + motivo + "', descripcion = '" + descripcion + "', " +
                 "cliente_id = " + clienteId + ", dni_empleado = '" + dniEmpleado + "', estado = '" + estado + "' " +
                 "WHERE idreclamo = " + idReclamo;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar reclamo: " + e.getMessage());
        }
    }

    
    public Integer generarCodigoReclamo() throws Exception {
        strSQL = "SELECT COALESCE(max(idreclamo),0)+1 as codigo from reclamo";
        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception ex) {
            throw new Exception("Error al generar código de reclamo --> " + ex.getMessage());
        }
        return 0;
    }
    







}
