import java.awt.FlowLayout; // Importa o layout de fluxo do pacote AWT.
import java.awt.Font; // Importa a classe Font para manipulação de fontes.
import java.awt.event.ItemListener; // Importa a interface ItemListener para ouvir eventos de itens.
import java.awt.event.ItemEvent; // Importa a classe ItemEvent para eventos de itens.
import javax.swing.JFrame; // Importa a classe JFrame para criação de janelas.
import javax.swing.JTextField; // Importa a classe JTextField para campos de texto.
import javax.swing.JRadioButton; // Importa a classe JRadioButton para botões de rádio.
import javax.swing.ButtonGroup; // Importa a classe ButtonGroup para agrupar botões de rádio.

public class RadioButtonFrame extends JFrame // Declara a classe RadioButtonFrame que estende JFrame
{
   private JTextField textField; // Campo de texto que exibirá a mensagem.
   private Font plainFont; // Fonte normal.
   private Font boldFont; // Fonte em negrito.
   private Font italicFont; // Fonte em itálico.
   private Font boldItalicFont; // Fonte em negrito e itálico.
   private JRadioButton plainJRadioButton; // Botão de rádio para fonte normal.
   private JRadioButton boldJRadioButton; // Botão de rádio para fonte em negrito.
   private JRadioButton italicJRadioButton; // Botão de rádio para fonte em itálico.
   private JRadioButton boldItalicJRadioButton; // Botão de rádio para fonte em negrito e itálico.
   private ButtonGroup radioGroup; // Grupo que contém os botões de rádio.

   public RadioButtonFrame() // Construtor da classe RadioButtonFrame.
   {
      super("RadioButton Test"); // Define o título da janela.
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout.

      textField = new JTextField("Watch the font style change", 25); // Cria um campo de texto com uma mensagem inicial.
      add(textField); // Adiciona o campo de texto à janela.

      // Cria os botões de rádio e define o botão padrão como "Plain".
      plainJRadioButton = new JRadioButton("Plain", true);
      boldJRadioButton = new JRadioButton("Bold", false);
      italicJRadioButton = new JRadioButton("Italic", false);
      boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
      add(plainJRadioButton); // Adiciona o botão "Plain" à janela.
      add(boldJRadioButton); // Adiciona o botão "Bold" à janela.
      add(italicJRadioButton); // Adiciona o botão "Italic" à janela.
      add(boldItalicJRadioButton); // Adiciona o botão "Bold/Italic" à janela.

      radioGroup = new ButtonGroup(); // Cria um grupo de botões para garantir que apenas um botão possa ser selecionado.
      radioGroup.add(plainJRadioButton); // Adiciona o botão "Plain" ao grupo.
      radioGroup.add(boldJRadioButton); // Adiciona o botão "Bold" ao grupo.
      radioGroup.add(italicJRadioButton); // Adiciona o botão "Italic" ao grupo.
      radioGroup.add(boldItalicJRadioButton); // Adiciona o botão "Bold/Italic" ao grupo.

      // Define as diferentes fontes.
      plainFont = new Font("Serif", Font.PLAIN, 14); // Fonte normal.
      boldFont = new Font("Serif", Font.BOLD, 14); // Fonte em negrito.
      italicFont = new Font("Serif", Font.ITALIC, 14); // Fonte em itálico.
      boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // Fonte em negrito e itálico.
      textField.setFont(plainFont); // Define a fonte padrão do campo de texto.

      // Adiciona ouvintes de eventos aos botões de rádio.
      plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont)); // Ouvinte para o botão "Plain".
      boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont)); // Ouvinte para o botão "Bold".
      italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont)); // Ouvinte para o botão "Italic".
      boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont)); // Ouvinte para o botão "Bold/Italic".
   } 

   private class RadioButtonHandler implements ItemListener // Classe interna que implementa ItemListener
   {
      private Font font; // Fonte associada ao botão de rádio.

      public RadioButtonHandler(Font f) // Construtor da classe RadioButtonHandler.
      {
         font = f; // Inicializa a fonte.
      } 
   
      @Override
      public void itemStateChanged(ItemEvent event) // Método chamado quando o estado do item muda.
      {
         textField.setFont(font); // Altera a fonte do campo de texto para a fonte associada ao botão de rádio selecionado.
      } 
   } 
}
