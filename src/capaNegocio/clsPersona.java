package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.*;

public class clsPersona {

    clsJDBC objConector = new clsJDBC();
    String str = "";
    ResultSet rs = null;

    public ResultSet listarPersonas() throws Exception {
        str = "SELECT c.numero_documento, p.nombre, p.ape_paterno, p.ape_materno, p.sexo, p.fecha_nacimiento "
            + "FROM persona p "
            + "JOIN cliente c ON p.cliente_id = c.cliente_id";
        try {
            rs = objConector.consultarBD(str);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al cargar las personas registradas: " + e.getMessage());
        }
    }

    public ResultSet buscarPorNumeroDocumento(String numeroDocumento) throws Exception {
        str = "SELECT c.numero_documento, p.nombre, p.ape_paterno, p.ape_materno, p.sexo, p.fecha_nacimiento "
            + "FROM persona p "
            + "JOIN cliente c ON p.cliente_id = c.cliente_id "
            + "WHERE c.numero_documento = '" + numeroDocumento + "'";
        try {
            rs = objConector.consultarBD(str);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error en la búsqueda por número de documento --> " + e.getMessage());
        }
    }

    public void registrarNuevaPersona(String numeroDocumento, String nombre, String apPat, String apMat, String sexo, String fechaNacimiento) throws Exception {
        ResultSet rsCliente = objConector.consultarBD("SELECT cliente_id FROM cliente WHERE numero_documento = '" + numeroDocumento + "'");
        if (rsCliente.next()) {
            int cliente_id = rsCliente.getInt("cliente_id");
            str = "INSERT INTO persona (cliente_id, nombre, ape_paterno, ape_materno, sexo, fecha_nacimiento) "
                + "VALUES (" + cliente_id + ", '" + nombre + "', '" + apPat + "', '" + apMat + "', '" + sexo + "', '" + fechaNacimiento + "')";
            try {
                objConector.ejecutarBD(str);
            } catch (Exception e) {
                throw new Exception("Error al ingresar nueva Persona --> " + e.getMessage());
            }
        } else {
            throw new Exception("No se encontró cliente con ese número de documento.");
        }
    }

    public void modificarPersona(String numeroDocumento, String nombre, String apPat, String apMat, String sexo, String fechaNacimiento) throws Exception {
        ResultSet rsCliente = objConector.consultarBD("SELECT cliente_id FROM cliente WHERE numero_documento = '" + numeroDocumento + "'");
        if (rsCliente.next()) {
            int cliente_id = rsCliente.getInt("cliente_id");
            str = "UPDATE persona SET nombre='" + nombre + "', ape_paterno='" + apPat + "', ape_materno='" + apMat + "', sexo='" + sexo + "', fecha_nacimiento='" + fechaNacimiento + "' "
                + "WHERE cliente_id=" + cliente_id;
            try {
                objConector.ejecutarBD(str);
            } catch (Exception e) {
                throw new Exception("Error al modificar datos de persona --> " + e.getMessage());
            }
        } else {
            throw new Exception("No se encontró cliente con ese número de documento.");
        }
    }

    public void eliminarPersona(String numeroDocumento) throws Exception {
        ResultSet rsCliente = objConector.consultarBD("SELECT cliente_id FROM cliente WHERE numero_documento = '" + numeroDocumento + "'");
        if (rsCliente.next()) {
            int cliente_id = rsCliente.getInt("cliente_id");
            str = "DELETE FROM persona WHERE cliente_id=" + cliente_id;
            try {
                objConector.ejecutarBD(str);
            } catch (Exception e) {
                throw new Exception("Error al eliminar persona --> " + e.getMessage());
            }
        } else {
            throw new Exception("No se encontró cliente con ese número de documento.");
        }
    }
}
