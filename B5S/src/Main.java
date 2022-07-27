import java.util.Scanner;

import functions.Functions;

public class Main {
    public static void main(String[] args) throws Exception {
        final int tamanhoDoVetor = 5;
        int vetor[] = new int[tamanhoDoVetor];
        String palavra = "Felipao";
        vetor[0] = 2;
        vetor[1] = 5;
        vetor[2] = 10;
        vetor[3] = 100;
        vetor[4] = 200;

        Scanner scanner = new Scanner(System.in);
        Functions f = new Functions();
        // int x;

        // System.out.println("Digite um valor \n");
        // x = scanner.nextInt();
        // System.out.println(f.correspondingMonth(x));

        // System.out.println(f.arithmeticAverage(vetor));
        // System.out.println(f.oddOrEven(vetor));
        // System.out.println(f.reverseString(palavra));
        // System.out.println(f.replaceWovels(palavra));
        // System.out.println(f.firstNonRepeatedValue(vetor));
        // f.arraySort(vetor);
        // for(int i = 0; i < tamanhoDoVetor; i++) System.out.println(vetor[i]);
        // f.atmMachines(1323, vetor);
        //f.fileHandler();
        // System.out.println(f.creditCardNumber());
        // scanner.close();
    }
}
