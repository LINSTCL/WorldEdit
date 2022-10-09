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

import com.sk89q.worldedit.internal.cui.CUIEvent;

public class MultiRegionStyle implements CUIEvent {

    private String gridColor;
    private String edgeColor;
    private String primaryPointColor;
    private String secondaryPointColor;

    public MultiRegionStyle(String gridColor, String edgeColor, String primaryPointColor, String secondaryPointColor) {
        this.gridColor = gridColor;
        this.edgeColor = edgeColor;
        this.primaryPointColor = primaryPointColor;
        this.secondaryPointColor = secondaryPointColor;
    }

    public String getGridColor() {
        return gridColor;
    }

    public void setGridColor(String gridColor) {
        this.gridColor = gridColor;
    }

    public String getEdgeColor() {
        return edgeColor;
    }

    public void setEdgeColor(String edgeColor) {
        this.edgeColor = edgeColor;
    }

    public String getPrimaryPointColor() {
        return primaryPointColor;
    }

    public void setPrimaryPointColor(String primaryPointColor) {
        this.primaryPointColor = primaryPointColor;
    }

    public String getSecondaryPointColor() {
        return secondaryPointColor;
    }

    public void setSecondaryPointColor(String secondaryPointColor) {
        this.secondaryPointColor = secondaryPointColor;
    }

    @Override
    public String getTypeId() {
        return "+col";
    }

    @Override
    public String[] getParameters() {
        return new String[] { gridColor, edgeColor, primaryPointColor, secondaryPointColor };
    }
}
