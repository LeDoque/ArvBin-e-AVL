import java.util.Random;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        Random random = new Random();

        long starTime = System.currentTimeMillis();

        // Insere 10 números aleatórios entre 1 e 100 na árvore
        for (int i = 0; i < 20000; i++) {
            int valor = random.nextInt(20000) + 1;
            tree.inserir(valor);
        }

        System.out.println("Árvore AVL após a inserção dos números aleatórios:");
        tree.imprimirNivelPorNivel();
        System.out.println();

        // Realiza uma rotação para a direita
        Node novaRaiz = tree.direitaRotate(tree.raiz);
        tree.raiz = novaRaiz;

        System.out.println("Árvore AVL após a rotação para a direita:");
        tree.imprimirNivelPorNivel();

        long endTime = System.currentTimeMillis();

        long tempoDeExecucao = endTime - starTime;
        System.out.println("Tempo de execução " + tempoDeExecucao + " milissegundos");


    }

}
