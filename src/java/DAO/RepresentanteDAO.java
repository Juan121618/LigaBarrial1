/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Representante;
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
public class RepresentanteDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    ConexionDB conec = new ConexionDB();

    public List listarrepresentante() {
        ArrayList<Representante> Listar = new ArrayList();
        String sql = "select * from Representante";
        try {
            con = conec.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Representante r = new Representante();
                r.setId(rs.getInt("id"));
                r.setNombre(rs.getString("nombre"));
                r.setUsuario(rs.getString("usuario"));
                r.setContrasena(rs.getString("contrasena"));

                Listar.add(r);
            }
        } catch (Exception e) {
        }

        return Listar;
    }

    public boolean guardarRepresentante(Representante representante) {
        boolean guardado = false;
        String sql = "INSERT INTO Representante (nombre, usuario, contrasena) VALUES (?, ?, ?)";

        try {
            con = conec.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, representante.getNombre());
            ps.setString(2, representante.getUsuario());
            ps.setString(3, representante.getContrasena());

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

    public Representante obtenerRepresentantePorId(int id) {
        Representante representante = null;
        String sql = "SELECT * FROM Representante WHERE id = ?";

        try {
            con = conec.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                representante = new Representante();
                representante.setId(rs.getInt("id"));
                representante.setNombre(rs.getString("nombre"));
                representante.setUsuario(rs.getString("usuario"));
                representante.setContrasena(rs.getString("contrasena"));
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

        return representante;
    }
    
    public boolean actualizarRepresentante(Representante representante) {
    boolean actualizacionExitosa = false;
    String sql = "UPDATE Representante SET nombre=?, usuario=?, contrasena=? WHERE id=?";

    try {
        con = conec.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, representante.getNombre());
        ps.setString(2, representante.getUsuario());
        ps.setString(3, representante.getContrasena());
        ps.setInt(4, representante.getId());

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
    public boolean eliminarRepresentante(int id) {
    boolean eliminacionExitosa = false;
    String sql = "DELETE FROM Representante WHERE id=?";

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
