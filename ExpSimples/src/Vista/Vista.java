package Vista;

import Controlador.Compuesto;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis David Peralta Gonzalez
 */
public class Vista extends javax.swing.JFrame {
    
    public Vista() {
        initComponents();
        jb2.setEnabled(false);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jl1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jtf1 = new javax.swing.JTextField();
        jb1 = new javax.swing.JButton();
        jb2 = new javax.swing.JButton();
        jbsalir = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(410, 350));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("Probabilidad - 2CV16");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Instituto Politecnico Nacional");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 19));

        jl1.setText("Posibles combinaciones: ");
        getContentPane().add(jl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/claro.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 50));

        jta1.setEditable(false);
        jta1.setColumns(20);
        jta1.setRows(5);
        jScrollPane1.setViewportView(jta1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 380, 190));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Eventos: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 30));
        getContentPane().add(jtf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 40, 30));

        jb1.setText("aceptar");
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });
        getContentPane().add(jb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 30));

        jb2.setText("Nuevo");
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb2ActionPerformed(evt);
            }
        });
        getContentPane().add(jb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 70, 30));

        jbsalir.setText("Salir");
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });
        getContentPane().add(jbsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        
        try {
            int eventos = Integer.valueOf(jtf1.getText());
            Compuesto experimento = new Compuesto(eventos);
            List <List <String>>simples;        //Matriz de exp. simples
            List <String> combinaciones;        //Vector de posibles combinaciones

            experimento.conteo();//Funcion conteo del objeto Compuesto
            
            jl1.setText("Posibles combinaciones: "+experimento.getPosibilidades());
            simples = experimento.getSimples();
            combinaciones = experimento.getCombinaciones();

            jta1.append("\t|EXPERIMENTOS|\n");
            for (int i = 0; i < simples.size(); i++) {
                jta1.append("[E"+(i+1)+"]: | ");
                for (int j = 0; j < simples.get(i).size(); j++) {
                    jta1.append(simples.get(i).get(j)+" |");
                }
                jta1.append("\n");
            }

            jta1.append("\n\t|COMBINACIONES|\n");
            for (int i = 0; i < combinaciones.size(); i++) {//Muestra las combinaciones
            jta1.append(combinaciones.get(i)+"\n");
            }
        
            jtf1.setEnabled(false);
            jb1.setEnabled(false);
            jb2.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Algo salio mal, reinicia el programa", "Arror",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jb1ActionPerformed

    private void jb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb2ActionPerformed
        jtf1.setEnabled(true);
        jb1.setEnabled(true);
        jb2.setEnabled(false);
        
        jtf1.setText(null);
        jta1.setText(null);
        jl1.setText("Posibles combinaciones: ");
    }//GEN-LAST:event_jb2ActionPerformed

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbsalirActionPerformed

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb1;
    private javax.swing.JButton jb2;
    private javax.swing.JButton jbsalir;
    private javax.swing.JLabel jl1;
    private javax.swing.JTextArea jta1;
    private javax.swing.JTextField jtf1;
    // End of variables declaration//GEN-END:variables
}
