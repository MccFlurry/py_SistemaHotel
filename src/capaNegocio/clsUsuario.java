package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.*;

public class clsUsuario {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    public String login(String correo, String con) throws Exception {
        strSQL = "select dni_empleado, cliente_id, rol from usuario where correo = '" + correo + "' and contrasena = '" + con + "' and vigencia = true";
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                String rol = rs.getString("rol");
                String nombreCompleto = "";
                String dni = "";

                if (rol.equals("empleado")) {
                    dni = rs.getString("dni_empleado");
                    strSQL = "select nombres, ape_paterno, ape_materno from empleado where dni_empleado = '" + dni + "'";
                    ResultSet rsEmpleado = objConectar.consultarBD(strSQL);
                    if (rsEmpleado.next()) {
                        nombreCompleto = rsEmpleado.getString("nombres") + " " + rsEmpleado.getString("ape_paterno") + " " + rsEmpleado.getString("ape_materno");
                    }
                    return "empleado:" + dni + ":" + nombreCompleto;

                } else if (rol.equals("cliente")) {
                    int clienteId = rs.getInt("cliente_id");

                    strSQL = "select numero_documento from cliente where cliente_id = " + clienteId;
                    ResultSet rsCliente = objConectar.consultarBD(strSQL);
                    if (rsCliente.next()) {
                        dni = rsCliente.getString("numero_documento");

                        strSQL = "select nombre, ape_paterno, ape_materno from persona where cliente_id = " + clienteId;
                        ResultSet rsPersona = objConectar.consultarBD(strSQL);
                        if (rsPersona.next()) {
                            nombreCompleto = rsPersona.getString("nombre") + " " + rsPersona.getString("ape_paterno") + " " + rsPersona.getString("ape_materno");
                        }
                    }
                    return "cliente:" + dni + ":" + nombreCompleto;
                }
            } else {
                return "";
            }
        } catch (Exception e) {
            throw new Exception("Error al iniciar sesión: " + e.getMessage());
        }
        return "";
    }

    public Boolean validarVigencia(String correo) throws Exception {
        strSQL = "select vigencia from usuario where correo= '" + correo + "'";
        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getBoolean("vigencia");
            }
        } catch (Exception e) {
            throw new Exception("Error al validar usuario: " + e.getMessage());
        }
        return false;
    }

    public ResultSet listarCuentasGuardadas() throws Exception {
        strSQL = "SELECT idusuario, correo FROM usuario";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar las cuentas guardadas: " + e.getMessage());
        }
    }

    public void guardarCuenta(int idUsuario) throws Exception {
        try {
            // Logic to "mark" the account as saved could go here, but in this case, we reuse the existing data
        } catch (Exception e) {
            throw new Exception("Error al guardar la cuenta: " + e.getMessage());
        }
    }

    // This method retrieves the user's information to allow login by selecting from saved accounts
    public ResultSet buscarCuenta(String correo) throws Exception {
        strSQL = "SELECT * FROM usuario WHERE correo = '" + correo + "'";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar la cuenta guardada: " + e.getMessage());
        }
    }

    public ResultSet listarUsuarios() throws Exception {
        strSQL = "select * from usuario";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Usuarios ---> " + e.getMessage());
        }
    }

    public ResultSet buscarPorid(Integer id) throws Exception {
        strSQL = "select * from usuario where idusuario=" + id;
        try {
            return rs = objConectar.consultarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al encontrar esa ID" + e.getMessage());
        }
    }

    public Integer generarId() throws Exception {
        strSQL = "select coalesce(max(idusuario),0) +1 as id from usuario";
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar nueva ID" + e.getMessage());
        }
        return 0;
    }

    public void registrarUsuarioCliente(Integer id, String corre, String clave, Integer cli_Id, String dni, String rol, boolean vigencia) throws Exception {
        if (rol.equals("cliente")) {
            strSQL = "insert into usuario (idusuario, correo, contrasena, cliente_id, rol, vigencia) "
                    + "values(" + id + ", '" + corre + "', '" + clave + "', " + cli_Id + ", '" + rol + "', " + vigencia + ")";
        } else if (rol.equals("empleado")) {
            strSQL = "insert into usuario (idusuario, correo, contrasena, dni_empleado, rol, vigencia) "
                    + "values(" + id + ", '" + corre + "', '" + clave + "', '" + dni + "', '" + rol + "', " + vigencia + ")";
        }

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar nuevo usuario" + e.getMessage());
        }
    }

    public void modificaruser(Integer id, String corre, String clave, Integer cli_Id, String dni, String rol, boolean vigencia) throws Exception {
        if (rol.equals("cliente")) {
            strSQL = "update usuario set correo='" + corre + "', contrasena='" + clave + "', cliente_id=" + cli_Id + ", dni_empleado=null, "
                    + "rol='" + rol + "', vigencia=" + vigencia + " where idusuario=" + id;
        } else if (rol.equals("empleado")) {
            strSQL = "update usuario set correo='" + corre + "', contrasena='" + clave + "', cliente_id=null, dni_empleado='" + dni + "', "
                    + "rol='" + rol + "', vigencia=" + vigencia + " where idusuario=" + id;
        }

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar datos de usuario --->" + e.getMessage());
        }
    }

    public void eliminarUser(Integer id) throws Exception {
        strSQL = "delete from usuario where idusuario=" + id;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar usuario --->" + e.getMessage());
        }
    }
}
