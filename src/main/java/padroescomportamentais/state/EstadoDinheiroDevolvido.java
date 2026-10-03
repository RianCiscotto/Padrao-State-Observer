package padroescomportamentais.state;

public class EstadoDinheiroDevolvido extends MaquinaEstado {

    private EstadoDinheiroDevolvido() {};

    private static EstadoDinheiroDevolvido instance = new EstadoDinheiroDevolvido();

    public static EstadoDinheiroDevolvido getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Dinheiro Devolvido";
    }

    public boolean recolherDinheiro(MaquinaDeVendas maquina) {
        maquina.setEstado(EstadoAguardandoMoeda.getInstance());
        return true;
    }
}