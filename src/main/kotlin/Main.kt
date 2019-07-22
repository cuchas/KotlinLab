import java.io.File
import java.lang.StringBuilder

//main com args
//fun main(args: Array<String>) {
fun main() {
//    print(globalProp)
//
//    println()
//
//    val phone = "976396169"
//    print(phone.prefixo())

//    val numberList = listOf(1,2,3,4,5)
//    print(numberList.addSeparators(separator = ".", sufix = " e feshow"))

//    filtroComFuncaoAltaOrdem()
//
//    val rect = Retangulo(300, 200)
//
//    println(SimpleColor.valueOf("BLUE"))
//
//    println(Color.ORANGE.rgb())
//
//    val set = setOf(Color.BLUE, Color.BLUEISH)
//
//    val set2 = setOf(Color.BLUEISH, Color.BLUE)
//
//    println(set == set2)
//
//    println(set)
//
//    println(mixOtimo(Color.ORANGE, Color.RED))
//
//    println(mixOtimo(Color.BLUE, Color.RED))
//
//    loops()

//    collectionCheck()

//    excecoes()

//    colecoes()

//    val view = View()
//    view.click()
//    view.print()
//
//    val button = Button()
//    button.click()
//    button.print()
//
//    val view2: View = Button()
//    view2.print()
//
//    println("Cucharro".lastChar)
//    val builder = StringBuilder("Cucharro")
//    builder.lastChar = 'a'
//    println(builder)
//
//    someFun(arrayOf("a", "b", "c"))

//    splittingRight()
//    splittingFilePath()
//    splittingDestructured()
//    multilinhasAspasTriplas()
//    splittingDestructuredBonitao()

//    val user = UserModern(1, "cucharro", "rua ibitirama")
//    save(user)
//
//    RegistraGemalto().run()
//
//    val vitu = Vitu("123123")
//    println(vitu.nickname)
//
//    val someGuy = SomeGuy()
//    someGuy.email = "Eduardo"
//
//    println(someGuy.email)

    val c1 = Client("eduardo", 3133200)
    println(c1)
    val c2 = Client("eduardo", 3133200)
    println(c1 == c2)
    println(c1 === c2)

    val set = hashSetOf(c1)
    println(set.contains(c2))

    val c3 = Client2("eduardo", 3133200)
    println(c3)
    val c4 = Client2("eduardo", 3133200)
    println(c3 == c4)
    println(c3 === c4)
    val set2 = hashSetOf(c3)
    println(set2.contains(c4))

    val c5 = c4.copy(name = "andressa")
    println(c5)

    val f1 = File("/images")
    val f2 = File("/documents")

    println(FileComparator.compare(f1, f2))

    val files = listOf(f1, f2)
    println(files.sortedWith(FileComparator))
}