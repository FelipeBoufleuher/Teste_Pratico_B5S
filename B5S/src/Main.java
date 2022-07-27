import java.util.Scanner;

import functions.Functions;

public class Main {
    public static void main(String[] args) throws Exception {
        final int tamanhoDoVetor = 4;
        int vetor[] = new int[tamanhoDoVetor];
        String palavra = "Felipao";
        vetor[0] = 6;
        vetor[1] = 5;
        vetor[2] = 11;
        vetor[3] = 11;

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
        f.creditCardNumber();
        // scanner.close();
    }
}
