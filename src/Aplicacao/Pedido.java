package Aplicacao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pedido {
    private int idCliente;

    public Pedido(int idCliente) {
        this.idCliente = idCliente;
    }

    public void addPedido(Connection connection){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO pedido (ID_Cliente) VALUES (?)");

            preparedStatement.setInt(1, idCliente);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
