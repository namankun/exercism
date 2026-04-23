object Hamming {
  def distance(d1: String, d2: String): Option[Int] = {
    if(d1.length!=d2.length)
    {
      return None
    }
    
var c=0
    for(i<- 0 until d1.length){
      if(d1(i)!=d2(i))
      {
        c+=1
      }
    }

    return Some(c)

    
  }
}
