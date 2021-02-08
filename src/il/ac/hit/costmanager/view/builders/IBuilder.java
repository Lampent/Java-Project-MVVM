/*
 * Ron Yosef 318466711
 * Eyal Stolov 324827328
 */
package il.ac.hit.costmanager.view.builders;

/**
 * The interface of the builder pattern of the application.
 *
 * @param <T> yhe item to be built.
 */
public interface IBuilder<T> {

    /**
     * The build method all class implementing this interface most implement.
     *
     * @return the built item.
     */
    T build();
}
