package ca.gbc.comp3095.petclinic.bootstrap;

import ca.gbc.comp3095.petclinic.model.*;
import ca.gbc.comp3095.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;
    private PetTypeService petTypeService;
    private SpecialtiesService specialtiesService;
    private VisitService visitService;
    private PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0){
            loadData();
        }


    }

    private void loadData() {
        Owner owner1 = new Owner();
        owner1.setFirstName("Saad");
        owner1.setLastName("Brunssen");
        owner1.setAddress("First street in mars");
        owner1.setCity("Toronto");
        owner1.setTelephone("324235534");

        Owner owner2= new Owner();
        owner2.setFirstName("Bruce");
        owner2.setLastName("Wayne");
        owner2.setAddress("Second street in Japan");
        owner2.setCity("Vancouver");
        owner2.setTelephone("1243637");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("owners loaded");
        System.out.println(owner1);
        System.out.println(owner2);


        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty savedRadiology = specialtiesService.save(radiology);
        Specialty savedDentistry = specialtiesService.save(dentistry);
        Specialty savedSurgery = specialtiesService.save(surgery);


        Vet vet1 = new Vet();
        vet1.setFirstName("Jessica");
        vet1.setLastName("Oblong");
        Set<Specialty> specialties = vet1.getSpecialties();
        specialties.add(radiology);
        vet1.setSpecialties(specialties);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Trust");
        vet2.setLastName("Smith");

        Set<Specialty> specialties2 = vet2.getSpecialties();
        specialties2.add(surgery);
        vet2.setSpecialties(specialties2);


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

        Pet frodosPet = new Pet();
        frodosPet.setPetType(saveDogPetType);
        frodosPet.setName("yasha");
        frodosPet.setOwner(owner1);
        frodosPet.setBirthdate(LocalDate.now());
        owner1.getPets().add(frodosPet);
        System.out.println("pets for owner1");
        owner1.getPets().forEach(pet-> {
            System.out.println(pet.getName());
        });
        petService.save(frodosPet);
        ownerService.save(owner1);


        Visit catVisit = new Visit();
        catVisit.setPet(frodosPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Frodos pet was sick");

        visitService.save(catVisit);

    }
}
