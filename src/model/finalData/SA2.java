package model.finalData;

public class SA2 {
   /*SA2|20170920000000000000000000000000001|excel M|excel E|excel O|excel O|excel Q||excel BD||||||||excel L||0|0|0|THB|||||0||ZZ||SLS|ZZ||Warehouse|ZZ|||ZZ|ITBP||ZZ|PBBP||ZZ|STBP||||||||Excel M|ZZ|SA2_END
       0|                                 1 |     2 |      3|      4|      5|    6-7||   8-15 ||||||||     16||8|9|2|21 |||||6||28|| 30|31||       33|34|||37|  38||40|  41||43|  44||||||||     52|53|54
    dateref M E O Q BD L
    */
    private String[] pos = new String[55];

    public SA2(){
        this.pos[0] = "SA2";
        this.pos[18]= "0";
        this.pos[19]= "0";
        this.pos[20]= "0";
        this.pos[21]= "THB";
        this.pos[26]= "0";
        this.pos[28]= "ZZ";
        this.pos[30]= "SLS";
        this.pos[31]= "ZZ";
        //>>Connect to database
//        this.pos[33]= "Warehouse";
        this.pos[34]= "ZZ";
        this.pos[37]= "ZZ";
        this.pos[38]= "ITBP";
        this.pos[40]= "ZZ";
        this.pos[41]= "STBP";
        this.pos[53]= "ZZ";
        this.pos[54] = "SA2_END";
    }

    public String getPoLocation(){
        return this.pos[2];
    }
    public void setPoLocation(String poLocation){
        this.pos[2] = poLocation;
        this.pos[52] = poLocation;
    }

    public String getPowNo(){
        return this.pos[3];
    }

    public void setPowNo(String powNo){
        this.pos[3] = powNo;
    }

    public String getEntryDate(){
        return this.pos[4];
    }

    public void setEntryDate(String entryDate){
        this.pos[4] = entryDate;
        this.pos[5] = entryDate;
    }

    public String getShipDate(){
        return this.pos[6];
    }

    public void setShipDate(String shipDate){
        this.pos[6] = shipDate;

    }

    public String getPayment(){
        return this.pos[16];
    }

    public void setPayment(String payment){
        this.pos[16] = payment;
    }

    public String getDateReferencce(){
        return this.pos[1];
    }

    public void setDateReference(String dateReference){
        this.pos[1] = dateReference;
    }

    public String getDescription(){
        return this.pos[8];
    }

    public void setDescription(String description){
        this.pos[8] = description;
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
