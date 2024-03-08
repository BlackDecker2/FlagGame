import com.example.flaggame.QuestionDepartamentos
import com.example.flaggame.R
import java.util.Random

object ConstantsDepartamentos {

    private val departamentos = listOf(
        "Amazonas", "Antioquia", "Arauca", "Atlántico", "Bolívar","Boyacá", "Caldas", "Caquetá", "Casanare", "Cauca",
        "Cesar", "Chocó", "Córdoba", "Cundinamarca", "Guainía", "Guaviare", "Huila", "La Guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Putumayo",
        "Quindío", "Risaralda", "San Andrés y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Vaupés", "Vichada"
    )




    fun getQuestionDepartamento(): ArrayList<QuestionDepartamentos> {
        val listaDePreguntas = ArrayList<QuestionDepartamentos>()


        val random = Random()



        for (i in 1..10) { // Generar 10 preguntas, puedes ajustar este número según sea necesario
            val respuestaCorrecta = departamentos.random() // Elegir una respuesta correcta aleatoria de entre todos los países
            val opciones = mutableListOf<String>() // Inicializar una lista mutable de opciones

            // Agregar la respuesta correcta a la lista de opciones
            opciones.add(respuestaCorrecta)

            // Obtener tres opciones aleatorias distintas para completar las cuatro opciones
            while (opciones.size < 3) {
                val opcionAleatoria = departamentos.random()
                if (opcionAleatoria != respuestaCorrecta && !opciones.contains(opcionAleatoria)) {
                    opciones.add(opcionAleatoria)
                }
            }

            // Mezclar aleatoriamente las opciones para que no estén en un orden predecible
            opciones.shuffle()

            val pregunta = QuestionDepartamentos(
                id = i,
                question = "¿Cuál es el Departamento de esta bandera?",
                image = obtenerRecursoDeBandera(respuestaCorrecta), // Aquí necesitas implementar la función obtenerRecursoDeBandera
                optionOne = opciones[0],
                optionTwo = opciones[1],
                optionThree = opciones[2],
                correctAnswer = opciones.indexOf(respuestaCorrecta) + 1 // Obtener el índice de la respuesta correcta
            )
            listaDePreguntas.add(pregunta)
        }








        return listaDePreguntas
    }

    private fun obtenerOpcionesAleatorias(): List<String> {
        val todasLasOpciones = departamentos.shuffled()
        return todasLasOpciones.take(3)
    }

    private fun obtenerRecursoDeBandera(nombreDelDepartamento: String): Int {
        return when (nombreDelDepartamento) {
            "Amazonas" -> R.drawable.amazonas
            "Antioquia" -> R.drawable.antioquia
            "Arauca" -> R.drawable.arauca
            "Atlántico" -> R.drawable.atlantico
            "Bolívar" -> R.drawable.bolivar
            "Boyacá" -> R.drawable.boyaca
            "Caldas" -> R.drawable.caldas
            "Caquetá" -> R.drawable.caqueta
            "Casanare" -> R.drawable.casanare
            "Cauca" -> R.drawable.cauca
            "Cesar" -> R.drawable.cesar
            "Chocó" -> R.drawable.choco
            "Córdoba" -> R.drawable.cordoba
            "Cundinamarca" -> R.drawable.cundinamarca
            "Guainía" -> R.drawable.guainia
            "Guaviare" -> R.drawable.guaviare
            "Huila" -> R.drawable.huila
            "La Guajira" -> R.drawable.guajira
            "Magdalena" -> R.drawable.magdalena
            "Meta" -> R.drawable.meta
            "Nariño" -> R.drawable.narino
            "Norte de Santander" -> R.drawable.norte_santander
            "Putumayo" -> R.drawable.putumayo
            "Quindío" -> R.drawable.quindio
            "Risaralda" -> R.drawable.risaralda
            "San Andrés y Providencia" -> R.drawable.san_andres
            "Santander" -> R.drawable.santander
            "Sucre" -> R.drawable.sucre
            "Tolima" -> R.drawable.tolima
            "Valle del Cauca" -> R.drawable.valle
            "Vaupés" -> R.drawable.vaupes
            "Vichada" -> R.drawable.vichada
            else -> throw IllegalArgumentException("Departamento no encontrado: $nombreDelDepartamento")
        }
    }



}
