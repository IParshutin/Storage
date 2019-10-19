package com.parshutin.storage.forms;

import com.parshutin.storage.datasets.Product;
import com.parshutin.storage.datasets.ProductType;
import com.parshutin.storage.repositories.ProductRepository;
import com.parshutin.storage.view.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class MainForm extends FormLayout {
    private TextField title = new TextField("Title");
    private ComboBox<ProductType> type = new ComboBox<>("Product type");
//    private NumberField count2 = new NumberField("Count");
    private TextField count = new TextField("Count");
    private DatePicker deliveryDate = new DatePicker("Delivery date");
    private Button save = new Button("Save");
    private Button delete = new Button("delete");
    private HorizontalLayout buttons = new HorizontalLayout(save, delete);

    private Binder<Product> binder = new Binder<>(Product.class);

    private ProductRepository productRepository;
    private MainView mainView;

    public MainForm(ProductRepository productRepository, MainView mainView) {
        this.productRepository = productRepository;
        this.mainView = mainView;

        type.setItems(ProductType.values());

        binder.bindInstanceFields(this);

        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());

        add(title, type, count, deliveryDate, buttons);
    }

    private void save(){
        Product product = binder.getBean();
        productRepository.save(product);
        mainView.updateList();
    }

    private void delete(){
        Product product = binder.getBean();
        productRepository.delete(product);
        mainView.updateList();
    }

    public void setProduct(Product product){
        binder.setBean(product);
        title.focus();
    }
}
