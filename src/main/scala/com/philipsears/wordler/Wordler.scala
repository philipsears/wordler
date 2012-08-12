package com.philipsears.wordler

/**
 * User: phils
 * Date: 8/9/12
 *
 * This is the "Main" Worlder class
 */

object Wordler {

  def parseStrInput(input: String): String = input.replaceAll(",","").replaceAll(" ","").toLowerCase

  def main(args: Array[String]) {
    var dictionary = new HashDictionary()
    do {
        var startTime = System.currentTimeMillis()
        print("Please enter the characters (from 3 to "+WordlerConfig.maxChars+" in length):");
        var charstr = parseStrInput(readLine())
        while(charstr.size < 3 || charstr.size > WordlerConfig.maxChars) {
          println("The input was "+charstr.size+" BUT must be from 3 to "+WordlerConfig.maxChars+" in length!");
          print("Please re-enter characters:");
          charstr = parseStrInput(readLine())
        }
  
        val charList = charstr.toCharArray.toList
        Debugger.debug("You have entered the character list (PRESS RETURN/ENTER): "+charList);
  
        var count = 0
        for (i <- 4 until charList.size + 1) {
          var combIter = charList.combinations(i)
          while (combIter.hasNext) {
            val nextComb = combIter.next
            var permIter = nextComb.permutations
            while (permIter.hasNext) {
              val nextWord = permIter.next
              count = count + 1
              val word = nextWord.mkString
              Debugger.debug("debug next word "+word)
              if (dictionary.containsWord(word)) {
                println(word)
              }
            }
          }
        }
  
        var timeInSecs = (System.currentTimeMillis() - startTime) /1000.0
        Debugger.debug("Took "+timeInSecs+" seconds.")
    } while (true)
  }

}

