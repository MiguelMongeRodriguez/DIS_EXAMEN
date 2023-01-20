package org.vaadin.example.Service;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.shared.Registration;
import org.springframework.web.client.RestTemplate;
import org.vaadin.example.Producto;


public class Formulario extends VerticalLayout {
    TextField nombre = new TextField("nombre");
    TextField categoria = new TextField("Categoría");
    TextField precio = new TextField("Precio");
    TextField EAN13 = new TextField("EAN13");

    public Formulario(Dialog dialog) {
        add(nombre, categoria, precio, EAN13);

        Button guardar = new Button("Guardar");
        guardar.addClickListener(e -> guardarForm(dialog));
        add(guardar);

        Button cancelar = new Button("Cancelar");
        cancelar.addClickListener(e -> cancelarForm(dialog));
        add(cancelar);
    }

    private void cancelarForm(Dialog dialog) {
        dialog.close();
    }

    private void guardarForm(Dialog dialog) {
        RestTemplate restTemplate = new RestTemplate();
        Producto nuevoProd = new Producto();
        nuevoProd.setNombre(nombre.getValue());
        nuevoProd.setCategoria(categoria.getValue());
        nuevoProd.setPrecio(Float.valueOf(precio.getValue().toString()));
        nuevoProd.setEan13(Long.parseLong(precio.getValue().toString()));
        restTemplate.postForEntity("http://localhost:8090/Productos", nuevoProd, Producto.class);
        dialog.close();
    }
}