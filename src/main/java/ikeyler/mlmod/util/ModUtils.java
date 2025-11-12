package ikeyler.mlmod.util;

import ikeyler.mlmod.cfg.Configuration;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentTranslation;

public class ModUtils {
    private static final Minecraft mc = Minecraft.getMinecraft();
    public static final String MOD_PREFIX = "§8» §f";
    public static final String NOTIFICATION_SOUND = "entity.experience_orb.pickup";
    public static boolean IN_DEV_MODE = false;
    public static final float GAME_GAMMA_SETTING = Minecraft.getMinecraft().gameSettings.gammaSetting;

    public static void enableDevMode() {
        if (Configuration.CREATIVE.DEV_NIGHT_MODE.get() && mc.player.isCreative()) {
            IN_DEV_MODE = true;
            mc.gameSettings.gammaSetting = 1000.0F;
        }
    }
    public static void disableDevMode() {
        if (IN_DEV_MODE && Configuration.CREATIVE.DEV_NIGHT_MODE.get()) {
            mc.gameSettings.gammaSetting = GAME_GAMMA_SETTING;
        }
        IN_DEV_MODE = false;
    }
    public static void nightModeCommand() {
        if (!mc.player.isCreative()) {
            mc.player.sendMessage(new TextComponentTranslation("mlmod.messages.creative_mode_needed"));
            return;
        }
        if (!Configuration.CREATIVE.DEV_NIGHT_MODE.get()) {
            mc.player.sendMessage(new TextComponentTranslation("mlmod.messages.nightmode.enable_in_config"));
            return;
        }
        enableDevMode();
        mc.player.sendMessage(new TextComponentTranslation("mlmod.messages.nightmode.enabled"));
    }
}
