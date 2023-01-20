package es.ufv.dis.api.final2022.MMR.Service;

import com.google.gson.Gson;
import es.ufv.dis.api.final2022.MMR.JSON.LeerJson;
import es.ufv.dis.api.final2022.MMR.PDF.PDFManager;
import es.ufv.dis.api.final2022.MMR.Producto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ProductoService {

    PDFManager pdfManager = new PDFManager();

    public Producto AltaProducto(Producto producto) {
        Gson gson = new Gson();
        ArrayList<Producto> listaProductos = new LeerJson().leeFicheroJson();

        listaProductos = actualizarIds(listaProductos);
        int maxid = listaProductos.size() + 1;
        producto.setId(maxid);
        listaProductos.add(producto);


        try {
            FileWriter writer = new FileWriter("./src/main/resources/Productos.json");
            writer.write(gson.toJson(listaProductos));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pdfManager.crearPDF(listaProductos);//Backup
        return producto;
    }

    public void DeleteProducto(int productoID) {
        Gson gson = new Gson();
        ArrayList<Producto> listaProductos = new LeerJson().leeFicheroJson();
        ArrayList<Producto> listaFinal = new ArrayList<Producto>();


        for (Producto producto : listaProductos) {
            if(producto.getId() != productoID){
                listaFinal.add(producto);
            }
        }
        listaFinal = actualizarIds(listaFinal);

        try {
            FileWriter writer = new FileWriter("./src/main/resources/Productos.json");
            writer.write(gson.toJson(listaFinal));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pdfManager.crearPDF(listaProductos);//Backup
    }

    public ArrayList<Producto> actualizarIds(ArrayList<Producto> listaProductos) {
        for (int i = 0; i < listaProductos.size(); i++) {
            listaProductos.get(i).setId(i + 1);
        }
        return listaProductos;
    }
}
