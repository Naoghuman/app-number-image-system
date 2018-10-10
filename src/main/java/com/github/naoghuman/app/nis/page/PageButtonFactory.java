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
    
    private static final ObservableMap<String, Button> BUTTON_CACHE = FXCollections.observableHashMap();
    
    /**
     * 
     * @param buttons
     * @return 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static ObservableList<Button> create(final ObservableList<String> buttons) {
        LoggerFacade.getDefault().debug(PageButtonFactory.class, "PageButtonFactory.create(ObservableList<String>)"); // NOI18N
        
        PreConditionValidator.getDefault().requireNonNull(buttons);
        
        final ObservableList<Button> btns = FXCollections.observableArrayList();
        buttons.forEach((button) -> {
            btns.add(PageButtonFactory.create(button));
        });
        
        return btns;
    }
    
    /**
     * 
     * @param button
     * @return 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static Button create(final String button) {
        PreConditionValidator.getDefault().requireNonNullAndNotEmpty(button);
        
        if (!BUTTON_CACHE.containsKey(button)) {
            LoggerFacade.getDefault().debug(PageButtonFactory.class, "PageButtonFactory.create(String)"); // NOI18N
        
            final Button btn = new Button();
            btn.setText(PropertiesFacade.getDefault().getProperty(RESOURCE_BUNDLE__PAGE, button));
            btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            btn.setPrefWidth(82.0d);
            btn.setOnAction((event) -> {
                PageManager.getDefault().switchTo(button);
            });
            
            BUTTON_CACHE.put(button, btn);
        }
        
        return BUTTON_CACHE.get(button);
    }
    
}
