package com.avatarduel;

class CharacterCard extends Card{
    private int power;
    private int attack;
    private int defense;
    private boolean position; //true atk, false defensse

    public CharacterCard(){
        super();
    }

    // public CharacterCard(int id, String name, String element, String description, String imagePath, int power, int attack, int defense, boolean position){
    //     super(id, name, element, description, imagePath);
    //     this.power = power;
    //     this.attack = attack;
    //     this.defense = defense;
    // } 
    public void changePosition() {
        this.position = !this.position;
    }
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

    public boolean getPosition() {
        return this.position;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public int getPoint() {
        if(this.position) {
            return this.attack;
        } else {
            return this.defense;
        }
    }

    public void cekKartu(){
        System.out.println("Character card");
        super.cekKartu();
        System.out.println(power + "\n" + attack + "\n" + defense);
    }
}