
import java.util.NoSuchElementException;
/**
 * CS312 Assignment 12.
 *
 * On MY honor, Luis Zamorano, this programming assignment is MY own work and I
 * have not provided this code to any other student.
 *
 * Student name: Luis Zamorano
 *  UTEID:ljz238
 * 
 */
public class RingBuffer {
	private int cap;
	private double[] buff;
	private int size;
	private int first;
	private int last;


	public RingBuffer(int capacity) {
		cap = capacity;
		buff = new double[cap];

	}

	public int size() {
		return size;
	}

	// returns true or false depending if the boolean is empty
	public boolean isEmpty() {
		return (size == 0);

	}

	// returns true or false depending if the boolean is full
	public boolean isFull() {

		return (cap == size);
	}

	// add item x to the end (as long as the buffer is not full)
	public void enqueue(double x) throws IllegalStateException{
		buff[last] = x;
		last++;

		if (cap == last ){ // used to wrap around
			last = 0;
		}
		size ++;
	}

	// deletes and returns the item from the front (as long as the
	// buffer is not empty)
	public double dequeue() throws NoSuchElementException {
		double tempNum = 0;
		tempNum=buff[first];
		first++;
		size--;
		if (cap == first) {
			first = 0;
		}

		return tempNum;
	}

	// returns the item from the front of the buffer if there is a value there
	// else it will throw a NoSuchElementException
	public double peek() throws NoSuchElementException{
		return buff[first];

	}

	// Returns a String of the form [front,next, next, last]
	public String toString() {
		int test = first;
		String returnString = "[";
		for (int i = 0; i < size; i++) {
			if (test >= cap) {
				test = 0;
			}
			returnString += buff[test];
			if (i != size - 1) {
				returnString += ", ";
			}
			test++;
		}
		returnString += "]";
		return returnString;
	}

}