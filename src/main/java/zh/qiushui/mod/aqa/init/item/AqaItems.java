package zh.qiushui.mod.aqa.init.item;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import dev.dubhe.anvilcraft.api.amulet.type.AmuletType;
import dev.dubhe.anvilcraft.init.block.ModBlocks;
import dev.dubhe.anvilcraft.init.item.ModItemTags;
import dev.dubhe.anvilcraft.init.item.ModItems;
import dev.dubhe.anvilcraft.item.amulet.AmuletItem;
import net.minecraft.core.Holder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;

import static zh.qiushui.mod.aqa.AnvilCraftQualiaAddon.REGISTRATE;

@SuppressWarnings("CodeBlock2Expr")
public class AqaItems {
    static {
        REGISTRATE.defaultCreativeTab(AqaItemGroups.AQA_ITEMS.getKey());
    }

    public static final ItemEntry<Item> TOTEM_OF_VOID = REGISTRATE.item("totem_of_void", Item::new)
        .lang("Totem of Void")
        .properties((properties) -> properties.stacksTo(1).rarity(Rarity.UNCOMMON))
        .tag(ModItemTags.TOTEM)
        .recipe((ctx, provider) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ctx.get())
                .pattern("MMM")
                .pattern("BTB")
                .pattern("MMM")
                .define('T', Items.TOTEM_OF_UNDYING)
                .define('B', ModBlocks.VOID_MATTER_BLOCK)
                .define('M', ModItems.VOID_MATTER)
                .unlockedBy("has_totem_of_undying", RegistrateRecipeProvider.has(Items.TOTEM_OF_UNDYING))
                .unlockedBy("has_void_matter_block", RegistrateRecipeProvider.has(ModBlocks.VOID_MATTER_BLOCK))
                .unlockedBy("has_void_matter", RegistrateRecipeProvider.has(ModItems.VOID_MATTER))
                .save(provider);
        })
        .register();

    public static final ItemEntry<? extends AmuletItem> VOID_AMULET = REGISTRATE
        .item("void_amulet", properties -> new AmuletItem(properties) {
            @Override
            public Holder<AmuletType> getType() {
                return AqaAmuletTypes.VOID;
            }
        })
        .properties((properties) -> properties.stacksTo(1))
        .tag(ModItemTags.AMULET)
        .register();

    public static void register() {
    }
}
