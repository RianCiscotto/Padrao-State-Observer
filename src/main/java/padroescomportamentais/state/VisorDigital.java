package padroescomportamentais.state;

public class VisorDigital implements Observer {
    @Override
    public void update(String mensagem) {
        System.out.println("[VISOR DA MÁQUINA]: " + mensagem);
    }
}

