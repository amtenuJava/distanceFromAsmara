package dev;
/*

       Distance of Cities Ordered by distance from Asmara,Eritrea
       __________________________________________________________

 -  Used ListIterator to move forward and backward
 -  need to create type that has a town and distance
 -  created a linkedList , ordered by the distance from Asmara
 -  No duplicated allowed

     Asmara <-> Mendefera   = 51kms
            <-> Dekemhare   = 40kms
            <-> Keren   = 93kms
            <-> Massawa   = 112kms
            <-> Adi Tekelezan   = 40kms
            <-> Duba Ruba   = 30kms
            <-> Tesseney   = 359kms
            <-> Senafe   = 132kms
            <-> Assab   = 1065kms
            <-> Nakfa   = 249kms

 - create menu options

  Available actions (select word or letter):
    (F)orward
    (B)ackwards
    (L)ist Places
    (M)enu
    (Q)uit

 */

import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance) {
    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }
}


public class LinkedListChallenge {

    public static void main(String[] args) {
        LinkedList<Place> citiesToVisit = new LinkedList<>();
        Place keren = new Place("Keren", 93);

        addCity(citiesToVisit, keren);

        addCity(citiesToVisit, new Place("Mendefera", 51));
        addCity(citiesToVisit, new Place("Senafe", 130));
        addCity(citiesToVisit, new Place("Assab", 1065));
        addCity(citiesToVisit, new Place("Tesseney", 359));
        addCity(citiesToVisit, new Place("Dekemhare", 40));
        addCity(citiesToVisit, new Place("Duba Ruba", 30));
        addCity(citiesToVisit, new Place("Adi Tekelezan", 40));

        System.out.println(citiesToVisit);

        var iterator = citiesToVisit.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();


        while (!quitLoop) {
            if (!iterator.hasPrevious()) {
                System.out.println("Originating : " + iterator.next());
                forward = true;
            }
            if (!iterator.hasNext()) {
                System.out.println("Final : " + iterator.previous());
                forward = false;
            }
            System.out.print("Enter Value: ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0, 1);

            switch (menuItem) {
                case "F":
                    System.out.println("User wants to go forward");
                    if (!forward) {           // Reversing Direction
                        forward = true;
                        if (iterator.hasNext()) {
                            iterator.next();  // Adjust position forward
                        }
                    }

                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }

                    break;

                case "B":
                    System.out.println("User wants to go backwards");
                    if (forward) {           // Reversing Direction
                        forward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();  // Adjust position backwards
                        }
                    }

                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    }
                    break;

                case "M":
                    printMenu();
                    break;

                case "L":
                    System.out.println(citiesToVisit);
                    break;

                default:
                    quitLoop = true;
                    break;
            }
        }

    }

    private static void addCity(LinkedList<Place> list, Place place) {
        if (list.contains(place)) {
            System.out.println("Duplicate -> " + place);
            return;
        }

        for (Place pl : list) {
            if (pl.name().equalsIgnoreCase(place.name())) {
                System.out.println("Duplicate-> " + place);
            }
        }

        int index = 0; ///Matched Index for sorting
        for (var listCities : list) {
            if (place.distance() < listCities.distance()) {
                list.add(index, place);
                return;
            }
            index++;
        }


        list.add(place);

    }

    private static void printMenu() {

        System.out.println("""
                Available actions (select word or letter):
                    (F)orward
                    (B)ackwards
                    (L)ist Places
                    (M)enu
                    (Q)uit""");

    }


}





