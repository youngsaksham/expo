package abi41_0_0.expo.modules.notifications;

import android.content.Context;

import abi41_0_0.org.unimodules.core.BasePackage;
import abi41_0_0.org.unimodules.core.ExportedModule;
import abi41_0_0.org.unimodules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.SingletonModule;

import java.util.Arrays;
import java.util.List;

import abi41_0_0.expo.modules.notifications.badge.BadgeModule;
import abi41_0_0.expo.modules.notifications.badge.ExpoBadgeManager;
import abi41_0_0.expo.modules.notifications.serverregistration.ServerRegistrationModule;
import expo.modules.notifications.notifications.NotificationManager;
import abi41_0_0.expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule;
import abi41_0_0.expo.modules.notifications.notifications.categories.serializers.ExpoNotificationsCategoriesSerializer;
import abi41_0_0.expo.modules.notifications.notifications.channels.AndroidXNotificationsChannelsProvider;
import abi41_0_0.expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule;
import abi41_0_0.expo.modules.notifications.notifications.channels.NotificationChannelManagerModule;
import abi41_0_0.expo.modules.notifications.notifications.emitting.NotificationsEmitter;
import abi41_0_0.expo.modules.notifications.notifications.handling.NotificationsHandler;
import abi41_0_0.expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule;
import abi41_0_0.expo.modules.notifications.notifications.scheduling.NotificationScheduler;
import abi41_0_0.expo.modules.notifications.permissions.NotificationPermissionsModule;
import expo.modules.notifications.tokens.PushTokenManager;
import abi41_0_0.expo.modules.notifications.tokens.PushTokenModule;

public class NotificationsPackage extends BasePackage {
  @Override
  public List<ExportedModule> createExportedModules(Context context) {
    return Arrays.asList(
      new BadgeModule(context),
      new PushTokenModule(context),
      new NotificationsEmitter(context),
      new NotificationsHandler(context),
      new NotificationScheduler(context),
      new ServerRegistrationModule(context),
      new NotificationPermissionsModule(context),
      new NotificationChannelManagerModule(context),
      new ExpoNotificationPresentationModule(context),
      new NotificationChannelGroupManagerModule(context),
      new ExpoNotificationCategoriesModule(context)
    );
  }

  @Override
  public List<SingletonModule> createSingletonModules(Context context) {
    return Arrays.asList(
      new PushTokenManager(),
      new NotificationManager(),
      new ExpoBadgeManager(context)
    );
  }

  @Override
  public List<InternalModule> createInternalModules(Context context) {
    return Arrays.asList(
      new AndroidXNotificationsChannelsProvider(context),
      new ExpoNotificationsCategoriesSerializer()
    );
  }
}
