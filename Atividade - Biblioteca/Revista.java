class Revista implements Imprimivel {
    private String titulo;
    private String empresa;
    private int edicao;
    private boolean emprestado;
    private int nroCopias;

    // Construtor
    public Revista(String titulo, String empresa, int edicao) {
        this.titulo = titulo;
        this.empresa = empresa;
        this.edicao = edicao;
        this.emprestado = false;
        this.nroCopias = 1;
    }

    // Método para reservar a revista
    public boolean reservar() {
        if (!emprestado) {
            emprestado = true;
            return true;
        } else {
            return false;
        }
    }

    // Método para devolver a revista
    public void devolver() {
        emprestado = false;
    }

    // Método para exibir informações da revista
    public String exibir_info() {
        return "Título: " + titulo + "\nEmpresa: " + empresa + "\nEdição: " + edicao +
                "\nEmpréstimo: " + (emprestado ? "Sim" : "Não") + "\nNúmero de Cópias: " + nroCopias;
    }

    // Implementação do método imprimir da interface Imprimível para a revista
    @Override
    public boolean imprimir() {
        if (!emprestado) {
            nroCopias++;
            return true;
        } else {
            return false;
        }
    }
}