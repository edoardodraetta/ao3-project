import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File

// https://try.jsoup.org

// TODO:
// - What do I want this program to look like?

const val ao3 = "https://archiveofourown.org"

fun main() {

    val fanfics = mutableListOf<Fanfic>()
    val doc : Document
    val url = "$ao3/tags/The%20Avengers%20(Marvel)%20-%20All%20Media%20Types/works"

    // Get Html document for Avengers page
    doc = Jsoup.connect(url).get()

    // Navigate to each title on the page and extract its data
    doc.select("h4.heading").not("h4.landmark.heading").select("a[href^=/work]")
        .map{ col -> col.attr("href")}
        .parallelStream()
        .map { extractFanficData(it) }
        .forEach {
            if (it != null) {
                fanfics.add(it)
            }
        }

    // testing module

//    for (i in 0..19) {
//        println(i)
//        println(fanfics[i].title)
//        println(fanfics[i].body.take(15))
//        println()
//    }

//     for (i in 0..4) fanfics[i].printToFile()

}