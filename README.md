# TrackMoney

TrackMoney is a mobile application designed to help users track their financial transactions efficiently and organizedly. With an intuitive and user-friendly interface, users can add, view, and manage their transactions anytime, anywhere.

## Key Features

- **Transaction Management:** Allows users to add new transactions with custom labels, amounts, and descriptions.
- **Transaction Viewing:** Displays a list of all recorded transactions, providing a clear overview of expenses and income.
- **Financial Summary:** Provides a real-time financial summary showing the total balance, budget, and accumulated expenses.
- **Transaction Deletion and Restoration:** Allows users to delete transactions with a simple swipe and provides the option to undo the action with an "undo" feature.

## MainActivity Functionality

The MainActivity is the main screen of the application and performs the following functions:

- **Transaction Viewing:** Displays a list of transactions in a RecyclerView.
- **Transaction Interaction:** Allows the user to delete transactions by swiping right on the list.
- **Dashboard Update:** Dynamically updates the financial summary at the top of the screen.
- **Transaction Addition:** Allows the user to add new transactions by clicking on a floating "Add" button.

## Technologies Used

- **Android Jetpack:** The application makes use of Jetpack components such as Room for the database and RecyclerView to display the list of transactions.
- **Room Database:** Used for storing and retrieving transactions.
- **Coroutines:** Used for performing asynchronous operations on the main thread.
- **Material Design Components:** Used for a coherent and modern user interface design, including MaterialCardView and FloatingActionButton.
- **Intents:** Used for navigation between activities, e.g., adding a new transaction.
- **Snackbar:** Used for displaying user feedback messages, e.g., undoing transaction deletion.

## Designs

- **Main Activity Layout (activity_main.xml):** Contains a RecyclerView to display transactions, a financial summary at the top, and a floating button for adding new transactions.
- **Transaction List Item (transaction_layout.xml):** Defines the layout for each transaction list item, including the transaction name and amount.
- **Other Design Elements:** Various Material Design elements such as CardView are used to enhance the appearance and user experience.

## Best Practices

- **Separation of Concerns:** Presentation logic and data manipulation are clearly separated using the MVVM (Model-View-ViewModel) architecture.
- **Repository Pattern Usage:** The repository pattern is used to abstract the data source and provide a clean data access layer.
- **Coroutines Usage:** Coroutines are used to perform asynchronous operations safely and efficiently.
- **Error Handling:** Errors are handled appropriately, e.g., by using try-catch blocks in database operations.
- **UI Optimization:** ViewHolders and DiffUtil are used to optimize performance and update the transaction list efficiently.

### DashBoard                              
<img src="https://github.com/KiritoMoreno/TrackMoneyApp/blob/main/MainBoard.png" style="height: 20%; width:20%;"/> 

### ADD    
<img src="https://github.com/KiritoMoreno/TrackMoneyApp/blob/main/Add.png" style="height: 20%; width:20%;"/> 

### Update
<img src="https://github.com/KiritoMoreno/TrackMoneyApp/blob/main/Update.png" style="height: 20%; width:20%;"/> 
