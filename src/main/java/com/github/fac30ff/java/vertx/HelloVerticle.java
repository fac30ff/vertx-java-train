package com.github.fac30ff.java.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class HelloVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloVerticle.class);

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new HelloVerticle());
  }

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    LOGGER.info("Welcome to Vert.x");
  }

  @Override
  public void stop(Future<Void> stopFuture) throws Exception {
    LOGGER.info("Shutting down application");
  }
}
