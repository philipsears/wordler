package com.philipsears.wordler

import java.io.File
import io.Source

/**
 * User: phils
 * Date: 8/9/12
 *
 * This is the base class for the Dictionary.
 * A dictionary should be able to quickly look up words for existence
 */
abstract class Dictionary {

  /** Determine whether dictionary contains word w **/
  def containsWord(w: String): Boolean

  /** Returns the length or points of word w **/
  def wordLength(w: String): Int

  /** Adds a word to the dictionary **/
  def addWord(w:String)

  /** number of words in dictionary **/
  def numWords(): Int

  protected val readDicFile: Dictionary => Unit = (dic: Dictionary) => {
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
            dic.addWord(line)
          } else if
            (line.length > 1 && Character.isUpperCase(line.charAt(0)) && !WordlerConfig.ignoreProperNames) {
            Debugger.debug("IGNORE PROPER NAME ")
            dic.addWord(line)
          } else {
            count = count + 1
            Debugger.debug("Next word ("+count+"): "+line)
            dic.addWord(line);
          }
        }
      Debugger.debug("Dictionary contains "+dic.numWords()+" words")
        source.close
    }
  }

}
