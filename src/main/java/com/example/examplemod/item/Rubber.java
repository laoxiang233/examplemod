package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Stack;

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

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (!playerIn.capabilities.isCreativeMode){
            itemstack.shrink(1);
        }
        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if(target instanceof EntityMob){
            stack.grow(1);
        }
        return true;
    }
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
        if(!worldIn.isRemote){
            if(Math.random()<=0.05f) {
                entityIn.sendMessage(new TextComponentTranslation("example.info.update", entityIn.getPosition().getX(), entityIn.getPosition().getY(), entityIn.getPosition().getZ()));
            }
        }
    }
    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if(!worldIn.isRemote)
            playerIn.sendMessage(new TextComponentTranslation("example.info.create"));
    }
    /* ======================================== FORGE START =====================================*/
    @Override
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
        if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL))
            return false;
        player.sendMessage(new TextComponentString("你居然丢掉了他"));
        return true;
    }
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        return entity instanceof EntityAnimal;

    }
    @Override
    public int getEntityLifespan(ItemStack itemStack, World world)
    {
        return 60;
    }
    @Override
    public CreativeTabs[] getCreativeTabs()
    {
        return new CreativeTabs[]{ CreativeTabs.FOOD,CreativeTabs.MISC ,CreativeTabs.TOOLS};
    }
}
