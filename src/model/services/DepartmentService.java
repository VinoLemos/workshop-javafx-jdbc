package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {

	// Dependencia
	private DepartmentDao dao = DaoFactory.createDepartmentDao();

	// Retorna uma lista de Department
	public List<Department> findAll() {
		return dao.findAll();
	}

	// Verifica se precisa inserir ou atualizar um objeto Department no banco de dados
	public void saveOrUpdate(Department obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		} else {
			dao.update(obj);
		}
	}

}
