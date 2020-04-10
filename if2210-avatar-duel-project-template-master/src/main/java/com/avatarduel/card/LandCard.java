package com.avatarduel.card;

public class LandCard extends Card{

    public LandCard(){
        super();
    }

//     public LandCard(int id, String name, String element, String description, String imagepath){
//         super(id, name, element, description, imagepath);
//     }

    public void cekKartu(){
        System.out.println("Land card");
        super.cekKartu();
    }

}