package app.trianing.ComandasService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import app.trianing.ComandasService.domain.Client;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Long> , JpaSpecificationExecutor<Client> {

}
