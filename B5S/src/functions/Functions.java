package functions;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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

    public void fileHandler() {
        try {
            File file = new File("/B5S/data.dat");
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            while(br.ready()) {
                String strSem0 = br.readLine();
                String strSem1 = br.readLine();

                strSem0 = strSem0.replace("0", "");
                strSem1 = strSem1.replace("1", "");
            }
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void creditCardNumber() { // 543210******1234 ~= 5432100000000000
        Long creditCardNumber = 5432100000000000L;
        long multiple = 123457;
        Long aux = creditCardNumber + (creditCardNumber % multiple); // = 5432100000013600, menor multiplo de 123457 no
                                                                     // intervalo
        String aux2 = aux.toString();
        System.out.println(aux2.substring(12, 16));

        do { // objetivo: calcular todos os multiplos, a´te um terminar em 1234, falhou
             // for(int i = aux2.length() - 1; i >= 0; i--) {
            System.out.println(aux2);
            aux2 = aux.toString();
            aux += multiple;
            // }
        } while (aux2.substring(12, 16) != "1234");
        System.out.println(aux);
        // a resposta é uma interseção entre o algoritmo de luhn e os multiplos de
        // 123457

    }

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
