import java.util.LinkedList;
import java.util.List;

/**
 * Table to list and store all pages associated to processes currently loaded into main memory
 *  It is stored as a linked list to allow for easy growth(adding pages) and retrieval(removing pages)
 */
public class PageTable {

    private LinkedList<Page> pages;

    PageTable(){
        pages = new LinkedList<>();
    }

    public List<Page> getPages() {
        return pages;
    }

    /**
     * Add a {@link Page} to the page table
     * @param page {@link Page} to add
     */
    public void push(Page page) {
        this.pages.push(page);
    }

    public int getSize() {
        return pages.size();
    }

    /**
     * Retrieve the next page {@link Page} in the page table
     * @return the retrieved {@link Page}
     */
    public Page pop(){
        return this.pages.pop();
    }
}
