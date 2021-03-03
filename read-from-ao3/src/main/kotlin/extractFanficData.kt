import org.jsoup.Jsoup
import org.jsoup.nodes.Document

fun extractFanficData(url: String): Fanfic? {

    // 1. Get html document at url

    var doc: Document
    val viewAdult: String = "?view_adult=true"
    val fanfic = Fanfic()

    try {
        doc = Jsoup.connect("$ao3$url").get()

        // if page is adult rated
        while (doc.select("p.caution").isNotEmpty()) {
            try {
                doc = Jsoup.connect("$ao3$url$viewAdult").get()
            } catch (e: Exception) {
                return null
            }
        }
    } catch (e: Exception) {
        return null
    }

    // 2. Extract fanfic content from url

    fanfic.title = doc.select("h2.title.heading").text()
    fanfic.author = doc.select("h3.byline.heading").text()
    fanfic.blurb = doc.select("blockquote.userstuff").text()

    fanfic.body = doc.select("div.userstuff").text()

    fanfic.url = url
    fanfic.rating = doc.select("dd.rating.tags").text()
    fanfic.warning = doc.select("dd.warning.tags").text()
    fanfic.categories = doc.select("dd.category.tags").text()

    fanfic.fandoms = doc.select("dd.fandom.tags").text()
    fanfic.relationships = doc.select("dd.relationship.tags").text()
    fanfic.characters = doc.select("dd.character.tags").text()
    fanfic.additionalTags = doc.select("dd.freeform.tags").text()
    fanfic.language = doc.select("dd.language.tags").text()

    fanfic.series = doc.select("dd.series.tags").text()
    fanfic.datePublished = doc.select("dd.published").text()
    fanfic.dateUpdated = doc.select("dd.status").text()

    fanfic.wordCount = doc.select("dd.words").text()
    fanfic.chapterCount = doc.select("dd.chapters").text()

    fanfic.comments = doc.select("dd.commends").text()
    fanfic.kudos = doc.select("dd.kudos").text()
    fanfic.bookmarks = doc.select("dd.bookmarks").text()
    fanfic.hits = doc.select("dd.hits").text()

    return fanfic
}
