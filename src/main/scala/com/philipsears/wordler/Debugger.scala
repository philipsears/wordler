package com.philipsears.wordler;

/**
 * User: phils
 * Date: 8/9/12
 */
object Debugger {
    def debug(str: String) {
      if (WordlerConfig.debug) {
        println(str)
      }
    }
}
