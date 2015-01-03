package de.frosner.ngrams

import java.io.{BufferedReader, InputStreamReader}

import scala.io.Source

object NGrams {

  def main(args: Array[String]) {
    val n = args(0).toInt
    val nGramLines = for (line <- Source.stdin.getLines()) yield line.sliding(n).map((_, 1))
    val nGrams = nGramLines.reduce(_ ++ _).toIterable
    val counts = nGrams.groupBy{ case (ngram, _) => ngram }.mapValues(_.size)
    counts foreach println
  }

}
