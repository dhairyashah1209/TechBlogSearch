import java.util.*;

class Category {
    private final String name;
    private final Map<Integer, Document> documents;

    public Category(String name) {
        this.name = name;
        this.documents = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addDocument(Document doc) {
        documents.put(doc.getId(), doc);
    }

    public void removeDocument(int docId) {
        documents.remove(docId);
    }

    public List<Document> searchDocuments(String keyword, boolean frequencyBased, boolean sortByCreated) {
        List<Document> results = new ArrayList<>();
        Map<Document, Integer> frequencyMap = new HashMap<>();

        for (Document doc : documents.values()) {
            int freq = countKeywordFrequency(doc.getContent(), keyword);
            if (freq > 0) {
                results.add(doc);
                frequencyMap.put(doc, freq);
            }
        }

        // Sorting logic
        if (frequencyBased) {
            results.sort((d1, d2) -> frequencyMap.get(d2) - frequencyMap.get(d1));
        } else if (sortByCreated) {
            results.sort(Comparator.comparingLong(Document::getCreatedAt));
        } else {
            results.sort(Comparator.comparingLong(Document::getUpdatedAt));
        }

        return results;
    }

    private int countKeywordFrequency(String text, String keyword) {
        int count = 0, index = 0;
        while ((index = text.indexOf(keyword, index)) != -1) {
            count++;
            index += keyword.length();
        }
        return count;
    }
}