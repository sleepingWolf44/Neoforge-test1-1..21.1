package net.sleepingwolf.testmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sleepingwolf.testmod.TestMod;
import net.sleepingwolf.testmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TestMod.MODID);

    public static final DeferredBlock<Block> END_TNT = registerBlock("end_tnt",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(0.1f).lightLevel(state -> 4).sound(SoundType.HONEY_BLOCK).friction(2.50f)));

    public static final DeferredBlock<Block> DUCK_BLOCK = registerBlock("duck_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(0.1f).lightLevel(state -> -10).sound(SoundType.HONEY_BLOCK).friction(2.50f)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private  static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
