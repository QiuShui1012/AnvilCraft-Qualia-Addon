package zh.qiushui.mod.aqa.init;

import com.tterrag.registrate.util.entry.BlockEntry;
import dev.dubhe.anvilcraft.init.item.ModItemTags;
import dev.dubhe.anvilcraft.init.item.ModItems;
import dev.dubhe.anvilcraft.util.DataGenUtil;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.common.Tags;
import zh.qiushui.mod.aqa.block.GasCollectionChamberBlock;
import zh.qiushui.mod.aqa.data.AqaDatagen;

import static zh.qiushui.mod.aqa.AnvilCraftQualiaAddon.REGISTRATE;

@SuppressWarnings({
    "unused",
    "CodeBlock2Expr"
})
public class AqaBlocks {
    static {
        REGISTRATE.defaultCreativeTab(AqaItemGroups.AQA_ITEMS.getKey());
    }

    public static final BlockEntry<GasCollectionChamberBlock> GAS_COLLECTION_CHAMBER = REGISTRATE
        .block("gas_collection_chamber", GasCollectionChamberBlock::new)
        .initialProperties(() -> Blocks.SLIME_BLOCK)
        .properties(properties -> properties.sound(SoundType.HONEY_BLOCK))
        .blockstate(DataGenUtil::noExtraModelOrState)
        .recipe((ctx, provider) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ctx.get())
                .pattern("RWR")
                .pattern("WEW")
                .pattern("RSR")
                .define('E', ModItemTags.STORAGE_BLOCKS_RESIN)
                .define('R', ModItems.ROYAL_STEEL_INGOT)
                .define('S', Tags.Items.STRINGS)
                .define('W', ItemTags.WOOL)
                .unlockedBy(AqaDatagen.hasItem(ModItemTags.STORAGE_BLOCKS_RESIN), AqaDatagen.has(ModItemTags.STORAGE_BLOCKS_RESIN))
                .unlockedBy(AqaDatagen.hasItem(ModItems.ROYAL_STEEL_INGOT), AqaDatagen.has(ModItems.ROYAL_STEEL_INGOT))
                .unlockedBy(AqaDatagen.hasItem(Tags.Items.STRINGS), AqaDatagen.has(Tags.Items.STRINGS))
                .unlockedBy(AqaDatagen.hasItem(ItemTags.WOOL), AqaDatagen.has(ItemTags.WOOL))
                .save(provider);
        })
        .simpleItem()
        .register();

    public static void register() {
    }
}
