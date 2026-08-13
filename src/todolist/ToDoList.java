/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todolist;

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class ToDoList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MAX_TAREFAS = 10;

        String[] descricao = new String[MAX_TAREFAS];
        boolean[] concluida = new boolean[MAX_TAREFAS];
        boolean[] ocupado = new boolean[MAX_TAREFAS];

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== LISTA DE TAREFAS ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    int posicaoLivre = -1;
                    for (int i = 0; i < MAX_TAREFAS; i++) {
                        if (!ocupado[i]) {
                            posicaoLivre = i;
                            break;
                        }
                    }

                    if (posicaoLivre != -1) {
                        System.out.print("Digite a tarefa: ");
                        descricao[posicaoLivre] = scanner.nextLine();
                        concluida[posicaoLivre] = false;
                        ocupado[posicaoLivre] = true;
                        System.out.println("Tarefa adicionada com sucesso!");
                    } else {
                        System.out.println("A lista de tarefas está cheia!");
                    }
                    break;

                case 2:
                    boolean possuiTarefas = false;
                    for (int i = 0; i < MAX_TAREFAS; i++) {
                        if (ocupado[i]) {
                            possuiTarefas = true;
                            break;
                        }
                    }

                    if (!possuiTarefas) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        System.out.println("\n=== MINHAS TAREFAS ===");
                        for (int i = 0; i < MAX_TAREFAS; i++) {
                            if (ocupado[i]) {
                                String status = concluida[i] ? "[X]" : "[ ]";
                                System.out.println((i + 1) + " - " + status + " " + descricao[i]);
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o número da tarefa que deseja concluir: ");
                    int numConcluir = scanner.nextInt();
                    int indiceConcluir = numConcluir - 1;
                    if (indiceConcluir >= 0 && indiceConcluir < MAX_TAREFAS && ocupado[indiceConcluir]) {
                        concluida[indiceConcluir] = true;
                        System.out.println("Tarefa concluída com sucesso!");
                    } else {
                        System.out.println("Tarefa inválida!");
                    }
                    break;

                case 4:
                    System.out.print("Digite o número da tarefa que deseja excluir: ");
                    int numExcluir = scanner.nextInt();
                    int indiceExcluir = numExcluir - 1;
                    if (indiceExcluir >= 0 && indiceExcluir < MAX_TAREFAS && ocupado[indiceExcluir]) {
                        ocupado[indiceExcluir] = false;
                        descricao[indiceExcluir] = null;
                        concluida[indiceExcluir] = false;
                        System.out.println("Tarefa excluída com sucesso!");
                    } else {
                        System.out.println("Tarefa inválida!");
                    }
                    break;

                case 5:
                    System.out.println("Programa encerrado. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
    
}
