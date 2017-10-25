package ar.com.pablitar.easingtest

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType

class EasingTestGame extends ApplicationAdapter {
  lazy val shapeRenderer = {
    val sr = new ShapeRenderer
    sr.setAutoShapeType(true)
    sr
  }
  val shape = new ShapeWithEasing

  override def render() {
    Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    shape.update(Gdx.graphics.getDeltaTime)
    
    shapeRenderer.begin(ShapeType.Filled)
    shapeRenderer.setColor(Color.CORAL)
    shapeRenderer.circle(shape.position.x, shape.position.y, 60f * shape.scale)
    shapeRenderer.end()
  }
}