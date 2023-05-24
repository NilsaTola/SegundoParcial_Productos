package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements CRUD{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Productos p=new Productos();
    
    @Override
    public List listar() {
      ArrayList<Productos>list=new ArrayList<>();
      String sql = "select * from productos";
      try{
          con = cn.getConnection();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while(rs.next()){
              Productos pro = new Productos();
              pro.setId(rs.getInt("id"));
              pro.setDescripcion(rs.getString("descripcion"));
              pro.setCantidad(rs.getInt("cantidad"));
              pro.setPrecio(rs.getFloat("precio"));
              pro.setCategoria(rs.getString("categoria"));
              list.add(pro);
          }
      }catch(Exception e){    
      }
      return list;
    }

    @Override
    public Productos list(int id) {
         String sql = "select * from productos where id="+id;
      try{
          con = cn.getConnection();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while(rs.next()){
              p.setId(rs.getInt("id"));
              p.setDescripcion(rs.getString("descripcion"));
              p.setCantidad(rs.getInt("cantidad"));
              p.setPrecio(rs.getFloat("precio"));
              p.setCategoria(rs.getString("categoria"));
              
          }
      }catch(Exception e){    
      }
      return p;
    }
    
        @Override
    public boolean add(Productos pro) {
        String sql="insert into productos(descripcion,cantidad,precio,categoria)values('"+pro.getDescripcion()+"','"+pro.getCantidad()+"','"+pro.getPrecio()+"','"+pro.getCategoria()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.execute();
        }catch(Exception e){
            
        }
        return false;
    }
    
    @Override
    public boolean edit(Productos pro) {
         String sql="update productos set Descripcion='"+pro.getDescripcion()+"',Cantidad='"+pro.getCantidad()+"',Precio='"+pro.getPrecio()+"',Categoria='"+pro.getCategoria()+"'where id="+pro.getId();
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from productos where Id="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }   
}
