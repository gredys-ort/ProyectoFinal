/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import conexion.ClsConexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Pokemones;

/**
 *
 * @author Wcastañeda
 */
public class MisPokemones extends javax.swing.JFrame {

    /**
     * Creates new form MisPokemones
     */
    BufferedImage buffer1 = null;
    Image imagen1 = null;

    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    List<Pokemones> Pokemon = new ArrayList<Pokemones>();

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenPanel.getGraphics();

        g2.drawImage(buffer1, 0, 0, imagenPanel.getWidth(), imagenPanel.getHeight(), null);
    }

    public MisPokemones() {
        initComponents();
        try {
            //imagen1 = ImageIO.read(getClass().getResource("/imagenes/back-white.png"));
            imagen1 = ImageIO.read(new File("D:\\tmp\\datos\\imagenes\\black-white.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        buffer1 = (BufferedImage) imagenPanel.createImage(
                imagenPanel.getWidth(),
                imagenPanel.getHeight());

        Graphics2D g2 = buffer1.createGraphics();

        dibujaElPokemonQueEstaEnLaPosicion(30);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String JDBC_URL = "jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";

            conexion = DriverManager.getConnection(JDBC_URL, "root", "MYSQL2021");
            estado = conexion.createStatement();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Hay error de clase no encontrada");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Hay error de BD");
        }
    }

    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion) {
        int fila = posicion / 31;
        int columna = posicion % 31;

        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);

        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPanel.getWidth(),
                imagenPanel.getHeight());

        g2.drawImage(imagen1,
                0, //posicion X inicial dentro del jpanel 
                0, // posicion Y inicial dentro del jpanel
                imagenPanel.getWidth(), //ancho del jpanel
                imagenPanel.getHeight(), //alto del jpanel
                columna * 96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila * 96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna * 96 + 96, //posicion final X
                fila * 96 + 96, //posicion final Y
                null //si no lo pones no va
        );

        repaint();

    }

    public void MostrarTodos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("correlativo");
        tabla.addColumn("id_pokemon");
        tabla.addColumn("id_usuario");
        tabla.addColumn("nombre_usuario");
        tabla.addColumn("preferencia");
        tabla.addColumn("correo");
        tableFavoritos.setModel(tabla);
        String sql = "select * from tb_favoritos";
        String[] datos = new String[9];

        try {

            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id_pokemon"));
                dibujaElPokemonQueEstaEnLaPosicion(id - 1);
                contador++;
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                tabla.addRow(datos);

                tableFavoritos.setModel(tabla);

                resultadoConsulta = estado.
                        executeQuery("select * from tb_favoritos where id_pokemon = " + id);
                if (resultadoConsulta.next()) {
                    lblNombre.setText(resultadoConsulta.getString(2));
                } else {
                    lblNombre.setText("Este chucho no esta e el pokedex");
                }
            }
            JOptionPane.showMessageDialog(null, "Datos Encontrados ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableFavoritos = new javax.swing.JTable();
        imagenPanel = new javax.swing.JPanel();
        lblNombre = new java.awt.Label();
        buttonMostrar = new java.awt.Button();
        buttonMeGusta = new java.awt.Button();
        buttonNoMeGusta = new java.awt.Button();
        buttonMenuAnterior = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 204, 255));

        tableFavoritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableFavoritos);

        javax.swing.GroupLayout imagenPanelLayout = new javax.swing.GroupLayout(imagenPanel);
        imagenPanel.setLayout(imagenPanelLayout);
        imagenPanelLayout.setHorizontalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        imagenPanelLayout.setVerticalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        lblNombre.setText("-");

        buttonMostrar.setLabel("Mostrar Datos");
        buttonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMostrarActionPerformed(evt);
            }
        });

        buttonMeGusta.setLabel("Me Gusta");
        buttonMeGusta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMeGustaActionPerformed(evt);
            }
        });

        buttonNoMeGusta.setLabel("No Me Gusta");
        buttonNoMeGusta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoMeGustaActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(buttonMeGusta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonNoMeGusta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(82, 82, 82)
                        .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(buttonMenuAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(buttonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonMeGusta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNoMeGusta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(buttonMenuAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMostrarActionPerformed

        MostrarTodos();
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMostrarActionPerformed
    String preferencia;
    private void buttonMeGustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMeGustaActionPerformed
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("correlativo");
        tabla.addColumn("id_pokemon");
        tabla.addColumn("id_usuario");
        tabla.addColumn("nombre_usuario");
        tabla.addColumn("preferencia");
        tabla.addColumn("correo");
        tableFavoritos.setModel(tabla);
        preferencia = "ME GUSTA";
        String sql = "select * from tb_favoritos where preferencia = '" + preferencia + "'";
        String[] datos = new String[9];

        try {

            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                contador++;
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                tabla.addRow(datos);

                tableFavoritos.setModel(tabla);
                indice = Integer.parseInt(rs.getString("id_pokemon"));
                dibujaElPokemonQueEstaEnLaPosicion(indice - 1);

                resultadoConsulta = estado.
                        executeQuery("select * from tb_favoritos where id_pokemon = " + indice);
                if (resultadoConsulta.next()) {
                    lblNombre.setText(resultadoConsulta.getString(2));
                } else {
                    lblNombre.setText("Este chucho no esta e el pokedex");
                }
            }
            JOptionPane.showMessageDialog(null, "Datos Encontrados ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMeGustaActionPerformed

    private void buttonNoMeGustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoMeGustaActionPerformed
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("correlativo");
        tabla.addColumn("id_pokemon");
        tabla.addColumn("id_usuario");
        tabla.addColumn("nombre_usuario");
        tabla.addColumn("preferencia");
        tabla.addColumn("correo");
        tableFavoritos.setModel(tabla);
        preferencia = "NO ME GUSTA";
        String sql = "select * from tb_favoritos where preferencia = '" + preferencia + "'";
        String[] datos = new String[9];

        try {

            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                contador++;
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                tabla.addRow(datos);

                tableFavoritos.setModel(tabla);
                indice = Integer.parseInt(rs.getString("id_pokemon"));
                dibujaElPokemonQueEstaEnLaPosicion(indice - 1);

                resultadoConsulta = estado.
                        executeQuery("select * from tb_favoritos where id_pokemon = " + indice);
                if (resultadoConsulta.next()) {
                    lblNombre.setText(resultadoConsulta.getString(2));
                } else {
                    lblNombre.setText("Este chucho no esta e el pokedex");
                }
            }
            JOptionPane.showMessageDialog(null, "Datos Encontrados ");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
    }//GEN-LAST:event_buttonNoMeGustaActionPerformed
    int contador;
    int indice;
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
            java.util.logging.Logger.getLogger(MisPokemones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MisPokemones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MisPokemones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MisPokemones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MisPokemones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button buttonMeGusta;
    private java.awt.Button buttonMenuAnterior;
    private java.awt.Button buttonMostrar;
    private java.awt.Button buttonNoMeGusta;
    private javax.swing.JPanel imagenPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label lblNombre;
    private javax.swing.JTable tableFavoritos;
    // End of variables declaration//GEN-END:variables
}
