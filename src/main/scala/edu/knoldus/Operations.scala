package edu.knoldus

class Operations {

  def runLengthEncoding(inputList: List[String]): List[(String, Int)] = {
    def runLengthEncodingRecursive(inputList: List[String], resultantList: List[(String, Int)]): List[(String, Int)] = {
      inputList match {
        case Nil => resultantList
        case head :: _ => val (result, remaining) = inputList.span(x => x == head)
          runLengthEncodingRecursive(remaining, resultantList ::: List((head, result.length)))
      }
    }

    runLengthEncodingRecursive(inputList, List())
  }

  def rotate(noOfPlaces: Int, inputList: List[Int]): List[Int] = {
    def rotateRecursive(noOfPlaces: Int, list: List[Int]): List[Int] = {
      list match {
        case Nil => throw new Exception("list is empty")
        case head :: tail if noOfPlaces > 0 => rotateRecursive(noOfPlaces - 1, tail :+ head)
        case _ => list
      }
    }

    rotateRecursive(noOfPlaces, inputList)
  }

  def removeDuplicates(inputList: List[Char]): List[Char] = {
    def removeDuplicatesRecursive(inputList: List[Char], resultantList: List[Char]): List[Char] = {
      inputList match {
        case Nil => resultantList
        case head1 :: head2 :: tail if head1 == head2 => removeDuplicatesRecursive(head1 :: tail, resultantList)
        case head :: tail => removeDuplicatesRecursive(tail, resultantList :+ head)
      }
    }

    if (inputList.nonEmpty) {
      removeDuplicatesRecursive(inputList, Nil)
    }
    else {
      throw new Exception("list is empty")
    }
  }

  def findHappyNumber(number: Int): Boolean = {
    def recursiveHappy(list: List[Int], number: Int): Boolean = {
      number match {
        case 1 => true
        case num if list.contains(num) => false
        case _ => recursiveHappy(number :: list, sumOfSquares(number))
      }
    }

    recursiveHappy(Nil, number)
  }

  def findSquare(number: Int): Int = number * number

  def sumOfSquares(number: Int): Int = {
    def sumOfSquaresRecursive(number: Int, sum: Int): Int = {
      number match {
        case 0 => sum
        case num if num < 10 => sum + findSquare(num)
        case _ => sumOfSquaresRecursive(number / 10, sum + findSquare(number % 10))
      }
    }

    sumOfSquaresRecursive(number, 0)
  }

}
