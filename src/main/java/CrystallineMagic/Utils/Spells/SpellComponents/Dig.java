package CrystallineMagic.Utils.Spells.SpellComponents;

import CrystallineMagic.Utils.MagicUtils;
import CrystallineMagic.Utils.Spells.SpellModifiers.StrengthUpgrade;
import CrystallineMagic.Utils.Spells.Utils.SpellComponent;
import MiscUtils.Utils.Block.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Dig implements SpellComponent{
    @Override
    public boolean OnUseOnEntity(ItemStack Spell, World world, Entity entityHit, EntityPlayer player) {

        return false;
    }

    @Override
    public boolean OnUseOnBlock(ItemStack Spell, World world, int x, int y, int z, Block block, EntityPlayer player, int Side) {
        if(block != Blocks.bedrock && block.getBlockHardness(world, x, y, z) > -1) {
            float h = block.getBlockHardness(world, x, y, z);
            if (h <= 2 + (MagicUtils.GetAmountOfAModifer(Spell, new StrengthUpgrade()) * 6)){
                world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(world.getBlock(x, y, z)) + (world.getBlockMetadata(x, y, z) << 12));
            BlockUtil.breakBlock(world, x, y, z);
                return true;
        }

        }

        return false;

    }

    @Override
    public String GetName() {
        return "Dig";
    }

    @Override
    public double EnergyCost() {
        return 48;
    }

    @Override
    public String GetId() {
        return "DG";
    }
}