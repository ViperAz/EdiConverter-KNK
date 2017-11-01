package model.finalData;

import java.util.ArrayList;

public class Order {



    private SA1 sa1;

    private SA2 sa2;

    private ArrayList<SA5> sa5;

    public Order(){
        sa1 = new SA1();
        sa2 = new SA2();
        sa5 = new ArrayList<SA5>();
    }


    public SA1 getSa1() {
        return sa1;
    }

    public void setSa1(SA1 sa1) {
        this.sa1 = sa1;
    }

    public SA2 getSa2() {
        return sa2;
    }

    public void setSa2(SA2 sa2) {
        this.sa2 = sa2;
    }

    public ArrayList<SA5> getSa5() {
        return sa5;
    }

    public void addSa5(SA5 sa5){
        this.sa5.add(sa5);
    }

    public void removeSa5(SA5 sa5){
        this.sa5.remove(sa5);
    }

    public void setSa5(ArrayList<SA5> sa5) {
        this.sa5 = sa5;
    }

    public ArrayList<String> getText(){
        ArrayList<String> texts = new ArrayList<>();
        texts.add(sa1.toString());
        texts.add(sa2.toString());
        for (SA5 i : sa5){
            texts.add(i.toString());
        }
        return texts;
    }
    @Override
    public String toString(){
        String text = sa1.toString()+"\n"+sa2.toString()+"\n";
        for (SA5 i : sa5){

            text+= i.toString() +"\n";
        }
        return text;
    }
}
