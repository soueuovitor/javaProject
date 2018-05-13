
package Interface;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import gamefestival.ListaUtilizadores;
import gamefestival.GameFestival;
import gamefestival.Utilizador;
import static java.awt.Color.WHITE;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 */
public class ListagemUtilizadores extends javax.swing.JFrame {
    private GameFestival game;
    private AbstractTableModel modeloTabela;
    
    public ListagemUtilizadores(GameFestival game) {
        initComponents();
        this.game = game;
        setICon();
        this.modeloTabela = criarModeloTabela();
        tabUtilizadores.setModel(modeloTabela);
         getContentPane().setBackground(WHITE);
         JScrollPane enclosingScrollPane = (JScrollPane) tabUtilizadores.getParent().getParent();
         enclosingScrollPane.setBorder(BorderFactory.createEmptyBorder());
    }
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Username", "Nome"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return game.getListaUtilizadores().size();
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
            /*
                Este método é invocado quando se pretende "popular" cada uma das células da tabela
                Se a tabela tem 3 linhas e 2 colunas existem 6 células (3*2), logo o método será invocado 6 vezes
                    rowIndex representa a linha da célula (0 a rowCount -1)
                    columnIndex representa a coluna da célula (0 a ColumnCount -1)
            */
                switch (columnIndex) {
                    case 0: 
                        return game.getListaUtilizadores().todos().get(rowIndex).getUsername();
                    case 1:
                        return game.getListaUtilizadores().todos().get(rowIndex).getNome();
                    default:
                        return "";
                }                              
            }            
        };
    }
    
    private void adicionar() {
        JanelaDadosUtilizador janela = new JanelaDadosUtilizador(game, null, this);   
        janela.setVisible(true);
    }
    
    private void editar() {
        int rowIndex = tabUtilizadores.getSelectedRow();
        //Se nenhum registo selecionado, nao é possivel editar
        if (rowIndex == -1) return;
        
        String username = (String) modeloTabela.getValueAt(rowIndex, 0);
        
        try {
            Utilizador utilizador = game.getListaUtilizadores().getUtilizador(username);
            JanelaDadosUtilizador janela = new JanelaDadosUtilizador(game, utilizador, this);   
            janela.setVisible(true);
        } catch (ListaUtilizadores.UtilizadorNaoExistenteException ex) {            
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    
    public void atualizar() {    
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
        modeloTabela.fireTableDataChanged();
    }        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabUtilizadores = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Utilizadores");
        setResizable(false);

        tabUtilizadores.setBackground(java.awt.Color.white);
        tabUtilizadores.setForeground(java.awt.Color.black);
        tabUtilizadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabUtilizadores.setFillsViewportHeight(true);
        tabUtilizadores.setSelectionBackground(java.awt.Color.gray);
        tabUtilizadores.setSelectionForeground(java.awt.Color.white);
        tabUtilizadores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabUtilizadores);

        btnAdicionar.setBackground(java.awt.Color.white);
        btnAdicionar.setForeground(java.awt.Color.black);
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(java.awt.Color.white);
        btnEditar.setForeground(java.awt.Color.black);
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEditar1.setBackground(java.awt.Color.white);
        btnEditar1.setForeground(java.awt.Color.black);
        btnEditar1.setText("Voltar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar1)
                    .addComponent(btnEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnEditar1ActionPerformed
 private void setICon() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("IconImage_1.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabUtilizadores;
    // End of variables declaration//GEN-END:variables
}
