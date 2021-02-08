/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view;

/**
 * View initializer interface to be implemented by classes that initialize the view.
 * It mainly used after all of the dependencies between the viewModel and the view have been resolved;
 * Afterwords, there is a need to initialize the view.
 */
public interface ViewInitializer {

    /**
     * Initializing the view.
     */
    void initializeView();
}
