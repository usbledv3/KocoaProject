package lx.com.kocoa

class ReviewManagerData {
    companion object{ // 여기는 ReviewActivity에서 사용함. 후기관리화면에 새로작성된 후기를 가져로는 용도

        var titleofReview: String?=null // 리뷰이름
        var dateofReview : String?=null // 리뷰날짜
        var nameofReview : String?=null // 리뷰작성자
        var textofReview : String?=null // 리뷰내용
        var selectedItem:ReviewData? = null
    }
}