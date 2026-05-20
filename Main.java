package exercicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RedisPessoa dao = new RedisPessoa();
        System.out.println("Qual função você deseja usar?");
        System.out.println("1 | Create Pessoa");
        System.out.println("2 | Read Pessoa");
        System.out.println("3 | Update Pessoa");
        System.out.println("4 | Delete Pessoa");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            System.out.println("Criando pessoa");
            Pessoa pessoa = new Pessoa();
            scanner.nextLine(); 
            System.out.println("Digite o apelido");
            pessoa.setApelido(scanner.nextLine());
            System.out.println("Digite o nome");
            pessoa.setNome(scanner.nextLine());
            System.out.println("Digite o sobrenome");
            pessoa.setSobrenome(scanner.nextLine());
            System.out.println("Digite o telefone");
            pessoa.setTelefone(scanner.nextLine());
            System.out.println("Digite a idade");
            pessoa.setIdade(scanner.nextInt());

            dao.CreatePessoa(pessoa);
        } 
        else if (opcao == 2) {
            System.out.println("Lendo pessoa");
            System.out.println("Digite o apelido");
            String apelido = scanner.next();

            Pessoa pessoa = dao.ReadPessoa(apelido);
            System.out.println(pessoa);
        } 
        else if (opcao == 3) {
            System.out.println("Atualizando pessoa");
            Pessoa pessoa = new Pessoa();
            scanner.nextLine(); 
            System.out.println("Digite o apelido");
            pessoa.setApelido(scanner.nextLine());
            System.out.println("Digite o nome");
            pessoa.setNome(scanner.nextLine());
            System.out.println("Digite o sobrenome");
            pessoa.setSobrenome(scanner.nextLine());
            System.out.println("Digite o telefone");
            pessoa.setTelefone(scanner.nextLine());
            System.out.println("Digite a idade");
            pessoa.setIdade(scanner.nextInt());

            dao.UpdatePessoa(pessoa);
        } 
        else if (opcao == 4) {
            System.out.println("Deletando pessoa");
            System.out.println("Digite o apelido");
            String apelido = scanner.next();
            dao.DeletePessoa(apelido);
        } 
        else {
            System.out.println("Você precisa selecionar alguma opção da lista");
            scanner.close();
        }
        }
}
