package Aplicacao;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Funcionario {
    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public void addFuncionario(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO funcionario (Nome) VALUES (?)");

            preparedStatement.setString(1, nome);

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
