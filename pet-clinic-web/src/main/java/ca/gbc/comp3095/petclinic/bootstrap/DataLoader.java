package ca.gbc.comp3095.petclinic.bootstrap;

import ca.gbc.comp3095.petclinic.model.Owner;
import ca.gbc.comp3095.petclinic.model.PetType;
import ca.gbc.comp3095.petclinic.model.Vet;
import ca.gbc.comp3095.petclinic.services.OwnerService;
import ca.gbc.comp3095.petclinic.services.PetTypeService;
import ca.gbc.comp3095.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;
    private PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Saad");
        owner1.setLastName("Brunssen");

        Owner owner2= new Owner();
        owner2.setFirstName("Bruce");
        owner2.setLastName("Wayne");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("owners loaded");
        System.out.println(owner1);
        System.out.println(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Jessica");
        vet1.setLastName("Oblong");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Trust");
        vet2.setLastName("Smith");
        vetService.save(vet2);

        System.out.println("Vets loaded");
        System.out.println(vet1);
        System.out.println(vet2);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        System.out.println("All pet types");
        Iterator<PetType> petTypes = petTypeService.findAll().iterator();

        while(petTypes.hasNext()){
            System.out.println(petTypes.next().getName());
        }





    }
}
