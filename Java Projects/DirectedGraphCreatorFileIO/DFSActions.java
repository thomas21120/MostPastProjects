/*
 * Author: Thomas, Lindley
 * Project: CMSC 350 Project 4
 * Date: 10/13/2020
 * Class Description: This class creates a binary tree from supplied input, checks parentheses syntax, and provides
 * methods to operate on the object
 */

public interface DFSActions<T> {
    public void cycleDetected();
    public void processVertex();
    public void descend();
    public void ascend();
}
