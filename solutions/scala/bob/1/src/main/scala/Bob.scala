object Bob {
  def response(s: String): String = {
    
    val lenn=s.trim().length-1
    if (lenn<0){
      return "Fine. Be that way!"
    }
    if (s(lenn)=='?')
    {
      if (s.toUpperCase==s  && s.exists(_.isLetter)  )
      {
      return   "Calm down, I know what I'm doing!" 
      }
      else{
        return "Sure."
      }
    }
    else if (s.trim().length==0){
      return "Fine. Be that way!"
    }
    else if (s.toUpperCase==s && s.exists(_.isLetter)){
      return "Whoa, chill out!"
    }
    
    else{
      return "Whatever."
    }



    
  }
}
