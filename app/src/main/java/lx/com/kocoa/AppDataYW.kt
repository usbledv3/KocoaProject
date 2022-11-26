package lx.com.kocoa

class AppDataYW {
    companion object {
        var searchSelectedItem:SearchData? = null
        var doSelectedItem:DoData? = null
        var reviewSelectedItem:ReviewData? = null
        var reviewAdapter:ReviewAdapter? = ReviewAdapter()
        var reviewTitle: String?=null
        var reviewDate: String?=null
        var reviewName: String?=null
        var reviewText: String?=null
    }
}