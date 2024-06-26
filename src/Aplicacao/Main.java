package Aplicacao;

import db.DB;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Cliente cliente;
        Funcionario funcionario;
        Conta conta;
        Pizza pizza;
        Pedido pedido;
        PedidoPizza pedidoPizza;

        Connection connection = DB.getConnection();
        try {
            while (true) {
                System.out.print("""
                                            
                        Escolha uma das opções a seguir:
                                            
                        [1]: Cadastrar um cliente
                        [2]: Ver lista de clientes
                        [3]: Deletar um cliente
                        -----------------------------------
                        [4]: Cadastrar um funcionário
                        [5]: Ver lista de funionários
                        [6]: Deletar um funcionário
                        -----------------------------------
                        [7] Cadastrar uma pizza
                        [8] Ver lista de pizzas
                        [9] Deletar uma pizza
                        -----------------------------------
                        [10] Pedir uma pizza
                        -----------------------------------
                        [11] Pagar uma conta
                        [12] Imprimir uma conta
                        [13] Sair
                        >""");
                int resposta = input.nextInt();

                input.nextLine();

                switch (resposta) {
                    case 1:
                        System.out.println("Opção selecionada: Cadastrar um cliente\n");

                        System.out.print("Digite o nome do cliente: ");
                        String nomeCliente = input.nextLine();

                        cliente = new Cliente(nomeCliente);
                        cliente.addCliente(connection);

                        System.out.printf("\nCliente '%s' cadastrado com sucesso!\n", nomeCliente);

                        break;

                    case 2:
                        System.out.println("Opção selecionada: Ver lista de clientes\n");

                        System.out.println("---Lista de clientes:---");

                        cliente = new Cliente();
                        cliente.mostrarClientes(connection);

                        break;

                    case 3:
                        System.out.println("Opção selecionada: Deletar um cliente\n");

                        System.out.print("Digite o ID do cliente: ");
                        int idClienteDeletar = input.nextInt();

                        cliente = new Cliente(idClienteDeletar);
                        cliente.deletarCliente(connection);

                        System.out.printf("\nCliente com ID = '%d' deletado com sucesso!\n", idClienteDeletar);

                        break;

                    case 4:
                        System.out.println("Opção selecionada: Cadastrar um funcionário\n");

                        System.out.print("Digite o nome d(o/a) funcionári(o/a): ");
                        String nomeFuncionario = input.nextLine();

                        funcionario = new Funcionario(nomeFuncionario);
                        funcionario.addFuncionario(connection);

                        System.out.printf("\nFuncionári(o/a) '%s' cadastrado com sucesso!\n", nomeFuncionario);

                        break;

                    case 5:
                        System.out.println("Opção selecionada: Ver lista de funcionários\n");

                        System.out.println("---Lista de funcionários:---");

                        funcionario = new Funcionario();
                        funcionario.mostrarFuncionarios(connection);

                        break;

                    case 6:
                        System.out.println("Opção selecionada: Deletar um funcionário\n");

                        System.out.print("Digite a matricula do funcionário: ");
                        int matriculaFuncionarioDeletar = input.nextInt();

                        funcionario = new Funcionario(matriculaFuncionarioDeletar);
                        funcionario.deletarFuncionario(connection);

                        System.out.printf("\nFuncionario com matricula = '%d' deletado com sucesso!\n", matriculaFuncionarioDeletar);

                        break;

                    case 7:
                        System.out.println("Opção selecionada: Cadastrar uma pizza\n");

                        System.out.print("Digite o sabor da pizza: ");
                        String saborPizza = input.nextLine();

                        System.out.print("Digite o valor da pizza: ");
                        double valorPizza = input.nextDouble();

                        System.out.print("Digite a matrícula do funcionário que cadastrou a pizza: ");
                        int idFuncionarioCadastroPizza = input.nextInt();

                        pizza = new Pizza(saborPizza, valorPizza, idFuncionarioCadastroPizza);
                        pizza.addPizza(connection);

                        System.out.printf("\nPizza com sabor '%s' cadastrada com sucesso!\n", saborPizza);

                        break;

                    case 8:
                        System.out.println("Opção selecionada: Mostrar lista de pizzas\n");

                        System.out.println("---Lista de pizzas:---");

                        pizza = new Pizza();
                        pizza.mostrarPizzas(connection);

                        break;

                    case 9:
                        System.out.println("Opção selecionada: Deletar uma pizza\n");

                        System.out.print("Digite o ID da pizza que você deseja deletar: ");
                        int idPizzaDeletar = input.nextInt();

                        pizza = new Pizza(idPizzaDeletar);
                        pizza.deletarPizza(connection);

                        System.out.printf("\nPizza com ID = '%d' deletada com sucesso!\n", idPizzaDeletar);

                        break;

                    case 10:
                        System.out.println("Opção selecionada: Pedir uma pizza\n");

                        System.out.print("Você ja abriu uma conta [s]im [n]ão: ");
                        String respostaPedido = input.next();

                        switch (respostaPedido) {
                            case "n":

                                System.out.print("\nDigite o ID do cliente que deseja abrir a conta: ");
                                int idClienteAbrirConta = input.nextInt();

                                pedido = new Pedido(idClienteAbrirConta);
                                pedido.addPedido(connection);

                                System.out.println("Pedido aberto!");

                                break;

                            case "s":

                                System.out.print("Digite o ID do pedido no qual deseja pedir a pizza: ");
                                int idPedidoPedirPizza = input.nextInt();

                                System.out.print("Digite o ID da pizza que deseja pedir: ");
                                int idPizzaPedido = input.nextInt();

                                System.out.print("Digite a quantas pizzas desse sabor você deseja pedir: ");
                                int quantidadePizza = input.nextInt();

                                pedidoPizza = new PedidoPizza(idPedidoPedirPizza, idPizzaPedido, quantidadePizza);
                                pedidoPizza.addPedidoPizza(connection);

                                pizza = new Pizza(idPizzaPedido);
                                double valorConta = pizza.valorPizzas(connection) * quantidadePizza;

                                conta = new Conta(idPedidoPedirPizza, valorConta);
                                conta.criarConta(connection);
                        }

                        break;

                    case 11:
                        System.out.println("Opção selecionada: Pagar uma conta\n");

                        System.out.print("Digite o ID do cliente que vai pagar: ");
                        int idClientePagar = input.nextInt();

                        System.out.print("Digite o ID da conta que deseja pagar: ");
                        int idContapagar = input.nextInt();

                        conta = new Conta(idClientePagar, idContapagar, 0);

                        conta.pagarConta(connection);

                        System.out.println("\nConta paga com sucesso!");

                        break;

                    case 12:
                        System.out.println("Opção selecionada: Imprimir uma conta\n");

                        System.out.print("Digite a matricula do funcionário que vai imprimir: ");
                        int matriculaFuncionarioImprimir = input.nextInt();

                        System.out.print("Digite o ID da conta que deseja imprimir: ");
                        int idContaimprimir = input.nextInt();

                        conta = new Conta(matriculaFuncionarioImprimir, idContaimprimir, 0);

                        System.out.print("\n--------------------------------------------------\n");
                        conta.imprimirConta(connection);
                        System.out.print("\n--------------------------------------------------\n");

                        System.out.println("\nConta impressa com sucesso!");

                        break;

                    case 13:
                        System.out.println("Saindo!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("\nOpção inválida!\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DB.closeConnection();
        }
    }
}