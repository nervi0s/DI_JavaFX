package addressapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

    private final int id;
    private StringProperty name;
    private StringProperty lastName;
    private String street;
    private String city;
    private int cp;
    private String birdthday;
    private static int idIncrement = 0;

    public Persona(String name, String lastName, String street, String city, int cp, String birdthday) {
        this.id = ++idIncrement;
        setName(name);
        setLastName(lastName);
        this.street = street;
        this.city = city;
        this.cp = cp;
        this.birdthday = birdthday;
    }

    public int getId() {
        return id;
    }

    public StringProperty nameProperty() {
        if (name == null) {
            name = new SimpleStringProperty(this, "name");
        }
        return name;
    }

    public String getName() {
        return nameProperty().getValue();
    }

    public void setName(String name) {
        nameProperty().set(name);
    }

    public StringProperty lastNameProperty() {
        if (lastName == null) {
            lastName = new SimpleStringProperty(this, "lastName");
        }
        return lastName;
    }

    public String getLastName() {
        return lastNameProperty().getValue();
    }

    public void setLastName(String lastName) {
        lastNameProperty().set(lastName);
    }

    public String getBirdthday() {
        return birdthday;
    }

    public void setBirdthday(String birdthday) {
        this.birdthday = birdthday;
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
