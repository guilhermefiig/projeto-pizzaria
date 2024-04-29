package Aplicacao;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pizza {
    private String sabor;
    private double valor;

    public static void addPizza(String sabor, double valor, int matriculaFunc){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO pizza (Sabor ,Valor, Matricula_Funcionario) VALUES (?, ?, ?)");

            preparedStatement.setString(1, sabor);
            preparedStatement.setDouble(2, valor);
            preparedStatement.setInt(3, matriculaFunc);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
//            try {
//                preparedStatement.close();
//                connection.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
        }
    }
}
