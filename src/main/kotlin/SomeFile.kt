@file:JvmName("SuperUtil")

import java.io.File
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.ArrayList

//package meu.pacote.diferente.doarquivo
//pacote padrao

//main sem args
// fun main() {}

var globalProp: String = "Cucharrex"

//prop imutavel
val CONSTANT_KOTLIN = "ConstanteKotlin"

const val CONSTANT_JAVA_STYLE = "JAVASTYLE"

fun filtroComFuncaoAltaOrdem() {
    val pessoas = listOf(Pessoa("Cleide", 65), Pessoa("Andressa", 37), Pessoa("Eduardo", 36), Pessoa("Saphira", 0))
    val maisVelha = pessoas.maxBy { it.idade ?: 0 }
    val maisNova = pessoas.minBy { it.idade ?: 0 }

    println("A pessoa mais velha é $maisVelha")
    println("A pessoa mais nova é $maisNova")

    val found = pessoas.find { findSaphira(it) }
    println("Pessoa encontrada foi $found")
}

fun findSaphira(pessoa: Pessoa): Boolean {
    return true
}

fun simpleLoop() {
    while (true) {
        println("oi")
        Thread.sleep(2000)
    }
}

fun inferenciaTipos() {
    println(max(max(10, 2), max(2, 10)))
    println(max2(20, 40))

    //inferencia de tipos
    val nome = "E um texto"
    val idade = 10
    val dinheiro = 10.2
    val bit = true

    println("nome é ${nome.javaClass.name}")
    println("idade é ${idade.javaClass.name}")
    println("dinheiro é ${dinheiro.javaClass.name}")
    println("bit é ${bit.javaClass.name}")

    val languages = arrayOf("Python", "Kotlin", "Java", "C#")
    println("languages é ${languages.javaClass.name}")

    println("Dinheiro maior que idade ${dinheiro > idade}")

    //println("args é ${args.javaClass.name}")

    val veiculo = Veiculo("Evarito", "Kwid")

    println(veiculo.print())

}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

//funcao com inferencia de tipo
fun max2(a: Int, b: Int) = if (a > b) a else b

//classe sem props
class Veiculo(val name: String, val model: String) {
    fun print() = "name = $name model = $model"
}

//Com hashCode, Destructuring e toString Padrão
data class Pessoa(val nome: String, val idade: Int? = null)

//Sem hashCode, Destructuring e toString Padrão, isMarried gerado
class Person(val name: String, var isMarried: Boolean)

//Sem hashCode, Destructuring e toString Padrão, getMarried gerado
class OtherPerson(val name: String, var married: Boolean)

class Retangulo(val altura: Int, val largura: Int) {
    val isQuadrado: Boolean
        get() {
            return altura == largura
        }

    val isSquare = altura == largura

    val isQuadradito: Boolean
        get() = altura == largura
}

enum class SimpleColor {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    BLUE(0, 0, 255),
    BLUEISH(0, 100, 255),
    PURPLE_RAIN(255, 0, 255);

    fun rgb() = (r * 256 * g) * 256 + b
}

fun getMnemonic(color: Color) = when (color) {
    Color.ORANGE -> "Laranja"
    Color.RED -> "Vermelhor"
    Color.BLUE, Color.BLUEISH -> "Azul"
    else -> throw Exception("Sei la que cor é essa")
}

//When com comparacao de conjuntos (when é uma expressao)
fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(Color.BLUE, Color.BLUEISH) -> "azulado"
    setOf(Color.PURPLE_RAIN, Color.BLUE) -> "muito azul"
    else -> "tanto faz"
}

fun mixOtimo(c1: Color, c2: Color) = when {
    c1 == c2 -> 1
    c2 == Color.BLUE -> "É azul mesmo"
    c1 == Color.ORANGE -> true
    else -> "indiferente"
}

fun loops() {
    val oneToThen = 1..10 //IntRange

    for (i in 1..10) print(fizzBuzz(i))

    println()

    for (i in 100 downTo 1 step 2) print(i) //decremental de tras pra frente pulando 2

    println()

    for (i in 0 until 100) print(i)

    println()

    for (i in 0..100 - 1) print(i)

    println()

    for (i in 0 until 100 step 2) print(i)

    println()

    //iterando com maps
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        binaryReps[c] = Integer.toBinaryString(c.toInt())
    }

    for ((letter, binary) in binaryReps) { //destructuring no laço
        println("$letter = $binary")
    }

    val list = arrayListOf("10", "11", "1001")

    for ((index, value) in list.withIndex()) {
        println("$index = $value")
    }
}

fun collectionCheck() {
    val list = listOf(1, 3, 4, 5, 7, 9)

    println("1 is in list ${1 in list}")

    println("2 is not in list ${2 !in list}")

    val x = 'A'..'Z' // CharRange

    val languages = "Java".."Scala" //ComparableRange

    println("k" in languages)

    println("Kotlin" in setOf("Java", "Scala"))
}

fun excecoes() {
    try {
        println(checkPercentage(1))
    } catch (e: Exception) {
        if (e is IllegalArgumentException) {
            println("Parametro zuado")
            return
        }
        println("deu ruim")
    }

    val number = try {
        Integer.parseInt("2")
    } catch (e: Exception) {
        2
    }

    println(number)
}

fun checkPercentage(number: Int) {
    //nao vai na assinatura
    //throw é uma expressao
    val percentage =
        if (number in 0..100) {
            number
            3 //atribui ultimo valor da expressao
        } else
            throw IllegalArgumentException("valor fora do range obrigatorio")
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun colecoes() {
    val set = hashSetOf(1, 2, 5)
    val list = arrayListOf(1, 7, 234)
    val map = hashMapOf(1 to "one", 2 to "two")

    println(list.last())
    println(list.min())
}

fun parametrosNomeadosComDefault() {
    funcaoComMuitosParametros(veiculo = Veiculo("x", "y"), person = Person("z", false))
}

@JvmOverloads
fun funcaoComMuitosParametros(
    pessoa: Pessoa? = null,
    person: Person,
    otherPerson: OtherPerson? = null,
    veiculo: Veiculo
) {
}

//Extension method
fun String.prefixo() = this.subSequence(0, 5)

@JvmOverloads
fun <T> Collection<T>.addSeparators(
    separator: String = ", ",
    prefix: String = "",
    sufix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(sufix)
    return result.toString()
}

open class View {
    open fun click() {
        println("A view foi clicada")
        println()
    }
}

class Button : View() {
    override fun click() {
        println("O botao foi clicado")
    }
}

fun View.print() = println("Sou uma view")

fun Button.print() = println("Sou um botao")

//extension property
val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) = this.setCharAt(length - 1, value)

//expansao de var args | passagem de parametro
fun someFun(args: Array<String>) {
    val list = listOf("args:", *args)
    println(list)
}

//infix function
fun useInfixFun() {
    val x = 1.to("one")
    val map = mapOf(1 to "one", 7 to "seven", 4 to "quatro")
    val m = 1 to "one"
    val y = 2 mapeiaPara "two"

}

infix fun Any.mapeiaPara(outro: Any) = Pair(this, outro)

//Helping java issues
fun splittingRight() {
    //var args
    val x = "1234.456.7".split(".")
    println(x.size)

    //igual java
    val y = "1234.456.7".split("\\.".toRegex())
    println(y)
    println(y.size)
}

fun splittingFilePath() {
    val file = "/users/images/zueira/zueirinha.jpg"
    val dir = file.substringBeforeLast("/")
    val fileName = file.substringAfterLast("/")
    val ext = file.substringAfterLast(".")

    println("dir: $dir\nfilename:$fileName\nextension: $ext")
}

fun splittingDestructured() {
    val file = "/users/images/zueira/zueirinha.jpg"
    //Sem scaping nos characteres
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val match = regex.matchEntire(file)
    match?.apply {
        val (dir, fileName, ext) = this.destructured
        println("dir: $dir\nfilename:$fileName\nextension: $ext")
    }
}

fun multilinhasAspasTriplas() {
    val kotlin = """
        .| //
        .|//
        .|/ \"""

    //inclui tudo, quebras de linhas, espacos, tabulacoes
    println(kotlin)
    //remove tudo até o delimitador
    println(kotlin.trimMargin("."))
}

fun splittingDestructuredBonitao() {
    val file = "/users/images/zueira/zueirinha.jpg"
    //Sem scaping nos characteres
    val regex = """(.+)/(.+)\.(.+)""".toRegex()

    val match = regex.matchEntire(file)
    match?.apply {
        val (dir, fileName, ext) = this.destructured
        println(
            """
        .dir: $dir
        .
        .filename:$fileName
        .
        .extension: $ext
        """.trimMargin(".")
        )
    }
}

//comparacao de valor e ref
class Client(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        return other is Client && other.name == name && other.postalCode == postalCode
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + postalCode
    }

    override fun toString(): String {
        return "Client $name $postalCode"
    }
}

//toString, equals, hashCode, copy
data class Client2(val name: String, val postalCode: Int)

//object declaracao e instancia ao mesmo tempo (singleton)
object FileComparator: Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, true)
    }
}

//decorator com delegation usando by
class DelegatingCollection<T>(
    innerList: Collection<T> = ArrayList()) : Collection<T> by innerList {
    override fun contains(element: T): Boolean {
        //meu custom comparator o resto é delegado para arraylist
        return true
    }
}

class UserOld(val id: Int, val name: String, val address: String) {
    fun save(user: UserOld) {
        if (user.name.isEmpty()) {
            throw IllegalArgumentException("user $user.id has empty Name")
        }

        if (user.address.isEmpty()) {
            throw IllegalArgumentException("user $user.id has empty address")
        }

        saveUser(UserOld(1, name, address))
    }

    private fun saveUser(user: UserOld) = Unit
}

class UserModern(val id: Int, var name: String, val address: String)

fun save(user: UserModern) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("user $user.id has empty $fieldName")
        }
    }

    fun saveUser(user: UserModern) = Unit

    validate(user.name, "name")
    validate(user.address, "address")

    saveUser(user)
}

interface UseCase {
    fun run()
    fun log() = println("use case log default")
}

interface ComplianceLog {
    //em java vc pode sobreescrever um método sem querer mesmo sem add
    //override, em kotlin override e obrigatorio
    fun log()
}

class RegistraGemalto : UseCase, ComplianceLog {
    override fun log() {
        super<UseCase>.log()
        super.log()
    }

    override fun run() {
        println("run executed")
    }
}

//final por padrao nas classes e metodos para abrir use open
//para fechar algo aberto use final
open class RegistraToken : UseCase, ComplianceLog {
    open override fun run() {
        println("registra remoto")
    }

    final override fun log() {
        super.log()
    }

}

class RegistraTokenLocal : RegistraToken() {
}

abstract class Tokenizator {
    abstract fun deveSerSobreescrito()
    fun porPadraoFechado() = Unit
    open fun podeSerAberto() = Unit
}

//public por padrao, internal para encapsular modulos, private e protected
//java permite hackear pacote criando uma classe por fora no mesmo pacote
// e com isso acessar código oculto, kotlin nao
//protected em java acessivel por membros do pacote, em kotlin so ele mesmo
// e subclasse

class OuterClassStatic {
    val name = "X"

    fun doSomething() = Unit

    class InnerClassStatic {
        fun doOther() {
            //mesmo q classe estatica sem acesso a outer
        }
    }
}

class OuterClass {
    val name = "X"

    fun doSomething() = Unit

    inner class InnerClass {
        fun doOther() {
            //essa tem acesso a outer
            val y = this@OuterClass.name
        }
    }
}

//So permite heranca de classes no mesmo arquivo
sealed class MySealed {
    fun doSomething() = Unit
}

class NewMySealed : MySealed() {
    fun go() = Unit
}

//construtor default
class Some(val name: String)

//construtor explicito com init
class OtherSome constructor(_name: String) {
    val name: String

    init {
        name = _name
    }

    constructor(_name: String, _surname: String) : this(_name)
}

//props na interface e init
interface PSUser {
    val nickname: String
}

class Maldonado(override val nickname: String) : PSUser
class Bolonha(val email: String) : PSUser {
    override val nickname: String
        get() = email.substringBefore("@")
}

class Vitu(val accountId: String) : PSUser {
    override val nickname: String = someVerySlowFun()
    fun someVerySlowFun(): String {
        return "Cody"
    }
}

interface SomeOtherUser {
    var email: String
    val nickname: String
        get() = email.substringBefore("@")
}

class SomeGuy : SomeOtherUser {
    var emailCounter: Int = 0
        private set

    override var email: String = "Some Maluco"
        set(value) {
            println("changing from $field to $value")
            field = value
            emailCounter = field.length
        }
}