package petshop;

abstract class Servico {
 private String nome;
 private double preco;

 public Servico(String nome, double preco) {
     this.nome = nome;
     this.preco = preco;
 }

 public String getNome() {
     return nome;
 }

 public double getPreco() {
     return preco;
 }

 public abstract String descricao();
}

class Banho extends Servico {
    public Banho() {
        super("Banho", 30.0);
    }

    public String descricao() {
        return "Serviço de Banho";
    }
}

class Tosa extends Servico {
    public Tosa() {
        super("Tosa", 40.0);
    }

    public String descricao() {
        return "Serviço de Tosa";
    }
}

class ConsultaVeterinaria extends Servico {
    public ConsultaVeterinaria() {
        super("Consulta Veterinária", 50.0);
    }

    public String descricao() {
        return "Consulta Veterinária";
    }
}