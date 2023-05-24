package Interfaces;

import Modelo.Productos;
import java.util.List;

public interface CRUD {
    public List listar();
    public Productos list(int id);
    public boolean add(Productos pro);
    public boolean edit(Productos pro);
    public boolean eliminar(int id);
    
}
