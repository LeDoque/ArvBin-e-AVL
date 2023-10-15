public class ArvoreBinaria {

    private Node raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }


    public Node getRaiz() {

        return raiz;
    }


    public void adicionar(int valor){
        Node novoNode = new Node(valor);
        if (raiz == null){
            this.raiz = novoNode;
        }else{
            Node atual = this.raiz;
            while(true){
                if (novoNode.getValor() < atual.getValor()){
                    if (atual.getEsquerda() != null){
                        atual = atual.getEsquerda();
                    }else{
                        atual.setEsquerda(novoNode);
                        break;
                    }
                }else
                {
                    if (atual.getDireita() != null){
                        atual = atual.getDireita();
                    }else{
                        atual.setDireita(novoNode);
                        break;
                    }
                }
            }
        }
    }

    public Node buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private Node buscarRec(Node atual, int valor) {
        if (atual == null || atual.getValor() == valor) {
            return atual;
        }

        if (valor < atual.getValor()) {
            return buscarRec(atual.getEsquerda(), valor);
        } else {
            return buscarRec(atual.getDireita(), valor);
        }
    }

    public void remover(int valor) {
        this.raiz = removerRecursivamente(this.raiz, valor);
    }

    private Node removerRecursivamente(Node atual, int valor) {
        if (atual == null) {
            return atual;
        }

        if (valor < atual.getValor()) {
            atual.setEsquerda(removerRecursivamente(atual.getEsquerda(), valor));
        } else if (valor > atual.getValor()) {
            atual.setDireita(removerRecursivamente(atual.getDireita(), valor));
        } else {
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            atual.setValor(encontrarMenorValor(atual.getDireita()));
            atual.setDireita(removerRecursivamente(atual.getDireita(), atual.getValor()));
        }

        return atual;
    }

    private int encontrarMenorValor(Node node) {
        while (node.getEsquerda() != null) {
            node = node.getEsquerda();
        }
        return node.getValor();
    }




}