import javax.swing.JFrame;//biblioteca

public class MenuTest//classe (MenuTest)
{
   public static void main(String[] args)//metodo
   { 
      MenuFrame menuFrame = new MenuFrame(); //cria a variavel do tipo (menuframe) e atribui um abj
      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza o codigo ao fechar a janela
      menuFrame.setSize(500, 200); //paremetros de dimenção da janela
      menuFrame.setVisible(true);//possibilita a vizibilidade da janela
   } 
} 
