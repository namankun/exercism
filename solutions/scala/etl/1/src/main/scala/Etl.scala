import scala.collection.mutable
object Etl {
  def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] = {
    var ans=mutable.HashMap[String,Int]()
    for((vall,chrr)<-scoreMap)
    {
      for(i<- 0 until chrr.length){
        ans(chrr(i).toLowerCase())=vall
      }
    }
    return ans.toMap
  }
}
