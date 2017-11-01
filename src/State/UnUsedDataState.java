package State;

import model.rawData.RawData;

public class UnUsedDataState implements State {
    @Override
    public void analyzeData(RawData rawData) {

        //Do nothing just implement it when it needed

    }

    @Override
    public boolean lookUpNext(RawData rawData) {
        String[] text ;
        text = rawData.getText(rawData.getCurrentLine()).split(this.DELIMITER);

        if(text[86].equals("")){
            return false ;
        }

        return true;
    }
}
