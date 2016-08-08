package com.bitwise.marsrover


/**
  * Created by akankshag on 8/4/2016.
  */





trait roverPos{
  def left:Pos
  def right:Pos
  def Up:Pos
}


class Pos(x:Int,y:Int,direction:Direction1 )extends roverPos {
  val x1 = x
  val y1 = y


  override  def left:Pos = {
    direction match {
      case North => new Pos(x, y, West)
      case West => new Pos(x, y, South)
      case South => new Pos(x, y, East)
      case East => new Pos(x, y, North)
    }
  }

    override def right:Pos = {
      direction match {
        case East => new Pos(x, y, South)
        case South => new Pos(x, y, West)
        case West => new Pos(x, y, North)
        case North => new Pos(x, y, East)

      }
    }

    override  def Up:Pos = {
      direction match {
        case West => new Pos(x - 1, y, West)
        case South => new Pos(x, y - 1, South)
        case East => new Pos(x + 1, y, East)
        case North => new Pos(x, y + 1, North)
      }
    }

       override def toString = s"Pos($x1, $y1)"


    def canEqual(other: Any): Boolean = other.isInstanceOf[Pos]

    override def equals(other: Any): Boolean = other match {
      case that: Pos =>
        (that canEqual this) &&
          x1 == that.x1 &&
          y1 == that.y1
      case _ => false
    }

    override def hashCode(): Int =
    {
      val state = Seq(x1, y1)
      state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
    }




}
  class InvalidNumberException extends RuntimeException


  object Pos {
    def apply(x: Int, y: Int, direction: Direction1): Pos = (x, y) match {
      case (x, y) if (x < 0 & y < 0) => throw new InvalidNumberException
      case (x, y) if (x > 5 & y > 5) => throw new InvalidNumberException
      case (_, _) => Pos(x, y, direction)


    }
  }



