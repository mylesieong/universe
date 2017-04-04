package com.myles.demo.ui.universities;

import com.myles.demo.ui.commons.UniverseMainUI;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;

@SpringView(name=UniversityLayoutFactory.NAME, ui=UniverseMainUI.class)
public class UniversityLayoutFactory extends VerticalLayout implements View{

    public static final String NAME = "operations";

    @Override
    public void enter(ViewChangeEvent event){
        this.addComponent(new Label("University Layout..."));
    }

}
