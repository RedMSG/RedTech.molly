package org.thoughtcrime.securesms.privacy;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

/**
 * Centralized privacy controls for the custom build.
 *
 * <p>All privacy-sensitive options default to the safer behavior. The class
 * deliberately uses ordinary app preferences only for policy flags; it does
 * not store keys, passphrases, message content, or cryptographic material.</p>
 */
public final class EnhancedPrivacySettings {

  private static final String PREFS = "custom_privacy_settings";
  private static final String KEY_SECURE_RECENTS = "secure_recents";
  private static final String KEY_SCREENSHOT_BLOCK = "screenshot_block";
  private static final String KEY_HIDE_LOCK_SCREEN = "hide_lock_screen_content";
  private static final String KEY_HIDE_GROUP_NAMES = "hide_group_names";
  private static final String KEY_HIDE_NOTIFICATION_ACTIONS = "hide_notification_actions";

  private EnhancedPrivacySettings() {}

  private static SharedPreferences prefs(@NonNull Context context) {
    return context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
  }

  public static boolean isSecureRecentsEnabled(@NonNull Context context) {
    return prefs(context).getBoolean(KEY_SECURE_RECENTS, true);
  }

  public static void setSecureRecentsEnabled(@NonNull Context context, boolean enabled) {
    prefs(context).edit().putBoolean(KEY_SECURE_RECENTS, enabled).apply();
  }

  public static boolean isScreenshotBlockingEnabled(@NonNull Context context) {
    return prefs(context).getBoolean(KEY_SCREENSHOT_BLOCK, true);
  }

  public static void setScreenshotBlockingEnabled(@NonNull Context context, boolean enabled) {
    prefs(context).edit().putBoolean(KEY_SCREENSHOT_BLOCK, enabled).apply();
  }

  public static boolean isLockScreenContentHidden(@NonNull Context context) {
    return prefs(context).getBoolean(KEY_HIDE_LOCK_SCREEN, true);
  }

  public static void setLockScreenContentHidden(@NonNull Context context, boolean enabled) {
    prefs(context).edit().putBoolean(KEY_HIDE_LOCK_SCREEN, enabled).apply();
  }

  public static boolean isGroupNameHidden(@NonNull Context context) {
    return prefs(context).getBoolean(KEY_HIDE_GROUP_NAMES, false);
  }

  public static void setGroupNameHidden(@NonNull Context context, boolean enabled) {
    prefs(context).edit().putBoolean(KEY_HIDE_GROUP_NAMES, enabled).apply();
  }

  public static boolean areNotificationActionsHidden(@NonNull Context context) {
    return prefs(context).getBoolean(KEY_HIDE_NOTIFICATION_ACTIONS, true);
  }

  public static void setNotificationActionsHidden(@NonNull Context context, boolean enabled) {
    prefs(context).edit().putBoolean(KEY_HIDE_NOTIFICATION_ACTIONS, enabled).apply();
  }
}
