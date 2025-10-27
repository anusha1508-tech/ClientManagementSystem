package infosys.client.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import infosys.client.Repository.ClientRepository;
import infosys.client.model.Client;
import infosys.client.service.ClientService;


@RestController
public class ClientController {
	
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/showall")
	public List<Client> showall(){
		//return clientRepository.findAll();
		return clientService.showall();
		
	}
	
    @PostMapping("/add")
    public String addClient(@RequestBody Client newClient) {
    	//clientRepository.save(newClient);
    	clientService.addClient(newClient);
    	return "Client Added Successfully";
    }
	
    @DeleteMapping("/delete/{cid}")
    public String deleteClient(@PathVariable ("cid") int cid) {
    Optional <Client> optionalClient = clientService.searchByClientId(cid);
    	if(optionalClient.isPresent()){
    		clientService.deleteClient(optionalClient.get());
    		return "deleted sucessfully";
    		
    	}
    	else {
    		return "not found";
    	}
    }
    
    @PutMapping("/update")
    public String updateClient(@RequestBody Client newClient) {
   // Optional<Client>optinalClient=clientRepository.findById(newClient.getClientId()); 
    Optional<Client>oldClient=clientService.searchByClientId(newClient.getClientId());
    
    if (oldClient.isPresent()) {
    	
    	clientService.updateClient(oldClient.get(), newClient);

    	
    	//clientRepository.save(oldClient);
    	return "success";
    }else {
    	
    	return "not found";
    }
    	
    }
    

    @GetMapping("/searchbyClientname/{clientName}")
    public List<Client> getByClientName(@PathVariable String clientName){
    	return clientRepository.findByClientName(clientName);
    }
    
	
    @GetMapping("searchIdRange/{min}/{max}")
    public List<Client>getByIdRange(@PathVariable int min, @PathVariable int max){
    	return clientRepository.findByIdRange(min, max);
    }
    
    @GetMapping("searchbynamestartswith/{clientName}")
    public List<Client>getByNameStarts(@PathVariable String clientName){
    	return clientRepository.findByClientNameStartsWith(clientName);
    }

    @GetMapping("/findByNameAndLocation/{prefix}/{location}")
    public List<Client> findByNameAndLocation(@PathVariable String prefix, @PathVariable String location) {
        return clientRepository.findClientsByNameAndLocation(prefix, location);
    }

    @GetMapping("/findByNameORLocation/{prefix}/{location}")
    public List<Client> findByNameORLocation(@PathVariable String prefix, @PathVariable String location) {
        return clientRepository.findClientsByNameORLocation(prefix, location);
    }

    
    }



