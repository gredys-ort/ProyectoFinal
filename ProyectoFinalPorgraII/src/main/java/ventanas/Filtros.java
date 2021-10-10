/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import conexion.ClsConexion;
import datos.ClsFavoritos;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelos.Pokemones;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Favorito;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Wcastañeda
 */
public class Filtros extends javax.swing.JFrame {

    /**
     * Creates new form Filtros
     */
    public Filtros() {
        initComponents();
        MostrarFiltros(0, null);
        buttonEnviarCorreo.setEnabled(false);
    }

    public void MostrarFiltros(int buscar, String condicion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("id");
        tabla.addColumn("name");
        tabla.addColumn("species");
        tabla.addColumn("color");
        tabla.addColumn("habitat");
        tabla.addColumn("gender_rate");
        tabla.addColumn("capture_rate");
        tabla.addColumn("base_experience");
        tabla.addColumn("forme_name");
        tableFiltros.setModel(tabla);

        String sql;
        if (buscar == 0 && condicion == null) {
            sql = "select * from pokemon";
        } else {
            if (buscar == 1 && condicion != null) {
                sql = "select * from pokemon where id = " + condicion;
            } else {
                if (buscar == 2 && condicion != null) {
                    sql = "select * from pokemon where name = '" + condicion + "'";
                } else {
                    if (buscar == 3 && condicion != null) {
                        sql = "select * from pokemon where species = '" + condicion + "'";
                    } else {
                        if (buscar == 4 && condicion != null) {
                            sql = "select * from pokemon where color = '" + condicion + "'";
                        } else {
                            if (buscar == 5 && condicion != null) {
                                sql = "select * from pokemon where habitat = '" + condicion + "'";
                            } else {
                                if (buscar == 6 && condicion != null) {
                                    sql = "select * from pokemon where gender_rate = '" + condicion + "'";
                                } else {
                                    if (buscar == 7 && condicion != null) {
                                        sql = "select * from pokemon where capture_rate = '" + condicion + "'";
                                    } else {
                                        if (buscar == 8 && condicion != null) {
                                            sql = "select * from pokemon where base_experience = '" + condicion + "'";
                                        } else {
                                            if (buscar == 9 && condicion != null) {
                                                sql = "select * from pokemon where forme_name = '" + condicion + "'";
                                            } else {
                                                sql = "select * from pokemon";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            String[] datos = new String[9];

            try {
                conn = ClsConexion.getConnection();
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                int contador = 0;
                while (rs.next()) {
                    contador++;
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(12);
                    datos[3] = rs.getString(13);
                    datos[4] = rs.getString(15);
                    datos[5] = rs.getString(16);
                    datos[6] = rs.getString(17);
                    datos[7] = rs.getString(18);
                    datos[8] = rs.getString(3);
                    tabla.addRow(datos);
                }
                tableFiltros.setModel(tabla);
                JOptionPane.showMessageDialog(null, "Datos Encontrados " + contador);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            } finally {
                ClsConexion.close(rs);
                ClsConexion.close(stmt);
                ClsConexion.close(conn);
            }

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFiltrarPokemonesPorColor = new java.awt.Label();
        FiltarPorColor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFiltros = new javax.swing.JTable();
        buttonGenerarReporte = new javax.swing.JButton();
        buttonFiltrarPorColor = new javax.swing.JButton();
        txtCondicion = new javax.swing.JTextField();
        buttonEnviarCorreo = new javax.swing.JButton();
        lblId = new java.awt.Label();
        lblCorreo = new java.awt.Label();
        buttonMenuAnterior = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFiltrarPokemonesPorColor.setText("Aplicar Filtro");

        FiltarPorColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "id", "name", "species", "color", "habitat", "gender_rate", "capture_rate", "base_experience", "forme_name" }));
        FiltarPorColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltarPorColorActionPerformed(evt);
            }
        });

        tableFiltros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableFiltros);

        buttonGenerarReporte.setText("Generar reporte");
        buttonGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerarReporteActionPerformed(evt);
            }
        });

        buttonFiltrarPorColor.setText("Mostrar");
        buttonFiltrarPorColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiltrarPorColorActionPerformed(evt);
            }
        });

        buttonEnviarCorreo.setText("Enviar Reporte por Email");
        buttonEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnviarCorreoActionPerformed(evt);
            }
        });

        buttonMenuAnterior.setLabel("Menu Anterior");
        buttonMenuAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenuAnteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(lblFiltrarPokemonesPorColor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FiltarPorColor, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(txtCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonFiltrarPorColor, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(532, 532, 532)
                                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonMenuAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonEnviarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(362, 362, 362)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FiltarPorColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonFiltrarPorColor)
                        .addComponent(txtCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFiltrarPokemonesPorColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonMenuAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonEnviarCorreo)
                                .addComponent(buttonGenerarReporte)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FiltarPorColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltarPorColorActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_FiltarPorColorActionPerformed

    public void generarReporte() {
        List listado = new ArrayList();
        for (int i = 0; i < tableFiltros.getRowCount(); i++) {
            Pokemones tipo = new Pokemones(tableFiltros.getValueAt(i, 0).toString(),
                    tableFiltros.getValueAt(i, 1).toString(), tableFiltros.getValueAt(i, 2).toString(),
                    tableFiltros.getValueAt(i, 3).toString(), tableFiltros.getValueAt(i, 4).toString(),
                    tableFiltros.getValueAt(i, 5).toString(), tableFiltros.getValueAt(i, 6).toString(),
                    tableFiltros.getValueAt(i, 7).toString(), tableFiltros.getValueAt(i, 8).toString());
            listado.add(tipo);
        }
        Connection conexion = null;
        try {
            conexion = ClsConexion.getConnection();
            JasperReport reporte = null;
            String path = "src\\main\\java\\reporte\\nuevoReporte2.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map Parametro = new HashMap();
            Parametro.put("opc", FiltarPorColor.getSelectedItem().toString());
            Parametro.put("filtro", txtCondicion.toString());
            JasperPrint jprint = JasperFillManager.fillReport(reporte, Parametro, new JRBeanCollectionDataSource(listado));
            JasperViewer.viewReport(jprint);
            JRExporter exportar = new JRPdfExporter();
            exportar.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
            exportar.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("C:\\Users\\PC\\Desktop\\Descargas\\Reporte\\nuevoReporte2.pdf"));
            exportar.exportReport();
            buttonEnviarCorreo.setEnabled(true);
        } catch (JRException | SQLException ex) {
            ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, "Error al Convertir Reporte.");
        }

    }
    private void buttonGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerarReporteActionPerformed
        generarReporte();
    }//GEN-LAST:event_buttonGenerarReporteActionPerformed
    int correlativo, id_pokemon, id_usuario;
    String nombre_usuario, preferencia, correo;

    public void BuscarCorreo() {
        ClsFavoritos favorito = new ClsFavoritos();
        int Busqueda = Integer.parseInt(JOptionPane.showInputDialog("Escriba Id Usuario"));
        List<Favorito> favoritos = favorito.favoritos(Busqueda);
        if (favoritos == null) {
            JOptionPane.showMessageDialog(null, "No valido", "Adv", JOptionPane.WARNING_MESSAGE);
        } else {
            for (Favorito fav : favoritos) {
                id_usuario = fav.getId_usuario();
                correo = fav.getCorreo();
            }
            lblId.setText(id_usuario + "");
            lblCorreo.setText(correo);
        }
    }
    private void buttonFiltrarPorColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltrarPorColorActionPerformed
        int opc = FiltarPorColor.getSelectedIndex();
        String valor = txtCondicion.getText();
        MostrarFiltros(opc, valor);
    }//GEN-LAST:event_buttonFiltrarPorColorActionPerformed

    private void buttonEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnviarCorreoActionPerformed
        BuscarCorreo();
        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", true);
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", true);
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            Session session = Session.getInstance(props);

            String correoRemitente = "proyectofinalprogra2021@gmail.com";
            String passwordRemitente = "ProyectoFinal2021";
            String correoReceptor = correo;
            String asunto = "Filtro Pokemon Aplicado";
            String mensaje = "Reporte de Pokemones";
            String file = "C://Users//PC//Desktop//Descargas//Reporte//nuevoReporte2.pdf";

            BodyPart cuerpo = new MimeBodyPart();
            cuerpo.setText(mensaje);
            BodyPart adjuntar = new MimeBodyPart();
            adjuntar.setDataHandler(new DataHandler(new FileDataSource(file)));
            File archivo = new File(file);
            adjuntar.setFileName(archivo.getName());

            MimeMultipart mul = new MimeMultipart();
            mul.addBodyPart(cuerpo);
            mul.addBodyPart(adjuntar);

            MimeMessage msj = new MimeMessage(session);
            msj.setFrom(new InternetAddress(correoRemitente));

            msj.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            msj.setSubject(asunto);
            msj.setContent(mul);

            Transport transportar = session.getTransport("smtp");
            transportar.connect(correoRemitente, passwordRemitente);
            transportar.sendMessage(msj, msj.getRecipients(Message.RecipientType.TO));
            transportar.close();

            JOptionPane.showMessageDialog(null, "E-mail Enviado Con exito");

        } catch (AddressException ex) {
            JOptionPane.showMessageDialog(null, "Lo siento, Hubo un error");
            Logger.getLogger(Filtros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "Lo siento, Hubo un error");
            Logger.getLogger(Filtros.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_buttonEnviarCorreoActionPerformed

    private void buttonMenuAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenuAnteriorActionPerformed
        setVisible(false);
        Busquedas busqueda = new Busquedas();
        busqueda.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMenuAnteriorActionPerformed

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
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filtros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> FiltarPorColor;
    private javax.swing.JButton buttonEnviarCorreo;
    private javax.swing.JButton buttonFiltrarPorColor;
    private javax.swing.JButton buttonGenerarReporte;
    private java.awt.Button buttonMenuAnterior;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label lblCorreo;
    public java.awt.Label lblFiltrarPokemonesPorColor;
    private java.awt.Label lblId;
    public javax.swing.JTable tableFiltros;
    public javax.swing.JTextField txtCondicion;
    // End of variables declaration//GEN-END:variables
}
