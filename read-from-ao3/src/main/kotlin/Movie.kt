import org.jsoup.Jsoup

class Movie {
    // Holds all movie information
    var title: String? =""
    var directedBy: String =""
    var producedBy: String =""
    var writtenBy: String =""
    var starring: String =""
    var musicBy: String =""
    var releaseDate: String =""

    override fun toString(): String {
        return "Movie(title='$title'"
    }

}