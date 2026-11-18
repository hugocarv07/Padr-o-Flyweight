package padroesprojeto.flyweight.hospital;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private List<Paciente> pacientes = new ArrayList<>();

    public void internar(String nomePaciente, String nomeConvenio, String cobertura) {
        Convenio convenio = ConvenioFactory.getConvenio(nomeConvenio, cobertura);
        Paciente paciente = new Paciente(nomePaciente, convenio);
        pacientes.add(paciente);
    }

    public List<String> obterPacientes() {
        List<String> saida = new ArrayList<String>();
        for (Paciente paciente : this.pacientes) {
            saida.add(paciente.obterPaciente());
        }
        return saida;
    }
}
