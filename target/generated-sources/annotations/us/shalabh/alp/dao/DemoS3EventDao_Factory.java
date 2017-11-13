package us.shalabh.alp.dao;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DemoS3EventDao_Factory implements Factory<DemoS3EventDao> {
  private static final DemoS3EventDao_Factory INSTANCE = new DemoS3EventDao_Factory();

  @Override
  public DemoS3EventDao get() {
    return new DemoS3EventDao();
  }

  public static Factory<DemoS3EventDao> create() {
    return INSTANCE;
  }
}
