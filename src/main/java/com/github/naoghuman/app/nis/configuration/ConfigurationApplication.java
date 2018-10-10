/*
 * Copyright (C) 2017 Naoghuman
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
package com.github.naoghuman.app.nis.configuration;

import javafx.util.Duration;

/**
 *
 * @since  0.1.0-PRERELEASE
 * @author Naoghuman
 */
public interface ConfigurationApplication {
    
    /**
     * 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static final Duration DURATION__125 = Duration.millis(125.0d);
    
    /**
     * 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static final String RESOURCE_BUNDLE__APPLICATION = "/com/github/naoghuman/app/nis/application/application.properties"; // NOI18N
    
    /**
     * 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static final String APPLICATION__BORDER_SIGN = "application.border.sign"; // NOI18N
    
    /**
     * 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static final String APPLICATION__BUILD_DATETIME = "application.build.datetime"; // NOI18N
    
    /**
     * 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static final String APPLICATION__DATABASE = "application.database"; // NOI18N
    
    /**
     * 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static final String APPLICATION__MESSAGE_START = "application.message.start"; // NOI18N
    
    /**
     * 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static final String APPLICATION__MESSAGE_STOP = "application.message.stop"; // NOI18N
    
    /**
     * 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static final String APPLICATION__TITLE = "application.title"; // NOI18N
    
    /**
     * 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static final String APPLICATION__VERSION = "application.version"; // NOI18N
    
}
