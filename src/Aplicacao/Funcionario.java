package Aplicacao;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Funcionario {
    private String nome;
    private String matricula;

    public static void addFuncionario(String nome, String matricula){
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = DB.getConnection();
//            preparedStatement = connection.prepareStatement(
//                    "INSERT INTO funcionario (Matricula ,Nome) VALUES (?, ?)",
//                    Statement.RETURN_GENERATED_KEYS);
//
//            preparedStatement.setString(1, nome);
//            preparedStatement.setString(2, matricula);
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//            DB.closeStatement(preparedStatement);
//            DB.closeConnection();
//        }
    }
}
