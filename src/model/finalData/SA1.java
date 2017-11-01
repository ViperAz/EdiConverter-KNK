package model.finalData;

public class SA1 {

    private String[] pos = new String[13];

    public SA1(){
        pos[0] = "SA1";
        pos[4] = "ORD001";
        pos[5] = "BEMIS";
        pos[6] = "SL1";
        pos[10] = "1700";
        pos[12] = "SA1_END";
    }
    public SA1 (String poLocation,String dateReference,String powNo,String date){
        pos[0] = "SA1";
        pos[1] = dateReference;
        pos[2] = poLocation;
        pos[3] = poLocation;
        pos[4] = "ORD001";
        pos[5] = "BEMIS";
        pos[6] = "SL1";
        pos[7] = powNo;
        pos[8] = date;
        pos[10] = "1700";
        pos[12] = "SA1_END";

    }

    public void setEntryDate(String date){
        this.pos[8] = date;
    }

    public String getEntryDate(){
        return this.pos[8];
    }

    public void setPowNo(String powNo){
        this.pos[7] = powNo;
    }

    public String getPowNo(){
        return this.pos[7];
    }

    public void setDateReference(String dateReference){
        this.pos[1] = dateReference;
    }
    public String getDateReference(){
        return this.pos[1];
    }

    public void setPoLocation(String poLocation){
        this.pos[2] = poLocation;
        this.pos[3] = poLocation;
    }

    public String getPoLocation(){
        return this.pos[2];
    }

    @Override
    public String toString(){
        String txt = "";

        for (String i : this.pos)
            txt += ((i != null) ? i : "") + "|";
        txt = txt.substring(0,txt.length()-1);

        return txt;
    }
}
