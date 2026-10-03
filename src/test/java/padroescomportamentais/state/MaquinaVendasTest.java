package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaquinaVendasTest {

    private MaquinaDeVendas maquina;
    private MockObserver mockObserver;

    private static class MockObserver implements Observer {
        private final List<String> notificacoes = new ArrayList<>();

        @Override
        public void update(String mensagem) {
            notificacoes.add(mensagem);
        }

        public List<String> getNotificacoes() {
            return notificacoes;
        }
    }

    @BeforeEach
    void setUp() {
        maquina = new MaquinaDeVendas();
        mockObserver = new MockObserver();
        maquina.addObserver(mockObserver);
    }

    @Test
    void deveIniciarNoEstadoAguardandoMoeda() {
        assertEquals("Aguardando Moeda", maquina.getNomeEstado());
        assertInstanceOf(EstadoAguardandoMoeda.class, maquina.getEstado());
    }

    @Test
    void deveTransicionarParaMoedaInseridaAoInserirMoeda() {
        boolean sucesso = maquina.inserirMoeda();

        assertTrue(sucesso);
        assertEquals("Moeda Inserida", maquina.getNomeEstado());
        assertInstanceOf(EstadoMoedaInserida.class, maquina.getEstado());

        assertEquals(1, mockObserver.getNotificacoes().size());
        assertEquals("Moeda Inserida", mockObserver.getNotificacoes().get(0));
    }

    @Test
    void deveTransicionarParaDispensandoProdutoAoSelecionarProduto() {
        maquina.inserirMoeda();
        boolean sucesso = maquina.selecionarProduto();

        assertTrue(sucesso);
        assertEquals("Dispensando Produto", maquina.getNomeEstado());
        assertInstanceOf(EstadoDispensandoProduto.class, maquina.getEstado());

        // Verifica se as duas notificações ocorreram na ordem correta
        assertEquals(2, mockObserver.getNotificacoes().size());
        assertEquals("Moeda Inserida", mockObserver.getNotificacoes().get(0));
        assertEquals("Dispensando Produto", mockObserver.getNotificacoes().get(1));
    }

    @Test
    void deveTransicionarParaVendaConcluidaAoDispensarProduto() {
        maquina.inserirMoeda();
        maquina.selecionarProduto();
        boolean sucesso = maquina.dispensarProduto();

        assertTrue(sucesso);
        assertEquals("Venda Concluída", maquina.getNomeEstado());
        assertInstanceOf(EstadoVendaConcluida.class, maquina.getEstado());
    }

    @Test
    void deveTransicionarParaDinheiroDevolvidoAoCancelarEmMoedaInserida() {
        maquina.inserirMoeda();
        boolean sucesso = maquina.cancelar();

        assertTrue(sucesso);
        assertEquals("Dinheiro Devolvido", maquina.getNomeEstado());
        assertInstanceOf(EstadoDinheiroDevolvido.class, maquina.getEstado());
    }

    @Test
    void naoDevePermitirSelecionarProdutoSemMoeda() {
        boolean sucesso = maquina.selecionarProduto();

        assertFalse(sucesso, "Não deveria permitir selecionar produto sem inserir moeda.");
        assertEquals("Aguardando Moeda", maquina.getNomeEstado());
        assertTrue(mockObserver.getNotificacoes().isEmpty(), "Nenhum observer deveria ser notificado.");
    }

    @Test
    void naoDevePermitirCancelarSeNaoHouverMoeda() {
        boolean sucesso = maquina.cancelar();

        assertFalse(sucesso, "Não deveria permitir cancelar sem dinheiro na máquina.");
        assertEquals("Aguardando Moeda", maquina.getNomeEstado());
    }

    @Test
    void devePermitirQueOObserverSejaRemovido() {
        maquina.removeObserver(mockObserver);
        maquina.inserirMoeda();

        assertEquals("Moeda Inserida", maquina.getNomeEstado());
        assertTrue(mockObserver.getNotificacoes().isEmpty(), "O observer removido não deveria receber notificações.");
    }
}