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
package com.mcgoodtime.productionline.common.worldgen;

import com.mcgoodtime.productionline.common.init.PLBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.core.Ic2Items;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by BestOwl on 2015.10.31.0031.
 *
 * ProductionLine world gen.
 * @author BestOwl
 */
public class PLWorldGen implements IWorldGenerator {

    private static int index = 1;

    protected final Block GEN_BLOCK;
    protected final int TICKET;
    protected final int MAX_HEIGHT;
    protected final int GEN_SIZE;

    public PLWorldGen(Block genBlock, int ticket, int maxHeight, int genSize) {
        this.GEN_BLOCK = genBlock;
        this.TICKET  = ticket;
        this.MAX_HEIGHT = maxHeight;
        this.GEN_SIZE = genSize;
        GameRegistry.registerWorldGenerator(this, index);
        ++index;
    }

    public static void init() {
        new PLWorldGen(PLBlocks.oreIridium, 1, 16, 3);
        new PLWorldGen(Block.getBlockFromItem(Ic2Items.basaltBlock.getItem()), 5, 27, 10);
    }

    /**
     * Generate some world
     *
     * @param random         the chunk specific {@link Random}.
     * @param chunkX         the chunk X coordinate of this chunk.
     * @param chunkZ         the chunk Z coordinate of this chunk.
     * @param world          : additionalData[0] The minecraft {@link World} we're generating for.
     * @param chunkGenerator : additionalData[1] The {@link IChunkProvider} that is generating.
     * @param chunkProvider  : additionalData[2] {@link IChunkProvider} that is requesting the world generation.
     */
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if ((!world.provider.isHellWorld) && (!world.provider.hasNoSky)) {
            generateOre(world, random, chunkX, chunkZ);
        }
    }

    private void generateOre(World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < TICKET; k++) {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = rand.nextInt(MAX_HEIGHT);
            int z = chunkZ * 16 + rand.nextInt(16);

            new WorldGenMinable(GEN_BLOCK, GEN_SIZE).generate(world, rand, x, y, z);
        }
    }

}
