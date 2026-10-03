package padroescomportamentais.state;

import java.util.ArrayList;
import java.util.List;

public class MaquinaDeVendas {

    private MaquinaEstado estado;
    private List<Observer> observadores = new ArrayList<>();

    public MaquinaDeVendas() {

        this.estado = EstadoAguardandoMoeda.getInstance();
    }

    public void addObserver(Observer observer) {
        this.observadores.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observadores.remove(observer);
    }

    private void notificarObservadores() {
        for (Observer obs : observadores) {
            obs.update(this.getNomeEstado());
        }
    }

    public void setEstado(MaquinaEstado estado) {
        this.estado = estado;
        this.notificarObservadores();
    }

    public MaquinaEstado getEstado() {
        return this.estado;
    }

    public String getNomeEstado() {
        return this.estado.getEstado();
    }

    public boolean inserirMoeda() {
        return this.estado.inserirMoeda(this);
    }

    public boolean selecionarProduto() {
        return this.estado.selecionarProduto(this);
    }

    public boolean dispensarProduto() {
        return this.estado.dispensarProduto(this);
    }

    public boolean cancelar() {
        return this.estado.cancelar(this);
    }
}
