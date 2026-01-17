package zh.qiushui.mod.aqa.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class ConfigLang {
    /**
     * 配置语言条目初始化
     *
     * @param provider 提供器
     */
    public static void init(RegistrateLangProvider provider) {
        provider.add("anvilcraft_qualia.configuration.title", "AnvilCraft: Qualia Addon Configuration");
        provider.add("anvilcraft_qualia.configuration.section.anvilcraft_qualia.common.toml.title", "AnvilCraft: Qualia Addon Common Configuration");
        provider.add("anvilcraft_qualia.configuration.section.anvilcraft_qualia.common.toml", "AnvilCraft: Qualia Addon Common Configuration");
    }
}
