package padroescomportamentais.state;

public class SistemaMonitoramento implements Observer {

    @Override
    public void update(String mensagem) {
        System.out.println("[SISTEMA DE MONITORAMENTO]: " + mensagem);
    }
}
