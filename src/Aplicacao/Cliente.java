package Aplicacao;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void addCliente(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO cliente (Nome) VALUES (?)");

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
