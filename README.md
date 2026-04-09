# DS_Project_Banking
Banking Transaction Simulator :Queue + hash + tree
Team Member's Name:
1. Vannsh Shah       1012411166
2. Manish Choudhary  1012411157
3. Manisha Choudhary 1012411188
4. Ayush Pawar       1012411182

Group Name: DS_Project_Banking
Group number: 
First we have to make basic bank code in java using Queue and tree --- Vannsh Shah

Second we will convert the binary tree to hash --- Manisha

Third we will start basic transcations in the code --- Manish

At Last we will wrap up the code and beautify it and make it neat as well as bugless code --- Ayush

Everyone start their respectective work as the deadline is closing close everyday.

Manish:My work is done, Ayush you can start your work

Ayush : Adding menu-driven user interface and improved output formatting
```markdown
The system simulates real-world banking tasks such as:
- Managing customer accounts  
- Processing transactions in order  
- Fast data retrieval  
- Structured storage of account information  

To achieve this, the project utilizes Queue, Hash Table, and Tree data structures.

---

## Features Implemented

### Account Management
- Create new bank accounts  
- Store customer details  
- Unique account identification  

### Transaction Processing (Queue)
- Deposit and withdrawal requests are handled using a queue  
- Ensures FIFO (First In First Out) processing  
- Simulates real banking transaction flow  

### Fast Lookup (Hash Table)
- Accounts stored using hashing  
- Enables constant time average lookup  
- Quick retrieval of account details  

### Data Organization (Tree)
- Accounts stored in a Binary Search Tree (BST)  
- Enables sorted traversal of accounts  
- Efficient searching and structured storage  

---

## Data Structures Used

| Data Structure       | Purpose                              |
|---------------------|--------------------------------------|
| Queue               | Handles transaction order (FIFO)     |
| Hash Table          | Fast account search                  |
| Binary Search Tree  | Sorted storage of accounts           |

---

## System Workflow

1. User creates an account  
2. Account is stored in:
   - Hash Table for quick access  
   - Binary Search Tree for structured storage  
3. Transactions (deposit/withdraw) are added to the queue  
4. Queue processes transactions one by one  
5. Account balance is updated accordingly  

---

## Expected Output

- Account creation confirmation  
- Correct transaction processing order  
- Accurate balance updates  
- Fast account retrieval  
- Sorted display of accounts using tree traversal  

---

## Actual Output

- System performs account creation successfully  
- Transactions are processed using queue logic  
- Account balances are updated based on operations  
- Account lookup is functional using hashing  
- Tree traversal displays structured account data  

Limitations:
- Limited input validation  
- Console-based interface  
- Possible edge case handling issues  

---

## Tech Stack

- Programming Language: C++  
- Concepts: Data Structures and Algorithms  
- Focus: Queue, Hashing, Binary Search Tree  

---

## Project Structure

DS_Project_Banking/
│── main.cpp  
│── account.cpp  
│── transaction.cpp  
│── hash.cpp  
│── bst.cpp  
│── README.md  

---

## How to Run

1. Clone the repository  
   git clone https://github.com/shahvannsh/DS_Project_Banking.git  

2. Navigate to the project directory  
   cd DS_Project_Banking  

3. Compile the program  
   g++ main.cpp -o banking  

4. Run the executable  
   ./banking  

---

## Sample Operations

- Create Account  
- Deposit Money  
- Withdraw Money  
- View Balance  
- Display All Accounts  

---

## Future Enhancements

- Graphical User Interface  
- Database integration  
- Authentication system  
- Improved validation and error handling  
- Transaction logging  
```


