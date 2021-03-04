package addressapp;

public class Persona {

    private final String name;
    private final String lastName;
    private String street;
    private String city;
    private int cp;
    private final String birdthday;

    public Persona(String name, String lastName, String street, String city, int cp, String birdthday) {
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.cp = cp;
        this.birdthday = birdthday;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

}
