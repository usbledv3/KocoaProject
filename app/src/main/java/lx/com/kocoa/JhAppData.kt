package lx.com.kocoa

class JhAppData {

    companion object{

        // 선택된 아이템 데이터
        // 게시판
        var selectedBbsItem:BbsData? = null
        var bbsAdapter:BbsAdapter? = BbsAdapter()

        var selectedRankItem:RankData? = null

        // 미니게임
        var selectedGameItem:MiniGameData? = null
        var miniGameAdapter:MiniGameAdapter? = MiniGameAdapter()
    }

}