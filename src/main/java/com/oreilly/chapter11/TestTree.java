package com.oreilly.chapter11;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestTree {
    public static void main(String[] args) {
        new TestTree().go();
    }

    public void go() {
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix your Body");
        Book b3 = new Book("Finding Emo");
        Book b4 = new Book("Finding Emo");

        Comparator<Book> sortByTitle = (book1, book2) -> book1.getTitle().compareTo(book2.getTitle());

        Set<Book> tree = new TreeSet<>(sortByTitle);  // A TreeSet is sorted. TreeSet elements must be comparable. See page 352
//        Set<Book> tree = new TreeSet<>();  // Not working without a Comparator (or Book must implement Comparable)
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        tree.add(b4);

        System.out.println(tree);

    }
}

@Data
@AllArgsConstructor
class Book {
    private String title;
}