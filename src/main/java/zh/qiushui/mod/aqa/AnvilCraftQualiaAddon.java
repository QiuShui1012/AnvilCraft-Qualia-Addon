package zh.qiushui.mod.aqa;

import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import dev.anvilcraft.lib.config.ConfigManager;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import org.slf4j.Logger;
import zh.qiushui.mod.aqa.data.AqaDatagen;
import zh.qiushui.mod.aqa.init.item.AqaAmuletTypes;
import zh.qiushui.mod.aqa.init.item.AqaItemGroups;
import zh.qiushui.mod.aqa.init.item.AqaItems;
import zh.qiushui.mod.aqa.item.tooltip.ItemTooltipManager;

@Mod(AnvilCraftQualiaAddon.MOD_ID)
public class AnvilCraftQualiaAddon {
    public static final String MOD_ID = "anvilcraft_qualia";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final AqaConfig CONFIG = ConfigManager.register(AnvilCraftQualiaAddon.MOD_ID, AqaConfig::new);
    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

    public AnvilCraftQualiaAddon(IEventBus modEventBus, ModContainer modContainer) {
        AqaItemGroups.register(modEventBus);
        AqaItems.register();

        AqaAmuletTypes.register(modEventBus);

        AqaDatagen.init();

        NeoForge.EVENT_BUS.addListener(AnvilCraftQualiaAddon::addItemTooltips);
    }

    public static void addItemTooltips(ItemTooltipEvent event) {
        ItemTooltipManager.addTooltip(event.getItemStack(), event.getToolTip());
    }

    public static ResourceLocation of(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
