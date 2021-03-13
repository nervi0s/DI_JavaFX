package utils;

import com.thoughtworks.xstream.XStream;//Se usa la librería XStream para trabajar con XML
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Persona;

//Se ha usado la siguiente librería para trabajar con XML: http://x-stream.github.io/index.html
public class FileHandler {

    private final File file;

    public FileHandler(String path) {
        file = new File(path);
    }

    public boolean fileHandlerExist() {
        return file.exists();
    }

    public ArrayList<Persona> leerListaPersonas() {
        XStream xstream = new XStream();
        xstream.registerConverter(new PersonaConverter());
        xstream.alias("persona", Persona.class);

        ArrayList<Persona> listaPersonas = (ArrayList<Persona>) xstream.fromXML(file);
        return listaPersonas;
    }

    public void escribirListaXMLPersonas(ArrayList<Persona> listaPersonas) throws IOException {
        FileWriter fw = new FileWriter(file);

        XStream xstream = new XStream();
        xstream.registerConverter(new PersonaConverter());
        xstream.alias("persona", Persona.class);

        xstream.toXML(listaPersonas, fw);
    }
}
