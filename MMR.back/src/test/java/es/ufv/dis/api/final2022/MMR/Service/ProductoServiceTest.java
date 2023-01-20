package es.ufv.dis.api.final2022.MMR.Service;

import es.ufv.dis.api.final2022.MMR.API.ProductosController;
import es.ufv.dis.api.final2022.MMR.JSON.LeerJson;
import es.ufv.dis.api.final2022.MMR.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductoServiceTest {

    ProductosController productosController = new ProductosController();
    LeerJson leerJson = new LeerJson();
    Producto mockProd= new Producto("Mochila", "Ropa", 39.99f, 453734034, 0);
    Producto expectedProd;

    @BeforeEach
    public void init(){

    }

    @Test
    void altaProducto() {
        //ARRANGE
        ArrayList<Producto> lista = new ArrayList<>();
        //ACT
        productosController.POST(mockProd);
        lista = leerJson.leeFicheroJson();
        expectedProd = lista.get(lista.size()-1);
        //ASSERT
        assertEquals(expectedProd.toString(), mockProd.toString());
    }
}