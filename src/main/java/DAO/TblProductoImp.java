package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IntProducto;
import Model.TblProductocl3;

public class TblProductoImp implements IntProducto{

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		EntityManagerFactory em=Persistence.createEntityManagerFactory("PLII_cl3_NinaOcrosJose");
		EntityManager emanager= em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(producto);
		System.out.println("Producto Registrado en la base de datos");
		emanager.getTransaction().commit();
		emanager.close();
	}

	@Override
	public List<TblProductocl3> ListarProducto() {
		EntityManagerFactory fab= Persistence.createEntityManagerFactory("PLII_cl3_NinaOcrosJose");
		EntityManager em= fab.createEntityManager();
		em.getTransaction().begin();
		List<TblProductocl3> listado=em.createQuery("select c from TblProductocl3 c", TblProductocl3.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listado;
	}
}
