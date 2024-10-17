package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.*;

public class clsHabitacion {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    public ResultSet listarHabitaciones() throws Exception {
        strSQL = "SELECT * FROM habitacion";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar habitaciones: " + e.getMessage());
        }
    }

    public void registrarHabitacion(int habitacionId, String estadoHab, int numCamas, int categoriaId) throws Exception {
        strSQL = "INSERT INTO habitacion (habitacion_id, estado_hab, num_camas, categoria_id) "
                + "VALUES (" + habitacionId + ", '" + estadoHab + "', " + numCamas + ", " + categoriaId + ")";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar habitación --> " + e.getMessage());
        }
    }

    public ResultSet buscarHabitacion(int habitacionId) throws Exception {
        strSQL = "SELECT h.*, c.nombre_categoria FROM habitacion h "
                + "INNER JOIN cate_habitacion c ON h.categoria_id = c.categoria_id "
                + "WHERE h.habitacion_id = " + habitacionId;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar habitación --> " + e.getMessage());
        }
    }

    public void eliminarHabitacion(int habitacionId) throws Exception {
        strSQL = "DELETE FROM habitacion WHERE habitacion_id = " + habitacionId;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar habitación --> " + e.getMessage());
        }
    }

    public void modificarHabitacion(int habitacionId, String estadoHab, int numCamas, int categoriaId) throws Exception {
        strSQL = "UPDATE habitacion SET estado_hab = '" + estadoHab + "', num_camas = " + numCamas + ", "
                + "categoria_id = " + categoriaId + " WHERE habitacion_id = " + habitacionId;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar habitación --> " + e.getMessage());
        }
    }

    public Integer generarCodigoHabitacion() throws Exception {
        strSQL = "SELECT COALESCE(max(habitacion_id),0)+1 as codigo from habitacion";
        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception ex) {
            throw new Exception("Error al generar codigo de habitacion" + ex.getMessage());
        }
        return 0;
    }
}
