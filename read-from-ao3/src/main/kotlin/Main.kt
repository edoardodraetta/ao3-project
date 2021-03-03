import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File

// https://try.jsoup.org


// TODO:
// -

const val ao3 = "https://archiveofourown.org/"


fun main() {

    // Basic test implementation

    val doc : Document
    val fanfic = Fanfic()
    var url = "$ao3/tags/The%20Avengers%20(Marvel)%20-%20All%20Media%20Types/works"

    doc = Jsoup.connect(url).get()

    var fanfics = mutableListOf<Fanfic>()

    // printCurrentPage(url)

    doc.select("h4.heading").not("h4.landmark.heading").select("a[href^=/work]")
        .map{ col -> col.attr("href")}
        .parallelStream()
        .map { extractFanficData(it) }
        .forEach {
            if (it != null) {
                fanfics.add(it)
            }
        }

    printPageToTerminal(fanfics)
//    printPageToFile("ao3_avengers.dat",fanfics)
}