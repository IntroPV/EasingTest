package ar.com.pablitar.easingtest
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.Gdx

class ShapeWithEasing(var position: Vector2 = new Vector2) {
  
  val movementTime = 1.0f
  val interpolator = Interpolation.swingOut
  
  var target = Option.empty[Vector2]
  var startPosition = position
  var movementElapsed = 0f
  var scale = 1f
  
  def update(delta: Float) = {
    target.foreach { aMovementTarget =>
      val interpolationRatio = interpolator.apply(movementElapsed / movementTime)

      scale = 2 * interpolationRatio * interpolationRatio - 2 * interpolationRatio + 1
      
      position = startPosition.cpy().
        lerp(aMovementTarget, interpolationRatio)
      
      movementElapsed += delta
      
      if(movementElapsed >= movementTime) {
        this.target = None
      }
    }
    
    if(Gdx.input.justTouched()) {
      this.moveTo(new Vector2(Gdx.input.getX, 720 - Gdx.input.getY))
    }
  }
  
  def moveTo(aTarget: Vector2) = {
    startPosition = position
    movementElapsed = 0
    target = Some(aTarget)
  }
  
}