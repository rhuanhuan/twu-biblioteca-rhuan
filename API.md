#Biblioteca API

##Welcome message and Main Menu

When you start the application, you will see welcome message and main menu:

```
Welcome to our library!
------------------
----Main  Menu----
------------------
```

###Commands

**`List Books`**
Show book list

**`List Movies`**
Show movie list

**`Quit`**
Quit the application

**`Other command`**
Select a valid option!

---------------------

#Book List

##Book list menu

When you list the books, you will see

```
******************
----Books List----
******************
```

and book infomation which can be checked out.

###Commands 

**`Checkout`**

Turn to the Checkout page

**`Return`**

Turn to the return page

**`Quit`**

Quit the application

**`Other Command`**

Invalid option!

--------------------------

##Checkout

When you choose checkout in the booklist, you will see checkout page

`###################`
`#Check your boooks#`
`*******************`

###Commands 

**`#bookname`**

If you bookname is legal and its statu is "Allowed", it will return 

`"Thank you! Enjoy the book"`

Otherwise it will return :

`"That book is not available."`

**`Back`**

It will return to the book list page.

-------------------------------------------

##Return

When you choose Return in the booklist, you will see return page

`####################`
`#Return your books#`
`********************`

###Commands

**`#bookname`**

If you bookname is legal and its statu is "Denied", it will return 

`Thank you for returning the book.`

Otherwise it will return :

`That is not a valid book to return.`

**`Back`**

It will return to the book list page.

-------------------------------------------