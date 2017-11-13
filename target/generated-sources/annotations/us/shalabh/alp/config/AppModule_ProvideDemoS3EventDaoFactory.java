package us.shalabh.alp.config;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import us.shalabh.alp.dao.DemoS3EventDao;
import us.shalabh.alp.dao.IDemoS3EventDao;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideDemoS3EventDaoFactory implements Factory<IDemoS3EventDao> {
  private final AppModule module;

  private final Provider<DemoS3EventDao> demoS3EventDaoProvider;

  public AppModule_ProvideDemoS3EventDaoFactory(
      AppModule module, Provider<DemoS3EventDao> demoS3EventDaoProvider) {
    this.module = module;
    this.demoS3EventDaoProvider = demoS3EventDaoProvider;
  }

  @Override
  public IDemoS3EventDao get() {
    return Preconditions.checkNotNull(
        module.provideDemoS3EventDao(demoS3EventDaoProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<IDemoS3EventDao> create(
      AppModule module, Provider<DemoS3EventDao> demoS3EventDaoProvider) {
    return new AppModule_ProvideDemoS3EventDaoFactory(module, demoS3EventDaoProvider);
  }
}
