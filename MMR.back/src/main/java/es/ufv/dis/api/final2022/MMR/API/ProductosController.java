package es.ufv.dis.api.final2022.MMR.API;

import es.ufv.dis.api.final2022.MMR.Lectura.LeerJson;
import es.ufv.dis.api.final2022.MMR.Producto;
import es.ufv.dis.api.final2022.MMR.Service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductosController {

    @GetMapping("/GET")
    public ArrayList<Producto> GET(){
        ArrayList<Producto> listaProductos = new LeerJson().leeFicheroJson();
    return listaProductos;
    }

    @PostMapping("/POST")
    public ResponseEntity<Producto> POST(@RequestBody @NonNull Producto producto){
        producto = new ProductoService().AltaProducto(producto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/DELETE/{productoID}")
    public ResponseEntity<Producto> DELETE(@PathVariable int productoID){
        new ProductoService().DeleteProducto(productoID);
        return ResponseEntity.ok().build();
    }


}
