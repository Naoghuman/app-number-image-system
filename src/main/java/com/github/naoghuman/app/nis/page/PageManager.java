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

import com.github.naoghuman.app.nis.page.about.AboutView;
import com.github.naoghuman.app.nis.page.help.HelpView;
import com.github.naoghuman.app.nis.page.home.HomeView;
import com.github.naoghuman.app.nis.page.statistic.StatisticView;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.validation.core.validator.PreConditionValidator;
import java.util.Optional;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * 
 * @since  0.1.0-PRERELEASE
 * @author Naoghuman
 */
public final class PageManager {
    
    private static final Optional<PageManager> INSTANCE = Optional.of(new PageManager());
    
    /**
     * 
     * @return 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static PageManager getDefault() {
        return INSTANCE.get();
    }
    
    private final ObservableList<Page> pages = FXCollections.observableArrayList();
    
    private Optional<Page> previousPage = Optional.empty();
    
    private ScrollPane spPageArea;
    private Text       pageName;
    private VBox       vbPageButtons;
    
    private PageManager() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "PageManager.initialize()"); // NOI18N
        
        pages.add(AboutView.getPage());
        pages.add(HelpView.getPage());
        pages.add(HomeView.getPage());
        pages.add(StatisticView.getPage());
    }
    
    /**
     * 
     * @param  pageName
     * @param  spPageArea
     * @param  vbPageButtons 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public void register(final Text pageName, final ScrollPane spPageArea, final VBox vbPageButtons) {
        LoggerFacade.getDefault().debug(this.getClass(), "PageManager.register(Text, ScrollPane)"); // NOI18N
        
        PreConditionValidator.getDefault().requireNonNull(pageName);
        PreConditionValidator.getDefault().requireNonNull(spPageArea);
        PreConditionValidator.getDefault().requireNonNull(vbPageButtons);
        
        this.pageName      = pageName;
        this.spPageArea    = spPageArea;
        this.vbPageButtons = vbPageButtons;
    }
    
//    private FadeTransition hide(final Page previous) {
//        LoggerFacade.getDefault().debug(this.getClass(), "PageManager.hide(Page)"); // NOI18N
//        
//        PreConditionValidator.getDefault().requireNonNull(previous);
//        
//        return null;
//    } 
    
//    private FadeTransition show(final Page page) {
//        LoggerFacade.getDefault().debug(this.getClass(), "PageManager.show(Page)"); // NOI18N
//        
//        PreConditionValidator.getDefault().requireNonNull(page);
//        
//        return null;
//    }
    
    /**
     * 
     * @param  page 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public void switchTo(final String page) {
        LoggerFacade.getDefault().debug(this.getClass(), "PageManager.switchTo(String)"); // NOI18N
        
        PreConditionValidator.getDefault().requireNonNullAndNotEmpty(page);
        
        // Hide previous

        // show new

        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.ONE);
        pt.setOnFinished(event -> {
            pages.stream()
                .filter(p -> p.getKey().equals(page))
                .forEach(p -> {
                    LoggerFacade.getDefault().debug(this.getClass(), "Found: " + p.getKey()); // NOI18N
        
                    pageName.setText(null);
                    pageName.setText(p.getKey());
                    
                    spPageArea.setContent(null);
                    spPageArea.setContent(p.getView());
                    
                    vbPageButtons.getChildren().clear();
                    vbPageButtons.getChildren().addAll(PageButtonFactory.create(p.getButtons()));
                });
        });
        
        pt.playFromStart();
    }
    
}
