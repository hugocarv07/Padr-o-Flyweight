package padroesprojeto.flyweight.hospital;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConvenioFactory {

    private static Map<String, Convenio> convenios = new ConcurrentHashMap<>();

    public static Convenio getConvenio(String nome, String cobertura) {
        return convenios.computeIfAbsent(nome, chave -> new Convenio(nome, cobertura));
    }

    public static int getTotalConvenios() {
        return convenios.size();
    }

    public static void limpar() {
        convenios.clear();
    }
}
