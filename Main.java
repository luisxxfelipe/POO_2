package main;

import classes.Contatos;
import classes.pessoaFisica;
import classes.pessoaJuridica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private final static int QUANT_CONT = 5;

    public static void main(String[] args) {
        int op;

        Scanner scan = new Scanner(System.in);
        ArrayList<Contatos> listContatos = new ArrayList<>();

        do {
            do {
                System.out.println("\n***SISTEMA DE AGENDA DE CONTATOS***\n");
                System.out.println("\n[1] Inserir novo contato\n[2] Remover contato\n[3] Pesquisar contato\n[4] Visualizar todos os contatos da agenda\n[5] Sair\n\n");
                System.out.println("Escolha alguma opcao acima: ");
                op = scan.nextInt();

                if (op < 1 || op > 5) {
                    System.out.println("\nOpcao invalida, entre com um valor entre [1] e [5]!!\n");
                }
            } while (op < 1 || op > 5);

            if (op == 5) {

                System.out.println("Obrigado por utilizar nosso sistema!!");
            } else {
                switch (op) {
                    case 1:
                        cadastrarContato(listContatos);
                        break;
                    case 2:
                        removerContato(listContatos);
                        break;
                    case 3:
                        int pesq;

                        System.out.println("\nDeseja pesquisar qual contato?\n[1] Pessoa Fisica.\n[2] Pessoa Juridica.\n\n");
                        pesq = scan.nextInt();

                        if (pesq == 1) {
                            imprimirContatoF(listContatos);
                        } else if (pesq == 2) {
                            imprimirContatoJ(listContatos);
                        }
                        break;
                    case 4:
                        ordenarCPFCNPJ(listContatos);
                        imprimirTodosContatos(listContatos);
                        break;
                }
            }
        } while (op != 5);
    }

    private static boolean cadastrarContato(ArrayList<Contatos> listContatos) {
        Scanner scan = new Scanner(System.in);
        int op;

        do {
            do {
                System.out.println("\n*** CRIANDO NOVO CONTATO ***\n");
                System.out.println("[1] Pessoa Fisica.\n[2] Pessoa Juridica.\n[3] Sair.\n\n");
                System.out.println("Escolha alguma opcao acima: ");
                op = scan.nextInt();

                if (op < 1 || op > 3) {
                    System.out.println("Opcao incorreta. Por favor, insira uma opcao entre [1] e [3]!!\n");
                }
            } while (op < 1 || op > 3);

            Contatos contato = null;

            switch (op) {
                case 1:
                    contato = new pessoaFisica();
                    System.out.println("\n *** CADASTRO DE PESSOA FISICA ***\n");
                    criarContatoFisico((pessoaFisica) contato);
                    listContatos.add(contato);
                    System.out.println("\nContato de Pessoa fisica criado com sucesso!!\n");
                    break;

                case 2:
                    contato = new pessoaJuridica();
                    System.out.println("\n *** CADASTRO DE PESSOA JURIDICA ***\n");
                    criarContatoJuridico((pessoaJuridica) contato);
                    listContatos.add(contato);
                    System.out.println("\nContato de Pessoa Juridica criado com sucesso!!\n");
                    break;
            }
        } while (op != 3);

        return true;
    }

    private static void criarContato(Contatos contato) {

        String nome;
        String email;
        String endereco;

        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com o nome do contato: ");
        nome = scan.nextLine();
        contato.setNome(nome);

        System.out.println("Entre com o e-mail do contato: ");
        email = scan.nextLine();
        contato.setEmail(email);

        System.out.println("Entre com o endereco do contato: ");
        endereco = scan.nextLine();
        contato.setEndereco(endereco);
    }

    private static void criarContatoFisico(pessoaFisica contato) {

        String CPF;
        String dataNascimento;
        String estadoCivil;

        Scanner scan = new Scanner(System.in);

        criarContato(contato);

        System.out.println("Entre com o CPF do contato: ");
        CPF = scan.nextLine();
        contato.setCPF(CPF);

        System.out.println("Entre com a data de nascimento do contato: ");
        dataNascimento = scan.nextLine();
        contato.setDataNascimento(dataNascimento);

        System.out.println("Entre com o estado civil do contato: ");
        estadoCivil = scan.nextLine();
        contato.setEstadoCivil(estadoCivil);
    }

    private static void criarContatoJuridico(pessoaJuridica contato) {

        String CNPJ;
        String inscricaoEstadual;
        String razaoSocial;

        Scanner scan = new Scanner(System.in);

        criarContato(contato);

        System.out.println("Entre com o CNPJ do contato: ");
        CNPJ = scan.nextLine();
        contato.setCNPJ(CNPJ);

        System.out.println("Entre com a inscricao estadual do contato: ");
        inscricaoEstadual = scan.nextLine();
        contato.setInscricaoEstadual(inscricaoEstadual);

        System.out.println("Entre com a razao social do contato: ");
        razaoSocial = scan.nextLine();
        contato.setRazaoSocial(razaoSocial);
    }

    private static void removerContato(ArrayList<Contatos> listContatos) {
        System.out.println("\n*** REMOVENDO CONTATO ****\n");
        Contatos contatos = pesquisarContatoFisico(listContatos);
        if (contatos == null) {
            System.out.println("Contato nao encontrado!!");
        } else {
            listContatos.remove(contatos);
            System.out.println("Contato removido com sucesso!!");
        }
    }

    private static Contatos pesquisarContatoFisico(ArrayList<Contatos> listContatos) {
        String CPF;
        Scanner scan = new Scanner(System.in);
        Contatos ContaPF = null;

        System.out.println("Entre com o CPF do contato: ");
        CPF = scan.nextLine();

        pessoaFisica ComparacaoPF = new pessoaFisica();
        ComparacaoPF.setCPF(CPF);

        int index = listContatos.indexOf(ComparacaoPF);

        if (index >= 0)
            ContaPF = listContatos.get(index);

        return ContaPF;
    }

    private static Contatos pesquisarContatoJuridico(ArrayList<Contatos> listContatos) {
        String CNPJ;
        Scanner scan = new Scanner(System.in);
        Contatos ContaPJ = null;

        System.out.println("Entre com o CNPJ do contato: ");
        CNPJ = scan.nextLine();

        pessoaJuridica ComparacaoPJ = new pessoaJuridica();
        ComparacaoPJ.setCNPJ(CNPJ);

        int index = listContatos.indexOf(ComparacaoPJ);

        if (index >= 0)
            ContaPJ = listContatos.get(index);

        return ContaPJ;

    }

    private static void imprimirContatoF(ArrayList<Contatos> listaConta) {

        System.out.println("\n*** IMPRIMINDO DADOS DO CONTATO FISICO ***\n");
        Contatos contatos = pesquisarContatoFisico(listaConta);

        if (contatos == null) {
            System.out.println("Contato não encontrado!");
        } else {
            System.out.println("------------------------------");
            contatos.imprimirDados();
            System.out.println("------------------------------");
        }
    }

    private static void imprimirContatoJ(ArrayList<Contatos> listaConta) {

        System.out.println("\n*** IMPRIMINDO DADOS DO CONTATO JURIDICO ***\n");
        Contatos contatos = pesquisarContatoJuridico(listaConta);

        if (contatos == null) {
            System.out.println("Contato não encontrado!");
        } else {
            System.out.println("------------------------------");
            contatos.imprimirDados();
            System.out.println("------------------------------");
        }
    }

    private static void imprimirTodosContatos(ArrayList<Contatos> listContatos) {
        System.out.println("\n*** IMPRIMINDO TODOS OS CONTATOS ***\n");
        System.out.println("------------------------------");
        for (Contatos conta : listContatos) {
            if (conta != null) {
                conta.imprimirDados();
                System.out.println("------------------------------");
            }
        }
    }

    private static void ordenarCPFCNPJ(ArrayList<Contatos> listContatos) {
        Collections.sort(listContatos, new Comparator<Contatos>() {
            @Override
            public int compare(Contatos contato1, Contatos contato2) {
                boolean isCPFFisica1 = contato1 instanceof pessoaFisica;
                boolean isCPFFisica2 = contato2 instanceof pessoaFisica;

                if (isCPFFisica1 && !isCPFFisica2) {
                    return -1; // Pessoa Fisica (CPF) vem antes de Pessoa Juridica (CNPJ)
                } else if (!isCPFFisica1 && isCPFFisica2) {
                    return 1; // Pessoa Juridica (CNPJ) vem depois de Pessoa Fisica (CPF)
                } else if (isCPFFisica1 && isCPFFisica2) {
                    pessoaFisica pf1 = (pessoaFisica) contato1;
                    pessoaFisica pf2 = (pessoaFisica) contato2;
                    return pf1.getCPF().compareTo(pf2.getCPF()); // Comparação dos números de CPF
                } else {
                    pessoaJuridica pj1 = (pessoaJuridica) contato1;
                    pessoaJuridica pj2 = (pessoaJuridica) contato2;
                    return pj1.getCNPJ().compareTo(pj2.getCNPJ()); // Comparação dos números de CNPJ
                }
            }
        });
    }
}

