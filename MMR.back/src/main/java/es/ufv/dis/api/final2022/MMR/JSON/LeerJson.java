package es.ufv.dis.api.final2022.MMR.JSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import es.ufv.dis.api.final2022.MMR.PDF.PDFManager;
import es.ufv.dis.api.final2022.MMR.Producto;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LeerJson {

    public ArrayList<Producto> leeFicheroJson(){
        PDFManager pdfManager = new PDFManager();
        try {
            //lee el fichero que le pasamos y lo carga en un reader
            Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/Productos.json"));
            // convierte el array JSON a un arraylist de users
            ArrayList<Producto> listaProductos = new Gson().fromJson(reader, new TypeToken<ArrayList<Producto>>() {}.getType());
            reader.close();// close reader

            pdfManager.crearPDF(listaProductos); // Backup
            return listaProductos;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>(); //si no ha leido nada, devuelve un array vacio
        }
    }
}

