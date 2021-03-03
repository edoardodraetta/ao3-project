class Fanfic {

    var url: String = ""
    var title: String =""
    var author: String =""

    var fandoms: String =""
    var blurb: String = ""

    var rating: String? =""
    var relationships: String? =""
    var contentWarnings: String? =""
    var progress: String? =""

    var datePosted: String =""
    var dateUpdated: String ="none"

    var language: String =""
    var words: String = ""
    var chapters: String = ""
    // var tags: String? = ""

    override fun toString() : String {
        return "Title: $title, Author: $author, Blurb:${blurb.take(20)}"
    }
}