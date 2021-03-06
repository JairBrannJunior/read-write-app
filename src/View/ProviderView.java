package View;

import Controller.Binary.ProviderBinaryController;
import Controller.Text.ProviderController;
import Model.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *.
 * @author Jair Brannn Junior RA: 2052075
 */
public class ProviderView extends javax.swing.JFrame {

    public ProviderController providerController = new ProviderController(1);
    public ProviderBinaryController providerBinaryController = new ProviderBinaryController(0);    
    public int modelId = 0;
    public String modelNome;
    public String modelCnpj;
    public List<Integer> listUniqueId = new ArrayList<>(); 
    public int uniqueId;
    public static int typeFile;    
    
    public ProviderView(int typeFile) {
        this.typeFile = typeFile;  
        initComponents();
        setModelId();
        InitTable();       
    }
    
        public void setModelId() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (jTable1.getSelectedRow() >= 0) {
                    modelId = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    modelNome = (jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                    modelCnpj = (jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                    campoNome.setText(modelNome);
                    campoCnpj.setText(modelCnpj);
                }
            }
        });
    }
    
    public int getUniqueId() {
        for(int i = 0;i<jTable1.getModel().getRowCount();i++) {      
            if (!listUniqueId.contains(Integer.parseInt(jTable1.getModel().getValueAt(i,0).toString()))) {
                listUniqueId.add(Integer.parseInt(jTable1.getModel().getValueAt(i,0).toString()));
            }
        }
        
        Collections.reverse(listUniqueId);
        if (!listUniqueId.isEmpty()) {
            uniqueId = Integer.parseInt(listUniqueId.get(0).toString());
        }else {
            uniqueId = 0;
        }
        
        do {
            uniqueId++;
        }while(listUniqueId.contains(uniqueId));
        return uniqueId;
    }
    
    public void removeListUnique(int id) {    
        Iterator itr = listUniqueId.iterator(); 
        while (itr.hasNext()) 
        { 
            int x = (Integer)itr.next(); 
            if (x == id) 
                itr.remove(); 
        } 
    }
    
    public boolean verifyOnlyNumber(String value) {
        if (value == null){
            return false;
        }
        int len = value.length();
        for (int i = 0; i < len; i++) {
            // checks whether the character is not a letter
            // if it is not a letter ,it will return false
            if ((Character.isLetter(value.charAt(i)) == true)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoCnpj = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fornecedor");

        jLabel1.setText("Nome:");

        jLabel2.setText("CNPJ:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Voltar a seleção");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoCnpj)
                                    .addComponent(campoNome))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (campoNome.getText().isEmpty() || campoCnpj.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!", "Aviso!", 2);
        } else if(campoNome.getText().contains(",") || campoCnpj.getText().contains(",")){
            JOptionPane.showMessageDialog(null, "Caractere ',' inválido!", "Aviso!", 2);
        }else if (verifyOnlyNumber(campoCnpj.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Somente números são aceitos!", "Aviso!", 2);
        }else{
            String newModel = getUniqueId() + "," + campoNome.getText() + "," + campoCnpj.getText();
            if (typeFile == 0) {
                Provider newProvider = new Provider();
                newProvider.id = getUniqueId();
                newProvider.nome = campoNome.getText();
                newProvider.cnpj = campoCnpj.getText();
                providerBinaryController.genericList.add(newProvider);                
            }else {
                providerController.setNewModel(newModel);
            }
            if (typeFile == 0 ? providerBinaryController.write(true) : providerController.write(true)) {
                JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Sucesso", 1);
                campoNome.setText("");
                campoCnpj.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao salvar os dados!", "Erro", 0);
            }
            InitTable();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (modelId > 0) {
            if(typeFile == 0 ? providerBinaryController.remove(modelId) : providerController.remove(modelId)) {
                removeListUnique(modelId);
                JOptionPane.showMessageDialog(null, "Item removido com sucesso!", "Sucesso", 1);           
                InitTable();         
                campoNome.setText("");
                campoCnpj.setText("");
            }else {
                JOptionPane.showMessageDialog(null, "Erro ao remover o item!", "Erro!", 0);           
            }
        }else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Aviso!", 2);           
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Provider editedProvider = new Provider();
        if (typeFile == 0) {
            editedProvider.id = modelId;
            editedProvider.nome = campoNome.getText();
            editedProvider.cnpj = campoCnpj.getText();            
        }else {
            String updateModel = modelId + "," + campoNome.getText() + "," + campoCnpj.getText();   
            providerController.setNewModel(updateModel);
        }
        
        if (campoNome.getText().isEmpty() || campoCnpj.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!", "Aviso!", 2);
        } else if(campoNome.getText().contains(",") || campoCnpj.getText().contains(",")){
            JOptionPane.showMessageDialog(null, "Caractere ',' inválido!", "Aviso!", 2);
        }else if (campoNome.getText().contains(",") || campoCnpj.getText().contains(",")) {
            JOptionPane.showMessageDialog(null, "Somente números são aceitos!", "Aviso!", 2);            
        }else if(typeFile == 0 ? providerBinaryController.Update(editedProvider) : providerController.Update(modelId)) {
            JOptionPane.showMessageDialog(null, "Item atualizado com sucesso!", "Sucesso", 1);
            InitTable();
        }else {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o item!", "Erro!", 0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        new OptionView(typeFile).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProviderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProviderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProviderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProviderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProviderView(typeFile).setVisible(true);
            }
        });
    }
    
        public void InitTable() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        Vector<String> col = new Vector<String>();
        col.add("Id");
        col.add("Nome");
        col.add("CNPJ");

        if (typeFile == 0) {
            providerBinaryController.read();
            providerBinaryController.genericList.forEach((item) -> {
                Vector<String> tempItem = new Vector<String>();
                Provider provider = (Provider) item;
                tempItem.add(provider.id + "");
                tempItem.add(provider.nome);
                tempItem.add(provider.cnpj);
                data.add(tempItem);
            });            
        }else {
            ArrayList<String> providers = providerController.ReadAll();
            providers.forEach((provider) -> {
                Vector<String> tempItem = new Vector<String>();
                String[] splitedProvider = provider.split(",");
                tempItem.add(splitedProvider[0]);
                tempItem.add(splitedProvider[1]);
                tempItem.add(splitedProvider[2]);
                data.add(tempItem);
            });            
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                data,
                col
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoCnpj;
    private javax.swing.JTextField campoNome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
