/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import gamefestival.ColaboradorPago;
import gamefestival.GameFestival;
import gamefestival.ListaColaboradores;
import gamefestival.ListaUtilizadores;
import gamefestival.Utilizador;
import static java.awt.Color.WHITE;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vhoa1
 */
public class ImprimeColaboradores extends javax.swing.JFrame {

    private GameFestival game;
    private AbstractTableModel modeloTabela;
    /**
     * Creates new form ImprimeColaboradoes
     */
    public ImprimeColaboradores(GameFestival game) {
        initComponents();
        setICon();
      
        this.modeloTabela = criarModeloTabela();
        tabColaboradores.setModel(modeloTabela);
        getContentPane().setBackground(WHITE);
        this.game = game;
       JScrollPane enclosingScrollPane = (JScrollPane) tabColaboradores.getParent().getParent();
       enclosingScrollPane.setBorder(BorderFactory.createEmptyBorder());
        

                NTS.setText(Integer.toString(game.getListaColaboradores().size()));
                SalarioCO.setText(Float.toString(game.getListaColaboradores().salarioTotalColaboradores()));
        
        
    }
       private void editar() {
        int rowIndex = tabColaboradores.getSelectedRow();
        //Se nenhum registo selecionado, nao é possivel editar
        if (rowIndex == -1) return;
        
        String Nome = (String) modeloTabela.getValueAt(rowIndex, 0);
        
        
   
        gamefestival.Colaborador colaborador = game.getListaColaboradores().getColaboradores(tabColaboradores.getSelectedRow());
          if((game.getListaColaboradores().getColaboradores(tabColaboradores.getSelectedRow())) instanceof ColaboradorPago){
              new ColaboradorPagoRegisto(game,colaborador, this ).setVisible(true);
          }else{
              new ColaboradorVoluntarioRegisto(game,colaborador, this ).setVisible(true);
          }
       
      
    }
    
    

   private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Nome", "Morada","Numero","Função", "Salário", "NIF"};
        
        
    

       
   

        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return game.getListaColaboradores().size();
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
                        return game.getListaColaboradores().getColaboradores(rowIndex).getNome();
                        
                    case 1:
                        return game.getListaColaboradores().getColaboradores(rowIndex).getMorada();
                    case 2:
                        return game.getListaColaboradores().getColaboradores(rowIndex).getNumTel();
                    case 3:
                        return game.getListaColaboradores().getColaboradores(rowIndex).getFuncao();
                    case 4:
                        if ((game.getListaColaboradores().getColaboradores(rowIndex)) instanceof ColaboradorPago){

                        return ((ColaboradorPago) game.getListaColaboradores().getColaboradores(rowIndex)).getSalario();
                        }
                else{
                       return "------------";
                        }
                        
                    case 5:
                             if ((game.getListaColaboradores().getColaboradores(rowIndex)) instanceof ColaboradorPago){

                        return ((ColaboradorPago) game.getListaColaboradores().getColaboradores(rowIndex)).getNif();
                        }
                else{
                       return "------------";
                        }
                    default:
                        return "";
                         
                }                              
            }            
        };
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabColaboradores = new javax.swing.JTable();
        EditarDados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SalarioCO = new javax.swing.JLabel();
        NTS = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem Colaboradores");
        setResizable(false);

        jToggleButton1.setBackground(java.awt.Color.white);
        jToggleButton1.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setText("Voltar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        tabColaboradores.setBackground(java.awt.Color.white);
        tabColaboradores.setForeground(java.awt.Color.black);
        tabColaboradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "Title 6"
            }
        ));
        tabColaboradores.setFillsViewportHeight(true);
        tabColaboradores.setSelectionBackground(new java.awt.Color(60, 66, 76));
        tabColaboradores.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabColaboradores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabColaboradores);

        EditarDados.setBackground(java.awt.Color.white);
        EditarDados.setForeground(java.awt.Color.black);
        EditarDados.setText("Editar Colaborador");
        EditarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarDadosActionPerformed(evt);
            }
        });

        jLabel1.setText("Número Colaboradores:");

        SalarioCO.setText("jLabel2");

        NTS.setText("jLabel2");

        jLabel2.setText("Total Salários:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EditarDados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NTS)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SalarioCO)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NTS)
                    .addComponent(SalarioCO)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditarDados)
                    .addComponent(jToggleButton1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        dispose();
     
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void EditarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarDadosActionPerformed
       editar();
    }//GEN-LAST:event_EditarDadosActionPerformed

    public void atualizar() {    
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
        modeloTabela.fireTableDataChanged();
    }        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditarDados;
    private javax.swing.JLabel NTS;
    private javax.swing.JLabel SalarioCO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tabColaboradores;
    // End of variables declaration//GEN-END:variables
 private void setICon() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("IconImage_1.png")));
    }

}
