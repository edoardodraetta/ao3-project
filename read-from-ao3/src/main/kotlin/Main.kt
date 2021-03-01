import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.io.File

const val ao3 = "https://archiveofourown.org/"

// https://try.jsoup.org

fun main() {

    val doc = Jsoup.connect("$ao3/tags/The%20Avengers%20(Marvel)%20-%20All%20Media%20Types/works").get()

    val titles = doc.select("h4.heading").not("h4.landmark.heading")
    val blurbs = doc.select("blockquote.userstuff.summary")

    File("ao3_avengers.dat").printWriter().use { out ->
        for (line in 0..10) {
            out.println(line)
            out.println(titles[line].text())
            out.println(blurbs[line].text())
        }
    }
}