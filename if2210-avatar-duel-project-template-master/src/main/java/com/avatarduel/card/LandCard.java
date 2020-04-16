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

    public int getPower() {
        return 0;
    }

    public int getAttack() {
        return 0;
    }

    public int getDefense() {
        return 0;
    }

}