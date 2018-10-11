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
package com.github.naoghuman.app.nis.page.statistic.statisticexerciseinfinite;

import com.airhacks.afterburner.views.FXMLView;
import com.github.naoghuman.app.nis.page.Page;
import java.util.Optional;

/**
 *
 * @since  0.1.0-PRERELEASE
 * @author Naoghuman
 */
public final class StatisticExerciseInfiniteView extends FXMLView {
    
    private static final Optional<StatisticExerciseInfiniteView> INSTANCE = Optional.of(new StatisticExerciseInfiniteView());
    
    private StatisticExerciseInfiniteView() {
        
    }
    
    /**
     * 
     * @return 
     * @since  0.1.0-PRERELEASE
     * @author Naoghuman
     */
    public static Page getPage() {
        return (Page) INSTANCE.get().getPresenter();
    }
    
}
