package vertx

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future

class MainVerticle : AbstractVerticle() {

  override fun start(future: Future<Void>) {
    vertx
      .createHttpServer()
      .requestHandler({
          req -> req
              .response()
              .putHeader("content-type", "text/plain")
              .end("Hello from Vert.x!")
      })
      .listen(8080,{
          result ->
          if(result.succeeded()){
              future.complete()
          }
          else{
              future.fail(result.cause())
          }
      })

  }
}