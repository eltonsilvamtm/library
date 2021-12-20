# library
CLI library project for Data tructures and Algorithms


A library has come to you as a developer and outlined that currently they do not have any software to
track the different titles they have in stock, users of the library and borrowings. They have asked you
to develop a system which will allow them to do this. The library doesn’t have a budget for a
database, so your solution must implement a text file based system to ensure persistency of the data.
Specific Requirements
• The library system must include the following entities:
o Book: To model all data relevant to the books. ID, title, author and/or any other piece
of information that you consider relevant.
o Reader: To model all data relevant to the users of the library. ID, name, address
and/or any other piece of information that you consider relevant.
• When the program is executed, it must automatically load onto memory the data that exists
on the text files(s) in the form of objects. Books, readers and any other entity that you include
in your design (e.g. borrowings).
Algorithms and Constructs Page 2 of 3
• Consider your user to be an employee from the library. After all the data has been loaded, the
user should be presented with the following options.
o Search for a specific book by title and/or author name.
o List all books by title and/or author name alphabetical order.
o Search for a specific reader by name and/or ID.
o List all readers by alphabetical and/or ID order.
o Register that a reader has borrowed a book.
o If a book is borrowed and another reader wants to borrow it, allow the user to add that
reader to a waiting list (queue).
o Register that a reader has returned a book.
o If a book is returned and has a waiting queue, display to the user the next reader
waiting for that book.
o For a specific reader, list the books that they have borrowed.
• In order to perform these tasks, you should implement APPROPRIATE constructs and data
structures. The use of the Java Collections Framework is allowed, except for Queues. Your
implementation of any queue structure must be CUSTOM MADE for your application.
• You must implement CUSTOM MADE searching and/or sorting algorithms. Even though, the
use of built-in Java Collections classes is allowed, searching and/or sorting algorithms must
be your own.
• This is a command line program, and the use of graphic user interfaces is not allowed (i.e.
JavaSwing, JavaFX, GUI builders, etc.).
