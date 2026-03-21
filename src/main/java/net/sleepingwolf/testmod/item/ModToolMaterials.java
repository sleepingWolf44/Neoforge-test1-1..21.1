package net.sleepingwolf.testmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolMaterials {
    public static final SimpleTier GODLY  = new SimpleTier(
            BlockTags.NEEDS_DIAMOND_TOOL,  // incorrect blocks tag
            50000,                            // durability
            60.0f,                           // mining speed
            20000.0f,                           // attack damage
            30,                             // enchantability
            () -> Ingredient.of(ModItems.DUCK.get())
    );
}