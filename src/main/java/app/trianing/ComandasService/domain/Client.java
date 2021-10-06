package app.trianing.ComandasService.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CLIENTE")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CD_CLIENTE")
	private Long id;
	
	@Column(name = "DS_CLIENTE")
	private String name;
	
	@Column(name = "NM_CPF")
	private Long cpf;
	
	@Column(name = "DT_NASC")
	private LocalDate dateOfBirth;
	
}
