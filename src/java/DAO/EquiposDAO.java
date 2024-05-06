package DAO;

import Modelo.Equipos;
import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EquiposDAO {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;
    private ConexionDB conec = new ConexionDB();

    public List<Equipos> listarEquiposConNombreRepresentante() {
        List<Equipos> listaEquipos = new ArrayList<>();
        String sql = "SELECT Equipos.id, Equipos.nombre, Equipos.ano_fundacion, Equipos.colores, "
                + "Equipos.imagen_escudo, Usuarios.nombre AS nombre_representante "
                + "FROM Equipos "
                + "LEFT JOIN Usuarios ON Equipos.id_representante = Usuarios.id";
        try {
            con = conec.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Equipos equipo = new Equipos();
                equipo.setId(rs.getInt("id"));
                equipo.setNombre(rs.getString("nombre"));
                equipo.setAnoFundacion(rs.getInt("ano_fundacion"));
                equipo.setColores(rs.getString("colores"));
                equipo.setImagenEscudo(rs.getString("imagen_escudo"));
                equipo.setNombreRepresentante(rs.getString("nombre_representante")); // Asignamos el nombre del representante

                listaEquipos.add(equipo);
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
        return listaEquipos;
    }

    // Métodos para guardar, actualizar y eliminar equipos según sea necesario
}
