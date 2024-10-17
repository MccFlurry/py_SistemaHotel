
package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.*;

/**
 *
 * @author idavi
 */
public class clsServicio {
    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;
    
    public ResultSet listarServicios() throws Exception {
        strSQL = "SELECT * FROM servicio";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar servicios: " + e.getMessage());
        }
    }
    
    public void registrarServicio(int servicioId, String descripcion) throws Exception {
        strSQL = "INSERT INTO servicio (servicio_id, descripcion) " +
                 "VALUES (" + servicioId + ", '" + descripcion + "')";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar servicio --> " + e.getMessage());
        }
    }
    
    public ResultSet buscarServicio(int servicioId) throws Exception {
        strSQL = "SELECT * FROM servicio WHERE servicio_id = " + servicioId;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar servicio --> " + e.getMessage());
        }
    }
    
    public void eliminarServicio(int servicioId) throws Exception {
        strSQL = "DELETE FROM servicio WHERE servicio_id = " + servicioId;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar servicio --> " + e.getMessage());
        }
    }

    public void modificarServicio(int servicioId, String descripcion) throws Exception {
        strSQL = "UPDATE servicio SET descripcion = '" + descripcion + "' WHERE servicio_id = " + servicioId;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar servicio --> " + e.getMessage());
        }
    }
    
    public Integer generarCodigoServicio() throws Exception {
        strSQL =  "SELECT COALESCE(max(servicio_id),0)+1 as codigo from servicio";
        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception ex) {
            throw new Exception("Error al generar codigo de servicio --> " + ex.getMessage()); 
        }
        return 0;
    }





}
