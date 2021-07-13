package mca.enums;

import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import org.jetbrains.annotations.Nullable;

public enum Chore {
    NONE    ("none", null),
    PROSPECT("gui.label.prospecting", PickaxeItem.class),
    HARVEST ("gui.label.harvesting", HoeItem.class),
    CHOP    ("gui.label.chopping", AxeItem.class),
    HUNT    ("gui.label.hunting", SwordItem.class),
    FISH    ("gui.label.fishing", FishingRodItem.class);

    private static final Chore[] VALUES = values();

    private final String friendlyName;

    @Nullable
    private final Class<?> toolType;

    Chore(String friendlyName, @Nullable Class<?> toolType) {
        this.friendlyName = friendlyName;
        this.toolType = toolType;
    }

    public Text getName() {
        return new TranslatableText(friendlyName);
    }

    @Nullable
    public Class<?> getToolType() {
        return toolType;
    }

    public static Chore byId(int id) {
        if (id < 0 || id >= VALUES.length) {
            return NONE;
        }
        return VALUES[id];
    }
}

