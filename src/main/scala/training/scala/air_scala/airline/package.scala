package training.scala.air_scala

import training.scala.air_scala.aircraft._

package object airline {


  def checkinPassenger[A <: SeatingClass : PassengerType](plane: AircraftModel)
                      (passenger: Passenger[A]): Seat = {

    val seatClass: SeatingClass = implicitly[PassengerType[A]].seatType
    ???
  }

  def checkinPassengerImplicit[A <: SeatingClass](plane: AircraftModel)
                              (passenger: Passenger[A])
                              (implicit passengerType: PassengerType[A]): Seat = {
    val seatClass: SeatingClass = passengerType.seatType
    ???
  }

  trait PassengerType[A <: SeatingClass] {
    val seatType: A
  }

  implicit val FirstClassPassenger = new PassengerType[FirstClass.type] {
    final val seatType = FirstClass
  }

  implicit val BusinessClassPassenger = new PassengerType[BusinessClass.type] {
    final val seatType = BusinessClass
  }

  implicit val EconomyPlusClassPassenger = new PassengerType[EconomyPlus.type] {
    final val seatType = EconomyPlus
  }

  implicit val EconomyClassPassenger = new PassengerType[Economy.type] {
    final val seatType = Economy
  }

}
