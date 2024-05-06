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
    ConexionDB conec=new ConexionDB();
    
    public List listarclasificacion(){
        ArrayList<Clasificacion> Listar=new ArrayList();
        String sql= "select * from Usuarios";
        try {
            con = conec.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Clasificacion c= new Clasificacion();
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
}
