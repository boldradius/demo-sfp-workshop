package training.scala.air_scala.airline

import training.scala.air_scala.aircraft.{PreferredSeat, SeatingClass}

/**
 * Perfect core for future exercise regarding Abstract Types...
 * Passenger would have an abstract type Nationality, which would
 * need to be filled in on a concrete instance of Passenger
 *
 * Also, add "FrequentFlyer" info... maybe instead?
 */
case class Passenger[A <: SeatingClass](
  givenName: String,
  middleName: Option[String],
  familyName: String,
  seatPreference: PreferredSeat
)


