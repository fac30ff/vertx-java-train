package com.github.fac30ff.java.vertx.rest;

import com.github.fac30ff.java.vertx.model.Article;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class RestServiceVerticle extends AbstractVerticle {
  @Override
  public void start(Future<Void> startFuture) throws Exception {
    Router router = Router.router(vertx);
    router.get("/api/articles/article/:id")
            .handler(this::getArticles);
  }

  private void getArticles(RoutingContext routingContext) {
    String articleId = routingContext.request()
            .getParam("id");
    Article article = new Article(articleId, "This is intro to vertx", "fac30ff", "18-04-2019", 1578);
    routingContext.response()
            .putHeader("content-type", "application/json")
            .setStatusCode(200)
            .end(Json.encodePrettily(article));
  }
}
