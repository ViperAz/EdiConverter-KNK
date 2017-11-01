package model.rawData;

import java.util.ArrayList;

public class RawOrder {

    private RawHeader header ;
    private ArrayList<RawItem> rawItem;
    private ArrayList<RawAmountLocation> rawAmLocation;

    public RawOrder(){
        this.header = new RawHeader();
        this.rawItem = new ArrayList<RawItem>();
        this.rawAmLocation = new ArrayList<RawAmountLocation>();
    }

    public RawOrder(RawHeader header) {
        this.header = header;
        this.rawItem = new ArrayList<RawItem>();
        this.rawAmLocation = new ArrayList<RawAmountLocation>();
    }

    public RawHeader getHeader() {
        return header;
    }

    public void setHeader(RawHeader header) {
        this.header = header;
    }

    public void addRawItem(RawItem Item){
        this.rawItem.add(Item);
    }

    public ArrayList<RawItem> getRawItem() {
        return rawItem;
    }

    public void setRawItem(ArrayList<RawItem> rawItem) {
        this.rawItem = rawItem;
    }

    public void addRawAmLocation(RawAmountLocation rawAmountLocation){
        this.rawAmLocation.add(rawAmountLocation);
    }
    public ArrayList<RawAmountLocation> getRawAmLocation() {
        return rawAmLocation;
    }

    public void setRawAmLocation(ArrayList<RawAmountLocation> rawAmLocation) {
        this.rawAmLocation = rawAmLocation;
    }

    @Override
    public String toString(){
        String text = header.toString()+"\n" ;

        System.out.println("Item Size"+ rawItem.size());
        for(RawItem i : rawItem){
            text += i.toString()+"\n";
        }
        for(RawAmountLocation i : rawAmLocation){
            text += i.toString()+"\n";
        }

        return text;
    }
}
