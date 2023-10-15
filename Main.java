import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArvAVL arvore = new ArvAVL();
        Random random = new Random();
        int quantidadeNumeros = 500;
        int limiteInf = 1001;
        int limiteSup = 2000;

        System.out.println("Numeros da arvore");
        for (int i = 0; i < quantidadeNumeros; i++){
            int randomInt = random.nextInt(1000);
            System.out.println(randomInt);
            arvore.rebalancear()
        }

        System.out.println("Valores inseridos na arvore");
        for (int i = 0; i < quantidadeNumeros; i++) {
            int randomIns = random.nextInt(limiteSup - limiteInf + 1) + limiteInf;
            System.out.println(randomIns);
        }

        Node resultado = arvore.procurar(50);


        if (resultado != null) {
            System.out.println("Valor encontrado na árvore.");
        } else {
            System.out.println("Valor não encontrado na árvore.");
        }


    }
}
