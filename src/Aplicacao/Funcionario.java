package Aplicacao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Funcionario {
    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public void addFuncionario(Connection connection){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO funcionario (Nome) VALUES (?)");

            preparedStatement.setString(1, nome);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
