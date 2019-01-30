package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Rubber extends Item {
    private static final String name = "rubber";
    public Rubber(){
        this.setRegistryName(name);
        this.setUnlocalizedName(ExampleMod.MODID+":"+name);
        this.setCreativeTab(CreativeTabs.MISC);
    }
}
