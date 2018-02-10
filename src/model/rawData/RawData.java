package model.rawData;

import State.State;

import java.util.ArrayList;

public class RawData {

    //Current Line 1 ** Please Remember that -1 when using this variable
    private int currentLine ;
    private ArrayList<String> TextLine;
    private int maxArray;
    private State state;
    private RawOrder rawOrder;

    public RawData(ArrayList<String> textline){
        this.currentLine = 1 ;
        this.TextLine = textline;
//        this.TextLine =
        this.maxArray = this.TextLine.size();
        state = null;
    }


    public RawOrder getRawOrder() {
        return rawOrder;
    }

    public void setRawOrder(RawOrder rawOrder) {
        this.rawOrder = rawOrder;
    }

    public void resetState(){
        this.state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return this.state;
    }

    /*
    *@return    true  = not the last index
    *           false = last index
     */
    public boolean increaseCurLine(){
        try{
            this.TextLine.get(currentLine);
        }catch (IndexOutOfBoundsException e){
            return false;
        }
            this.currentLine++;
            return true;


    }

    public int getCurrentLine(){
        return this.currentLine;
    }

    public String getText(int index){
        return this.TextLine.get(index);
    }
    public String getCurLineText(){
        return this.TextLine.get(currentLine-1);
    }

    public String toString(){
        return rawOrder.toString();
    }

    public int getTextLineSize(){
        return this.TextLine.size();
    }

}
