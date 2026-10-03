package padroescomportamentais.state;

public class EstadoMoedaInserida extends MaquinaEstado {

    private EstadoMoedaInserida() {};

    private static EstadoMoedaInserida instance = new EstadoMoedaInserida();

    public static EstadoMoedaInserida getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Moeda Inserida";
    }

    @Override
    public boolean selecionarProduto(MaquinaDeVendas maquina) {
        maquina.setEstado(EstadoDispensandoProduto.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(MaquinaDeVendas maquina) {
        maquina.setEstado(EstadoDinheiroDevolvido.getInstance());
        return true;
    }
}