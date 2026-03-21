package net.sleepingwolf.testmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sleepingwolf.testmod.TestMod;
import net.minecraft.world.item.SwordItem;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MODID);

    public static final DeferredItem<Item> DUCK = ITEMS.register("rubberduck",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> KILL_SWORD = ITEMS.register("kill_sword",
            () -> new SwordItem(
                    ModToolMaterials.GODLY,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(
                                    ModToolMaterials.GODLY,
                                    30000,      // attack damage bonus
                                    -2.4f   // attack speed
                            )
                    )
            )
    );



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
