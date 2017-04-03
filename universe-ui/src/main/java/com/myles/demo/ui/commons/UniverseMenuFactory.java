package com.myles.demo.ui.commons;

import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniverseMenuFactory implements UIComponentBuilder {

    private class UniverseMenu extends VerticalLayout {

        private Tree mainMenu;

	public UniverseMenu init(){
	    this.mainMenu = new Tree();
            return this;
	}

	public UniverseMenu layout(){
            this.setWidth("100%");
            this.setHeightUndefined();

	    this.mainMenu.addItem("STUDENT");
	    this.mainMenu.addItem("UNIVERSITY");

	    this.mainMenu.expandItem("STUDENT");
	    this.mainMenu.expandItem("UNIVERSITY");

	    this.mainMenu.addItem("Add Student");
	    this.mainMenu.addItem("Remove Student");
	    this.mainMenu.setChildrenAllowed("Add Student", false);
	    this.mainMenu.setChildrenAllowed("Remove Student", false);
	    this.mainMenu.setParent("Add Student", "STUDENT");
	    this.mainMenu.setParent("Remove Student", "STUDENT");

            this.mainMenu.addItem("Operations");
	    this.mainMenu.setChildrenAllowed("Operations", false);
	    this.mainMenu.setParent("Operations", "UNIVERSITY");

            this.addComponent(this.mainMenu);
	    return this;
	}
    }

    public Component createComponent(){

        return new UniverseMenu().init().layout();

    }
}
