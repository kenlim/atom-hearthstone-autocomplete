#!/bin/sh
exec scala "$0" "$@"
!#
import scala.io.Source

val lines = Source.fromFile("cards").getLines.toList
println(""""*" :""")

lines.foreach {line =>
  val items = line.split("\t")
  val cardName = items(0)

  val quantityPlaceholder = items(1) match {
    case ("Legendary") => "*"
    case _ => """${1:1}"""
  }

  println (s""" "$cardName":""")
  println (s"""   "prefix" : "$cardName"""")
  println (s"""   "body" : "$cardName $quantityPlaceholder"""" )
}
