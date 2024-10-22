package TarefaProf;

public class Ecercicio01 {
    int [] vetor = new int[1000];
    for (int i=0; i<vetor.length; i++){
        vetor[i] = (int) (Math.random()*100);

    int valorBusca = 578;
    int pos = -1;
    int i=0;
    while (i<vetor.length) {
        if (vetor[i] == valorBusca) {
            pos = i;
            break;
        }
        i++;
    }
    System.out.println(pos);
    }
}
    