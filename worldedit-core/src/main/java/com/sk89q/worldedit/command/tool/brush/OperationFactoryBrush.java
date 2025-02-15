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
import com.sk89q.worldedit.function.Contextual;
import com.sk89q.worldedit.function.EditContext;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.function.pattern.Pattern;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.regions.factory.RegionFactory;

public class OperationFactoryBrush implements Brush {

    private final Contextual<? extends Operation> operationFactory;
    private final RegionFactory regionFactory;

    public OperationFactoryBrush(Contextual<? extends Operation> operationFactory, RegionFactory regionFactory) {
        this.operationFactory = operationFactory;
        this.regionFactory = regionFactory;
    }

    @Override
    public void build(EditSession editSession, Vector position, Pattern pattern, double size) throws MaxChangedBlocksException {
        EditContext context = new EditContext();
        context.setDestination(editSession);
        context.setRegion(regionFactory.createCenteredAt(position, size));
        context.setFill(pattern);
        Operation operation = operationFactory.createFromContext(context);
        Operations.completeLegacy(operation);
    }

    @Override
    public Region getBounds(EditSession session, Vector position, double size) {
        return regionFactory.createCenteredAt(position, size + 0.5D);
    }
}
