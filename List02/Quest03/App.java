package Quest03;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> orderedList = new ArrayList<>();  

        System.out.println("Digite a quantidade de valores que deseja inserir: ");
        int n = scanner.nextInt(); 

        for (int i = 0; i < n; i++) {
            System.out.printf("Digite o %dº valor: ", (i + 1));
            int value = scanner.nextInt();

            emOrd(orderedList, value);
            System.out.println("Lista atual: " + orderedList);
               }

        scanner.close();
    }

    public static void emOrd(ArrayList<Integer> list, int value) {
        //caso  lista esteja vazia ou valor maior que o último elemento, add no final
        if (list.isEmpty() || value >= list.get(list.size() - 1)) {
            list.add(value);
        } else {
            //procura e coloca
            for (int i = 0; i < list.size(); i++) {
                if (value < list.get(i)) {
                    list.add(i, value); 
                    break;
                }
            }
        }
    }
}
