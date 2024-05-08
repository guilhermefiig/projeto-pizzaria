package Aplicacao;

import db.DB;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Cliente cliente;
        Funcionario funcionario;

        Connection connection = DB.getConnection();

        while(true) {
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
                    [8] Deletar uma pizza
                    -----------------------------------
                    [9] Abrir uma conta
                    [10] Pagar uma conta
                    [11] Imprimir uma conta
                    [12] Sair
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
                    break;
                case 8:
                    System.out.println("Opção selecionada: Deletar uma pizza\n");
                    break;
                case 9:
                    System.out.println("Opção selecionada: Abrir uma conta\n");
                    break;
                case 10:
                    System.out.println("Opção selecionada: Pagar uma conta\n");
                    break;
                case 11:
                    System.out.println("Opção selecionada: Imprimir uma conta\n");
                    break;
                case 12:
                    System.out.println("Saindo!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!\n");
            }
        }
    }
}