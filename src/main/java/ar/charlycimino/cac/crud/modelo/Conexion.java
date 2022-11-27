package ar.charlycimino.cac.crud.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class Conexion {

    private static Connection con;
    private static BasicDataSource dataSource;

    private Conexion() {
    }

    public static DataSource getDataSource() {
        if (dataSource == null) {
            try {
                String env = System.getenv("JAWSDB_URL");
                String urlDB;
                if (env == null) {
                    System.out.println("LOCAL");
                    urlDB = "jdbc:mysql://root:root@localhost:3306/cac_crud_bd?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                } else {
                    System.out.println("PRODUCCIÓN");
                    urlDB = "jdbc:" + env;
                }
                dataSource = new BasicDataSource();
                dataSource.setUrl(urlDB);
                dataSource.setInitialSize(50);
            } catch (Exception ex) {
                throw new RuntimeException("Error de E/S al leer config de BBDD", ex);
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
