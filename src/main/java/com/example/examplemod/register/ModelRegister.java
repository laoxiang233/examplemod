package com.example.examplemod.register;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModelRegister {
    public ModelRegister(){
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void registerItemModels(ModelRegistryEvent event) {
        registerItemModel(ItemsRegister.RUDDER);
    }
    private void registerItemModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
