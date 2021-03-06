package com.teamaurora.enhanced_mushrooms.common.item;

import com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import java.util.function.Supplier;

public class DynamicItemGroupItem extends Item {

    private Supplier<ItemGroup> optionalGroup;

    public DynamicItemGroupItem(Properties properties, Supplier<ItemGroup> itemGroupSupplier) {
        super(properties);
        this.optionalGroup = itemGroupSupplier;
    }

    @Override
    protected boolean isInGroup(ItemGroup group) {
        EnhancedMushrooms.LOGGER.info("Is in group: " + super.isInGroup(group));
        return super.isInGroup(group);
    }


    @Override
    public ItemGroup getGroup() {
        EnhancedMushrooms.LOGGER.error("Item group:" + (this.optionalGroup.get() == null ? "null" : this.optionalGroup.get().getPath()));
        return this.optionalGroup.get();
    }
}
