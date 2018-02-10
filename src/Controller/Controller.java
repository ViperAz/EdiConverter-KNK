package Controller;

import Task.ConvertData;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class Controller {

    private final FileChooser.ExtensionFilter filterCsv;
    private final FileChooser.ExtensionFilter filterAll;
//    private MainState mainState;
//    private CreateDataState createState;
//    private UnUsedDataState unUsedState;
//    private EntryState entryState;
//    private fileManager fileManager;
//
//
//    private LocalDateTime now ;
//
//    private final String  DATA_SEPARATOR = "\\|";
//
//    //private final String ITEM_DELIMITER = ":";
//
//    private int step;
//    private int year;
//    private int month;
//    private int day;
//    private String curDateRef;
//
    private File fileToConvert;

    private  FileChooser fileChooser;

    @FXML
    private Button browseBtn;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressBarText;

    @FXML
    private TextField browseText_1;

    @FXML
    private TextField stepText_1;
    @FXML
    private Button convertBtn;





    public Controller(){

        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filterTxt = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        filterCsv = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        filterAll = new FileChooser.ExtensionFilter("All files (*)", "*");
        fileChooser.getExtensionFilters().add(filterTxt);
        fileChooser.getExtensionFilters().add(filterCsv);
        fileChooser.getExtensionFilters().add(filterAll);
    }
    @FXML
    public void browseOpenFile(){
        Stage stage =(Stage) browseBtn.getScene().getWindow();
        fileChooser.setSelectedExtensionFilter(filterCsv);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            browseText_1.setText(file.getAbsolutePath());
//                            openFile(file);
        }
    }

    @FXML
    public void closeSystem(){
        System.exit(
                0
        );
    }

   @FXML
    public void convertData(){

       fileToConvert = new File(browseText_1.getText());

       ConvertData convertWorker = null;
       try {
           convertWorker = new ConvertData(fileToConvert,Integer.valueOf(stepText_1.getText()));
       } catch (IOException e) {
           e.printStackTrace();
       }
       progressBar.progressProperty().unbind();

       convertBtn.setDisable(true);
       progressBar.setProgress(0);
       progressBar.setVisible(true);
       progressBarText.setVisible(true);

       progressBar.progressProperty().bind(convertWorker.progressProperty());
       progressBarText.textProperty().bind(convertWorker.messageProperty());
       convertWorker.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler() {
           @Override
           public void handle(Event event) {
               progressBar.setVisible(false);
               progressBarText.setVisible(false);
               convertBtn.setDisable(false);
           }
       });
//       convertWorker.messageProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue));
       new Thread(convertWorker).start();


    }
}
