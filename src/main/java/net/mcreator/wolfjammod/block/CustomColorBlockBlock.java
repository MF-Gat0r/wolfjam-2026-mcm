package net.mcreator.wolfjammod.block;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.StringRepresentable;
import net.minecraft.core.BlockPos;

import net.mcreator.wolfjammod.procedures.BlockColorChangeProcedure;

public class CustomColorBlockBlock extends Block {
	public static final EnumProperty<EnumColorAssignmentProperty> ENUM_COLOR_ASSIGNMENT = EnumProperty.create("enum_color_assignment", EnumColorAssignmentProperty.class);

	public CustomColorBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(1f, 10f));
		this.registerDefaultState(this.stateDefinition.any().setValue(ENUM_COLOR_ASSIGNMENT, EnumColorAssignmentProperty.COLOR_FRIENDLY));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(ENUM_COLOR_ASSIGNMENT);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(ENUM_COLOR_ASSIGNMENT, EnumColorAssignmentProperty.COLOR_FRIENDLY);
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		BlockColorChangeProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
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
}