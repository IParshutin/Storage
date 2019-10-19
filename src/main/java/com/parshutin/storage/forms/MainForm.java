package com.parshutin.storage.forms;

import com.parshutin.storage.datasets.Product;
import com.parshutin.storage.repositories.ProductRepository;
import com.parshutin.storage.view.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class MainForm extends FormLayout {
    private TextField title = new TextField("Title");
    private ComboBox<Product> type = new ComboBox<>("Product type");
    private TextField count = new TextField("Count");
    private DatePicker deliveryDate = new DatePicker("Delivery date");
    private Button save = new Button("Save");
    private Button delete = new Button("delete");
    private HorizontalLayout buttons = new HorizontalLayout(save,delete);

    private ProductRepository productRepository;
    private MainView mainView;

    public MainForm(ProductRepository productRepository, MainView mainView) {
        this.productRepository = productRepository;
        this.mainView = mainView;

        add(title, type, count, deliveryDate, buttons);
    }
}
