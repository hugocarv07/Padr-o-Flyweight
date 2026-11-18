package padroesprojeto.flyweight.hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {

    @BeforeEach
    void setUp() {
        ConvenioFactory.limpar();
    }

    @Test
    void deveRetornarPacientes() {
        Hospital hospital = new Hospital();
        hospital.internar("Jose", "Unimed", "Total");
        hospital.internar("Maria", "Unimed", "Total");
        hospital.internar("Ana", "Unimed", "Total");
        hospital.internar("Joao", "Amil", "Parcial");

        List<String> saida = Arrays.asList(
                "Paciente{nome='Jose', convenio='Unimed', cobertura='Total'}",
                "Paciente{nome='Maria', convenio='Unimed', cobertura='Total'}",
                "Paciente{nome='Ana', convenio='Unimed', cobertura='Total'}",
                "Paciente{nome='Joao', convenio='Amil', cobertura='Parcial'}");

        assertEquals(saida, hospital.obterPacientes());
    }

    @Test
    void deveRetornarTotalConvenios() {
        Hospital hospital = new Hospital();
        hospital.internar("Jose", "Unimed", "Total");
        hospital.internar("Maria", "Unimed", "Total");
        hospital.internar("Ana", "Unimed", "Total");
        hospital.internar("Joao", "Amil", "Parcial");

        assertEquals(2, ConvenioFactory.getTotalConvenios());
    }

    @Test
    void deveCompartilharAMesmaInstanciaDeConvenio() {
        Convenio primeiro = ConvenioFactory.getConvenio("Unimed", "Total");
        Convenio segundo = ConvenioFactory.getConvenio("Unimed", "Total");

        assertSame(primeiro, segundo);
    }

    @Test
    void convenioDiferenteDeveSerOutraInstancia() {
        Convenio unimed = ConvenioFactory.getConvenio("Unimed", "Total");
        Convenio amil = ConvenioFactory.getConvenio("Amil", "Parcial");

        assertNotSame(unimed, amil);
        assertEquals(2, ConvenioFactory.getTotalConvenios());
    }

    @Test
    void muitosPacientesNaoDevemCriarMuitosConvenios() {
        Hospital hospital = new Hospital();
        String[] convenios = {"Unimed", "Amil", "Bradesco"};
        for (int i = 0; i < 1000; i++) {
            hospital.internar("Paciente " + i, convenios[i % 3], "Total");
        }

        assertEquals(1000, hospital.obterPacientes().size());
        assertEquals(3, ConvenioFactory.getTotalConvenios());
    }

    @Test
    void deveComecarSemConveniosAposLimpar() {
        ConvenioFactory.getConvenio("Unimed", "Total");
        ConvenioFactory.limpar();

        assertEquals(0, ConvenioFactory.getTotalConvenios());
    }
}
