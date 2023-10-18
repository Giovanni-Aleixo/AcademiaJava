import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> catalogo;
    private ArrayList<Livro> livrosEmprestados;
    private ArrayList<Revista> catalogoRevistas;
    private ArrayList<Revista> revistasEmprestadas;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
        this.livrosEmprestados = new ArrayList<>();
        this.catalogoRevistas = new ArrayList<>();
        this.revistasEmprestadas = new ArrayList<>();
    }

    public boolean adicionar_livro(String titulo, String autor, String ISBN) {
        Livro novoLivro = new Livro(titulo, autor, ISBN);
        this.catalogo.add(novoLivro);
        return true;
    }

    public boolean adicionar_revista(String titulo, String empresa, int edicao) {
        Revista novaRevista = new Revista(titulo, empresa, edicao);
        this.catalogoRevistas.add(novaRevista);
        return true;
    }

    public boolean remover_livro(String ISBN) {
        int tamanhoDoCatalogo = this.catalogo.size();
        int i;

        int indiceDoLivroSelecionado = -1;

        for (i = 0; i < tamanhoDoCatalogo; i++) {
            Livro livroAtual = this.catalogo.get(i);

            String ISBNLivroAtual = livroAtual.getISBN();

            if (ISBNLivroAtual.equals(ISBN)) {
                indiceDoLivroSelecionado = i;
                i = tamanhoDoCatalogo;
            }
        }

        if (indiceDoLivroSelecionado >= 0) {
            this.catalogo.remove(indiceDoLivroSelecionado);
            return true;
        } else {
            return false;
        }
    }

    public boolean adicionarRevista(Revista revista) {
        this.catalogoRevistas.add(revista);
        return true;
    }

    public boolean removerRevista(Revista revista) {
        if (this.catalogoRevistas.contains(revista)) {
            this.catalogoRevistas.remove(revista);
            return true;
        }
        return false;
    }

    public boolean emprestarLivro(String ISBN) {
        for (Livro livro : catalogo) {
            if (livro.getISBN().equals(ISBN)) {
                if (!livrosEmprestados.contains(livro)) {
                    livrosEmprestados.add(livro);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean emprestarRevista(Revista revista) {
        if (this.catalogoRevistas.contains(revista) && !this.revistasEmprestadas.contains(revista)) {
            this.revistasEmprestadas.add(revista);
            revista.reservar();
            return true;
        }
        return false;
    }

    public boolean devolverLivro(String ISBN) {
        for (Livro livro : livrosEmprestados) {
            if (livro.getISBN().equals(ISBN)) {
                livrosEmprestados.remove(livro);
                return true;
            }
        }
        return false;
    }

    public boolean devolverRevista(Revista revista) {
        if (this.revistasEmprestadas.contains(revista)) {
            this.revistasEmprestadas.remove(revista);
            revista.devolver();
            return true;
        }
        return false;
    }

    public ArrayList<Livro> listarLivros() {
        return catalogo;
    }

    public ArrayList<Livro> listarLivrosEmprestados() {
        ArrayList<Livro> livrosEmprestados = new ArrayList<>();
        for (Livro livro : catalogo) {
            if (livro.isEmprestado()) {
                livrosEmprestados.add(livro);
            }
        }
        return livrosEmprestados;
    }

    public ArrayList<Revista> listarRevistas() {
        return catalogoRevistas;
    }
}





