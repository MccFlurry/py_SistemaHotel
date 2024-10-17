package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.*;

public class clsEmpresa {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    public ResultSet listarEmpresas() throws Exception {
        strSQL = "SELECT c.numero_documento, e.razon_social, e.tipo_id "
                + "FROM empresa e "
                + "JOIN cliente c ON e.cliente_id = c.cliente_id";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar empresas: " + e.getMessage());
        }
    }

    public void registrarEmpresaPorDocumento(String numeroDocumento, String razonSocial, int tipoId) throws Exception {
        String strSQLCliente = "SELECT cliente_id FROM cliente WHERE numero_documento = '" + numeroDocumento + "'";
        ResultSet rsCliente;
        int clienteId = -1;

        try {
            rsCliente = objConectar.consultarBD(strSQLCliente);
            if (rsCliente.next()) {
                clienteId = rsCliente.getInt("cliente_id");
            } else {
                throw new Exception("Cliente con numero_documento " + numeroDocumento + " no encontrado.");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar cliente por documento --> " + e.getMessage());
        }

        // Ahora insertamos en la tabla empresa usando el cliente_id
        strSQL = "INSERT INTO empresa (cliente_id, razon_social, tipo_id) "
                + "VALUES (" + clienteId + ", '" + razonSocial + "', " + tipoId + ")";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar empresa --> " + e.getMessage());
        }
    }

    public ResultSet buscarEmpresaPorDocumento(String numeroDocumento) throws Exception {
        strSQL = "SELECT * FROM empresa e JOIN cliente c ON e.cliente_id = c.cliente_id WHERE c.numero_documento = '" + numeroDocumento + "'";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar empresa por documento --> " + e.getMessage());
        }
    }

    public void eliminarEmpresaPorDocumento(String numeroDocumento) throws Exception {
        String strSQLCliente = "SELECT cliente_id FROM cliente WHERE numero_documento = '" + numeroDocumento + "'";
        ResultSet rsCliente;
        int clienteId = -1;

        try {
            rsCliente = objConectar.consultarBD(strSQLCliente);
            if (rsCliente.next()) {
                clienteId = rsCliente.getInt("cliente_id");
            } else {
                throw new Exception("Cliente con numero_documento " + numeroDocumento + " no encontrado.");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar cliente por documento --> " + e.getMessage());
        }

        String strSQL = "DELETE FROM empresa WHERE cliente_id = " + clienteId;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar empresa --> " + e.getMessage());
        }
    }

    public void modificarEmpresaPorDocumento(String numeroDocumento, String razonSocial, int tipoId) throws Exception {
        String strSQLCliente = "SELECT cliente_id FROM cliente WHERE numero_documento = '" + numeroDocumento + "'";
        ResultSet rsCliente;
        int clienteId = -1;

        try {
            rsCliente = objConectar.consultarBD(strSQLCliente);
            if (rsCliente.next()) {
                clienteId = rsCliente.getInt("cliente_id");
            } else {
                throw new Exception("Cliente con numero_documento " + numeroDocumento + " no encontrado.");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar cliente por documento --> " + e.getMessage());
        }

        // Ahora actualizamos la tabla empresa usando el cliente_id
        strSQL = "UPDATE empresa SET razon_social = '" + razonSocial + "', tipo_id = " + tipoId
                + " WHERE cliente_id = " + clienteId;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar empresa --> " + e.getMessage());
        }
    }

    public ResultSet listarTiposEmpresa() throws Exception {
        strSQL = "SELECT * FROM tipo_empresa";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar tipos de empresa: " + e.getMessage());
        }
    }
}
