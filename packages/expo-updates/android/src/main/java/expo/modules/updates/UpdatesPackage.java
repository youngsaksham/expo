package expo.modules.updates;

import android.content.Context;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import expo.modules.core.BasePackage;
import expo.modules.core.ExportedModule;
import expo.modules.core.interfaces.InternalModule;

public class UpdatesPackage extends BasePackage {
  @Override
  public List<InternalModule> createInternalModules(Context context) {
    return Collections.singletonList((InternalModule) new UpdatesService(context));
  }

  @Override
  public List<ExportedModule> createExportedModules(Context context) {
    return Collections.singletonList((ExportedModule) new UpdatesModule(context));
  }
}
