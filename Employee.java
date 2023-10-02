package pet.store.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.ToString;
import nonapi.io.github.classgraph.json.Id;

@EntityScan
@Data

public class Employee {
	
	private static final String GenerationType = null;

	private static final String CascadeType = null;

	//Identifies the primary key for the employee table
	@Id
	@Generated(Strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	private String employeeFirstName;
	private String employeeLastName;
	private String employeePhone;
	private String employeeJobTitle;
	
	//Many to one relationship with pet_store(one pet store has multiple employees)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.All)
	//Joins tables by pet_store_id
	@JoinColumn(name = "pet_store_id")
	private PetStore petstore;
	

}
