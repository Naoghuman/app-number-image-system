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
package com.github.naoghuman.app.nis.page;

import static com.github.naoghuman.app.nis.configuration.ConfigurationPage.RESOURCE_BUNDLE__PAGE;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.properties.core.PropertiesFacade;
import com.github.naoghuman.lib.validation.core.validator.PreConditionValidator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.control.Button;

/**
 *
 * @since  0.1.0-PRERELEASE
 * @author Naoghuman
 */
public final class PageButtonFactory {
    
    private static final ObservableMap<String, Button> BUTTONS    = FXCollections.observableHashMap();
    private static final ObservableMap<String, Button> THUMBNAILS = FXCollections.observableHashMap();
    
    /**
     * 
     * @param pages
     * @return 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static ObservableList<Button> create(final ObservableList<String> pages) {
        LoggerFacade.getDefault().debug(PageButtonFactory.class, "PageButtonFactory.create(ObservableList<String>)"); // NOI18N
        
        PreConditionValidator.getDefault().requireNonNull(pages);
        
        final ObservableList<Button> btns = FXCollections.observableArrayList();
        pages.forEach((page) -> {
            btns.add(PageButtonFactory.create(page));
        });
        
        return btns;
    }
    
    /**
     * 
     * @param page
     * @return 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static Button create(final String page) {
        PreConditionValidator.getDefault().requireNonNullAndNotEmpty(page);
        
        if (!BUTTONS.containsKey(page)) {
            LoggerFacade.getDefault().debug(PageButtonFactory.class, "PageButtonFactory.create(String)"); // NOI18N
        
            final Button btn = new Button();
            btn.setText(PropertiesFacade.getDefault().getProperty(RESOURCE_BUNDLE__PAGE, page));
            btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            btn.setPrefWidth(82.0d);
            btn.setOnAction((event) -> {
                PageManager.getDefault().switchTo(page);
            });
            
            BUTTONS.put(page, btn);
        }
        
        return BUTTONS.get(page);
    }
    
    /**
     * 
     * @param page
     * @return 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static Button thumbnail(final String page) {
        PreConditionValidator.getDefault().requireNonNullAndNotEmpty(page);
        
        if (!THUMBNAILS.containsKey(page)) {
            LoggerFacade.getDefault().debug(PageButtonFactory.class, "PageButtonFactory.thumbnail(String)"); // NOI18N
        
            final Button btn = new Button();
            btn.setText(PropertiesFacade.getDefault().getProperty(RESOURCE_BUNDLE__PAGE, page));
            btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            btn.setPrefWidth(128.0d);
            btn.setPrefHeight(96.0d);
            btn.setOnAction((event) -> {
                PageManager.getDefault().switchTo(page);
            });
            
            THUMBNAILS.put(page, btn);
        }
        
        return THUMBNAILS.get(page);
    }
    
}
