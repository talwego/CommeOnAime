package Sopra.DiscuissonAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class InstructionRecette {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Recette recette;
	@Column(columnDefinition = "text")
	private String instruction;

	public InstructionRecette() {
		
	}
	
	public InstructionRecette(Recette recette, String instruction) {
		super();
		this.recette = recette;
		this.instruction = instruction;
	}

	public InstructionRecette(Integer id, Recette recette, String instruction) {
		super();
		this.id = id;
		this.recette = recette;
		this.instruction = instruction;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	@Override
	public String toString() {
		return "InstructionRecette [id=" + id + ", instruction=" + instruction + "]";
	}
}
