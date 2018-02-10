package Controller;


import model.Run;

import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class fileManager {


    private final String END_OF_FILE,RUN_PATH, LINE_SEPARATOR;

    {
        END_OF_FILE = ".txt";
        RUN_PATH = "run.txt";
        LINE_SEPARATOR = System.getProperty("line.separator");
    }


//    public void openConection(){
//
//
//    }
//
//    public String getWareHouse (String item) throws IOException {
//        item = PREFIX+item.trim();
//        Config config;
//             config = getConfig(CONFIG_PATH);
//
////        System.out.println("Entering warehouse");
//        String connectionUrl = "jdbc:sqlserver://"+config.getUrl().trim()+":"+config.getPort().trim()+";" +
//                "databaseName="+config.getDbName().trim()+";user="+config.getUsername()+";password="+config.getPassword();
//
//        // Declare the JDBC objects.
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        String output = "";
//        try {
//            // Establish the connection.
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            con = DriverManager.getConnection(connectionUrl);
//            // Create and execute an SQL statement that returns some data.
//            String SQL = "select t_cwar from ttdisa001803 where t_item = '"+PREFIX+item.trim()+"'";
//            stmt = con.createStatement();
//            rs = stmt.executeQuery(SQL);
//
//            // Iterate through the data in the result set and display it.
//            while (rs.next()) {
//                output = rs.getString(1);
//            }
//        }
//
//        // Handle any errors that may have occurred.
//        catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        finally {
//            if (rs != null) try { rs.close(); } catch(Exception e) {}
//            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
//            if (con != null) try { con.close(); } catch(Exception e) {}
//        }
//        return output;
//    }

//    public String getWareHouse(String item) throws IOException, ClassNotFoundException {
//        item = PREFIX+item.trim();
//        Config config = getConfig(CONFIG_PATH);
////        Context context = new InitialContext();
////        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDB");
//        String connectionUrl = "jdbc:sqlserver://"+config.getUrl().trim()+":"+config.getPort().trim()+"/"+config.getDbName().trim();
//        System.out.println(connectionUrl);
//
//        try  {
////            Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection(connectionUrl, config.getUsername().trim(), config.getPassword().trim());
//            System.out.println("Driver loaded!");
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select ttdsia001.cwar from ttdsia001 where ttdsia001.item = "+item);
//            System.out.println(rs);
//            while (rs.next()){
//
//            }
//            con.close();
//            stmt.close();
//            rs.close();
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        return null;
//    }

//    private Config getConfig(String filePath) throws IOException {
//        File file = new File(filePath).getAbsoluteFile();
//        Config config = new Config();
//        ArrayList<String> data = openFile(file);
//
//        for (String i : data){
//            String[] line = i.split("=");
//            String prefix = line[0].trim();
//            if (prefix.equals("url"))
//                config.setUrl(line[1].trim());
//            if (prefix.equals("id"))
//                config.setUsername(line[1].trim());
//            if (prefix.equals("password"))
//                config.setPassword(line[1].trim());
//            if (prefix.equals("port"))
//                config.setPort(line[1].trim());
//            if (prefix.equals("db_name"))
//                config.setDbName(line[1].trim());
//        }
//        return config;
//    }

    public Run getRun(LocalDateTime curDate) throws IOException{

        File file = new File(RUN_PATH).getAbsoluteFile();

        ArrayList<String> data = openFile(file);
        String day = String.valueOf(curDate.getDayOfMonth());
        String month = String.valueOf(curDate.getMonthValue());
        String year = String.valueOf(curDate.getYear());
        Run run = new Run();
        run.setDate(year+"/"+month+"/"+day);
        for(String i : data){
            String[] line = i.split("=");
            if (line[0].trim().equals("run") )
                run.setRun(Integer.valueOf(line[1].trim()));

            if (line[0].trim().equals("current_date")){
                String[] date = line[1].trim().split("/");
                if (!date[2].equals(day) || !date[1].equals(month) || !date[0].equals(year)){
                    System.out.println("Reset");
                    run.setRun(0);
                }
            }


        }
        System.out.println(run.getDate() + run.getRun());
        return run;

    }

    public void saveRun(Run run) throws IOException {
        File file = new File (RUN_PATH).getAbsoluteFile();
        PrintWriter output = new PrintWriter(new FileWriter(file));

        output.println("[Run date & number]");
        output.println("run = "+run.getRun());
        output.println("current_date = "+run.getDate());
        output.close();

    }
    public ArrayList<String> openFile (File file) throws IOException {

        String  line = "";
        ArrayList<String> data = new ArrayList<String>();

        BufferedReader input = new BufferedReader(new InputStreamReader(
                new FileInputStream(file)));

        line = input.readLine();
        while (line != null){
            data.add(line);
            line = input.readLine();
        }
        input.close();
        return data;
    }


//    public void saveFile (File file,ArrayList<String> text) throws IOException {
//
//        String tmp ;
//
//
//        if (file.toString().endsWith(END_OF_FILE)){
//            tmp = "" ;
//        } else {
//            tmp = END_OF_FILE;
//        }
//        OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file + tmp));
//
//        for (String i : text) {
//            output.write(i+ LINE_SEPARATOR);
//        }
//        output.close();
//    }

    public void saveFile (ArrayList<String> text) throws IOException {

        String tmp ;

        File file = new File("ord001.txt").getAbsoluteFile();

        OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file));

        for (String i : text) {
            output.write(i+ LINE_SEPARATOR);
        }
        output.close();
    }

}
