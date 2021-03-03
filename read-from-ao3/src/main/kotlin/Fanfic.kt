import java.io.File

class Fanfic {

    var title: String =""
    var author: String =""
    var blurb: String = ""

    var body: String = ""
    var url: String = ""
    var rating: String? =""
    var warning: String =""
    var categories: String =""

    var fandoms: String =""
    var relationships: String =""
    var characters: String =""

    var additionalTags: String =""
    var language: String =""

    var series: String = ""
    var datePublished: String =""
    var dateUpdated: String =""

    var wordCount: String = ""
    var chapterCount: String =""

    var comments:String =""
    var kudos: String =""
    var bookmarks =""
    var hits =""


    override fun toString() : String {
        return "Title: $title, Author: $author, Blurb:${blurb.take(20)}"
    }

    fun printToFile(fileName:String ="$title by $author.txt", path: String = "src/out") {

        File(path, fileName).printWriter().use { out ->
            out.println("$title by $author")
            out.println()
            out.println("$ao3$url")
            out.println()
            out.println("Date Updated: $dateUpdated, Date Published: $datePublished")
            out.println()
            out.println("Rating: $rating")
            out.println("Warnings: $warning")
            out.println()
            out.println("Categories: $categories")
            out.println("Relationships: $relationships")
            out.println("Characters: $characters")
            out.println()
            out.println(blurb)
            out.println()
            out.println("Language: $language")
            out.println()
            out.println("Additional Tags: ")
            out.println(additionalTags)
            out.println()
            out.println("Word Count: $wordCount, Chapters: $chapterCount")
            out.println()
            out.println("$comments commments, $kudos kudos, $bookmarks bookmarks, $hits hits")
            out.println()
            out.println("-".repeat(120))
            out.println()
            out.println(body)
        }
    }
}