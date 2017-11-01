package model.rawData;

public class RawItem {

    private String pricePerUnit;

    private String packSize;

    private String description;

    private String item ;
    private String unit;
    private String totalPerLine;

    public RawItem(){

    }

    public RawItem(String pricePerUnit, String packSize, String description) {
        this.pricePerUnit = pricePerUnit;
        this.packSize = packSize;
        this.description = description;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUnit(){
        return this.unit;
    }

    public void setUnit (String unit){
        this.unit = unit;
    }
    public String getTotalPerLine(){
        return this.totalPerLine;
    }
    public void setTotalPerLine(String totalPerLine) {
        this.totalPerLine = totalPerLine;
    }


    public String toString(){
        return String.format("PricePerUnit : %s , PackSize : %s , Description : %s", new Object[]{pricePerUnit, packSize, description});
    }


}
