public class Empresarial extends Cliente{
    private int ano;

    public Empresarial(int codigo, String nome, int ano){
        super (codigo, nome);
        this.ano = ano;
    }

    @Override
    public double calculaDesconto() {
        return 0;
    }

    @Override
    public String toString() {
        return "Empresarial{" +
                super.toString()+
                "ano=" + ano +
                '}';
    }
}
