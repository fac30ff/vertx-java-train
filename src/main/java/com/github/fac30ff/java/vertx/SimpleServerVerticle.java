package com.github.fac30ff.java.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class SimpleServerVerticle extends AbstractVerticle {

  @Override
  public void start(final Future<Void> startFuture) throws Exception {
    vertx.createHttpServer()
            .requestHandler(r -> r.response().end("Welcome to Vert.x sample simple server"))
            .listen(config().getInteger("http.port", 8080), result -> {
              if(result.succeeded()) {
                startFuture.complete();
              } else {
                startFuture.fail(result.cause());
              }
            });
  }
}
