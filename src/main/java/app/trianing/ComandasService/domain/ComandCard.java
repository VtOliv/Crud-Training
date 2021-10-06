package app.trianing.ComandasService.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "TB_COMANDA")
public class ComandCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CD_COMANDA")
	private Long id;
	
	@Column(name = "DS_COMANDA")
	private String name;
	
	@OneToMany
	@JoinColumn(name = "CD_PRODUTO")
	private Set<Products> productCode;
	

}
