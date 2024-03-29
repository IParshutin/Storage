package com.parshutin.storage.view;

import com.parshutin.storage.datasets.Product;
import com.parshutin.storage.forms.MainForm;
import com.parshutin.storage.repositories.ProductRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {
    private ProductRepository productRepository;
    private MainForm mainForm;

    private TextField filter = new TextField();
    private Button addProduct = new Button("Add product");
    private Grid<Product> grid = new Grid<>(Product.class);

    public MainView(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.mainForm = new MainForm(productRepository, this);

        addProduct.addClickListener(e -> mainForm.setProduct(new Product()));

        filter.setPlaceholder("Filter by title");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> updateList());

        grid.setColumns("title","type","count","deliveryDate");
        grid.asSingleSelect().addValueChangeListener(e ->
                mainForm.setProduct(grid.asSingleSelect().getValue()));
        grid.getColumnByKey("title").setWidth("370px");
        grid.setSizeFull();

        updateList();

        HorizontalLayout header = new HorizontalLayout(filter, addProduct);

        HorizontalLayout content = new HorizontalLayout(grid, mainForm);
        content.setSizeFull();

        setSizeFull();

        add(header, content);
    }

    public void updateList(){
        grid.setItems(productRepository.findByTitleStartsWithIgnoreCase(filter.getValue()));
    }
}
