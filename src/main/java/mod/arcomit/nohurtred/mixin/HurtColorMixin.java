package mod.arcomit.nohurtred.mixin;

import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public class HurtColorMixin {

	// 第二个参数 pWhiteOverlayProgress 就是用来控制苦力怕发白等效果的进度
	@Inject(method = "getOverlayCoords", at = @At("HEAD"), cancellable = true)
	private static void selectiveHurtRed(LivingEntity pEntity, float pWhiteOverlayProgress, CallbackInfoReturnable<Integer> cir) {
		// OverlayTexture.u() 接收传入的白色进度，保留附魔和特殊白色闪烁
		int u = OverlayTexture.u(pWhiteOverlayProgress);
		// OverlayTexture.v(false) 强制关闭受伤的红光
		int v = OverlayTexture.v(false);

		// 返回修改后的坐标，成功拦截原版逻辑
		cir.setReturnValue(OverlayTexture.pack(u, v));
	}
}