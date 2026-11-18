package padroesprojeto.flyweight.hospital;

public class Convenio {

    private final String nome;
    private final String cobertura;

    public Convenio(String nome, String cobertura) {
        this.nome = nome;
        this.cobertura = cobertura;
    }

    public String getNome() {
        return nome;
    }

    public String getCobertura() {
        return cobertura;
    }
}
