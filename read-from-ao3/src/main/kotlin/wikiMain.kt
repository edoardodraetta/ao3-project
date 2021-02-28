import org.jsoup.Jsoup

const val wiki = "https://en.wikipedia.org"

fun main() {

    val doc = Jsoup.connect("$wiki/wiki/List_of_films_with_a_100%25_rating_on_Rotten_Tomatoes").get()    // <1>

    doc.select(".wikitable:first-of-type tr td:first-of-type a")    // <2>
        .map { col -> col.attr("href") }    // <3>
        .parallelStream()    // <4>
        .map { extractMovieData(it) }    // <5>
        .filter { it != null }
        .forEach { println(it) }
}

/* We can process steams in parallel by just introducing parallelStream() call.
We have more than 300 rows in the table and each row is independent of each other
so we can process them in parallel and it will be fast. With parallelStream() it took 7
seconds to process all movies but when I removed parallelStream() then whole process took
around 17 seconds because then movies are processed in sequential.
 */
/*
<1> Jsoup.connect(…) will connects to the URL and creates Connection object.

Once the connection object is created then called get() on it so the page is
parsed and returned as the Document object. We stored document in the doc variable.

<2> select takes a CSS query and returns all matched elements as Elements instance.

Elements is a collection which extends ArrayList so we can iterate and process the
elements individually.

We passed .wikitable:first-of-type tr td:first-of-type a.

This is a bit complex CSS query. Lets divide this into pieces to understand it;

.wikitable:first-of-type

Get first matched element which contains .wikitable class. If you inspect the page in the
browser then you see the movies table contains .wikitable class.

.wikitable:first-of-type tr
Extract all rows in the table.

.wikitable:first-of-type tr td:first-of-type

but we are interested only on first column of the table because it contains the movie title with URL.
So this extracts the first td.

.wikitable:first-of-type tr td:first-of-type a
With in the first column we need anchor tag because this contains the URL for the movie page.

<3> We need href attribute because it contains the URL so using map we convert
Element to String which contains the URL.

<4> We have more than 300 movies in the table and for each movie we need to parse
the movie page and extract its content so instead of doing it in sequential we can do it in
parallel to speedup the process.

<5> For each URL we call extractMovieData function. This function contains code to extract movie content.
*/

// https://thetechstack.net/using-jsoup-with-kotlin-to-scrape-wiki-pages/#add-jsoup