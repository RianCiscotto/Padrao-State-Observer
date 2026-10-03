package padroescomportamentais.state;

public class EstadoVendaConcluida extends MaquinaEstado {

    private EstadoVendaConcluida() {};

    private static EstadoVendaConcluida instance = new EstadoVendaConcluida();

    public static EstadoVendaConcluida getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Venda Concluída";
    }

    public boolean finalizarFluxo(MaquinaDeVendas maquina) {
        maquina.setEstado(EstadoAguardandoMoeda.getInstance());
        return true;
    }
}