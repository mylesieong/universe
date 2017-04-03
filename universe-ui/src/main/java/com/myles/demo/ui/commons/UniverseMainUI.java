package com.myles.demo.ui.commons;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path=UniverseMainUI.NAME)
@Title("UNIVERSE Title")
@Theme("valo")
public class UniverseMainUI extends UI {

	public static final String NAME = "/ui";

	private Panel changeTab = new Panel();

	@Autowired
        private UniverseLogoLayoutFactory universeLogoLayoutFactory;

	@Autowired
        private UniverseMenuFactory universeMenuFactory;

	@Override
	protected void init(VaadinRequest request) {
                changeTab.setHeight("100%");

		VerticalLayout rootLayout = new VerticalLayout();
		rootLayout.setSizeFull();
		rootLayout.setMargin(true);
		
		Panel contentPanel = new Panel();
		contentPanel.setWidth("75%");
		contentPanel.setHeight("100%");

		Panel logoPanel = new Panel();
		logoPanel.setWidth("75%");
		logoPanel.setHeightUndefined();

		HorizontalLayout uiLayout = new HorizontalLayout();
		uiLayout.setSizeFull();
		uiLayout.setMargin(true);
		
		Component logo = universeLogoLayoutFactory.createComponent();
		Component menu = universeMenuFactory.createComponent();

                uiLayout.addComponent(menu);
		uiLayout.addComponent(changeTab);

		uiLayout.setComponentAlignment(menu, Alignment.TOP_CENTER);
		uiLayout.setComponentAlignment(changeTab, Alignment.TOP_CENTER);

                uiLayout.setExpandRatio(menu, 1);
                uiLayout.setExpandRatio(changeTab, 2);

		logoPanel.setContent(logo);
		contentPanel.setContent(uiLayout);

		rootLayout.addComponent(logoPanel);
		rootLayout.addComponent(contentPanel);
		rootLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
		rootLayout.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);
                rootLayout.setExpandRatio(contentPanel, 1);

		setContent(rootLayout);
		
	}

}
