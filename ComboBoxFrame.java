import java.awt.*; // Importa a classe awt
import java.awt.event.*; // Importa a classe event
import javax.swing.*; // Importa a classe swing

public class ComboBoxFrame extends JFrame // declaração da classe pública (extends = herança)
{ // inicio do bloco de códigos da classe
   // Declaração do JComboBox para selecionar imagens
   private final JComboBox<String> imagesJComboBox; 
   // Declaração do JLabel para exibir a imagem selecionada
   private final JLabel label; 

   // Armazena os nomes de imagens
   private static final String[] names = // names é uma matriz de strings
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   // Armazena os ícones que correspondem às imagens
   private final Icon[] icons = { //icon é uma matriz de ícones
      new ImageIcon(getClass().getResource(names[0])),
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3]))};

   // Construtor da classe ComboBoxFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout      

      // Inicializa o JComboBox com os nomes das imagens
      imagesJComboBox = new JComboBox<String>(names);
      imagesJComboBox.setMaximumRowCount(3); // Define o número máximo de itens visíveis na lista

      // Adiciona um listener para tratar a seleção de itens no JComboBox
      imagesJComboBox.addItemListener(
         new ItemListener() 
         {
            @Override
            public void itemStateChanged(ItemEvent event)
            {
               // Verifica se o estado do item foi alterado para selecionado
               if (event.getStateChange() == ItemEvent.SELECTED)
                  // Atualiza o ícone do JLabel com a imagem correspondente
                  label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
            } 
         } 
      ); 

      // Adiciona o JComboBox à janela
      add(imagesJComboBox); 
      // Inicializa o JLabel com o primeiro ícone e o adiciona à janela
      label = new JLabel(icons[0]); 
      add(label); 
   }
}
