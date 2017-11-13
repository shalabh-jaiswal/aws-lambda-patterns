package us.shalabh.alp.config;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import us.shalabh.alp.service.DemoS3EventService;
import us.shalabh.alp.service.IDemoS3EventService;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideDemoS3EventServiceFactory
    implements Factory<IDemoS3EventService> {
  private final AppModule module;

  private final Provider<DemoS3EventService> demoS3EventServiceProvider;

  public AppModule_ProvideDemoS3EventServiceFactory(
      AppModule module, Provider<DemoS3EventService> demoS3EventServiceProvider) {
    this.module = module;
    this.demoS3EventServiceProvider = demoS3EventServiceProvider;
  }

  @Override
  public IDemoS3EventService get() {
    return Preconditions.checkNotNull(
        module.provideDemoS3EventService(demoS3EventServiceProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<IDemoS3EventService> create(
      AppModule module, Provider<DemoS3EventService> demoS3EventServiceProvider) {
    return new AppModule_ProvideDemoS3EventServiceFactory(module, demoS3EventServiceProvider);
  }
}
