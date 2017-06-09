package examples.traits

object DateTest extends App {  
  override def main(args:Array[String]) {
    val date1 = new Date(2017, 2, 23)
    val date2 = new Date(2017, 2, 24)
    
    println( date1 < date2)
    println( date1 > date2)
    
  }
}