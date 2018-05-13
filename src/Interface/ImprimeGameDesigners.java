/*
 * Copyright (C) 2017 vhoa1
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Interface;

import gamefestival.ColaboradorPago;
import gamefestival.GameFestival;
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
public class ImprimeGameDesigners extends javax.swing.JFrame {
private AbstractTableModel modeloTabela;
private GameFestival game;
    /**
     * Creates new form ImprimeGameDesigners
     */
    public ImprimeGameDesigners(GameFestival game) {
        initComponents();
        this.game = game;
        setICon();
        this.modeloTabela = criarModeloTabela();
        tabGameDesigners.setModel(modeloTabela);
        TotalGD.setText(Integer.toString(game.getListaGameDesigners().size()));
        SalarioGD.setText(Float.toString(game.getListaGameDesigners().salarioTotalGameDesigners()));
        JScrollPane enclosingScrollPane = (JScrollPane) tabGameDesigners.getParent().getParent();
        enclosingScrollPane.setBorder(BorderFactory.createEmptyBorder());
        getContentPane().setBackground(WHITE);
        
    }
    
    
    private void editar() {
        int rowIndex = tabGameDesigners.getSelectedRow();
        //Se nenhum registo selecionado, nao é possivel editar
        if (rowIndex == -1) return;
        
        String Nome = (String) modeloTabela.getValueAt(rowIndex, 0);
        
        
   
        gamefestival.GameDesigner gameDesigners = game.getListaGameDesigners().getGameDesigner(tabGameDesigners.getSelectedRow());
          game.getListaGameDesigners().getGameDesigner(tabGameDesigners.getSelectedRow());
              GameDesigners janela = new GameDesigners(game, gameDesigners, this);
          janela.setVisible(true);
       
      
    }
    
    
    
    
    
    
    
    
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Nome", "Morada","Numero","Nif", "Cache","jogo","Dia","Hora"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return game.getListaGameDesigners().size();
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
          
                switch (columnIndex) {
                    case 0: 
                        return game.getListaGameDesigners().getGameDesigner(rowIndex).getNome();
                        
                    case 1:
                        return game.getListaGameDesigners().getGameDesigner(rowIndex).getMorada();
                    case 2:
                        return game.getListaGameDesigners().getGameDesigner(rowIndex).getNumTel();
                    case 3:
                        return game.getListaGameDesigners().getGameDesigner(rowIndex).getNif();
                    case 4:
                        return game.getListaGameDesigners().getGameDesigner(rowIndex).getCache();
                    case 5:
                        return game.getListaGameDesigners().getGameDesigner(rowIndex).getJogo();
                    case 6:
                        return game.getListaGameDesigners().getGameDesigner(rowIndex).getDateFormatted();
                  
                  
                    case 7:
                        return game.getListaGameDesigners().getGameDesigner(rowIndex).getHoraFormatted();
                      
                    default:
                        return "";
                }                              
            }            
        };
    }
          
     public void atualizar() {    
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
        modeloTabela.fireTableDataChanged();
    }        


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabGameDesigners = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SalarioGD = new javax.swing.JLabel();
        TotalGD = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listage Game Designers");
        setResizable(false);

        tabGameDesigners.setBackground(java.awt.Color.white);
        tabGameDesigners.setForeground(java.awt.Color.black);
        tabGameDesigners.setModel(new javax.swing.table.DefaultTableModel(
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
        tabGameDesigners.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tabGameDesigners);

        jToggleButton1.setBackground(java.awt.Color.white);
        jToggleButton1.setForeground(java.awt.Color.black);
        jToggleButton1.setText("Voltar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total GameDesigners:");

        jLabel2.setText("Gastos:");

        SalarioGD.setText("jLabel3");

        TotalGD.setText("jLabel3");

        jToggleButton2.setBackground(java.awt.Color.white);
        jToggleButton2.setForeground(java.awt.Color.black);
        jToggleButton2.setText("Editar Game Designer");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalGD)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SalarioGD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SalarioGD)
                    .addComponent(TotalGD)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        dispose();
      
      
      
      
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        editar();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
     private void setICon() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("IconImage_1.png")));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SalarioGD;
    private javax.swing.JLabel TotalGD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTable tabGameDesigners;
    // End of variables declaration//GEN-END:variables
}
