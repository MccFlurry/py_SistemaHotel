package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.*;

public class clsCliente {

    clsJDBC objConector = new clsJDBC();
    String str = "";
    ResultSet rs = null;

    //Primer método: Listar todos los clientes
    public ResultSet listarClientes() throws Exception {
        str = "select * from cliente inner join pais ON pais.codigo_pais = cliente.codigo_pais ";
        try {
            rs = objConector.consultarBD(str);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar los clientes" + e.getMessage());
        }
    }

    public ResultSet buscarporID(Integer id) throws Exception {
        str = "select * from cliente inner join pais on pais.codigo_pais=cliente.codigo_pais where cliente_id=" + id;
        try {
            rs = objConector.consultarBD(str);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al encontrar el cliente" + e.getMessage());
        }
    }

    public int generarId() throws Exception {
        str = "select coalesce(max(cliente_id),0)+1 as id from cliente";
        try {
            rs = objConector.consultarBD(str);
            while (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            throw new Exception("Error al crear id del cliente " + e.getMessage());
        }
        return 0;
    }

    public void registrarCliente(Integer id, String docu, String numDocu, String direccion, String tel, int codPais, String f_reg) throws Exception {
        str = "insert into cliente values (" + id + ", '" + docu + "', '" + numDocu + "' , '" + direccion + "', '" + tel + "', " + codPais + ", '" + f_reg + "')";
        try {
            objConector.ejecutarBD(str);
        } catch (Exception e) {
            throw new Exception("Error al registrar nuevo cliente" + e.getMessage());
        }
    }

    public void modificarCliente(Integer id, String docu, String numDocu, String direccion, String tel, int codPais, String f_reg) throws Exception {
        str = "update cliente set tipo_doc='" + docu + "', numero_documento='" + numDocu + "' , direccion='" + direccion + "', telefono='" + tel + "', codigo_pais=" + codPais + ", fecha_reg='" + f_reg + "' where cliente_id=" + id;
        try {
            objConector.ejecutarBD(str);
        } catch (Exception e) {
            throw new Exception("Error al modificar datos del cliente" + e.getMessage());
        }
    }

    public void eliminarCliente(Integer id) throws Exception {
        str = "delete from cliente where cliente_id=" + id;
        try {
            objConector.ejecutarBD(str);
        } catch (Exception e) {
            throw new Exception("Error al eliminar cliente " + e.getMessage());
        }
    }

    public Integer obtenerCodPais(String nom) throws Exception {
        str = "select codigo_pais from pais where nombre='" + nom + "'";
        try {
            rs = objConector.consultarBD(str);
            if (rs.next()) {
                return rs.getInt("codigo_pais");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el código del pais. " + e.getMessage());
        }
        return 0;
    }

    public Integer obtenerCodigoCliente(String numeroDocumento) throws Exception {
        str = "SELECT cliente_id FROM cliente WHERE numero_documento = '" + numeroDocumento + "'";
        try {
            rs = objConector.consultarBD(str);
            if (rs.next()) {
                return rs.getInt("cliente_id");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar cliente: " + e.getMessage());
        }
        return 0;
    }

    public String obtenerDniCliente(int clienteId) throws Exception {
        String strSQL = "SELECT numero_documento FROM cliente WHERE cliente_id = " + clienteId;
        ResultSet rs = null;
        try {
            rs = objConector.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getString("numero_documento");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener DNI del cliente: " + e.getMessage());
        }
        return null;
    }

    public String obtenerNombreCliente(String dni) throws Exception {
        String strSQL = "SELECT p.nombre, p.ape_paterno, p.ape_materno "
                + "FROM persona p "
                + "JOIN cliente c ON p.cliente_id = c.cliente_id "
                + "WHERE c.numero_documento = '" + dni + "'";
        try {
            ResultSet rs = objConector.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getString("nombre") + " " + rs.getString("ape_paterno") + " " + rs.getString("ape_materno");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener nombre del cliente: " + e.getMessage());
        }
        return null;
    }
}
