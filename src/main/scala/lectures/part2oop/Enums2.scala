package lectures.part2oop

object Enums2 extends App {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields / methods
    def openDocument():Unit =
      if (this == READ) println("opening document...")
      else println("reading not allowed.")
  }

  val somePermissions: Permissions = Permissions.READ

  // constructor args
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) // 001
    case NONE extends PermissionsWithBits(0) // 000
  }

  // Standard API
  val somePermissionsOrdinal = somePermissions.ordinal
  println(somePermissionsOrdinal)

  val allPermissions = Permissions.values.toList
  println(allPermissions)

  val readPermission: Permissions = Permissions.valueOf("READ")
  

}
