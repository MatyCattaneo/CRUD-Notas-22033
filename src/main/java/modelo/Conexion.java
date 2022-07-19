/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Matias
 */
public class Conexion {
        private static BasicDataSource dataSource;
    
    private static DataSource getDataSource() {
        if (dataSource == null) {
            try {
                String url = "jdbc:mysql://matias:matias2012@localhost:3306/notasbd?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                dataSource = new BasicDataSource();
                dataSource.setUrl(url);
                dataSource.setInitialSize(50);
            }
            catch (Exception ex) {
                throw new RuntimeException("Error al conectar con la BD", ex);
            }
        }
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
