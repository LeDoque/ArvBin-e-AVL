public class AVLTree {

    Node raiz;

    int altura(Node N) {
        if (N == null)
            return 0;
        return N.altura;
    }


    int max(int a, int b) {
        return (a > b) ? a : b;
    }


    Node direitaRotate(Node y) {
        Node x = y.esquerda;
        Node T2 = x.direita;


        x.direita = y;
        y.esquerda = T2;


        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;


        return x;
    }


    Node esquerdaRotate(Node x) {
        Node y = x.direita;
        Node T2 = y.esquerda;


        y.esquerda = x;
        x.direita = T2;


        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;


        return y;
    }


    int getBalance(Node N) {
        if (N == null)
            return 0;
        return altura(N.esquerda) - altura(N.direita);
    }

    Node inserir(Node node, int key) {


        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.esquerda = inserir(node.esquerda, key);
        else if (key > node.key)
            node.direita = inserir(node.direita, key);
        else
            return node;


        node.altura = 1 + max(altura(node.esquerda),
                altura(node.direita));


        int balance = getBalance(node);


        if (balance > 1 && key < node.esquerda.key)
            return direitaRotate(node);


        if (balance < -1 && key > node.direita.key)
            return esquerdaRotate(node);


        if (balance > 1 && key > node.esquerda.key) {
            node.esquerda = esquerdaRotate(node.esquerda);
            return direitaRotate(node);
        }


        if (balance < -1 && key < node.direita.key) {
            node.direita = direitaRotate(node.direita);
            return esquerdaRotate(node);
        }

        return node;
    }

    void inserir(int key) {
        raiz = inserir(raiz, key);
    }

    public boolean remover(int key) {
        if (raiz == null) {
            System.out.println("Árvore vazia. Não é possível remover.");
            return false;
        }

        Node node = remover(raiz, key);
        if (node == null) {
            System.out.println("Elemento " + key + " não encontrado na árvore.");
            return false;
        }

        raiz = node;
        System.out.println("Elemento " + key + " removido com sucesso.");
        return true;
    }

    private Node remover(Node node, int key) {
        if (node == null)
            return node;

        if (key < node.key)
            node.esquerda = remover(node.esquerda, key);
        else if (key > node.key)
            node.direita = remover(node.direita, key);
        else {
            if (node.esquerda == null)
                return node.direita;
            else if (node.direita == null)
                return node.esquerda;

            node.key = minValue(node.direita);

            node.direita = remover(node.direita, node.key);
        }

        node.altura = 1 + max(altura(node.esquerda), altura(node.direita));

        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.esquerda) >= 0)
            return direitaRotate(node);

        if (balance > 1 && getBalance(node.esquerda) < 0) {
            node.esquerda = esquerdaRotate(node.esquerda);
            return direitaRotate(node);
        }

        if (balance < -1 && getBalance(node.direita) <= 0)
            return esquerdaRotate(node);

        if (balance < -1 && getBalance(node.direita) > 0) {
            node.direita = direitaRotate(node.direita);
            return esquerdaRotate(node);
        }

        return node;
    }

    private int minValue(Node node) {
        int minValue = node.key;
        while (node.esquerda != null) {
            minValue = node.esquerda.key;
            node = node.esquerda;
        }
        return minValue;
    }


    void imprimirEmOrdem(Node node) {
        if (node != null) {
            imprimirEmOrdem(node.esquerda);
            System.out.print(node.key + " ");
            imprimirEmOrdem(node.direita);
        }
    }


    void imprimirNivelPorNivel() {
        int h = altura(raiz);
        int i;
        for (i = 1; i <= h; i++) {
            imprimirNivel(raiz, i);
            System.out.println();
        }
    }


    void imprimirNivel(Node node, int level) {
        if (node == null) {
            System.out.print("null ");
            return;
        }
        if (level == 1)
            System.out.print(node.key + " ");
        else if (level > 1) {
            imprimirNivel(node.esquerda, level - 1);
            imprimirNivel(node.direita, level - 1);
        }
    }

}

