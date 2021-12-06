package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerService {

	// Dependencia
	private SellerDao dao = DaoFactory.createSellerDao();

	// Retorna uma lista de Seller
	public List<Seller> findAll() {
		return dao.findAll();
	}

	// Verifica se precisa inserir ou atualizar um objeto Seller no banco de dados
	public void saveOrUpdate(Seller obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		} else {
			dao.update(obj);
		}
	}

	public void remove(Seller obj) {
		dao.deleteById(obj.getId());
	}
}
