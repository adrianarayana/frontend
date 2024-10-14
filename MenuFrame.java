import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame 
{
   private final Color[] colorValues = //final somente leitura
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};   
   private final JRadioButtonMenuItem[] colorItems; 
   private final JRadioButtonMenuItem[] fonts; 
   private final JCheckBoxMenuItem[] styleItems; 
   private final JLabel displayJLabel; 
   private final ButtonGroup fontButtonGroup; 
   private final ButtonGroup colorButtonGroup; 
   private int style; 

   public MenuFrame()
   {
      super("Using JMenus");     

      JMenu fileMenu = new JMenu("File");
      fileMenu.setMnemonic('F'); //mnemonic atalho

      JMenuItem aboutItem = new JMenuItem("About..."); 
      aboutItem.setMnemonic('A'); 
      fileMenu.add(aboutItem); 
      aboutItem.addActionListener(
         new ActionListener() 
         {  
            @Override //substituição
            public void actionPerformed(ActionEvent event)
            {
               JOptionPane.showMessageDialog(MenuFrame.this, //JoptionPane é um painel de opções | (,) esta separando os parametros dos métodos
                  "This is an example\nof using menus", // Mensagem que será exibida | \n quebra a linha
                  "About", JOptionPane.PLAIN_MESSAGE);
            } 
         } 
      ); 
 
      JMenuItem exitItem = new JMenuItem("Exit"); 
      exitItem.setMnemonic('x'); 
      fileMenu.add(exitItem); 
      exitItem.addActionListener(
         new ActionListener() 
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0); 
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar(); // barra de menu
      setJMenuBar(bar); 
      bar.add(fileMenu); //adicionar o file menu dentro da linha de menu

      JMenu formatMenu = new JMenu("Format"); 
      formatMenu.setMnemonic('r'); 

      String[] colors = {"Black", "Blue", "Red", "Green"}; // [] matriz {} declaração de vetores

      JMenu colorMenu = new JMenu("Color"); 
      colorMenu.setMnemonic('C'); 

      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup(); //criar um grupo de botões
      ItemHandler itemHandler = new ItemHandler(); 

      for (int count = 0; count < colors.length; count++) //estrutura de reptição pré definida, dentro do for declaramos 3 ações
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); 
         colorMenu.add(colorItems[count]); 
         colorButtonGroup.add(colorItems[count]); 
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true);

      formatMenu.add(colorMenu); //adicionar o menu color dentro do menu Format
      formatMenu.addSeparator(); //asssepartor cria uma linha de separação

      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};//menu fonte, atribuindo 3 vetores
      JMenu fontMenu = new JMenu("Font"); //criar um menu fonte
      fontMenu.setMnemonic('n'); 

      fonts = new JRadioButtonMenuItem[fontNames.length]; //definir a matriz de botões de menu vem em  formato de item.
      fontButtonGroup = new ButtonGroup(); //desmarca a outra opções quando clica em uma opção.

      for (int count = 0; count < fonts.length; count++) //for é uma esutur de repetição pré definida
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]); 
         fontButtonGroup.add(fonts[count]); 
         fonts[count].addActionListener(itemHandler); 
      } 

      fonts[0].setSelected(true); //vetor 0 da matriz font ja vem selecionado
      fontMenu.addSeparator(); //adicionar um separador dentro do menu font

      String[] styleNames = {"Bold", "Italic"}; 
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler(); 

      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); 
         fontMenu.add(styleItems[count]); 
         styleItems[count].addItemListener(styleHandler); 
      }

      formatMenu.add(fontMenu); 
      bar.add(formatMenu); 
     
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
      displayJLabel.setForeground(colorValues[0]);
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));

      getContentPane().setBackground(Color.CYAN); 
      add(displayJLabel, BorderLayout.CENTER); 
   } 

   private class ItemHandler implements ActionListener 
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 

         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, 72));
            }
         }

         repaint(); 
      } 
   } 

   private class StyleHandler implements ItemListener 
   {
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); 
         Font font; 

         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72);
         else
            font = new Font(name, Font.PLAIN, 72);

         displayJLabel.setFont(font);
         repaint(); 
      } 
   } 
} 