package net.mcreator.wolfjammod.block;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.util.StringRepresentable;
import net.minecraft.core.BlockPos;

import net.mcreator.wolfjammod.procedures.CounterEntityWalksOnTheBlockProcedure;
import net.mcreator.wolfjammod.procedures.BlockColorChangeProcedure;
import net.mcreator.wolfjammod.block.entity.LavaBlockBlockEntity;

public class LavaBlockBlock extends Block implements EntityBlock {
	public static final EnumProperty<EnumColorAssignmentProperty> ENUM_COLOR_ASSIGNMENT = EnumProperty.create("enum_color_assignment", EnumColorAssignmentProperty.class);
	public static final EnumProperty<ColorAssignmentProperty> COLOR_ASSIGNMENT = EnumProperty.create("color_assignment", ColorAssignmentProperty.class);

	public LavaBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(1f, 10f));
		this.registerDefaultState(this.stateDefinition.any().setValue(ENUM_COLOR_ASSIGNMENT, EnumColorAssignmentProperty.COLOR_FRIENDLY).setValue(COLOR_ASSIGNMENT, ColorAssignmentProperty.ORANGE));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(ENUM_COLOR_ASSIGNMENT, COLOR_ASSIGNMENT);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(ENUM_COLOR_ASSIGNMENT, EnumColorAssignmentProperty.COLOR_FRIENDLY).setValue(COLOR_ASSIGNMENT, ColorAssignmentProperty.ORANGE);
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		CounterEntityWalksOnTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		BlockColorChangeProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new LavaBlockBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof LavaBlockBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof LavaBlockBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}

	public enum EnumColorAssignmentProperty implements StringRepresentable {
		COLOR_FRIENDLY("color_friendly"), GREY("grey"), BROWN("brown"), RED("red"), YELLOW("yellow"), GREEN("green"), GREEN2("green2"), ORANGE("orange"), ORANGE2("orange2");

		private final String name;

		private EnumColorAssignmentProperty(String name) {
			this.name = name;
		}

		@Override
		public String getSerializedName() {
			return this.name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

	public enum ColorAssignmentProperty implements StringRepresentable {
		ORANGE("orange"), ORANGE1("orange1"), GREY("grey"), BROWN("brown"), YELLOW("yellow"), RED("red"), GREEN("green"), GREEN1("green1"), COLOR_FRIENDLY("color_friendly"), LIGHT_GREEN("light_green"), DARK_GREEN("dark_green"), RED2("red2"), ORANGE3(
				"orange3"), PEACH("peach"), CORAL("coral"), YELLOW2(
						"yellow2"), PALE_CREAM("pale_cream"), HOT_PINK("hot_pink"), MAGENTA("magenta"), DARK_MAGENTA("dark_magenta"), ORANGE_RED("orange_red"), RUST_RED("rust_red"), DBROWN_RED("dbrown_red"), LIGHT_PINK("light_pink");

		private final String name;

		private ColorAssignmentProperty(String name) {
			this.name = name;
		}

		@Override
		public String getSerializedName() {
			return this.name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}
}