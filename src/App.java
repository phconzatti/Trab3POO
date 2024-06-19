import javax.swing.*;
public class App extends JFrame {
        private Tela tela;
        public App() {
            super();
            tela = new Tela();
            JPanel painel = tela.getPainel();
            add(painel);
            setSize(800,600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

