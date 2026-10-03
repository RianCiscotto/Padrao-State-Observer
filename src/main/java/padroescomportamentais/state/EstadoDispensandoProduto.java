package padroescomportamentais.state;

public class EstadoDispensandoProduto extends MaquinaEstado {

    private EstadoDispensandoProduto() {};

    private static EstadoDispensandoProduto instance = new EstadoDispensandoProduto();

    public static EstadoDispensandoProduto getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Dispensando Produto";
    }

    @Override
    public boolean dispensarProduto(MaquinaDeVendas maquina) {
        maquina.setEstado(EstadoVendaConcluida.getInstance());
        return true;
    }
}