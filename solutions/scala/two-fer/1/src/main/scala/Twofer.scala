object Twofer {
  def twofer(name: String=""): String = {
    var x=name
      if (name.length<1){
        x="you"
      }

    return "One for " + x + ", one for me."

    
  }
}
