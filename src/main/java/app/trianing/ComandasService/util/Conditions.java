package app.trianing.ComandasService.util;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class Conditions<T> {

	public Specification<T> equals(String field, Object value) {
		if (Optional.ofNullable(value).isEmpty()) {
			return null;
		} else {
			return (root, query, criteria) -> {
				return criteria.equal(root.get(field), value);
			};
		}
	}
	
	public Specification<T> like(String field, String value) {
		if (Optional.ofNullable(value).isEmpty()) {
			return null;
		} else {
			return (root, query, criteria) -> {
				return criteria.like(criteria.lower(root.get(field)) ,"%" + value.toLowerCase() + "%");
			};
		}
	}
}
