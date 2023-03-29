package Modelo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    String user;
    String port;
    String hostname;
    String conector;
    String database;
    String password;
    String url;
    Connection con;

    public Conexion(String user, String port, String hostname, String conector, String database, String password,
                    String url) {

        this.user = user;
        this.port = port;
        this.hostname = hostname;
        this.conector = conector;
        this.database = database;
        this.password = password;
        this.url = url;
    }

    public Connection AbrirConexion() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con = DriverManager.getConnection(this.url , this.user , this.password);

        return this.con;
    }
}
