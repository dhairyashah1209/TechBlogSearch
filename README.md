Problem Statement:

Your organization has started a new tech blog and wants to implement an in-memory search engine to enable efficient search functionality on blog content. You are responsible for designing and implementing this system.

Requirements:

Category Management:

The system should allow creating multiple categories, where each category can contain multiple documents.

Document Management:

The system should support inserting and deleting documents in a given category.

Each document should have the following attributes:
Document ID (Unique identifier)
Title
Content
Created Timestamp
Updated Timestamp
Search Functionality:

Users should be able to search for documents within a specific category using a given keyword.

The search should support two modes:
Normal Search: Returns all documents containing the keyword.
Frequency-Based Search: Returns results ranked by the number of keyword occurrences in the document.

Sorting of Search Results:

The search results should be sortable based on:
Created Timestamp (Oldest to Newest)
Updated Timestamp (Most Recently Updated First)

Constraints & Considerations:
The system should be in-memory (no external database).
It should be optimized for fast retrieval.
Consider edge cases, such as searching for a word that doesn’t exist in any document, deleting a non-existing document, or handling empty categories.

Follow-up Questions (For Candidates in an Interview):
How would you optimize the search functionality for large datasets?
How would you extend this system if it needed to support full-text search?
How would you modify the design to support persistence using a database?
How would you handle concurrent searches and modifications in a multi-threaded environment?
