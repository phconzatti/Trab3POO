import java.util.ArrayList;

public class Registro {
    private ArrayList<Cliente> lista;

    public Registro (){
        lista = new ArrayList<>();
    }

    public boolean cadastraMidia(Cliente cliente) {
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
    public void clienteCadastrado(){
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void clienteNaoCadastrado(){
        System.out.println("Cliente não cadastrado, código repetido.");
    }
}
