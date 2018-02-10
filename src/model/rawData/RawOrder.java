package model.rawData;

import java.util.ArrayList;

public class RawOrder {

    private RawHeader header ;
    private ArrayList<RawItem> rawItems;
    private ArrayList<RawAmountLocation> rawAmLocations;

    public RawOrder(){
        this.header = new RawHeader();
        this.rawItems = new ArrayList<RawItem>();
        this.rawAmLocations = new ArrayList<RawAmountLocation>();
    }


    public RawHeader getHeader() {
        return header;
    }

    public void setHeader(RawHeader header) {
        this.header = header;
    }

    public void addRawItem(RawItem Item){
        this.rawItems.add(Item);
    }

    public ArrayList<RawItem> getRawItems() {
        return rawItems;
    }

    public void setRawItems(ArrayList<RawItem> rawItems) {
        this.rawItems = rawItems;
    }

    public void addRawAmLocation(RawAmountLocation rawAmountLocation){
        this.rawAmLocations.add(rawAmountLocation);
    }
    public ArrayList<RawAmountLocation> getRawAmLocations() {
        return rawAmLocations;
    }

    public void setRawAmLocations(ArrayList<RawAmountLocation> rawAmLocations) {
        this.rawAmLocations = rawAmLocations;
    }

    @Override
    public String toString(){
        String text = header.toString()+"\n" ;

        System.out.println("Item Size"+ rawItems.size());
        for(RawItem i : rawItems){
            text += i.toString()+"\n";
        }
        for(RawAmountLocation i : rawAmLocations){
            text += i.toString()+"\n";
        }

        return text;
    }
}
