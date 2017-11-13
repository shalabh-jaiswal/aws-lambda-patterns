package us.shalabh.alp.config;

import com.amazonaws.services.s3.AmazonS3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideAmazonS3Factory implements Factory<AmazonS3> {
  private final AppModule module;

  public AppModule_ProvideAmazonS3Factory(AppModule module) {
    this.module = module;
  }

  @Override
  public AmazonS3 get() {
    return Preconditions.checkNotNull(
        module.provideAmazonS3(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AmazonS3> create(AppModule module) {
    return new AppModule_ProvideAmazonS3Factory(module);
  }

  public static AmazonS3 proxyProvideAmazonS3(AppModule instance) {
    return instance.provideAmazonS3();
  }
}
