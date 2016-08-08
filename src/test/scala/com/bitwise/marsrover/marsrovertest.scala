





import com.bitwise.marsrover._
import org.junit.{Assert, Test}


/**
  * Created by akankshag on 8/4/2016.
  */
class marsRoverTest {

@Test(expected = classOf[InvalidNumberException])
 def PlateauShouldNotBeNegative(): Unit ={
    //given
    val pos=   Pos(-1,-1,North)
    //when
    //then
  }

 @Test(expected = classOf[InvalidNumberException])
  def PlateauShouldNotMoreThen5InXANDYAxis(): Unit ={
    //given
    val pos = Pos(6,6,North)
    //when
    //then
  }


  @Test
  def itShouldMoveLeft(): Unit ={
    //given

    val pos = Pos(0,0,North)
    //when
    val moveleft=pos.left
    //then
    Assert.assertEquals( new Pos(0,0,East),pos.left)
  }

  @Test
  def itShouldMoveRight(): Unit ={
    //given

    val pos = Pos(0,0,North)
    //when
    val moveleft=pos.left
    //then
    Assert.assertEquals( new Pos(0,0,West),pos.left)
  }

  @Test
  def itShouldMoveUpInNorthDirection(): Unit ={
    //given

    val pos =  Pos(0,0,North)
    //when
    val moveleft=pos.Up
    //then
    Assert.assertEquals( Pos(0,1,North),pos.Up)
  }
  @Test
  def itShouldMoveUpInEastDirection(): Unit ={
    //given

    val pos = Pos(1,1,East)
    //when
    val moveleft=pos.Up
    //then
    Assert.assertEquals(  Pos(2,1,East),pos.Up)
  }

  @Test
  def itShouldMoveDownInSouthDirection(): Unit ={
    //given

    val pos =  Pos(1,1,South)
    //when
    val moveleft=pos.Up
    //then
    Assert.assertEquals( Pos(1,0,South),pos.Up)
  }




  @Test
  def itShouldMoveTravelLeftThenRight(): Unit ={
    //given
    val pos= Pos(1,2,North)
    //when
    val moveleft=pos.left

    //then
    Assert.assertEquals( Pos(1,2,East),pos.left)

  val moveup =moveleft.Up
  Assert.assertEquals(  Pos(0,2,West),pos.left.Up)

val againmoveleft =moveup.left
  Assert.assertEquals(  Pos(0,2,South),pos.left.Up.left)

  val move4 = againmoveleft.Up
  Assert.assertEquals(  Pos(0,1,South),move4)


  val move5 = move4.left
  Assert.assertEquals( Pos(0,1,East),pos.left.Up.left.Up.left)

  val move6 = move5.Up
  Assert.assertEquals(Pos(1,1,East),pos.left.Up.left.Up.left.Up)

  val move7 = move6.left
  Assert.assertEquals( Pos(1,1,North),pos.left.Up.left.Up.left.Up.left)

  val move8 = move7.Up
  Assert.assertEquals( Pos(1,2,North),pos.left.Up.left.Up.left.Up.left.Up)

  val move9 = move8.Up
  Assert.assertEquals(Pos(1,3,North),move8.Up.left)
  }


@Test
def itShouldMoveInAnyDirection(): Unit ={
  //given
  val pos=new Pos(3,3,East)
  //when
  val move1 =pos.Up
  Assert.assertEquals( new Pos(5,1,East),pos.Up.Up.right.Up.Up.right.Up.right.right.Up)

  //then
}


}






