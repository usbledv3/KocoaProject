package lx.com.kocoa

object MultipleQuestionData {

    fun getQuestion(): ArrayList<MultipleQuestion>{

        val questList: ArrayList<MultipleQuestion> = arrayListOf()

        val question1 = MultipleQuestion(
            1,
            "산천어의 몸 길이는?",
            "5cm",
            "10cm",
            "15cm",
            "20cm",
            4
        )

        val question2 = MultipleQuestion(

            2,
            "산천어의 수명은?",
            "1년",
            "2년",
            "3년",
            "4년",
            3

        )

        val question3 = MultipleQuestion(
            3,
            "산천어 축제가 열리는 지역은?",
            "평창군",
            "화천군",
            "철원군",
            "양양군",
            2
        )

        questList.add(question1)
        questList.add(question2)
        questList.add(question3)

        return questList
    }
}