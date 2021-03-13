package utils;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import model.Persona;

//Se ha usado la siguiente librería para trabajar con XML: http://x-stream.github.io/index.html
public class PersonaConverter implements Converter {

    @Override
    public boolean canConvert(Class clazz) {
        return clazz.equals(Persona.class);
    }

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        Persona persona = (Persona) o;
        writer.startNode("id");
        writer.setValue(String.valueOf(persona.getId()));
        writer.endNode();
        writer.startNode("name");
        writer.setValue(persona.getName());
        writer.endNode();
        writer.startNode("lastName");
        writer.setValue(persona.getLastName());
        writer.endNode();
        writer.startNode("street");
        writer.setValue(persona.getStreet());
        writer.endNode();
        writer.startNode("city");
        writer.setValue(persona.getCity());
        writer.endNode();
        writer.startNode("cp");
        writer.setValue(String.valueOf(persona.getCp()));
        writer.endNode();
        writer.startNode("birdthday");
        writer.setValue(persona.getBirdthday());
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        Persona persona = new Persona("", "", "", "", 0, "");

        reader.moveDown();
        persona.setId(Integer.parseInt(reader.getValue()));
        reader.moveUp();

        reader.moveDown();
        persona.setName(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        persona.setLastName(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        persona.setStreet(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        persona.setCity(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        persona.setCp(Integer.parseInt(reader.getValue()));
        reader.moveUp();

        reader.moveDown();
        persona.setBirdthday(reader.getValue());
        reader.moveUp();

        return persona;
    }
}
