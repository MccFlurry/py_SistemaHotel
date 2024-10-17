package CapaNegocio;

import capaDatos.clsJDBC;
import java.sql.ResultSet;

public class clsCatHabitacion {
       clsJDBC objConectar = new clsJDBC();
       String strSQL;
       ResultSet rs = null;
       
    public ResultSet listarCateHabitaciones() throws Exception {
        strSQL = "select * from cate_habitacion order by 1" ;       
        try
        {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        }
        catch (Exception ex) {
            throw new Exception(ex.getMessage()+ ": Error al consultar categorias de habitacion");
        }
    }
    
    public void registrarCateHabitacion(int categoriaId, String nombreCategoria, double precioCategoria) throws Exception {
        strSQL = "INSERT INTO cate_habitacion (categoria_id, nombre_categoria, precio_categoria) " +
                 "VALUES (" + categoriaId + ", '" + nombreCategoria + "', " + precioCategoria + ")";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar categoría de habitación --> " + e.getMessage());
        }
    }

    public ResultSet buscarCateHabitacion(int categoriaId) throws Exception {
        strSQL = "SELECT * FROM cate_habitacion WHERE categoria_id = " + categoriaId;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar categoría de habitación --> " + e.getMessage());
        }
    }
    
    public void eliminarCateHabitacion(int categoriaId) throws Exception {
        strSQL = "DELETE FROM cate_habitacion WHERE categoria_id = " + categoriaId;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar categoría de habitación --> " + e.getMessage());
        }
    }
    
    public void modificarCateHabitacion(int categoriaId, String nombreCategoria, double precioCategoria) throws Exception {
        strSQL = "UPDATE cate_habitacion SET nombre_categoria = '" + nombreCategoria + "', precio_categoria = " + precioCategoria + " " +
                 "WHERE categoria_id = " + categoriaId;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar categoría de habitación --> " + e.getMessage());
        }
    }

    
    public Integer generarCodigoCateHabitacion() throws Exception {
        strSQL = "SELECT COALESCE(max(categoria_id),0)+1 as codigo from cate_habitacion";
        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception ex) {
            throw new Exception("Error al generar código de categoría de habitación --> " + ex.getMessage());
        }
        return 0;
    }




}
    

