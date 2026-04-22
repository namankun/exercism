import scala.collection.immutable.ListMap

/**
 * The School class acts like a big filing cabinet for students.
 */
class School {
  
  // This is a "Type Alias." It's a shortcut name for our data structure.
  // It says: Our database (DB) is a Map where:
  // - The Key is an Int (the Grade Number)
  // - The Value is a Seq[String] (the list of Student Names)
  type DB = Map[Int, Seq[String]]

  // This is our actual filing cabinet. 
  // We use 'private' so no one can mess with it directly.
  // We use 'var' because we will replace the old cabinet with a new one 
  // every time we add a student.
  private var schoolRoster: DB = Map()

  /**
   * This function adds a student to a specific grade.
   */
  def add(name: String, g: Int): Unit = {
    
    // 1. THE UNIQUENESS CHECK:
    // We look through every folder (values) in our cabinet.
    // We check if any folder already contains the student's name.
    val isAlreadyInSchool = schoolRoster.values.exists(names => names.contains(name))

    if (isAlreadyInSchool) {
      // If we found the name, we don't do anything. 
      // In a real school, you can't be in two places at once!
      println(s"Incorrect: $name is already registered in this school.")
    } else {
      
      // 2. GET THE CURRENT CLASS LIST:
      // We look for the folder for grade 'g'.
      // If the folder doesn't exist yet, we start with an empty list: Seq()
      val currentStudentsInGrade = schoolRoster.getOrElse(g, Seq())

      // 3. UPDATE THE LIST:
      // We create a new list that has all the old students PLUS the new one.
      val updatedStudentsInGrade = currentStudentsInGrade :+ name

      // 4. UPDATE THE FILING CABINET:
      // We update our 'schoolRoster' map by linking the grade 'g' to our new list.
      schoolRoster = schoolRoster + (g -> updatedStudentsInGrade)
    }
  }

  /**
   * This function just shows us the whole filing cabinet as it is.
   */
  def db: DB = schoolRoster

  /**
   * This function lets us see only the students in one specific grade.
   */
  def grade(g: Int): Seq[String] = {
    // If the grade exists, show the names. If not, show an empty list.
    schoolRoster.getOrElse(g, Seq())
  }

  /**
   * This function provides a perfectly organized version of the school.
   */
  def sorted: DB = {
    
    // STEP A: Sort the names inside each grade folder alphabetically (A-Z).
    // The .map function goes through every "Grade -> Names" pair.
    val sortedNames = schoolRoster.map { case (gradeLevel, names) =>
      (gradeLevel, names.sorted)
    }

    // STEP B: Sort the grades themselves numerically (Grade 1, then 2, then 3...).
    // 1. .toSeq converts the Map into a list of tuples so we can sort them.
    // 2. .sortBy(_._1) tells Scala to sort by the first part of the tuple (the Grade).
    // 3. ListMap(...) puts them back into a special Map that stays in order.
    ListMap(sortedNames.toSeq.sortBy(_._1): _*)
  }
}