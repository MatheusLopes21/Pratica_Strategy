/* Pratica 5 Strategy Method
    Dupla: Igor Carvalho Braz -- RA: 42021158
            Matheus Magalhães Alves Lopes -- RA: 4231922738*/ 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContextoDeOrdenacao contexto = new ContextoDeOrdenacao();

        System.out.println("Digite uma lista de números inteiros separados por espaço:");
        String input = scanner.nextLine();
        String[] partes = input.split(" ");
        List<Integer> numeros = new ArrayList<>();
        for (String parte : partes) {
            numeros.add(Integer.parseInt(parte));
        }

        System.out.println("Escolha o método de ordenação:");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Selection Sort");
        System.out.println("3 - Insertion Sort");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                contexto.setEstrategia(new OrdenacaoBubbleSort());
                break;
            case 2:
                contexto.setEstrategia(new OrdenacaoSelectionSort());
                break;
            case 3:
                contexto.setEstrategia(new OrdenacaoInsertionSort());
                break;
            default:
                System.out.println("Opção inválida. Usando Bubble Sort por padrão.");
                contexto.setEstrategia(new OrdenacaoBubbleSort());
                break;
        }

        System.out.println("Lista original: " + numeros);
        contexto.executarOrdenacao(numeros);

        scanner.close();
    }
}
