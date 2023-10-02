package pet.store.entity;


import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;

import org.springframework.boot.autoconfigure.cache.CacheType;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import nonapi.io.github.classgraph.json.Id;


@EntityScan
@Data

public class PetStore {
	
	private static final String GenerationType = null;

	//Identifies the primary key for the pet_store table
	@Id
	@GeneratedValue(Strategy = GenerationType.IDENTITY)
	private Long petStoreId;
	
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private Long petStoreZip;
	private String petStorePhone;
	
	//Many to many relationship with customer. Joins the tables by a join table.
	//pet_store_customer via pet_store_id and customer_id
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CacheType.PERSIST)
	@JoinTable(name = "pet store customer", 
	joinColumns = @JoinColumn(name = "pet_store_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
	private Set<Customer> customers = new HashSet<>();
	
	//One to many relationship with employee table. One pet store has multiple employees.
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "petStore", cascade = CacheType. All, orphanRemoval = true)
	private Set<Employee> employees = new HashSet<>();
}


}
