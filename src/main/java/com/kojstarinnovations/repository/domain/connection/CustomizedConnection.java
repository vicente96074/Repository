package com.kojstarinnovations.repository.domain.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class CustomizedConnection {

    private static Connection connection;

    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        if(connection == null){
            Properties properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
            properties.load(inputStream);
            String datasourceDriver = properties.getProperty("datasource.driver");
            String datasourceUrl = properties.getProperty("datasource.url");
            String datasourceUsername = properties.getProperty("datasource.username");
            String datasourcePassword = properties.getProperty("datasource.password");

            Class.forName(datasourceDriver);

            connection = DriverManager.getConnection(datasourceUrl, datasourceUsername, datasourcePassword);
        }

        return connection;
    }

    //Close result set
    public static void closeResultSet(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                printException(e);
            }
        }
    }

    //Close prepared statement
    public static void closePreparedStatement(PreparedStatement ps){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                printException(e);
            }
        }
    }

    private static void printException(Exception e) {
        logger.severe("Ocurrió una excepción: " + e.getMessage());
        logger.severe("Detalles de la excepción:");
        logger.severe(e.toString());
        for (StackTraceElement element : e.getStackTrace()) {
            logger.severe("\t" + element.toString());
        }
    }

    //Singleton pattern
    private CustomizedConnection() {
    }

    public static CustomizedConnection getInstance() {
        if (instance == null) {
            instance = new CustomizedConnection();
        }
        return instance;
    }

    private static CustomizedConnection instance;
    private static final Logger logger = Logger.getLogger(CustomizedConnection.class.getName());
}