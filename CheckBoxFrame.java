import java.awt.FlowLayout; // Importa o layout que organiza componentes em linha
import java.awt.Font; // Importa a classe Font para manipulação de fontes
import java.awt.event.ItemListener; // Importa a interface para lidar com eventos de item
import java.awt.event.ItemEvent; // Importa a classe que representa um evento de item
import javax.swing.JFrame; // Importa a classe para criar janelas
import javax.swing.JTextPane; // Importa a classe para criar campos de texto com formatação
import javax.swing.JCheckBox; // Importa a classe para criar checkboxes
import javax.swing.JPanel; // Importa a classe para criar painéis
import javax.swing.text.SimpleAttributeSet; // Para definir atributos de texto
import javax.swing.text.StyleConstants; // Para constantes de estilo
import javax.swing.text.StyledDocument; // Para documentos formatados

// Declaração da classe CheckBoxFrame que estende JFrame
public class CheckBoxFrame extends JFrame {
    // Declaração dos componentes da interface
    private final JTextPane textPane; // Campo de texto onde o estilo da fonte será exibido
    private final JCheckBox boldJCheckBox; // Checkbox para o estilo negrito
    private final JCheckBox italicJCheckBox; // Checkbox para o estilo itálico
    private final JCheckBox underlineJCheckBox; // Checkbox para o estilo sublinhado

    // Construtor da classe CheckBoxFrame
    public CheckBoxFrame() {
        super("JCheckBox Test"); // Define o título da janela
        setLayout(new FlowLayout()); // Define o layout da janela

        // Cria e configura o campo de texto
        textPane = new JTextPane(); // Cria um JTextPane
        textPane.setText("Watch the font style change"); // Mensagem inicial
        textPane.setFont(new Font("Serif", Font.PLAIN, 14)); // Define a fonte inicial
        add(textPane); // Adiciona o campo de texto à janela

        // Cria um painel para as checkboxes
        JPanel checkBoxPanel = new JPanel(); // Painel para organizar as checkboxes
        checkBoxPanel.setLayout(new FlowLayout()); // Define o layout do painel

        // Cria os checkboxes para negrito, itálico e sublinhado
        boldJCheckBox = new JCheckBox("Bold");
        italicJCheckBox = new JCheckBox("Italic");
        underlineJCheckBox = new JCheckBox("Underline"); // Checkbox para sublinhado

        // Adiciona os checkboxes ao painel
        checkBoxPanel.add(boldJCheckBox); // Adiciona o checkbox de negrito ao painel
        checkBoxPanel.add(italicJCheckBox); // Adiciona o checkbox de itálico ao painel
        checkBoxPanel.add(underlineJCheckBox); // Adiciona o checkbox de sublinhado ao painel

        // Adiciona o painel de checkboxes à janela
        add(checkBoxPanel);

        // Cria e associa o manipulador de eventos
        CheckBoxHandler handler = new CheckBoxHandler();
        boldJCheckBox.addItemListener(handler); // Adiciona o listener ao checkbox de negrito
        italicJCheckBox.addItemListener(handler); // Adiciona o listener ao checkbox de itálico
        underlineJCheckBox.addItemListener(handler); // Adiciona o listener ao checkbox de sublinhado
    }

    // Classe interna para manipular eventos de item
    private class CheckBoxHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            SimpleAttributeSet attrs = new SimpleAttributeSet(); // Atributos de estilo

            // Define os atributos de estilo com base nos checkboxes
            if (boldJCheckBox.isSelected()) {
                StyleConstants.setBold(attrs, true); // Adiciona negrito
            }
            if (italicJCheckBox.isSelected()) {
                StyleConstants.setItalic(attrs, true); // Adiciona itálico
            }
            if (underlineJCheckBox.isSelected()) {
                StyleConstants.setUnderline(attrs, true); // Adiciona sublinhado
            }

            // Obtém o documento e aplica os atributos
            StyledDocument doc = textPane.getStyledDocument();
            doc.setCharacterAttributes(0, doc.getLength(), attrs, false); // Aplica os atributos ao texto
        }
    }

    // Método principal para executar o programa
    public static void main(String[] args) {
        CheckBoxFrame checkBoxFrame = new CheckBoxFrame();
        checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkBoxFrame.setSize(300, 150); // Dimensão de tamanho
        checkBoxFrame.setVisible(true); // Declara a visibilidade do checkbox
    }
}
