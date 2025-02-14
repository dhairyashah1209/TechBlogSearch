import java.util.*;

class SearchEngine {
    private final Map<String, Category> categories;

    public SearchEngine() {
        this.categories = new HashMap<>();
    }

    public void createCategory(String name) {
        categories.putIfAbsent(name, new Category(name));
    }

    public void addDocument(String categoryName, Document doc) {
        Category category = categories.get(categoryName);
        if (category != null) {
            category.addDocument(doc);
        } else {
            System.out.println("Category not found: " + categoryName);
        }
    }

    public void deleteDocument(String categoryName, int docId) {
        Category category = categories.get(categoryName);
        if (category != null) {
            category.removeDocument(docId);
        } else {
            System.out.println("Category not found: " + categoryName);
        }
    }

    public List<Document> search(String categoryName, String keyword, boolean frequencyBased, boolean sortByCreated) {
        Category category = categories.get(categoryName);
        if (category != null) {
            return category.searchDocuments(keyword, frequencyBased, sortByCreated);
        }
        return new ArrayList<>();
    }
}