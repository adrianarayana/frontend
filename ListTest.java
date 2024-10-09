import javax.swing.JFrame; // Importa JFrame para criar janelas

public class ListTest 
{
      public static void main(String[] args) // Esta declarando o método main (principal, conhecido como método executor) 
   { 
      ListFrame listFrame = new ListFrame(); // Cria a janela
      
      listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
      listFrame.setSize(350, 150); // Define o tamanho da janela
      listFrame.setVisible(true); // Torna a janela visível
   } 
} 
