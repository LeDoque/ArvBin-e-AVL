public class ArvAVL {

    private Node raiz;

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    public void remover(int valor) {
        raiz = remover(raiz, valor);
    }

    public Node getraiz() {
        return raiz;
    }

    public int altura() {
        return raiz == null ? -1 : raiz.altura;
    }
    public Node procurar(int valor) {
        Node atual = raiz;
        while (atual != null) {
            if (atual.valor == valor) {
                break;
            }
            atual = atual.valor < valor ? atual.right : atual.left;
        }
        return atual;
    }

    public Node inserir(Node node, int valor) {
        if (node == null) {
            return new Node(valor);
        } else if (node.valor > valor) {
            node.left = inserir(node.left, valor);
        } else if (node.valor < valor) {
            node.right = inserir(node.right, valor);
        } else {
            return rebalancear(node);
        }
        return rebalancear(node);
    }


    public Node remover(Node node, int valor) {
        if (node == null) {
            return node;
        } else if (node.valor > valor) {
            node.left = remover(node.left, valor);
        } else if (node.valor < valor) {
            node.right = remover(node.right, valor);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.valor = mostLeftChild.valor;
                node.right = remover(node.right, node.valor);
            }
        }
        if (node != null) {
            node = rebalancear(node);
        }
        return node;
    }

    public Node mostLeftChild(Node node) {
        Node atual = node;
        /* loop down to procurar the leftmost leaf */
        while (atual.left != null) {
            atual = atual.left;
        }
        return atual;
    }

    public Node rebalancear(Node z) {
        updatealtura(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (altura(z.right.right) > altura(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (altura(z.left.left) > altura(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    public Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updatealtura(y);
        updatealtura(x);
        return x;
    }

    public Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updatealtura(y);
        updatealtura(x);
        return x;
    }

    public void updatealtura(Node n) {
        n.altura = 1 + Math.max(altura(n.left), altura(n.right));
    }

    public int altura(Node n) {
        return n == null ? -1 : n.altura;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : altura(n.right) - altura(n.left);
    }
}