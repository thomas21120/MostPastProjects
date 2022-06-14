/*
 * Author: Thomas, Lindley
 * Date: 07/24/2020
 * Purpose: Binds the generic interface to the enum
 */
package lindley.project4;

interface StateChangeable<E extends Enum<E>>{
    public void changeState(E state);
}
