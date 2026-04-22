object Leap {
  def leapYear(year: Int): Boolean = {

    if (year%100==0){
      if (year%400==0)
      {
        return true
      }
      else{
        return false
      }
      
    }
    else if (year%4==0)
    {
      return true
    }
    else{
      return false
    }


    
  }
}
