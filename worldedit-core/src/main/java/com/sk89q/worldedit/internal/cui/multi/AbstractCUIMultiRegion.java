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

import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class AbstractCUIMultiRegion implements CUIMultiRegion {

    private final String uuid;
    private final MultiRegionStyle style;
    private boolean gridSet;
    private double spacing;
    private boolean cull;

    protected AbstractCUIMultiRegion(MultiRegionStyle style) {
        this.uuid = UUID.randomUUID().toString();
        this.style = style;
    }

    protected AbstractCUIMultiRegion(MultiRegionStyle style, double gridSpacing, boolean gridCull) {
        this(style);
        this.gridSet = true;
        this.spacing = gridSpacing;
        this.cull = gridCull;
    }

    @Override
    public String getRegionID() {
        return uuid;
    }

    @Override
    public void describeCUI(LocalSession session, Actor player) {
        checkNotNull(session);
        checkNotNull(player);
        session.dispatchClientCUIEvent(player, new MultiRegionShapeEvent(getRegionID(), getTypeID()), getProtocolVersion());
        if (style != null) {
            session.dispatchClientCUIEvent(player, style, getProtocolVersion());
        }
        if (gridSet) {
            session.dispatchClientCUIEvent(player, new MultiRegionGridEvent(spacing, cull), getProtocolVersion());
        }
    }

    @Override
    public abstract String getTypeID();

}
