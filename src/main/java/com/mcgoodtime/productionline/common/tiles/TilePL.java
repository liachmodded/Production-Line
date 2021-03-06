/*
 * This file is part of GoodTime-Industrial, licensed under MIT License (MIT).
 *
 * Copyright (c) 2015 GoodTime Studio <https://github.com/GoodTimeStudio>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mcgoodtime.productionline.common.tiles;

import com.mcgoodtime.productionline.common.network.PLNetwork;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by suhao on 2015.7.1.
 *
 * @author suhao
 */
public class TilePL extends TileEntity {

    public short facing;
    public boolean active;

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        facing = nbt.getShort("facing");
        active = nbt.getBoolean("active");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("facing", facing);
        nbt.setBoolean("active", active);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        NBTTagCompound nbt = pkt.func_148857_g();
        this.facing = nbt.getShort("facing");
        this.active = nbt.getBoolean("active");
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound sync = new NBTTagCompound();
        sync.setShort("facing", this.facing);
        sync.setBoolean("active", this.active);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, sync);
    }

    public void setActive(boolean active) {
        this.active = active;
        PLNetwork.updateBlockDisplayState(this);
    }

    public void setFacing(short facing) {
        this.facing = facing;
        PLNetwork.updateBlockDisplayState(this);
    }
}
