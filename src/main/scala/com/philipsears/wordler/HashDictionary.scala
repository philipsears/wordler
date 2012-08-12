package com.philipsears.wordler

/**
 * User: phils
 * Date: 8/9/12
 */
class HashDictionary() extends Dictionary {

  def containsWord(w: String) = dictionaryHash.contains(w)

  def wordLength(w: String) = dictionaryHash.get(w).get

  def addWord(w:String) { dictionaryHash.put(w,w.size) }

  def numWords() = dictionaryHash.keySet.size

}
