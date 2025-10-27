package infosys.client.service;

import org.springframework.beans.factory.annotation.Autowired;

import infosys.client.Repository.ClientRepository;
import infosys.client.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	public Optional <Client> searchByClientId(int clientId){
		return clientRepository.findById(clientId);
		
		
	}
	
	public List<Client> showall(){
		return clientRepository.findAll();
	}
	
	public void addClient(Client client) {
		clientRepository.save(client);
		
	}
	
	public void deleteClient(Client client) {
		clientRepository.delete(client);
	}
	
	
	public void updateClient(Client oldClient,Client newClient) {
		oldClient.setClientName(newClient.getClientName());
		oldClient.setClientAddress(newClient.getClientAddress());
		oldClient.setClientMail(newClient.getClientMail());
		clientRepository.save(oldClient);
	}

	
}
