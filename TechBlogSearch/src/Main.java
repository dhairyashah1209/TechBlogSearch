import java.util.*;

public class Main {
	
    public static void main(String[] args) throws InterruptedException {
        SearchEngine engine = new SearchEngine();

        // Create categories
        engine.createCategory("Tech");
        engine.createCategory("Science");

        // Add documents
        Document doc1 = new Document(1, "Java Basics", "Java is a powerful language.");
        Document doc2 = new Document(2, "Advanced Java", "Java supports multi-threading.");
        Document doc3 = new Document(3, "Python Guide", "Python is popular for AI and ML.");
        
        engine.addDocument("Tech", doc1);
        engine.addDocument("Tech", doc2);
        engine.addDocument("Science", doc3);

        // Simulate an update
        Thread.sleep(1000);
        doc1.updateContent("Java is widely used for enterprise applications.");

        // Search for "Java"
        System.out.println("Normal Search (Tech, 'Java'):");
        List<Document> result1 = engine.search("Tech", "Java", false, false);
        result1.forEach(System.out::println);

        // Search for "Java" with frequency-based ranking
        System.out.println("\nFrequency-Based Search (Tech, 'Java'):");
        List<Document> result2 = engine.search("Tech", "Java", true, false);
        result2.forEach(System.out::println);

        // Search with sorting by creation time
        System.out.println("\nSearch Sorted by Creation Time (Tech, 'Java'):");
        List<Document> result3 = engine.search("Tech", "Java", false, true);
        result3.forEach(System.out::println);

        // Delete a document
        engine.deleteDocument("Tech", 1);
        System.out.println("\nAfter deleting document with ID 1:");
        List<Document> result4 = engine.search("Tech", "Java", false, false);
        result4.forEach(System.out::println);
    }
}