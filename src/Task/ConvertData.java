package Task;

import javafx.concurrent.Task;
import model.Run;
import model.fileManager;
import model.finalData.Order;
import model.finalData.SA1;
import model.finalData.SA2;
import model.finalData.SA5;
import model.rawData.RawAmountLocation;
import model.rawData.RawData;
import model.rawData.RawHeader;
import model.rawData.RawItem;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import State.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class ConvertData extends Task {

    private Run run;

    private ArrayList<Order> orders ;
    private ArrayList<String> output;

    private int step ;

    private LocalDateTime now ;
    private int year;
    private int month;
    private int day;
    private String curDateRef;

    private File fileToConvert;


    private MainState mainState;
    private CreateDataState createState;
    private UnUsedDataState unUsedState;
    private EntryState entryState;
    private fileManager fileManager;

    private String DATA_SEPARATOR = "\\|";


    public ConvertData(File fileToConvert,int step){
        this.orders = new ArrayList<>();
        this.fileToConvert = fileToConvert;
        this.step = step;
        this.fileManager  = new fileManager();
        this.curDateRef = "000000000000000000000000000";
        entryState = new EntryState();
        mainState = new MainState();
        createState = new CreateDataState();
        unUsedState = new UnUsedDataState();
        output  = new ArrayList<>();
    }
    @Override
    protected Object call() throws Exception {

        this.updateMessage("Start Converting");

        ArrayList<String> textList ;
        output.clear();
        this.run = null;
//        fileToConvert = new File(browseText_1.getText());
        this.now = LocalDateTime.now();
        this.year = now.getYear();
        this.month = now.getMonthValue();
        this.day = now.getDayOfMonth();
        this.run = fileManager.getRun(this.now);
        try{
            textList =  fileManager.openFile(fileToConvert);
            this.updateMessage("Reading File ...");

        }
        catch (FileNotFoundException e){
            showMessageDialog(null,"File not found. Try Again.","Error",JOptionPane.ERROR_MESSAGE);
//        setProgressView(false);
            return null ;
        }

        RawData rawData = new RawData(textList);

        UnUsedDataState2 unUsedDataState2 = new UnUsedDataState2();

        if (rawData.getState() == null) {
            rawData.setState(entryState);
        }
        int size =  rawData.getTextLineSize();
        int cur = 1;
        this.updateMessage("Converting data");
        //Loop Each line of rawData ignore first line
        try {
            while (rawData.increaseCurLine()) {
               //System.out.println(rawData.getCurLineText().substring(0,50));

                try {
                    analyzeData(rawData);
                    System.out.println("1");
                } catch (IndexOutOfBoundsException e) {
                    showMessageDialog(null, "Wrong file format.Make sure use\"|\" as string delimiter", "Error", JOptionPane.ERROR_MESSAGE);
//                setProgressView(false);
                    return null;
                }
                System.out.println("c");
                try {
                    if (rawData.getState() == unUsedDataState2 && !unUsedDataState2.lookUpNext(rawData)) {
                        rawData.setState(entryState);
                        System.out.println("2");
                    }
                    if (rawData.getState() == unUsedState && !unUsedState.lookUpNext(rawData)) {
                        rawData.setState(unUsedDataState2);
                        System.out.println("3");
                    }
                    System.out.println("d");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("File end in unused state");
                }
                System.out.println("is out");
                try {
                    if (rawData.getState() == createState && !createState.lookUpNext(rawData)) {
                        //Create SO here
                        orders.add(convertRawToOrder(rawData));
                        rawData.setState(unUsedState);
                        System.out.println("4");
                    }

                    if (rawData.getState() == mainState && !mainState.lookUpNext(rawData)) {
                        String[] text;
                        text = rawData.getText(rawData.getCurrentLine()).split(this.DATA_SEPARATOR);
                        System.out.println("e");
                        if (!text[0].equals("")) {
                            //Create SO here
                            orders.add(convertRawToOrder(rawData));
                            rawData.setState(entryState);
                            System.out.println("5");
                        } else if (!text[72].equals("")) {
                            rawData.setState(createState);
                            System.out.println("6");
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    orders.add(convertRawToOrder(rawData));
                    System.out.println("7");
                }
                System.out.println("zz");
                if (rawData.getState() == entryState && !entryState.lookUpNext(rawData)) {
                    rawData.setState(mainState);
                    System.out.println("8");
                }
                this.updateProgress(cur, size);
                cur++;
            }
        }
        catch(Exception ex){
                showMessageDialog(null,ex.getMessage());
            }
        fileManager.saveRun(this.run);
//        int count = 0 ;
        for (Order i :
                orders) {
            output.addAll(i.getText());
//            count++;
        }

        if (orders.size()>0) {
//            saveBrowseFile(event, count);
            this.updateProgress(size,size);
            this.updateMessage("Saving");
            fileManager.saveFile(output);
//                setProgress(1.0,"Saving");


            showMessageDialog(null, "Save Successful");
        } else {
            showMessageDialog(null, "Empty data or wrong format please try again.");
//            setProgressView(false);
        }
//        setProgressView(false);
        return null;
    }

    private void analyzeData(RawData rawData){

        if (rawData.getState() == unUsedState){
            unUsedState.analyzeData(rawData);
        }
        else if (rawData.getState() == createState){
            createState.analyzeData(rawData);
        }
        else if (rawData.getState() == mainState ) {
            mainState.analyzeData(rawData);
        }

        else if (rawData.getState() == entryState) {
            entryState.analyzeData(rawData);
        }
    }

    private Order convertRawToOrder (RawData rawData) throws IOException, ClassNotFoundException {
        //27
        this.run.increaseRun();
        RawHeader rawHeader =  rawData.getRawOrder().getHeader();
        ArrayList<RawItem> rawItem = rawData.getRawOrder().getRawItem();
        ArrayList<RawAmountLocation> rawAmountLocations = rawData.getRawOrder().getRawAmLocation();

        int delRange = String.valueOf(this.run.getRun()).length();

        String tmpDateRef = String.valueOf(this.year)+String.valueOf(this.month)+
                (this.day<10? "0"+String.valueOf(this.day): String.valueOf(this.day))+
                curDateRef.substring(0,curDateRef.length() - delRange);
        tmpDateRef += String.valueOf(this.run.getRun());
        String poLo = rawHeader.getPoLocation().substring(0,5);
        String powNo = rawHeader.getPowNo().split(" ")[0];
        String entryDate= rawHeader.getEntryDate();
        entryDate = convertDateFormat(entryDate);
        String shipDate = rawHeader.getShipDate();
        shipDate = convertDateFormat(shipDate);
        String[] payments = rawHeader.getPayment().split(" ");

        String desc = rawItem.get(0).getDescription();
        if (desc.length()>50)
            desc =  desc.substring(0,50);
        String payment = "" ;
        if (payments.length > 1){
            payment = payments[1];
        }
        Order order = new Order();

        SA1 sa1 = new SA1();
        SA2 sa2 = new SA2();

        sa1.setDateReference(tmpDateRef);
        sa1.setEntryDate(entryDate);
        sa1.setPoLocation(poLo);
        sa1.setPowNo(powNo);
        order.setSa1(sa1);

        sa2.setDateReference(tmpDateRef);
        sa2.setEntryDate(entryDate);
        sa2.setPoLocation(poLo);
        sa2.setPowNo(powNo);
        sa2.setPayment(payment);
        sa2.setShipDate(shipDate);
        sa2.setDescription(desc);
        order.setSa2(sa2);
        if (rawAmountLocations.size()>0){
            for (RawAmountLocation i : rawAmountLocations){
                SA5 sa5 = new SA5();
                sa5.setDateReference(tmpDateRef);
                sa5.setPoLocation(poLo);
                sa5.setPowNo(powNo);
                sa5.setEntryDate(entryDate);
                sa5.setItem(i.getItem());
                sa5.setTotalPerLine(i.getTotalPerLine());
                sa5.setUnit(i.getUnit());
                sa5.setSendLocation(i.getSendLocation().substring(0,5));
                sa5.setStepSize(String.valueOf(step));
                sa5.setShipDate(shipDate);
                sa5.setWareHouse(fileManager.getWareHouse(i.getItem().trim()));
                for (RawItem j : rawItem){
                    if(j.getItem().trim().equals(i.getItem().trim())){
                        sa5.setSizePerPack(j.getPackSize());
                        //sa5.setPrice(j.getPricePerUnit());
                    }
                }
                order.addSa5(sa5);
                step+=10;
            }
        }else{
            for(RawItem i : rawItem){
                SA5 sa5 = new SA5();
                sa5.setDateReference(tmpDateRef);
                sa5.setPoLocation(poLo);
                sa5.setPowNo(powNo);
                sa5.setEntryDate(entryDate);
                sa5.setItem(i.getItem());
                sa5.setTotalPerLine(i.getTotalPerLine());
                sa5.setUnit(i.getUnit());
                sa5.setSendLocation(poLo);
                sa5.setStepSize(String.valueOf(step));
                sa5.setSizePerPack(i.getPackSize());
                sa5.setShipDate(shipDate);
                //sa5.setPrice(i.getPricePerUnit());
                sa5.setWareHouse(fileManager.getWareHouse(i.getItem().trim()));
                order.addSa5(sa5);
                step+=10;
            }
        }
        return order;
    }


    private String convertDateFormat (String date){
        String[] monthStr = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String[] temp = date.split(" ");
        String year = temp[2];
        String day = temp[0].split(",")[1];
        int month = 0 ;
        for (String i :
                monthStr) {
            month++;
            if (i.equals(temp[1]))
                break;
        }
        return year+(month<10? "0"+String.valueOf(month) :String.valueOf(month) )+day ;
    }


}
