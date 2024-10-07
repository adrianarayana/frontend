import javax.swing.JFrame; // Importa a classe JFrame do pacote javax.swing para criação de GUIs.

public class RadioButtonTest  // Declara a classe pública RadioButtonTest.
{
   public static void main(String[] args) // Método principal: ponto de entrada da aplicação.
   {
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame(); // Cria uma instância de RadioButtonFrame, uma classe personalizada que estende JFrame para a GUI.
      
      radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação de fechamento para encerrar a aplicação quando a janela for fechada.
      
      radioButtonFrame.setSize(300, 100); // Define o tamanho da janela como 300 pixels de largura e 100 pixels de altura.
      
      radioButtonFrame.setVisible(true); // Torna a janela visível para o usuário.
   } 
}