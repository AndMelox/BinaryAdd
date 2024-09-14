package co.edu.uptc.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import co.edu.uptc.structures.Queue;
import co.edu.uptc.structures.Stack;

public class BinarySumApp {

	public static final String FILE_PATH = "C:\\Users\\Usuario\\eclipse-workspace\\202126930\\src\\Numeros.txt";

	public static void main(String[] args) {
		Queue<Integer> resultQueue = new Queue<>();

		showFileContent(FILE_PATH);

		try {
			resultQueue = processFile(FILE_PATH);
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println("Error en el formato del número binario: " + e.getMessage());
		}

		System.out.println("Resultado final:");
		printQueueInReverse(resultQueue);
	}

	private static void showFileContent(String filePath) {
		System.out.println("Contenido del archivo:");
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		}
	}

	private static Queue<Integer> processFile(String filePath) throws IOException {
		Queue<Integer> resultQueue = new Queue<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			int lineNumber = 0;

			while ((line = br.readLine()) != null) {
				Stack<Integer> binaryStack = new Stack<>();

				for (char digit : line.toCharArray()) {
					if (digit != '0' && digit != '1') {
						throw new NumberFormatException("El archivo contiene caracteres no binarios.");
					}
					binaryStack.push(Character.getNumericValue(digit));
				}

				if (lineNumber == 0) {
					while (!binaryStack.isEmpty()) {
						resultQueue.push(binaryStack.pop());
					}
				} else {
					resultQueue = sumBinaryStacks(resultQueue, binaryStack);
				}
				lineNumber++;
			}
		}
		return resultQueue;
	}

	public static Queue<Integer> sumBinaryStacks(Queue<Integer> queue, Stack<Integer> stack) {
		Queue<Integer> resultQueue = new Queue<>();
		int carry = 0;

		while (!queue.isEmpity() || !stack.isEmpty() || carry != 0) {
			int sum = carry;
			if (!queue.isEmpity()) {
				sum += queue.poll();
			}
			if (!stack.isEmpty()) {
				sum += stack.pop();
			}
			resultQueue.push(sum % 2);
			carry = sum / 2;
		}

		return resultQueue;
	}

	public static void printQueueInReverse(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpity()) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}
}