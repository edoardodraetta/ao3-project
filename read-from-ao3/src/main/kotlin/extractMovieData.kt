import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

fun extractMovieData(url: String): Movie? { // <1>
    val doc: Document
    try {
        doc = Jsoup.connect("$wiki$url").get()  // <2>
    } catch (e: Exception){
        return null
    }

    val movie = Movie() // <3>
    doc.select(".infobox tr")   // <4>
        .forEach { ele ->   // <5>
            when {
                ele.getElementsByTag("th")?.hasClass("summary") ?: false -> {   // <6>
                    movie.title = ele.getElementsByTag("th")?.text()
                }
                else -> {
                    val value: String? = if (ele.getElementsByTag("li").size > 1)
                        ele.getElementsByTag("li")
                            .map(Element::text)
                            .filter(String::isNotEmpty)
                            .joinToString(", ") else
                        ele.getElementsByTag("td")?.first()?.text() // <7>

                    when (ele.getElementsByTag("th")?.first()?.text()) {    // <8>
                        "Directed by" -> movie.directedBy = value ?: ""
                        "Produced by" -> movie.producedBy = value ?: ""
                        "Written by" -> movie.writtenBy = value ?: ""
                        "Starring" -> movie.starring = value ?: ""
                        "Music by" -> movie.musicBy = value ?: ""
                        "Release date" -> movie.releaseDate = value ?: ""
                        "title" -> movie.title = value ?: ""
                    }
                }
            }
        }
    return movie
}

/*
<1> extractMovieData takes URL of the movie page

<2> Connect and parse the HTML document but some times wiki page might
not be available for the movie then Jsoup throws the Exception.
Handle it and return null if page is not available.

<3> For each movie create a new Movie instance.

<4> Wiki assigns class .infobox to the movie table and it contains all
the required information. We will select all rows from the .infobox table.

<5> forEach is executed for each row in the table and it provides Element
reference to that row. Now we can examine this row and extract needed data.

<6> A row with .summary class will have title of the movie so we are checking if
this element existing and if yes then set it to movie.title. ele.getElementsByTag(“th”)?.text()
extracts the contents of the th element which contains movie title.

<7> This is a long expression with if..else condition. Wiki can have multiple values in some rows
like multiple actors in Starring in this case we need to check for multiple list items and if exists
then extract text from each item and join them with comma if not then just extract the text.
Final result will be assigned to value.

<8> We have value but we need the column information so we can set this to proper field in the
Movie instance. For example value in Produced by should be mapped to producedBy field in the
Movie instance. First column in the row contains the header and we used when expression to check
these values and for each matched column we assigned to the proper field in the movie instance.
 */