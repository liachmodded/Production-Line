/*
 * This file is part of GoodTime-Industrial, licensed under MIT License (MIT).
 *
 * Copyright (c) 2015 Minecraft-GoodTime <http://github.com/Minecraft-GoodTime>
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
package com.mcgoodtime.gti.common.network;

import com.mcgoodtime.gti.common.tiles.TileGti;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by suhao on 2015.10.18.0018.
 *
 * @author suhao
 */
public class BlockUpdateMessage implements IMessage {

    private NBTTagCompound nbt;

    public BlockUpdateMessage(){}

    public BlockUpdateMessage(int x, int y, int z, boolean isBurn) {
        nbt = new NBTTagCompound();
        nbt.setInteger("xPos", x);
        nbt.setInteger("yPos", y);
        nbt.setInteger("zPos", z);
        nbt.setBoolean("isBurn", isBurn);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        nbt = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, nbt);
    }

    public static class Handler implements IMessageHandler<BlockUpdateMessage, IMessage> {

        @Override
        public IMessage onMessage(BlockUpdateMessage message, MessageContext ctx) {
            WorldClient client = Minecraft.getMinecraft().theWorld;
            int x = message.nbt.getInteger("xPos");
            int y = message.nbt.getInteger("yPos");
            int z = message.nbt.getInteger("zPos");
            ((TileGti) client.getTileEntity(x, y, z)).setIsBurn(message.nbt.getBoolean("isBurn"));
            client.markBlockForUpdate(x, y, z);
            client.notifyBlockChange(x, y, z, client.getBlock(x, y, z));
            return null;
        }
    }
}
