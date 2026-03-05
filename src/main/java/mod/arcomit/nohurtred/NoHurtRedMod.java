package mod.arcomit.nohurtred;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

/**
 * 模组主类。
 *
 * @author Mitok
 * @since 2026-02-23
 */
@Mod(NoHurtRedMod.MODID)
public class NoHurtRedMod {
	public static final String MODID = "nohurtred";
	public static final Logger LOGGER = LogUtils.getLogger();

	public NoHurtRedMod(IEventBus modEventBus, ModContainer modContainer) {
		LOGGER.info("NoHurtRed mod initialized!");
	}

	public static ResourceLocation prefix(String path) {
		return ResourceLocation.fromNamespaceAndPath(MODID, path);
	}
}
