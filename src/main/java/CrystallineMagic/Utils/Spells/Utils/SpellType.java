package CrystallineMagic.Utils.Spells.Utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface SpellType {

    public String GetName();
    public String GetId();

    public SpellUseType GetUseType();


    public boolean OnUse(ItemStack SpellStack, EntityPlayer player, World world, int x, int y, int z, int BlockSide);



}
