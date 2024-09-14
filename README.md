# BinaryAd

## Data Structures Used

- **Stack**: Each binary number is stored digit by digit in a stack, allowing the digits to be extracted in reverse order to perform the sum.
- **Queue**: The partial results of the sum are stored digit by digit in a queue, which ultimately holds the final result in reverse order.

The Stack and Queue structures are located in the `structures` package in this repository.

## Features

- **Binary Numbers Input from File**: Binary numbers can be read from a text file.
- **Manual Binary Numbers Input**: Binary numbers can also be entered manually by the user.
- **Binary Sum**: The application sums two binary numbers stored in stacks and saves the result in a queue. This process repeats until all the numbers have been summed.
- **Final Result**: The sum result is displayed by reversing the contents of the final queue.

## Project Structure

- **`BinarySumApp`**: Main class responsible for reading binary numbers from a file, performing the sum, and printing the final result.
- **`test`**: Class that provides an interface for the user to choose between manual input or reading binary numbers from a file.
- **`Stack` and `Queue`**: Generic classes used for managing the stacks and queues necessary for the project, located in the `structures` package.

## How to Run

1. Clone this repository.
2. Ensure the `Stack` and `Queue` classes are properly defined and compiled.
3. Set the file path for the binary numbers file in `BinarySumApp.FILE_PATH`.
4. Run the application from the `test` class and choose the input method:
   - Option 1: Read from file.
   - Option 2: Enter manually.

### File Input Execution:
Make sure the file contains only binary numbers, one number per line.

### Manual Input Execution:
Enter the binary numbers in a single line, separated by spaces.

## Requirements

- Java 21 or higher.
- The project does not use predefined data structures like `ArrayList` or linked lists.

## Author

- **Andres Felipe Melo**
