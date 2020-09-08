import java.util.Random;
/**
 * CS312 Assignment 12.
 *
 * On MY honor, Luis Zamorano, this programming assignment is MY own work and I
 * have not provided this code to any other student.
 *
 * Student name: Luis Zamorano
 *  UTEID:ljz238
 */
public class GuitarString {

	private RingBuffer buff;
	private double value;
	private int num;
	private int ticTimes;
	

	// creates a RingBuffer of the desired capacity N (sampling rate 44,100
	// divided by frequency, rounded up to the nearest integer)
	// and initializes it to represent a guitar string at rest by enqueuing Num
	// zeros.
	public GuitarString(double frequency) {
		
		num = (int) ((44100 / frequency) + 0.5);
		buff = new RingBuffer(num);
		for (int i = 1; i <= num; i++) {
			buff.enqueue(0.0);
		}

	}

	// creates a RingBuffer of capacity equal to the size of the array,
	// and initializes the contents of the buffer to the values in the array.
	public GuitarString(double[] init) {
		 int ring = init.length;
		buff = new RingBuffer(ring);
		for (int i = 0; i < ring; i++) {
			double startVal = init[i];
			buff.enqueue(startVal);
		}

	}

	// Replace the N items in the ring buffer with N random values between -0.5
	// and +0.5.
	public void pluck() {
		
		for (int i = 0; i < num; i++) {
			buff.dequeue();
			double randomNum = (Math.random() - 0.5);
			buff.enqueue(randomNum);
		}
	}

	// delete the sample at the front of the ring buffer and add to the end of
	// the ring buffer the average of the first two samples,
	// multiplied by the energy decay factor.
	public void tic(){
			double temp=buff.dequeue();
			double secondNum=sample();
			double karplus=.994*((temp+secondNum)/2);// the karplus number
			buff.enqueue(karplus);
			ticTimes++;
		
	}

	// Returns the value of the item at the front of the ring buffer.
	public double sample() {
		value = buff.peek();
		return value;
		
	}

	//counts the number of times tic is played 
	public int time() {
		return ticTimes;

	}
}
