import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Random random = new Random();


        for (int i = 0; i < 500; i++){
            int randomInt = random.nextInt(1000);
            arvore.adicionar(randomInt);
        }


        Node resultado = arvore.buscar(50);

        if (resultado != null) {
            System.out.println("Valor encontrado na árvore.");
        } else {
            System.out.println("Valor não encontrado na árvore.");
        }


    }
}
