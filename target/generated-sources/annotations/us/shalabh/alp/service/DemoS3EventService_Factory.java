package us.shalabh.alp.service;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import us.shalabh.alp.dao.IDemoS3EventDao;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DemoS3EventService_Factory implements Factory<DemoS3EventService> {
  private final Provider<IDemoS3EventDao> demoS3EventDaoProvider;

  public DemoS3EventService_Factory(Provider<IDemoS3EventDao> demoS3EventDaoProvider) {
    this.demoS3EventDaoProvider = demoS3EventDaoProvider;
  }

  @Override
  public DemoS3EventService get() {
    return new DemoS3EventService(demoS3EventDaoProvider.get());
  }

  public static Factory<DemoS3EventService> create(
      Provider<IDemoS3EventDao> demoS3EventDaoProvider) {
    return new DemoS3EventService_Factory(demoS3EventDaoProvider);
  }
}
