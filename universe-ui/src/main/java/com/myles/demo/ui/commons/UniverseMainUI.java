package com.myles.demo.ui.commons;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path=UniverseMainUI.NAME)
@Title("UNIVERSE Title")
@Theme("valo")
public class UniverseMainUI extends UI {

	public static final String NAME = "/ui";

	@Override
	protected void init(VaadinRequest request) {

		VerticalLayout rootLayout = new VerticalLayout();
		rootLayout.addComponent(new Label("Hello Vaadin!"));
		setContent(rootLayout);
		
	}

}
