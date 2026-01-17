package zh.qiushui.mod.aqa.data;

import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import zh.qiushui.mod.aqa.AnvilCraftQualiaAddon;
import zh.qiushui.mod.aqa.data.lang.AqaLangHandler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import static zh.qiushui.mod.aqa.AnvilCraftQualiaAddon.REGISTRATE;

@EventBusSubscriber(modid = AnvilCraftQualiaAddon.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class AqaDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {}

    /**
     * 初始化生成器
     */
    public static void init() {
        REGISTRATE.addDataGenerator(ProviderType.LANG, AqaLangHandler::init);
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike itemLike) {
        return RegistrateRecipeProvider.has(itemLike);
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(TagKey<Item> tag) {
        return RegistrateRecipeProvider.has(tag);
    }

    public static String hasItem(TagKey<Item> item) {
        return "has_" + item.location().getPath();
    }

    public static String hasItem(ItemLike item) {
        return "has_" + BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
    }
}
