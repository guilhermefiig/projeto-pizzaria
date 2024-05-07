package Aplicacao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoPizza {
    private int idPedido;
    private int idPizza;
    private int quantidade;

    public PedidoPizza(int idPedido, int idPizza, int quantidade) {
        this.idPedido = idPedido;
        this.idPizza = idPizza;
        this.quantidade = quantidade;
    }

    public void addPedidoPizza(Connection connection){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO pedidopizza (ID_Pedido, ID_Pizza, quantidade_pizza) VALUES (?, ?, ?)");

            preparedStatement.setInt(1, idPedido);
            preparedStatement.setInt(2, idPizza);
            preparedStatement.setInt(3, quantidade);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
