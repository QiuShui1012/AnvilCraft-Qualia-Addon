package zh.qiushui.mod.aqa.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import zh.qiushui.mod.aqa.AnvilCraftQualiaAddon;

@Mod(value = AnvilCraftQualiaAddon.MOD_ID, dist = Dist.CLIENT)
public class AnvilCraftQualiaAddonClient {
    public AnvilCraftQualiaAddonClient(IEventBus modBus, ModContainer container) {
    }
}
