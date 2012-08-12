package com.philipsears.wordler

import java.io.File
import io.Source

/**
 * User: phils
 * Date: 8/9/12
 */
abstract class Dictionary {

  protected val dictionaryHash = new scala.collection.mutable.HashMap[String,Int]()

  /** Determine whether dictionary contains word w **/
  def containsWord(w: String): Boolean

  /** Returns the length or points of word w **/
  def wordLength(w: String): Int

  /** Adds a word to the dictionary **/
  def addWord(w:String)

  /** number of words in dictionary **/
  def numWords(): Int

  if (!new File(WordlerConfig.dictionaryPath).exists()) {
      println("ERROR: dictionary path "+WordlerConfig.dictionaryPath+" does not exist!")
    ()
  }else {
      Debugger.debug("Dictionary file has been loaded successfully!")
      val source = Source.fromFile(WordlerConfig.dictionaryPath)
      var lines = source.getLines()
      var count = 0;
      while (lines.hasNext) {
        val line = lines.next()
        if (line.contains(("'")) && !WordlerConfig.ignorePossessives) {
          Debugger.debug("IGNORE THIS ' word")
          addWord(line)
        } else if
          (line.length > 1 && Character.isUpperCase(line.charAt(0)) && !WordlerConfig.ignoreProperNames) {
          Debugger.debug("IGNORE PROPER NAME ")
          addWord(line)
        } else {
          count = count + 1
          Debugger.debug("Next word ("+count+"): "+line)
          addWord(line);
        }
      }
    Debugger.debug("Dictionary contains "+numWords()+" words")
      source.close
  }

}
