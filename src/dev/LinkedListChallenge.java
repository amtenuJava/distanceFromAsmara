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
        System.out.println(citiesToVisit);


    }

    private static void addCity(LinkedList<Place> list, Place place) {
        if (list.contains(place)) {
            System.out.println("Duplicate -> " + place);
            return;
        }

        for(Place pl:list){
            if(pl.name().equalsIgnoreCase(place.name())){
                System.out.println("Duplicate-> "+ place);
            }
        }


        list.add(place);

    }


}
