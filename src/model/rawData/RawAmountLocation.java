package model.rawData;

public class RawAmountLocation {

    private String sendLocation;

    private String item;

    private String totalPerLine;

    private String unit;

    public RawAmountLocation(){

    }



    public String getSendLocation() {
        return sendLocation;
    }

    public void setSendLocation(String sendLocation) {
        this.sendLocation = sendLocation;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getTotalPerLine() {
        return totalPerLine;
    }

    public void setTotalPerLine(String totalPerLine) {
        this.totalPerLine = totalPerLine;
    }

    public String getUnit(){
        return unit;
    }

    public void setUnit(String unit){
        this.unit = unit;
    }

    @Override
    public String toString(){
        return String.format("SendLocation : %s , Item : %s , TotalPerLine : %s",sendLocation,item,totalPerLine);
    }
}
