package infosys.client.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="client_details")
public class Client {
    @Id
	private int clientId;
	private String clientName;
	private String clientMail;
	private String clientAddress;
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientMail() {
		return clientMail;
	}
	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	
	
}
