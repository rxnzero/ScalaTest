package examples

import scala.annotation.tailrec

// 유클리드 호제법에 의한 최대 공약수 구하기
// Greatest Common Divisor
object GCD extends App {
  
  def gcd(a:Int, b:Int) :Int = {
	  val mx = math.max(a,b)
	  val mn = math.min(a,b)
	  gcdLoop(mx, mn)	  
  }
  
  
  def lcm(a:Int, b:Int) :Int = {
	  val mx = math.max(a,b)
	  val mn = math.min(a,b)
	  (a*b) / gcdLoop(mx, mn) 	  
  }
  
  @tailrec  
  def gcdLoop(mx:Int, mn:Int) :Int = {
	  if(mn == 0) mx          
	  else gcdLoop(mn, mx%mn)	  
  }
  
  def gcdMatch(a:Int, b:Int) :Int = {
	  val mx = math.max(a,b)
	  val mn = math.min(a,b)
	  gcdMatchLoop(mx, mn)	  
  }
  
  @tailrec  
  def gcdMatchLoop(mx:Int, mn:Int) :Int = mn  match {
    case 0 => mx	      
    case _ => gcdMatchLoop(mn, mx%mn)
	}
  
  println(gcd (78696, 19332))
  println(gcd (78696, 0))  
  println(gcd (0, 78696))
  println(lcm (78696, 19332))
  
  println
  println(gcd (12, 10))
  println(lcm (12, 10))
  
  println
  println(gcdMatch (78696, 19332))  
  println(gcdMatch (78696, 0))  
  println(gcdMatch (0, 78696))
}