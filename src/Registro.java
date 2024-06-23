import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Registro {
    private List<Cliente> lista;

    public Registro (){
        lista = new ArrayList<>();
    }

    public boolean cadastraCliente(Cliente cliente) {
        if (lista.isEmpty()) {
            lista.add(cliente);
            clienteCadastrado();
            return true;

        } else {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getCodigo() == cliente.getCodigo()) {
                    clienteNaoCadastrado();
                    return false;

                }
            }
            return true;
        }

    }
    public String clienteCadastrado(){
        return "Cliente cadastrado com sucesso!";
    }

    public String clienteNaoCadastrado(){
        return "Cliente não cadastrado, código repetido.";
    }

    public void organizarLista(){
        List<Cliente> clientesOrdenados = lista.stream().sorted(Comparator.comparing(Cliente::getCodigo)).collect(Collectors.toList());
    }

    public List<Cliente> getLista() {
        return lista;
    }
}
