package Aplicacao;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente {
    private String nome;

    public static void addCliente(String nome){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO cliente (Nome) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, nome);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

        }
    }


}
