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

import com.github.naoghuman.app.nis.configuration.ConfigurationApplication;
import com.github.naoghuman.app.nis.configuration.ConfigurationPage;
import com.github.naoghuman.app.nis.page.PageManager;
import com.github.naoghuman.lib.action.core.Registerable;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.validation.core.validator.PreConditionValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @since  0.1.0-PRERELEASE
 * @author Naoghuman
 */
public class ApplicationPresenter implements 
        ConfigurationApplication, ConfigurationPage, Initializable,
        Registerable
{
    @FXML private ScrollPane spPageArea;
    @FXML private Text       tPageName;
    @FXML private VBox       vbPageButtons;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initialize(URL, ResourceBundle)"); // NOI18N
        
        this.initializeHomePage();
    }
    
    private void initializeHomePage() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initializeHomePage()"); // NOI18N
        
        PreConditionValidator.getDefault().requireNonNull(tPageName);
        PreConditionValidator.getDefault().requireNonNull(spPageArea);
        PreConditionValidator.getDefault().requireNonNull(vbPageButtons);
        
        PageManager.getDefault().register(tPageName, spPageArea, vbPageButtons);
        PageManager.getDefault().switchTo(PAGE__HOME);
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.register()"); // NOI18N

    }
    
}
