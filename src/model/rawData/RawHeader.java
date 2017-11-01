package model.rawData;

public class RawHeader {

    private String flowType;

    private String powNo;

    private String payment;

    private String poLocation;

    private String entryDate;

    private String shipDate;

    public RawHeader(){

    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public String getPowNo() {
        return powNo;
    }

    public void setPowNo(String powNo) {
        this.powNo = powNo;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPoLocation() {
        return poLocation;
    }

    public void setPoLocation(String poLocation) {
        this.poLocation = poLocation;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String toString(){
        return String.format("Flow Type : %s , PowNo : %s , Payment : %s , PoLocation : %s , Entry Date : %s , Ship Date : %s", new Object[]{flowType, powNo, payment, poLocation, entryDate, shipDate});
    }
}
