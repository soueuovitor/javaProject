package Interface;

import Interface.ListagemUtilizadores;
import javax.swing.JOptionPane;
import gamefestival.ListaUtilizadores;
import gamefestival.Utilizador;
import gamefestival.GameFestival;
import static java.awt.Color.WHITE;
import java.awt.Toolkit;

/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 * 
 * Esta janela é utilizada para os seguintes casos de uso: * 
 *   1 - Alteração dos dados do utilizador ligado
 *   2 - Pelo Administrador, para criar um novo Utilizador
 *   3 - Pelo Administrador, para visualizar/editar os dados de um Utilizador já existente
 * 
 */
public class JanelaDadosUtilizador extends javax.swing.JDialog {
    //Referencia ao Sistema, a lista de utilizadores esta no sistema
    private GameFestival game;    
    //Referencia a ListagemUtilizadores. Se for indicado, depois de alterarmos um registo podemos solicitar que a tabela seja redesenhada
    private ListagemUtilizadores listagem;
    //Referencia ao Utilizador que queremos visualizar/editar
    private Utilizador utilizador;   
   
    public JanelaDadosUtilizador(GameFestival game, Utilizador utilizador, ListagemUtilizadores listagem) {
        initComponents();
        setICon();
         getContentPane().setBackground(WHITE);
        //Indica que a janela deve ser modal ou seja,
        //bloqueia a execução do programa até que a janela seja fechada
        this.setModal(true);           
        
        //Não permite o redimensionamento da janela
        this.setResizable(false);                        
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //Guarda a referencia ao sistema
        this.game = game;   
        
        //Guarda a referencia ao utilizador
        this.utilizador = utilizador;
        
        //Guarda a referencia a listagem
        this.listagem = listagem;
        
        //No caso de um registo novo
        if (registoNovo()) {    
            //Altera o titulo da janela
            //Como construimos sempre uma nova janela, as caixas de texto já estão limpas
            setTitle("Criação de novo utilizador");
            txtUtilizador.requestFocus();                      
        }else{
            //No caso de um registo existente
            //Altera o titulo da janela
            setTitle("Alteração de dados de utilizador");
            //Preenche as caixas de texto com os dados do utilizador
            txtUtilizador.setText(utilizador.getUsername());
            txtNome.setText(utilizador.getNome());            
            txtPassword.requestFocus();
        }               
        
    }    
    
    private boolean registoNovo() {
        //Se utililizador == null consideramos que é um novo registo
        return utilizador == null;
    }    
    private void guardar() {
         if (registoNovo() && txtUtilizador.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o username pretendido!");            
            txtUtilizador.requestFocus();
            return;
        }
        
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o seu nome!");            
            txtNome.requestFocus();
            return;
        }
        
        if (txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a nova password!");
            txtPassword.requestFocus();
            return;
        }       
        
        if (txtConfirmacao.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a password de confirmação!");
            txtConfirmacao.requestFocus();
            return;
        }  
        
        String password = new String(txtPassword.getPassword());
        
        if (!password.equals(new String(txtConfirmacao.getPassword()))){
            JOptionPane.showMessageDialog(this, "A password de confirmação não corresponde à password introduzida!");
            txtConfirmacao.requestFocus();
            return;
        }        
        
        if (registoNovo()) {      
            txtUtilizador.setEditable(true);                                 
            Utilizador novo = new Utilizador();
            novo.setNome(txtNome.getText());
            novo.setUsername(txtUtilizador.getText());
            novo.setPassword(password);
          
            try {
                game.getListaUtilizadores().adicionar(novo);
            } catch (ListaUtilizadores.UtilizadorDuplicadoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }                      
                  
        }else{
            txtUtilizador.setEditable(false);
            utilizador.setNome(txtNome.getText());        
            utilizador.setPassword(password);       
        }                       
        
        //Se tiver feito uma referencia a listagem, atualiza a listagem
        if (listagem != null) listagem.atualizar();                 
        
        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
        fechar();
        
    }
    
    private void fechar() {
        dispose();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUtilizador = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmacao = new javax.swing.JPasswordField();
        btnAlterar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alteração de dados de utilizador");
        setResizable(false);

        jLabel1.setText("Username:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Password:");

        btnAlterar.setBackground(java.awt.Color.white);
        btnAlterar.setForeground(java.awt.Color.black);
        btnAlterar.setText("Guardar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnFechar.setBackground(java.awt.Color.white);
        btnFechar.setForeground(java.awt.Color.black);
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel4.setText("Confirmação:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAlterar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnFechar))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnAlterar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        fechar();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        guardar();
    }//GEN-LAST:event_btnAlterarActionPerformed
    private void setICon() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("IconImage_1.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtConfirmacao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUtilizador;
    // End of variables declaration//GEN-END:variables
}
