object AnimalFarm extends App {

  abstract class Animal {
    type SuitableFood <: Food

    def name: String

    def eat(food: SuitableFood): this.type = {
      println(s"[$name]: OM NOM NOM, eating ${food.getClass.getSimpleName}")
      this
    }
  }

  class Bird(val name: String) extends Animal {
    type SuitableFood = Grain
  }

  class Cow(val name: String) extends Animal {
    type SuitableFood = Grass
  }

  class Fish(val name: String) extends Animal with Food {
    type SuitableFood = Food {
      def swim(): Unit
    }

    def swim(): Unit = println("SWIM! SWIM! SWIM!")
  }

  class Duck(name: String) extends Bird(name) with Food {
    def swim(): Unit = println("Where's my bread, lazy humans?")
  }

  trait Food

  case class Grain() extends Food

  case class Grass() extends Food

  case class Steak() extends Food

  case class Rock()


  val bessie = new Cow("Bessie")
  val daffy = new Duck("Daffie")
  val bubba = new Fish("Bubba")
  val nemo = new Fish("Nemo")

  bessie.eat(Grass())
  daffy.eat(Grain())

  bubba.eat(nemo)
  nemo.eat(nemo)
  bubba.eat(daffy)

  bubba.eat(nemo).eat(daffy).eat(bubba)

  /*bessie.eat(Grain())
  daffy.eat(Rock())*/
}
