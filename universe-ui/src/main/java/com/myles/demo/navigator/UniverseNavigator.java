package com.myles.demo.navigator;

import com.google.gwt.thirdparty.guava.common.base.Strings; 

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class  UniverseNavigator extends Navigator {
   
    public UniverseNavigator(UI ui, SingleComponentContainer container){
        super(ui, container);
    }

    private static UniverseNavigator getNavigator(){
        UI ui = UI.getCurrent();
	Navigator navigator = ui.getNavigator();
	return (UniverseNavigator)navigator;
    }

    public static void navigate(String path){
        try {
            UniverseNavigator.getNavigator().navigateTo(path);    
	} catch (Exception e){
	    e.printStackTrace();
	}
    }

    @Override
    public void navigateTo(String viewName){
        super.navigateTo(Strings.nullToEmpty(viewName));
    }

}
