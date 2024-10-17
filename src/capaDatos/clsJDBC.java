package capaDatos;

import java.sql.*;

public class clsJDBC {

    private String driver, url, user, password;
    private Connection con;
    private Statement sent = null;

    public clsJDBC() {
        this.driver = "org.postgresql.Driver";
        this.url = "jdbc:postgresql://localhost:5432/bd_SistemaHotel";
        this.user = "postgres";
        this.password = "mrmilk12";
        this.con = null;
    }
    
    public void conectar() throws Exception{
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception("Error al conectar la BD!");
        }
    }
    
    public void desconectar() throws Exception{
        try{
            con.close();
        } catch (SQLException ex){
            throw new Exception ("Error al desconectar la BD");
        }
    }
    
    public ResultSet consultarBD (String strSQL) throws Exception{
        ResultSet rs=null;
        try{
            conectar();
            sent=con.createStatement();
            rs=sent.executeQuery(strSQL);
            return rs;
        } catch (Exception e){
            throw new Exception ("Error al ejecutar consola: "+e.getMessage());
        } finally{
            if (con!=null) {
                desconectar();
            }
        }
    }
    
    public void ejecutarBD(String strSQL) throws Exception {
        try {
            conectar();
            sent = con.createStatement();
            sent.executeUpdate(strSQL);
        } catch (Exception e){
            throw new Exception ("Error al ejecutar Update -->" +e.getMessage());
        } finally {
            if (con != null) {
                desconectar();
            }
        }
    }
}
