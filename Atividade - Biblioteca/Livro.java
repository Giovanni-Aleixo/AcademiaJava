class Livro {
    private String titulo;
    private String autor;
    private String ISBN;
    private boolean emprestado;

    public Livro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.emprestado = false;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public boolean isEmprestado() {
        return this.emprestado;
    }

    private void setEmprestado(boolean isEmprestado) {
        this.emprestado = isEmprestado;
    }

    public boolean reservar() {
        if (this.isEmprestado()) {
            return false; // Não pode ser emprestado se já estiver emprestado.
        } else {
            this.setEmprestado(true);
            return true;
        }
    }

    public boolean devolver() {
        if (this.isEmprestado()) {
            this.setEmprestado(false);
            return true;
        } else {
            return false; // Não pode ser devolvido se não estiver emprestado.
        }
    }

    public String exibir_info() {
        String informacoes = "Título: " + this.getTitulo() + ", Autor: " + this.getAutor();

        String ISBN = this.getISBN();

        if (!ISBN.isEmpty()) {
            informacoes = informacoes + ", ISBN: " + ISBN;
        }

        boolean livroEmprestado = isEmprestado();
        if (livroEmprestado) {
            informacoes = informacoes + " (Emprestado)";
        } else {
            informacoes = informacoes + " (Disponível)";
        }

        return informacoes;
    }
}


