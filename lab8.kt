//Class to store a single comment (author + message)
class Comment(
    val userId: Int,
    val message: String
)

fun main() {
    // List of comments (ordered, can contain many items)
    val comments: List<Comment> = listOf(
        Comment(5241, "Nice code"),
        Comment(6624, "Like it"),
        Comment(5224, "What’s going on?"),
        Comment(9001, "Check out my website"),
        Comment(8818, "Hello everyone :)")
    )

    //Set of blocked users (unique ids, fast membership test)
    val blockedUserIds: Set<Int> = setOf(5224, 9001)

    //  Map of relationships (key = userId, value = relation)
    val userIdToRelation: Map<Int, String> = mapOf(
        5241 to "Friend",
        6624 to "Work Colleague"
    )

    //  Filter, find relation, then print
    for (comment in comments) {

        // If the author is NOT blocked, show the comment
        if (comment.userId !in blockedUserIds) {

            //  find relation by userId; if absent -> "unknown"
            val relation: String = userIdToRelation[comment.userId] ?: "unknown"

            // S print in required format
            println("Comment ${comment.message} from $relation")
        }
    }
}
