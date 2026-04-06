//DS_Project_Banking
//Banking Transaction Simulator :Queue + basic binary tree

//First we have to make basic bank code in java using Queue and basic binary tree --- Vannsh Shah
//Second we will convert the binary tree to hash --- Manisha

import java.util.*;

class Banking_App {
    
    // Using Queue for transaction processing (FIFO)
    private Queue<Transaction> transactionQueue;
    
    // Using basic binary search tree for accounts (sorted by account number)
    private BST accounts;
    
    // Using HaspMap to store
    private HashMap<String, Account> accountMap;

    // Constructor
    public Banking_App() {
        transactionQueue = new LinkedList<>();
        accounts = new BST();
        accountMap = new HashMap<>(); // Creating HashMap object
    }
    
    // Inner class for Account
    static class Account {
        String accountNumber;
        String name;
        double balance;
        
        public Account(String accountNumber, String name, double balance) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.balance = balance;
        }
        
        @Override
        public String toString() {
            return "Account{" +
                    "accountNumber='" + accountNumber + '\'' +
                    ", name='" + name + '\'' +
                    ", balance=" + balance +
                    '}';
        }
    }
    
    // Inner class for Transaction
    static class Transaction {
        String type; // "deposit", "withdraw", "transfer"
        String accountNumber;
        double amount;
        String toAccount; // for transfer
        
        public Transaction(String type, String accountNumber, double amount) {
            this.type = type;
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
        
        public Transaction(String type, String accountNumber, double amount, String toAccount) {
            this.type = type;
            this.accountNumber = accountNumber;
            this.amount = amount;
            this.toAccount = toAccount;
        }
        
        @Override
        public String toString() {
            return "Transaction{" +
                    "type='" + type + '\'' +
                    ", accountNumber='" + accountNumber + '\'' +
                    ", amount=" + amount +
                    ", toAccount='" + toAccount + '\'' +
                    '}';
        }
    }
    
    // Node for BST
    static class Node {
        Account account;
        Node left, right;
        
        public Node(Account account) {
            this.account = account;
            left = null;
            right = null;
        }
    }
    
    // Basic Binary Search Tree for accounts
    static class BST {
        Node root;
        
        public BST() {
            root = null;
        }
        
        // Insert account
        public void insert(Account account) {
            root = insertRec(root, account);
        }
        
        private Node insertRec(Node root, Account account) {
            if (root == null) {
                root = new Node(account);
                return root;
            }
            
            if (account.accountNumber.compareTo(root.account.accountNumber) < 0) {
                root.left = insertRec(root.left, account);
            } else if (account.accountNumber.compareTo(root.account.accountNumber) > 0) {
                root.right = insertRec(root.right, account);
            }
            // If equal, do nothing (assume unique account numbers)
            return root;
        }
        
        // Search account by account number
        public Account search(String accountNumber) {
            return searchRec(root, accountNumber);
        }
        
        private Account searchRec(Node root, String accountNumber) {
            if (root == null || root.account.accountNumber.equals(accountNumber)) {
                return root != null ? root.account : null;
            }
            
            if (accountNumber.compareTo(root.account.accountNumber) < 0) {
                return searchRec(root.left, accountNumber);
            } else {
                return searchRec(root.right, accountNumber);
            }
        }
        
        // Inorder traversal to get sorted accounts
        public void inorder(List<Account> list) {
            inorderRec(root, list);
        }
        
        private void inorderRec(Node root, List<Account> list) {
            if (root != null) {
                inorderRec(root.left, list);
                list.add(root.account);
                inorderRec(root.right, list);
            }
        }
    }
    
    // Create a new account
    public void createAccount(String accountNumber, String name, double initialBalance) {
        Account acc = new Account(accountNumber, name, initialBalance);
        accounts.insert(acc);
        accountMap.put(accountNumber, acc); // Storing every Account by HashMap for fast search
        System.out.println("Account created: " + acc);
    }
    
    // Deposit money (add to queue)
    public void deposit(String accountNumber, double amount) {
        if (amount > 0) {
            Transaction t = new Transaction("deposit", accountNumber, amount);
            transactionQueue.add(t);
            System.out.println("Deposit transaction queued: " + t);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    // Withdraw money (add to queue)
    public void withdraw(String accountNumber, double amount) {
        if (amount > 0) {
            Transaction t = new Transaction("withdraw", accountNumber, amount);
            transactionQueue.add(t);
            System.out.println("Withdraw transaction queued: " + t);
        } else {
            System.out.println("Invalid withdraw amount!");
        }
    }
    
    // Transfer money (add to queue)
    public void transfer(String fromAccount, String toAccount, double amount) {
        if (amount > 0 && !fromAccount.equals(toAccount)) {
            Transaction t = new Transaction("transfer", fromAccount, amount, toAccount);
            transactionQueue.add(t);
            System.out.println("Transfer transaction queued: " + t);
        } else {
            System.out.println("Invalid transfer!");
        }
    }
    
    // Process all transactions in the queue
    public void processTransactions() {
        System.out.println("Processing transactions...");
        while (!transactionQueue.isEmpty()) {
            Transaction t = transactionQueue.poll();
            System.out.println("Processing: " + t);
            
            if (t.type.equals("deposit")) {
                Account acc = accountMap.get(t.accountNumber); // New add
                if (acc != null) {
                    acc.balance += t.amount;
                    System.out.println("Deposited " + t.amount + " to " + t.accountNumber + ". New balance: " + acc.balance);
                } else {
                    System.out.println("Account not found: " + t.accountNumber);
                }
            } else if (t.type.equals("withdraw")) {
                Account  acc = accountMap.get(t.accountNumber); // New add 
                if (acc != null) {
                    if (acc.balance >= t.amount) {
                        acc.balance -= t.amount;
                        System.out.println("Withdrew " + t.amount + " from " + t.accountNumber + ". New balance: " + acc.balance);
                    } else {
                        System.out.println("Insufficient balance in " + t.accountNumber);
                    }
                } else {
                    System.out.println("Account not found: " + t.accountNumber);
                }
            } else if (t.type.equals("transfer")) {
                Account  from  = accountMap.get(t.accountNumber); // new add
                Account to = accountMap.get(t.toAccount); // new add 
                if (from != null && to != null) {
                    if (from.balance >= t.amount) {
                        from.balance -= t.amount;
                        to.balance += t.amount;
                        System.out.println("Transferred " + t.amount + " from " + t.accountNumber + " to " + t.toAccount);
                        System.out.println("New balance " + t.accountNumber + ": " + from.balance);
                        System.out.println("New balance " + t.toAccount + ": " + to.balance);
                    } else {
                        System.out.println("Insufficient balance in " + t.accountNumber);
                    }
                } else {
                    System.out.println("One or both accounts not found!");
                }
            }
        }
        System.out.println("All transactions processed.");
    }
    
    // Get account details
    public Account getAccount(String accountNumber) {
    return accountMap.get(accountNumber); // UPDATED for Fast(HashMap)
}
    
    // Get all accounts sorted by account number (inorder traversal of BST)
    public void displaySortedAccounts() {
        List<Account> sortedList = new ArrayList<>();
        accounts.inorder(sortedList);
        System.out.println("Accounts sorted by account number:");
        for (Account acc : sortedList) {
            System.out.println(acc);
        }
    }
}

