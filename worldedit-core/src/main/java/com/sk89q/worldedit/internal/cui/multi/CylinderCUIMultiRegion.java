/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.internal.cui.multi;

import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.extension.platform.Actor;
import com.sk89q.worldedit.internal.cui.SelectionCylinderEvent;
import com.sk89q.worldedit.internal.cui.SelectionMinMaxEvent;
import com.sk89q.worldedit.internal.cui.SelectionPointEvent;
import com.sk89q.worldedit.regions.CylinderRegion;

import static com.google.common.base.Preconditions.checkNotNull;

public class CylinderCUIMultiRegion extends AbstractCUIMultiRegion {

    private final CylinderRegion region;

    public CylinderCUIMultiRegion(CylinderRegion region, MultiRegionStyle style) {
        super(style);
        checkNotNull(region);
        this.region = region;
    }

    public CylinderCUIMultiRegion(CylinderRegion region, MultiRegionStyle style, double gridSpacing, boolean gridCull) {
        super(style, gridSpacing, gridCull);
        checkNotNull(region);
        this.region = region;
    }

    @Override
    public void describeCUI(LocalSession session, Actor player) {
        super.describeCUI(session, player);
        session.dispatchClientCUIEvent(player,
                new WrappedMultiCUIEvent(new SelectionCylinderEvent(region.getCenter(), region.getRadius())),
                getProtocolVersion());
        session.dispatchClientCUIEvent(player,
                new WrappedMultiCUIEvent(new SelectionMinMaxEvent(region.getMinimumY(), region.getMaximumY())),
                getProtocolVersion());
    }

    @Override
    public String getTypeID() {
        return "cylinder";
    }
}
