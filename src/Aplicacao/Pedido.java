package Aplicacao;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pedido {
    private int idCliente;

    public Pedido(int idCliente) {
        this.idCliente = idCliente;
    }

    public void addPedido(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO pedido (ID_Cliente) VALUES (?)");

            preparedStatement.setInt(1, idCliente);

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
