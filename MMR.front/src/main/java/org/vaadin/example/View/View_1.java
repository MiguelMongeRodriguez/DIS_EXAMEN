package org.vaadin.example.View;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.vaadin.example.Producto;
import org.vaadin.example.Service.Formulario;

import java.util.ArrayList;

@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@Route(value = "view1", layout = MainView.class)
@PageTitle("Productos")
public class View_1 extends VerticalLayout {
    Grid<Producto> grid = new Grid<>(Producto.class);
    Formulario formulario = new Formulario();
    Dialog ventana = new Dialog();
    Button add = new Button("Quiero darme de Alta");

    public View_1() {

        addClassName("List-view");
        setSizeFull();

        configureGrid(); //Grid de datos
        add(
                getToolbar(),
                getContent()
        );
    }

    private Component getToolbar() {
        Button DeleteButton = new Button("Eliminar Producto seleccionado");
        DeleteButton.addClickListener(e -> eliminarProductoSeleccionado());
        HorizontalLayout toolbar=new HorizontalLayout(DeleteButton);
        toolbar.addClassName("Toolbar");
        return toolbar;
    }

    private void eliminarProductoSeleccionado() {
        Producto producto = grid.getSelectedItems().iterator().next();
        int productoID = producto.getId();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8090/DELETE/{productoID}", productoID);

        configureGrid();
    }
    private Component getContent() {
        HorizontalLayout content= new HorizontalLayout(grid);
        content.setFlexGrow(2,grid);
        content.addClassName("contect");
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayList<Producto>> response = restTemplate.exchange("http://localhost:8090/Productos",
                HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<Producto>>() {});
        ArrayList<Producto> listaProductos = response.getBody();
        grid.addClassName("contact-grid");
        grid.setSizeFull();

        grid.setColumns("id","nombre","categoria","precio", "ean13");
        grid.setItems(listaProductos);
    }
}
