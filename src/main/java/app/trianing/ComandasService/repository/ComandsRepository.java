package app.trianing.ComandasService.repository;

import org.springframework.stereotype.Repository;

import app.trianing.ComandasService.domain.ComandCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface ComandsRepository extends JpaRepository<ComandCard, Long> , JpaSpecificationExecutor<ComandCard> {

}
