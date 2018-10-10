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
package com.github.naoghuman.app.nis.page.home;

import com.github.naoghuman.app.nis.configuration.ConfigurationPage;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import com.github.naoghuman.app.nis.page.Page;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @since  0.1.0-PRERELEASE
 * @author Naoghuman
 */
public class HomePresenter implements 
        ConfigurationPage, Initializable, Page
{
    private final ObservableList<String> buttons = FXCollections.observableArrayList();
     
    @FXML private FlowPane fpPageHome;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "HomePresenter.initialize(URL, ResourceBundle)"); // NOI18N
    
        this.initializeButtons();
    }
    
    private void initializeButtons() {
        LoggerFacade.getDefault().info(this.getClass(), "HomePresenter.initializeButtons()"); // NOI18N
    
        buttons.add(PAGE__HELP);
        buttons.add(PAGE__STATISTIC);
        buttons.add(PAGE__ABOUT);
    }

    @Override
    public String getKey() {
        return PAGE__HOME;
    }

    @Override
    public Node getView() {
        return fpPageHome;
    }

    @Override
    public ObservableList<String> getButtons() {
        return buttons;
    }
    
}
