package functions;
public class Functions {
    

    public String correspondingMonth(int month) {
        switch(month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Unknown month";
        }
    }

    public int arithmeticAverage(int[] x) {
        int sum = 0;
        if(x.length <= 2) {
            System.out.println("False"); // O retorno de dois tipos não é algo próprio do Java, por isso
            return 0;                      // substitui por um return 0 e uma mensagem de  false.
        }
        for(int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum / x.length;    
    }

    public int oddOrEven(int[] x) {
        int evenCount = 0;
        for(int i = 0; i < x.length; i++) {
            if(x[i] % 2 == 0) evenCount++;
        }
        return evenCount;
    }

    public String reverseString(String x) {       // Poderia manipular a string como um vetor, porém imagino que
        StringBuilder strb = new StringBuilder(x);// que este metodo tenha uma complexidade menor;
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

    public int firstNonRepeatedValue(int[] x) {
        int j;
        for(int i = 0; i < x.length; i++) {
            for(j = i + 1; j < x.length; j++) {
                System.out.println(i + "  " + j);
                if(x[i] == x[j]) return x[i];
            }
        } System.out.println("Não há valores repetidos");
        return -1;
    }

    public void creditCardNumber() { // 543210******1234 ~= 5432100000000000
        Long creditCardNumber = 5432100000000000L;
        long multiple = 123457;
        Long aux = creditCardNumber + (creditCardNumber % multiple); // = 5432100000013600
        String aux2 = aux.toString();
        System.out.println(aux2.substring(12, 16));

        do {
            // for(int i = aux2.length() - 1; i >= 0; i--) {
                System.out.println(aux2);
                aux2 = aux.toString();
                aux += multiple;
            // }
        } while(aux2.substring(12, 16) != "1234");
         System.out.println(aux);
        
        
        

    }

    

}
