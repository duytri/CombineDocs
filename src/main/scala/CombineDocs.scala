package main.scala

import java.io.File
import java.io.BufferedReader
import java.io.FileReader
import java.io.BufferedWriter
import java.io.FileWriter

object CombineDocs {
  def main(args: Array[String]): Unit = {
    val folderIn = new File(args(0)) // args(0) = ./input-folder
    var writer: BufferedWriter = new BufferedWriter(new FileWriter(args(1))) // args(1) = output file
    writer.flush()
    if (folderIn.isDirectory()) {
      val listFiles = folderIn.listFiles()
      writer.write(listFiles.length + "\n")
      listFiles.foreach(file => {
        writer.write(readContent(file) + "\n")
      })
    }
    writer.close()
  }

  def readContent(file: File): String = {
    val reader = new BufferedReader(new FileReader(file))
    var result = ""
    var line = reader.readLine()
    while (line != null) {
      result += line + " "
      line = reader.readLine()
    }
    result.trim()
  }
}