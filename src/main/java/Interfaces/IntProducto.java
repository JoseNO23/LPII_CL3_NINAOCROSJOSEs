package Interfaces;

import java.util.List;
import Model.TblProductocl3;

public interface IntProducto {
	public void RegistrarProducto(TblProductocl3 producto);
	public List<TblProductocl3> ListarProducto();
}
