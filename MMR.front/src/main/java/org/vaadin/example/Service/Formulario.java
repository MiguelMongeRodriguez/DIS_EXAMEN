package org.vaadin.example.Service;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.web.client.RestTemplate;
import org.vaadin.example.Producto;

import java.time.format.DateTimeFormatter;


public class Formulario {

    public static class formulario extends VerticalLayout {
        TextField nombre = new TextField("nombre");
        TextField categoria = new TextField("Categoría");
        TextField precio = new TextField("Precio");
        TextField EAN13 = new TextField("EAN13");

        public formulario() {
            add(nombre, categoria, precio, EAN13);
            Button guardar = new Button("Guardar");
            guardar.addClickListener(e -> guardarForm());
            add(guardar);
        }
        private void guardarForm() {
            RestTemplate restTemplate = new RestTemplate();
            Producto nuevoProd = new Producto();
            nuevoProd.setNombre(nombre.getValue());
            nuevoProd.setCategoria(categoria.getValue());
            nuevoProd.setPrecio(Float.valueOf(precio.getValue().toString()));
            nuevoProd.setEan13(Long.parseLong(precio.getValue().toString()));
            restTemplate.postForEntity("http://localhost:8090/Productos", nuevoProd, Producto.class);
        }
    }
}