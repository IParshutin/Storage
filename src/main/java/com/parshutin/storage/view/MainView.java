package com.parshutin.storage.view;

import com.parshutin.storage.datasets.Product;
import com.parshutin.storage.repositories.ProductRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {
    private ProductRepository productRepository;

    private Grid<Product> grid = new Grid<>(Product.class);

    public MainView(ProductRepository productRepository) {
        this.productRepository = productRepository;

        grid.setColumns("title","type","count","deliveryDate");

        updateList();

        add(grid);
    }

    public void updateList(){
        grid.setItems(productRepository.findAll());
    }
}
