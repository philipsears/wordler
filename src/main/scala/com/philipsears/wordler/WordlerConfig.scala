package com.philipsears.wordler

/**
 * User: phils
 * Date: 8/9/12
 * Time: 9:57 AM
 *
 * The main configuration file for the Wordler program
 */
object WordlerConfig {

  //The path to the dictionary file on your local machine.
   //The text file should contain one word per line in lower case
  def dictionaryPath = "/Users/phils/Documents/en-US.dic"

  // Determines whether to ignore possessive words in the dictionary that end with 's
  def ignorePossessives = true

  // Determines whether to ignore proper names - those that are upper case
  def ignoreProperNames = true

  // the maximum number of characters that a user can input
  def maxChars = 12

  // Determines whether verbose debugging is on
  def debug = false

  // Determines whether verbose info is on
  def info = false

}
