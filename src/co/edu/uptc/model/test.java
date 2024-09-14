package co.edu.uptc.model;

import co.edu.uptc.structures.Queue;
import co.edu.uptc.structures.Stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> resultQueue = new Queue<>();

		System.out.println("Seleccione el método de entrada:");
		System.out.println("1. Leer desde archivo");
		System.out.println("2. Ingresar manualmente");
		int choice = scanner.nextInt();
		scanner.nextLine();

		if (choice == 1) {

			String filePath = BinarySumApp.FILE_PATH;
			try {
				resultQueue = processFile(filePath);
			} catch (IOException e) {
				System.err.println("Error al leer el archivo: " + e.getMessage());
				return;
			}
		} else if (choice == 2) {
			System.out.println("Ingrese los números binarios separados por espacios:");
			String input = scanner.nextLine();
			String[] inputs = input.split(" ");
			resultQueue = processInput(inputs);
		} else {
			System.out.println("Opción no válida.");
			return;
		}

		System.out.println("Resultado final:");
		BinarySumApp.printQueueInReverse(resultQueue);
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
					resultQueue = BinarySumApp.sumBinaryStacks(resultQueue, binaryStack);
				}
				lineNumber++;
			}
		}
		return resultQueue;
	}

	private static Queue<Integer> processInput(String[] inputs) {
		Queue<Integer> resultQueue = new Queue<>();

		for (int i = 0; i < inputs.length; i++) {
			String binaryNumber = inputs[i];
			Stack<Integer> binaryStack = new Stack<>();

			for (char digit : binaryNumber.toCharArray()) {
				if (digit != '0' && digit != '1') {
					throw new NumberFormatException("La entrada contiene caracteres no binarios.");
				}
				binaryStack.push(Character.getNumericValue(digit));
			}

			if (i == 0) {
				while (!binaryStack.isEmpty()) {
					resultQueue.push(binaryStack.pop());
				}
			} else {
				resultQueue = BinarySumApp.sumBinaryStacks(resultQueue, binaryStack);
			}
		}

		return resultQueue;
	}
}