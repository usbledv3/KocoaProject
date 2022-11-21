package lx.com.kocoa

/**
 * 한글 초성 검색을 위한 유틸(유니코드 활용)
 */
class KoreanMatcher {

    private val koreanUnicodeStart = 44032 // 가
    private val koreanUnicodeEnd = 55203   // 힣

    private val koreanUnicodeBased = 588   // 각 자음 마다 가지는 글자 수

    // 자음
    private val koreanConsonant = arrayOf(
        'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ',
        'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    )

    /**
     * 해당 문자가 초성인지 체크
     */
    private fun isConsonant(ch: Char): Boolean {
        return koreanConsonant.contains(ch)
    }

    /**
     * 해당 문자가 한글인지 체크
     */
    private fun isKorean(ch: Char): Boolean {
        val charCode = ch.code
        return charCode in koreanUnicodeStart..koreanUnicodeEnd
    }

    /**
     * 자음을 얻는다
     */
    private fun getConsonant(ch: Char): Char {
        val hasBegin = (ch.code - koreanUnicodeStart)
        val idx = hasBegin / koreanUnicodeBased
        return koreanConsonant[idx]
    }

    /**
     * 초성 또는 한글 검색
     * @param based 비교대상
     * @param search 검색단어
     */
    fun matchKoreanAndConsonant(based: String, search: String): Boolean {
        var temp = 0
        val diffLength = based.length - search.length
        val searchLength = search.length

        if (diffLength < 0) {
            return false
        } else {
            for (i in 0..diffLength) {
                temp = 0

                while (temp < searchLength) {
                    if (isConsonant(search[temp]) && isKorean(based[i + temp])) {
                        // 현재 char이 초성이고 based가 한글일 때
                        if (getConsonant(based[i + temp]) == search[temp]) {
                            // 각각의 초성끼리 같은지 비교
                            temp++
                        } else {
                            break
                        }
                    } else {
                        // char가 초성이 아니라면
                        if (based[i + temp] == search[temp]) {
                            temp++
                        } else {
                            break
                        }
                    }
                }

                // 모두 일치한 결과
                if (temp == searchLength) return true
            }

            // 일치하는 것을 찾지 못했을 때
            return false
        }

    }
}