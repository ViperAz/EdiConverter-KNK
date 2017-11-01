package model;

public class Config {

    private String url;

    private String username;

    private String password;

    private String port;

    private String dbName ;

    public Config(){

    }

    public Config(String url, String username, String password, String port, String dbName) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.port = port;
        this.dbName = dbName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
