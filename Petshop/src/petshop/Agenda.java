package petshop;

class Agenda {
    private Animal animal;
    private Servico servico;
    private String data;
    private String horario;

    public Agenda(Animal animal, Servico servico, String data, String horario) {
        this.animal = animal;
        this.servico = servico;
        this.data = data;
        this.horario = horario;
    }

    public String toString() {
        return "Animal: " + animal.toString() + ", Serviço: " + servico.descricao() +
               ", Data: " + data + ", Horário: " + horario;
    }
}
