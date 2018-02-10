package Controller;

import model.Config;

import java.io.*;
import java.util.ArrayList;

public class ConfigManager {

    private static final String CONFIG_NAME = "config.txt";

    public static Config getConfig() throws IOException {
        File file = new File(CONFIG_NAME).getAbsoluteFile();
        Config config = new Config();
        ArrayList<String> data = openFile(file);

        for (String i : data){
            String[] line = i.split("=");
            String prefix = line[0].trim();
            if (prefix.equals("url"))
                config.setUrl(line[1].trim());
            if (prefix.equals("id"))
                config.setUsername(line[1].trim());
            if (prefix.equals("password"))
                config.setPassword(line[1].trim());
            if (prefix.equals("port"))
                config.setPort(line[1].trim());
            if (prefix.equals("db_name"))
                config.setDbName(line[1].trim());
        }
        return config;
    }

    public static ArrayList<String> openFile(File file) throws IOException {

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
}
