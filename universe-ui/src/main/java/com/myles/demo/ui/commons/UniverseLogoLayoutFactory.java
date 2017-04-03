package com.myles.demo.ui.commons;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniverseLogoLayoutFactory implements UIComponentBuilder {

    private class LogoLayout extends VerticalLayout {

        private Embedded logo;

	public LogoLayout init(){
	    this.logo = new Embedded();
	    this.logo.setSource(new ThemeResource("../../images/orpheus.jpg"));
	    this.logo.setWidth("674px");
	    this.logo.setHeight("346px");
	    return this;
	}

        public LogoLayout layout(){
           this.addComponent(logo);
	   this.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
	   return this;
	}

    }

    public Component createComponent(){
        return new LogoLayout().init().layout();
    }
}
