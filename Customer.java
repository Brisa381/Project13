package pet.store.entity;

import java.util.HashSet;
import lombok.Data;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.math.BigDecimal;

import org.springframework.boot.autoconfigure.cache.CacheType;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.ToString;
import nonapi.io.github.classgraph.json.Id;

import org.springframework.http.HttpStatus;

@EntityScan
@Data
public class Customer {
	
	private static final String GenerationType = null;

	//Identifies the primary key for the customer table
	@Id
	@Generated(Strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	
	//Many to many relationship with pet_stores(one customer can use many pet stores and vice versa)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "customers", cascade = CacheType.PERSIST)
	private Set<PetStore> petStores = new LinkedHashSet<>();
}

	

}
