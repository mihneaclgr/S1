package com.example;

import java.util.List;
import com.example.entity.*;
import com.example.repository.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private PiesaMobilaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public void run(String... args) throws Exception {
		
		//============================= a ====================================
		// Preluarea datelor într-o colecție de tip List<PiesaMobila>
        List<PiesaMobila> piese = repository.findAll();

        // Afișare folosind o expresie Lambda
        piese.forEach(p -> System.out.println(p));
        //====================================================================
        
        
        //============================= b ====================================
        // Subpunctul b) Adăugare piesă nouă de la tastatură
        // b) Adăugare piesă (folosind doar nextLine() pentru a evita erorile de buffer)
        System.out.println("\n--- ADAUGARE PIESA NOUA ---");
        System.out.print("Denumire: ");
        Scanner scanner = new Scanner(System.in);
        String denumire = scanner.nextLine();
        
        System.out.print("Material: ");
        String material = scanner.nextLine();
        
        System.out.print("Culoare: ");
        String culoare = scanner.nextLine();

        PiesaMobila piesa = new PiesaMobila();
        piesa.setDenumire(denumire);
        piesa.setMaterial(material);
        piesa.setCuloare(culoare);
        piese.add(piesa);
        repository.save(piesa);
        System.out.println("Salvare reusita!");
        
        // Afișare folosind o expresie Lambda
        piese.forEach(p -> System.out.println(p));
        
        //==========================================================
        
        //========================= c ==============================
        // c) Ștergere piesă după cod
        System.out.println("\n--- Punctul C: Stergere piesa dupa cod ---");
        System.out.print("Introduceti codul piesei de sters: ");
        int codSters = Integer.parseInt(scanner.nextLine());

        if (repository.existsById(codSters)) {
            repository.deleteById(codSters);
            System.out.println("Piesa cu codul " + codSters + " a fost stearsa.");
        } else {
            System.out.println("Eroare: Piesa cu codul " + codSters + " nu exista in tabel.");
        }

        // Afișare finală pentru verificare
        System.out.println("\nLista finala:");
        repository.findAll().forEach(System.out::println);
        //===========================================================
        
        
        //========================= d ========================================
        System.out.println("\n--- Afisare dupa material\nIntroduceti materialul");
        String materialCautat = scanner.nextLine();
        long nrPiese = repository.findByMaterial(materialCautat).size();
        System.out.println("Numarul de piese din materialul " + materialCautat + " este: " + nrPiese);
        
        
        
    }

}
