package State;

import model.rawData.RawData;
import model.rawData.RawItem;

public class MainState implements State {

    private final int PRICE_PER_UNIT = 37,
                    PACK_SIZE = 43 ,
                    TOTAL_PER_LINE = 44,
                    ITEM    = 52,
                    Unit    = 33 ,
                    DESCRIPTION = 55;
    @Override
    public void analyzeData(RawData rawData) {

        String[] text ;
        text = rawData.getCurLineText().split(this.DELIMITER);
        RawItem rawItem = new RawItem();
        rawItem.setPricePerUnit(text[PRICE_PER_UNIT]);
        rawItem.setPackSize(text[PACK_SIZE]);
        rawItem.setItem(text[ITEM]);
        rawItem.setDescription(text[DESCRIPTION]);
        rawItem.setUnit(text[Unit]);
        rawItem.setTotalPerLine(text[TOTAL_PER_LINE]);
        rawData.getRawOrder().addRawItem(rawItem);
        rawData.setState(this);
    }

    @Override
    public boolean lookUpNext (RawData rawData) throws IndexOutOfBoundsException{
        String[] text ;
        text = rawData.getText(rawData.getCurrentLine()).split(this.DELIMITER);
        if (!text[0].equals("")){
            return false ;
        }
        else if (text[27].equals("")){
            return false;
        }
        return true;


    }



    public String toString(){
        return "Main State";
    }
}
