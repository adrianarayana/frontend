import javax.swing.*; // Importa todas as classes do pacote javax.swing para criar interfaces gráficas.

public class ComboBoxTest // Declara a classe pública ComboBoxTest.
{
   public static void main(String[] args) // Método principal: ponto de entrada da aplicação.
   { 
      ComboBoxFrame comboBoxFrame = new ComboBoxFrame(); // Cria uma nova instância da classe ComboBoxFrame.
      comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação de fechamento para encerrar a aplicação quando a janela for fechada.
      comboBoxFrame.setSize(350, 150); // Define o tamanho da janela como 350 pixels de largura e 150 pixels de altura.
      comboBoxFrame.setVisible(true); // Torna a janela visível para o usuário.
   } 
}
