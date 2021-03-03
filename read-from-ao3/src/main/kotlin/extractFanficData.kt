import org.jsoup.Jsoup
import org.jsoup.nodes.Document

fun extractFanficData(url: String): Fanfic? {

    // 1. Get html document at url
    var doc: Document
    try {
        doc = Jsoup.connect("$ao3$url").get()  // <2>
    } catch (e: Exception) {
        return null
    }

    // What if the fanfic has an adult rating tag and you need to choose to proceed?

    val viewAdult: String = "?view_adult=true"
    while (doc.select("p.caution").isNotEmpty()) {
        try {
            doc = Jsoup.connect("$ao3$url$viewAdult").get()  // <2>
        } catch (e: Exception) {
            return null
        }
    }
    // 2. Extract fanfic content from url

    val fanfic = Fanfic()
    fanfic.title = doc.select("h2.title.heading").text()
    fanfic.author = doc.select("h3.byline.heading").text()
    fanfic.dateUpdated = doc.select("dd.status").text()
    fanfic.rating = doc.select("dd.rating.tags").text()
    fanfic.blurb = doc.select("blockquote.userstuff").text()


    return fanfic
}
