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

package com.sk89q.worldedit.command.tool.brush;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.command.util.CreatureButcher;
import com.sk89q.worldedit.entity.Entity;
import com.sk89q.worldedit.extent.NullExtent;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.function.pattern.Pattern;
import com.sk89q.worldedit.function.visitor.EntityVisitor;
import com.sk89q.worldedit.regions.CylinderRegion;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.regions.RegionOperationException;

import java.util.List;

public class ButcherBrush implements Brush {

    private CreatureButcher flags;

    public ButcherBrush(CreatureButcher flags) {
        this.flags = flags;
    }

    @Override
    public void build(EditSession editSession, Vector position, Pattern pattern, double size) throws MaxChangedBlocksException {
        CylinderRegion region = CylinderRegion.createRadius(editSession, position, size);
        List<? extends Entity> entities = editSession.getEntities(region);
        Operations.completeLegacy(new EntityVisitor(entities.iterator(), flags.createFunction(editSession.getWorld().getWorldData().getEntityRegistry())));
    }

    @Override
    public Region getBounds(EditSession session, Vector position, double size) {
        CylinderRegion cyl = CylinderRegion.createRadius(session, position, size);
        try {
            cyl.contract(new Vector(0, -1, 0), new Vector(0, 1, 0));
            return cyl;
        } catch (RegionOperationException e) {
        }
        return cyl;
    }
}
