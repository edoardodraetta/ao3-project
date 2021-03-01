import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.io.File

// https://jsoup.org/apidocs/org/jsoup/nodes/Document.html

const val wikihome = "https://en.wikipedia.org/wiki/Main_Page"

fun main() {

    // The Document class is the HTML document, it's an extension of the Element class
    // the .connect() method connects to the given URL
    // the .get() method retrieves the HTML data

    // val doc : Document = Jsoup.connect("http://example.com").get()

    // val doc : Document = Jsoup.connect("$wikihome").get()

    // the .text() method retrieves all text in the element

    // println(doc.text())
    // println(doc.body().text())

    // println(doc.head().text())

    // get url
    // println(doc.location())

    // the .select() method returns Elements that match the CSS selector
    // matched elements may include this element and any of its children

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

