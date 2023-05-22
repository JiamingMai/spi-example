package com.kapok;

import java.io.File;
import java.net.URL;
import java.util.ServiceLoader;

public class Main {
  public static void main(String[] args) throws Exception {
    String resourcePath = Main.class.getClassLoader().getResource("").getPath();
    File jar = new File(resourcePath, "lib/implement.jar");
    URL[] urls = new URL[]{jar.toURI().toURL()};
    ExtensionsClassLoader extensionsClassLoader = new ExtensionsClassLoader(urls,
        Thread.currentThread().getContextClassLoader());
    ServiceLoader<Animal> loader = ServiceLoader.load(Animal.class, extensionsClassLoader);
    for (Animal provider : loader) {
      provider.sayHello();
    }
  }
}
