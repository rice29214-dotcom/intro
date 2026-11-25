package com.niitlab.Libary
fun main() {
// =====================================
// 1. BOOK CLASS
// =====================================

class Book(
    val id: Int,
    val title: String,
    val author: String,
    val year: Int,
    var borrowedByMemberId: Int? = null
)


// 2. MEMBER CLASS

class Member(
    val id: Int,
    val name: String,
    val borrowedBooks: MutableSet<Int> = mutableSetOf()
)



// 3. LIBRARY CLASS


class Library {

    private val books = mutableMapOf<Int, Book>()
    private val members = mutableMapOf<Int, Member>()

    private var nextBookId = 1
    private var nextMemberId = 1


    // ADD BOOK
    fun addBook(title: String, author: String, year: Int) {

        val book = Book(nextBookId, title, author, year)

        books[nextBookId] = book

        println("Book added successfully!")
        println("Book ID: $nextBookId")

        nextBookId++
    }


    // REGISTER MEMBER
    fun addMember(name: String) {

        val member = Member(nextMemberId, name)

        members[nextMemberId] = member

        println("Member registered successfully!")
        println("Member ID: $nextMemberId")

        nextMemberId++
    }


    // BORROW BOOK
    fun borrowBook(bookId: Int, memberId: Int) {

        val book = books[bookId]
        val member = members[memberId]

        if (book == null) {
            println("Error: Book does not exist.")
            return
        }

        if (member == null) {
            println("Error: Member does not exist.")
            return
        }

        if (book.borrowedByMemberId != null) {
            println("Sorry, this book has already been borrowed.")
            return
        }

        book.borrowedByMemberId = memberId
        member.borrowedBooks.add(bookId)

        println("Book borrowed successfully!")
    }


    // RETURN BOOK
    fun returnBook(bookId: Int, memberId: Int) {

        val book = books[bookId]
        val member = members[memberId]

        if (book == null) {
            println("Error: Book does not exist.")
            return
        }

        if (member == null) {
            println("Error: Member does not exist.")
            return
        }

        if (book.borrowedByMemberId == null) {
            println("Error: This book has not been borrowed.")
            return
        }

        if (book.borrowedByMemberId != memberId) {
            println("Error: This book belongs to another member.")
            return
        }

        book.borrowedByMemberId = null
        member.borrowedBooks.remove(bookId)

        println("Book returned successfully!")
    }


    // DISPLAY ALL BOOKS
    fun displayBooks() {

        if (books.isEmpty()) {
            println("No books available.")
            return
        }

        println("\n===== LIBRARY BOOKS =====")

        for (book in books.values) {

            val status = if (book.borrowedByMemberId == null) {
                "Available"
            } else {
                "Borrowed"
            }

            println("-------------------------")
            println("Book ID: ${book.id}")
            println("Title: ${book.title}")
            println("Author: ${book.author}")
            println("Year: ${book.year}")
            println("Status: $status")
        }
    }


    // DISPLAY LIBRARY SUMMARY
    fun displaySummary() {

        val totalBooks = books.size

        val borrowedBooks = books.values.count {
            it.borrowedByMemberId != null
        }

        val availableBooks = totalBooks - borrowedBooks

        println("\n===== LIBRARY SUMMARY =====")
        println("Total books: $totalBooks")
        println("Borrowed books: $borrowedBooks")
        println("Available books: $availableBooks")
        println("Registered members: ${members.size}")
    }
}


// =====================================
// 4. USER INPUT FUNCTIONS
// =====================================

fun readText(message: String): String {

    while (true) {

        print(message)

        val input = readLine()?.trim()

        if (!input.isNullOrEmpty()) {
            return input
        }

        println("Input cannot be empty. Try again.")
    }
}


fun readPositiveInt(message: String): Int {

    while (true) {

        print(message)

        val input = readLine()?.trim()
        val number = input?.toIntOrNull()

        if (number != null && number > 0) {
            return number
        }

        println("Please enter a valid positive number.")
    }
}

// 5. MAIN FUNCTION




    val library = Library()

    while (true) {

        println("\n================================")
        println("   PORT HARCOURT LIBRARY SYSTEM")
        println("================================")
        println("1. Add a Book")
        println("2. Register a Member")
        println("3. Borrow a Book")
        println("4. Return a Book")
        println("5. Display All Books")
        println("6. Display Library Summary")
        println("0. Exit")
        println("================================")

        print("Choose an option: ")

        val choice = readLine()?.trim()?.toIntOrNull()

        when (choice) {

            1 -> {
                println("\n--- ADD A BOOK ---")

                val title = readText("Enter book title: ")
                val author = readText("Enter author name: ")
                val year = readPositiveInt("Enter publication year: ")

                library.addBook(title, author, year)
            }

            2 -> {
                println("\n--- REGISTER MEMBER ---")

                val name = readText("Enter member name: ")

                library.addMember(name)
            }

            3 -> {
                println("\n--- BORROW A BOOK ---")

                val bookId = readPositiveInt("Enter book ID: ")
                val memberId = readPositiveInt("Enter member ID: ")

                library.borrowBook(bookId, memberId)
            }

            4 -> {
                println("\n--- RETURN A BOOK ---")

                val bookId = readPositiveInt("Enter book ID: ")
                val memberId = readPositiveInt("Enter member ID: ")

                library.returnBook(bookId, memberId)
            }

            5 -> {
                library.displayBooks()
            }

            6 -> {
                library.displaySummary()
            }

            0 -> {
                println("Thank you for using Port Harcourt Library System!")
                break
            }

            else -> {
                println("Invalid option. Please choose between 0 to 6.")
            }
        }
    }
}