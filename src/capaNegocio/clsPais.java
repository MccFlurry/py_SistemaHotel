package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.ResultSet;

public class clsPais {
 
    clsJDBC objConector = new clsJDBC();
    String str = "";
    ResultSet rs = null;

    public ResultSet listarPaises() throws Exception {
        str = "select * from pais";
        try {
            rs = objConector.consultarBD(str);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar los paises" + e.getMessage());
        }
    }
    
}
