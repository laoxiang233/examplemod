package com.example.examplemod.register;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.*;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ItemsRegister {
    public static final Item RUDDER = new Rubber();
    public ItemsRegister(){
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                RUDDER
        );
    }
}
