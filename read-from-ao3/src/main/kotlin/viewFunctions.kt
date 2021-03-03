import org.jsoup.Jsoup
import org.jsoup.nodes.Document

fun printPageToTerminal(fics: MutableList<Fanfic>) {
    fics.forEach {
        println(it.title)
        println()
        println(it.author)
        println()
        println(it.dateUpdated)
        println()
        println(it.rating)
        println()
        println(it.blurb)
        println()
    }
}


fun printPageToFile(filename : String, fics: MutableList<Fanfic>){
    TODO()
//    File(filename).printWriter().use { out ->
}

fun printCurrentPage(url: String) {

    val doc = Jsoup.connect(url).get()

    val page = doc.select("div.header.module").select("h4.heading").filter { it != null }

    // Could not get this to work using forEach
    for (i in 0..19) {
        println("$i ${page[i].text()}")
    }

}