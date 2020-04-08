package com.avatarduel;

class CharacterCard extends Card{
    private int power;
    private int attack;
    private int defense;

    public CharacterCard(){
        super();
    }

    // public CharacterCard(int id, String name, String element, String description, String imagePath, int power, int attack, int defense){
    //     super(id, name, element, description, imagePath);
    //     this.power = power;
    //     this.attack = attack;
    //     this.defense = defense;
    // } 

    public int getPower(){
        return power;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public void setPower(int power){
        this.power = power;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public void cekKartu(){
        System.out.println("Character card");
        super.cekKartu();
        System.out.println(power + "\n" + attack + "\n" + defense);
    }
}