import java.util.Random;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        Random random = new Random();

        // Insere 10 números aleatórios entre 1 e 100 na árvore
        for (int i = 0; i < 10; i++) {
            int valor = random.nextInt(100) + 1;
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
    }
}
