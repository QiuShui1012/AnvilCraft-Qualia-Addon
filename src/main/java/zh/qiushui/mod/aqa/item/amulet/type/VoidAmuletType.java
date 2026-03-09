package zh.qiushui.mod.aqa.item.amulet.type;

import dev.dubhe.anvilcraft.api.amulet.fromto.Effect;
import dev.dubhe.anvilcraft.api.amulet.type.AmuletType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.item.ItemStack;
import zh.qiushui.mod.aqa.init.item.AqaItems;
import zh.qiushui.mod.aqa.item.totem.TotemOfVoidHandler;

public class VoidAmuletType extends AmuletType {
    public VoidAmuletType() {
        super(
            VoidAmuletType::canObtainS,
            new Effect(VoidAmuletType::inventoryTickS, VoidAmuletType::shouldImmuneDamageS),
            AqaItems.VOID_AMULET::asStack
        );
    }

    private static boolean canObtainS(ServerPlayer player, DamageSource source) {
        return source.is(DamageTypes.FELL_OUT_OF_WORLD);
    }

    private static boolean shouldImmuneDamageS(ServerPlayer player, DamageSource source) {
        return VoidAmuletType.canObtainS(player, source);
    }

    private static void inventoryTickS(ServerPlayer player, ItemStack amulet, boolean isEnabled) {
        if (!isEnabled) return;
        if (player.getY() < player.level().getMinBuildHeight()) TotemOfVoidHandler.saveEntityFromVoid(player, null);
    }
}
