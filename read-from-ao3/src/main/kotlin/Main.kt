import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.io.File

const val ao3 = "https://archiveofourown.org/"

// holy flying fuck this is so useful:
// https://try.jsoup.org

fun main() {

    val doc = Jsoup.connect("$ao3/tags/The%20Avengers%20(Marvel)%20-%20All%20Media%20Types/works").get()
    val content = doc.select(".work")


    File("ao3_avengers.dat").printWriter().use { out ->
        for (line in 1..20) {
            out.println(content[line].text().take(30))
        }
    }

}