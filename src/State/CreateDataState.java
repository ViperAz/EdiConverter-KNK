package State;

import model.rawData.RawAmountLocation;
import model.rawData.RawData;

public class CreateDataState implements State {

    //1st Line 73 , 2nd Line 3 6
    private final int SEND_LOCATION = 75,
                        ITEM    = 77,
                        Unit    = 7,
                        TOTAL_PER_LINE = 6;

    @Override
    public void analyzeData(RawData rawData) {

        String[] textFirstLine,textSecondLine ;

        textFirstLine =  rawData.getCurLineText().split(this.DELIMITER);

        rawData.increaseCurLine();

        textSecondLine = rawData.getCurLineText().split(this.DELIMITER);

        RawAmountLocation amountLocation = new RawAmountLocation();

        amountLocation.setSendLocation(textFirstLine[SEND_LOCATION]);
        amountLocation.setItem(textFirstLine[ITEM]);
        amountLocation.setTotalPerLine(textSecondLine[TOTAL_PER_LINE]);
        amountLocation.setUnit(textSecondLine[Unit]);

        rawData.getRawOrder().addRawAmLocation(amountLocation);

    }

    @Override
    public boolean lookUpNext (RawData rawData){
        String[] text ;
        text = rawData.getText(rawData.getCurrentLine()).split(this.DELIMITER);

        if(text[75].equals("")){
            return false ;
        }

        return true;

        }
    public String toString(){
        return "Create Data State";
    }




}
