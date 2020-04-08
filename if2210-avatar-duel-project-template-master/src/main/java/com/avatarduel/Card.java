import java.util.*;

abstract class Card{

    protected int id;
    protected String name;
    protected String element;
    protected String description;
    protected String imagepath;

    public Card(){

    }

//     public Card(int id, String name, String element, String description, String imagepath){
//         this.id = id;
//         this.name = name;
//         this.element = element;
//         this.description = description;
//         this.imagepath = imagepath;
//     }


    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getElement(){
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

    public void setElement(String element){
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



    //untuk kartu setelah di baca di csv(masih error)
//    public List<Card> copyCardCharacter(List<String[]> cardList){
//        List<Card> characterList= new ArrayList<Card>();
//        String type = "CharacterCard";
//        CharacterCard character = CardFactory.getCard(type);
//        String[] temp;
//
//        for(int i = 0;i < cardList.size(); i++){
//            temp = cardList.get(i);
//            character.setId(Integer.parseInt(temp[0]));
//            character.setName(temp[1]);
//            character.setElement(temp[2]);
//            character.setDescription(temp[3]);
//            character.setImagepath(temp[4]);
//            character.setAttack(Integer.parseInt(temp[5]));
//            character.setDefense(Integer.parseInt(temp[6]));
//            character.setPower(Integer.parseInt(temp[7]));
//            characterList.add(character);
//        }
//    }

//    public List<Card> copyCardSkill(List<String[]> cardList){
//        List<Card> skillList= new ArrayList<Card>();
//        String type = "SkillCard";
//        SkillCard skill = CardFactory.getCard(type);
//        String[] temp;
//
//        for(int i = 0;i < cardList.size(); i++){
//            temp = cardList.get(i);
//            skill.setId(Integer.parseInt(temp[0]));
//            skill.setName(temp[1]);
//            skill.setElement(temp[2]);
//            skill.setDescription(temp[3]);
//            skill.setImagepath(temp[4]);
//            skill.setAttack(Integer.parseInt(temp[5]));
//            skill.setDefense(Integer.parseInt(temp[6]));
//            skill.setPower(Integer.parseInt(temp[7]));
//            skillList.add(skill);
//        }
//    }
//
//    public List<Card> copyCardLand(List<String[]> cardList){
//        List<Card> landList= new ArrayList<Card>();
//        String type = "ListCard";
//        LandCard land = CardFactory.getCard(type);
//        String[] temp;
//
//        for(int i = 0;i < cardList.size(); i++){
//            temp = cardList.get(i);
//            land.setId(Integer.parseInt(temp[0]));
//            land.setName(temp[1]);
//            land.setElement(temp[2]);
//            land.setDescription(temp[3]);
//            land.setImagepath(temp[4]);
//            landList.add(land);
//        }
//    }
}