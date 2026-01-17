package zh.qiushui.mod.aqa;

import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import zh.qiushui.mod.aqa.data.AqaDatagen;
import zh.qiushui.mod.aqa.init.AqaBlocks;
import zh.qiushui.mod.aqa.init.AqaItemGroups;
import zh.qiushui.mod.aqa.init.AqaItems;
import dev.anvilcraft.lib.config.ConfigManager;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(AnvilCraftQualiaAddon.MOD_ID)
public class AnvilCraftQualiaAddon {
    public static final String MOD_ID = "anvilcraft_qualia";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final AqaConfig CONFIG = ConfigManager.register(AnvilCraftQualiaAddon.MOD_ID, AqaConfig::new);
    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

    public AnvilCraftQualiaAddon(IEventBus modEventBus, ModContainer modContainer) {
        AqaItemGroups.register(modEventBus);
        AqaBlocks.register();
        AqaItems.register();
        AqaDatagen.init();
    }

    public static ResourceLocation of(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
