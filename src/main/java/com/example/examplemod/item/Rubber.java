package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

public class Rubber extends Item {
    private static final String name = "rubber";

    public Rubber() {
        this.setRegistryName(name);
        this.setUnlocalizedName(ExampleMod.MODID + ":" + name);
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
            tooltip.add(I18n.format(this.getUnlocalizedName()+".shift.1."+"desc"));
        }
        if(flagIn.isAdvanced()){
            tooltip.add("this is ");
            tooltip.add("a rubber");
        }
        else{
            tooltip.add(I18n.format(this.getUnlocalizedName()+".1."+"desc"));
        }
    }
}
