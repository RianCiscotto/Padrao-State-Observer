package padroescomportamentais.state;

public class EstadoAguardandoMoeda extends MaquinaEstado {

    private EstadoAguardandoMoeda() {};

    private static EstadoAguardandoMoeda instance = new EstadoAguardandoMoeda();

    public static EstadoAguardandoMoeda getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Aguardando Moeda";
    }

    @Override
    public boolean inserirMoeda(MaquinaDeVendas maquina) {
        maquina.setEstado(EstadoMoedaInserida.getInstance());
        return true;
    }
}
