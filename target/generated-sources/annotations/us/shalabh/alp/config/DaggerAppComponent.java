package us.shalabh.alp.config;

import com.amazonaws.services.s3.AmazonS3;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import us.shalabh.alp.dao.DemoHttpRequestDao;
import us.shalabh.alp.dao.DemoHttpRequestDao_Factory;
import us.shalabh.alp.dao.DemoS3EventDao;
import us.shalabh.alp.dao.DemoS3EventDao_Factory;
import us.shalabh.alp.dao.IDemoHttpRequestDao;
import us.shalabh.alp.dao.IDemoS3EventDao;
import us.shalabh.alp.service.DemoHttpRequestService;
import us.shalabh.alp.service.DemoHttpRequestService_Factory;
import us.shalabh.alp.service.DemoS3EventService;
import us.shalabh.alp.service.DemoS3EventService_Factory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private AppModule appModule;

  private Provider<DemoS3EventDao> demoS3EventDaoProvider;

  private Provider<IDemoS3EventDao> provideDemoS3EventDaoProvider;

  private Provider<DemoS3EventService> demoS3EventServiceProvider;

  private Provider<DemoHttpRequestDao> demoHttpRequestDaoProvider;

  private Provider<IDemoHttpRequestDao> provideDemoHttpRequestDaoProvider;

  private Provider<DemoHttpRequestService> demoHttpRequestServiceProvider;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.appModule = builder.appModule;
    this.demoS3EventDaoProvider = DoubleCheck.provider(DemoS3EventDao_Factory.create());
    this.provideDemoS3EventDaoProvider =
        AppModule_ProvideDemoS3EventDaoFactory.create(builder.appModule, demoS3EventDaoProvider);
    this.demoS3EventServiceProvider =
        DoubleCheck.provider(DemoS3EventService_Factory.create(provideDemoS3EventDaoProvider));
    this.demoHttpRequestDaoProvider = DoubleCheck.provider(DemoHttpRequestDao_Factory.create());
    this.provideDemoHttpRequestDaoProvider =
        AppModule_ProvideDemoHttpRequestDaoFactory.create(
            builder.appModule, demoHttpRequestDaoProvider);
    this.demoHttpRequestServiceProvider =
        DoubleCheck.provider(
            DemoHttpRequestService_Factory.create(provideDemoHttpRequestDaoProvider));
  }

  @Override
  public AmazonS3 getAmazonS3() {
    return Preconditions.checkNotNull(
        appModule.provideAmazonS3(), "Cannot return null from a non-@Nullable @Provides method");
  }

  @Override
  public DemoS3EventService getDemoS3EventService() {
    return demoS3EventServiceProvider.get();
  }

  @Override
  public DemoHttpRequestService getDemoHttpRequestService() {
    return demoHttpRequestServiceProvider.get();
  }

  public static final class Builder {
    private AppModule appModule;

    private Builder() {}

    public AppComponent build() {
      if (appModule == null) {
        this.appModule = new AppModule();
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }
  }
}
