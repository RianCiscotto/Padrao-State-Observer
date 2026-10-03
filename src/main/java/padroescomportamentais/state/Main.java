package padroescomportamentais.state;

public class Main {
    public static void main(String[] args) {
        MaquinaDeVendas maquina = new MaquinaDeVendas();

        Observer visor = new VisorDigital();
        Observer sistema = new SistemaMonitoramento();

        maquina.addObserver(visor);
        maquina.addObserver(sistema);

        System.out.println("--- Iniciando Operações na Máquina ---");

        maquina.inserirMoeda();
        maquina.selecionarProduto();
    }
}
