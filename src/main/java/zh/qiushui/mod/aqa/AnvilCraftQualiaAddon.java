package zh.qiushui.mod.aqa;

import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import dev.dubhe.anvilcraft.api.totem.TotemManager;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import zh.qiushui.mod.aqa.data.AqaDatagen;
import zh.qiushui.mod.aqa.init.item.AqaItemGroups;
import zh.qiushui.mod.aqa.init.item.AqaItems;
import dev.anvilcraft.lib.config.ConfigManager;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import zh.qiushui.mod.aqa.item.tooltip.ItemTooltipManager;
import zh.qiushui.mod.aqa.item.totem.TotemOfVoidHandler;

@Mod(AnvilCraftQualiaAddon.MOD_ID)
public class AnvilCraftQualiaAddon {
    public static final String MOD_ID = "anvilcraft_qualia";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final AqaConfig CONFIG = ConfigManager.register(AnvilCraftQualiaAddon.MOD_ID, AqaConfig::new);
    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

    public AnvilCraftQualiaAddon(IEventBus modEventBus, ModContainer modContainer) {
        AqaItemGroups.register(modEventBus);
        AqaItems.register();
        AqaDatagen.init();
    }

    @SubscribeEvent
    public static void addItemTooltips(ItemTooltipEvent event) {
        ItemTooltipManager.addTooltip(event.getItemStack(), event.getToolTip());
    }

    public static ResourceLocation of(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
