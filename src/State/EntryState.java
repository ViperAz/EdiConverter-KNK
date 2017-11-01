package State;

import model.rawData.RawData;
import model.rawData.RawHeader;
import model.rawData.RawOrder;

public class EntryState implements State {


    private final int FLOW_INDEX = 0,
                    POWNO_INDEX = 4,
                    PAYMENT_INDEX = 11,
                    POLOCATION_INDEX = 12,
                    ENTRYDATE_INDEX = 14,
                    SHIPDATE_INDEX = 16;

    private boolean isIgnoreNext =  false ;


    @Override
    public void analyzeData(RawData rawData) {
        //Checking flowType and store Entry Section
        String[] text ;

        text = rawData.getCurLineText().split(this.DELIMITER);

        rawData.createRawOrder(new RawOrder());
        //Just Keep Raw data in Order no need to process it here
        rawData.getRawOrder().getHeader().setFlowType(text[FLOW_INDEX]);
        rawData.getRawOrder().getHeader().setPowNo(text[POWNO_INDEX]);
        rawData.getRawOrder().getHeader().setPayment(text[PAYMENT_INDEX]);
        rawData.getRawOrder().getHeader().setPoLocation(text[POLOCATION_INDEX]);
        rawData.getRawOrder().getHeader().setEntryDate(text[ENTRYDATE_INDEX]);
        rawData.getRawOrder().getHeader().setShipDate(text[SHIPDATE_INDEX]);


    }

    @Override
    public boolean lookUpNext (RawData rawData){
       String[] text ;
        text = rawData.getText(rawData.getCurrentLine()).split(this.DELIMITER);
       if (text[0].equals("")){
           return false;
       }
        return true;
    }


    public String toString(){
        return "Entry State";
    }
}
