package test;
import service.dao.ClientDAO;
import domain.Client;

public class TestAddClient {
	
	static Client client = new Client("souhaib", "souhaib@gmail.com", "52630213");
	static ClientDAO clientDAO = new ClientDAO();
	public static void main(String[] args) {
		clientDAO.save(client);
	}
	
	
}
