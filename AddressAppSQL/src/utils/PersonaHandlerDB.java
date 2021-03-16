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
            if (!personaExistInDB(persona, connection)) {
                insertPersona(persona, connection);
            } else {
                //No se guarda en la DB
            }
        }
    }

    private Persona personaParser(String name, String lastName, String street, String city, int cp, String birdthday) {
        Persona parsedPerson = new Persona(name, lastName, street, city, cp, birdthday);
        return parsedPerson;
    }

    private boolean personaExistInDB(Persona persona, Connection connection) {
        boolean existe = false;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM personas WHERE  id_persona = ? AND nombre = ? AND apellidos = ? AND calle = ? AND ciudad = ? AND cp = ? AND fecha_nacimiento = ?");

            ps.setInt(1, persona.getId());
            ps.setString(2, persona.getName());
            ps.setString(3, persona.getLastName());
            ps.setString(4, persona.getStreet());
            ps.setString(5, persona.getCity());
            ps.setInt(6, persona.getCp());
            ps.setString(7, persona.getBirdthday());

            ResultSet r = ps.executeQuery();
            existe = r.next();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaHandlerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
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
}
