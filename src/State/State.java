package State;

import model.rawData.RawData;

public interface State {

    public final String  DELIMITER = "\\|";

    public void analyzeData(RawData rawData);

    public boolean lookUpNext(RawData rawData);
}
