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

package com.sk89q.worldedit.math;

import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.Vector;

/**
 * An immutable 3-dimensional vector.
 */
public class BlockVector3 {

    public static final Vector ZERO = new Vector(0, 0, 0);
    public static final Vector UNIT_X = new Vector(1, 0, 0);
    public static final Vector UNIT_Y = new Vector(0, 1, 0);
    public static final Vector UNIT_Z = new Vector(0, 0, 1);
    public static final Vector ONE = new Vector(1, 1, 1);

    protected final int x, y, z;

    /**
     * Construct an instance.
     *
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param z the Z coordinate
     */
    public BlockVector3(int x, int y, int z) {
        this.x = (int) x;
        this.y = (int) y;
        this.z = (int) z;
    }

    /**
     * Copy another vector.
     *
     * @param other another vector to make a copy of
     */
    public BlockVector3(Vector other) {
        this.x = (int) other.getX();
        this.y = (int) other.getY();
        this.z = (int) other.getZ();
    }

    /**
     * Construct a new instance with X, Y, and Z coordinates set to 0.
     *
     * <p>One can also refer to a static {@link #ZERO}.</p>
     */
    public BlockVector3() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public int getZ() {
        return (int) z;
    }

    public BlockVector toBlockVector() {
        return new BlockVector(
            Math.floor(x),
            Math.floor(y),
            Math.floor(z)
        );
    }

}

