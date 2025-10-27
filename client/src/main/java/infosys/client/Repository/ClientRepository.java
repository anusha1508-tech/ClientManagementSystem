package infosys.client.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import infosys.client.model.Client;



public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	List<Client> findByClientName(String clientName);
	
	@Query(value="select c from Client as c where c.clientId between:minValue and :maxValue")
	List<Client> findByIdRange(@Param("minValue")int minValue,@Param("maxValue")int maxValue);
	
	@Query(value="select c from Client as c where c.clientName like ?1%")
	List<Client> findByClientNameStartsWith(String clientName);
	
	
	@Query("SELECT c FROM Client c WHERE c.clientName LIKE CONCAT(:prefix, '%') AND c.clientAddress = :location")
	List<Client> findClientsByNameAndLocation(@Param("prefix") String prefix, @Param("location") String location);

	@Query("SELECT c FROM Client c WHERE c.clientName LIKE CONCAT(:prefix, '%') OR c.clientAddress = :location")
	List<Client> findClientsByNameORLocation(@Param("prefix") String prefix, @Param("location") String location);

	
	
	

}