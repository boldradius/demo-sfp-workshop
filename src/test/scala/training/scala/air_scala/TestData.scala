package training.scala.air_scala

import squants.space.NauticalMiles
import training.scala.air_scala.aircraft._
import training.scala.air_scala.aircraft.Aircraft
import training.scala.air_scala.airport.{Gate, AirportCode}
import training.scala.air_scala.flights.scheduling.ProposedItinerary
import training.scala.air_scala.flights.{FlightNumber, FlightLeg, Schedule, Flight}
import com.github.nscala_time.time.Imports._
import squants.market._
import squants.space.Length._
import MoneyConversions._


import scala.collection.immutable.HashMap

object TestData {


  case object CRJ200 extends AircraftModel with TurboProp {
    val seatAssignments = Map.empty
    val FirstClassSeats =  Vector.empty[Seat]
    val BusinessClassSeats = Vector.empty[Seat]
    val EconomyPlusSeats = Vector(
        EconomyPlusSeat(1, 'A', WindowSeat), EconomyPlusSeat(1, 'B', MiddleSeat), EconomyPlusSeat(1, 'C', AisleSeat),
        EconomyPlusSeat(2, 'A', WindowSeat), EconomyPlusSeat(2, 'B', MiddleSeat), EconomyPlusSeat(2, 'C', AisleSeat),
        EconomyPlusSeat(3, 'A', WindowSeat), EconomyPlusSeat(3, 'B', MiddleSeat), EconomyPlusSeat(3, 'C', AisleSeat),
        EconomyPlusSeat(4, 'A', WindowSeat ), EconomyPlusSeat(4, 'B', MiddleSeat), EconomyPlusSeat(4, 'C', AisleSeat)
    )
    val EconomySeats = Vector(
        EconomySeat(5, 'A', WindowSeat), EconomySeat(5, 'B', MiddleSeat), EconomySeat(5, 'C', AisleSeat),
        EconomySeat(6, 'A', WindowSeat), EconomySeat(6, 'B', MiddleSeat), EconomySeat(6, 'C', AisleSeat),
        EconomySeat(7, 'A', WindowSeat), EconomySeat(7, 'B', MiddleSeat), EconomySeat(7, 'C', AisleSeat),
        EconomySeat(8, 'A', WindowSeat), EconomySeat(8, 'B', MiddleSeat), EconomySeat(8, 'C', AisleSeat),
        EconomySeat(9, 'A', WindowSeat), EconomySeat(9, 'B', MiddleSeat), EconomySeat(9, 'C', AisleSeat),
        EconomySeat(10, 'A', WindowSeat), EconomySeat(10, 'B', MiddleSeat), EconomySeat(10, 'C', AisleSeat),
        EconomySeat(11, 'A', WindowSeat), EconomySeat(11, 'B', MiddleSeat), EconomySeat(11, 'C', AisleSeat),
        EconomySeat(12, 'A', WindowSeat), EconomySeat(12, 'B', MiddleSeat), EconomySeat(12, 'C', AisleSeat),
        EconomySeat(13, 'A', WindowSeat), EconomySeat(13, 'B', MiddleSeat), EconomySeat(13, 'C', AisleSeat)
      )
  }

  case object MD11 extends AircraftModel with WideBodyJet {
    val seatAssignments = Map.empty
    val FirstClassSeats = Vector.empty[Seat]
    val BusinessClassSeats = Vector(
        BusinessClassSeat(1, 'A', WindowSeat), BusinessClassSeat(1, 'B', MiddleSeat), BusinessClassSeat(1, 'C', AisleSeat), BusinessClassSeat(1, 'D', AisleSeat),
        BusinessClassSeat(2, 'A', WindowSeat), BusinessClassSeat(2, 'B', MiddleSeat), BusinessClassSeat(2, 'C', AisleSeat), BusinessClassSeat(2, 'D', AisleSeat),
        BusinessClassSeat(3, 'A', WindowSeat), BusinessClassSeat(3, 'B', MiddleSeat), BusinessClassSeat(3, 'C', AisleSeat), BusinessClassSeat(3, 'D', AisleSeat),
        BusinessClassSeat(4, 'A', WindowSeat), BusinessClassSeat(4, 'B', MiddleSeat), BusinessClassSeat(4, 'C', AisleSeat), BusinessClassSeat(4, 'D', AisleSeat),
        BusinessClassSeat(5, 'A', WindowSeat), BusinessClassSeat(5, 'B', MiddleSeat), BusinessClassSeat(5, 'C', AisleSeat), BusinessClassSeat(5, 'D', AisleSeat)
      )
    val EconomyPlusSeats = Vector(
        EconomyPlusSeat(6, 'A', WindowSeat), EconomyPlusSeat(6, 'B', MiddleSeat), EconomyPlusSeat(6, 'C', AisleSeat),
        EconomyPlusSeat(6, 'D', AisleSeat), EconomyPlusSeat(6, 'E', MiddleSeat), EconomyPlusSeat(6, 'F', AisleSeat),
        EconomyPlusSeat(6, 'G', AisleSeat), EconomyPlusSeat(6, 'H', MiddleSeat), EconomyPlusSeat(6, 'J', WindowSeat),
        EconomyPlusSeat(7, 'A', WindowSeat), EconomyPlusSeat(7, 'B', MiddleSeat), EconomyPlusSeat(7, 'C', AisleSeat),
        EconomyPlusSeat(7, 'D', AisleSeat), EconomyPlusSeat(7, 'E', MiddleSeat), EconomyPlusSeat(7, 'F', AisleSeat),
        EconomyPlusSeat(7, 'G', AisleSeat), EconomyPlusSeat(7, 'H', MiddleSeat), EconomyPlusSeat(7, 'J', WindowSeat),
        EconomyPlusSeat(8, 'A', WindowSeat), EconomyPlusSeat(8, 'B', MiddleSeat), EconomyPlusSeat(8, 'C', AisleSeat),
        EconomyPlusSeat(8, 'D', AisleSeat), EconomyPlusSeat(8, 'E', MiddleSeat), EconomyPlusSeat(8, 'F', AisleSeat),
        EconomyPlusSeat(8, 'G', AisleSeat), EconomyPlusSeat(8, 'H', MiddleSeat), EconomyPlusSeat(8, 'J', WindowSeat),
        EconomyPlusSeat(9, 'A', WindowSeat), EconomyPlusSeat(9, 'B', MiddleSeat), EconomyPlusSeat(9, 'C', AisleSeat),
        EconomyPlusSeat(9, 'D', AisleSeat), EconomyPlusSeat(9, 'E', MiddleSeat), EconomyPlusSeat(9, 'F', AisleSeat),
        EconomyPlusSeat(9, 'G', AisleSeat), EconomyPlusSeat(9, 'H', MiddleSeat), EconomyPlusSeat(9, 'J', WindowSeat),
        EconomyPlusSeat(10, 'A', WindowSeat), EconomyPlusSeat(10, 'B', MiddleSeat), EconomyPlusSeat(10, 'C', AisleSeat),
        EconomyPlusSeat(10, 'D', AisleSeat), EconomyPlusSeat(10, 'E', MiddleSeat), EconomyPlusSeat(10, 'F', AisleSeat),
        EconomyPlusSeat(10, 'G', AisleSeat), EconomyPlusSeat(10, 'H', MiddleSeat), EconomyPlusSeat(10, 'J', WindowSeat),
        EconomyPlusSeat(11, 'A', WindowSeat), EconomyPlusSeat(11, 'B', MiddleSeat), EconomyPlusSeat(11, 'C', AisleSeat),
        EconomyPlusSeat(11, 'D', AisleSeat), EconomyPlusSeat(11, 'E', MiddleSeat), EconomyPlusSeat(11, 'F', AisleSeat),
        EconomyPlusSeat(11, 'G', AisleSeat), EconomyPlusSeat(11, 'H', MiddleSeat), EconomyPlusSeat(11, 'J', WindowSeat),
        EconomyPlusSeat(12, 'A', WindowSeat), EconomyPlusSeat(12, 'B', MiddleSeat), EconomyPlusSeat(12, 'C', AisleSeat),
        EconomyPlusSeat(12, 'D', AisleSeat), EconomyPlusSeat(12, 'E', MiddleSeat), EconomyPlusSeat(12, 'F', AisleSeat),
        EconomyPlusSeat(12, 'G', AisleSeat), EconomyPlusSeat(12, 'H', MiddleSeat), EconomyPlusSeat(12, 'J', WindowSeat),
        EconomyPlusSeat(13, 'A', WindowSeat), EconomyPlusSeat(13, 'B', MiddleSeat), EconomyPlusSeat(13, 'C', AisleSeat),
        EconomyPlusSeat(13, 'D', AisleSeat), EconomyPlusSeat(13, 'E', MiddleSeat), EconomyPlusSeat(13, 'F', AisleSeat),
        EconomyPlusSeat(13, 'G', AisleSeat), EconomyPlusSeat(13, 'H', MiddleSeat), EconomyPlusSeat(13, 'J', WindowSeat),
        EconomyPlusSeat(14, 'A', WindowSeat), EconomyPlusSeat(14, 'B', MiddleSeat), EconomyPlusSeat(14, 'C', AisleSeat),
        EconomyPlusSeat(14, 'D', AisleSeat), EconomyPlusSeat(14, 'E', MiddleSeat), EconomyPlusSeat(14, 'F', AisleSeat),
        EconomyPlusSeat(14, 'G', AisleSeat), EconomyPlusSeat(14, 'H', MiddleSeat), EconomyPlusSeat(14, 'J', WindowSeat),
        EconomyPlusSeat(15, 'A', WindowSeat), EconomyPlusSeat(15, 'B', MiddleSeat), EconomyPlusSeat(15, 'C', AisleSeat),
        EconomyPlusSeat(15, 'D', AisleSeat), EconomyPlusSeat(15, 'E', MiddleSeat), EconomyPlusSeat(15, 'F', AisleSeat),
        EconomyPlusSeat(15, 'G', AisleSeat), EconomyPlusSeat(15, 'H', MiddleSeat), EconomyPlusSeat(15, 'J', WindowSeat),
        EconomyPlusSeat(16, 'A', WindowSeat), EconomyPlusSeat(16, 'B', MiddleSeat), EconomyPlusSeat(16, 'C', AisleSeat),
        EconomyPlusSeat(16, 'D', AisleSeat), EconomyPlusSeat(16, 'E', MiddleSeat), EconomyPlusSeat(16, 'F', AisleSeat),
        EconomyPlusSeat(16, 'G', AisleSeat), EconomyPlusSeat(16, 'H', MiddleSeat), EconomyPlusSeat(16, 'J', WindowSeat),
        EconomyPlusSeat(20, 'A', WindowSeat), EconomyPlusSeat(20, 'B', MiddleSeat), EconomyPlusSeat(20, 'C', AisleSeat),
        EconomyPlusSeat(20, 'D', AisleSeat), EconomyPlusSeat(20, 'E', MiddleSeat), EconomyPlusSeat(20, 'F', AisleSeat),
        EconomyPlusSeat(20, 'G', AisleSeat), EconomyPlusSeat(20, 'H', MiddleSeat), EconomyPlusSeat(20, 'J', WindowSeat),
        EconomyPlusSeat(21, 'A', WindowSeat), EconomyPlusSeat(21, 'B', MiddleSeat), EconomyPlusSeat(21, 'C', AisleSeat),
        EconomyPlusSeat(21, 'D', AisleSeat), EconomyPlusSeat(21, 'E', MiddleSeat), EconomyPlusSeat(21, 'F', AisleSeat),
        EconomyPlusSeat(21, 'G', AisleSeat), EconomyPlusSeat(21, 'H', MiddleSeat), EconomyPlusSeat(21, 'J', WindowSeat),
        EconomyPlusSeat(22, 'A', WindowSeat), EconomyPlusSeat(22, 'B', MiddleSeat), EconomyPlusSeat(22, 'C', AisleSeat),
        EconomyPlusSeat(22, 'D', AisleSeat), EconomyPlusSeat(22, 'E', MiddleSeat), EconomyPlusSeat(22, 'F', AisleSeat),
        EconomyPlusSeat(22, 'G', AisleSeat), EconomyPlusSeat(22, 'H', MiddleSeat), EconomyPlusSeat(22, 'J', WindowSeat)
      )
    val EconomySeats = Vector(
        EconomySeat(17, 'A', WindowSeat), EconomySeat(17, 'B', MiddleSeat), EconomySeat(17, 'C', AisleSeat),
        EconomySeat(17, 'D', AisleSeat), EconomySeat(17, 'E', MiddleSeat), EconomySeat(17, 'F', AisleSeat),
        EconomySeat(17, 'G', AisleSeat), EconomySeat(17, 'H', MiddleSeat), EconomySeat(17, 'J', WindowSeat),
        EconomySeat(18, 'A', WindowSeat), EconomySeat(18, 'B', MiddleSeat), EconomySeat(18, 'C', AisleSeat),
        EconomySeat(18, 'D', AisleSeat), EconomySeat(18, 'E', MiddleSeat), EconomySeat(18, 'F', AisleSeat),
        EconomySeat(18, 'G', AisleSeat), EconomySeat(18, 'H', MiddleSeat), EconomySeat(18, 'J', WindowSeat),
        EconomySeat(19, 'A', WindowSeat), EconomySeat(19, 'B', MiddleSeat), EconomySeat(19, 'C', AisleSeat),
        EconomySeat(19, 'D', AisleSeat), EconomySeat(19, 'E', MiddleSeat), EconomySeat(19, 'F', AisleSeat),
        EconomySeat(19, 'G', AisleSeat), EconomySeat(19, 'H', MiddleSeat), EconomySeat(19, 'J', WindowSeat),
        EconomySeat(23, 'A', WindowSeat), EconomySeat(23, 'B', MiddleSeat), EconomySeat(23, 'C', AisleSeat),
        EconomySeat(23, 'D', AisleSeat), EconomySeat(23, 'E', MiddleSeat), EconomySeat(23, 'F', AisleSeat),
        EconomySeat(23, 'G', AisleSeat), EconomySeat(23, 'H', MiddleSeat), EconomySeat(23, 'J', WindowSeat),
        EconomySeat(24, 'A', WindowSeat), EconomySeat(24, 'B', MiddleSeat), EconomySeat(24, 'C', AisleSeat),
        EconomySeat(24, 'D', AisleSeat), EconomySeat(24, 'E', MiddleSeat), EconomySeat(24, 'F', AisleSeat),
        EconomySeat(24, 'G', AisleSeat), EconomySeat(24, 'H', MiddleSeat), EconomySeat(24, 'J', WindowSeat),
        EconomySeat(25, 'A', WindowSeat), EconomySeat(25, 'B', MiddleSeat), EconomySeat(25, 'C', AisleSeat),
        EconomySeat(25, 'D', AisleSeat), EconomySeat(25, 'E', MiddleSeat), EconomySeat(25, 'F', AisleSeat),
        EconomySeat(25, 'G', AisleSeat), EconomySeat(25, 'H', MiddleSeat), EconomySeat(25, 'J', WindowSeat),
        EconomySeat(26, 'A', WindowSeat), EconomySeat(26, 'B', MiddleSeat), EconomySeat(26, 'C', AisleSeat),
        EconomySeat(26, 'D', AisleSeat), EconomySeat(26, 'E', MiddleSeat), EconomySeat(26, 'F', AisleSeat),
        EconomySeat(26, 'G', AisleSeat), EconomySeat(26, 'H', MiddleSeat), EconomySeat(26, 'J', WindowSeat),
        EconomySeat(27, 'A', WindowSeat), EconomySeat(27, 'B', MiddleSeat), EconomySeat(27, 'C', AisleSeat),
        EconomySeat(27, 'D', AisleSeat), EconomySeat(27, 'E', MiddleSeat), EconomySeat(27, 'F', AisleSeat),
        EconomySeat(27, 'G', AisleSeat), EconomySeat(27, 'H', MiddleSeat), EconomySeat(27, 'J', WindowSeat),
        EconomySeat(28, 'A', WindowSeat), EconomySeat(28, 'B', MiddleSeat), EconomySeat(28, 'C', AisleSeat),
        EconomySeat(28, 'D', AisleSeat), EconomySeat(28, 'E', MiddleSeat), EconomySeat(28, 'F', AisleSeat),
        EconomySeat(28, 'G', AisleSeat), EconomySeat(28, 'H', MiddleSeat), EconomySeat(28, 'J', WindowSeat),
        EconomySeat(29, 'A', WindowSeat), EconomySeat(29, 'B', MiddleSeat), EconomySeat(29, 'C', AisleSeat),
        EconomySeat(29, 'D', AisleSeat), EconomySeat(29, 'E', MiddleSeat), EconomySeat(29, 'F', AisleSeat),
        EconomySeat(29, 'G', AisleSeat), EconomySeat(29, 'H', MiddleSeat), EconomySeat(29, 'J', WindowSeat),
        EconomySeat(30, 'A', WindowSeat), EconomySeat(30, 'B', MiddleSeat), EconomySeat(30, 'C', AisleSeat),
        EconomySeat(30, 'D', AisleSeat), EconomySeat(30, 'E', MiddleSeat), EconomySeat(30, 'F', AisleSeat),
        EconomySeat(30, 'G', AisleSeat), EconomySeat(30, 'H', MiddleSeat), EconomySeat(30, 'J', WindowSeat),
        EconomySeat(31, 'A', WindowSeat), EconomySeat(31, 'B', MiddleSeat), EconomySeat(31, 'C', AisleSeat),
        EconomySeat(31, 'D', AisleSeat), EconomySeat(31, 'E', MiddleSeat), EconomySeat(31, 'F', AisleSeat),
        EconomySeat(31, 'G', AisleSeat), EconomySeat(31, 'H', MiddleSeat), EconomySeat(31, 'J', WindowSeat),
        EconomySeat(32, 'A', WindowSeat), EconomySeat(32, 'B', MiddleSeat), EconomySeat(32, 'C', AisleSeat),
        EconomySeat(32, 'D', AisleSeat), EconomySeat(32, 'E', MiddleSeat), EconomySeat(32, 'F', AisleSeat),
        EconomySeat(32, 'G', AisleSeat), EconomySeat(32, 'H', MiddleSeat), EconomySeat(32, 'J', WindowSeat),
        EconomySeat(33, 'A', WindowSeat), EconomySeat(33, 'B', MiddleSeat), EconomySeat(33, 'C', AisleSeat),
        EconomySeat(33, 'D', AisleSeat), EconomySeat(33, 'E', MiddleSeat), EconomySeat(33, 'F', AisleSeat),
        EconomySeat(33, 'G', AisleSeat), EconomySeat(33, 'H', MiddleSeat), EconomySeat(33, 'J', WindowSeat),
        EconomySeat(34, 'A', WindowSeat), EconomySeat(34, 'B', MiddleSeat), EconomySeat(34, 'C', AisleSeat),
        EconomySeat(34, 'D', AisleSeat), EconomySeat(34, 'E', MiddleSeat), EconomySeat(34, 'F', AisleSeat),
        EconomySeat(34, 'G', AisleSeat), EconomySeat(34, 'H', MiddleSeat), EconomySeat(34, 'J', WindowSeat),
        EconomySeat(35, 'A', WindowSeat), EconomySeat(35, 'B', MiddleSeat), EconomySeat(35, 'C', AisleSeat),
        EconomySeat(35, 'D', AisleSeat), EconomySeat(35, 'E', MiddleSeat), EconomySeat(35, 'F', AisleSeat),
        EconomySeat(35, 'G', AisleSeat), EconomySeat(35, 'H', MiddleSeat), EconomySeat(35, 'J', WindowSeat),
        EconomySeat(36, 'A', WindowSeat), EconomySeat(36, 'B', MiddleSeat), EconomySeat(36, 'C', AisleSeat),
        EconomySeat(36, 'D', AisleSeat), EconomySeat(36, 'E', MiddleSeat), EconomySeat(36, 'F', AisleSeat),
        EconomySeat(36, 'G', AisleSeat), EconomySeat(36, 'H', MiddleSeat), EconomySeat(36, 'J', WindowSeat),
        EconomySeat(37, 'A', WindowSeat), EconomySeat(37, 'B', MiddleSeat), EconomySeat(37, 'C', AisleSeat),
        EconomySeat(37, 'D', AisleSeat), EconomySeat(37, 'E', MiddleSeat), EconomySeat(37, 'F', AisleSeat),
        EconomySeat(37, 'G', AisleSeat), EconomySeat(37, 'H', MiddleSeat), EconomySeat(37, 'J', WindowSeat),
        EconomySeat(38, 'A', WindowSeat), EconomySeat(38, 'B', MiddleSeat), EconomySeat(38, 'C', AisleSeat),
        EconomySeat(38, 'D', AisleSeat), EconomySeat(38, 'E', MiddleSeat), EconomySeat(38, 'F', AisleSeat),
        EconomySeat(38, 'G', AisleSeat), EconomySeat(38, 'H', MiddleSeat), EconomySeat(38, 'J', WindowSeat),
        EconomySeat(39, 'A', WindowSeat), EconomySeat(39, 'B', MiddleSeat), EconomySeat(39, 'C', AisleSeat),
        EconomySeat(39, 'D', AisleSeat), EconomySeat(39, 'E', MiddleSeat), EconomySeat(39, 'F', AisleSeat),
        EconomySeat(39, 'G', AisleSeat), EconomySeat(39, 'H', MiddleSeat), EconomySeat(39, 'J', WindowSeat),
        EconomySeat(40, 'A', WindowSeat), EconomySeat(40, 'B', MiddleSeat), EconomySeat(40, 'C', AisleSeat),
        EconomySeat(40, 'D', AisleSeat), EconomySeat(40, 'E', MiddleSeat), EconomySeat(40, 'F', AisleSeat),
        EconomySeat(40, 'G', AisleSeat), EconomySeat(40, 'H', MiddleSeat), EconomySeat(40, 'J', WindowSeat)
      )
  }

  case object B747 extends AircraftModel with WideBodyJet {
    val seatAssignments = Map.empty
    val FirstClassSeats = Vector(
        FirstClassSeat(1, 'A', WindowSeat), FirstClassSeat(1, 'D', AisleSeat),
        FirstClassSeat(2, 'A', WindowSeat), FirstClassSeat(2, 'D', AisleSeat),
        FirstClassSeat(3, 'A', WindowSeat), FirstClassSeat(3, 'D', AisleSeat),
        FirstClassSeat(4, 'A', WindowSeat), FirstClassSeat(4, 'D', AisleSeat),
        FirstClassSeat(5, 'A', WindowSeat), FirstClassSeat(5, 'D', AisleSeat)
      )
    val BusinessClassSeats = Vector(
        BusinessClassSeat(6, 'A', WindowSeat), BusinessClassSeat(6, 'B', MiddleSeat), BusinessClassSeat(6, 'C', AisleSeat), BusinessClassSeat(6, 'D', AisleSeat),
        BusinessClassSeat(7, 'A', WindowSeat), BusinessClassSeat(7, 'B', MiddleSeat), BusinessClassSeat(7, 'C', AisleSeat), BusinessClassSeat(7, 'D', AisleSeat),
        BusinessClassSeat(8, 'A', WindowSeat), BusinessClassSeat(8, 'B', MiddleSeat), BusinessClassSeat(8, 'C', AisleSeat), BusinessClassSeat(8, 'D', AisleSeat),
        BusinessClassSeat(9, 'A', WindowSeat), BusinessClassSeat(9, 'B', MiddleSeat), BusinessClassSeat(9, 'C', AisleSeat), BusinessClassSeat(9, 'D', AisleSeat),
        BusinessClassSeat(10, 'A', WindowSeat), BusinessClassSeat(10, 'B', MiddleSeat), BusinessClassSeat(10, 'C', AisleSeat), BusinessClassSeat(10, 'D', AisleSeat)
      )
    val EconomyPlusSeats = Vector(
        EconomyPlusSeat(6, 'A', WindowSeat), EconomyPlusSeat(6, 'B', MiddleSeat), EconomyPlusSeat(6, 'C', AisleSeat),
        EconomyPlusSeat(6, 'D', AisleSeat), EconomyPlusSeat(6, 'E', MiddleSeat), EconomyPlusSeat(6, 'F', AisleSeat),
        EconomyPlusSeat(6, 'G', AisleSeat), EconomyPlusSeat(6, 'H', MiddleSeat), EconomyPlusSeat(6, 'J', WindowSeat),
        EconomyPlusSeat(7, 'A', WindowSeat), EconomyPlusSeat(7, 'B', MiddleSeat), EconomyPlusSeat(7, 'C', AisleSeat),
        EconomyPlusSeat(7, 'D', AisleSeat), EconomyPlusSeat(7, 'E', MiddleSeat), EconomyPlusSeat(7, 'F', AisleSeat),
        EconomyPlusSeat(7, 'G', AisleSeat), EconomyPlusSeat(7, 'H', MiddleSeat), EconomyPlusSeat(7, 'J', WindowSeat),
        EconomyPlusSeat(8, 'A', WindowSeat), EconomyPlusSeat(8, 'B', MiddleSeat), EconomyPlusSeat(8, 'C', AisleSeat),
        EconomyPlusSeat(8, 'D', AisleSeat), EconomyPlusSeat(8, 'E', MiddleSeat), EconomyPlusSeat(8, 'F', AisleSeat),
        EconomyPlusSeat(8, 'G', AisleSeat), EconomyPlusSeat(8, 'H', MiddleSeat), EconomyPlusSeat(8, 'J', WindowSeat),
        EconomyPlusSeat(9, 'A', WindowSeat), EconomyPlusSeat(9, 'B', MiddleSeat), EconomyPlusSeat(9, 'C', AisleSeat),
        EconomyPlusSeat(9, 'D', AisleSeat), EconomyPlusSeat(9, 'E', MiddleSeat), EconomyPlusSeat(9, 'F', AisleSeat),
        EconomyPlusSeat(9, 'G', AisleSeat), EconomyPlusSeat(9, 'H', MiddleSeat), EconomyPlusSeat(9, 'J', WindowSeat),
        EconomyPlusSeat(10, 'A', WindowSeat), EconomyPlusSeat(10, 'B', MiddleSeat), EconomyPlusSeat(10, 'C', AisleSeat),
        EconomyPlusSeat(10, 'D', AisleSeat), EconomyPlusSeat(10, 'E', MiddleSeat), EconomyPlusSeat(10, 'F', AisleSeat),
        EconomyPlusSeat(10, 'G', AisleSeat), EconomyPlusSeat(10, 'H', MiddleSeat), EconomyPlusSeat(10, 'J', WindowSeat),
        EconomyPlusSeat(11, 'A', WindowSeat), EconomyPlusSeat(11, 'B', MiddleSeat), EconomyPlusSeat(11, 'C', AisleSeat),
        EconomyPlusSeat(11, 'D', AisleSeat), EconomyPlusSeat(11, 'E', MiddleSeat), EconomyPlusSeat(11, 'F', AisleSeat),
        EconomyPlusSeat(11, 'G', AisleSeat), EconomyPlusSeat(11, 'H', MiddleSeat), EconomyPlusSeat(11, 'J', WindowSeat),
        EconomyPlusSeat(12, 'A', WindowSeat), EconomyPlusSeat(12, 'B', MiddleSeat), EconomyPlusSeat(12, 'C', AisleSeat),
        EconomyPlusSeat(12, 'D', AisleSeat), EconomyPlusSeat(12, 'E', MiddleSeat), EconomyPlusSeat(12, 'F', AisleSeat),
        EconomyPlusSeat(12, 'G', AisleSeat), EconomyPlusSeat(12, 'H', MiddleSeat), EconomyPlusSeat(12, 'J', WindowSeat),
        EconomyPlusSeat(13, 'A', WindowSeat), EconomyPlusSeat(13, 'B', MiddleSeat), EconomyPlusSeat(13, 'C', AisleSeat),
        EconomyPlusSeat(13, 'D', AisleSeat), EconomyPlusSeat(13, 'E', MiddleSeat), EconomyPlusSeat(13, 'F', AisleSeat),
        EconomyPlusSeat(13, 'G', AisleSeat), EconomyPlusSeat(13, 'H', MiddleSeat), EconomyPlusSeat(13, 'J', WindowSeat),
        EconomyPlusSeat(14, 'A', WindowSeat), EconomyPlusSeat(14, 'B', MiddleSeat), EconomyPlusSeat(14, 'C', AisleSeat),
        EconomyPlusSeat(14, 'D', AisleSeat), EconomyPlusSeat(14, 'E', MiddleSeat), EconomyPlusSeat(14, 'F', AisleSeat),
        EconomyPlusSeat(14, 'G', AisleSeat), EconomyPlusSeat(14, 'H', MiddleSeat), EconomyPlusSeat(14, 'J', WindowSeat),
        EconomyPlusSeat(15, 'A', WindowSeat), EconomyPlusSeat(15, 'B', MiddleSeat), EconomyPlusSeat(15, 'C', AisleSeat),
        EconomyPlusSeat(15, 'D', AisleSeat), EconomyPlusSeat(15, 'E', MiddleSeat), EconomyPlusSeat(15, 'F', AisleSeat),
        EconomyPlusSeat(15, 'G', AisleSeat), EconomyPlusSeat(15, 'H', MiddleSeat), EconomyPlusSeat(15, 'J', WindowSeat),
        EconomyPlusSeat(16, 'A', WindowSeat), EconomyPlusSeat(16, 'B', MiddleSeat), EconomyPlusSeat(16, 'C', AisleSeat),
        EconomyPlusSeat(16, 'D', AisleSeat), EconomyPlusSeat(16, 'E', MiddleSeat), EconomyPlusSeat(16, 'F', AisleSeat),
        EconomyPlusSeat(16, 'G', AisleSeat), EconomyPlusSeat(16, 'H', MiddleSeat), EconomyPlusSeat(16, 'J', WindowSeat),
        EconomyPlusSeat(20, 'A', WindowSeat), EconomyPlusSeat(20, 'B', MiddleSeat), EconomyPlusSeat(20, 'C', AisleSeat),
        EconomyPlusSeat(20, 'D', AisleSeat), EconomyPlusSeat(20, 'E', MiddleSeat), EconomyPlusSeat(20, 'F', AisleSeat),
        EconomyPlusSeat(20, 'G', AisleSeat), EconomyPlusSeat(20, 'H', MiddleSeat), EconomyPlusSeat(20, 'J', WindowSeat),
        EconomyPlusSeat(21, 'A', WindowSeat), EconomyPlusSeat(21, 'B', MiddleSeat), EconomyPlusSeat(21, 'C', AisleSeat),
        EconomyPlusSeat(21, 'D', AisleSeat), EconomyPlusSeat(21, 'E', MiddleSeat), EconomyPlusSeat(21, 'F', AisleSeat),
        EconomyPlusSeat(21, 'G', AisleSeat), EconomyPlusSeat(21, 'H', MiddleSeat), EconomyPlusSeat(21, 'J', WindowSeat),
        EconomyPlusSeat(22, 'A', WindowSeat), EconomyPlusSeat(22, 'B', MiddleSeat), EconomyPlusSeat(22, 'C', AisleSeat),
        EconomyPlusSeat(22, 'D', AisleSeat), EconomyPlusSeat(22, 'E', MiddleSeat), EconomyPlusSeat(22, 'F', AisleSeat),
        EconomyPlusSeat(22, 'G', AisleSeat), EconomyPlusSeat(22, 'H', MiddleSeat), EconomyPlusSeat(22, 'J', WindowSeat)
      )
    val EconomySeats -> Vector(
        EconomySeat(17, 'A', WindowSeat), EconomySeat(17, 'B', MiddleSeat), EconomySeat(17, 'C', AisleSeat),
        EconomySeat(17, 'D', AisleSeat), EconomySeat(17, 'E', MiddleSeat), EconomySeat(17, 'F', AisleSeat),
        EconomySeat(17, 'G', AisleSeat), EconomySeat(17, 'H', MiddleSeat), EconomySeat(17, 'J', WindowSeat),
        EconomySeat(18, 'A', WindowSeat), EconomySeat(18, 'B', MiddleSeat), EconomySeat(18, 'C', AisleSeat),
        EconomySeat(18, 'D', AisleSeat), EconomySeat(18, 'E', MiddleSeat), EconomySeat(18, 'F', AisleSeat),
        EconomySeat(18, 'G', AisleSeat), EconomySeat(18, 'H', MiddleSeat), EconomySeat(18, 'J', WindowSeat),
        EconomySeat(19, 'A', WindowSeat), EconomySeat(19, 'B', MiddleSeat), EconomySeat(19, 'C', AisleSeat),
        EconomySeat(19, 'D', AisleSeat), EconomySeat(19, 'E', MiddleSeat), EconomySeat(19, 'F', AisleSeat),
        EconomySeat(19, 'G', AisleSeat), EconomySeat(19, 'H', MiddleSeat), EconomySeat(19, 'J', WindowSeat),
        EconomySeat(23, 'A', WindowSeat), EconomySeat(23, 'B', MiddleSeat), EconomySeat(23, 'C', AisleSeat),
        EconomySeat(23, 'D', AisleSeat), EconomySeat(23, 'E', MiddleSeat), EconomySeat(23, 'F', AisleSeat),
        EconomySeat(23, 'G', AisleSeat), EconomySeat(23, 'H', MiddleSeat), EconomySeat(23, 'J', WindowSeat),
        EconomySeat(24, 'A', WindowSeat), EconomySeat(24, 'B', MiddleSeat), EconomySeat(24, 'C', AisleSeat),
        EconomySeat(24, 'D', AisleSeat), EconomySeat(24, 'E', MiddleSeat), EconomySeat(24, 'F', AisleSeat),
        EconomySeat(24, 'G', AisleSeat), EconomySeat(24, 'H', MiddleSeat), EconomySeat(24, 'J', WindowSeat),
        EconomySeat(25, 'A', WindowSeat), EconomySeat(25, 'B', MiddleSeat), EconomySeat(25, 'C', AisleSeat),
        EconomySeat(25, 'D', AisleSeat), EconomySeat(25, 'E', MiddleSeat), EconomySeat(25, 'F', AisleSeat),
        EconomySeat(25, 'G', AisleSeat), EconomySeat(25, 'H', MiddleSeat), EconomySeat(25, 'J', WindowSeat),
        EconomySeat(26, 'A', WindowSeat), EconomySeat(26, 'B', MiddleSeat), EconomySeat(26, 'C', AisleSeat),
        EconomySeat(26, 'D', AisleSeat), EconomySeat(26, 'E', MiddleSeat), EconomySeat(26, 'F', AisleSeat),
        EconomySeat(26, 'G', AisleSeat), EconomySeat(26, 'H', MiddleSeat), EconomySeat(26, 'J', WindowSeat),
        EconomySeat(27, 'A', WindowSeat), EconomySeat(27, 'B', MiddleSeat), EconomySeat(27, 'C', AisleSeat),
        EconomySeat(27, 'D', AisleSeat), EconomySeat(27, 'E', MiddleSeat), EconomySeat(27, 'F', AisleSeat),
        EconomySeat(27, 'G', AisleSeat), EconomySeat(27, 'H', MiddleSeat), EconomySeat(27, 'J', WindowSeat),
        EconomySeat(28, 'A', WindowSeat), EconomySeat(28, 'B', MiddleSeat), EconomySeat(28, 'C', AisleSeat),
        EconomySeat(28, 'D', AisleSeat), EconomySeat(28, 'E', MiddleSeat), EconomySeat(28, 'F', AisleSeat),
        EconomySeat(28, 'G', AisleSeat), EconomySeat(28, 'H', MiddleSeat), EconomySeat(28, 'J', WindowSeat),
        EconomySeat(29, 'A', WindowSeat), EconomySeat(29, 'B', MiddleSeat), EconomySeat(29, 'C', AisleSeat),
        EconomySeat(29, 'D', AisleSeat), EconomySeat(29, 'E', MiddleSeat), EconomySeat(29, 'F', AisleSeat),
        EconomySeat(29, 'G', AisleSeat), EconomySeat(29, 'H', MiddleSeat), EconomySeat(29, 'J', WindowSeat),
        EconomySeat(30, 'A', WindowSeat), EconomySeat(30, 'B', MiddleSeat), EconomySeat(30, 'C', AisleSeat),
        EconomySeat(30, 'D', AisleSeat), EconomySeat(30, 'E', MiddleSeat), EconomySeat(30, 'F', AisleSeat),
        EconomySeat(30, 'G', AisleSeat), EconomySeat(30, 'H', MiddleSeat), EconomySeat(30, 'J', WindowSeat),
        EconomySeat(31, 'A', WindowSeat), EconomySeat(31, 'B', MiddleSeat), EconomySeat(31, 'C', AisleSeat),
        EconomySeat(31, 'D', AisleSeat), EconomySeat(31, 'E', MiddleSeat), EconomySeat(31, 'F', AisleSeat),
        EconomySeat(31, 'G', AisleSeat), EconomySeat(31, 'H', MiddleSeat), EconomySeat(31, 'J', WindowSeat),
        EconomySeat(32, 'A', WindowSeat), EconomySeat(32, 'B', MiddleSeat), EconomySeat(32, 'C', AisleSeat),
        EconomySeat(32, 'D', AisleSeat), EconomySeat(32, 'E', MiddleSeat), EconomySeat(32, 'F', AisleSeat),
        EconomySeat(32, 'G', AisleSeat), EconomySeat(32, 'H', MiddleSeat), EconomySeat(32, 'J', WindowSeat),
        EconomySeat(33, 'A', WindowSeat), EconomySeat(33, 'B', MiddleSeat), EconomySeat(33, 'C', AisleSeat),
        EconomySeat(33, 'D', AisleSeat), EconomySeat(33, 'E', MiddleSeat), EconomySeat(33, 'F', AisleSeat),
        EconomySeat(33, 'G', AisleSeat), EconomySeat(33, 'H', MiddleSeat), EconomySeat(33, 'J', WindowSeat),
        EconomySeat(34, 'A', WindowSeat), EconomySeat(34, 'B', MiddleSeat), EconomySeat(34, 'C', AisleSeat),
        EconomySeat(34, 'D', AisleSeat), EconomySeat(34, 'E', MiddleSeat), EconomySeat(34, 'F', AisleSeat),
        EconomySeat(34, 'G', AisleSeat), EconomySeat(34, 'H', MiddleSeat), EconomySeat(34, 'J', WindowSeat),
        EconomySeat(35, 'A', WindowSeat), EconomySeat(35, 'B', MiddleSeat), EconomySeat(35, 'C', AisleSeat),
        EconomySeat(35, 'D', AisleSeat), EconomySeat(35, 'E', MiddleSeat), EconomySeat(35, 'F', AisleSeat),
        EconomySeat(35, 'G', AisleSeat), EconomySeat(35, 'H', MiddleSeat), EconomySeat(35, 'J', WindowSeat),
        EconomySeat(36, 'A', WindowSeat), EconomySeat(36, 'B', MiddleSeat), EconomySeat(36, 'C', AisleSeat),
        EconomySeat(36, 'D', AisleSeat), EconomySeat(36, 'E', MiddleSeat), EconomySeat(36, 'F', AisleSeat),
        EconomySeat(36, 'G', AisleSeat), EconomySeat(36, 'H', MiddleSeat), EconomySeat(36, 'J', WindowSeat),
        EconomySeat(37, 'A', WindowSeat), EconomySeat(37, 'B', MiddleSeat), EconomySeat(37, 'C', AisleSeat),
        EconomySeat(37, 'D', AisleSeat), EconomySeat(37, 'E', MiddleSeat), EconomySeat(37, 'F', AisleSeat),
        EconomySeat(37, 'G', AisleSeat), EconomySeat(37, 'H', MiddleSeat), EconomySeat(37, 'J', WindowSeat),
        EconomySeat(38, 'A', WindowSeat), EconomySeat(38, 'B', MiddleSeat), EconomySeat(38, 'C', AisleSeat),
        EconomySeat(38, 'D', AisleSeat), EconomySeat(38, 'E', MiddleSeat), EconomySeat(38, 'F', AisleSeat),
        EconomySeat(38, 'G', AisleSeat), EconomySeat(38, 'H', MiddleSeat), EconomySeat(38, 'J', WindowSeat),
        EconomySeat(39, 'A', WindowSeat), EconomySeat(39, 'B', MiddleSeat), EconomySeat(39, 'C', AisleSeat),
        EconomySeat(39, 'D', AisleSeat), EconomySeat(39, 'E', MiddleSeat), EconomySeat(39, 'F', AisleSeat),
        EconomySeat(39, 'G', AisleSeat), EconomySeat(39, 'H', MiddleSeat), EconomySeat(39, 'J', WindowSeat),
        EconomySeat(40, 'A', WindowSeat), EconomySeat(40, 'B', MiddleSeat), EconomySeat(40, 'C', AisleSeat),
        EconomySeat(40, 'D', AisleSeat), EconomySeat(40, 'E', MiddleSeat), EconomySeat(40, 'F', AisleSeat),
        EconomySeat(40, 'G', AisleSeat), EconomySeat(40, 'H', MiddleSeat), EconomySeat(40, 'J', WindowSeat)
      )
  }

  // TODO - some of our tests with time comparisons may race based on daylight savings...

  val SFOToEWRDeparture = new DateTime(2018, 6, 12, 10, 49, DateTimeZone.forID("US/Pacific"))

  val EWRFromSFOArrival = new DateTime(2018, 6, 12, 19, 29, DateTimeZone.forID("US/Eastern"))

  val EWRToLHRDeparture = new DateTime(2018, 6, 12, 21, 49, DateTimeZone.forID("US/Eastern"))

  val LHRFromEWRArrival = new DateTime(2018, 6, 13, 10, 19, DateTimeZone.forID("Europe/London"))

  val LHRToEWRDeparture = new DateTime(2018, 6, 21, 8, 40, DateTimeZone.forID("Europe/London"))

  val EWRFromLHRArrival = new DateTime(2018, 6, 21, 11, 45, DateTimeZone.forID("US/Eastern"))

  val EWRToSFODeparture = new DateTime(2018, 6, 21, 14, 15, DateTimeZone.forID("US/Eastern"))

  val SFOFromEWRArrival = new DateTime(2018, 6, 21, 17, 27, DateTimeZone.forID("US/Pacific"))

  val SFO = AirportCode("SFO")

  val EWR = AirportCode("EWR")

  val LHR = AirportCode("LHR")

  def SFToNewarkSchedule = Schedule(
    FlightLeg(SFO, SFOToEWRDeparture),
    FlightLeg(EWR, EWRFromSFOArrival)
  )

  def NewarkToLondonSchedule = Schedule(
    FlightLeg(EWR, EWRToLHRDeparture),
    FlightLeg(LHR, LHRFromEWRArrival)
  )

  def LondonToNewarkSchedule = Schedule(
    FlightLeg(LHR, LHRToEWRDeparture),
    FlightLeg(EWR, EWRFromLHRArrival)
  )

  def NewarkToSFSchedule = Schedule(
    FlightLeg(EWR, EWRToSFODeparture),
    FlightLeg(SFO, SFOFromEWRArrival)
  )

  implicit val moneyContext = defaultMoneyContext
  implicit val moneyNum = new MoneyNumeric()

  def SFOToEWRFlight =
    new Flight(
      FlightNumber("UA", 1683),
      Aircraft(B747),
      SFToNewarkSchedule,
      USD(256.15),
      NauticalMiles(2565)
    )

  val SFToNewarkItinerary = ProposedItinerary(
    Seq(
      SFOToEWRFlight
    )
  )
  
  def EWRToLHRFlight =
    new Flight(
      FlightNumber("UA", 940),
      Aircraft(B747),
      NewarkToLondonSchedule,
      USD(1419),
      NauticalMiles(5199)
    )

  val NewarkToLondonItinerary = ProposedItinerary(
    Seq(
      EWRToLHRFlight
    )
  )

  val SFToLondonItinerary = ProposedItinerary(
    Seq(
      SFOToEWRFlight,
      EWRToLHRFlight
    )
  )

  def LHRToEWRFlight =
    new Flight(
      FlightNumber("UA", 923),
      Aircraft(B747),
      LondonToNewarkSchedule,
      USD(1738),
      NauticalMiles(5199)
    )

  val LondonToNewarkItinerary = ProposedItinerary(
    Seq(
      LHRToEWRFlight
    )
  )


  def EWRToSFOFlight =
    new Flight(
      FlightNumber("UA", 1978),
      Aircraft(B747),
      NewarkToSFSchedule,
      USD(382.26),
      NauticalMiles(2565)
    )

  val NewarkToSFItinerary = ProposedItinerary(
    Seq(
      EWRToSFOFlight
    )
  )

  val LondonToSFItinerary = ProposedItinerary(
    Seq(
      LHRToEWRFlight,
      EWRToSFOFlight
    )
  )

  // todo ++ for Itineraries
  val SFToLondonRoundTripItinerary = ProposedItinerary(
    Seq(
      SFOToEWRFlight,
      EWRToLHRFlight,
      LHRToEWRFlight,
      EWRToSFOFlight
    )
  )

}
