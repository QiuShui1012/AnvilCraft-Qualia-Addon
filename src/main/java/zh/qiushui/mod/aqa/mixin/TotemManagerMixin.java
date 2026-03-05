package zh.qiushui.mod.aqa.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.dubhe.anvilcraft.api.totem.TotemManager;
import dev.dubhe.anvilcraft.api.totem.handler.TotemHandler;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import zh.qiushui.mod.aqa.init.item.AqaItems;
import zh.qiushui.mod.aqa.item.totem.TotemOfVoidHandler;

@Mixin(TotemManager.class)
abstract class TotemManagerMixin {
    @WrapOperation(
        method = "<init>",
        at = @At(
            value = "INVOKE",
            target = "Ldev/dubhe/anvilcraft/api/totem/TotemManager;registerTotem(Lnet/minecraft/world/item/Item;Ldev/dubhe/anvilcraft/api/totem/handler/TotemHandler;)V"
        )
    )
    private static void registerTotems(TotemManager instance, Item item, TotemHandler handler, Operation<Void> original) {
        original.call(instance, item, handler);
        original.call(instance, AqaItems.TOTEM_OF_VOID.asItem(), TotemOfVoidHandler.INSTANCE);
    }
}
