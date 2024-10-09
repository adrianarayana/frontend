import java.awt.*; 
import javax.swing.*; 
import javax.swing.event.*; 

public class ListFrame extends JFrame { //ListFrame é uma classe que cria uma janela com duas listas
    private final JList<String> colorJList; // Lista para selecionar cores
    private final JList<String> sizeJList; // Lista para selecionar tamanhos

    private static final String[] colorNames = {     // Nomes das cores disponíveis
        "Black", "Blue", "Cyan", "Dark Gray", "Gray", 
        "Green", "Light Gray", "Magenta", "Orange", 
        "Pink", "Red", "White", "Yellow"
    };
    
        private static final Color[] colors = { // Cores correspondentes aos nomes
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
        Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
        Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };
    
        private static final String[] sizeNames = { // Nomes dos tamanhos disponíveis
        "Small", "Medium", "Big"
    };
    
        private static final Dimension[] sizes = { // Dimensões correspondentes a cada tamanho
        new Dimension(300, 200), // Small
        new Dimension(600, 400), // Medium
        new Dimension(900, 600)  // Large
    };

    public ListFrame() { // Construtor da classe ListFrame, Inicializa a janela e adiciona as listas de cores e tamanhos
        super("List Test"); // Título da janela
        setLayout(new FlowLayout()); // Define o layout da janela

      colorJList = new JList<>(colorNames); // Inicializa a lista de cores
        colorJList.setVisibleRowCount(5); // Define quantas linhas visíveis
        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite apenas uma seleção
        add(new JScrollPane(colorJList)); // Adiciona a lista com rolagem

         sizeJList = new JList<>(sizeNames); // Inicializa a lista de tamanhos
        sizeJList.setVisibleRowCount(3); // Define quantas linhas visíveis
        sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite apenas uma seleção
        add(new JScrollPane(sizeJList)); // Adiciona a lista com rolagem

        colorJList.addListSelectionListener(new ListSelectionListener() { // Ouvinte para mudanças de seleção na lista de cores
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // Altera a cor de fundo da janela com base na seleção
                getContentPane().setBackground(colors[colorJList.getSelectedIndex()]);
            }
        });

                sizeJList.addListSelectionListener(new ListSelectionListener() { // Ouvinte para mudanças de seleção na lista de tamanhos
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int selectedIndex = sizeJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    
                    setSize(sizes[selectedIndex]); // Altera o tamanho da janela com base na seleção
                }
            }
        });
    }

       public static void main(String[] args) { //Método principal para executar o aplicativo, Cria uma instância de ListFrame e configura a janela.
        ListFrame listFrame = new ListFrame();
        listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o aplicativo ao fechar a janela
        listFrame.setSize(300, 200); // Define o tamanho inicial da janela
        listFrame.setVisible(true); // Torna a janela visível
    }
}
