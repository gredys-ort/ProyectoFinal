/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import conexion.ClsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Favorito;

/**
 *
 * @author Wcastañeda
 */
public class ClsFavoritos {

    public List<Favorito> favoritos(int id) {
        List<Favorito> favoritos = new ArrayList<Favorito>();
        Connection cn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            cn = ClsConexion.getConnection();
            stmt = cn.prepareStatement("SELECT * FROM tb_favoritos where id_usuario = " + id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int correlativo = rs.getInt("correlativo");
                int id_pokemon = rs.getInt("id_pokemon");
                int id_usuario = rs.getInt("id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String preferencia = rs.getString("preferencia");
                String correo = rs.getString("correo");

                Favorito favorito = new Favorito();
                favorito.setCorrelativo(correlativo);
                favorito.setId_pokemon(id_pokemon);
                favorito.setId_usuario(id_usuario);
                favorito.setNombre_usuario(nombre_usuario);
                favorito.setPreferencia(preferencia);
                favorito.setCorreo(correo);
                favoritos.add(favorito);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(cn);
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
        }
        return favoritos;
    }
}
