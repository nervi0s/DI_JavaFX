package addressapp;

public class Persona {

    private final int id;
    private final String name;
    private final String lastName;
    private String street;
    private String city;
    private int cp;
    private final String birdthday;
    private static int idIncrement = 0;

    public Persona(String name, String lastName, String street, String city, int cp, String birdthday) {
        this.id = ++idIncrement;
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.cp = cp;
        this.birdthday = birdthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirdthday() {
        return birdthday;
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

    public void guardarEnLaLista() {
        AddressAppFXMLController.lista.add(this);
        System.out.println(AddressAppFXMLController.lista);
    }

}
