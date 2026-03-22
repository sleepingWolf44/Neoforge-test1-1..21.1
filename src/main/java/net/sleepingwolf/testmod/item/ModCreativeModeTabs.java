package net.sleepingwolf.testmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sleepingwolf.testmod.TestMod;
import net.sleepingwolf.testmod.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    public static final Supplier<CreativeModeTab> TEST_ITEM_TAB = CREATIVE_MODE_TAB.register("test_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DUCK.get()))
                    .title(Component.translatable("creativetab.testmod.test_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.DUCK);
                        output.accept(ModItems.KILL_SWORD);
                        output.accept(ModBlocks.END_TNT);
                        output.accept(ModBlocks.DUCK_BLOCK);
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
