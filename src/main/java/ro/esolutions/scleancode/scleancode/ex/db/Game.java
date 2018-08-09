package ro.esolutions.scleancode.scleancode.ex.db;

public class Game {
    public Game(String name, String version, String company, String description) {
        this.name = name;
        this.version = version;
        this.company = company;
        this.description = description;
    }

    private String name;
    private String version;
    private String company;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
