package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Persona;

public class PersonaHandlerDB {

    public PersonaHandlerDB() {

    }

    public ArrayList<Persona> getPersonasFromDB(Connection connection) {
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM personas");
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                //Mapeamos los datos obtenidos de la DB
                Persona p = personaParser(res.getString("nombre"), res.getString("apellidos"), res.getString("calle"), res.getString("ciudad"), res.getInt("cp"), res.getString("fecha_nacimiento"));
                //Seteamos a cada persona su correspondiente ID
                p.setId(res.getInt("id_persona"));
                Persona.idIncrement = res.getInt("id_persona");//En caso de que existan personas en la DB, asignamos a la variable estática el último id de la DB
                //Añadimos la persona obtenido dela DB al ArrayList
                personas.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaHandlerDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personas;
    }

    public void savePersonasInDB(ArrayList<Persona> listaPersonas, Connection connection) {
        for (Persona persona : listaPersonas) {
            if (!personaExistInDB(persona, connection)) {//Si la persona de la lista NO existe en la DB
                insertPersona(persona, connection);
            } else {//Si la persona de la lista existe en la DB
                if (personaWasModified(persona, connection)) {//Si la persona de la lista ha sido modificada
                    System.out.println("persona modificada");
                    updatePersona(persona, connection);
                } else {//Si no hay cambios en la lista
                    System.out.println("no hay cambios para guardar");
                }
            }
        }
    }

    private Persona personaParser(String name, String lastName, String street, String city, int cp, String birdthday) {
        Persona parsedPerson = new Persona(name, lastName, street, city, cp, birdthday);
        return parsedPerson;
    }

    private Persona personaParser(int id, String name, String lastName, String street, String city, int cp, String birdthday) {
        Persona parsedPerson = new Persona(id, name, lastName, street, city, cp, birdthday);
        return parsedPerson;
    }

    private boolean personaExistInDB(Persona persona, Connection connection) {
        boolean existe = false;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM personas WHERE  id_persona = ?");

            ps.setInt(1, persona.getId());

            ResultSet r = ps.executeQuery();
            existe = r.next();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaHandlerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }

    private boolean personaWasModified(Persona persona, Connection connection) {
        boolean modified = false;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM personas WHERE  id_persona = ?");

            ps.setInt(1, persona.getId());

            ResultSet r = ps.executeQuery();
            r.next();
            Persona parsedPerson = personaParser(r.getInt("id_persona"), r.getString("nombre"), r.getString("apellidos"), r.getString("calle"), r.getString("ciudad"), r.getInt("cp"), r.getString("fecha_nacimiento"));
            modified = !(persona.esIgual(parsedPerson));
        } catch (SQLException ex) {
            Logger.getLogger(PersonaHandlerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modified;
    }

    public void insertPersona(Persona persona, Connection c) {
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO personas VALUES(?, ?, ?, ?, ?, ?, ?)");

            ps.setInt(1, persona.getId());
            ps.setString(2, persona.getName());
            ps.setString(3, persona.getLastName());
            ps.setString(4, persona.getStreet());
            ps.setString(5, persona.getCity());
            ps.setInt(6, persona.getCp());
            ps.setString(7, persona.getBirdthday());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaHandlerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePersona(Persona persona, Connection c) {
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE personas SET nombre = ?, apellidos = ?, calle = ?, ciudad = ?, cp = ?, fecha_nacimiento = ? WHERE id_persona = ?");

            ps.setString(1, persona.getName());
            ps.setString(2, persona.getLastName());
            ps.setString(3, persona.getStreet());
            ps.setString(4, persona.getCity());
            ps.setInt(5, persona.getCp());
            ps.setString(6, persona.getBirdthday());
            ps.setInt(7, persona.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaHandlerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
