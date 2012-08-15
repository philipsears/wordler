package com.philipsears.wordler

/**
 * User: phils
 * Date: 8/9/12
 *
 * This is the "Main" Wordler class
 * The main steps are:
 *  a) Read and load dictionary
 *  b) Loop on the worlder user process:
 *     i. Read user input of characters from console
 *    ii. Find all permutations and combinations of characters
 *    iii. If a permutation/combination exists in dictionary, display to user
 */

object Wordler {

  // function to parse the user input
  def parseStrInput(input: String): String = input.replaceAll(",","").replaceAll(" ","").toLowerCase

  def main(args: Array[String]) {
    // Read and load the complete dictionary
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
              if (dictionary.containsWord(word)) {
                // The dictionary contains the word, so display it to user!
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

