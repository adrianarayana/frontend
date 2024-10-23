import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDeCadastro extends JFrame {
    public final JLabel lblNome;
    public final JTextField txtNome;

    public final JLabel lblEmail;
    public final JTextField txtEmail;

    public final JLabel lblSenha;
    public final JPasswordField txtSenha;

    public final JButton btnCadastrar;
    public final JButton btnCancelar;

    public final JLabel lblNotificacoes;

    public TelaDeCadastro() {
        super("Tela de Cadastro");
        setLayout(new GridLayout(5, 1, 5, 5));

        JPanel linhaNome = new JPanel(new GridLayout(1, 2));
        lblNome = new JLabel("Nome", SwingConstants.RIGHT);
        txtNome = new JTextField(10);
        linhaNome.add(lblNome);
        linhaNome.add(txtNome);
        add(linhaNome);

        JPanel linhaEmail = new JPanel(new GridLayout(1, 2));
        lblEmail = new JLabel("Email", SwingConstants.RIGHT);
        txtEmail = new JTextField(10);
        linhaEmail.add(lblEmail);
        linhaEmail.add(txtEmail);
        add(linhaEmail);

        JPanel linhaSenha = new JPanel(new GridLayout(1, 2));
        lblSenha = new JLabel("Senha", SwingConstants.RIGHT);
        txtSenha = new JPasswordField(10);
        linhaSenha.add(lblSenha);
        linhaSenha.add(txtSenha);
        add(linhaSenha);

        JPanel linhaBotoes = new JPanel(new GridLayout(1, 2));
        btnCadastrar = new JButton("Cadastrar");
        btnCancelar = new JButton("Cancelar");
        linhaBotoes.add(btnCadastrar);
        linhaBotoes.add(btnCancelar);
        add(linhaBotoes);
        
        JPanel linhaNotificacoes = new JPanel(new GridLayout(1, 1));
        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linhaNotificacoes.add(lblNotificacoes);
        add(linhaNotificacoes);

        btnCadastrar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtNome.getText().trim().length() == 0) {
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Nome. Por favor, digite um caracter válido no campo Nome para prosseguir.");
                        txtNome.requestFocus();
                        return;
                    } 

                    if (txtEmail.getText().trim().length() == 0) {
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Email. Por favor, digite um caracter válido no campo Email para prosseguir.");
                        txtEmail.requestFocus();
                        return;
                    }

                    if (String.valueOf(txtSenha.getPassword()).trim().length() == 0) {
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Senha. Por favor, digite um caracter no campo Senha para prosseguir.");
                        txtSenha.requestFocus();
                        return;
                    }

                    String StrSqlCadastrar = "INSERT INTO `tbl_senac` (`nome`, `email`, `senha`) VALUES ('" + txtNome.getText() + "','" + txtEmail.getText() + "','" + String.valueOf(txtSenha.getPassword()) + "');";
                    try {
                        Connection conexao = MySQLConnector.conectar();
                        Statement stmSqlCadastrar = conexao.createStatement();
                        stmSqlCadastrar.executeUpdate(StrSqlCadastrar); // Executa a atualização
                        lblNotificacoes.setText("Cadastro realizado com sucesso.");
                        txtNome.setText("");
                        txtEmail.setText("");
                        txtSenha.setText("");
                    } catch (Exception e) {
                        lblNotificacoes.setText("Ops! Ocorreu um problema e não será possível cadastrar nesse momento. Por favor, tente novamente mais tarde.");
                        System.err.println("Erro: " + e);
                    }
                }
            }
        );

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    txtNome.setText("");
                    txtEmail.setText("");
                    txtSenha.setText("");
                    if (JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?") == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    } else {
                        txtNome.requestFocus();
                    }
                }
            }
        );

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        TelaDeCadastro appTelaDeCadastro = new TelaDeCadastro();
        appTelaDeCadastro.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
