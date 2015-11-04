package com.mcgoodtime.gti.common.entity;

import com.mcgoodtime.gti.common.GtiUtil;
import ic2.core.IC2Potion;
import ic2.core.Ic2Items;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by suhao on 2015.10.25.0025.
 *
 */
public class EntityUran238 extends EntityThrowable {


    public EntityUran238(World world) {
        super(world);
    }

    public EntityUran238(World world, EntityLivingBase livingBase) {
        super(world, livingBase);
    }

    public EntityUran238(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(MovingObjectPosition objectPosition) {
        GtiUtil.onThrowItemImpact(objectPosition, this, Ic2Items.Uran238.getItem(), IC2Potion.radiation, 200, 0);
    }
}
