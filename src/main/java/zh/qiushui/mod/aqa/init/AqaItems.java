package zh.qiushui.mod.aqa.init;

import static zh.qiushui.mod.aqa.AnvilCraftQualiaAddon.REGISTRATE;

@SuppressWarnings({
    "unused",
    "CodeBlock2Expr"
})
public class AqaItems {
    static {
        REGISTRATE.defaultCreativeTab(AqaItemGroups.AQA_ITEMS.getKey());
    }

    public static void register() {
    }
}
