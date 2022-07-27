package functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Functions {

    public String correspondingMonth(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Unknown month";
        }
    }

    public int arithmeticAverage(int[] x) {
        int sum = 0;
        if (x.length <= 2) {
            System.out.println("False"); // O retorno de dois tipos não é algo próprio do Java, por isso
            return 0; // substitui por um return 0 e uma mensagem de false.
        }
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum / x.length;
    }

    public int oddOrEven(int[] x) {
        int evenCount = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] % 2 == 0)
                evenCount++;
        }
        return evenCount;
    }

    public String reverseString(String x) { // Poderia manipular a string como um vetor, porém imagino que
        StringBuilder strb = new StringBuilder(x);// que este método tenha uma complexidade menor;
        return strb.reverse().toString();
    }

    public String replaceWovels(String str) {
        str = str.replace('a', '?'); // Poderia fazer o mesmo para vogais maiúsculas ou com acento
        str = str.replace('e', '?');
        str = str.replace('i', '?');
        str = str.replace('o', '?');
        str = str.replace('u', '?');
        return str;
    }

    public int[] arraySort(int[] array) { // utilizei o bubble sort pois não queria alterar os parametros da função
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
        return array;
    }

    public int firstNonRepeatedValue(int[] x) {
        int j;
        for (int i = 0; i < x.length; i++) {
            for (j = i + 1; j < x.length; j++) {
                System.out.println(i + "  " + j);
                if (x[i] == x[j])
                    return x[i];
            }
        }
        System.out.println("Não há valores repetidos");
        return -1;
    }

    public int[] fileHandler() { // Esse algoritmo funcionará trocando 1 e 0 por espaços vazios, logo depois
                                 // contando os caracteres da linha
        int totalLines[] = new int[2]; // se as condições requeridas forem cumpridas, os contadores aumentam.
        try {
            File file = new File("B5S\\src\\data.dat");
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            while (br.ready()) {
                String str0 = br.readLine();
                String str1 = str0;

                str0 = str0.replace("1", "");
                str1 = str1.replace("0", "");

                if (str1.chars().filter(ch -> ch != ' ').count() % 2 == 0)
                    totalLines[1]++;
                if (str0.chars().filter(ch -> ch != ' ').count() % 3 == 0)
                    totalLines[0]++;

            }
            System.out.println("Quantidade de 0 certo: " + totalLines[0]);
            System.out.println("Quantidade de 1 certo: " + totalLines[1]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalLines;
    }

    /*
     * QUESTÃO DO CARTÃO DE CRÉDITO A BAIXO
     */

    public boolean luhn(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) { // começa do final pois o ultimo algoritmo do número nunca pode ter peso 2 no algoritmo de luhn
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = n - 9;
                }
            } sum += n;
            alternate = !alternate;
        } return (sum % 10 == 0);
    }

    public long creditCardNumber() { // 543210******1234 ~= 5432100000001234
        Long cardNumber = 5432100000001234L;
        long multiple = 123457;

        while(cardNumber < 5432109999991234L) {
            int count = 10000; // o contador aumenta de 10000 em 10000 as variáveis começam após 10^4 e os digitos de menor magnitude não podem ser alterados
            cardNumber += count;
            if (cardNumber % multiple == 0 && luhn(cardNumber.toString()))    
            return cardNumber;
        }
        System.out.println("Nenhuma solução encontrada.");
        return 0;
    }

    /*
     * QUESTÃO DO CARTÃO DE CRÉDITO A CIMA
     */

    public int[] atmMachines(int value, int[] bankNotes) { // o algoritmo vai guardar o resultado da divisão
        int totalNotes[] = new int[bankNotes.length]; // do valor pelo array de notas e gaurdar no totalNotes
        for (int i = bankNotes.length - 1; i >= 0; i--) { // (da maior posição, pois o vetor está, teoricamente,
                                                          // ordenado)
            totalNotes[i] = value / bankNotes[i]; // e atualiza o valor de acordo com o resto da divisão
            value = value % bankNotes[i];
            System.out.println(bankNotes[i] + " : " + totalNotes[i]);
        }
        return totalNotes;
        // OBSERVAÇÃO: na minha máquina a divisão dos inteiros está arredondando para
        // baixo.
    }

}
