package com.philipsears.wordler


/**
 * User: phils
 * Date: 8/14/12
 * This is the brute force non-optimal example of a dictionary
 * This should ONLY be used as a reference example and not for optimal playing :(
 */
class ListDictionary() extends Dictionary {
   protected var dictionaryList = new collection.mutable.MutableList[String]()

   readDicFile(this)

   def containsWord(w: String) = findWord(w) != null

   def wordLength(w: String): Int = {
     var word = findWord(w)
     if (word == null) 0 else word.length 
   }

   def addWord(w:String) { dictionaryList += w }

   def numWords() = dictionaryList.size
  
  def findWord(w:String) : String = {
    for (next <- dictionaryList.iterator) {
      if (next == w) return next
    }
    return null
  }    
}
