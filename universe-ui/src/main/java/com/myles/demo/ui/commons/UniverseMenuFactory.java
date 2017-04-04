package com.myles.demo.ui.commons;

import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

import com.myles.demo.utils.StringUtils;

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

	    this.mainMenu.addItem(StringUtils.MENU_STUDENT.getString());
	    this.mainMenu.addItem(StringUtils.MENU_UNIVERSITY.getString());

	    this.mainMenu.expandItem(StringUtils.MENU_STUDENT.getString());
	    this.mainMenu.expandItem(StringUtils.MENU_UNIVERSITY.getString());

	    this.mainMenu.addItem(StringUtils.MENU_ADD_STUDENT.getString());
	    this.mainMenu.addItem(StringUtils.MENU_REMOVE_STUDENT.getString());
	    this.mainMenu.setChildrenAllowed(StringUtils.MENU_ADD_STUDENT.getString(), false);
	    this.mainMenu.setChildrenAllowed(StringUtils.MENU_REMOVE_STUDENT.getString(), false);
	    this.mainMenu.setParent(StringUtils.MENU_ADD_STUDENT.getString(), StringUtils.MENU_STUDENT.getString());
	    this.mainMenu.setParent(StringUtils.MENU_REMOVE_STUDENT.getString(), StringUtils.MENU_STUDENT.getString());

            this.mainMenu.addItem(StringUtils.MENU_OPERATIONS.getString());
	    this.mainMenu.setChildrenAllowed(StringUtils.MENU_OPERATIONS.getString(), false);
	    this.mainMenu.setParent(StringUtils.MENU_OPERATIONS.getString(), StringUtils.MENU_UNIVERSITY.getString());

            this.addComponent(this.mainMenu);
	    return this;
	}
    }

    public Component createComponent(){

        return new UniverseMenu().init().layout();

    }
}
