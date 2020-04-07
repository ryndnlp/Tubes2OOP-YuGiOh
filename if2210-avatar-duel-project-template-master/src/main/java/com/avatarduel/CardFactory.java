public class CardFactory{

    public static Card getCard(String cardType){
        if(cardType == null){
            return null;
        }

        if(cardType.equalsIgnoreCase("SkillCard")){
            return new SkillCard();
        }

        else if(cardType.equalsIgnoreCase("CharacterCard")){
            return new CharacterCard();
        }

        else if(cardType.equalsIgnoreCase("LandCard")){
            return new LandCard();
        }

        return null;
    }
}