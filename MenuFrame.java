import java.awt.*; // bibliotecas
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame // cria a classe (MenuFrame) herdando (JFrame)
{
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};  // cria uma array (colorValues) com as cores
   private final JRadioButtonMenuItem[] colorItems; // color menu items
   private final JRadioButtonMenuItem[] fonts; // font menu items
   private final JRadioButtonMenuItem[] sizes; // font menu items
   private final JCheckBoxMenuItem[] styleItems; // font style menu items
   private final JLabel displayJLabel; // displays sample text

   private final ButtonGroup fontButtonGroup; // manages font menu items
   private final ButtonGroup colorButtonGroup; // manages color menu items
   private final ButtonGroup sizeButtonGroup; // manages color menu items
   private int style; // used to create style for font
   private final int[] fontSizes = {12, 24, 48, 72}; 

   // construtor
   public MenuFrame()
   {
      super("Using JMenus"); // titulo da janela  

      JMenu fileMenu = new JMenu("File"); // cria o menu "File"
      fileMenu.setMnemonic('F'); // define o mnemonic com "F"

      JMenuItem aboutItem = new JMenuItem("About..."); // cria o (menuItem) "About..."
      aboutItem.setMnemonic('A'); // define o mnemonic com "A"
      fileMenu.add(aboutItem); // adiciona (aboutItem) ao (fileMenu)
      aboutItem.addActionListener(
         new ActionListener() 
         {  
            @Override // sobreescreve o codigo
            public void actionPerformed(ActionEvent event) 
            {
               JOptionPane.showMessageDialog(MenuFrame.this,
                  "This is an example\nof using menus", // mensagem 
                  "About", JOptionPane.PLAIN_MESSAGE); // titulo "About" com a fonte (PLAIN)
            } 
         } 
      ); 

      JMenuItem exitItem = new JMenuItem("Exit"); // cria o botão "exit"
      exitItem.setMnemonic('x'); // define o mnemonic com "x"
      fileMenu.add(exitItem); // adiciona (exitItem) ao (fileMenu)
      exitItem.addActionListener(
         new ActionListener() // cria um observador
         {
            @Override
            public void actionPerformed(ActionEvent event) // adiciona um acionador
            {
               System.exit(0); // fecha o aplicativo
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar(); // cria a barra de menu 
      setJMenuBar(bar); // adiciona o (menuBar) a aplicativo
      bar.add(fileMenu); // adiciona (fileMenu) ao (menuBar)

      JMenu formatMenu = new JMenu("Format"); // cria o menu "Format"
      formatMenu.setMnemonic('r'); // define o mnemonic com "r"

      String[] colors = {"Black", "Blue", "Red", "Green"}; // cria a array (colors) e atribui vetores

      JMenu colorMenu = new JMenu("Color"); // cria o menu "Color"
      colorMenu.setMnemonic('C'); // define o mnemonic com "C"

      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup(); // cria o grupo de botões das cores
      ItemHandler itemHandler = new ItemHandler(); // manipulador das cores

      // create color radio button menu items
      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); // create item
         colorMenu.add(colorItems[count]); // add item to color menu
         colorButtonGroup.add(colorItems[count]); // add to group
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true); // select first Color item

      formatMenu.add(colorMenu); // add color menu to format menu
      formatMenu.addSeparator(); // add separator in menu

      // array listing font names
      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};
      JMenu fontMenu = new JMenu("Font"); // create font menu
      fontMenu.setMnemonic('n'); // set mnemonic to n

      // create radio button menu items for font names
      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup(); // manages font names

      // create Font radio button menu items
      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]); // add font to font menu
         fontButtonGroup.add(fonts[count]); // add to button group
         fonts[count].addActionListener(itemHandler); // add handler
      } 

      fonts[0].setSelected(true); // select first Font menu item
      fontMenu.addSeparator(); // add separator bar to font menu

      String[] styleNames = {"Bold", "Italic"}; // names of styles
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler(); // style handler

      // create style checkbox menu items
      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); // for style
         fontMenu.add(styleItems[count]); // add to font menu
         styleItems[count].addItemListener(styleHandler); // handler
      }

      fontMenu.addSeparator(); // add separator bar to font menu

      sizes = new JRadioButtonMenuItem[fontSizes.length];
      sizeButtonGroup = new ButtonGroup();

      for (int count = 0; count < fontSizes.length; count++) 
      {
         sizes[count] = 
            new JRadioButtonMenuItem(String.valueOf(fontSizes[count])); // for style
         fontMenu.add(sizes[count]); 
         sizeButtonGroup.add(sizes[count]);
         sizes[count].addActionListener(itemHandler); // handler
      }

      sizes[3].setSelected(true);

      formatMenu.add(fontMenu); // add Font menu to Format menu
      bar.add(formatMenu); // add Format menu to menu bar
     
      // set up label to display text
      displayJLabel = new JLabel("Aula Menu Frame", SwingConstants.CENTER); // Alterada aqui
      displayJLabel.setForeground(colorValues[0]);
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));

      getContentPane().setBackground(Color.PINK); // Alterado para rosa
      add(displayJLabel, BorderLayout.CENTER); // add displayJLabel
   } // end MenuFrame constructor

   // inner class to handle action events from menu items
   private class ItemHandler implements ActionListener 
   {
      // process color and font selections
      @Override
      public void actionPerformed(ActionEvent event)
      {
         // process color selection
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 

         // process font selection
         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, displayJLabel.getFont().getSize()));
            }
         }

         for (int count = 0; count < sizes.length; count++)
         {
            if (sizes[count].isSelected()) 
            {
               displayJLabel.setFont(
                  new Font(displayJLabel.getFont().getName(), style, fontSizes[count]));
            } 
         } 

         repaint(); // redraw application
      } 
   } // end class ItemHandler

   // inner class to handle item events from checkbox menu items
   private class StyleHandler implements ItemListener 
   {
      // process font style selections
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); // current Font
         Font font; // new font based on user selections

         // determine which CheckBoxes are checked and create Font
         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, displayJLabel.getFont().getSize());
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, displayJLabel.getFont().getSize());
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, displayJLabel.getFont().getSize());
         else
            font = new Font(name, Font.PLAIN, displayJLabel.getFont().getSize());

         displayJLabel.setFont(font);

         definirCor();
         definirFonte();
         definirTamanho();

         repaint(); // redraw application
      } 
   } // end class StyleHandler
} // end class MenuFrame
