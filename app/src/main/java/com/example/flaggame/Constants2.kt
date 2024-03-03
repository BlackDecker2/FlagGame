package com.example.flaggame

object Constants2 {

    fun getQuestion() : ArrayList<Question>{

        val questionsList = ArrayList<Question>()

        val que1 = Question(1,
            "Cúal es el pais de esta bandera?",
            R.drawable.germany,
        "Alemania",
            "Argentina",
            "Armenia", "USA",
            1)



        val que2 = Question(2,
            "Cúal es el Pais de esta bandera?", R.drawable.mexico,
            "Australia",
            "Argentina",
            "Mexico",
            "USA",
            3)


        val que3 = Question(3,
            "Cúal es el Pais de esta bandera?", R.drawable.france,
            "Mexico",
            "Francia",
            "Africa",
            "USA",
            2)


        val que4 = Question(4,
            "Cúal es el Pais de esta bandera?", R.drawable.turkey,
            "Kazakistan",
            "Ucrania",
            "Turquia",
            "USA",
            3)


        val que5 = Question(5,
            "Cúal es el Pais de esta bandera?", R.drawable.us,
            "USA",
            "Argentina",
            "Armenia",
            "Sur America",
            1)


        val que6 = Question(6,
            "Cúal es el Pais de esta bandera?", R.drawable.uk,
            "Australia",
            "Argentina",
            "Reino Unido",
            "USA",
            3)


        val que7 = Question(7,
            "Cúal es el Pais de esta bandera?", R.drawable.european,
            "Escocia",
            "Union Europea",
            "Armenia",
            "USA",
            2)


        val que8 = Question(8,
            "Cúal es el Pais de esta bandera?", R.drawable.germany,
            "Holanda",
            "España",
            "Belgica",
            "Alemania",
            4)


        val que9 = Question(9,
            "Cúal es el Pais de esta bandera?", R.drawable.canada,
            "Dinamarca",
            "Argentina",
            "Canada",
            "USA",
            3)


        val que10 = Question(10,
            "Cúal es el Pais de esta bandera?", R.drawable.india,
            "India",
            "Iran",
            "Irlanda",
            "USA",
            1)


        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)




        return questionsList
    }

}

