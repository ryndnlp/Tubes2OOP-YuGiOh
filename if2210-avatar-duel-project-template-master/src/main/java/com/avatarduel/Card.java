package com.avatarduel;
import com.avatarduel.model.Element;

abstract class Card{

    protected int id;
    protected String name;
    protected Element element;
    protected String description;
    protected String imagepath;

    public Card(){

    }

//     public Card(int id, String name, String element, String description, String imagepath){
//         this.id = id;
//         this.name = name;
//         this.element = element; Ngikut yang ada di data
//         this.description = description;
//         this.imagepath = imagepath;
//     }


    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Element getElement(){
        return element;
    }

    public String getDescription(){
        return description;
    }

    public String getImagepath(){
        return imagepath;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setElement(Element element){
        this.element = element;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setImagepath(String imagepath){
        this.imagepath = imagepath;
    }

    public void cekKartu(){
        System.out.println(id + "\n" + name + "\n" + element + "\n" + description + "\n" + imagepath);
    }
}