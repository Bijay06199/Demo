package com.example.gyankunj.ui.home.quiz.randomQuiz

object Constants {

    const val TOTAL_QUESTIONS:String="total_question"
    const val CORRECT_ANSWERS:String="correct_answers"
    const val ITEM:String="item"

    fun getQuestions():ArrayList<Question>{
        val questionsList=ArrayList<Question>()



        val que1=Question(1,"Which one of these don't affect the expossure of a digital photography?","ISO",
             "RAW","Aperture","Shutter Speed",1)
        questionsList.add(que1)

        val que2=Question(1,"Which one of these don't affect the expossure of a digital photography?","ISO",
            "RAW","Aperture","Shutter Speed",1)
        questionsList.add(que2)

        val que3=Question(1,"Which one of these don't affect the expossure of a digital photography?","ISO",
            "RAW","Aperture","Shutter Speed",1)
        questionsList.add(que3)

        val que4=Question(1,"Which one of these don't affect the expossure of a digital photography?","ISO",
            "RAW","Aperture","Shutter Speed",1)
        questionsList.add(que4)

        val que5=Question(1,"Which one of these don't affect the expossure of a digital photography?","ISO",
            "RAW","Aperture","Shutter Speed",1)
        questionsList.add(que5)

        val que6=Question(1,"Which one of these don't affect the expossure of a digital photography?","ISO",
            "RAW","Aperture","Shutter Speed",1)
        questionsList.add(que6)
        val que7=Question(1,"Which one of these don't affect the expossure of a digital photography?","ISO",
            "RAW","Aperture","Shutter Speed",1)
        questionsList.add(que7)

      return questionsList
    }
}