package zh.qiushui.mod.aqa.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class AqaLangHandler {
    /**
     * 语言文件初始化
     *
     * @param provider 提供器
     */
    public static void init(RegistrateLangProvider provider) {
        ConfigLang.init(provider);
    }
}
