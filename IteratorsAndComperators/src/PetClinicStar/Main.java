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
            switch (command[0]){
                case "Create":
                    if (command[1].equals ("Pet")){
                        Pet pet = new Pet (command[2],Integer.parseInt (command[3]),command[4]);
                        pets.add (pet);
                    }else if (Integer.parseInt (command[3])%2!=0){
                        clinic = new Clinic (command[2],Integer.parseInt (command[3]) );
                        clinics.add (clinic);

                    }break;
                case "HasEmptyRooms":
                    String clinicName = command[1];
                    for (Clinic cli : clinics) {
                        if (cli.getName ().equals (clinicName)){
                            System.out.println (cli.hasEmptyRoom ());
                        }
                    }


                    break;
            }

        }
        System.out.println ();
    }
}
