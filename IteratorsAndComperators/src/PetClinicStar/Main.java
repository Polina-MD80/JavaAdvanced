package PetClinicStar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        List<Pet> pets = new ArrayList<> ();
        List<Clinic> clinics = new ArrayList<> ();
        Clinic clinic;

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine ().split ("\\s+");
            String clinicName;
            switch (command[0]){
                case "Create":
                    if (command[1].equals ("Pet")){
                        Pet pet = new Pet (command[2],Integer.parseInt (command[3]),command[4]);
                        pets.add (pet);
                    }else if (Integer.parseInt (command[3])%2!=0){
                        clinic = new Clinic (command[2],Integer.parseInt (command[3]) );
                        clinics.add (clinic);

                    }else if (Integer.parseInt (command[3])%2==0){
                        System.out.println ("Invalid Operation!");
                    }
                    break;
                case "HasEmptyRooms":
                    clinicName = command[1];
                    for (Clinic cli : clinics) {
                        if (cli.getName ().equals (clinicName)){
                            System.out.println (cli.hasEmptyRooms ());
                        }
                    }

                    break;
                case "Release":
                    clinicName = command[1];
                    for (Clinic cli : clinics) {
                        if (cli.getName ().equals (clinicName)){
                            System.out.println (cli.releasePet ());
                        }
                    }break;
                case "Add":
                    Pet petToAdd = null;
                    for (Pet pet : pets) {
                        if (pet.getName ().equals (command[1])){
                            petToAdd = pet;break;
                        }
                    }
                    for (Clinic cli : clinics) {
                     if(cli.getName ().equals (command[2])){
                            System.out.println (cli.addPet (petToAdd));
                        }break;
                    }break;
                case "Print":
                    clinicName = command[1];
                    if (command.length==3){
                        int roomNumber = Integer.parseInt (command[2])-1;
                        for (Clinic cli : clinics) {
                            if (cli.getName ().equals (clinicName)){
                                if (cli.getRooms ()[roomNumber] == null){
                                    System.out.println ("Room empty");
                                }else {
                                    System.out.println (cli.getRooms ()[roomNumber]);
                                }
                            }
                        }
                    }
                    else for (Clinic cli : clinics) {
                        for (Pet room : cli.getRooms ()) {
                            if (room == null){
                                System.out.println ("Room empty");
                            }else {
                                System.out.println (room);
                            }
                        }
                    }break;
            }

        }
        System.out.println ();
    }
}
