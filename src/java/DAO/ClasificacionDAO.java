/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Clasificacion;
import conexion.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class ClasificacionDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    ConexionDB conec = new ConexionDB();

    public List listarclasificacion() {
        ArrayList<Clasificacion> Listar = new ArrayList();
        String sql = "select * from Usuarios";
        try {
            con = conec.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clasificacion c = new Clasificacion();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setUsuario(rs.getString("usuario"));
                c.setContrasena(rs.getString("contrasena"));

                Listar.add(c);
            }
        } catch (Exception e) {
        }

        return Listar;
    }

    public boolean guardarClasificacion(Clasificacion clasificacion) {
        boolean guardado = false;
        String sql = "INSERT INTO Usuarios (nombre, usuario, contrasena) VALUES (?, ?, ?)";

        try {
            con = conec.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, clasificacion.getNombre());
            ps.setString(2, clasificacion.getUsuario());
            ps.setString(3, clasificacion.getContrasena());

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                guardado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return guardado;
    }

    public Clasificacion obtenerUsuarioPorId(int id) {
        Clasificacion usuario = null;
        String sql = "SELECT * FROM Usuarios WHERE id = ?";

        try {
            con = conec.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Clasificacion();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return usuario;
    }
    
    public boolean actualizarUsuario(Clasificacion usuario) {
    boolean actualizacionExitosa = false;
    String sql = "UPDATE Usuarios SET nombre=?, usuario=?, contrasena=? WHERE id=?";

    try {
        con = conec.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getUsuario());
        ps.setString(3, usuario.getContrasena());
        ps.setInt(4, usuario.getId());

        int resultado = ps.executeUpdate();

        if (resultado > 0) {
            actualizacionExitosa = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return actualizacionExitosa;
}
    public boolean eliminarUsuario(int id) {
    boolean eliminacionExitosa = false;
    String sql = "DELETE FROM Usuarios WHERE id=?";

    try {
        con = conec.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int resultado = ps.executeUpdate();

        if (resultado > 0) {
            eliminacionExitosa = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return eliminacionExitosa;
}


}
