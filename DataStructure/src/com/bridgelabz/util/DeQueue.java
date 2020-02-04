/**DeQueueList class implement DeQueue functions
 * @author kishorereddy
 * @version 1.0
 * @since 04-03-2020
 * @file DeQueueList.java
*/
package com.bridgelabz.util;
import java.util.Scanner;

public class DeQueue<T> {
	Node<T> left, right;
	Node<T> prev;
	int size = 0;
	
    //constructor
	public DeQueue() {
		left = right = null;
	}

	public Scanner scanner = new Scanner(System.in);
	/** function to implement add character to dequeue in rear end
	 * @param data
	 */
	public void addRear(T data) {
		Node<T> newNode = new Node<T>(data);
		if (left == null) {
			left = right = (Node<T>) newNode;
			left.prev = null;
			right.next = null;
			size++;
			return;
		}
		right.next = (Node<T>) newNode;
		newNode.prev = (Node<T>) right;
		right = (Node<T>) newNode;
		size++;
	}

	/**function to implement add character to dequeue in front en
	 * @param data
	 */
	public void addFront(T data) {
		Node<T> newNode = new Node<T>(data);
		left.prev = (Node<T>) newNode;
		newNode.next = (Node<T>) left;
		newNode.prev = null;
		left = (Node<T>) newNode;
		size++;
	}

	/**function to implement remove character at front end
	 * @param data
	 */
	public T removeFront() {
		Node<T> prevnode;
		if (left == null) {
			System.out.println("dequeue is empty ");
			return null;
		}
		System.out.println(left.data);
		T charcter = (T) left.data;
		prevnode = (Node<T>) left;
		left = left.next;
		prevnode.next = null;
		return charcter;
	}

	/**function to implement remove character at rear end 
	 * @param data
	 */
	public T removeRear() {
		Node<T> prevnode;
		if (right == null) {
			System.out.println("deQueue is empty");
			return null;
		}
		System.out.println(right.data);
		T character = (T) right.data;
		prevnode = (Node<T>) right;
		right = right.prev;
		prevnode.prev = null;
		return character;
	}

	/**function to implement return the size of dequeue 
	 * @return size of dequeue
	 */
	public int deQueueSize() {
		return size;
	}

	/**function to implement dequeue is empty or not
	 * @return isDequeueEmpty or not
	 */
	public boolean isDequeEmpty() {
		boolean isDeQueue = false;
		if (left != null) {
			isDeQueue = true;
		}
		return isDeQueue;
	}

	/**funcrtion to implement given string is palindrome or not
	 * @return boolean isPalindrome
	 */
	public boolean isPalindrome() {
		Character name1 = ' ';
		Character name2 = ' ';
		boolean ispalindrome = false;
		int size = deQueueSize();
		if (size % 2 == 0) {
			while (size != 0) {
				name1 = (Character) removeFront();
				name2 = (Character) removeRear();
				size--;
			}
			if (name1.equals(name2)) {
				ispalindrome = true;
			}
		} else if (size % 2 == 1) {
			System.out.println("deque contains insufficient  character ");
		}
		return ispalindrome;
	}
}
