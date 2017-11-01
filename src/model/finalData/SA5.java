package model.finalData;

public class SA5 {

    private String[] pos = new String[94];
    /*
                                                            +10
                                                         **Select from database
    SA5|20170920000000000000000000000000001|excel M|excel E|10|excel AR||BP|         excel D or BA|         excel D or BA||excel G|execl O|excel O|excel Q|excel H or AH|excel (AL)|excel H AH|0|0|0|0|0|V07|ZZ||||||Gross|Gross|Gross|Gross|Gross|0|0|0|0|0|Any|||||0|0|0||||200|ZZ|ZZ|excel M|ZZ|STBP||||||0||0|||||||||||||||TH||TH||||||||Excel M|ZZ|Excel BX|ZZ|SA5_END
      0|                                  1|      2|      3| 4|       5|| 7|                     8|                     9||     11|     12|     13|     14|           15|        16|     17|8|9|0|1|2|23 |24||||||   30|31   |32   |33   |34   |5|6|7|8|9|40 |||||5|6|7|||| 51|52|53|    54 |55|  56||||||2||4|||||||||||||||79||81||||||||89     |90|91      |92|93
            M  E  AR   D or BA   G O Q   H or AH  AL  BX
     */
    public SA5(){
        pos[0] = "SA5";
        pos[7] = "BP" ;
        pos[18] = "0";
        pos[19] = "0";
        pos[20] = "0";
        pos[21] = "0";
        pos[22] = "0";
        pos[23] = "V07";
        pos[24] = "ZZ";
        pos[30] = "Gross";
        pos[31] = "Gross";
        pos[32] = "Gross";
        pos[33] = "Gross";
        pos[34] = "Gross";
        pos[35] = "0";
        pos[36] = "0";
        pos[37] = "0";
        pos[38] = "0";
        pos[39] = "0";
        pos[40] = "Any";
        pos[45] = "0";
        pos[46] = "0";
        pos[47] = "0";
        pos[51] = "";//database
        pos[52] = "ZZ";
        pos[53] = "ZZ";
        pos[55] = "ZZ";
        pos[56] = "STBP";
        pos[62] = "0";
        pos[64] = "0";
        pos[79] = "TH";
        pos[81] = "TH";
        pos[90] = "ZZ";
        pos[92] = "ZZ";
        pos[93] = "SA5_END";

    }
    public String getDateReference (){
        return this.pos[1];
    }

    public void setDateReference(String dateRerence){
        this.pos[1] = dateRerence;
    }

    public String getPoLocation(){
        return this.pos[2];
    }

    public String getStepSize(){
        return this.pos[4];
    }

    public void setStepSize(String pos4){
        this.pos[4] = pos4;
    }

    public void setPoLocation(String poLocation){
        this.pos[2] = poLocation;
        this.pos[89] = poLocation;
        this.pos[54] = poLocation;
    }

    public String getPowNo(){
        return this.pos[3];
    }

    public void setPowNo(String powNo){
        this.pos[3] = powNo;
    }

    public String getItem(){
        return this.pos[8];
    }

    public void setItem(String item){
        this.pos[8] = item;
    }

    public String getTotalPerLine (){
        return this.pos[11];
    }

    public void setTotalPerLine(String totalPerLine){
        this.pos[11] = totalPerLine;
    }

    public String getPrice(){
        return this.pos[16];
    }

    public void setPrice(String price){
        this.pos[16] = price;
    }

    public String getShipDate(){
        return this.pos[14];
    }

    public void setShipDate(String shipDate){
        this.pos[14] =  shipDate;
    }

    public String getUnit(){
        return  this.pos[15];
    }

    public void setUnit(String unit){
        this.pos[15] = unit;
        this.pos[17] = unit;
    }

    public String getEntryDate(){
        return this.pos[12];
    }

    public void setEntryDate(String entryDate){
        this.pos[12] = entryDate;
        this.pos[13] = entryDate;
    }

    public String getSendLocation(){
       return this.pos[91] ;
    }

    public void setSendLocation(String sendLocation){
        this.pos[91] = sendLocation;
    }

    public String getSizePerPack (){
        return this.pos[5];
    }

    public void setSizePerPack(String sizePerPack){
        this.pos[5] = sizePerPack;
    }

    public String getWareHouse (){
        return this.pos[51];
    }

    public void setWareHouse(String wareHouse){
        this.pos[51] = wareHouse;
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
