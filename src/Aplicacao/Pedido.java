package Aplicacao;

import java.sql.*;

public class Pedido {
    private int idCliente;

    public Pedido(int idCliente) {
        this.idCliente = idCliente;
    }

    public void addPedido(Connection connection){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO pedido (ID_Cliente) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, idCliente);

            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                int idPedidoGerado = resultSet.getInt(1);
                System.out.println("\nID do pedido: " + idPedidoGerado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
