package State;

import model.rawData.RawData;

public class UnUsedDataState2 implements State {
    @Override
    public void analyzeData(RawData rawData) {

    }

    @Override
    public boolean lookUpNext(RawData rawData) throws IndexOutOfBoundsException {
        String[] text ;
        text = rawData.getText(rawData.getCurrentLine()).split(this.DELIMITER);

        if(!text[0].equals("")){
            return false ;
        }

        return true;
    }
}
