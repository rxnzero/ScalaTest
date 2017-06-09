import javax.script.ScriptEngineManager

object Sample {
  def evenElems[T:ClassManifest](xs: Vector[T]) : Array[T] = {
    val arr = new Array[T]((xs.length + 1) / 2)
      for (i <- 0 until xs.length by 2)
          arr(i / 2) = xs(i)
    arr
  }
  
  def main(args: Array[String]) {
    val en = evenElems( Vector(1, 2, 3, 4, 5) )
    
    for(i<-0 until en.length by 1) { 
      println(i +" = " + en(i))
    }
    

  val e = new ScriptEngineManager().getEngineByName("scala")
  e.put("n", 10)
  e.eval("1 to n.asInstanceOf[Int] foreach println")
  }
}