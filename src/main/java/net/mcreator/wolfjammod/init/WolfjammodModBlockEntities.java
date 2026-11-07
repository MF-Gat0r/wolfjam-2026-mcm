/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wolfjammod.init;

import net.neoforged.neoforge.transfer.item.WorldlyContainerWrapper;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.wolfjammod.block.entity.CounterLavaBlockBlockEntity;
import net.mcreator.wolfjammod.WolfjammodMod;

@EventBusSubscriber
public class WolfjammodModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, WolfjammodMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CounterLavaBlockBlockEntity>> COUNTER_LAVA_BLOCK = register("counter_lava_block", WolfjammodModBlocks.COUNTER_LAVA_BLOCK, CounterLavaBlockBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.Item.BLOCK, COUNTER_LAVA_BLOCK.get(), WorldlyContainerWrapper::new);
	}
}