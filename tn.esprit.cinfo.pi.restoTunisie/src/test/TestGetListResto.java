package test;
import service.dao.RestoDAO;

public class TestGetListResto {
	public static void main(String[] args) {
		RestoDAO restoDAO = new RestoDAO();
		restoDAO.findAll();
	}
}
