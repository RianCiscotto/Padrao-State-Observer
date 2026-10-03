package padroescomportamentais.state;

public abstract class MaquinaEstado {

    public abstract String getEstado();

    public boolean inserirMoeda(MaquinaDeVendas maquina) {
        return false;
    }

    public boolean selecionarProduto(MaquinaDeVendas maquina) {
        return false;
    }

    public boolean dispensarProduto(MaquinaDeVendas maquina) {
        return false;
    }

    public boolean cancelar(MaquinaDeVendas maquina) {
        return false;
    }

}
