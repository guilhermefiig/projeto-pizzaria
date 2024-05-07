package Aplicacao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pizza {
    private String sabor;
    private double valor;
    private int matriculaFunc;

    public Pizza(String sabor, double valor, int matriculaFunc) {
        this.sabor = sabor;
        this.valor = valor;
        this.matriculaFunc = matriculaFunc;
    }

    public void addPizza(Connection connection){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO pizza (Sabor ,Valor, Matricula_Funcionario) VALUES (?, ?, ?)");

            preparedStatement.setString(1, sabor);
            preparedStatement.setDouble(2, valor);
            preparedStatement.setInt(3, matriculaFunc);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void apagarPizza(){

    }
}
