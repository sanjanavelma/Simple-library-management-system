import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Book {
    String name;
    String author;
    int id;


    String status;  // Added status field
    Book next;

    public Book(String name, String author, int id, String status) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.status = status;
        this.next = null;
    }
}

class Student {
    String name;
    String email;
    String book;
    String author;
    int id;
    Student next;

    public Student(String name, String email, String book, String author, int id) {
        this.name = name;
        this.email = email;
        this.book = book;
        this.author = author;
        this.id = id;
        this.next = null;
    }
}

public class libraryManagementSystem {
    static Book startLib = null;
    static Student start = null;
    static Queue<Student> issuedBooksQueue = new LinkedList<>(); // Declare issuedBooksQueue
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startLib = initializeLib();
        greetings();
        mainMenu();
    }

    static void greetings() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\t\t    ****************************************");
        System.out.println("\t\t\t\t\t     *                                      *");
        System.out.println("\t\t\t\t\t     *                                      *");
        System.out.println("\t\t\t\t\t     *     ----------------------------     *");
        System.out.println("\t\t\t\t\t     *      WELCOME TO STUDENT LIBRARY      *");
        System.out.println("\t\t\t\t\t     *     ----------------------------     *");
        System.out.println("\t\t\t\t\t     *                                      *");
        System.out.println("\t\t\t\t\t     *                                      *");
        System.out.println("\t\t\t\t\t     ****************************************");
        System.out.println("\n\n");
        System.out.println("\t\t\t\t\t     ****************************************");
        System.out.println("\t\t\t\t\t     *                                      *");
        System.out.println("\t\t\t\t\t     *                                      *");
        System.out.println("\t\t\t\t\t     *       ------------------------       *");
        System.out.println("\t\t\t\t\t     *           STUDENT LIBRARY            *");
        System.out.println("\t\t\t\t\t     *       ------------------------       *");
        System.out.println("\t\t\t\t\t     *                                      *");
        System.out.println("\t\t\t\t\t     *                                      *");
        System.out.println("\t\t\t\t\t     *       Hyderabad,Telangana,India      *");
        System.out.println("\t\t\t\t\t     *     Email: studentlib@gmail.com      *");
        System.out.println("\t\t\t\t\t     *     Contact:8800991010,8800992020    *");
        System.out.println("\t\t\t\t\t     *                                      *");
        System.out.println("\t\t\t\t\t     ****************************************");
        System.out.println("\n\n\t\t\t\t\t             Press Enter to continue: ");
        scanner.nextLine();
    }

    static void mainMenu() {
        int choice;
        do {
            System.out.println("\n\n\n\n\n");
            System.out.println("\n\n\t\t\t\t\t*************************************************");
            System.out.println("\n\t\t\t\t\t\t      MAIN MENU: ");
            System.out.println("\n\t\t\t\t\t\t     1. ISSUE OF BOOKS ");
            System.out.println("\n\t\t\t\t\t\t     2. RETURN OF BOOKS ");
            System.out.println("\n\t\t\t\t\t\t     3. DISPLAY STUDENT DETAILS ");
            System.out.println("\n\t\t\t\t\t\t     4. ADD NEW BOOK ");
            System.out.println("\n\t\t\t\t\t\t     5. SEARCH BOOK ");
            System.out.println("\n\t\t\t\t\t\t     6. LIST ALL BOOKS ");
            System.out.println("\n\t\t\t\t\t\t     7. DELETE BOOK ");
            System.out.println("\n\t\t\t\t\t\t     8. EXIT ");
            System.out.println("\n\n\t\t\t\t\t*************************************************");
            System.out.println("\n\t\t\t\t\t\t      Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    bookIssue();
                    break;
                case 2:
                    bookReturn();
                    break;
                case 3:
                    displayStudentDetails();
                    break;
                case 4:
                    addNewBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    listBooks();
                    break;
                case 7:
                    deleteBook();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("\n\t\t\t\t\t\t      ...Invalid Option!...");
                    System.out.println("\n\t\t\t\t\t\t      Press Enter to try again: ");
                    scanner.nextLine();
                    break;
            }
        } while (choice != 8);
    }

    static Book initializeLib() {
        startLib = new Book("The Kite Runner", "Khaled Hosseini", 101, "available");
        startLib.next = new Book("To Kill A Mockingbird", "Harper Lee", 102, "available");
        startLib.next.next = new Book("The Alchemist", "Paulo Coelho", 103, "available");
        startLib.next.next.next = new Book("Pride And Prejudice", "Jane Austen", 104, "available");
        startLib.next.next.next.next = new Book("A Tale Of Two Cities", "Charles Dickens", 105, "available");
        return startLib;
    }

    static Book[] convertBookListToArray(Book start) {
        int size = 0;
        Book temp = start;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        Book[] booksArray = new Book[size];
        temp = start;
        int index = 0;
        while (temp != null) {
            booksArray[index++] = temp;
            temp = temp.next;
        }
        return booksArray;
    }

    static void mergeSort(Book[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(Book[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Book[] leftArray = new Book[n1];
        Book[] rightArray = new Book[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].name.compareToIgnoreCase(rightArray[j].name) <= 0) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    static void displayBooksArray(Book[] booksArray) {
        System.out.println("\n\t*************** List of Books: ****************");
        for (Book book : booksArray) {
            System.out.println("\n\t_________________________________________________");
            System.out.println("\n\t Book Title: " + book.name);
            System.out.println("\n\t Author: " + book.author);
            System.out.println("\n\t Book ID: " + book.id);
            System.out.println("\n\t Status: " + book.status);
            System.out.println("\n\t_________________________________________________");
        }
    }

    static void addNewBook() {
        System.out.println("\n\t Enter Book Details:\n ");
        System.out.println("\n\t Enter Book Title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("\n\t Enter Author Name: ");
        String authorName = scanner.nextLine();
        System.out.println("\n\t Enter Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Book newBook = new Book(bookTitle, authorName, bookId, "available");
        if (startLib == null) {
            startLib = newBook;
        } else {
            Book ptr = startLib;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = newBook;
        }
        System.out.println("\n\t New Book Added Successfully!");
        System.out.println("\n\t Press Enter to continue: ");
        scanner.nextLine();
    }

    static void searchBook() {
        System.out.println("\n\t Enter Book ID to Search: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Book ptr = startLib;
        boolean found = false;
        while (ptr != null) {
            if (ptr.id == bookId) {
                found = true;
                System.out.println("\n\t*************** Book Details: ****************");
                System.out.println("\n\t Book Title: " + ptr.name);
                System.out.println("\n\t Author: " + ptr.author);
                System.out.println("\n\t Book ID: " + ptr.id);
                System.out.println("\n\t Status: " + ptr.status);
                System.out.println("\n\t_________________________________________________");
                break;
            }
            ptr = ptr.next;
        }
        if (!found) {
            System.out.println("\n\t Book with ID " + bookId + " not found.");
        }
        System.out.println("\n\t Press Enter to continue: ");
        scanner.nextLine();
    }

    static void listBooks() {
        if (startLib == null) {
            System.out.println("\n\t No Books Available.");
        } else {
            Book[] booksArray = convertBookListToArray(startLib);
            mergeSort(booksArray, 0, booksArray.length - 1);
            displayBooksArray(booksArray);
        }
        System.out.println("\n\t Press Enter to continue: ");
        scanner.nextLine();
    }

    static void deleteBook() {
        System.out.println("\n\t Enter Book ID to Delete: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        if (startLib == null) {
            System.out.println("\n\t No Books Available.");
        } else if (startLib.id == bookId) {
            startLib = startLib.next;
            System.out.println("\n\t Book Deleted Successfully!");
        } else {
            Book ptr = startLib;
            while (ptr.next != null && ptr.next.id != bookId) {
                ptr = ptr.next;
            }
            if (ptr.next == null) {
                System.out.println("\n\t Book with ID " + bookId + " not found.");
            } else {
                ptr.next = ptr.next.next;
                System.out.println("\n\t Book Deleted Successfully!");
            }
        }
        System.out.println("\n\t Press Enter to continue: ");
        scanner.nextLine();
    }

    static void bookIssue() {
        System.out.println("\n\t Enter Student Details:\n ");
        System.out.println("\n\t Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.println("\n\t Enter Student Email: ");
        String studentEmail = scanner.nextLine();
        System.out.println("\n\t Enter Book Title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("\n\t Enter Author Name: ");
        String authorName = scanner.nextLine();
        System.out.println("\n\t Enter Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Find the book
        Book ptr = startLib;
        while (ptr != null) {
            if (ptr.id == bookId && ptr.status.equals("available")) {
                ptr.status = "issued";
                Student newStudent = new Student(studentName, studentEmail, bookTitle, authorName, bookId);
                if (start == null) {
                    start = newStudent;
                } else {
                    Student temp = start;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = newStudent;
                }
                System.out.println("\n\t Book Issued Successfully!");
                System.out.println("\n\t Press Enter to continue: ");
                scanner.nextLine();
                return;
            }
            ptr = ptr.next;
        }
        System.out.println("\n\t Book with ID " + bookId + " not available.");
        System.out.println("\n\t Press Enter to continue: ");
        scanner.nextLine();
    }

    static void bookReturn() {
        System.out.println("\n\t Enter Student Details to Return Book:\n ");
        System.out.println("\n\t Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.println("\n\t Enter Student Email: ");
        String studentEmail = scanner.nextLine();
        System.out.println("\n\t Enter Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Find the student and book
        Student prevStudent = null;
        Student ptrStudent = start;
        while (ptrStudent != null) {
            if (ptrStudent.name.equals(studentName) && ptrStudent.email.equals(studentEmail) && ptrStudent.id == bookId) {
                // Find the book and mark it as available
                Book ptrBook = startLib;
                while (ptrBook != null) {
                    if (ptrBook.id == bookId) {
                        ptrBook.status = "available";
                        break;
                    }
                    ptrBook = ptrBook.next;
                }
                if (prevStudent == null) {
                    start = ptrStudent.next;
                } else {
                    prevStudent.next = ptrStudent.next;
                }
                System.out.println("\n\t Book Returned Successfully!");
                System.out.println("\n\t Press Enter to continue: ");
                scanner.nextLine();
                return;
            }
            prevStudent = ptrStudent;
            ptrStudent = ptrStudent.next;
        }
        System.out.println("\n\t No record found for the given details.");
        System.out.println("\n\t Press Enter to continue: ");
        scanner.nextLine();
    }

    static void displayStudentDetails() {
        if (start == null) {
            System.out.println("\n\t No Student Details Available.");
        } else {
            System.out.println("\n\t*************** Student Details: ****************");
            Student ptr = start;
            while (ptr != null) {
                System.out.println("\n\t_________________________________________________");
                System.out.println("\n\t Student Name: " + ptr.name);
                System.out.println("\n\t Email: " + ptr.email);
                System.out.println("\n\t Book Title: " + ptr.book);
                System.out.println("\n\t Author: " + ptr.author);
                System.out.println("\n\t Book ID: " + ptr.id);
                System.out.println("\n\t_________________________________________________");
                ptr = ptr.next;
            }
        }
        System.out.println("\n\t Press Enter to continue: ");
        scanner.nextLine();
    }
}
