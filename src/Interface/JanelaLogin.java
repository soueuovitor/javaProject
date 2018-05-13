package Interface;

import gamefestival.GameFestival;
import static java.awt.Color.WHITE;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;



/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 * 
 *   
 */


public class JanelaLogin extends JDialog {    
    private GameFestival game;
    
    public JanelaLogin(GameFestival game) {
        initComponents();
        setICon();
        
        this.setModal(true);           
        
        this.setResizable(false);
        
    
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);                                
        getContentPane().setBackground(WHITE);
        this.game = game;      
      
        txtUtilizador.requestFocus();
    }   
    
    private void autenticar() {                
        if (txtUtilizador.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o nome de utilizador!");            
            txtUtilizador.requestFocus();
            return;
        }
        
        if (txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a sua password!");
            txtPassword.requestFocus();
            return;
        }                              
        
        if (!game.autenticarUtilizador(txtUtilizador.getText(), new String(txtPassword.getPassword()))){
            JOptionPane.showMessageDialog(this, "As credenciais introduzidas não correspondem a um utilizador válido.",
                     "Autenticação", JOptionPane.WARNING_MESSAGE);
            txtUtilizador.requestFocus();            
        }else{
            //Devolve o controlo da aplicação para o método main
            dispose();            
        }               
    }           
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUtilizador = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnOk = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autenticação");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        btnOk.setBackground(java.awt.Color.white);
        btnOk.setForeground(new java.awt.Color(0, 0, 0));
        btnOk.setText("Autenticar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnSair.setBackground(java.awt.Color.white);
        btnSair.setForeground(java.awt.Color.black);
        btnSair.setText("Terminar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        autenticar();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        game.terminar();
    }//GEN-LAST:event_btnSairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       game.terminar();
    }//GEN-LAST:event_formWindowClosing
     private void setICon() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("IconImage_1.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUtilizador;
    // End of variables declaration//GEN-END:variables
}
