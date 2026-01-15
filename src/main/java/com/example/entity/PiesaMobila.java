package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "piese_mobilier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PiesaMobila {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int cod_produs;
	
	private String denumire;
	private String material;
	private String culoare;
	
	@Override
	public String toString() {
		return "PiesaMobila [cod_produs=" + cod_produs + ", denumire=" + denumire + ", material=" + material
				+ ", culoare=" + culoare + "]";
	}

	
	

}
