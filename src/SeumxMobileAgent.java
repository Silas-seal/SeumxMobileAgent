package com.seumxmobileagent;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;  
import javafx.stage.Stage;

public class SeumxMobileAgent extends MobileApplication {

    @Override
    public void init() {
        addViewFactory(HOME_VIEW, BasicView::new);
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        ((Stage) scene.getWindow()).getIcons().add(new Image(SeumxMobileAgent.class.getResourceAsStream("/logo2.png")));
        ((Stage) scene.getWindow()).setTitle("Seumx Mobile Agent"); 
    }
}
