package gestao.produtos_mvc.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:postgres://localhost:5432/gestao-produtos-mvc";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection getConexao(){
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e){
            System.out.println("Erro ao conectar com o Driver e com o usuario");
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println("Erro ao conectar no banco");
        }
        return null;
    }

}
