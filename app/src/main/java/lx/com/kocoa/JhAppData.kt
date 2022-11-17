package lx.com.kocoa

class JhAppData {

    companion object{

        // 선택된 아이템 데이터
        var selectedBbsItem:BbsData? = null
        var bbsAdapter:BbsAdapter? = BbsAdapter()
        var selectedRankItem:RankData? = null
        var selectedGameItem:MiniGameData? = null
    }

}