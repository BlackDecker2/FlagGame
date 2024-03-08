import com.example.flaggame.QuestionEasy
import com.example.flaggame.R
import java.util.Random

object ConstantsEasy {

    private val todosLosPaises = listOf(
        "Afganistan", "Alemania", "Arabia Saudita",
        "Argelia", "Argentina", "Australia", "Austria", "Azerbaiyan", "Bahamas", "Banglades",
        "Barbados", "Barein", "Belgica", "Belice", "Benin", "Bielorrusia", "Birmania", "Bolivia",
        "Bosnia y Herzegovina", "Botsuana", "Brasil", "Bulgaria", "Burkina Faso",
         "Cabo Verde", "Camboya", "Camerun", "Canada", "Catar", "Chile", "China",
        "Chipre", "Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Ecuador", "Egipto",
        "El Salvador", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos",
         "Etiopia", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón", "Gambia", "Georgia",
         "Granada", "Grecia", "Guatemala", "Guyana", "Guinea", "Guinea Bisau", "Guinea Ecuatorial",
        "Haiti", "Honduras", "Hungria", "India", "Indonesia", "Irak", "Irlanda", "Islandia", "Islas Marshall",
        "Islas Salomon", "Israel", "Italia", "Jamaica", "Japon", "Jordania", "Kazajistan", "Kenia", "Kirguistan",
        "Kiribati", "Kuwait", "Laos", "Lesoto", "Libano", "Liberia", "Libia", "Liechtenstein",
        "Luxemburgo", "Malasia", "Malaui", "Maldivas", "Malta", "Marruecos", "Mauricio", "Mauritania",
        "Mexico", "Moldavia", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal",
        "Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda", "Oman", "Paises Bajos", "Pakistan", "Palaos", "Panama",
        "Papua Nueva Guinea", "Paraguay", "Peru", "Polonia", "Portugal", "Reino Unido", "Republica Centroafricana",
        "Republica Checa", "Republica del Congo",
        "Republica Dominicana",  "Ruanda", "Rumania", "Rusia", "Samoa", "San Cristobal y Nieves",
        "San Marino", "San Vicente y las Granadinas", "Santa Lucia", "Santo Tome y Principe", "Senegal", "Serbia",
        "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Suazilandia", "Sudan", "Sudan del Sur",
        "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikistan", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago",
        "Tunez", "Turkmenistan", "Turquia", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela",
        "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue","Isla Navidad","Isla Norfolk","Islas Caiman","Islas Cocos","Islas Feroe","Islas Virgenes","Islas Salomon","Islas Turcas", "Islas Cook"
    )



    fun getQuestionEasy(): ArrayList<QuestionEasy> {
        val listaDePreguntas = ArrayList<QuestionEasy>()


        val random = Random()



        for (i in 1..10) { // Generar 10 preguntas, puedes ajustar este número según sea necesario
            val respuestaCorrecta = todosLosPaises.random() // Elegir una respuesta correcta aleatoria de entre todos los países
            val opciones = mutableListOf<String>() // Inicializar una lista mutable de opciones

            // Agregar la respuesta correcta a la lista de opciones
            opciones.add(respuestaCorrecta)

            // Obtener tres opciones aleatorias distintas para completar las cuatro opciones
            while (opciones.size < 3) {
                val opcionAleatoria = todosLosPaises.random()
                if (opcionAleatoria != respuestaCorrecta && !opciones.contains(opcionAleatoria)) {
                    opciones.add(opcionAleatoria)
                }
            }

            // Mezclar aleatoriamente las opciones para que no estén en un orden predecible
            opciones.shuffle()

            val pregunta = QuestionEasy(
                id = i,
                question = "¿Cuál es el país de esta bandera?",
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
        val todasLasOpciones = todosLosPaises.shuffled()
        return todasLasOpciones.take(3)
    }

    private fun obtenerRecursoDeBandera(nombreDelPais: String): Int {
        return when (nombreDelPais) {
            "Australia" -> R.drawable.australia
            "Argentina" -> R.drawable.argentina
            "Nigeria" -> R.drawable.nigeria
            "Estados Unidos" -> R.drawable.usa
            "Mexico" -> R.drawable.mexico
            "Francia" -> R.drawable.france
            "Turquia" -> R.drawable.turquia
            "Reino Unido" -> R.drawable.reino_unido
            "Canada" -> R.drawable.canada
            "Alemania" -> R.drawable.alemania
            "Brasil" -> R.drawable.brasil
            "India" -> R.drawable.india
            "China" -> R.drawable.china
            "Rusia" -> R.drawable.rusia
            "Italia" -> R.drawable.italia
            "España" -> R.drawable.espania
            "Japon" -> R.drawable.japon
            "Corea del Sur" -> R.drawable.korea_sur
            "Sudafrica" -> R.drawable.sudafrica
            "Egipto" -> R.drawable.egipto
            "Afganistan" -> R.drawable.afganistan
            "Arabia Saudita" -> R.drawable.arabia_saudita
            "Argelia" -> R.drawable.argelia
            "Austria" -> R.drawable.austria
            "Azerbaiyan" -> R.drawable.azerbaiyan
            "Bangladés" -> R.drawable.banglades
            "Barbados" -> R.drawable.barbados
            "Barein" -> R.drawable.barein
            "Belgica" -> R.drawable.belgica
            "Belice" -> R.drawable.belice
            "Bielorrusia" -> R.drawable.bielorrusia
            "Birmania" -> R.drawable.birmania
            "Bolivia" -> R.drawable.bolivia
            "Boznia y Herzegovina" -> R.drawable.bosnia_herzegovina
            "Botsuana" -> R.drawable.botswana
            "Bulgaria" -> R.drawable.bulgaria
            "Burkina Faso" -> R.drawable.burkina_faso
            "Cabo Verde" -> R.drawable.cabo_verde
            "Camboya" -> R.drawable.camboya
            "Camerun" -> R.drawable.camerun
            "Catar" -> R.drawable.qatar
            "Chile" -> R.drawable.chile
            "Chipre" -> R.drawable.chipre
            "Ciudad Vaticano" -> R.drawable.vaticano
            "Colombia" -> R.drawable.colombia
            "Comoras" -> R.drawable.comoras
            "Corea del Norte" -> R.drawable.korea_norte
            "Costa Rica" -> R.drawable.costa_rica
            "Croacia" -> R.drawable.croacia
            "Cuba" -> R.drawable.cuba
            "Dinamarca" -> R.drawable.dinamarca
            "Dominicana" -> R.drawable.dominicana
            "Ecuador" -> R.drawable.ecuador
            "El Salvador" -> R.drawable.salvador
            "Eritrea" -> R.drawable.eritrea
            "Eslovaquia" -> R.drawable.eslovaquia
            "Eslovenia" -> R.drawable.eslovenia
            "Etiopia" -> R.drawable.etiopia
            "Filipinas" -> R.drawable.filipinas
            "Finlandia" -> R.drawable.finlandia
            "Fiyi" -> R.drawable.fiji
            "Gabon" -> R.drawable.gabon
            "Gambia" -> R.drawable.gambia
            "Georgia" -> R.drawable.georgia
            "Granada" -> R.drawable.granada
            "Grecia" -> R.drawable.grecia
            "Guatemala" -> R.drawable.guatemala
            "Guyana" -> R.drawable.guyana
            "Guinea" -> R.drawable.guinea
            "Guinea Bisau" -> R.drawable.guinea_bisau
            "Guinea Ecuatorial" -> R.drawable.guinea_ecuatorial
            "Haiti" -> R.drawable.haiti
            "Honduras" -> R.drawable.honduras
            "Hungria" -> R.drawable.hungria
            "Indonesia" -> R.drawable.indonesia
            "Irak" -> R.drawable.irak
            "Irlanda" -> R.drawable.irlanda
            "Islandia" -> R.drawable.islandia
            "Islas Marshall" -> R.drawable.islas_marshall
            "Isla Navidad" -> R.drawable.isla_navidad
            "Isla Norfolk" -> R.drawable.isla_norfolk
            "Islas Caiman" -> R.drawable.islas_caiman
            "Islas Cocos" -> R.drawable.islas_cocos
            "Islas Feroe" -> R.drawable.islas_feroe
            "Islas Virgenes" -> R.drawable.islas_virgenes
            "Islas Salomon" -> R.drawable.islas_salomon
            "Islas Turcas" -> R.drawable.islas_turcas
            "Islas Cook" -> R.drawable.islas_cook
            "Israel"-> R.drawable.israel
            "Jamica"-> R.drawable.jamaica
            "Japon"-> R.drawable.japon
            "Jordania"-> R.drawable.jordania
            "Kasajistan"-> R.drawable.kazajstan
            "Kenia"-> R.drawable.kenia
            "Kirguistan"-> R.drawable.kirguistan
            "Kiribati"-> R.drawable.kiribati
            "Kuwait"-> R.drawable.kuwait
            "Laos"-> R.drawable.laos
            "Lesoto"-> R.drawable.lesoto
            "Libano"-> R.drawable.libano
            "Liberia"-> R.drawable.liberia
            "Libia"-> R.drawable.libia
            "Liechtenstein"-> R.drawable.liechtenstein
            "Luxemburgo"-> R.drawable.luxemburgo
            "Malasia"-> R.drawable.malasya
            "Malaui"-> R.drawable.malaui
            "Maldivas"-> R.drawable.maldivas
            "Malta"-> R.drawable.malta
            "Marruecos"-> R.drawable.marrueco
            "Mauricio"-> R.drawable.mauricio
            "Mauritania"-> R.drawable.mauritania
            "Moldavia"-> R.drawable.moldovia
            "Mongolia"-> R.drawable.mongolia
            "Montenegro"-> R.drawable.montenegro
            "Mozambique"-> R.drawable.mozambique
            "Namibia"-> R.drawable.namibia
            "Nauru"-> R.drawable.nauru
            "Nepal"-> R.drawable.nepal
            "Nicaragua"-> R.drawable.nicaragua
            "Niger"-> R.drawable.niger
            "Noruega"-> R.drawable.noruega
            "Nueva Zelanda"-> R.drawable.nueva_zelanda
            "Oman"-> R.drawable.oman
            "Paises Bajos"-> R.drawable.paises_bajos
            "Pakistan"-> R.drawable.pakistan
            "Palaos"-> R.drawable.palaos
            "Panama"-> R.drawable.panama
            "Papua Nueva Guinea"-> R.drawable.papua_nueva_guinea
            "Paraguay"-> R.drawable.paraguay
            "Peru"-> R.drawable.peru
            "Polonia"-> R.drawable.polonia
            "Portugal"-> R.drawable.portugal
            "Republica Centroafricana"-> R.drawable.republica_centroafricana
            "Republica Checa"-> R.drawable.republica_checa
            "Republica Congo"-> R.drawable.congo
            "Republica Dominicana"-> R.drawable.republica_dominicana
            "Ruanda"-> R.drawable.ruanda
            "Rumania"-> R.drawable.rumania
            "Samoa"-> R.drawable.samoa
            "San Cristobal y Nieves"-> R.drawable.san_cristobal
            "San Marino"-> R.drawable.san_marino
            "Santa Lucia"-> R.drawable.santa_lucia
            "Santo Tome y Principe"-> R.drawable.santo_tome
            "Senegal"-> R.drawable.senegal
            "Serbia"-> R.drawable.serbia
            "Seychelles"-> R.drawable.seychelles
            "Sierra Leona"-> R.drawable.sierra_leona
            "Singapur"-> R.drawable.singapur
            "Siria"-> R.drawable.siria
            "Somalia"-> R.drawable.somalia
            "Suazilandia"-> R.drawable.suazilandia
            "Sudan"-> R.drawable.sudan
            "Sudan del Sur"-> R.drawable.sudan_sur
            "Suecia"-> R.drawable.suecia
            "Suiza"-> R.drawable.suiza
            "Surinam"-> R.drawable.surinam
            "Tailandia"-> R.drawable.tailandia
            "Tanzania"-> R.drawable.tanzania
            "Tayikistan"-> R.drawable.tayikistan
            "Timor Oriental"-> R.drawable.timor_oriental
            "Togo"-> R.drawable.togo
            "Tonga"-> R.drawable.tonga
            "Trinidad y Tobago"-> R.drawable.trinidad_tobago
            "Tunez"-> R.drawable.tunez
            "Turkmenistan"-> R.drawable.turkmenistan
            "Turquia"-> R.drawable.turquia
            "Tuvalu"-> R.drawable.tuvalu
            "Ucrania"-> R.drawable.ucrania
            "Uganda"-> R.drawable.uganda
            "Uruguay"-> R.drawable.uruguay
            "Uzbekistan"-> R.drawable.uzbekistan
            "Vanuatu"-> R.drawable.vanuatu
            "Venezuela"-> R.drawable.venezuela
            "Vietnam"-> R.drawable.vietnam
            "Yemen"-> R.drawable.yemen
            "Yibuti"-> R.drawable.yibuti
            "Zambia"-> R.drawable.zambia
            "Zimbaue"-> R.drawable.zimbabue
            "Jamaica"-> R.drawable.jamaica

            // Agrega más casos según sea necesario
            else ->  R.drawable.union_europea
        }
    }
}
