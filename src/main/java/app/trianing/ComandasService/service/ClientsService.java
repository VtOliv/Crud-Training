package app.trianing.ComandasService.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import app.trianing.ComandasService.domain.Client;
import app.trianing.ComandasService.domain.dto.ClientDTO;
import app.trianing.ComandasService.repository.ClientsRepository;
import app.trianing.ComandasService.util.Conditions;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientsService extends Conditions<Client> {

	private final ClientsRepository repository;

	public Client create(ClientDTO dto) {

		var client = Client.builder().name(dto.getName()).cpf(dto.getCpf()).dateOfBirth(dto.getDateOfBirth()).build();

		return repository.save(client);
	}
	
	public Client update(ClientDTO dto, Long id) {
		var client = repository.findById(id).orElse(null);
		
		if(!(client == null)) {
			client.setName(dto.getName());
			client.setCpf(dto.getCpf());
			client.setDateOfBirth(dto.getDateOfBirth());
			
			return repository.save(client);
		} else {
			return null;
		}
	}
	
	public Page<Client> search(ClientDTO dto, Pageable pageable) {
		return repository.findAll(Specification.where(equals("id", dto.getId()))
				.and(like("name", dto.getName()))
				.and(equals("cpf", dto.getCpf())), pageable);
	}
}