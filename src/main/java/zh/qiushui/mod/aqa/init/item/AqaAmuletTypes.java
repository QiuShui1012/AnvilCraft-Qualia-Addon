package zh.qiushui.mod.aqa.init.item;

import dev.dubhe.anvilcraft.api.amulet.AmuletManager;
import dev.dubhe.anvilcraft.api.amulet.type.AmuletType;
import dev.dubhe.anvilcraft.init.ModRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import zh.qiushui.mod.aqa.AnvilCraftQualiaAddon;
import zh.qiushui.mod.aqa.item.amulet.type.VoidAmuletType;

public class AqaAmuletTypes {
    private static final DeferredRegister<AmuletType> REGISTER = DeferredRegister.create(ModRegistries.AMULET_TYPE_KEY, AnvilCraftQualiaAddon.MOD_ID);

    public static final DeferredHolder<AmuletType, VoidAmuletType> VOID = REGISTER.register(
        "void",
        VoidAmuletType::new
    );

    public static void register(IEventBus bus) {
        REGISTER.register(bus);

        AmuletManager.INSTANCE.registerAmulets(
            AqaItems.VOID_AMULET::get
        );
    }
}
