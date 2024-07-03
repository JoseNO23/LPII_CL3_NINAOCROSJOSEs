package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TblProductoImp;
import Model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblProductocl3 cliente = new TblProductocl3();
		TblProductoImp crud = new TblProductoImp();
		List<TblProductocl3> listadoproducto =crud.ListarProducto();
		//ASIGNAMOS EL LISTADO DE CLIENTES RECUPERADOS DE LA BD
		request.setAttribute("ListadoProductos", listadoproducto);
		
		request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//RECUPERAMOS LOS DATOS DEL FORMULARIO
		String nombre = request.getParameter("nombrecl3");
		double precioVen = Double.parseDouble(request.getParameter("precioventacl3"));
		double precioCom =Double.parseDouble(request.getParameter("preciocompcl3"));
		String estado = request.getParameter("estadocl3");
		String descripcion = request.getParameter("descripcl3");
		
		//INSTANCIAMOS LAS RESPECTIVAS CLASES
		TblProductocl3 prod = new TblProductocl3();
		TblProductoImp crud = new TblProductoImp();
		//ASIGNAMOS LOS VALORES
		prod.setNombrecl3(nombre);
		prod.setPrecioventacl3(precioVen);;
		prod.setPreciocompcl3(precioCom);
		prod.setEstadocl3(estado);;
		prod.setDescripcl3(descripcion);
		
		//INVOCAMOS EL METEODO A REGISTRAR
		crud.RegistrarProducto(prod);
		List<TblProductocl3> listadoproducto=crud.ListarProducto();
	
		//ASIGNAMOS EL LISTADO DE CLIENTES RECUPERADOS DE LA BD
		request.setAttribute("ListadoProductos", listadoproducto);
		//REDIRECCIONAMOS A LISTADO
		request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);
		
	}

}
