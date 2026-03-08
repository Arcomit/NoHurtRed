package mod.arcomit.nohurtred.mixin;

import net.minecraft.client.renderer.texture.OverlayTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OverlayTexture.class)
public class OverlayTextureMixin {

	/**
	 * 拦截计算受击变红程度的 v 坐标方法。
	 * 将其强制返回 10，这代表无红色覆盖层。
	 * 这种做法不仅能全局取消变红，还能保留苦力怕爆炸前和实体死亡时的“纯白闪烁”效果。
	 */
	@Inject(method = "v", at = @At("HEAD"), cancellable = true)
	private static void disableHurtRed(boolean hurt, CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(10);
	}
}