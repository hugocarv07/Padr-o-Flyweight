package padroesprojeto.flyweight.hospital;

public class Paciente {

    private String nome;
    private Convenio convenio;

    public Paciente(String nome, Convenio convenio) {
        this.nome = nome;
        this.convenio = convenio;
    }

    public String obterPaciente() {
        return "Paciente{" +
                "nome='" + this.nome + '\'' +
                ", convenio='" + convenio.getNome() + '\'' +
                ", cobertura='" + convenio.getCobertura() + '\'' +
                '}';
    }
}
