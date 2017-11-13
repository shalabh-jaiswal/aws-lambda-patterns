package us.shalabh.alp.function;

import com.amazonaws.services.s3.AmazonS3;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import us.shalabh.alp.service.IDemoS3EventService;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DemoS3EventLambda_MembersInjector implements MembersInjector<DemoS3EventLambda> {
  private final Provider<AmazonS3> s3Provider;

  private final Provider<IDemoS3EventService> demoS3EventServiceProvider;

  public DemoS3EventLambda_MembersInjector(
      Provider<AmazonS3> s3Provider, Provider<IDemoS3EventService> demoS3EventServiceProvider) {
    this.s3Provider = s3Provider;
    this.demoS3EventServiceProvider = demoS3EventServiceProvider;
  }

  public static MembersInjector<DemoS3EventLambda> create(
      Provider<AmazonS3> s3Provider, Provider<IDemoS3EventService> demoS3EventServiceProvider) {
    return new DemoS3EventLambda_MembersInjector(s3Provider, demoS3EventServiceProvider);
  }

  @Override
  public void injectMembers(DemoS3EventLambda instance) {
    injectS3(instance, s3Provider.get());
    injectDemoS3EventService(instance, demoS3EventServiceProvider.get());
  }

  public static void injectS3(DemoS3EventLambda instance, AmazonS3 s3) {
    instance.s3 = s3;
  }

  public static void injectDemoS3EventService(
      DemoS3EventLambda instance, IDemoS3EventService demoS3EventService) {
    instance.demoS3EventService = demoS3EventService;
  }
}
