import javax.swing.JFrame; // Importa a classe para criar janelas

public class CheckBoxTest {
    public static void main(String[] args) {
        // Cria uma instância da classe CheckBoxFrame, que representa a janela com checkboxes
        CheckBoxFrame checkBoxFrame = new CheckBoxFrame();
        
        // Define a operação padrão ao fechar a janela (encerra o programa)
        checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Define o tamanho da janela (largura, altura)
        checkBoxFrame.setSize(275, 100);
        
        // Torna a janela visível
        checkBoxFrame.setVisible(true);
    }
}
