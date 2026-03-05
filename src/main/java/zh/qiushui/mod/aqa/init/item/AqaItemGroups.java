package zh.qiushui.mod.aqa.init.item;

import zh.qiushui.mod.aqa.AnvilCraftQualiaAddon;
import dev.dubhe.anvilcraft.init.item.ModItemGroups;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static zh.qiushui.mod.aqa.AnvilCraftQualiaAddon.REGISTRATE;

public class AqaItemGroups {
    private static final DeferredRegister<CreativeModeTab> DEFERRED_REGISTER = DeferredRegister.create(
        Registries.CREATIVE_MODE_TAB,
        AnvilCraftQualiaAddon.MOD_ID
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AQA_ITEMS = DEFERRED_REGISTER.register(
        "addon_items",
        () -> CreativeModeTab.builder()
            .icon(AqaItems.TOTEM_OF_VOID::asStack)
            .displayItems((ctx, entries) -> {
            })
            .title(
                REGISTRATE.addLang(
                    "itemGroup",
                    AnvilCraftQualiaAddon.of("aqa_items"),
                    "AnvilCraft: Qualia Addon"
                )
            )
            .withTabsBefore(ModItemGroups.ANVILCRAFT_BUILD_BLOCK.getId())
            .build()
    );

    public static void register(IEventBus modEventBus) {
        DEFERRED_REGISTER.register(modEventBus);
    }
}
