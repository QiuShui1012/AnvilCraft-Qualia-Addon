package zh.qiushui.mod.aqa.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;
import zh.qiushui.mod.aqa.item.tooltip.ItemTooltipManager;

public class ItemTooltipLang {
    /**
     * 物品工具提示语言条目初始化
     *
     * @param provider 提供器
     */
    public static void init(RegistrateLangProvider provider) {
        ItemTooltipManager.NEED_TOOLTIP_ITEM.forEach((item, s) -> provider.add(ItemTooltipManager.getTranslationKey(item), s));
    }
}
