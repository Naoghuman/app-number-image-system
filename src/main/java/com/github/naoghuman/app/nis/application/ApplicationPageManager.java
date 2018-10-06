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

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.util.Optional;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @since  0.1.0-PRERELEASE
 * @author Naoghuman
 */
public final class ApplicationPageManager {
    
    private static AnchorPane anchorPane;
    
    public static void configure(final AnchorPane anchorPane) {
        LoggerFacade.getDefault().info(ApplicationPageManager.class, "ApplicationPageManager.configure(AnchorPane)"); // NOI18N
        
        ApplicationPageManager.anchorPane = anchorPane;
    }
    
    private static FadeTransition hidePage(final Node previous) {
        LoggerFacade.getDefault().debug(ApplicationPageManager.class, "ApplicationPageManager.hidePage(Node)"); // NOI18N
        
        final FadeTransition ft = new FadeTransition();
        ft.setAutoReverse(false);
        ft.setCycleCount(1);
        ft.setDelay(Duration.millis(75.0d));
        ft.setDuration(Duration.millis(125.0d));
        ft.setFromValue(1.0d);
        ft.setNode(previous);
        ft.setToValue(0.0d);
        ft.setOnFinished(event -> {
            anchorPane.getChildren().remove(previous);
        });
        
        return ft;
    }
    
    private static FadeTransition showPage(final Node node) {
        LoggerFacade.getDefault().debug(ApplicationPageManager.class, "ApplicationPageManager.showPage(Node)"); // NOI18N
        
        node.setOpacity(0.0d);
        
        final FadeTransition ft = new FadeTransition();
        ft.setAutoReverse(false);
        ft.setCycleCount(1);
        ft.setDelay(Duration.millis(125.0d));
        ft.setDuration(Duration.millis(150.0d));
        ft.setFromValue(0.0d);
        ft.setNode(node);
        ft.setToValue(1.0d);
        
        return ft;
    }
    
    public static void switchToPage(final Optional<Node> previous, final Node node) {
        LoggerFacade.getDefault().debug(ApplicationPageManager.class, "ApplicationPageManager.switchToPage(Optional<Node>, Node)"); // NOI18N
        
        final SequentialTransition st = new SequentialTransition();
        st.setAutoReverse(false);
        st.setCycleCount(1);
        
        // hide previous node
        if (previous.isPresent()) {
            st.getChildren().add(ApplicationPageManager.hidePage(previous.get()));
        }
        
        // show previous node
        st.getChildren().add(ApplicationPageManager.showPage(node));
        
        st.playFromStart();
    }
    
}
