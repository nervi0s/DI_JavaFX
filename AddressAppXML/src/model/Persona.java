package model;

import controllers.AddressAppFXMLController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

    private int id;
    private StringProperty name; //Se usa StringProperty para setear en las columnas de la tabla las varibles de las cuales queremos observar sus cambios
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

    public void setId(int id) {
        this.id = id;
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

    //Una persona se puede guardar en la lista observable
    public void guardarEnLaLista() {
        AddressAppFXMLController.lista.add(this);
        System.out.println("Persona añadida a lista ObservableList<Persona>");
    }
}
