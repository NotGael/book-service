package be.fontenelle.springbase.bookservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController {

    val books = listOf(Book(1L, "author1", "title1"), Book(2L, "author2", "title2"))

    @GetMapping("")
    fun findAllBooks(): List<Book> {
        return books
    }

    @GetMapping("/{bookId}")
    fun findBook(@PathVariable bookId:Long): Book? {
        return books.filter{ b -> b.id == bookId }.firstOrNull()
    }
}
