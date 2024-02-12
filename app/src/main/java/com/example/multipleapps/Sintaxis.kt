package com.example.multipleapps

fun main() {
    // todo operadores Condicionales
    // mayor que= (>)
    // menor que= (<)
    // menor o igual que= (<=)
    // mayor o igual que= (>=)
    // igualdad= (==)
    // desigialdad= (!=)

    // todo Operadores Logicos
    // && "y"
    // !! "o"
    // ! "no


//todo Lecciones:
    //leccion 1
    //variablesYConstantes()

    //Leccion 2
    //tiposDeDatos()

    //Leccion 3
    //sentenciaIf()

    //Leccion 4
    //funciones()


}


private fun variablesYConstantes() {
    //Variables
    var myFirstVariable = "Hola Ricardo"
    println(myFirstVariable)

    myFirstVariable = "bienvenido nuevamente"
    println(myFirstVariable)

//no podemos asignar un tipo int a una variable tipo string
    //  myFirstVariable = 1

    var mySecondVariable = "Suscribete"
    println(mySecondVariable)

    mySecondVariable = myFirstVariable
    println(mySecondVariable)

    myFirstVariable = "ya queda menos para lograr ser programador"
    println(myFirstVariable)

    //Constantes
    val myFirstConstant = "te a gustado esta sintaxis"
    println(myFirstConstant)
//una constante no puede modificar su valor
    // myFirstConstant = "se podra camniar esta constante"

    val mySecondConstant = myFirstVariable
    println(mySecondConstant)


}

private fun tiposDeDatos() {
    // String
    val myString = "Hola Ricardo!"  //cualquier string o cadena de texto deve ir entre comillas
    val myString2 = "Bienvenido a este curso"
    val myString3 = myString + " " + myString2
    println(myString3)

    // Enteros (Byte, Short, Int, Long)
    val myInt = 1
    val myInt2 = 2
    val myInt3 = myInt + myInt2
    println(myInt3)

    //Decimales (Float, Double)
    val myDouble = 1.5
    val myDouble2 = 1.5
    val myDouble3 = 1
    val myDouble4 = myDouble + myDouble2 + myDouble3
    println(myDouble4)

    //Boolean     es para validar solo 2 condiciones, verdadero o falso
    val myBool = true
    val myBool2 = false
    //val myBool3 = myBool + myBool2   esto no se puede hacer cuando son booleanos.
    println(myBool == myBool2)
    println(myBool && myBool2)

}

private fun sentenciaIf(){
    val myNumber = 9

    if (myNumber <= 10) {

        println("$myNumber es menor o igual que 10")
    }else{
        println("$myNumber es mayor que 10")
    }
}

private fun funciones(){

}




