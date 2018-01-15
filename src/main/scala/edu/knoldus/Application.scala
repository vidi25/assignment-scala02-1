package edu.knoldus

import org.apache.log4j.Logger

object Application extends App{

  val log = Logger.getLogger(this.getClass)

  val app = new Operations

  val noOfPlaces = 2

  val char1 = 'a'
  val char2 = 'a'
  val char3 = 'b'
  val char4 = 'c'
  val char5 = 'c'

  val inputList1 = List(char1,char2,char3,char4,char5)

  val inputNumber1 = 12
  val inputNumber2 = 5
  val inputNumber3 = 19
  val inputNumber4 = 7

  val inputList2 = List(inputNumber1,inputNumber2,inputNumber3,inputNumber4)

  val inputList3 = List("hi","hi","bye","bye","hi")

  log.info(s"After rotation list = ${app.rotate(noOfPlaces,inputList2)}\n")

  log.info(s"After removing duplicates list = ${app.removeDuplicates(inputList1)}\n")

  log.info(s"${inputList2.map(app.findHappyNumber)}\n")

  log.info(s"Run length encoding list = ${app.runLengthEncoding(inputList3)}\n")

}
