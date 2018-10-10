/*
 * Copyright (C) 2018 Naoghuman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.app.nis.application;

import com.airhacks.afterburner.injection.Injector;
import com.github.naoghuman.app.nis.configuration.ConfigurationApplication;
import com.github.naoghuman.app.nis.configuration.ConfigurationPage;
import com.github.naoghuman.lib.database.core.DatabaseFacade;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.lib.properties.core.PropertiesFacade;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @since  0.1.0-PRERELEASE
 * @author Naoghuman
 */
public class ApplicationStart extends Application implements 
        ConfigurationApplication, ConfigurationPage
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        
        PropertiesFacade.getDefault().register(RESOURCE_BUNDLE__APPLICATION);
        PropertiesFacade.getDefault().register(RESOURCE_BUNDLE__PAGE);
        
        final char borderSign = this.getProperty(APPLICATION__BORDER_SIGN).charAt(0);
        final String message  = this.getProperty(APPLICATION__MESSAGE_START);
        final String title    = this.getProperty(APPLICATION__TITLE)
                              + this.getProperty(APPLICATION__VERSION);
        LoggerFacade.getDefault().message(borderSign, 80, String.format(message, title));
        
        final Boolean dropPreferencesFileAtStart = Boolean.FALSE;
        PreferencesFacade.getDefault().init(dropPreferencesFileAtStart);
        
        DatabaseFacade.getDefault().register(this.getProperty(APPLICATION__DATABASE));
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        final ApplicationView view = new ApplicationView();
        
        final Scene scene = new Scene(view.getView(), 400, 250);
        primaryStage.setTitle(
                this.getProperty(APPLICATION__TITLE)
                        + this.getProperty(APPLICATION__VERSION));
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest((WindowEvent we) -> {
           we.consume();
           
           this.onCloseRequest();
        });
        
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        Injector.forgetAll();
    }
    
    private String getProperty(String propertyKey) {
        return PropertiesFacade.getDefault().getProperty(RESOURCE_BUNDLE__APPLICATION, propertyKey);
    }
    
    private void onCloseRequest() {
        // afterburner.fx
        Injector.forgetAll();
        
        // Database
        DatabaseFacade.getDefault().shutdown();
        
        // Message
        final char borderSign = this.getProperty(APPLICATION__BORDER_SIGN).charAt(0);
        final String message = this.getProperty(APPLICATION__MESSAGE_STOP);
        final String title = this.getProperty(APPLICATION__TITLE) + this.getProperty(APPLICATION__VERSION);
        LoggerFacade.getDefault().message(borderSign, 80, String.format(message, title));
        
        // Timer
        final PauseTransition pt = new PauseTransition(DURATION__125);
        pt.setOnFinished((ActionEvent event) -> {
            Platform.exit();
        });
        pt.playFromStart();
    }
    
}
